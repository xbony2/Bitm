package net.bitm.blocks;

import java.util.Random;

import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class machineblock extends Block{

	public machineblock(Material material) {
		super(Material.rock);
		
		this.setHardness(2F);
		this.setStepSound(soundTypeMetal);
		this.setResistance(5);
		this.setBlockName("machineblock");
		this.setCreativeTab(creativeTab.bonetabMachines);
	}
	
	@Override
	public Item getItemDropped(int par1, Random random, int par2){
		return Item.getItemFromBlock(bonytechmod.machineblock);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		blockIcon = register.registerIcon("bitm" + ":" + "machineblock");
	}

}
