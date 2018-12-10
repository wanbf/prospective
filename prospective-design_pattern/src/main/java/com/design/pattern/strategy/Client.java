package com.design.pattern.strategy;

interface Strategy{
    void doSomething();
}

class Context{
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        strategy.doSomething();
    }
}

class FirstStrategy implements Strategy{

    @Override
    public void doSomething() {
        System.out.println("first strategy");
    }
}
class SecondStrategy implements Strategy{

    @Override
    public void doSomething() {
        System.out.println("second strategy");
    }
}
public class Client {
    public static void main(String[] args) {
        Strategy strategy1 = new FirstStrategy();
        Strategy strategy2 = new SecondStrategy();
        Context context1 = new Context(strategy1);
        context1.execute();
        Context context2 = new Context(strategy2);
        context2.execute();
    }
}
