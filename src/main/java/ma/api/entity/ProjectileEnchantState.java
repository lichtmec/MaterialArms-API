package ma.api.entity;

public final class ProjectileEnchantState
{
	public IPropEnchantProjectile enchantProp;
	public int lv;

	public ProjectileEnchantState (IPropEnchantProjectile enchantProp, int lv)
	{
		this.enchantProp = enchantProp;
		this.lv = lv;
	}
}