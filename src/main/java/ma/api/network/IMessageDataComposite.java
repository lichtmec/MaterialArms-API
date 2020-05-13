package ma.api.network;

import io.netty.buffer.ByteBuf;

/**
 * Interface for packet data.<br>
 * Implement it in the same as {@link cpw.mods.fml.common.network.simpleimpl.IMessage}.
 */
public interface IMessageDataComposite
{
	void fromBytes (ByteBuf buf);
	
	void toBytes (ByteBuf buf);
}