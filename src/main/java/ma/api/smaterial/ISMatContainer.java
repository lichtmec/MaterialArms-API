package ma.api.smaterial;

/**
 * SMaterial-Container common interface.<br>
 *
 * @see	ma.api.smaterial.ISMatContainerTile
 * @see	ma.api.smaterial.ISMatContainerItem
 *
 * @author	licht
 */
public interface ISMatContainer
{
	/**
	 * @param	container	Container ID
	 *
	 * @return	Contained SMaterial-Stack
	 */
	SMatStack getMaterialContainer (int container);

	/**
	 * @param	container	Container ID
	 *
	 * @return	Container capacity (Milli-Bucket)
	 */
	int getMaterialContainerCapacity (int container);

	/**
	 * @return	Number of containers
	 */
	int getMaterialContainerSize ();
}