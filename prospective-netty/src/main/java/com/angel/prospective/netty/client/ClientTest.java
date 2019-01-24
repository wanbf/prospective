package com.angel.prospective.netty.client;

import com.angel.prospective.netty.Constant;
import com.angel.prospective.netty.Serializer;
import com.angel.prospective.netty.server.StringServerInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author wanbf
 * @date 2018/12/29 10:48
 */
public class ClientTest {
    public void connect(String host, int port, Serializer serilizer) {
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(worker);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            switch (serilizer) {
                case ORIGIN:
                    b.handler(new OriginClientInitializer());
                case STRING:
                    b.handler(new StringClientInitializer());
            }
            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new ClientTest().connect("127.0.0.1", 9090, Constant.SERIALIZER);
    }
}
