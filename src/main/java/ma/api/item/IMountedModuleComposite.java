package ma.api.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.ArrayList;

/**
 * Module property.<br>
 * Process of modules of the same type can be executed collectively.
 *
 * @see IMountedModule
 *
 * @author licht
 */
public interface IMountedModuleComposite
{
	EnumAfterAction onArmorTick (CompositeEventInfo matchedEvent, EntityPlayer player, ItemStack armorStack);

	@SideOnly(Side.CLIENT)
	EnumAfterAction renderHelmetOverlay(CompositeEventInfo matchedEvent, EntityPlayer player, ItemStack armorStack, ScaledResolution resolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY);

	EnumAfterAction onLivingAttacked (CompositeEventInfo matchedEvent, LivingAttackEvent event, ItemStack armorStack);

	EnumAfterAction onLivingFall (CompositeEventInfo matchedEvent, LivingFallEvent event, ItemStack armorStack);

	EnumAfterAction onLivingHurt (CompositeEventInfo matchedEvent, LivingHurtEvent event, ItemStack armorStack);

	interface IMatcher
	{
		boolean isMatch (IMountedModule module, NBTTagCompound moduleData);
	}

	enum EnumAfterAction
	{
		/**
		 * If there is another matching IMatcher, it will also be execute.
		 */
		PROCESS(true, true),
		/**
		 * In this event, Not do any further action as CompositeModule.
		 */
		SKIP_COMPOSITE_MATCHER(false, true),
		/**
		 * In this event, Not do anything after this.
		 */
		SKIP_ALL(false, false);

		public final boolean updateAfterComposite;
		public final boolean updateAfterNormal;

		EnumAfterAction (boolean updateComposite, boolean updateNormal)
		{
			this.updateAfterComposite = updateComposite;
			this.updateAfterNormal = updateNormal;
		}
	}

	class CompositeEventInfo
	{
		public final IMatcher matched;
		public final NBTTagCompound[] matchedModuleData;

		public CompositeEventInfo (IMatcher matched, NBTTagCompound[] matchedModuleData)
		{
			this.matched = matched;
			this.matchedModuleData = matchedModuleData;
		}

		public CompositeEventInfo (IMatcher matched, ArrayList<NBTTagCompound> matchedModuleData)
		{
			this.matched = matched;

			this.matchedModuleData = new NBTTagCompound[matchedModuleData.size()];
			int i = 0;
			for (NBTTagCompound nbtTagCompound : matchedModuleData)
			{
				this.matchedModuleData[i] = nbtTagCompound;
				i++;
			}
		}
	}
}