package com.prospective.practice;


import java.io.*;

/**
 * Created by wanbf on 2018/4/2.
 */
public class ExternalizableTest implements Externalizable {

    private transient String content = "是的，我将会被序列化，不管我是否被transient关键字修饰";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal");
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        System.out.println("readExternal");
        content = (String) in.readObject();
    }

    public static void main(String[] args) throws Exception {


/*        ExternalizableTest et = new ExternalizableTest();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                new File("test")));
        out.writeObject(et);

        ObjectInput in = new ObjectInputStream(new FileInputStream(new File(
                "test")));
        et = (ExternalizableTest) in.readObject();
        System.out.println(et.content);

        out.close();
        in.close();*/




/*        SerializeTest et = SerializeTest.instance;
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                new File("test")));
        System.out.println(et.toString());
        out.writeObject(et);

        ObjectInput in = new ObjectInputStream(new FileInputStream(new File(
                "test")));
        SerializeTest et1 = (SerializeTest) in.readObject();
        System.out.println(et1.toString());
        System.out.println(et.equals(et1));

        out.close();
        in.close();*/




/*        Person robin = new Person("robin", 29);

        String savePath = "D:\\object.txt";

        ExternalizableTest test = new ExternalizableTest();

        try {
            test.serialize(robin, savePath);
            Person person = (Person) test.deSerialize(savePath);


            System.out.println("Name:" + person.getName()
                    + " Age:" + person.getAge());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    public void serialize(Object obj, String path) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(obj);
        } finally {
            if (null != oos)
                oos.close();
        }
    }

    /**
     * 反序列化取出对象
     *
     * @param path 被序列化对象保存的位置
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object deSerialize(String path) throws IOException,
            ClassNotFoundException {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            return ois.readObject();
        } finally {
            if (null != ois)
                ois.close();
        }
    }

}

class SerializeTest implements Serializable {
    private static final long serialVersionUID = 123456789L;
    public static SerializeTest instance = new SerializeTest();

    private SerializeTest() {

    }

    private Object readResolve() {
        System.out.println("read resolve");
        return instance;
    }

}

class Person implements Serializable {

    private static final long serialVersionUID = -6412852654889352693L;

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(name);
        out.writeInt(age + 1);

        System.out.println("my write");
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.name = "zhangsan";
        this.age = 30;
        System.out.println("my read");
    }

    private Object readResolve() {
        System.out.println("read resolve");
        return this;
    }

}

