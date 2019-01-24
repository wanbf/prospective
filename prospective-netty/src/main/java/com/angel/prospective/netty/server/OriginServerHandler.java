package com.angel.prospective.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author wanbf
 * @date 2018/12/29 10:34
 */
public class OriginServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("OriginServerHandler reading");
        ByteBuf result = (ByteBuf) msg;
        byte[] resultByte = new byte[result.readableBytes()];
        result.readBytes(resultByte);
        String message = new String(resultByte);
        System.out.println("client said: " + message);
        result.release();

        String response = "hello client";
        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
        encoded.writeBytes(response.getBytes());
        ctx.write(encoded);
        ctx.flush();

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
