package ma.api.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * It provides a client-server communication function in the (Powered Suit) Modules.
 * 
 * @author licht
 */
public class ModuleControlCommunicationAccess
{
	private static IModuleControlCommunication CONTROLLER;
	
	/**
	 * Register a packet handler.<br>
	 * <br>
	 * Recommended key format:<br>
	 * &nbsp;&nbsp; "{ModID}:{PacketName}"<br>
	 * &nbsp;&nbsp; e.g.<br>
	 * &nbsp;&nbsp; "materialarms:turn_power"
	 * 
	 * @param patternName	key
	 * @param pattern		Packet handler
	 * @return				registration successfull ( false = registration key duplicated )
	 */
	public static boolean registerCommunicationPattern (String patternName, IMessageHandlerModuleControl pattern)
	{
		return CONTROLLER.registerCommunicationPattern(patternName, pattern);
	}
	
	/**
	 * Send (Powered Suit) Module control packet to server.<br>
	 * This method is only available within the client-side {@link ma.api.item.IMountedModule#onArmorTick(NBTTagCompound, EntityPlayer, ItemStack)}.<br>
	 * <br>
	 * Calling this method will send a message to the corresponding module on the server side.<br>
	 * For example,<br>
	 * If this method is called in the onArmorTick() of the helmet's 0th module :<br>
	 * The MaterialArms system will call onReceiveRequest( 2nd arg = NBT of helmet's 0th module ) (in packet handler) at server. 
	 * 
	 * @param patternName	key
	 * @param message		packet data
	 */
	public static void sendModuleControlToServer (String patternName, IMessageDataComposite message)
	{
		CONTROLLER.sendModuleControlToServer(patternName, message);
	}
	
	public interface IModuleControlCommunication
	{
		boolean registerCommunicationPattern (String patternName, IMessageHandlerModuleControl pattern);
		
		void sendModuleControlToServer (String patternName, IMessageDataComposite message);
	}
}