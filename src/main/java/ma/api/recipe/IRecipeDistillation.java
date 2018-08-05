package ma.api.recipe;

import ma.api.smaterial.SMatStack;

public interface IRecipeDistillation
{
	/**
	 * @return	In case of false, distillation platform will check the next recipe.
	 */
	boolean isMatch (SMatStack input);

	DistillationOutput getResult (SMatStack input);

	/**
	 * For recipe display on NEI.<br>
	 * It does not necessarily have to be implemented.<br>
	 *
	 * @return Sample stack.
	 */
	SMatStack getStartMaterial ();

	class DistillationOutput
	{
		/**
		 * Output to next distillation platform.
		 */
		public final SMatStack output1;

		/**
		 * Output to pan.
		 */
		public final SMatStack output2;

		/**
		 * Returned input. (ISMatContainerTile#fillMaterial() return)
		 */
		public final int surplus;

		/**
		 * @param output1 Nullable, output to next distillation platform.
		 * @param output2 Nullable, output to pan.
		 */
		public DistillationOutput (SMatStack output1, SMatStack output2, int surplus)
		{
			this.output1 = output1;
			this.output2 = output2;
			this.surplus = surplus;
		}
	}
}