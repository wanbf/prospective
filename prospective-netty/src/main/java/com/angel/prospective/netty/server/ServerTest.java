package com.angel.prospective.netty.server;


import com.angel.prospective.netty.Constant;
import com.angel.prospective.netty.Serializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * @author wanbf
 * @date 2018/12/29 10:19
 */
public class ServerTest {

    public void startNetty(int port, Serializer serializer) {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker);
            bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
            bootstrap.channel(NioServerSocketChannel.class);
            switch (serializer) {
                case ORIGIN:
                    bootstrap.childHandler(new OriginServerInitializer());
                case STRING:
                    bootstrap.childHandler(new StringServerInitializer());
            }
            ChannelFuture f = bootstrap.bind(port).sync();
            f.channel().closeFuture().sync();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new ServerTest().startNetty(9090, Constant.SERIALIZER);
    }
}
