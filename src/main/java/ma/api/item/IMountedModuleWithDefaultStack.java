package ma.api.item;

import net.minecraft.item.ItemStack;

/**
 * PoweredSuits built before MA 1.0.x does not contain ItemStack info of module.<br>
 * This interface gives alternative info for contents that requires ItemStack info.
 *
 * @author licht
 */
public interface IMountedModuleWithDefaultStack extends IMountedModule
{
	ItemStack getDefaultModuleItem ();
}