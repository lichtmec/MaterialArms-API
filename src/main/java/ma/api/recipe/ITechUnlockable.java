package ma.api.recipe;

import ma.api.recipe.Technology.UnderlyingTechnology;

/**
 * Information about U.Technology unlock.
 * It is assumed to be implemented with IRecipeMA.
 *
 * @author	licht
 */
public interface ITechUnlockable
{
	/**
	 * Check whether it is possible to unlock this U.Technology.
	 *
	 * @param tech	Check target
	 *
	 * @return	true(unlockable) or false(not unlockable)
	 */
	boolean isUnlockable (Technology.UnderlyingTechnology tech);

	/**
	 * Is secret info.
	 * If the secret , it does not appear in the Research-Note.
	 *
	 * @return	true(secret) or false(not secret)
	 */
	boolean isSecret ();

	/**
	 * @return	Array of unlockables
	 */
	UnderlyingTechnology[] getUnlockableList ();
}