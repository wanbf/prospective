package com.angel.prospective.serialization.jackson.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Main {
    static ObjectMapper objectMapper = new ObjectMapper();

    void serializeDemo() throws JsonProcessingException {
        Student student = new Student();
        System.out.println(objectMapper.writeValueAsString(student));
    }

    void deserializeDemo() throws IOException {
        String json = "{\"age\":7,\"grade\":1,\"name\":\"XiaoMing\",\"book\":" +
                "{\"name\":\"Physics\"}}";
        Student student = objectMapper.readValue(json, Student.class);
        System.out.println(student.getName());
    }

    public static void main(String[] args) throws IOException {
        Main a = new Main();
        System.out.println("serializeDemo:");
        a.serializeDemo();
        System.out.println("\ndeserializeDemo:");
        a.deserializeDemo();
    }

}
