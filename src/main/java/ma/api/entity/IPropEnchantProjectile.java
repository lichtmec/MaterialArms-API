package ma.api.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;

public interface IPropEnchantProjectile
{
	void onFire (ProjectileEnchantState enchantState, Entity projectileEntity);

	void onHitBefore (ProjectileEnchantState enchantState, Entity projectileEntity, Entity hitEntity, boolean willDead);

	void onHit (ProjectileEnchantState enchantState, Entity projectileEntity, Entity hitEntity, boolean willDead);

	void onHit (ProjectileEnchantState enchantState, Entity projectileEntity, Block hitBlock, int xCoord, int yCoord, int zCoord, boolean willDead);
}