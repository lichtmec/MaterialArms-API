package ma.api.recipe;

import java.util.*;

import net.minecraft.item.*;

import ma.common.smaterial.*;

public interface IRecipeFusemelt
{
	public boolean isMatches (ItemStack[] stacks);
	
	public boolean canStart (ItemStack[] stacks, int temp);
	
	public List getResources ();
	
	public SMatStack getResult ();
	
	public int getRunTemp ();
	
	public int getRunTime ();
}