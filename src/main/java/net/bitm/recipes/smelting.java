package net.bitm.recipes;

import net.bitm.bonytechmod;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class smelting {
	public static void registersmeltingstuff(){
		GameRegistry.addSmelting(bonytechmod.nytore, new ItemStack(bonytechmod.nyt), 0.6F);
		GameRegistry.addSmelting(bonytechmod.viceore, new ItemStack(bonytechmod.vice), 0.4F);
		GameRegistry.addSmelting(bonytechmod.stonedust, new ItemStack(Blocks.stone), 0.1F);
		GameRegistry.addSmelting(bonytechmod.irondust, new ItemStack(Items.iron_ingot), 0.7F);
		GameRegistry.addSmelting(bonytechmod.diamonddust, new ItemStack(Items.diamond), 1.0F);
		GameRegistry.addSmelting(bonytechmod.golddust, new ItemStack(Items.gold_ingot), 1.0F);
		GameRegistry.addSmelting(bonytechmod.emeralddust, new ItemStack(Items.emerald), 1.0F);
		GameRegistry.addSmelting(bonytechmod.lapisdust, new ItemStack(Items.dye, 1, 4), 0.2F);
		GameRegistry.addSmelting(bonytechmod.quartzdust, new ItemStack(Items.quartz), 0.2F);
		GameRegistry.addSmelting(bonytechmod.nytdust, new ItemStack(bonytechmod.nyt), 0.6F);
		GameRegistry.addSmelting(bonytechmod.vicedust, new ItemStack(bonytechmod.vicedust), 0.4F);
		GameRegistry.addSmelting(bonytechmod.coaldust, new ItemStack(Items.coal), 0.1F);
		
	}
}
