package ma.api.event;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class PlayerCurrentEquipSwapEvent extends Event
{
	public final EntityPlayer player;
	public final ItemStack newEquip;
	public final ItemStack oldEquip;

	public PlayerCurrentEquipSwapEvent (EntityPlayer player, ItemStack newEquip, ItemStack oldEquip)
	{
		this.player = player;
		this.newEquip = newEquip;
		this.oldEquip = oldEquip;
	}
}