package net.bitm.items;

import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.bitm.config.settings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
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
	
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack){
        return false;
    }
	
	public boolean getShareTag(){
        return true;
    }
	
	public ItemStack getContainerItem(ItemStack itemStack) {
		itemStack.setItemDamage(itemStack.getItemDamage() + 1);
		return itemStack;
	}
	
	public boolean hasContainerItem(){
		return true;
	}
	
    @SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + "stickcarver");
	}
}