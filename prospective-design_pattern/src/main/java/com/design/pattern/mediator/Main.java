package com.design.pattern.mediator;

/**
 * 采用中介者模式
 * 适当地使用中介者模式可以避免同事类之间的过度耦合，使得各同事类之间可以相对独立地使用。
   使用中介者模式可以将对象间一对多的关联转变为一对一的关联，使对象间的关系易于理解和维护。
   使用中介者模式可以将对象的行为和协作进行抽象，能够比较灵活的处理对象间的相互作用。
 */
/*
abstract class AbstractColleague {
    protected int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }
    //注意这里的参数不再是同事类，而是一个中介者
    public abstract void setNumber(int number, AbstractMediator am);
}

class ColleagueA extends AbstractColleague{

    public void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.AaffectB();
    }
}

class ColleagueB extends AbstractColleague{

    @Override
    public void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.BaffectA();
    }
}

abstract class AbstractMediator {
    protected AbstractColleague A;
    protected AbstractColleague B;

    public AbstractMediator(AbstractColleague a, AbstractColleague b) {
        A = a;
        B = b;
    }

    public abstract void AaffectB();

    public abstract void BaffectA();

}
class Mediator extends AbstractMediator {

    public Mediator(AbstractColleague a, AbstractColleague b) {
        super(a, b);
    }

    //处理A对B的影响
    public void AaffectB() {
        int number = A.getNumber();
        B.setNumber(number*100);
    }

    //处理B对A的影响
    public void BaffectA() {
        int number = B.getNumber();
        A.setNumber(number/100);
    }
}

public class Main {
    public static void main(String[] args){
        AbstractColleague collA = new ColleagueA();
        AbstractColleague collB = new ColleagueB();

        AbstractMediator am = new Mediator(collA, collB);

        System.out.println("==========通过设置A影响B==========");
        collA.setNumber(1000, am);
        System.out.println("collA的number值为："+collA.getNumber());
        System.out.println("collB的number值为A的10倍："+collB.getNumber());

        System.out.println("==========通过设置B影响A==========");
        collB.setNumber(1000, am);
        System.out.println("collB的number值为："+collB.getNumber());
        System.out.println("collA的number值为B的0.1倍："+collA.getNumber());

    }
}
*/
public class Main {
    public static void main(String[] args) {
        People peopleA = new Zhangsan();
        People peopleB = new Lisi();
        Mediator mediator = new ConcreteMediator(peopleA, peopleB);
        peopleA.setNum(10);
        peopleB.setNum(10);
        peopleB.setNum(12,mediator);
        System.out.println(peopleA.getNum());
        System.out.println(peopleB.getNum());
    }
}

abstract class People {
    protected int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    abstract void setNum(int num,Mediator mediator);
}

class Zhangsan extends People {

    @Override
    void setNum(int num, Mediator mediator) {
        this.setNum(num);
        mediator.affectB();
    }
}

class Lisi extends People {

    @Override
    void setNum(int num, Mediator mediator) {
        this.setNum(num);
        mediator.affectA();
    }
}

abstract class Mediator {
    protected People peopleA;
    protected People peopleB;

    public Mediator(People peopleA, People peopleB) {
        this.peopleA = peopleA;
        this.peopleB = peopleB;
    }
    abstract void affectA();

    abstract void affectB();
}

class ConcreteMediator extends Mediator{

    public ConcreteMediator(People peopleA, People peopleB) {
        super(peopleA, peopleB);
    }

    @Override
    void affectA() {
        peopleA.setNum(peopleA.getNum()+1);
    }

    @Override
    void affectB() {
        peopleB.setNum(peopleB.getNum()+1);
    }
}
