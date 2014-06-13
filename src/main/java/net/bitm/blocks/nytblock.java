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
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class nytblock extends Block{
	public nytblock (Material material){
		super(material.rock);
		
		this.setHardness(2F);
		this.setStepSound(soundTypeStone);
		this.setResistance(5);
		this.setBlockName("nytblock");
		if(defaultsettings.alternetcreativemenuonoff == 0){
			this.setCreativeTab(CreativeTabs.tabBlock);
		}else{
		this.setCreativeTab(creativeTab.bonetabTools);
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon toptexture;
	private IIcon bottomtexture;
	
	public Item getItemDropped(int par1, Random random, int par2){
		return Item.getItemFromBlock(bonytechmod.nytblock);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		blockIcon = register.registerIcon("bitm" + ":" + "nytblockside");
		this.toptexture = register.registerIcon("bitm" + ":" + "nytblocktop");
		this.bottomtexture = register.registerIcon("bitm" + ":" + "nytblockbottom");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		
		switch(side){
		case 0: return this.bottomtexture;
		case 1: return this.toptexture;
		default: return this.blockIcon;
		
		}
	}
	
	
}
