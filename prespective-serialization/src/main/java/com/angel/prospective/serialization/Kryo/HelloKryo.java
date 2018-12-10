package com.angel.prospective.serialization.Kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class HelloKryo {
    public static void main(String[] args) throws FileNotFoundException {
        Kryo kryo = new Kryo();
        SomeClass obj = new SomeClass();
        kryo.register(SomeClass.class);
        obj.value = "hello kryo";
        Output output = new Output(new FileOutputStream("file.bin"));
        kryo.writeObject(output, obj);
        output.close();

        Input input = new Input(new FileInputStream("file.bin"));
        SomeClass obj2 = kryo.readObject(input, SomeClass.class);
        System.out.println(obj2.value);

    }

    static public class SomeClass {
        String value;
    }
}
