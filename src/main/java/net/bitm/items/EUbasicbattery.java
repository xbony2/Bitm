package net.bitm.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bitm.creativeTab;
import net.bitm.modInt.IC2;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ic2.api.item.IElectricItem;

public class EUbasicbattery extends Item implements IElectricItem{
	int power = 500000;
	public EUbasicbattery(){
		super();
		
		this.setCreativeTab(creativeTab.bonetabMachines);
		this.setMaxDamage(power);
		this.setMaxStackSize(1);
	}
	
	public boolean canProvideEnergy(ItemStack itemStack) {
		return true;
	}

	public Item getChargedItem(ItemStack itemStack) {
		return IC2.eubasicbettery;
	}

	public Item getEmptyItem(ItemStack itemStack) {
		return IC2.emptyeubasicbattery;
	}

	public int getMaxCharge(ItemStack itemStack) {
		return power;
	}

	public int getTier(ItemStack itemStack) {
		return 2;
	}

	public int getTransferLimit(ItemStack itemStack) {
		return 1152;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + this.getUnlocalizedName());
	}

}
