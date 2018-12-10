package com.design.pattern.observer;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

interface Subject {
    void happen();

    void addObserver(ObServer obServer);
}

interface ObServer {
    void update();
}

class ConcreteSubject implements Subject {

    List<ObServer> obServers = new CopyOnWriteArrayList<>();

    @Override
    public void happen() {
        for (ObServer obServer : obServers) {
            obServer.update();
        }
    }

    @Override
    public void addObserver(ObServer obServer) {
        obServers.add(obServer);
    }
}

class ConcreteObserver implements ObServer {
    private int tag;

    public ConcreteObserver(int tag) {
        this.tag = tag;
    }

    @Override
    public void update() {
        System.out.println("第" + tag + "个观察者观察到事件变化！！！");
    }
}

public class Client {
    public static void main(String[] args) {
        ObServer obServer1 = new ConcreteObserver(1);
        ObServer obServer2 = new ConcreteObserver(2);
        Subject subject = new ConcreteSubject();
        subject.addObserver(obServer1);
        subject.addObserver(obServer2);
        subject.happen();
    }
}
