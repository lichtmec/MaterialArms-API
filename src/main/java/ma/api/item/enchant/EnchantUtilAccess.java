package ma.api.item.enchant;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public final class EnchantUtilAccess
{
	private static IEnchantUtil utilInstance;

	public static EnchantState getEnchantState (ItemStack stack, EnchantDefine enchant)
	{
		return utilInstance.getEnchantState(stack, enchant);
	}

	public static List<EnchantState> getEnchantmentList (ItemStack stack)
	{
		return utilInstance.getEnchantmentList(stack);
	}

	public static boolean checkAreHaveEnchant (ItemStack stack, EnchantDefine enchant)
	{
		return utilInstance.checkAreHaveEnchant(stack, enchant);
	}

	public static ItemStack applyEnchantment (ItemStack stack, EnchantDefine enchant)
	{
		return utilInstance.applyEnchantment(stack, enchant);
	}

	public static int getStoredMana (ItemStack stack)
	{
		return utilInstance.getStoredMana(stack, null);
	}

	public static int getStoredMana (ItemStack stack, EntityPlayer player)
	{
		return utilInstance.getStoredMana(stack, player);
	}

	public static void dischargeMana (ItemStack stack, int amount)
	{
		utilInstance.dischargeMana(stack, null, amount);
	}

	public static void dischargeMana (ItemStack stack, EntityPlayer player, int amount)
	{
		utilInstance.dischargeMana(stack, player, amount);
	}

	public static void chargeMana (ItemStack stack, int amount)
	{
		utilInstance.chargeMana(stack, null, amount);
	}

	public static void chargeMana (ItemStack stack, EntityPlayer player, int amount)
	{
		utilInstance.chargeMana(stack, player, amount);
	}

	public interface IEnchantUtil
	{
		EnchantState getEnchantState (ItemStack stack, EnchantDefine enchant);

		List<EnchantState> getEnchantmentList (ItemStack stack);

		boolean checkAreHaveEnchant (ItemStack stack, EnchantDefine enchant);

		ItemStack applyEnchantment (ItemStack stack, EnchantDefine enchant);

		int getStoredMana (ItemStack stack, EntityPlayer player);

		void dischargeMana (ItemStack stack, EntityPlayer player, int amount);

		void chargeMana (ItemStack stack, EntityPlayer player, int amount);
	}
}