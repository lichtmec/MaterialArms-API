package ma.api.recipe;

import net.minecraft.item.*;

public interface ICraftItemGenHandler
{
	ItemStack onGenerate (ItemStack defResult, ItemStack memory);
	
	void onCrafted (ItemStack result, ItemStack memory);
}