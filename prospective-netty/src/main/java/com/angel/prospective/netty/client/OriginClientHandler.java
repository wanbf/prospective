package com.angel.prospective.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author wanbf
 * @date 2018/12/29 10:55
 */
public class OriginClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("OriginClientHandler.channelRead");
        ByteBuf result = (ByteBuf)msg;
        byte[] resultByte = new byte[result.readableBytes()];
        result.readBytes(resultByte);
        System.out.println("Server said:" + new String(resultByte));
        result.release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String msg = "Hello server";
        ByteBuf encode = ctx.alloc().buffer(4 * msg.length());
        encode.writeBytes(msg.getBytes());
        ctx.write(encode);
        ctx.flush();
    }
}
