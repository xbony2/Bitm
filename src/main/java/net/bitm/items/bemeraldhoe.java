package net.bitm.items;

import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.bitm.config.defaultsettings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class bemeraldhoe extends ItemHoe {

	public bemeraldhoe(ToolMaterial par2ToolMaterial) {
		super(par2ToolMaterial);
		this.maxStackSize = 1;
		if(defaultsettings.alternetcreativemenuonoff == 0){
			this.setCreativeTab(CreativeTabs.tabTools);
		}else{
		this.setCreativeTab(creativeTab.bonetabTools);
		}

		this.setUnlocalizedName("bemeraldhoe");
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + "bemeraldhoe");
	}
}
