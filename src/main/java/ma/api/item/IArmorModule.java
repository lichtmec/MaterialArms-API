package ma.api.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * MA-ElectricArmor module item
 * 
 * @author licht
 */
public interface IArmorModule
{
	/**
	 * @param	stack	this item
	 * 
	 * @return	aviable module
	 * 
	 * @author	licht
	 */
	public boolean isArmorModule (ItemStack stack);
	
	public boolean canAttach (ItemStack stack, int part);
	
	/**
	 * @param	stack	module stack
	 * 
	 * @return	require tier
	 * 
	 * @author	licht
	 */
	public int getRequireTier (ItemStack stack);
	
	/**
	 * @param	target	armor stack
	 * @param	stack	module stack
	 * 
	 * @return	Tools needed to attach<br>
	 * 			(Tool ID= 0:wrench, 1:hammer, 2:screwdriver, 3:metalfile, 4:chisel, 5:saw)
	 * 
	 * @author	licht
	 */
	public int[] getNeedTools (ItemStack target, ItemStack stack);
	
	/**
	 * @param	target	armor stack
	 * @param	stack	module stack
	 * 
	 * @author	licht
	 */
	public void attachComponent (ItemStack target, NBTTagCompound moduleNBT, ItemStack stack);
}