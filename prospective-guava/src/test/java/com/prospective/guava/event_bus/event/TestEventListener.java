package com.prospective.guava.event_bus.event;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

public class TestEventListener implements EventListener {
    @Override
    @Subscribe
    @AllowConcurrentEvents
    public void action(SystemEvent event) {
        System.out.println(String.format("[TestEventListener ] action, listener=%s event=%s", this.toString(), event.toString()));
        TestEvent subEvent = (TestEvent) event;
        invoke(subEvent);
    }

    public void invoke(TestEvent testEvent) {
        System.out.println(String.format("[TestEventListener ] action testEvent=%s", testEvent.toString()));
    }

}
