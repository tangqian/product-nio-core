package com.netwaymedia.nio.core.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class KmppMessageDecoder extends LengthFieldBasedFrameDecoder {

	public KmppMessageDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
		super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
	}

	@Override
	protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		ByteBuf frame = (ByteBuf) super.decode(ctx, in);
		if(frame == null)
			return null;
		int length = frame.readInt();
		System.out.println(length);
		byte[] msgArr = new byte[length];
		frame.readBytes(msgArr);
		String s = new String(msgArr, "UTF-8");
		System.out.println(s);
		return s;
	}

	

}
