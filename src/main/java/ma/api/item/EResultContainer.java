package ma.api.item;

/**
 * 
 * Use on MaterialArms's enchant property
 * 
 * @author licht
 *
 */
public class EResultContainer
{
	public int containsMana;
	public int consumeMana;
	
	public int consumeDurability;
	public int consumeDurabilityBoost;
	public float consumeDurabilityGain;
	
	public boolean canceled;
	public float attackDamageBoost;
	public float attackDamageGain;
	
	public float digSpeedBoost;
	public float digSpeedGain;
	
	public int critVote;
	
	public EResultContainer (int cMana)
	{
		this();
		
		this.containsMana = cMana;
	}
	
	public EResultContainer ()
	{
		this.consumeMana = 0;
		
		this.consumeDurability = 0;
		this.consumeDurabilityBoost = 0;
		this.consumeDurabilityGain = 1F;
		
		this.canceled = false;
		this.attackDamageBoost = 0F;
		this.attackDamageGain = 1F;
		
		this.digSpeedBoost = 0F;
		this.digSpeedGain = 1F;
		
		this.critVote = 0;
	}
	
	public void setCanceled (boolean isCanceled)
	{
		this.canceled = isCanceled;
	}
	
	public boolean isEnoughMana (int request)
	{
		return (this.containsMana - (this.consumeMana + request) >= 0);
	}
	
	public void addManaConsume (int consume)
	{
		this.consumeMana += consume;
	}
	
	public void gainManaConsume (float gain)
	{
		this.consumeMana *= gain;
	}
	
	public EResultContainer setBreaking (int cons)
	{
		this.consumeDurability += cons;
		
		return this;
	}
	
	public EResultContainer setDurabilityConsume (int boost, float gain)
	{
		this.consumeDurabilityBoost = boost;
		this.consumeDurabilityGain = gain;
		
		return this;
	}
	
	public EResultContainer setAttackDamage (float boost, float gain)
	{
		this.attackDamageBoost = boost;
		this.attackDamageGain = gain;
		
		return this;
	}
	
	public void addAttackDamageBoost (float boost)
	{
		this.attackDamageBoost += boost;
	}
	
	public void gainAttackDamageBoost (float gain)
	{
		this.attackDamageBoost *= gain;
	}
	
	public void addAttackDamageGain (float boost)
	{
		this.attackDamageGain += boost;
	}
	
	public void gainAttackDamageGain (float gain)
	{
		this.attackDamageGain *= gain;
	}
	
	public EResultContainer setDigSpeed (float boost, float gain)
	{
		this.digSpeedBoost = boost;
		this.digSpeedGain = gain;
		
		return this;
	}
	
	public void addDigSpeedBoost (float boost)
	{
		this.digSpeedBoost += boost;
	}
	
	public void gainDigSpeedBoost (float gain)
	{
		this.digSpeedBoost *= gain;
	}
	
	public void addDigSpeedGain (float boost)
	{
		this.digSpeedGain += boost;
	}
	
	public void gainDigSpeedGain (float gain)
	{
		this.digSpeedGain *= gain;
	}
	
	public EResultContainer voteCritical (boolean isCrit)
	{
		this.critVote += isCrit ? 1 : -1;
		
		return this;
	}
}