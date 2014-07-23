package net.bitm.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bitm.creativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class NytWindmillGround extends Block{

	public NytWindmillGround(Material material) {
		super(material);
		this.setCreativeTab(creativeTab.bonetabMachines);
		this.setBlockName("nytWindmillGround");
		this.setBlockBounds(0, 0, 0, 1, 0.3F, 1);
	}

	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		blockIcon = register.registerIcon("bitm" + ":" + "nyt_block");
	}
}
