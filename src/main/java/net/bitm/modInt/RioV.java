package net.bitm.modInt;

import sheenrox82.RioV.src.api.item.RioVWeapon;
import sheenrox82.RioV.src.content.RioVItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.bitm.bonytechmod;
import net.bitm.items.bonyiumingot;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class RioV {

	public static Item bonyiumIngot;
	public static Item infusedNytSword;
	
	public static ToolMaterial infusedNyt = EnumHelper.addToolMaterial("InfusedNyt", 3, 300, 7.5F, 2.3F, 27);
	
	public static void addRioVItems(){
		bonyiumIngot = new bonyiumingot();
		infusedNytSword = new RioVWeapon(infusedNyt, true).setUnlocalizedName("infusedNytSword");
		
		GameRegistry.registerItem(bonyiumIngot, "bonyiumingot");
		GameRegistry.registerItem(infusedNytSword, "infusedNytSword");
	}
	
	public static void addRioVRecipes(){
		GameRegistry.addShapelessRecipe(new ItemStack(bonyiumIngot, 2), new Object[]{
			new ItemStack(Items.iron_ingot), new ItemStack(RioVItems.blackBone), new ItemStack(Items.coal)});
	}
}
