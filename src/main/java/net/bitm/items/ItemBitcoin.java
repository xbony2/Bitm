package net.bitm.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bitm.creativeTab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemBitcoin extends Item{
	public ItemBitcoin() {
		super();

		this.maxStackSize = 16;
		this.setCreativeTab(creativeTab.bonetabMaterials);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + this.getUnlocalizedName());
	}
}
