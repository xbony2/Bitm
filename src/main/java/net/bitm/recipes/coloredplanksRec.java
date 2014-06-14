package net.bitm.recipes;

import net.bitm.bonytechmod;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class coloredplanksRec {

	public static void registerRecipesPlanks(){
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankBlack), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyeBlack"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankBlue), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyeBlue"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankBrown), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyeBrown"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankCyan), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyeCyan"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankGray), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyeGray"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankGreen), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyeGreen"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankLightBlue), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyeLightBlue"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankLightGray), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyeLightGray"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankLime), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyeLime"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankMagenta), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyeMagenta"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankOrange), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyeOrange"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankPink), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyePink"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankPurple), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyePurple"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankRed), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyeRed"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankWhite), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyeWhite"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.plankYellow), new Object[]{
			"www",
			"wdw",
			"www", 'w', "plankWood", 'd', "dyeYellow"}));
	}
}
