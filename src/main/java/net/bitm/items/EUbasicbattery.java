package net.bitm.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bitm.modInt.IC2;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ic2.api.item.IElectricItem;

public class EUbasicbattery extends Item implements IElectricItem{
	int power = 500000;
	public EUbasicbattery(){
		super();
		
		this.setMaxDamage(power);
		this.setMaxStackSize(1);
	}
	
	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
		return true;
	}

	@Override
	public Item getChargedItem(ItemStack itemStack) {
		return IC2.eubasicbettery;
	}

	@Override
	public Item getEmptyItem(ItemStack itemStack) {
		return IC2.emptyeubasicbattery;
	}

	@Override
	public double getMaxCharge(ItemStack itemStack) {
		return power;
	}

	@Override
	public int getTier(ItemStack itemStack) {
		return 2;
	}

	@Override
	public double getTransferLimit(ItemStack itemStack) {
		return 1152;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + this.getUnlocalizedName());
	}

}
