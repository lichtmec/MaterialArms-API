package ma.api.tileentity;

public interface ITileDamageable
{
	boolean addDamage (long damage);
	
	void setDurability (long durability);
	
	long getDurability ();
	
	long getMaxDurability ();
}