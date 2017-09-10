package ma.api.item.enchant;

import ma.api.item.ModConform;
import ma.api.item.IPropEnchant;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

/**
 * MA-Enchant definication class.
 *
 * @author licht
 */
public class EnchantDefine
{
	public IPropEnchant prop;
	public ModConform modInfo;
	public String displayUnlocalized;

	public EnchantDefine (ModConform modInfo, String displayUnlocalized, IPropEnchant prop)
	{
		this.prop = prop;
		this.modInfo = modInfo;
		this.displayUnlocalized = displayUnlocalized;
	}

	public String getDisplayName ()
	{
		return StatCollector.translateToLocal(this.displayUnlocalized);
	}

	@Override
	public String toString ()
	{
		return this.displayUnlocalized;
	}
}
