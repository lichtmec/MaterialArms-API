package ma.api.smaterial;

public interface ISMatContainerItem
{
	void fillMaterial (SMatStack smat);

	boolean canFillMaterial (SMatStack smat);

	SMatStack drainMaterial (int maxDrain);

	SMatStack drainMaterial (int maxDrain, int container);

	boolean canDrainMaterial (SMatStack smat);
}