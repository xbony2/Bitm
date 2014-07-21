package net.bitm.modInt.SheenRio;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bitm.creativeTab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item.ToolMaterial;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.item.RioVWeapon;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;

public class BonyRioVWeapon extends RioVWeapon{
	public float weaponDamage;
	public final ToolMaterial toolMaterial;
	public boolean isInfused;
	
	public BonyRioVWeapon(ToolMaterial par2EnumToolMaterial, boolean par2) {
		super(par2EnumToolMaterial, par2);
		this.toolMaterial = par2EnumToolMaterial;
		this.maxStackSize = 1;
		this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
		this.setCreativeTab(creativeTab.bonetabTools);
		this.weaponDamage = 4 + par2EnumToolMaterial.getDamageVsEntity();
		this.isInfused = par2;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister){
		this.itemIcon = par1IconRegister.registerIcon("bitm" + ":" + this.getUnlocalizedName());
	}
}
