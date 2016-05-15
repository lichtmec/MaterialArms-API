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
	public static final String API_VER = "0.9.5";

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
}