package com.design.pattern.decorator;

 interface IReader {
    void read();
}

class BufferedReader implements IReader {

    private IReader mReader;
    public BufferedReader(IReader reader) {
        this.mReader = reader;
    }

    @Override
    public void read() {
        System.out.println("read of BufferedReader.");
        mReader.read();
    }

}
 class Reader implements IReader {

    @Override
    public void read() {
        System.out.println("read of Reader.");
    }

}
public class MainTest {
    public static void main(String[] args) {
        IReader reader = new Reader();
        IReader bufferedReader = new BufferedReader(reader);
        bufferedReader.read();
    }
}
