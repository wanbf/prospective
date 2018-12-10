package com.angel.prospective.serialization.jackson.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class Main {
    static XmlMapper xmlMapper = new XmlMapper();

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.serialize();
        m.deserialize();
    }

    void serialize() throws JsonProcessingException {
        Student st = new Student();
        System.out.println("serialize: " + xmlMapper.writeValueAsString(st));
    }

    void deserialize() throws IOException {
        String str = "<Student><name>zhangsan</name><age>14</age><sex>男</sex></Student>";
        Student s = xmlMapper.readValue(str, Student.class);
        System.out.println("deserialize: " + s.getName());
    }



}
