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
	public int getRuneLoad (ItemStack itemstack, int lv);
	
	public void onUpdate (EResultContainer result, int lv, ItemStack itemstack, EntityPlayer player);
	
	public void onAttack_Before (EResultContainer result, int lv, ItemStack itemstack, EntityPlayer player, Entity entity, DamageSource source, float damage);
	
	public void onAttack_After (EResultContainer result, int lv, ItemStack itemstack, EntityPlayer player, Entity entity);
	
	public int getHLBoost (EResultContainer result, int lv, ItemStack itemstack);
	
	public void strVsBlock (EResultContainer result, int lv, ItemStack itemstack, Block block, float defaultSpeed);
	
	public void onBlockDestroy (EResultContainer result, int lv, ItemStack itemstack, Block block, World world, int x, int y, int z);
	
	public void onConsumeDurability (EResultContainer result, int lv, ItemStack itemstack);
	
	public ResistProperty getResistProperty (EResultContainer result, int lv, EntityLivingBase player, ItemStack armor, DamageSource source, float damage);
	
	public int getManaCollectBoost (ItemStack stack, int lv);
	
	public float getManaCollectGain (ItemStack stack, int lv);
	
	public void onEntityLivingAttacked (EResultContainer result, int lv, ItemStack itemstack, LivingAttackEvent event);
	
	public void onEntityLivingFall (EResultContainer result, int lv, ItemStack itemstack, LivingFallEvent event);
	
	public void onEntityLivingHurt (EResultContainer result, int lv, ItemStack itemstack, LivingHurtEvent event);
	
	public float getManaConsumeGain (ItemStack itemstack, int lv);
}