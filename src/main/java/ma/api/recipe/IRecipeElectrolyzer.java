package ma.api.recipe;

import ma.api.smaterial.SMatStack;

public interface IRecipeElectrolyzer
{
	boolean isMatches (SMatStack materialStack);

	int getRequiredTime ();

	int getRequiredTier ();

	SMatStack getResource ();

	/**
	 * Output sample from cathode.
	 *
	 * @return	Output SMaterial stack sample, nullable.
	 */
	SMatStack getOutput1 ();

	/**
	 * Output sample from anode.
	 *
	 * @return	Output SMaterial stack sample, nullable.
	 */
	SMatStack getOutput2 ();
}