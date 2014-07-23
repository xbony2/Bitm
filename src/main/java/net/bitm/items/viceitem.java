package net.bitm.items;

import net.bitm.creativeTab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class viceitem extends Item{
	public viceitem(){
		super();
		
		this.maxStackSize = 64;
		this.setCreativeTab(creativeTab.bonetabTools);
		this.setUnlocalizedName("viceitem");
	
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + "viceitem");
	}
	
}