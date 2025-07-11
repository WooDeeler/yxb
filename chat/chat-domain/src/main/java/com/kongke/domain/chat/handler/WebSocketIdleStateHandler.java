package com.kongke.domain.chat.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * WebSocket服务端的心跳检测
 *
 *
 */
@Slf4j
public class WebSocketIdleStateHandler extends IdleStateHandler {
	
	/**
	 * 默认的读空闲时间
	 */
	private static final int DEFAULT_READER_IDLE_TIME = 5;
	
	/**
	 * 默认30秒读空闲断开客户端
	 */
	public WebSocketIdleStateHandler() {
		super(DEFAULT_READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
	}
	
	/**
	 * 指定心跳时间（秒）
	 *
	 * @param readerIdleTimeSeconds 读空闲时间
	 * @param writerIdleTimeSeconds 写空闲时间
	 * @param allIdleTimeSeconds    读写空闲时间
	 */
	public WebSocketIdleStateHandler(int readerIdleTimeSeconds, int writerIdleTimeSeconds, int allIdleTimeSeconds) {
		super(readerIdleTimeSeconds, writerIdleTimeSeconds, allIdleTimeSeconds, TimeUnit.SECONDS);
	}
	
	/**
	 * 指定心跳时间及时间单位
	 *
	 * @param readerIdleTime 读空闲时间
	 * @param writerIdleTime 写空闲时间
	 * @param allIdleTime    读写空闲时间
	 * @param unit           时间单位
	 */
	public WebSocketIdleStateHandler(long readerIdleTime, long writerIdleTime, long allIdleTime, TimeUnit unit) {
		super(readerIdleTime, writerIdleTime, allIdleTime, unit);
	}
	
	/**
	 * 当空闲事件触发时执行
	 */
	@Override
	protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
		//如果是读空闲
		if (evt.state().equals(IdleState.READER_IDLE)) {
			Channel channel = ctx.channel();
			log.debug("服务端未检测到客户端【{}】的心跳包，强制关闭客户端！", channel.id());
			channel.close();
		}
		
		super.channelIdle(ctx,evt);
	}
	
}
