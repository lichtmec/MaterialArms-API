package ma.api.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ma.api.item.IMountedModule;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Properties of the module mounted in the armor.<br>
 * Provides a function to display module information to the HUD.
 *
 * @author	licht
 */
public interface IMountedModuleHUD extends IMountedModule
{
	/**
	 * Render information in the module HUD.
	 *
	 * @param x					Render coordinate X
	 * @param y					Render coordinate Y
	 * @param providedSpaceW	Draw according to this width.
	 * @param providedSpaceH	Draw according to this height.
	 * @return					Was drawn something.
	 */
	@SideOnly(Side.CLIENT)
	boolean renderHUDContent (NBTTagCompound moduleData, EntityPlayer player, ItemStack armorStack, float partialTicks, boolean hasScreen, int x, int y, int providedSpaceW, int providedSpaceH);
}