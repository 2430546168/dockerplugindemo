package com.dockerplugindemo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

/**
 * @author: zsg
 * @create: 2020/9/8 18:31
 * @description:
 */
public class NettyServer {

    private static final int PORT = 8000;
    private static final AttributeKey<Object> SERVER_NAME_KEY = AttributeKey.newInstance("serverName");
    private static final String SERVER_NAME_VALUE = "nettyServer";
    public static final AttributeKey<Object> CLIENT_KEY = AttributeKey.newInstance("clientKey");
    public static final String CLIENT_VALUE = "clientValue";


    /**
     * 1、boss 中的接受新连接线程 主要负责创建新连接
     * 2、worker 负责读取数据的线程，主要用于读取数据以及业务逻辑处理
     *
     * @param args
     */
    public static void main(String[] args) {
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(boosGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                // 给服务端添加一个逻辑处理器 这个处理器的作用是负责读取客户端的数据
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new FirstServerHandler());
                    }
                });


        bind(serverBootstrap, PORT);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
            }
        });
    }
}
