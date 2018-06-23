package com.angel.prospective.util.listener;

/**
 * Created by wanbf on 2017/11/22.
 */
public class Action {
    private static String CREATE_EVENT = "CREATE_EVENT";
    private static String DELETE_EVENT = "DELETE_EVENT";

    public static void main(String[] args) {
        ((Listener) myEvent -> {
            if (myEvent.getEvent().equals(CREATE_EVENT)) {
                System.out.println("MyListener get a CREATE event!");
            } else if (myEvent.getEvent().equals(DELETE_EVENT)) {
                System.out.println("MyListener get a DELETE event!");
            }
        }).handle(() -> CREATE_EVENT);
    }
}

interface Event {
    String getEvent();
}

interface Listener {
    void handle(Event myEvent);
}
