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
	 * 
	 * @author	licht
	 */
	public boolean isArmorCoreComponent (ItemStack stack);
	
	/**
	 * @param	stack	component stack
	 * 
	 * @return	require tier
	 * 
	 * @author	licht
	 */
	public int getRequireTier (ItemStack stack);
	
	/**
	 * @param	target	core stack
	 * @param	stack	component stack
	 * 
	 * @return	Tools needed to attach<br>
	 * 			(Tool ID= 0:wrench, 1:hammer, 2:screwdriver, 3:metalfile, 4:chisel, 5:saw)
	 * 
	 * @author	licht
	 */
	public int[] getNeedTools (ItemStack target, ItemStack stack);
	
	/**
	 * @param	target	core stack
	 * @param	stack	component stack
	 * 
	 * @return	happend
	 * 
	 * @author	licht
	 */
	public boolean attachComponent (ItemStack target, ItemStack stack);
}