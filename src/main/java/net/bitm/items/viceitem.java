package net.bitm.items;

import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.bitm.config.defaultsettings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class viceitem extends Item{
	public viceitem(){
		super();
		
		this.maxStackSize = 64;
		if(defaultsettings.alternetcreativemenuonoff == 0){
			this.setCreativeTab(CreativeTabs.tabMaterials);
		}else{
		this.setCreativeTab(creativeTab.bonetabTools);
		}
		this.setUnlocalizedName("viceitem");
	
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + "viceitem");
	}
	
}