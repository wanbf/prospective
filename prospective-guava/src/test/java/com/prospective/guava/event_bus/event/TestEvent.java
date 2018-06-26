package com.prospective.guava.event_bus.event;


public class TestEvent extends SystemEvent {

    private String testField;

    public String getTestField() {
        return testField;
    }

    public void setTestField(String testField) {
        this.testField = testField;
    }

    public TestEvent() {
    }

    public TestEvent(String eventName, String testField) {
        super(eventName);
        this.testField = testField;
    }

}
