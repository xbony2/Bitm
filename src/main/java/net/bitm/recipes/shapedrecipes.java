package net.bitm.recipes;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.bitm.bonytechmod;
import net.bitm.config.settings;
import net.bitm.items.itembasicbattery;
import cpw.mods.fml.common.registry.GameRegistry;

public class shapedrecipes {
	public static void registerrecipes(){
		
		toolrecipes.registerToolRecipes();
		coloredplanksRec.registerRecipesPlanks();
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.stickcarver), true, new Object[]{
			"  q",
			" q ",
			"s  ", 'q', "gemQuartz", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.stickcarver), new Object[]{
			"q  ",
			" q ",
			"  s", 'q', "gemQuartz", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.nytblock), new Object[]{
		"nnn",
        "nnn",
		"nnn", 'n', "gemNyt"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.viceblock), new Object[]{
		"vvv",
        "vvv",
		"vvv", 'v', "gemVice"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.chromeglass), new Object[]{
			"rdr",
			"lgl",
			"iki", 'g', bonytechmod.clearglass, 'l', "rodGold", 'r', "rodEmerald", 'k', "rodGlowstone", 'd', "rodDiamond", 'i', "rodIron"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.ironbitcoin, 5), new Object[]{
			" i ",
			"iii",
			" i ", 'i', "ingotIron"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.goldbitcoin, 5), new Object[]{
			" g ",
			"ggg",
			" g ", 'g', "ingotGold"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.diamondbitcoin, 5), new Object[]{
			" d ",
			"ddd",
			" d ", 'd', "gemDiamond"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.machineblock), new Object[]{
			"rvr",
			"vnv",
			"rvr", 'n', "blockNyt", 'v', "rodVice", 'r', "rodRedstone"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.basicbattery, 1, bonytechmod.basicbattery.getMaxDamage()), new Object[]{
			"svs",
			"ivi",
			"srs", 's', "rodCobblestone", 'i', "rodIron", 'v', "gemVice", 'r', "dustRedstone"}));
			
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.clearglass), new Object[]{
			"ggg",
			"g g",
			"ggg", 'g', "glass"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.furnacenytidle), new Object[]{
			"nnn",
			"nmn",
			"nfn", 'n', "gemNyt", 'm', "blockMachine", 'f', bonytechmod.furnaceironidle}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.furnaceironidle), new Object[]{
			"iii",
			"ibi",
			"ifi", 'i', "ingotIron", 'b', "blockIron", 'f', Blocks.furnace}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.emeraldbitcoin), new Object[]{
			" e ",
			"eee",
			" e ", 'e', "gemEmerald"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.choclateCake), new Object[]{
		"bbb", 
		"bcb",
		"bbb", 'c', "foodCake", 'b', "dyeBrown"})); //Why any dye? Because people eat weird shit
	}
}
