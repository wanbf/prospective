package com.angel.prospective.serialization.jackson.protobuf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.protobuf.ProtobufMapper;
import com.fasterxml.jackson.dataformat.protobuf.schema.ProtobufSchema;
import com.fasterxml.jackson.dataformat.protobuf.schema.ProtobufSchemaLoader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String protobuf_str = "message Employee {\n"
                + " required string name = 1;\n"
                + " required int32 age = 2;\n"
                + " repeated string emails = 3;\n"
                + " optional Employee boss = 4;\n"
                + "}\n";
        ProtobufSchema schema = ProtobufSchemaLoader.std.parse(protobuf_str);
        ObjectMapper mapper = new ProtobufMapper();
        byte[] protobufData = protobuf_str.getBytes();
        Employee empl = mapper.readerFor(Employee.class)
                .with(schema)
                .readValue(protobufData);
        System.out.println(empl.age);
    }
}
