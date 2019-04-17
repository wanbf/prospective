package com.prospective.custorm;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author wanbf
 * @date 2019/4/12 19:50
 */
public class MyTypeFilter implements TypeFilter {
    /**
     * @param metadataReader        读取正在扫描类的信息
     * @param metadataReaderFactory 可以读取其他正在扫描类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前的资源信息（类路径）
        Resource resource = metadataReader.getResource();
        System.out.println(classMetadata.getClassName());
        return true;
    }
}
