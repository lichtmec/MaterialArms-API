package ma.api.recipe;

import ma.api.recipe.dynamic.IDynamicRecipeCrusher;
import ma.api.smaterial.SMatStack;
import ma.api.smaterial.SMaterial;
import net.minecraft.item.ItemStack;
import ma.api.recipe.Technology.UnderlyingTechnology;

/**
 * MaterialArms Recipe Register Accesser
 *
 * @author	licht
 */
public final class RecipeRegsiterAccess
{
	private static IRecipeRegister register;

	/**
	 * Add MA-Crafting Recipe from recipe-instance.
	 */
	public static void addMARecipe (IRecipeMA recipe)
	{
		register.addMARecipe(recipe);
	}

	/**
	 * Add MA-Crafting Recipe from some parameters.
	 */
	public static void addMARecipe (UnderlyingTechnology[] underlying, UnderlyingTechnology[] unlock, ICraftItemGenHandler genHandler, ItemStack output, Object ... input)
	{
		register.addMARecipe(underlying, unlock, genHandler, output, input);
	}

	/**
	 * Add unlockable recipe.
	 */
	public static void registerRechUnlocker (ITechUnlockable unlocker)
	{
		register.registerTechUnlocker(unlocker);
	}

	public static void addFusemeltRecipe (IRecipeFusemelt recipe)
	{
		register.addFusemeltRecipe(recipe);
	}

	public static void addFusemeltRecipe (SMatStack output, Object[] input, int requiredTemp, int requiredTime)
	{
		register.addFusemeltRecipe(output, input, requiredTemp, requiredTime);
	}

	public static void registerPlateProcessorCategory (PlateProcessorCategory category)
	{
		register.registerPlateProcessorCategory(category);
	}

	public static void addPlateProcessorRecipeIngotToPlate (String materialName, int requiredTier, int requiredTime)
	{
		register.addPlateProcessorRecipeIngotToPlate(materialName, requiredTier, requiredTime);
	}

	public static void addPlateProcessorRecipePlateToDoubleplate (String materialName, int requiredTier, int requiredTime)
	{
		register.addPlateProcessorRecipePlateToDoubleplate(materialName, requiredTier, requiredTime);
	}

	public static void addPlateProcessorRecipeDoubleplateToSteadyplate (String materialName, int requiredTier, int requiredTime)
	{
		register.addPlateProcessorRecipeDoubleplateToSteadyplate(materialName, requiredTier, requiredTime);
	}

	public static void addPlateProcessorRecipePlateToSteadyplate (String materialName, int requiredTier, int requiredTime)
	{
		register.addPlateProcessorRecipePlateToSteadyplate(materialName, requiredTier, requiredTime);
	}

	public static void addPulverizerRecipe (IRecipePulverizer recipe)
	{
		register.addPulverizerRecipe(recipe);
	}

	public static void addPulverizerRecipe (ItemStack input, byte category, int tierRequired, int timeRequired, ItemStack output, ItemStack subOutput, float subOutputChance)
	{
		register.addPulverizerRecipe(input, category, tierRequired, timeRequired, output, subOutput, subOutputChance);
	}

	public static void addCrusherRecipe (IRecipeCrusher recipe)
	{
		register.addCrusherRecipe(recipe);
	}

	public static void addCrusherRecipe (Object input, ItemStack output, int tierRequired, int timeRequired)
	{
		register.addCrusherRecipe(input, output, tierRequired, timeRequired);
	}

	public static void addElectrolyzerRecipe (IRecipeElectrolyzer recipe)
	{
		register.addElectrolyzerRecipe(recipe);
	}

	public static void addElectrolyzerRecipe (SMaterial input, int inputAmount, SMatStack output1, SMatStack output2, SMaterial.States inputState, int requiredTier, int requiredTime, int sampleTemp)
	{
		register.addElectrolyzerRecipe(input, inputAmount, output1, output2, inputState, requiredTier, requiredTime, sampleTemp);
	}

	public static void addCircuitAssemblerRecipe (IRecipeCircuitAssembler recipe)
	{
		register.addCircuitAssemblerRecipe(recipe);
	}

	public static void addCircuitAssemblerRecipe (Object[] inputs, int inputRedstoneAmount, ItemStack output, int requiredTime)
	{
		register.addCircuitAssemblerRecipe(inputs, inputRedstoneAmount, output, requiredTime);
	}

	public static void addDistillationRecipe (IRecipeDistillation recipe)
	{
		register.addDistillationRecipe(recipe);
	}
	
	public static void registerCrusherDynamicRecipe (IDynamicRecipeCrusher dynamicRecipe)
	{
		register.registerCrusherDynamicRecipe(dynamicRecipe);
	}

	public interface IRecipeRegister
	{
		void addMARecipe (IRecipeMA recipe);

		void addMARecipe (UnderlyingTechnology[] underlying, UnderlyingTechnology[] unlock, ICraftItemGenHandler genHandler, ItemStack output, Object ... input);

		void registerTechUnlocker (ITechUnlockable unlocker);

		void addFusemeltRecipe (IRecipeFusemelt recipe);

		void addFusemeltRecipe (SMatStack output, Object[] input, int requiredTemp, int requiredTime);

		void registerPlateProcessorCategory (PlateProcessorCategory category);

		void addPlateProcessorRecipeIngotToPlate (String materialName, int requiredTier, int requiredTime);

		void addPlateProcessorRecipePlateToDoubleplate (String materialName, int requiredTier, int requiredTime);

		void addPlateProcessorRecipeDoubleplateToSteadyplate (String materialName, int requiredTier, int requiredTime);

		void addPlateProcessorRecipePlateToSteadyplate (String materialName, int requiredTier, int requiredTime);

		void addPulverizerRecipe (IRecipePulverizer recipe);

		void addPulverizerRecipe (ItemStack input, byte category, int tierRequired, int timeRequired, ItemStack output, ItemStack subOutput, float subOutputChance);

		void addCrusherRecipe (IRecipeCrusher recipe);

		void addCrusherRecipe (Object input, ItemStack output, int tierRequired, int timeRequired);

		void addElectrolyzerRecipe (IRecipeElectrolyzer recipe);

		void addElectrolyzerRecipe (SMaterial input, int inputAmount, SMatStack output1, SMatStack output2, SMaterial.States inputState, int requiredTier, int requiredTime, int sampleTemp);

		void addCircuitAssemblerRecipe (IRecipeCircuitAssembler recipe);

		void addCircuitAssemblerRecipe (Object[] inputs, int inputRedstoneAmount, ItemStack output, int requiredTime);

		void addDistillationRecipe (IRecipeDistillation recipe);
		
		void registerCrusherDynamicRecipe (IDynamicRecipeCrusher dynamicRecipe);
	}
}