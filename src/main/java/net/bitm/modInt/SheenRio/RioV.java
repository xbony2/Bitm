package net.bitm.modInt.SheenRio;

import net.bitm.bonytechmod;
import net.bitm.blocks.SheenyBlock;
import net.bitm.items.bonyiumingot;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.content.RioVItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class RioV {

	public static Item bonyiumIngot;
	public static Item infusedNytAxe;
	public static Item infusedNytPickaxe;
	public static Item infusedNytSpade;
	public static Item infusedNytSword;
	public static Item infusedViceAxe;
	public static Item infusedVicePickaxe;
	public static Item infusedViceSpade;
	public static Item infusedViceSword;
	
	public static Block sheenyBlock;
	
	public static ToolMaterial infusedNyt = EnumHelper.addToolMaterial("InfusedNyt", 3, 350, 8F, 3F, 30);
	public static ToolMaterial infusedVice = EnumHelper.addToolMaterial("InfusedVice", 2, 250, 9F, 2F, 7);
	
	public static void addRioVItems(){
		bonyiumIngot = new bonyiumingot();
		infusedNytAxe = new BonyRioVAxe(infusedNyt, true).setUnlocalizedName("infusedNytAxe");
		infusedNytPickaxe = new BonyRioVPickaxe(infusedNyt, true).setUnlocalizedName("infusedNytPickaxe");
		infusedNytSpade = new BonyRioVSpade(infusedNyt, true).setUnlocalizedName("infusedNytSpade");
		infusedNytSword = new BonyRioVWeapon(infusedNyt, true).setUnlocalizedName("infusedNytSword");
		infusedViceAxe = new BonyRioVAxe(infusedVice, true).setUnlocalizedName("infusedViceAxe");
		infusedVicePickaxe = new BonyRioVPickaxe(infusedVice, true).setUnlocalizedName("infusedVicePickaxe");
		infusedViceSpade = new BonyRioVSpade(infusedVice, true).setUnlocalizedName("infusedViceSpade");
		infusedViceSword = new BonyRioVWeapon(infusedVice, true).setUnlocalizedName("infusedViceSword");
		
		sheenyBlock = new SheenyBlock(Material.cloth);
		
		GameRegistry.registerItem(bonyiumIngot, "bonyiumingot");
		GameRegistry.registerItem(infusedNytAxe, "infusedNytAxe");
		GameRegistry.registerItem(infusedNytPickaxe, "infusedNytPickaxe");
		GameRegistry.registerItem(infusedNytSpade, "infusedNytSpade");
		GameRegistry.registerItem(infusedNytSword, "infusedNytSword");
		GameRegistry.registerItem(infusedViceAxe, "infusedViceAxe");
		GameRegistry.registerItem(infusedVicePickaxe, "infusedVicePickaxe");
		GameRegistry.registerItem(infusedViceSpade, "infusedViceSpade");
		GameRegistry.registerItem(infusedViceSword, "infusedViceSword");
		
		GameRegistry.registerBlock(sheenyBlock, "sheenyBlock");
	}
	
	public static void addRioVRecipes(){
		RioVAPI.getInstance().getInfuser().addInfusion(bonytechmod.axenyt, new ItemStack(infusedNytAxe, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(bonytechmod.picknyt, new ItemStack(infusedNytPickaxe, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(bonytechmod.swordnyt, new ItemStack(infusedNytSword, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(bonytechmod.spadenyt, new ItemStack(infusedNytSpade, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(bonytechmod.axevice, new ItemStack(infusedViceAxe, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(bonytechmod.pickvice, new ItemStack(infusedVicePickaxe, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(bonytechmod.swordvice, new ItemStack(infusedViceSword, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(bonytechmod.spadevice, new ItemStack(infusedViceSpade, 1));
		
		GameRegistry.addShapelessRecipe(new ItemStack(bonyiumIngot, 2), new Object[]{
			new ItemStack(Items.iron_ingot), new ItemStack(RioVItems.blackBone), new ItemStack(Items.coal)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(sheenyBlock), new Object[]{
			new ItemStack(Blocks.wool, 1, 12), new ItemStack(RioVItems.heart)});
	}
}
