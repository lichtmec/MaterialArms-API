package ma.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Mod:MaterialArms API core
 * 
 * @author	licht
 */
public final class MaterialArmsAPI
{
	private static final int API_VER_MAJOR = 0;
	private static final int API_VER_MINOR = 9;
	private static final int API_VER_BUILD = 8;

	public static final String API_VER = API_VER_MAJOR + "." + API_VER_MINOR + "." + API_VER_BUILD;

	private static Boolean initialized = Boolean.FALSE;
	private static Logger logger = LogManager.getLogger("MaterialArmsAPI");

	public static boolean isInitialized ()
	{
		return initialized;
	}

	public static void sendLogInfo (String message)
	{
		logger.info(message);
	}

	public static void sendLogWarning (String message)
	{
		logger.warn(message);
	}

	public static void sendLogError (String message)
	{
		logger.error(message);
	}

	public static void sendLogFatal (String message)
	{
		logger.fatal(message);
	}

	public static boolean checkApiVersion (int requireMajor, int requireMinor, int requireBuild)
	{
		if (API_VER_MAJOR > requireMajor)
		{
			return true;
		}
		else if (API_VER_MINOR > requireMinor)
		{
			return true;
		}
		else if (API_VER_BUILD >= requireBuild)
		{
			return true;
		}

		return false;
	}
}