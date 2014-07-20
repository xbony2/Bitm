package net.bitm.items;

import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.bitm.config.defaultsettings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class bemeraldpick extends ItemPickaxe {

	public bemeraldpick(ToolMaterial par2ToolMaterial){
		super(par2ToolMaterial);
		this.maxStackSize = 1;
		this.setCreativeTab(creativeTab.bonetabTools);
		this.setUnlocalizedName("bemeraldpick");
	
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + "bemeraldpick");
	}
}
