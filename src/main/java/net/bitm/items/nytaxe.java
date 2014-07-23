package net.bitm.items;

import net.bitm.creativeTab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemAxe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class nytaxe extends ItemAxe{
	
	public nytaxe(ToolMaterial par2ToolMaterial) {
		super(par2ToolMaterial);
		
		this.maxStackSize = 1;
		this.setCreativeTab(creativeTab.bonetabTools);
		this.setUnlocalizedName("nytaxe");
	}

	

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + "nytaxe");
	}
	
}
