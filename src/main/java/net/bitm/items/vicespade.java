package net.bitm.items;

import net.bitm.creativeTab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSpade;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class vicespade extends ItemSpade{

	public vicespade(ToolMaterial par2ToolMaterial) {
		super(par2ToolMaterial);
		this.maxStackSize = 1;
		this.setCreativeTab(creativeTab.bonetabTools);
		this.setUnlocalizedName("vicespade");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + "vicespade");
	}

}

