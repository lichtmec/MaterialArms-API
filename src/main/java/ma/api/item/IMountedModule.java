package ma.api.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.*;

public interface IMountedModule
{
	public long getEnergyCapacity (NBTTagCompound moduleData, EntityPlayer player, ItemStack armorStack);
	
	public void onArmorTick (NBTTagCompound moduleData, EntityPlayer player, ItemStack armorStack);
	
	@SideOnly(Side.CLIENT)
	public void renderHelmetOverlay(NBTTagCompound moduleData, EntityPlayer player, ItemStack armorStack, ScaledResolution resolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY);
	
	public void onLivingAttacked (NBTTagCompound moduleData, LivingAttackEvent event, ItemStack armorStack);
	
	public void onLivingFall (NBTTagCompound moduleData, LivingFallEvent event, ItemStack armorStack);
	
	public void onLivingHurt (NBTTagCompound moduleData, LivingHurtEvent event, ItemStack armorStack);
}