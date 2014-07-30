package net.bitm.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;

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
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor){
		this.updateBlock(world, x, y, z);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z){
		this.updateBlock(world, x, y, z);
	}
	
	public void updateBlock(World world, int x, int y, int z){
		isMultiblockStructured(world, x, y, z);
	}
	
	public boolean isMultiblockStructured(World world, int x1, int y1, int z1){
		boolean mStructure = false;
		boolean currentCheckStructure = true;
		
		for(int x3 = 0; x3 < 3; x3++){
			for(int z3 = 0; z3 < 3; z3++){
				if(currentCheckStructure && !world.getBlock(x1 - x3, y1, z1 - z3).equals(bonytechmod.nytWindmillGround)){
					currentCheckStructure = false;
				}
			}
		}
		
		return false;
	}
}
