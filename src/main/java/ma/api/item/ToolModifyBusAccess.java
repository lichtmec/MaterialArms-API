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

/**
 * Methods for exert Customize and Enchantment.
 * Call from each method of Item-class.
 *
 * @see	net.minecraft.item.Item
 *
 * @author	licht
 */
public final class ToolModifyBusAccess
{
	private static ICustomBus CUSTOM_BUS;
	private static IEnchantBus ENCHANT_BUS;

	public static class Custom
	{
		/**
		 * Item#addInformation
		 *
		 * @param stack		arg.1
		 * @param display	arg.3
		 */
		public static void addInformation (ItemStack stack, List display)
		{
			CUSTOM_BUS.addInformation(stack, display);
		}

		/**
		 * Item#onUpdate
		 *
		 * @param itemstack	arg.1
		 * @param player	arg.3
		 */
		public static void onUpdate (ItemStack itemstack, EntityPlayer player)
		{
			CUSTOM_BUS.onUpdate(itemstack, player);
		}

		/**
		 * Before attack to entity.<br>
		 * ex) Item#onLeftClickEntity
		 *
		 * @param itemstack	(onLeftClickEntity : arg.1)
		 * @param player	(onLeftClickEntity : arg.2)
		 * @param entity	(onLeftClickEntity : arg.3)
		 */
		public static void onAttack_Before (ItemStack itemstack, EntityPlayer player, Entity entity)
		{
			CUSTOM_BUS.onAttack_Before(itemstack, player, entity);
		}

		/**
		 * After attack to entity.<br>
		 * ex) Item#hitEntity
		 *
		 * @param itemstack	(hitEntity : arg.1)
		 * @param player	(hitEntity : arg.3)
		 * @param entity	(hitEntity : arg.2)
		 */
		public static void onAttack_After (ItemStack itemstack, EntityPlayer player, Entity entity)
		{
			CUSTOM_BUS.onAttack_After(itemstack, player, entity);
		}

		/**
		 * Good luck!
		 *
		 * @param itemstack	stack of tool
		 * @param player	attacker
		 * @param entity	attacked entity
		 *
		 * @return	amount of damage-boost
		 */
		public static float getDamageBoost (ItemStack itemstack, EntityPlayer player, Entity entity)
		{
			return CUSTOM_BUS.getDamageBoost(itemstack, player, entity);
		}

		/**
		 * Good luck!
		 *
		 * @param itemstack	stack of tool
		 * @param player	attacker
		 * @param entity	attacked entity
		 *
		 * @return	amount of damage-gain
		 */
		public static float getDamageGain (ItemStack itemstack, EntityPlayer player, Entity entity)
		{
			return CUSTOM_BUS.getDamageGain(itemstack,player, entity);
		}

		/**
		 * Good luck!
		 *
		 * @param itemstack	stack of tool
		 *
		 * @return	amount of durability-gain
		 */
		public static double getDurabilityGain (ItemStack itemstack)
		{
			return CUSTOM_BUS.getDurabilityGain(itemstack);
		}

		/**
		 * Item#getDigSpeed<br>
		 * ex) ({tool dig-speed} + <b>DigSpeedBoost</b>) * DigSpeedGain
		 *
		 * @param itemstack	arg.1
		 *
		 * @return	amount of digspeed-boost
		 */
		public static float getDigSpeedBoost (ItemStack itemstack)
		{
			return CUSTOM_BUS.getDigSpeedBoost(itemstack);
		}

		/**
		 * Item#getDigSpeed<br>
		 * ex) ({tool dig-speed} + DigSpeedBoost) * <b>DigSpeedGain</b>
		 *
		 * @param itemstack	arg.1
		 *
		 * @return	amount of digspeed-gain
		 */
		public static float getDigSpeedGain (ItemStack itemstack)
		{
			return CUSTOM_BUS.getDigSpeedGain(itemstack);
		}

		/**
		 * Item#getHarvestLevel
		 *
		 * @param itemstack	arg.1
		 *
		 * @return	amount of harvestlevel-boost
		 */
		public static int getHLBoost (ItemStack itemstack)
		{
			return CUSTOM_BUS.getHLBoost(itemstack);
		}

		/**
		 * ISpecialArmor#getProperties
		 *
		 * @param player	arg.1
		 * @param armor		arg.2
		 * @param source	arg.3
		 * @param damage	arg.4
		 *
		 * @return	sum of RgsistProperty
		 */
		public static IModifiProperty.ResistProperty getResistProperty (EntityLivingBase player, ItemStack armor, DamageSource source, float damage)
		{
			return CUSTOM_BUS.getResistProperty(player, armor, source, damage);
		}

		/**
		 * It is automatically called when implement the ICustomableItemMA.<br>
		 * Normally, it is not necessary to call from the add-on side .
		 */
		public static void onEntityLivingAttacked (ItemStack itemstack, LivingAttackEvent event)
		{
			CUSTOM_BUS.onEntityLivingAttacked(itemstack, event);
		}

		/**
		 * It is automatically called when implement the ICustomableItemMA.<br>
		 * Normally, it is not necessary to call from the add-on side .
		 */
		public static void onEntityLivingFall (ItemStack itemstack, LivingFallEvent event)
		{
			CUSTOM_BUS.onEntityLivingFall(itemstack, event);
		}

		/**
		 * It is automatically called when implement the ICustomableItemMA.<br>
		 * Normally, it is not necessary to call from the add-on side .
		 */
		public static void onEntityLivingHurt (ItemStack itemstack, LivingHurtEvent event)
		{
			CUSTOM_BUS.onEntityLivingHurt(itemstack, event);
		}

