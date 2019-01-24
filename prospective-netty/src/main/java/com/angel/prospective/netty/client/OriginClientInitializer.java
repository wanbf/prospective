package com.angel.prospective.netty.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;


/**
 * @author wanbf
 * @date 2018/12/29 14:26
 */
public class OriginClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new OriginClientHandler());
    }
}
