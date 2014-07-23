package net.bitm.items;

import net.bitm.creativeTab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class nytitem extends Item{
	public nytitem(){
		super();
		
		this.maxStackSize = 64;
		this.setCreativeTab(creativeTab.bonetabTools);
		this.setUnlocalizedName("nytitem");
	}

	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + "nytitem");
	}
	
}