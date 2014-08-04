package net.bitm.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bitm.creativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class SheenyBlock extends Block{

	public SheenyBlock(Material material) {
		super(material);

		this.setHardness(0.8F);
		this.setStepSound(soundTypeCloth);
		this.setBlockName("sheenyBlock");
		this.setCreativeTab(creativeTab.bonetabDeco);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		blockIcon = register.registerIcon("bitm" + ":" + "sheenyblock");
	}
}
