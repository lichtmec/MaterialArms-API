package ma.api.recipe;

import net.minecraft.item.*;

public interface ICraftItemGenHandler
{
	public ItemStack onGenerate (ItemStack defResult, ItemStack memory);
	
	public void onCrafted (ItemStack result, ItemStack memory);
}