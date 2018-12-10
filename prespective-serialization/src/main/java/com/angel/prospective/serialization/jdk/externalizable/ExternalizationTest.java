package com.angel.prospective.serialization.jdk.externalizable;

import java.io.*;

public class ExternalizationTest {
    private static final String FILE_NAME = "D://1.txt";

    public static void main(String[] args) throws IOException {
        Person person = new Person();
        Person newPerson = null;
        person.setId(100);
        person.setGender("男");
        person.setName("張三");
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        File file = new File(FILE_NAME);
        File file1 = new File(FILE_NAME);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(person);
        } finally {
            objectOutputStream.close();
        }
        try {
            InputStream inputStream = new FileInputStream(file1);
            objectInputStream = new ObjectInputStream(inputStream);
            newPerson = (Person) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            objectInputStream.close();
        }
        System.out.println("person:" + person.toString());
        System.out.println("newPerson" + newPerson.toString());

    }
}

