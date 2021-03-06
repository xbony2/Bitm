package net.bitm.blocks;

import java.util.Random;

import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class nytblock extends Block{
	public nytblock (Material material){
		super(Material.rock);
		
		this.setHardness(2F);
		this.setStepSound(soundTypeStone);
		this.setResistance(5);
		this.setBlockName("nytblock");
		this.setCreativeTab(creativeTab.bonetabTools);
		
	}
	
	@Override
	public Item getItemDropped(int par1, Random random, int par2){
		return Item.getItemFromBlock(bonytechmod.nytblock);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		blockIcon = register.registerIcon("bitm" + ":" + "nyt_block");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return this.blockIcon;
	}
	
	
}