		/**
		 * IEnchantableItemMA#getRuneCapacity
		 *
		 * @param itemstack	arg.1
		 *
		 * @return	amount of runecapacity-boost
		 */
		public static int getRuneCapacityBoost (ItemStack itemstack)
		{
			return CUSTOM_BUS.getRuneCapacityBoost(itemstack);
		}

		/**
		 * IEnchantableItemMA#getManaCapacity
		 *
		 * @param itemstack	arg.1
		 *
		 * @return	amount of manacapacity-boost
		 */
		public static int getManaCapacityBoost (ItemStack itemstack)
		{
			return CUSTOM_BUS.getManaCapacityBoost(itemstack);
		}
	}

	public static class Enchant
	{
		/**
		 * Item#addInformation
		 *
		 * @param stack		arg.1
		 * @param display	arg.3
		 */
		public static void addInformation (ItemStack stack, List display)
		{
			ENCHANT_BUS.addInformation(stack, display);
		}

		/**
		 * Item#onUpdate
		 *
		 * @param itemstack	arg.1
		 * @param player	arg.3
		 */
		public static void onUpdate (ItemStack itemstack, EntityPlayer player)
		{
			ENCHANT_BUS.onUpdate(itemstack, player);
		}

		/**
		 * Before attack to entity.<br>
		 * ex) Item#onLeftClickEntity
		 *
		 * @param itemstack	(onLeftClickEntity : arg.1)
		 * @param player	(onLeftClickEntity : arg.2)
		 * @param entity	(onLeftClickEntity : arg.3)
		 *
		 * @return	boosted damage-amount etc.
		 */
		public static AttackResult onAttack_Before (ItemStack itemstack, EntityPlayer player, Entity entity, DamageSource source, float damage)
		{
			return ENCHANT_BUS.onAttack_Before(itemstack, player, entity, source, damage);
		}

		/**
		 * After attack to entity.<br>
		 * ex) Item#hitEntity
		 *
		 * @param itemstack	(hitEntity : arg.1)
		 * @param player	(hitEntity : arg.3)
		 * @param entity	(hitEntity : arg.2)
		 */
		public static void onAttack_After (ItemStack itemstack, EntityPlayer player, Entity entity)
		{
			ENCHANT_BUS.onAttack_After(itemstack, player, entity);
		}

		/**
		 * Item#getDigSpeed
		 *
		 * @param itemstack	arg.1
		 * @param block		arg.2
		 * @param defaultSpeed	default digspeed(Already applied a correction by the Customize)
		 *
		 * @return	amount of digspeed-boost
		 */
		public static float getDigSpeed (ItemStack itemstack, Block block, float defaultSpeed)
		{
			return ENCHANT_BUS.getDigSpeed(itemstack, block, defaultSpeed);
		}

		/**
		 * Item#onBlockDestroyed
		 *
		 * @param itemstack	arg.1
		 * @param block		arg.3
		 * @param world		arg.2
		 * @param x			arg.4
		 * @param y			arg.5
		 * @param z			arg.6
		 */
		public static void onBlockDestroy (ItemStack itemstack, Block block, World world, int x, int y, int z)
		{
			ENCHANT_BUS.onBlockDestroy(itemstack, block, world, x, y, z);
		}

		/**
		 * Hook to the durability consumes.
		 *
		 * @param itemstack	used stack
		 * @param consume	default consume
		 *
		 * @return	corrected consumes
		 */
		public static long getConsumeDurability (ItemStack itemstack, long consume)
		{
			return ENCHANT_BUS.getConsumeDurability(itemstack, consume);
		}

		/**
		 * Item#getHarvestLevel
		 *
		 * @param itemstack	arg.1
		 * @param defaultHL	default harvestlevel(Already applied a correction by the Customize)
		 *
		 * @return	corrected harvestlevel
		 */
		public static int getHarvestLevel (ItemStack itemstack, int defaultHL)
		{
			return ENCHANT_BUS.getHarvestLevel(itemstack, defaultHL);
		}

		/**
		 * ISpecialArmor#getProperties
		 *
		 * @param player	arg.1
		 * @param itemstack	arg.2
		 * @param source	arg.3
		 * @param damage	arg.4
		 *
		 * @return	sum of RgsistProperty
		 */
		public static IModifiProperty.ResistProperty getResistProperty (EntityLivingBase player, ItemStack itemstack, DamageSource source, float damage)
		{
			return ENCHANT_BUS.getResistProperty(player, itemstack, source, damage);
		}

		/**
		 * Item#onEntitySwing
		 *
		 * @param player	arg.2
		 * @param itemstack	arg.1
		 */
		public static void onItemSwing (EntityLivingBase player, ItemStack itemstack)
		{
			ENCHANT_BUS.onItemSwing(player, itemstack);
		}

		/**
		 * It is automatically called when implement the IEnchantableItemMA.<br>
		 * Normally, it is not necessary to call from the add-on side .
		 */
		public static void onEntityLivingAttacked (ItemStack itemstack, LivingAttackEvent event)
		{
			ENCHANT_BUS.onEntityLivingAttacked(itemstack, event);
		}

		/**
		 * It is automatically called when implement the IEnchantableItemMA.<br>
		 * Normally, it is not necessary to call from the add-on side .
		 */
		public static void onEntityLivingFall (ItemStack itemstack, LivingFallEvent event)
		{
			ENCHANT_BUS.onEntityLivingFall(itemstack, event);
		}

		/**
		 * It is automatically called when implement the IEnchantableItemMA.<br>
		 * Normally, it is not necessary to call from the add-on side .
		 */
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

		void onItemSwing (EntityLivingBase player, ItemStack itemstack);

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