package net.bitm.blocks;

import java.util.Random;

import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.bitm.config.settings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class viceblock extends Block{
	public viceblock (Material material){
		super(material.rock);
		
		this.setHardness(2F);
		this.setStepSound(soundTypeStone);
		this.setResistance(5);
		this.setBlockName("viceblock");
		this.setCreativeTab(creativeTab.bonetabTools);
		
	}
	
	public Item getItemDropped(int par1, Random random, int par2){
		return Item.getItemFromBlock(bonytechmod.viceblock);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		this.blockIcon = register.registerIcon("bitm" + ":" + "vice_block");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return this.blockIcon;
	}
	
}

