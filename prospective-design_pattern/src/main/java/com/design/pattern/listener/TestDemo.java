package com.design.pattern.listener;


import java.util.Enumeration;
import java.util.Vector;

 class DemoSource {
    private Vector repository = new Vector();//监听自己的监听器队列
    public DemoSource(){}
    public void addDemoListener(DemoListener dl) {
        repository.addElement(dl);
    }
    public void notifyDemoEvent() {//通知所有的监听器
        Enumeration enums = repository.elements();
        while(enums.hasMoreElements()) {
            DemoListener dl = (DemoListener)enums.nextElement();
            dl.handleEvent(new DemoEvent(this));
        }
    }
}


 class DemoEvent extends java.util.EventObject {
    public DemoEvent(Object source) {
        super(source);//source—事件源对象—如在界面上发生的点击按钮事件中的按钮
        //所有 Event 在构造时都引用了对象 "source"，在逻辑上认为该对象是最初发生有关 Event 的对象
    }
    public void say() {
        System.out.println("This is say method...");
    }
}

 interface DemoListener extends java.util.EventListener {
    //EventListener是所有事件侦听器接口必须扩展的标记接口、因为它是无内容的标记接口、
    //所以事件处理方法由我们自己声明如下：
     void handleEvent(DemoEvent dm);
}

class DemoListener1 implements DemoListener {
    public void handleEvent(DemoEvent de) {
        System.out.println("Inside listener1...");
        de.say();//回调
    }
}
public class TestDemo {
    DemoSource ds;
    public TestDemo(){
        try{
            ds = new DemoSource();
            //将监听器在事件源对象中登记：
            DemoListener1 listener1 = new DemoListener1();
            ds.addDemoListener(listener1);
            ds.addDemoListener(event -> System.out.println("Method come from 匿名类..."));
            ds.notifyDemoEvent();//触发事件、通知监听器
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new TestDemo();
    }
}