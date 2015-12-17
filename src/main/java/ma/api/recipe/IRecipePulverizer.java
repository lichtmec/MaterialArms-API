package ma.api.recipe;

import net.minecraft.item.ItemStack;

public interface IRecipePulverizer
{
	byte modeGrinder = 1;
	byte modeCrushmill = 2;
	
	boolean canPulverize (ItemStack input, int tier, int pulverizer);
	
	int getPulverizerMode ();
	
	int getRequiredTier ();
	
	Object getResource ();
	
	ItemStack getMainOutput ();
	
	ItemStack getSubOutput ();
	
	float getSubOutputChance ();
	
	int getTimeRequired (ItemStack input, int pulverizer);
}