package ma.api.item;

import net.minecraft.item.ItemStack;

/**
 * It referenced to when that destroy disassembable-block.<br>
 * When destroy a disassembable-block in this item , that block will be disassembled.
 *
 * @see	ma.api.block.IBlockDisassembable
 *
 * @author	licht
 */
public interface IDisassembleTool
{
	/**
	 * Check whether this item can be used as disassemble-tool.
	 */
	boolean isDisassembleTool (ItemStack stack);

	/**
	 * @return	power tier
	 */
	int getDisassembleWorkPower (ItemStack stack);

	IDisassembleMethod getDisassembleMethod (ItemStack stack);

	enum DisassembleMethod implements IDisassembleMethod
	{
		BREAK("break"),
		CUTTING("cutting"),
		DISASSEMBLE("disassemble");

		private final String methodName;

		DisassembleMethod (String methodName)
		{
			this.methodName = methodName;
		}

		@Override
		public String getMethodName ()
		{
			return this.methodName;
		}
	}

	interface IDisassembleMethod
	{
		String getMethodName ();
	}
}