package ma.api.recipe;

import java.util.*;

import ma.api.smaterial.SMatStack;
import net.minecraft.item.*;

public interface IRecipeFusemelt
{
	boolean isMatches (ItemStack[] stacks);
	
	boolean canStart (ItemStack[] stacks, int temp);
	
	List getResources ();
	
	SMatStack getResult ();
	
	int getRunTemp ();
	
	int getRunTime ();
}