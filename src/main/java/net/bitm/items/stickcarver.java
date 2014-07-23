package net.bitm.items;

import net.bitm.creativeTab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class stickcarver extends Item{
	public stickcarver(){
		super();
		
		this.maxStackSize = 1;
		this.setCreativeTab(creativeTab.bonetabMachines);
		this.setUnlocalizedName("stickcarver");
		this.setNoRepair();
		this.setMaxDamage(30);
		
	}
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack){
        return false;
    }
	
	@Override
	public boolean getShareTag(){
        return true;
    }
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		itemStack.setItemDamage(itemStack.getItemDamage() + 1);
		return itemStack;
	}
	
	@Override
	public boolean hasContainerItem(){
		return true;
	}
	
    @Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + "stickcarver");
	}
}