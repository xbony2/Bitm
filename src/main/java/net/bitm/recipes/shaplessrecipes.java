package net.bitm.recipes;

import net.bitm.bonytechmod;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class shaplessrecipes {
	public static void registerrecipes(){
	
		rodrecipes.registerRodRecipes();
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 5), new Object[]{	
			new ItemStack(bonytechmod.ironbitcoin)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 5), new Object[]{
			new ItemStack(bonytechmod.goldbitcoin)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 5), new Object[]{
			new ItemStack(bonytechmod.diamondbitcoin)});
		/*
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.redstonestick, 16), new Object[]{
			new ItemStack(bonytechmod.stickcarver), new ItemStack(Blocks.redstone_block)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.lapisstick, 16), new Object[]{
			new ItemStack(bonytechmod.stickcarver), new ItemStack(Blocks.lapis_block)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.quartzstick,16), new Object[]{
			new ItemStack(bonytechmod.stickcarver), new ItemStack(Blocks.quartz_block)});
		
		GameRegistry.addShapelessRecipe(new ItemStack (bonytechmod.nytstick, 16), new Object[]{
			new ItemStack(bonytechmod.stickcarver), new ItemStack(bonytechmod.nytblock)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.vicestick, 16), new Object[]{
			new ItemStack(bonytechmod.stickcarver), new ItemStack(bonytechmod.viceblock)});*/
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.bonyiumingot, 2), new Object[]{
			new ItemStack(Items.iron_ingot), new ItemStack(Items.bone), new ItemStack(Items.coal)});
		//TEMP. RECIPE DOWN THERE
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.irongravel), new Object[]{
			new ItemStack(Items.iron_ingot), new ItemStack(Blocks.gravel)});
       
	}
}
