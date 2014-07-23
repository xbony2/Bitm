package net.bitm.items;

import net.bitm.creativeTab;
import net.bitm.powermanagement.defaultenergy;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class itembasicbattery extends Item{
	public itembasicbattery(){
		super();
		
		this.maxStackSize = 1;
		this.setCreativeTab(creativeTab.bonetabMachines);
		this.setUnlocalizedName("basicbattery");
		this.setMaxDamage(defaultenergy.BASICBATTERYBOOS);
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + "basicbattery");
	}
}