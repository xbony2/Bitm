package net.bitm.gui;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class OreRecipes {

	public static final FurnaceRecipes originalRecipes = FurnaceRecipes.smelting();
	
	public static void addRecipe(Block block, ItemStack itemstack, float xp){
		originalRecipes.func_151393_a(block, itemstack, xp);
	}
	
	public static void overrideStuff(Block block, ItemStack itemstack, float xp){
		originalRecipes.func_151393_a(block, itemstack, xp);
	}
	
	public static FurnaceRecipes getRecipes(){
		return originalRecipes;
	}
}
