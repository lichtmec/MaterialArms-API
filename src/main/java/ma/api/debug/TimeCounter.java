package ma.api.debug;

/**
 * Utility for measuring the processing time.
 *
 * @deprecated "debug" package will be soon removed.
 * 
 * @author	licht
 */
@Deprecated
public class TimeCounter
{
	protected static long startTime_nano = 0;
	
	/**
	 * Store the measurement start time.
	 */
	public static void startTimer ()
	{
		startTime_nano = System.nanoTime();
	}
	
	/**
	 * Get the difference between the measurement start time.
	 * 
	 * @return	measuring result
	 */
	public static long getLapseTime ()
	{
		return System.nanoTime() - startTime_nano;
	}
}