package com.angel.prospective.netty.block_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeServerHandler extends Thread {
    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        BufferedReader in = null;
        PrintWriter out = null;
        try {
          //  in = new BufferedReader(this.socket.getInputStream());
            out = new PrintWriter(this.socket.getOutputStream(),true);
            String currentTime = null;
            String body = null;

            while (true){
                body = in.readLine();
                if(body == null)
                    break;

            }
        } catch (Exception ex) {

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                out.close();
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
