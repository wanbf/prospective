package com.angel.prospective.serialization.jdk.xml.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class Main {

    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        Person person = new Person();
        person.setId(1);
        person.setName("张三");
        person.setAge(30);
        Address address = new Address();
        address.setId(1);
        address.setProvince("广东省");
        address.setCity("深圳市");
        address.setArea("南山区");
        address.setOther("其它");
        person.setAddress(address);
        marshaller.marshal(person, writer);
        System.out.println(writer.toString());
    }
}
