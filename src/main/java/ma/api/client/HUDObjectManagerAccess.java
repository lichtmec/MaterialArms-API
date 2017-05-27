package ma.api.client;

import net.minecraft.entity.player.EntityPlayer;

/**
 * @author	licht
 */
public final class HUDObjectManagerAccess
{
	private static IHUDManager managerInstance;

	/**
	 * On update contents.<br>
	 * After this method is called, Central-HUD is displayed for a certain period of time.
	 */
	public static void updateContents ()
	{
		managerInstance.updateCentralHUDContents();
	}

	/**
	 * updateContents() for server side.
	 *
	 * @param player player updating HUD
	 */
	public static void updateCentralHUDContentsInServer (EntityPlayer player)
	{
		managerInstance.updateCentralHUDContentsInServer(player);
	}

	public static void registerCentralHUD (CentralHUDObject hudObject)
	{
		managerInstance.registerCentralHUD(hudObject, ObjectPlace.MIDDLE);
	}

	public static void registerCentralHUD (CentralHUDObject hudObject, ObjectPlace place)
	{
		managerInstance.registerCentralHUD(hudObject, place);
	}

	public interface IHUDManager
	{
		void updateCentralHUDContents ();

		void updateCentralHUDContentsInServer (EntityPlayer player);

		void registerCentralHUD (CentralHUDObject hudObject, ObjectPlace place);
	}

	public enum ObjectPlace
	{
		TOP,
		UPPER,
		MIDDLE,
		LOWER,
		BOTTOM
	}
}