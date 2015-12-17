package ma.api.recipe;

import java.util.*;

import net.minecraft.item.*;

import ma.common.smaterial.*;

public interface IRecipeFusemelt
{
	boolean isMatches (ItemStack[] stacks);
	
	boolean canStart (ItemStack[] stacks, int temp);
	
	List getResources ();
	
	SMatStack getResult ();
	
	int getRunTemp ();
	
	int getRunTime ();
}