package net.bitm.blocks;

import net.bitm.creativeTab;
import net.bitm.tileentity.TileEntityNytWindmill;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class NytWindmill extends BlockContainer{

	public NytWindmill(Material material) {
		super(material);
		this.setBlockName("nytWindmill");
		
	}

	@Override
	public int getRenderType(){
		return -1;
		
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
	public TileEntity createNewTileEntity(World world, int par2){
		return new TileEntityNytWindmill();
	}
}
