package net.bitm.recipes;

import net.bitm.bonytechmod;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class rodrecipes {

	public static void registerRodRecipes(){
		int i=-1;
		while(i<=30){
		i++;
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.stonestick, 16), new Object[]{
			new ItemStack(bonytechmod.stickcarver, 1, i), new ItemStack(Blocks.cobblestone)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.ironstick, 16), new Object[]{
			new ItemStack(bonytechmod.stickcarver, 1, i), new ItemStack(Blocks.iron_block)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.diamondstick, 16), new Object[]{
			new ItemStack(bonytechmod.stickcarver, 1, i), new ItemStack(Blocks.diamond_block)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.emeraldstick, 16), new Object[]{
			new ItemStack(bonytechmod.stickcarver, 1, i), new ItemStack(Blocks.emerald_block)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.goldstick, 16), new Object[]{
			new ItemStack(bonytechmod.stickcarver, 1, i), new ItemStack(Blocks.gold_block)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.glowstonestick, 16), new Object[]{
			new ItemStack(bonytechmod.stickcarver, 1, i), new ItemStack(Blocks.glowstone)});	
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.redstonestick, 16), new Object[]{
			new ItemStack(bonytechmod.stickcarver, 1, i), new ItemStack(Blocks.redstone_block)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.lapisstick, 16), new Object[]{
			new ItemStack(bonytechmod.stickcarver, 1, i), new ItemStack(Blocks.lapis_block)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.quartzstick,16), new Object[]{
			new ItemStack(bonytechmod.stickcarver, 1, i), new ItemStack(Blocks.quartz_block)});
		
		GameRegistry.addShapelessRecipe(new ItemStack (bonytechmod.nytstick, 16), new Object[]{
			new ItemStack(bonytechmod.stickcarver, 1, i), new ItemStack(bonytechmod.nytblock)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonytechmod.vicestick, 16), new Object[]{
			new ItemStack(bonytechmod.stickcarver, 1, i), new ItemStack(bonytechmod.viceblock)});
		}
	}
}
