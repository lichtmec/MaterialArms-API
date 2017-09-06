package ma.api.item.enchant;

import ma.api.entity.ProjectileEnchantState;
import ma.api.item.EResultContainer;
import ma.api.item.IPropEnchant;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public interface IPropEnchantMissileSource extends IPropEnchant
{
	ProjectileEnchantState onFire (EResultContainer result, int lv, ItemStack itemstack, Entity missileEntity, EntityLivingBase shooterEntity);
}