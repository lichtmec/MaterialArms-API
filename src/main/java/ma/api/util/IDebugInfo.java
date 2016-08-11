package ma.api.util;

import java.util.*;

/**
 * This is interface for Block, TileEntity, and Entity.<br>
 * <br>
 * Implement debug-info.<br>
 * In vanila MaterialArms, this is accessed by ItemTester.
 * 
 * @author	licht
 */
public interface IDebugInfo extends ma.api.debug.IDebugInfo
{
	/**
	 * 
	 * 
	 * @param	info	hovering text list
	 * @param	type	0:Block, 1:TileEntity, 2:Entity
	 * @param	me		object of interact
	 * @param	x		x
	 * @param	y		y
	 * @param	z		z
	 */
	void onAccessedTester (List info, byte type, Object me, int x, int y, int z);
}