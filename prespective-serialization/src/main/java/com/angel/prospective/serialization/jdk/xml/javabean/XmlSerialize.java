package com.angel.prospective.serialization.jdk.xml.javabean;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Vector;

@SuppressWarnings("all")
public class XmlSerialize {
    public XmlSerialize() {
    }

    public void serializeSingleObject(OutputStream os, Object obj)       // 序列化单个java对象
    {
        // XMLEncoder xe = new XMLEncoder(os);
        XMLEncoder xe = new XMLEncoder(os, "UTF-8", true, 0);     // 仅用于Java SE 7
        xe.writeObject(obj);    // 序列化成XML字符串
        xe.close();
    }

    public Object deserializeSingleObject(InputStream is)       // 反序列化单个Java对象
    {
        XMLDecoder xd = new XMLDecoder(is);
        Object obj = xd.readObject();       // 从XML序列中解码为Java对象
        xd.close();
        return obj;
    }

    public void serializeMultipleObject(OutputStream os, List<Object> objs)       // 序列化多个Java对象
    {
        XMLEncoder xe = new XMLEncoder(os);
        xe.writeObject(objs);    // 序列化成XML字符串
        xe.close();
    }

    public List<Object> deserializeMultipleObject(InputStream is)        // 反序列化多个Java对象
    {
        XMLDecoder xd = new XMLDecoder(is);
        List<Object> objs = (List<Object>) xd.readObject();       // 从XML序列中解码为Java对象列表
        xd.close();
        return objs;
    }

    public void runSingleObject() {
        File xmlFile = new File("object.xml");

        SerializableObject jo4Out = new SerializableObject(1, "Java序列化为XML", 3.14159265359);     // 创建待序列化的对象
        try {
            FileOutputStream ofs = new FileOutputStream(xmlFile);       // 创建文件输出流对象
            serializeSingleObject(ofs, jo4Out);
            ofs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream ifs = new FileInputStream(xmlFile);
            SerializableObject jo4In = (SerializableObject) deserializeSingleObject(ifs);
            System.out.println("id: " + jo4In.getId());
            System.out.println("name: " + jo4In.getName());
            System.out.println("value: " + jo4In.getValue());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void runMultipleObject() {
        File xmlFile = new File("objects.xml");

        List<SerializableObject> sos4Out = new Vector<SerializableObject>();
        sos4Out.add(new SerializableObject(1, "Java序列化为XML - 1", 3.14));     // 创建待序列化的对象
        sos4Out.add(new SerializableObject(2, "Java序列化为XML - 2", 3.14159));     // 创建待序列化的对象
        sos4Out.add(new SerializableObject(3, "Java序列化为XML - 3", 3.1415926));     // 创建待序列化的对象
        sos4Out.add(new SerializableObject(4, "Java序列化为XML - 4", 3.141592653));     // 创建待序列化的对象
        sos4Out.add(new SerializableObject(5, "Java序列化为XML - 5", 3.14159265359));     // 创建待序列化的对象

        try {
            FileOutputStream ofs = new FileOutputStream(xmlFile);       // 创建文件输出流对象
            serializeSingleObject(ofs, sos4Out);
            ofs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream ifs = new FileInputStream(xmlFile);
            List<SerializableObject> sos4In = (List<SerializableObject>) deserializeSingleObject(ifs);
            for (SerializableObject jo4In : sos4In) {
                System.out.println("id: " + jo4In.getId());
                System.out.println("name: " + jo4In.getName());
                System.out.println("value: " + jo4In.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XmlSerialize xs = new XmlSerialize();
        xs.runSingleObject();
        xs.runMultipleObject();
    }

}
