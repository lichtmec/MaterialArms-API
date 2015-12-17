package ma.api.item;

import net.minecraft.item.ItemStack;

/**
 * MA-ElectricArmor core component item
 * 
 * @author	licht
 */
public interface IArmorCoreComponent
{
	/**
	 * @param	stack	this item
	 * 
	 * @return	aviable componet
	 */
	boolean isArmorCoreComponent (ItemStack stack);
	
	/**
	 * @param	stack	component stack
	 * 
	 * @return	require tier
	 */
	int getRequireTier (ItemStack stack);
	
	/**
	 * @param	target	core stack
	 * @param	stack	component stack
	 * 
	 * @return	Tools needed to attach<br>
	 * 			(Tool ID= 0:wrench, 1:hammer, 2:screwdriver, 3:metalfile, 4:chisel, 5:saw)
	 */
	int[] getNeedTools (ItemStack target, ItemStack stack);
	
	/**
	 * @param	target	core stack
	 * @param	stack	component stack
	 * 
	 * @return	happend
	 */
	boolean attachComponent (ItemStack target, ItemStack stack);
}