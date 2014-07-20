package net.bitm.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.bitm.config.defaultsettings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class clearglass extends Block{

	public clearglass (Material material){
		super(material.glass);
		
		this.setHardness(0.3F);
		this.setStepSound(soundTypeGlass);
		this.setBlockName("clearglass");
		this.setCreativeTab(creativeTab.bonetabDeco);
		}
		
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	public Item getItemDropped(int par1, Random random, int par2){
		return Item.getItemFromBlock(Blocks.air);
	}
	
	protected boolean canSilkHarvest(){
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass(){
		return 1;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		blockIcon = register.registerIcon("bitm" + ":" + "chrome5");
	}

}
