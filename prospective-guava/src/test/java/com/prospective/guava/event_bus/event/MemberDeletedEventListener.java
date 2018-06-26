package com.prospective.guava.event_bus.event;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

public class MemberDeletedEventListener implements EventListener{

    @Override
    @Subscribe
    @AllowConcurrentEvents
    public void action(SystemEvent event) {
        System.out.println(String.format("[MemberDeletedEventListener ] action event=%s", event.toString()));
        MemberDeletedEvent subEvent = (MemberDeletedEvent) event ;
        invoke(subEvent) ;
    }

    public void invoke(MemberDeletedEvent memberDeletedEvent) {
        System.out.println(memberDeletedEvent.toString());
    }

}