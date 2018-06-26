package com.prospective.guava.hash;

import com.google.common.base.Charsets;
import com.google.common.hash.*;
import junit.framework.TestCase;

public class HashTest extends TestCase {
    public void test1() {
        HashFunction function_0 = Hashing.md5();
        HashFunction function_1 = Hashing.murmur3_128();
        Hasher hash1 = function_0.newHasher();
        Hasher hash2 = function_1.newHasher();
        Person person = new Person();
        person.setAge(27);
        person.setName("hahahah");
        person.setAddress("北京三里屯");
        person.setPhoneNumber(16666666666L);
        person.setMale(Male.man);

        HashCode code_0 = hash1.putInt(person.getAge())
                .putString(person.getName(), Charsets.UTF_8)
                .putString(person.getAddress(), Charsets.UTF_8)
                .putLong(person.getPhoneNumber())
                .putObject(person.getMale(), (Funnel<Male>) (from, into) ->
                        into.putString(from.name(), Charsets.UTF_8)).hash();
        HashCode code_1 = hash2.putInt(person.getAge())
                .putString(person.getName(), Charsets.UTF_8)
                .putString(person.getAddress(), Charsets.UTF_8)
                .putLong(person.getPhoneNumber())
                .putObject(person.getMale(), (Funnel<Male>) (from, into) ->
                        into.putString(from.name(), Charsets.UTF_8)).hash();
        System.out.println(code_0.asLong());//5060351607726203293L
        System.out.println(code_1.asLong());//85963185347800355L
    }


    public enum Male {
        man
    }

    public static class Person {
        int age;
        String name;
        String address;
        long phoneNumber;
        Male male;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public long getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Male getMale() {
            return male;
        }

        public void setMale(Male male) {
            this.male = male;
        }
    }

}
