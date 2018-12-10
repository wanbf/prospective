package com.design.pattern.absfactory;
/**
 * 无论是简单工厂模式，工厂方法模式，还是抽象工厂模式，他们都属于工厂模式，在形式和特点上也是极为相似的，
 * 他们的最终目的都是为了解耦。在使用时，我们不必去在意这个模式到底工厂方法模式还是抽象工厂模式，
 * 因为他们之间的演变常常是令人琢磨不透的。经常你会发现，明明使用的工厂方法模式，当新需求来临，
 * 稍加修改，加入了一个新方法后，由于类中的产品构成了不同等级结构中的产品族，
 * 它就变成抽象工厂模式了；而对于抽象工厂模式，当减少一个方法使的提供的产品不再构成产品族之后，它就演变成了工厂方法模式。
 */
public class Main {
    public static void main(String[] args) {
        IFactory factory = new Factory();
        IProduct1 product1 = factory.createProduct1();
        product1.show();
        IProduct2 product2 = factory.createProduct2();
        product2.show();
    }

}
