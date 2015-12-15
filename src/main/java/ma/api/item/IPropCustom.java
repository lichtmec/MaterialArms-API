package ma.api.item;

import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.*;

public interface IPropCustom extends IModifiProperty
{
	public void onUpdate (ItemStack itemstack, EntityPlayer player);
	
	public void onAttack_Before (ItemStack itemstack, EntityPlayer player, Entity entity);
	
	public void onAttack_After (ItemStack itemstack, EntityPlayer player, Entity entity);
	
	public float getDamageBoost (ItemStack itemstack, EntityPlayer player, Entity entity);
	
	public float getDamageGain (ItemStack itemstack, EntityPlayer player, Entity entity);
	
	public double getDurabilityGain (ItemStack itemstack);
	
	public float getDigSpeedBoost (ItemStack itemstack);
	
	public float getDigSpeedGain (ItemStack itemstack);
	
	public int getHLBoost (ItemStack itemstack);
	
	public ResistProperty getResistProperty (EntityLivingBase player, ItemStack armor, DamageSource source, float damage);
	
	public void onEntityLivingAttacked (ItemStack itemstack, LivingAttackEvent event);
	
	public void onEntityLivingFall (ItemStack itemstack, LivingFallEvent event);
	
	public void onEntityLivingHurt (ItemStack itemstack, LivingHurtEvent event);
	
	public int getRuneCapacityBoost (ItemStack itemstack);
	
	public int getManaCapacityBoost (ItemStack itemstack);
}
