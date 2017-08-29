package ma.api.enchant;

import ma.api.item.ModConform;
import ma.api.item.IPropEnchant;
import net.minecraft.item.ItemStack;

/**
 * MA-Enchant definication class.
 *
 * @author licht
 */
public class EnchantDefine
{
	public IPropEnchant prop;
	public ModConform modInfo;
	public String display;

	public EnchantDefine (ModConform modInfo, String display, IPropEnchant prop)
	{
		this.prop = prop;
		this.modInfo = modInfo;
		this.display = display;
	}

	public String toString (ItemStack stack)
	{
		return "Enchant/" + display;
	}
}
