package com.design.pattern.observer;

import java.util.Observable;
import java.util.Observer;

class Watcher implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update() called, count is "
                + ((Integer) arg).intValue());
        }
        }

class BeingWatched extends Observable {
    void counter(int period) {
        for (; period >= 0; period--) {
            setChanged();
            notifyObservers(new Integer(period));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupeted");
            }
        }
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        BeingWatched beingWatched = new BeingWatched();//受查者
        Watcher watcher = new Watcher();//观察者
        beingWatched.addObserver(watcher);
        beingWatched.counter(10);
    }
}
