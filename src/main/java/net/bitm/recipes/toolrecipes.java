package net.bitm.recipes;

import net.bitm.bonytechmod;
import net.bitm.config.settings;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class toolrecipes {
	
	public static void registerToolRecipes(){
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.axenyt), new Object[]{
			"nn ",
			"ns ",
			" s ", 'n', "gemNyt", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.axenyt), new Object[]{
			" nn",
			" sn",
			" s ", 'n', "gemNyt", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.picknyt), new Object[]{
			"nnn",
			" s ",
			" s ", 'n', "gemNyt", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.swordnyt), new Object[]{
			"n",
			"n",
			"s", 'n', "gemNyt", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.spadenyt), new Object[]{
			"n",
			"s",
			"s", 'n', "gemNyt", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.hoenyt), new Object[]{
			"nn ",
			" s ",
			" s ", 'n', "gemNyt", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.hoenyt), new Object[]{
			" nn",
			" s ",
			" s ", 'n', "gemNyt", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.axevice), new Object[]{
			"vv ",
			"vs ",
			" s ", 'v', "gemVice", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.axevice), new Object[]{
			" vv",
			" sv",
			" s ", 'v', "gemVice", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.pickvice), new Object[]{ 
			"vvv",
			" s ",
			" s ", 'v', "gemVice", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.swordvice), new Object[]{
			"v",
			"v",
			"s", 'v', "gemVice", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.spadevice), new Object[]{
			"v",
			"s",
			"s", 'v', "gemVice", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.hoevice), new Object[]{
			"vv ",
			" s ",
			" s ", 'v', "gemVice", 's', "stickWood"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.hoevice), new Object[]{
			" vv",
			" s ",
			" s ", 'v', "gemVice", 's', "stickWood"}));
		
if(settings.bemeraldonoff == 1){
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.axebemerald), new Object[]{
				"ee ",
				"es ", 
				" s ", 'e', "gemEmerald", 's', "stickWood"}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.axebemerald), new Object[]{
				" ee",
				" se",
				" s ", 'e', "gemEmerald", 's', "stickWood"}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.pickbemerald), new Object[]{
				"eee",
				" s ",
				" s ", 'e', "gemEmerald", 's', "stickWood"}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.swordbemerald), new Object[]{
				"e",
				"e",
				"s", 'e', "gemEmerald", 's', "stickWood"}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.spadebemerald), new Object[]{
				"e",
				"s",
				"s", 'e', "gemEmerald", 's', "stickWood"}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.hoebemerald), new Object[]{
				"ee ",
				" s ",
				" s ", 'e', "gemEmerald", 's', "stickWood"}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.hoebemerald), new Object[]{
				" ee",
				" s ",
				" s ", 'e', "gemEmerald", 's', "stickWood"}));
		}
		
		if(settings.bquartzonoff == 1){
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.axebquartz), new Object[]{
				"qq ",
				"qs ", 
				" s ", 'q', "gemQuartz", 's', "stickWood"}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.axebquartz), new Object[]{
				" qq",
				" sq",
				" s ", 'q', "gemQuartz", 's', "stickWood"}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.pickbquartz), new Object[]{
				"qqq",
				" s ",
				" s ", 'q', "gemQuartz", 's', "stickWood"}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.swordbquartz), new Object[]{
				"q",
				"q",
				"s", 'q', "gemQuartz", 's', "stickWood"}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.spadebquartz), new Object[]{
				"q",
				"s",
				"s", 'q', "gemQuartz", 's', "stickWood"}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.hoebquartz), new Object[]{
				"qq ",
				" s ",
				" s ", 'q', "gemQuartz", 's', "stickWood"}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bonytechmod.hoebquartz), new Object[]{
				" qq",
				" s ",
				" s ", 'q', "gemQuartz", 's', "stickWood"})); 
		}
		
	}
}
