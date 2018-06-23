package com.prospective.practice.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by wanbf on 2018/1/24.
 */
public class HelloClient {
    public static void main(String[] args) {
        try {
            Hello h = (Hello) Naming.lookup("rmi://10.32.21.6:12312/Hello");
            System.out.println(h.sayHello("ZhangSan"));
        } catch (MalformedURLException ex) {
            System.out.println("url格式异常");
        }catch (RemoteException e) {
            System.out.println("创建对象异常");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.out.println("对象未绑定");
        }
    }
}
