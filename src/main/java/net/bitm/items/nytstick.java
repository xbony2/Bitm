package net.bitm.items;

import net.bitm.creativeTab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class nytstick extends Item{
	public nytstick(){
		super();
		
		this.maxStackSize = 64;
		this.setCreativeTab(creativeTab.bonetabMaterials);
		this.setUnlocalizedName("stickinyt");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + "nytstick");
	}
	
}
