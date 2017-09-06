package ma.api.entity;

import ma.api.item.IArrowComposite;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEntityArrowComposite extends EntityArrow
{
	private boolean init = false;

	public Entity shooter;
	public ItemStack bowStack;
	public ItemStack arrowStack;
	public boolean isCritical;

	private List<ProjectileEnchantState> appliedEnchantList;

	public AbstractEntityArrowComposite (World world)
	{
		super(world);

		setSize(0.3F, 0.3F);
		this.yOffset = 0F;

		this.appliedEnchantList = new ArrayList<>();
	}

	public AbstractEntityArrowComposite (World world, Entity shooter, ItemStack bosStack, ItemStack arrowStack, float power)
	{
		this(world);

		this.shooter = shooter;
		this.arrowStack = arrowStack;
		if (!world.isRemote && !this.checkValidArrow())
		{
			this.setDead();
		}

		setStartPositionFromShooter(shooter);
		setStartMotionFromShooter(shooter);
		setThrowableHeading(this.motionX, this.motionY, this.motionZ, power * getStartSpeed(), 1F);
	}

	protected float getStartSpeed ()
	{
		return 1.2F;
	}

	@Override
	protected void entityInit ()
	{
		super.entityInit();

		// Add ItemStack object (Arrow stack info)
		this.dataWatcher.addObjectByDataType(16, 5);
	}

	protected void setArrowItemStack (ItemStack arrowStack)
	{
		this.init = true;
		this.dataWatcher.updateObject(16, arrowStack);
	}

	@Override
	public void onUpdate ()
	{
		super.onEntityUpdate();

		if (!this.init && !this.worldObj.isRemote)
		{
			this.setArrowItemStack(this.arrowStack);
		}
	}

	@Override
	public void readEntityFromNBT (NBTTagCompound nbt)
	{
		if (nbt.hasKey("arrowStack"))
		{
			this.arrowStack = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("arrowStack"));
		}
		else
		{
			this.arrowStack = null;
		}

		this.isCritical = nbt.getBoolean("isCrit");
	}

	@Override
	public void writeEntityToNBT (NBTTagCompound nbt)
	{
		if (this.arrowStack != null)
		{
			NBTTagCompound stackNbt = new NBTTagCompound();
			this.arrowStack.writeToNBT(stackNbt);
			nbt.setTag("arrowStack", stackNbt);
		}

		nbt.setBoolean("isCrit", this.isCritical);
	}

	@Override
	public void setThrowableHeading (double motionX, double motionY, double motionZ, float speedGain, float shake)
	{
		this.motionX *= speedGain;
		this.motionY *= speedGain;
		this.motionZ *= speedGain;
		this.motionX += this.rand.nextGaussian() * (this.rand.nextBoolean() ? 1 : -1) * 0.007499999832361937D * shake;
		this.motionY += this.rand.nextGaussian() * (this.rand.nextBoolean() ? 1 : -1) * 0.007499999832361937D * shake;
		this.motionZ += this.rand.nextGaussian() * (this.rand.nextBoolean() ? 1 : -1) * 0.007499999832361937D * shake;

		float f1 = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
		this.prevRotationYaw	= this.rotationYaw		= (float)(Math.atan2(this.motionX, this.motionZ) * 180D / Math.PI);
		this.prevRotationPitch	= this.rotationPitch	= (float)(Math.atan2(this.motionY, (double)f1) * 180D / Math.PI);
	}

	public void setStartPositionFromShooter (Entity shooter)
	{
		this.posX = shooter.posX - (double)(MathHelper.cos(shooter.rotationYaw / 180F * (float)Math.PI) * 0.16F);
		this.posY = shooter.posY + (double)shooter.getEyeHeight() - 0.10000000149011612D;
		this.posZ = shooter.posZ - (double)(MathHelper.sin(shooter.rotationYaw / 180F * (float)Math.PI) * 0.16F);
		this.setPosition(this.posX, this.posY, this.posZ);
	}

	public void setStartMotionFromShooter (Entity shooter)
	{
		this.motionX = (double)(-MathHelper.sin(shooter.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(shooter.rotationPitch / 180.0F * (float)Math.PI));
		this.motionZ = (double)(MathHelper.cos(shooter.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(shooter.rotationPitch / 180.0F * (float)Math.PI));
		this.motionY = (double)(-MathHelper.sin(shooter.rotationPitch / 180.0F * (float)Math.PI));
	}

	public void setCritical ()
	{
		this.isCritical = true;
	}

	public boolean checkValidArrow ()
	{
		if (this.arrowStack == null || !(this.arrowStack.getItem() instanceof IArrowComposite) || !((IArrowComposite)this.arrowStack.getItem()).canUseToCompositeBow(this.arrowStack))
		{
			return false;
		}

		return true;
	}

	public void applyEnchantEffect (ProjectileEnchantState enchant)
	{
		if (enchant != null && !this.appliedEnchantList.contains(enchant))
		{
			this.appliedEnchantList.add(enchant);
		}
	}

	public List<ProjectileEnchantState> getAppliedEnchantList ()
	{
		return this.appliedEnchantList;
	}

	public void onFire ()
	{
		for (ProjectileEnchantState enchantState : this.appliedEnchantList)
		{
			enchantState.enchantProp.onFire(enchantState, this);
		}
	}

	public void onHitEntityBefore (Entity hitEntity, boolean willDead)
	{
		for (ProjectileEnchantState enchantState : this.appliedEnchantList)
		{
			enchantState.enchantProp.onHitBefore(enchantState, this, hitEntity, willDead);
		}
	}

	public void onHitEntity (Entity hitEntity, boolean willDead)
	{
		for (ProjectileEnchantState enchantState : this.appliedEnchantList)
		{
			enchantState.enchantProp.onHit(enchantState, this, hitEntity, willDead);
		}
	}

	public void onHitBlock (Block hitBlock, int xCoord, int yCoord, int zCoord, boolean willDead)
	{
		for (ProjectileEnchantState enchantState : this.appliedEnchantList)
		{
			enchantState.enchantProp.onHit(enchantState, this, hitBlock, xCoord, yCoord, zCoord, willDead);
		}
	}
}