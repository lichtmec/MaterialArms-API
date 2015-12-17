package ma.api.item;

import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.DamageSource;
import net.minecraft.world.*;
import net.minecraftforge.event.entity.living.*;

public interface IPropEnchant extends IModifiProperty
{
	int getRuneLoad (ItemStack itemstack, int lv);

	void onUpdate (EResultContainer result, int lv, ItemStack itemstack, EntityPlayer player);

	void onAttack_Before (EResultContainer result, int lv, ItemStack itemstack, EntityPlayer player, Entity entity, DamageSource source, float damage);

	void onAttack_After (EResultContainer result, int lv, ItemStack itemstack, EntityPlayer player, Entity entity);

	int getHLBoost (EResultContainer result, int lv, ItemStack itemstack);

	void strVsBlock (EResultContainer result, int lv, ItemStack itemstack, Block block, float defaultSpeed);

	void onBlockDestroy (EResultContainer result, int lv, ItemStack itemstack, Block block, World world, int x, int y, int z);

	void onConsumeDurability (EResultContainer result, int lv, ItemStack itemstack);

	ResistProperty getResistProperty (EResultContainer result, int lv, EntityLivingBase player, ItemStack armor, DamageSource source, float damage);

	int getManaCollectBoost (ItemStack stack, int lv);

	float getManaCollectGain (ItemStack stack, int lv);

	void onEntityLivingAttacked (EResultContainer result, int lv, ItemStack itemstack, LivingAttackEvent event);

	void onEntityLivingFall (EResultContainer result, int lv, ItemStack itemstack, LivingFallEvent event);

	void onEntityLivingHurt (EResultContainer result, int lv, ItemStack itemstack, LivingHurtEvent event);

	float getManaConsumeGain (ItemStack itemstack, int lv);
}