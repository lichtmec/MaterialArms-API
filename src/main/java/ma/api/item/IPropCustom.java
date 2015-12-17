package ma.api.item;

import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.*;

public interface IPropCustom extends IModifiProperty
{
	void onUpdate (ItemStack itemstack, EntityPlayer player);

	void onAttack_Before (ItemStack itemstack, EntityPlayer player, Entity entity);

	void onAttack_After (ItemStack itemstack, EntityPlayer player, Entity entity);

	float getDamageBoost (ItemStack itemstack, EntityPlayer player, Entity entity);

	float getDamageGain (ItemStack itemstack, EntityPlayer player, Entity entity);

	double getDurabilityGain (ItemStack itemstack);

	float getDigSpeedBoost (ItemStack itemstack);

	float getDigSpeedGain (ItemStack itemstack);

	int getHLBoost (ItemStack itemstack);

	ResistProperty getResistProperty (EntityLivingBase player, ItemStack armor, DamageSource source, float damage);

	void onEntityLivingAttacked (ItemStack itemstack, LivingAttackEvent event);

	void onEntityLivingFall (ItemStack itemstack, LivingFallEvent event);

	void onEntityLivingHurt (ItemStack itemstack, LivingHurtEvent event);
	
	int getRuneCapacityBoost (ItemStack itemstack);
	
	int getManaCapacityBoost (ItemStack itemstack);
}
