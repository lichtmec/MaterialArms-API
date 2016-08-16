package ma.api.tileentity;

/**
 * @author	licht
 */
public interface ITileHeatable_2 extends ITileHeatable
{
	int getAcceptedHeatBuffer ();

	void setAcceptedHeatBuffer (int amount);
}