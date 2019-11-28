package ma.api.item;

import net.minecraft.item.ItemStack;

/**
 * Interface indicating the category of the module.<br>
 * If implemented, it is automatically used for HUD display.
 * 
 * @author	licht
 */
public interface IArmorModuleHasCategory extends IArmorModule
{
	IModuleCategory getModuleCategory (ItemStack stack);
	
	interface IModuleCategory
	{
		/**
		 * @return color code ( not include opacity )
		 */
		int getCategoryColor ();
	}
	
	enum EnumModuleCategory implements IModuleCategory
	{
		NONE(0xFFFFFF),
		POWER_ASSIST(0x8000FF),
		PROTECTOR(0x00FF00),
		WEAPON(0xFF0000),
		FUNC_EXPANSION(0xFF8000);
		
		private final int color;
		
		EnumModuleCategory (int color)
		{
			this.color = color;
		}
		
		@Override
		public int getCategoryColor ()
		{
			return this.color;
		}
	}
}