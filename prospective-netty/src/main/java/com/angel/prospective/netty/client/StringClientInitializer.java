package com.angel.prospective.netty.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author wanbf
 * @date 2018/12/29 15:13
 */

public class StringClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        /*
         * 这个地方的 必须和服务端对应上。否则无法正常解码和编码
         *
         * 解码和编码 我将会在下一张为大家详细的讲解。再次暂时不做详细的描述
         *
         * LinkedBaseFrameDecoder 按照行解析
         * DelimiterBasedFrameDecoder 使用分隔符解析或者最大长度
         * FixLengthFrameDecoder 定长解析
         * */

        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());

        // 客户端的逻辑
        pipeline.addLast("handler", new StringClientHandler());
    }
}