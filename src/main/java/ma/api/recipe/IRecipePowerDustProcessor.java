package ma.api.recipe;

import ma.api.smaterial.SMatStack;
import net.minecraft.item.ItemStack;

public interface IRecipePowerDustProcessor
{
	boolean isMatches (IInventoryPowerDustProcessorInput input, int machineTier);

	int getRequiredTime ();

	int getRequiredTier ();

	ItemStack getResultItem ();

	SMatStack getResultSMat ();

	int getMatrixLength ();

	int getMatrixWidth ();

	int getMatrixHeight ();

	/**
	 * Create recipe result item.
	 *
	 * @param input Input matrix. ( Unmodifiable )
	 * @return ItemStack of output.
	 */
	ItemStack getOutputItem (IInventoryPowerDustProcessorInput input);

	/**
	 * Create recipe result smatstack.
	 *
	 * @param input Input matrix. ( Unmodifiable )
	 * @return SMatStack of output.
	 */
	SMatStack getOutputSMat (IInventoryPowerDustProcessorInput input);

	Object[] getResources ();

	/**
	 * Consume resources on start process.
	 *
	 * @return Task was successes. ( On return 'false', cancel the process. )
	 */
	boolean consumeResources (IInventoryPowerDustProcessorInput input);

	interface IInventoryPowerDustProcessorInput
	{
		int getMatrixWidth ();

		int getMatrixHeight ();

		ItemStack getStackInSlot (int slotIndex);

		ItemStack getStackInSlot (int x, int y);

		ItemStack decrStackSize (int slotIndex, int amount);

		ItemStack decrStackSize (int x, int y, int amount);

		void setInventorySlotContents (int slotIndex, ItemStack stack);

		void setInventorySlotContents (int x, int y, ItemStack stack);
	}
}