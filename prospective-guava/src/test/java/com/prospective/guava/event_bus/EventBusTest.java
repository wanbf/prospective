package com.prospective.guava.event_bus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import junit.framework.TestCase;

import java.util.concurrent.Executors;

public class EventBusTest extends TestCase {
    public void test1() {
        EventBus eventBus = new EventBus();

        eventBus.register(new Event());

        eventBus.post("注册时间处理");
    }

    public void testAysncEventBus() {

        AsyncEventBus eventBus = new
                AsyncEventBus(Executors.newFixedThreadPool(3));

        eventBus.register(new Event());

        eventBus.post("注册时间处理2");

    }


    public void testDeadEven() {

        EventBus eventBus = new EventBus();

        eventBus.register(new Event());

        eventBus.post(520);

    }

    class Event {
        @Subscribe
        public void sub(String message) {
            System.out.println(message);

        }
        @Subscribe
        public void sub1(Integer message) {
            System.out.println(message);

        }
    }

}
