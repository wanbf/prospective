package com.angel.prospective.serialization.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserSimple {
    String name;
    String email;
    boolean isDeveloper;
    int age;

    public UserSimple(String name, String email, boolean isDeveloper, int age) {
        this.name = name;
        this.email = email;
        this.isDeveloper = isDeveloper;
        this.age = age;
    }

    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls(); //重点
        Gson gson = gsonBuilder.create();
        UserSimple user = new UserSimple("Norman", null, true, 26);
        String usersJson = gson.toJson(user);
        System.out.println(usersJson);
        UserSimple s = gson.fromJson("{\"name\":\"Norman\",\"email\":null,\"isDeveloper\":true,\"age\":26}",
                UserSimple.class);
        System.out.println(s.toString());
    }

    @Override
    public String toString() {
        return "{name：" + name + ", email: " + email
                + ", isDevelopment: " + isDeveloper + ", age: " + age + "}";
    }
}