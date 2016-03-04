package ma.api.smaterial;

/**
 * This is interface for SMaterial.<br>
 * When SMaterial implementing this, it is solidified in such SSmelter and DiecastingBox.
 *
 * @author	licht
 */
public interface ISMatCoagulable
{
	/**
	 * Associate the SMaterial and OreDictionary-Name of material.<br>
	 *
	 * @return	Material name.
	 */
	String getCorrespondingMaterialName ();
}