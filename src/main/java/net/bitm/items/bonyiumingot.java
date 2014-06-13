package net.bitm.items;

import net.bitm.bonytechmod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class bonyiumingot extends Item{
	public bonyiumingot(){
		super();
		
		this.maxStackSize = 64;
		this.setUnlocalizedName("ingotbonyium,");
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + "bonyiumingot");
	}
}

