package ma.api.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;

public final class ToolModifyBusAccess
{
	private static ICustomBus CUSTOM_BUS;
	private static IEnchantBus ENCHANT_BUS;

	public static class Custom
	{
		public static void addInformation (ItemStack stack, List display)
		{
			CUSTOM_BUS.addInformation(stack, display);
		}

		public static void onUpdate (ItemStack itemstack, EntityPlayer player)
		{
			CUSTOM_BUS.onUpdate(itemstack, player);
		}

		public static void onAttack_Before (ItemStack itemstack, EntityPlayer player, Entity entity)
		{
			CUSTOM_BUS.onAttack_Before(itemstack, player, entity);
		}

		public static void onAttack_After (ItemStack itemstack, EntityPlayer player, Entity entity)
		{
			CUSTOM_BUS.onAttack_After(itemstack, player, entity);
		}

		public static float getDamageBoost (ItemStack itemstack, EntityPlayer player, Entity entity)
		{
			return CUSTOM_BUS.getDamageBoost(itemstack, player, entity);
		}

		public static float getDamageGain (ItemStack itemstack, EntityPlayer player, Entity entity)
		{
			return CUSTOM_BUS.getDamageGain(itemstack,player, entity);
		}

		public static double getDurabilityGain (ItemStack itemstack)
		{
			return CUSTOM_BUS.getDurabilityGain(itemstack);
		}

		public static float getDigSpeedBoost (ItemStack itemstack)
		{
			return CUSTOM_BUS.getDigSpeedBoost(itemstack);
		}

		public static float getDigSpeedGain (ItemStack itemstack)
		{
			return CUSTOM_BUS.getDigSpeedGain(itemstack);
		}

		public static int getHLBoost (ItemStack itemstack)
		{
			return CUSTOM_BUS.getHLBoost(itemstack);
		}

		public static IModifiProperty.ResistProperty getResistProperty (EntityLivingBase player, ItemStack armor, DamageSource source, float damage)
		{
			return CUSTOM_BUS.getResistProperty(player, armor, source, damage);
		}

		public static void onEntityLivingAttacked (ItemStack itemstack, LivingAttackEvent event)
		{
			CUSTOM_BUS.onEntityLivingAttacked(itemstack, event);
		}

		public static void onEntityLivingFall (ItemStack itemstack, LivingFallEvent event)
		{
			CUSTOM_BUS.onEntityLivingFall(itemstack, event);
		}

		public static void onEntityLivingHurt (ItemStack itemstack, LivingHurtEvent event)
		{
			CUSTOM_BUS.onEntityLivingHurt(itemstack, event);
		}

		public static int getRuneCapacityBoost (ItemStack itemstack)
		{
			return CUSTOM_BUS.getRuneCapacityBoost(itemstack);
		}

		public static int getManaCapacityBoost (ItemStack itemstack)
		{
			return CUSTOM_BUS.getManaCapacityBoost(itemstack);
		}
	}

	public static class Enchant
	{
		public static void addInformation (ItemStack stack, List display)
		{
			ENCHANT_BUS.addInformation(stack, display);
		}

		public static void onUpdate (ItemStack itemstack, EntityPlayer player)
		{
			ENCHANT_BUS.onUpdate(itemstack, player);
		}

		public static AttackResult onAttack_Before (ItemStack itemstack, EntityPlayer player, Entity entity, DamageSource source, float damage)
		{
			return ENCHANT_BUS.onAttack_Before(itemstack, player, entity, source, damage);
		}

		public static void onAttack_After (ItemStack itemstack, EntityPlayer player, Entity entity)
		{
			ENCHANT_BUS.onAttack_After(itemstack, player, entity);
		}

		public static float getDigSpeed (ItemStack itemstack, Block block, float defaultSpeed)
		{
			return ENCHANT_BUS.getDigSpeed(itemstack, block, defaultSpeed);
		}

		public static void onBlockDestroy (ItemStack itemstack, Block block, World world, int x, int y, int z)
		{
			ENCHANT_BUS.onBlockDestroy(itemstack, block, world, x, y, z);
		}

