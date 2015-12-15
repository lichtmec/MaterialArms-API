package ma.api.recipe;

import net.minecraft.item.ItemStack;

public interface IRecipePulverizer
{
	public static final byte modeGrinder = 1;
	public static final byte modeCrushmill = 2;
	
	public boolean canPulverize (ItemStack input, int tier, int pulverizer);
	
	public int getPulverizerMode ();
	
	public int getRequiredTier ();
	
	public Object getResource ();
	
	public ItemStack getMainOutput ();
	
	public ItemStack getSubOutput ();
	
	public float getSubOutputChance ();
	
	public int getTimeRequired (ItemStack input, int pulverizer);
}