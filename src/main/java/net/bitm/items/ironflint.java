package net.bitm.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bitm.creativeTab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ironflint extends Item{
	public ironflint() {
		super();
		
		this.maxStackSize = 64;
		this.setCreativeTab(creativeTab.bonetabMaterials);
		this.setUnlocalizedName("flintiron");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + "ironflint");
	}
}
