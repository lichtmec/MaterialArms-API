package ma.api.item;

import java.lang.reflect.*;
import java.util.*;

import net.minecraft.item.*;

public class ImplementToolRegister
{
	@SuppressWarnings("all")
	public static void registerWrench (ItemStack item)
	{
		getImplementList("implementList_Wrench").add(item);
	}

	@SuppressWarnings("all")
	public static void registerWrench (ArrayList<ItemStack> items)
	{
		getImplementList("implementList_Wrench").addAll(items);
	}

	@SuppressWarnings("all")
	public static void registerHammer (ItemStack item)
	{
		getImplementList("implementList_Hammer").add(item);
	}

	@SuppressWarnings("all")
	public static void registerHammer (ArrayList<ItemStack> items)
	{
		getImplementList("implementList_Hammer").addAll(items);
	}

	@SuppressWarnings("all")
	public static void registerScrewdriver (ItemStack item)
	{
		getImplementList("implementList_Screwdriver").add(item);
	}

	@SuppressWarnings("all")
	public static void registerScrewdriver (ArrayList<ItemStack> items)
	{
		getImplementList("implementList_Screwdriver").addAll(items);
	}

	@SuppressWarnings("all")
	public static void registerMetalFile (ItemStack item)
	{
		getImplementList("implementList_MetalFile").add(item);
	}

	@SuppressWarnings("all")
	public static void registerMetalFile (ArrayList<ItemStack> items)
	{
		getImplementList("implementList_MetalFile").addAll(items);
	}

	@SuppressWarnings("all")
	public static void registerChisel (ItemStack item)
	{
		getImplementList("implementList_Chisel").add(item);
	}

	@SuppressWarnings("all")
	public static void registerChisel (ArrayList<ItemStack> items)
	{
		getImplementList("implementList_Chisel").addAll(items);
	}

	@SuppressWarnings("all")
	public static void registerSaw (ItemStack item)
	{
		getImplementList("implementList_Saw").add(item);
	}

	@SuppressWarnings("all")
	public static void registerSaw (ArrayList<ItemStack> items)
	{
		getImplementList("implementList_Saw").addAll(items);
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<ItemStack> getImplementList (String name)
	{
		try
		{
			Field field = MAItems.getItemClass().getField(name);
			
			return (ArrayList<ItemStack>)field.get(null);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}

		return null;
	}
}