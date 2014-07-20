package net.bitm.items;

import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.bitm.config.defaultsettings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class nytpick extends ItemPickaxe{

	public nytpick(ToolMaterial par2ToolMaterial) {
		super(par2ToolMaterial);
		
		this.maxStackSize = 1;
		this.setCreativeTab(creativeTab.bonetabTools);
		this.setUnlocalizedName("nytpick");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("bitm" + ":" + "nytpick");
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack){
	    return true;
	    }
	
}
