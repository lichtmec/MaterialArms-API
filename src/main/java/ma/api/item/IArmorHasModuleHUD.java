package ma.api.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Interface for ItemArmor.<br>
 * Armor modules notify information in another way if HUD not supported.
 *
 * @author licht
 */
public interface IArmorHasModuleHUD
{
	boolean isModuleHUDAvailable (ItemStack armorStack, EntityPlayer player);
}