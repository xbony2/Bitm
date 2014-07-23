package net.bitm;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class creativeTab {

	//public static CreativeTabs bonetab;
		public static CreativeTabs bonetabTools;
		public static CreativeTabs bonetabMaterials;
		public static CreativeTabs bonetabMachines;
		public static CreativeTabs bonetabDeco;
	
	public static void registerCreativeTabs(){

			bonetabTools = new CreativeTabs("Bonyindustiraltechtools"){
				@Override
				@SideOnly(Side.CLIENT)
				public Item getTabIconItem() {
					return bonytechmod.picknyt; 
				}
			};
			bonetabMaterials = new CreativeTabs("Bonyindustiraltechmaterials"){
				@Override
				@SideOnly(Side.CLIENT)
				public Item getTabIconItem() {
					return bonytechmod.diamondbitcoin; 
				}
			};
			bonetabMachines = new CreativeTabs("Bonyindustiraltechmachines"){
				@Override
				@SideOnly(Side.CLIENT)
				public Item getTabIconItem() {
					return bonytechmod.basicbattery; 
				}
			};
			bonetabDeco = new CreativeTabs("Bonyindustiraltechdeco"){
				@Override
				@SideOnly(Side.CLIENT)
				public Item getTabIconItem() {
					return Item.getItemFromBlock(bonytechmod.clearglass); 
				}
			};
			
			/*bonetab = new CreativeTabs("Bonyindustiraltech"){
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return bonytechmod.basicbattery; 
			}
		};*/
	}
}
