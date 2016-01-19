package ma.api.smaterial;

import ma.api.smaterial.SMatStack;

public interface ISMatContainer
{
	SMatStack getMaterialContainer (int container);
	
	int getMaterialContainerCapacity (int container);
	
	int getMaterialContainerSize ();
}