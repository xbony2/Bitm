package sheenrox82.RioV.src.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;
import sheenrox82.RioV.src.content.RioVBlocks;
import sheenrox82.RioV.src.util.MethodUtil;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRioVTallGrass extends BlockFlower
{
	public BlockRioVTallGrass(int i)
	{
		super(i);
		this.setStepSound(Block.soundTypeGrass);
		this.setCreativeTab(null);
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
		if(this == RioVBlocks.glimmerTallGrass)
		{
			return par1 == RioVBlocks.glimmerGrass;
		}

		if(this == RioVBlocks.sanctuatiteTallGrass)
		{
			return par1 == RioVBlocks.sanctuatiteGrass;
		}

		if(this == RioVBlocks.bloodTallGrass)
		{
			return par1 == RioVBlocks.bloodGrass;
		}
		
		return par1 == Blocks.grass || par1 == Blocks.dirt || par1 == Blocks.farmland;
	}
}
