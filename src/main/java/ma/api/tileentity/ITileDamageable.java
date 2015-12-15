package ma.api.tileentity;

public interface ITileDamageable
{
	public boolean addDamage (long damage);
	
	public void setDurability (long durability);
	
	public long getDurability ();
	
	public long getMaxDurability ();
}