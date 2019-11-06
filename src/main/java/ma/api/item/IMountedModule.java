package ma.api.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.*;

/**
 * Properties of the module mounted in the armor.<br>
 * Called from events for each modules.
 *
 * @author licht
 */
public interface IMountedModule
{
	/**
	 * @return Energy capacity of module.
	 */
	long getEnergyCapacity (NBTTagCompound moduleData, EntityPlayer player, ItemStack armorStack);
	
	void onArmorTick (NBTTagCompound moduleData, EntityPlayer player, ItemStack armorStack);
	
	/**
	 * Similar to Item#renderHelmetOverlay(), but whether it is actually called depends on the state of the armor.<br>
	 * Not only when mounted on a helmet, but also when mounted on other parts.
	 */
	@SideOnly(Side.CLIENT)
	void renderHelmetOverlay(NBTTagCompound moduleData, EntityPlayer player, ItemStack armorStack, ScaledResolution resolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY);
	
	void onLivingAttacked (NBTTagCompound moduleData, LivingAttackEvent event, ItemStack armorStack);
	
	void onLivingFall (NBTTagCompound moduleData, LivingFallEvent event, ItemStack armorStack);
	
	void onLivingHurt (NBTTagCompound moduleData, LivingHurtEvent event, ItemStack armorStack);
}

/*
 * NOTE: moduleData tags
 *
 * - "function" : String
 * 		Key of MountedModule registry.
 * 
 * - "mstack" : NBTTagCompound
 * 		NBT data of ItemStack ( mounted module )
 * 
 * - "mconnection" : boolean
 * 		Is module connect to armor battery and controller.
 * 
 * - "charge" : long
 * 		Energy level of module.
 * 		If you want to consume module-energy, rewrite this value.
 */