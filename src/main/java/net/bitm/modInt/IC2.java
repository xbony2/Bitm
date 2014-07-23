package net.bitm.modInt;

import ic2.api.item.IC2Items;
import cpw.mods.fml.common.registry.GameRegistry;
import net.bitm.creativeTab;
import net.bitm.items.EUbasicbattery;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class IC2 {

	public static Item eubasicbettery;
	public static Item emptyeubasicbattery;
	
	public static void addIC2Items(){
		eubasicbettery = new EUbasicbattery().setUnlocalizedName("euBasicBattery");
		emptyeubasicbattery = new EUbasicbattery().setUnlocalizedName("emptyEUbasicBattery").setCreativeTab(creativeTab.bonetabMachines);
		
		GameRegistry.registerItem(eubasicbettery, "euBasicBattery");
		GameRegistry.registerItem(emptyeubasicbattery, "emptyEUbasicBattery");
	}
	
	public static void addRecipes(){
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(emptyeubasicbattery), new Object[]{
			" c ",
			"tvt",
			"tet",  'c', IC2Items.getItem("insulatedCopperCableItem"),'v', "gemVice",  't', IC2Items.getItem("casingtin"), 'e', "circuitBasic"}));
		
	}
	
}
