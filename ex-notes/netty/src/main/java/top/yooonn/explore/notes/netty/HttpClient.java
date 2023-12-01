package top.yooonn.explore.notes.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @author yooonn
 * @date 2022.07.23
 */
public class HttpClient {

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap client = new Bootstrap();
        // todo
        try {
            ChannelFuture channel = client.connect("127.0.0.1", 18888).sync();
            channel.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            group.shutdownGracefully();
        }
    }
}
