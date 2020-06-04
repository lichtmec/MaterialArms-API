package ma.api.tileentity;

/**
 * Interface that controls the way heat transfer rate to the Material.
 */
public interface ISMatContainerTileHeatSegregation
{
	SegregationStatus getSegregationStatus (int smatContainerId);
	
	enum SegregationStatus
	{
		/**
		 * Normal state.<br>
		 * Heat is 100% transferable.
		 */
		DEFAULT,
		/**
		 * Completely segregatied.<br>
		 * The heat of {@link ITileHeatable} does not affect that material.
		 */
		PERFECT_SEGREGATED
	}
}