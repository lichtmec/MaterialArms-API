package ma.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import ma.api.MaterialArmsAPI;
import ma.api.entity.AbstractEntityArrowComposite;
import ma.api.item.IArrowComposite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;

/**
 * Event of CompositeBow.<br>
 * It is being posted separately in the Start and ConstructEntity.
 *
 * @author	licht
 */
public class CompositeBowShotEvent extends PlayerEvent
{
	protected ItemStack shotArrowStack;

	private CompositeBowShotEvent (EntityPlayer player, ItemStack shotArrowStack)
	{
		super(player);

		this.shotArrowStack = shotArrowStack;
	}

	public ItemStack getArrowStack ()
	{
		return this.shotArrowStack;
	}

	/**
	 * It is posted prior to generating the arrow entity.<br>
	 * If replace the arrowStack, arrows entity is generated from the arrowStack after replacing.
	 *
	 * @author	licht
	 */
	@Cancelable
	public static final class Start extends CompositeBowShotEvent
	{
		protected boolean consumeArrow;

		public Start (EntityPlayer player, ItemStack arrowStack, boolean consumeArrow)
		{
			super(player, arrowStack);

			this.consumeArrow = consumeArrow;
		}

		public void replaceArrowStack (ItemStack arrowStack)
		{
			if (arrowStack == null || !(arrowStack.getItem() instanceof IArrowComposite))
			{
				MaterialArmsAPI.sendLogError("Failure to replace the arrow. This is not a stack of arrow.");
				return;
			}
			if (!((IArrowComposite)arrowStack.getItem()).canUseToCompositeBow(arrowStack))
			{
				MaterialArmsAPI.sendLogInfo("Failure to replace the arrow. This can't be used as an arrow.");
				return;
			}

			this.shotArrowStack = arrowStack;
		}

		public boolean isConsumeArrow ()
		{
			return this.consumeArrow;
		}

		public void setIsConsumeArrow (boolean isConsumeArrow)
		{
			this.consumeArrow = isConsumeArrow;
		}
	}

	/**
	 * This event is posted after the arrow entity has been generated.<br>
	 * By replacing the arrow entity, it is possible to hammer out an arrow entity different in the existing arrow-items.
	 *
	 * @author	licht
	 */
	@Cancelable
	public static final class ConstructEntity extends CompositeBowShotEvent
	{
		protected AbstractEntityArrowComposite shotArrowEntity;

		public ConstructEntity (EntityPlayer player, AbstractEntityArrowComposite shotArrowEntity, ItemStack arrowStack)
		{
			super(player, arrowStack);

			this.shotArrowEntity = shotArrowEntity;
		}

		public AbstractEntityArrowComposite getArrowEntity ()
		{
			return this.shotArrowEntity;
		}

		public void replaceArrowEntity (AbstractEntityArrowComposite arrowEntity)
		{
			this.shotArrowEntity = arrowEntity;
		}
	}
}