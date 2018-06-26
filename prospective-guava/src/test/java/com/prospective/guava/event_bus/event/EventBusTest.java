package com.prospective.guava.event_bus.event;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import org.junit.Test;

import java.util.List;

public class EventBusTest {
    //测试重复注册监听器
    @Test
    public void testRepeatRegister() {
        final EventBus bus = new EventBus() ;
        bus.register(new TestEventListener());
        bus.register(new TestEventListener());
        TestEvent event = new TestEvent(SystemEvent.TEST_EVENT, "123") ;
        bus.post(event);
    }

    //测试并发操作
    //@Test
    public void testConcurrcy() {
        List<String> list = Lists.newArrayList("001#01") ;
        MemberDeletedEvent event = new MemberDeletedEvent(SystemEvent.MEMBER_DELETE_EVENT, "123", list , 1) ;
        for(int i=0 ; i < 100 ; i++) {
            final int cnt = i ;
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第"+ cnt+ "次");
                EventBusFactory.build().register(MemberDeletedEventListener.class) ;
            }) ;
            t.start();
        }
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EventBusFactory.build().postsEvent(event);
    }

    //测试继承结构下的事件分发
    @Test
    public void testInherit() {
        TestEvent event = new TestEvent(SystemEvent.TEST_EVENT, "123") ;
        EventBusFactory.build().register(TestEventListener.class) ;
        EventBusFactory.build().postsEvent(event);
    }
}
