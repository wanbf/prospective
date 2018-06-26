package com.angel.practice;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wanbf on 2017/12/11.
 */
public class ClassPoolTest {
    File file = new File("c:/ThreadInfo.class");

    @Test
    public void test() throws IOException {
        if (file.exists())
            file.delete();
        file.createNewFile();
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("com.wanbf.ThreadInfo");
        ctClass.stopPruning(true);
        try {
            //添加属性
            ctClass.addField(CtField.make("private int age;", ctClass));
            //添加setAge方法
            ctClass.addMethod(CtMethod.make("public void setAge(int age){this.age = age;}", ctClass));
            ctClass.addMethod(CtMethod.make("public int getAge(){return this.age;}", ctClass));

            byte[] byteArray = ctClass.toBytecode();
            FileOutputStream output = new FileOutputStream(file);
            output.write(byteArray);
            output.close();
            System.out.println("文件写入成功!!!");

            if (ctClass.isFrozen()) {
                ctClass.defrost();
            }
            ctClass = pool.get("com.wanbf.ThreadInfo");
            ctClass.addField(CtField.make("private String sex;", ctClass));
            ctClass.addField(CtField.make("private String name;", ctClass));

            byteArray = ctClass.toBytecode();
            output = new FileOutputStream(file);
            output.write(byteArray);
            output.close();

            System.out.println("文件修改成功!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
