package net.bitm.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bitm.creativeTab;
import net.bitm.config.settings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRod extends Item{
	public ItemRod(){
		super();
		
		this.maxStackSize = 64;
		this.setCreativeTab(creativeTab.bonetabMaterials);

	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + this.getUnlocalizedName());
	}
}


