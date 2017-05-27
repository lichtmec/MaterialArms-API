package ma.api.client;

/**
 * @author	licht
 */
public abstract class CentralHUDObject
{
	/**
	 * @return	If return false, render() will not call.
	 */
	public boolean isRender ()
	{
		return true;
	}

	/**
	 * @param baseAlpha	Alpha channel of Central-HUD
	 *
	 * @return	Rendered height
	 */
	public abstract int render (int left, int top, float baseAlpha);
}