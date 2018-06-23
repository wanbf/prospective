package com.angel.practice.enumtest;

import java.util.Arrays;

/**
 * Created by wanbf on 2017/12/22.
 */
public class Main {
    public static void main(String[] args) {

        EnumBuster<User> buster =
                new EnumBuster<User>(User.class);
        User ANGRY = buster.make("ANGRY");
        ANGRY.setAge(15);
        buster.addByValue(ANGRY);

        System.out.println(Arrays.toString(User.values()));
        System.out.println(ANGRY.getAge());
    }
}
