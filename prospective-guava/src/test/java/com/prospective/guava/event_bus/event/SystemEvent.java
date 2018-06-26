package com.prospective.guava.event_bus.event;


/**
 * 系统事件父类
 *
 */
public class SystemEvent {

    public static final String MEMBER_DELETE_EVENT = "memberDelEvt";
    public static final String TEST_EVENT = "testEvt";

    private String eventName;

    public SystemEvent() {

    }

    public SystemEvent(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "SystemEvent [eventName=" + eventName + "]";
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}