		public static long getConsumeDurability (ItemStack itemstack, long consume)
		{
			return ENCHANT_BUS.getConsumeDurability(itemstack, consume);
		}

		public static int getHarvestLevel (ItemStack itemstack, int defaultHL)
		{
			return ENCHANT_BUS.getHarvestLevel(itemstack, defaultHL);
		}

		public static IModifiProperty.ResistProperty getResistProperty (EntityLivingBase player, ItemStack itemstack, DamageSource source, float damage)
		{
			return ENCHANT_BUS.getResistProperty(player, itemstack, source, damage);
		}

		public static void onEntityLivingAttacked (ItemStack itemstack, LivingAttackEvent event)
		{
			ENCHANT_BUS.onEntityLivingAttacked(itemstack, event);
		}

		public static void onEntityLivingFall (ItemStack itemstack, LivingFallEvent event)
		{
			ENCHANT_BUS.onEntityLivingFall(itemstack, event);
		}

		public static void onEntityLivingHurt (ItemStack itemstack, LivingHurtEvent event)
		{
			ENCHANT_BUS.onEntityLivingHurt(itemstack, event);
		}
	}

	public interface ICustomBus
	{
		void addInformation (ItemStack stack, List display);

		void onUpdate (ItemStack itemstack, EntityPlayer player);

		void onAttack_Before (ItemStack itemstack, EntityPlayer player, Entity entity);

		void onAttack_After (ItemStack itemstack, EntityPlayer player, Entity entity);

		float getDamageBoost (ItemStack itemstack, EntityPlayer player, Entity entity);

		float getDamageGain (ItemStack itemstack, EntityPlayer player, Entity entity);

		double getDurabilityGain (ItemStack itemstack);

		float getDigSpeedBoost (ItemStack itemstack);

		float getDigSpeedGain (ItemStack itemstack);

		int getHLBoost (ItemStack itemstack);

		IModifiProperty.ResistProperty getResistProperty (EntityLivingBase player, ItemStack armor, DamageSource source, float damage);

		void onEntityLivingAttacked (ItemStack itemstack, LivingAttackEvent event);

		void onEntityLivingFall (ItemStack itemstack, LivingFallEvent event);

		void onEntityLivingHurt (ItemStack itemstack, LivingHurtEvent event);

		int getRuneCapacityBoost (ItemStack itemstack);

		int getManaCapacityBoost (ItemStack itemstack);
	}

	public interface IEnchantBus
	{
		void addInformation (ItemStack stack, List display);

		void onUpdate (ItemStack itemstack, EntityPlayer player);

		AttackResult onAttack_Before (ItemStack itemstack, EntityPlayer player, Entity entity, DamageSource source, float damage);

		void onAttack_After (ItemStack itemstack, EntityPlayer player, Entity entity);

		float getDigSpeed (ItemStack itemstack, Block block, float defaultSpeed);

		void onBlockDestroy (ItemStack itemstack, Block block, World world, int x, int y, int z);

		long getConsumeDurability (ItemStack itemstack, long consume);

		int getHarvestLevel (ItemStack itemstack, int defaultHL);

		IModifiProperty.ResistProperty getResistProperty (EntityLivingBase player, ItemStack itemstack, DamageSource source, float damage);

		void onEntityLivingAttacked (ItemStack itemstack, LivingAttackEvent event);

		void onEntityLivingFall (ItemStack itemstack, LivingFallEvent event);

		void onEntityLivingHurt (ItemStack itemstack, LivingHurtEvent event);
	}

	public static class AttackResult
	{
		public boolean canceled;
		public float damage;

		public boolean setCrit;
		public boolean cancelCrit;

		public AttackResult (float damage)
		{
			this.canceled = false;
			this.damage = damage;
		}

		public AttackResult setCanceled ()
		{
			this.canceled = true;

			return this;
		}

		public void setCritical ()
		{
			this.setCrit = true;
		}

		public void cancelCritical ()
		{
			this.cancelCrit = true;
		}
	}
}