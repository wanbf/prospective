package com.prospective.custorm;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author wanbf
 * @date 2019/4/12 21:25
 */
public class LinuxCondition implements Condition {
    /**
     * @param context  判断条件可以使用的上下文 环境
     * @param metadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if (context.getEnvironment().getProperty("os.name").contains("Linux"))
            return true;
        return false;
    }
}
