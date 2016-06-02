package ma.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

import java.util.ArrayList;

public abstract class BlockDisassembleEvent extends BlockEvent
{
	protected final ItemStack disassembleTool;

	public BlockDisassembleEvent (int x, int y, int z, World world, Block block, int blockMetadata, ItemStack disassembleTool)
	{
		super(x, y, z, world, block, blockMetadata);

		this.disassembleTool = disassembleTool;
	}

	public ItemStack getDisassembleTool ()
	{
		return this.disassembleTool;
	}

	@Cancelable
	public static class Pre extends BlockDisassembleEvent
	{
		public Pre (int x, int y, int z, World world, Block block, int blockMetadata, ItemStack disassembleTool)
		{
			super(x, y, z, world, block, blockMetadata, disassembleTool);
		}
	}

	public static class Post extends BlockDisassembleEvent
	{
		public ArrayList<ItemStack> drops;

		public Post (int x, int y, int z, World world, Block block, int blockMetadata, ItemStack disassembleTool, ArrayList<ItemStack> drops)
		{
			super(x, y, z, world, block, blockMetadata, disassembleTool);

			this.drops = drops;
		}
	}
}