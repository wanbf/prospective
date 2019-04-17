package com.angel.prospective.util.VMUtil;

/**
 * 测试虚拟机栈深度
 */
public class StackErrorMock {
    private static int index = 1;

    public void call(){
        index++;
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        call();
    }

    public static void main(String[] args) {
        StackErrorMock mock = new StackErrorMock();
        try {
            mock.call();
        }catch (Throwable e){
            System.out.println("Stack deep : "+index);
            e.printStackTrace();
        }
    }
}