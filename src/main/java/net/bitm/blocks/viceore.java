package net.bitm.blocks;

import java.util.Random;

import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.bitm.config.defaultsettings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class viceore extends Block{
	public viceore (Material material){
		super(material.rock);
		
		this.setHardness(5);
		this.setStepSound(soundTypeStone);
		this.setResistance(5);
		this.setBlockName("viceore");
		if(defaultsettings.alternetcreativemenuonoff == 0){
			this.setCreativeTab(CreativeTabs.tabBlock);
		}else{
		this.setCreativeTab(creativeTab.bonetabTools);
		}
		
	}

	public Item getItemDropped(int par1, Random random, int par2){
		return Item.getItemFromBlock(bonytechmod.viceore);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		blockIcon = register.registerIcon("bitm" + ":" + "viceore");
	}

}