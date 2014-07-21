package sheenrox82.RioV.src.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;
import sheenrox82.RioV.src.content.RioVBlocks;
import sheenrox82.RioV.src.content.RioVItems;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPlantCore extends BlockFlower
{
	public BlockPlantCore()
	{
		super(0);
		this.setStepSound(Block.soundTypeGrass);
		this.setCreativeTab(RioVAPI.getInstance().tab);
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		if(this == RioVBlocks.blackDuriiPlant)
		{
			return RioVItems.blackDurii;
		}
		if(this == RioVBlocks.tomatoPlant)
		{
			return RioVItems.tomato;
		}
		if(this == RioVBlocks.grapePlant)
		{
			return RioVItems.grapes;
		}
		if(this == RioVBlocks.pepperPlant)
		{
			return RioVItems.pepper;
		}
		if(this == RioVBlocks.bloodFlower)
		{
			return RioVItems.heart;
		}
		if(this == RioVBlocks.elderBerryPlant)
		{
			return RioVItems.elderBerry;
		}
		if(this == RioVBlocks.cloudBerryPlant)
		{
			return RioVItems.cloudBerry;
		}
		if(this == RioVBlocks.enderBerryPlant)
		{
			return RioVItems.enderBerry;
		}

		return Item.getItemFromBlock(null);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
	{
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
	}

	@SideOnly(Side.CLIENT)
	public IIcon blockIcon;

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + RioVAPIUtil.getName(this.getUnlocalizedName()));
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
		return blockIcon;
	}

	protected boolean canPlaceBlockOn(Block par1)
	{		
		if(this == RioVBlocks.bloodFlower ||this == RioVBlocks.bloodTallGrass)
		{
			return par1 == RioVBlocks.bloodGrass;
		}

		if(this == RioVBlocks.glimmerTallGrass || this == RioVBlocks.elderBerryPlant)
		{
			return par1 == RioVBlocks.glimmerGrass;
		}

		if(this == RioVBlocks.sanctuatiteTallGrass || this == RioVBlocks.cloudBerryPlant)
		{
			return par1 == RioVBlocks.sanctuatiteGrass;
		}
		
		if(this == RioVBlocks.enderBerryPlant)
		{
			return par1 == Blocks.end_stone;
		}

		return par1 == Blocks.grass || par1 == Blocks.dirt || par1 == Blocks.farmland;
	}
}
