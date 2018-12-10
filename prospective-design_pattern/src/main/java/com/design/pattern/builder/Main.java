package com.design.pattern.builder;

/**
 * 与工厂模式相比，建造者模式一般用来创建更为复杂的对象，因为对象的创建过程更为复杂，
 * 因此将对象的创建过程独立出来组成一个新的类——导演类。也就是说，工厂模式是将对象的全部创建过程封装在工厂类中，
 * 由工厂类向客户端提供最终的产品；而建造者模式中，建造者类一般只提供产品类中各个组件的建造，而将具体建造过程交付给导演类。
 * 由导演类负责将各个组件按照特定的规则组建为产品，然后将组建好的产品交付给客户端。
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        Product bus = director.getBusProduct();
        bus.show();

        Product car =director.getCarProduct();
        car.show();
    }
}
