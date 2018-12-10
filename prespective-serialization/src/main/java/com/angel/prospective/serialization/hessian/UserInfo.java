package com.angel.prospective.serialization.hessian;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 使用hessian序列化时，一定要注意子类和父类不能有同名字段
 */
public class UserInfo extends User {
    private String username;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    public static void main(String[] args) throws IOException {
        UserInfo user = new UserInfo();
        user.setUsername("hello world");
        user.setPassword("buzhidao");
        user.setAge(21);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //Hessian的序列化输出
        HessianOutput ho = new HessianOutput(os);
        ho.writeObject(user);

        byte[] userByte = os.toByteArray();
        ByteArrayInputStream is = new ByteArrayInputStream(userByte);


        //Hessian的反序列化读取对象
        HessianInput hi = new HessianInput(is);
        UserInfo u = (UserInfo) hi.readObject();
        System.out.println("姓名：" + u.getUsername());
        System.out.println("年龄：" + u.getAge());
    }
}