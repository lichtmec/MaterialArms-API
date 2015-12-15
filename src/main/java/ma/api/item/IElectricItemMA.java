package ma.api.item;

import net.minecraft.item.*;

public interface IElectricItemMA
{
	public boolean isElectricItemMA (ItemStack stack);
	
	public long getMaxChargeMAEU (ItemStack stack);
	
	public boolean isAcceptCharge (ItemStack stack);
	
	public boolean useCustomTag (ItemStack stack);
	
	public String getTagCharge (ItemStack stack);
}