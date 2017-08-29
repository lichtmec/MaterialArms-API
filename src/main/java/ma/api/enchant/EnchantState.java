package ma.api.enchant;

import net.minecraft.item.ItemStack;

/**
 * MA-Enchant status information.<br>
 * Contain enchant definication and enchant strength.
 *
 * @author licht
 */
public class EnchantState
{
	public EnchantDefine enchant;
	public int lv;

	public EnchantState (EnchantDefine enchant)
	{
		this.enchant = enchant;
	}

	public EnchantState (EnchantDefine enchant, int lv)
	{
		this.enchant = enchant;
		this.lv = lv;
	}

	public String toString (ItemStack stack)
	{
		return "Enchant/" + enchant.display + "  Lv." + lv;
	}
}
