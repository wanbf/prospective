package com.angel.prospective.util.jackson.mode;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Jackson Tree Model解析生成示例
 */
public class JacksonTreeModelTest {

    private ObjectMapper objectMapper;

    @Before
    public void init() {
        objectMapper = new ObjectMapper();
        // 如果为空则不输出
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        // 对于空的对象转json的时候不抛出错误
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 禁用序列化日期为timestamps
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // 禁用遇到未知属性抛出异常
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 视空字符传为null
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        // 低层级配置
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        // 允许属性名称没有引号
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 允许单引号
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 取消对非ASCII字符的转码
        objectMapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, false);

    }

   // @Test
    public void testTreeModel() throws Exception {
        JsonNodeFactory nodeFactory = objectMapper.getNodeFactory();
        // 创建一个model
        ObjectNode node = nodeFactory.objectNode();
        node.put("age", 18);
        // 新增
        node.put("name", "周杰伦");
        // 如果存在同名的则是替换操作
        node.put("age", 19);
        ArrayNode coursesNode = node.putArray("courses");
        coursesNode.add("思想政治");
        coursesNode.add("高等数学");
        // 获取节点类型
        System.out.println(node.getNodeType());
        System.out.println(coursesNode.getNodeType());
        // 移除第一个
        coursesNode.remove(0);
        // 输出
        System.out.println(node.toString());
        String jsonStr = "{\"age\":19,\"name\":\"周杰伦\",\"courses\":[\"高等数学\"]}";
        JsonNode jsonNode = objectMapper.readTree(jsonStr);
        ArrayNode arrayNode = (ArrayNode) jsonNode.withArray("courses");
        arrayNode.add("马列");
        for (int i = 0;i < arrayNode.size();i++){
            System.out.println(arrayNode.get(i).asText());
        }
        System.out.println(jsonNode.toString());

    }
}