package com.angel.prospective.serialization.fastjson;

import com.alibaba.fastjson.serializer.*;

public class MyJSON {
    public static String toJSONString(Object object, SerializeConfig config, SerializeFilter[] filters,
                                      SerializerFeature[] features) {
        SerializeWriter out = new SerializeWriter();

        try {
            // SerializeConfig可以理解为一个Map<Type,ObjectSerializer>,
            // 内部保存着类型与对应的对象序列化器之间的映射关系
            if (config == null)
                config = SerializeConfig.getGlobalInstance();
            // 核心序列化器，主要负责调用SerializeConfig根据value选择合适的对象序列化器
            // 内部还保存着输出流对象，以及各种过滤器
            JSONSerializer serializer = new JSONSerializer(out, config);
            // 所有特性最终会合成为一个int值，保存在输出流对象中
            if (features != null)
                for (SerializerFeature feature : features) {
                    serializer.config(feature, true);
                }
            // 如上面所说，过滤器保存在核心序列化器中
            if (filters != null && filters.length > 0)
                setFilter(serializer, filters);
            // 序列化过程的入口方法
            serializer.write(object);

            return out.toString();
        } finally {
            out.close();
        }
    }

    private static void setFilter(JSONSerializer serializer, SerializeFilter... filters) {
        for (SerializeFilter filter : filters) {
            setFilter(serializer, filter);
        }
    }

    private static void setFilter(JSONSerializer serializer, SerializeFilter filter) {
        if (filter == null) {
            return;
        }

        if (filter instanceof PropertyPreFilter) {
            serializer.getPropertyPreFilters().add((PropertyPreFilter) filter);
        }

        if (filter instanceof NameFilter) {
            serializer.getNameFilters().add((NameFilter) filter);
        }

        if (filter instanceof ValueFilter) {
            serializer.getValueFilters().add((ValueFilter) filter);
        }

        if (filter instanceof PropertyFilter) {
            serializer.getPropertyFilters().add((PropertyFilter) filter);
        }

        if (filter instanceof BeforeFilter) {
            serializer.getBeforeFilters().add((BeforeFilter) filter);
        }

        if (filter instanceof AfterFilter) {
            serializer.getAfterFilters().add((AfterFilter) filter);
        }

        if (filter instanceof LabelFilter) {
            serializer.getLabelFilters().add((LabelFilter) filter);
        }
    }
}
