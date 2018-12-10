package com.angel.prospective.netty.block_io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("输入的参数不合法" + args[0]);
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port:" + port);
            Socket socket ;
            while (true) {
                socket = server.accept();
                TimeServerHandler handler = new TimeServerHandler(socket);
                new Thread(handler).start();
            }
        } finally {
            if (server != null) {
                System.out.println("the time server close!!");
                server.close();
            }
        }
    }
}
