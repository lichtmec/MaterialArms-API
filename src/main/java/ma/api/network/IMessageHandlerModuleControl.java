package ma.api.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * The interface of the packet receiver.<br>
 * The methods of this interface are only called from the server side.
 * 
 * @param <C>	Type of data to be received.
 * 
 * @author licht
 */
public interface IMessageHandlerModuleControl<C extends IMessageDataComposite>
{
	/**
	 * Create new data instance. (Used by receiver)<br>
	 * Parameter initialization is not required.
	 * 
	 * @return	new instance
	 */
	C createCompositeInstance ();
	
	/**
	 * The process of receiving a packet.
	 * 
	 * @param data			Received data
	 * @param moduleData	Module NBT data
	 * @param player		Player equipped with armor
	 * @param armorStack	Armor with the module
	 */
	void onReceiveRequest (C data, NBTTagCompound moduleData, EntityPlayer player, ItemStack armorStack);
}