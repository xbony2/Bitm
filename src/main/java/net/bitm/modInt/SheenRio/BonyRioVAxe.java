package net.bitm.modInt.SheenRio;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bitm.creativeTab;
import net.minecraft.client.renderer.texture.IIconRegister;
import sheenrox82.RioV.src.api.item.RioVAxe;

public class BonyRioVAxe extends RioVAxe{
	public boolean isInfused;
	
	public BonyRioVAxe(ToolMaterial par2EnumToolMaterial, boolean par2) {
		super(par2EnumToolMaterial, par2);
		this.isInfused = par2;
		this.setCreativeTab(creativeTab.bonetabTools);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister){
		this.itemIcon = par1IconRegister.registerIcon("bitm" + ":" + this.getUnlocalizedName());
	}
}
