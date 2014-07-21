package sheenrox82.RioV.src.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.terraingen.TerrainGen;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;
import sheenrox82.RioV.src.content.RioVBlocks;
import sheenrox82.RioV.src.util.Util;
import sheenrox82.RioV.src.world.feature.WorldGenBloodTree;
import sheenrox82.RioV.src.world.feature.WorldGenCherryBlossomTree;
import sheenrox82.RioV.src.world.feature.WorldGenGlimmerWoodTree;
import sheenrox82.RioV.src.world.feature.WorldGenSanctuatiteTree;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRioVSapling extends BlockSapling implements IPlantable
{    
	public IIcon blockIcon;
	
	public BlockRioVSapling()
	{
		super();
		this.setCreativeTab(RioVAPI.getInstance().tab);
		this.setStepSound(Block.soundTypeGrass);
        this.setHardness(0.2F);
        this.setLightOpacity(1);
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}

	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
	{
		if (!p_149674_1_.isRemote)
		{
			super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);

			if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9 && p_149674_5_.nextInt(7) == 0)
			{
				this.func_149879_c(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
			}
		}
	}

	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return blockIcon;
    }

    public void func_149879_c(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	if(this == RioVBlocks.glimmerwoodSapling)
		{
			int l = par1World.getBlockMetadata(par2, par2, par3);
			/** change this block to your custom grass block **/
			if ((l & 8) == 0)
			{
				par1World.setBlockMetadataWithNotify(par2, par2, par3, l | 8, 4);
			}
			else
			{
				this.func_149878_d(par1World, par2, par3, par4, par5Random);
			}
		}

		if(this == RioVBlocks.cherryBlossomSapling)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			/** change this block to your custom grass block **/
			if ((l & 8) == 0)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
			}
			else
			{
				this.func_149878_d(par1World, par2, par3, par4, par5Random);
			}
		}

		if(this == RioVBlocks.bloodSapling)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			/** change this block to your custom grass block **/
			if ((l & 8) == 0)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
			}
			else
			{
				this.func_149878_d(par1World, par2, par3, par4, par5Random);
			}
		}

		if(this == RioVBlocks.skywoodSapling)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			/** change this block to your custom grass block **/
			if ((l & 8) == 0)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
			}
			else
			{
				this.func_149878_d(par1World, par2, par3, par4, par5Random);
			}
		}
    }

	public void func_149878_d(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if(this == RioVBlocks.glimmerwoodSapling)
		{
			if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)) return;
			int l = par1World.getBlockMetadata(par2, par3, par4) & 3;
			Object object = null;
			int i1 = 0;
			int j1 = 0;
			boolean flag = false;
			if (l == 3)
			{
				for (i1 = 0; i1 >= -1; --i1)
				{
					for (j1 = 0; j1 >= -1; --j1)
					{
						if (this.func_149880_a(par1World, par2 + i1, par3, par4 + j1, 3) && this.func_149880_a(par1World, par2 + i1 + 1, par3, par4 + j1, 3) && this.func_149880_a(par1World, par2 + i1, par3, par4 + j1 + 1, 3) && this.func_149880_a(par1World, par2 + i1 + 1, par3, par4 + j1 + 1, 3))
						{
							/** Change this to your WorldGenNAMETree **/
							object = new WorldGenGlimmerWoodTree(false);
							flag = true;
							break;
						}
					}
					if (object != null)
					{
						break;
					}
				}
				if (object == null)
				{
					j1 = 0;
					i1 = 0;

					object = new WorldGenGlimmerWoodTree(false);
				}
			}
			else
			{
				object = new WorldGenGlimmerWoodTree(false); // Changed //

			}

			Block block = Blocks.air;

			if (flag)
			{
				par1World.setBlock(par2 + i1, par3, par4 + j1, block, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, block, 0, 4);
				par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, block, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, block, 0, 4);
			}
			else
			{
				par1World.setBlock(par2, par3, par4, block, 0, 4);
			}
			if (!((WorldGenerator)object).generate(par1World, par5Random, par2 + i1, par3, par4 + j1))
			{
				if (flag)
				{
					par1World.setBlock(par2 + i1, par3, par4 + j1, this, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this, l, 4);
					par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this, l, 4);
				}
				else
				{
					par1World.setBlock(par2, par3, par4, this, l, 4);
				}
			}
		}

		if(this == RioVBlocks.cherryBlossomSapling)
		{
			if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)) return;
			int l = par1World.getBlockMetadata(par2, par3, par4) & 3;
			Object object = null;
			int i1 = 0;
			int j1 = 0;
			boolean flag = false;
			if (l == 3)
			{
				for (i1 = 0; i1 >= -1; --i1)
				{
					for (j1 = 0; j1 >= -1; --j1)
					{
						if (this.func_149880_a(par1World, par2 + i1, par3, par4 + j1, 3) && this.func_149880_a(par1World, par2 + i1 + 1, par3, par4 + j1, 3) && this.func_149880_a(par1World, par2 + i1, par3, par4 + j1 + 1, 3) && this.func_149880_a(par1World, par2 + i1 + 1, par3, par4 + j1 + 1, 3))
						{
							/** Change this to your WorldGenNAMETree **/
							object = new WorldGenCherryBlossomTree(false);
							flag = true;
							break;
						}
					}
					if (object != null)
					{
						break;
					}
				}
				if (object == null)
				{
					j1 = 0;
					i1 = 0;

					object = new WorldGenCherryBlossomTree(false);
				}
			}
			else
			{
				object = new WorldGenCherryBlossomTree(false); // Changed //

			}

			Block block = Blocks.air;

			if (flag)
			{
				par1World.setBlock(par2 + i1, par3, par4 + j1, block, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, block, 0, 4);
				par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, block, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, block, 0, 4);
			}
			else
			{
				par1World.setBlock(par2, par3, par4, block, 0, 4);
			}
			if (!((WorldGenerator)object).generate(par1World, par5Random, par2 + i1, par3, par4 + j1))
			{
				if (flag)
				{
					par1World.setBlock(par2 + i1, par3, par4 + j1, this, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this, l, 4);
					par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this, l, 4);
				}
				else
				{
					par1World.setBlock(par2, par3, par4, this, l, 4);
				}
			}
		}

		if(this == RioVBlocks.bloodSapling)
		{
			if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)) return;
			int l = par1World.getBlockMetadata(par2, par3, par4) & 3;
			Object object = null;
			int i1 = 0;
			int j1 = 0;
			boolean flag = false;
			if (l == 3)
			{
				for (i1 = 0; i1 >= -1; --i1)
				{
					for (j1 = 0; j1 >= -1; --j1)
					{
						if (this.func_149880_a(par1World, par2 + i1, par3, par4 + j1, 3) && this.func_149880_a(par1World, par2 + i1 + 1, par3, par4 + j1, 3) && this.func_149880_a(par1World, par2 + i1, par3, par4 + j1 + 1, 3) && this.func_149880_a(par1World, par2 + i1 + 1, par3, par4 + j1 + 1, 3))
						{
							/** Change this to your WorldGenNAMETree **/
							object = new WorldGenBloodTree(false);
							flag = true;
							break;
						}
					}
					if (object != null)
					{
						break;
					}
				}
				if (object == null)
				{
					j1 = 0;
					i1 = 0;

					object = new WorldGenBloodTree(false);
				}
			}
			else
			{
				object = new WorldGenBloodTree(false); // Changed //

			}

			Block block = Blocks.air;

			if (flag)
			{
				par1World.setBlock(par2 + i1, par3, par4 + j1, block, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, block, 0, 4);
				par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, block, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, block, 0, 4);
			}
			else
			{
				par1World.setBlock(par2, par3, par4, block, 0, 4);
			}
			if (!((WorldGenerator)object).generate(par1World, par5Random, par2 + i1, par3, par4 + j1))
			{
				if (flag)
				{
					par1World.setBlock(par2 + i1, par3, par4 + j1, this, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this, l, 4);
					par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this, l, 4);
				}
				else
				{
					par1World.setBlock(par2, par3, par4, this, l, 4);
				}
			}
		}

		if(this == RioVBlocks.skywoodSapling)
		{
			if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)) return;
			int l = par1World.getBlockMetadata(par2, par3, par4) & 3;
			Object object = null;
			int i1 = 0;
			int j1 = 0;
			boolean flag = false;
			if (l == 3)
			{
				for (i1 = 0; i1 >= -1; --i1)
				{
					for (j1 = 0; j1 >= -1; --j1)
					{
						if (this.func_149880_a(par1World, par2 + i1, par3, par4 + j1, 3) && this.func_149880_a(par1World, par2 + i1 + 1, par3, par4 + j1, 3) && this.func_149880_a(par1World, par2 + i1, par3, par4 + j1 + 1, 3) && this.func_149880_a(par1World, par2 + i1 + 1, par3, par4 + j1 + 1, 3))
						{
							/** Change this to your WorldGenNAMETree **/
							object = new WorldGenSanctuatiteTree(false);
							flag = true;
							break;
						}
					}
					if (object != null)
					{
						break;
					}
				}
				if (object == null)
				{
					j1 = 0;
					i1 = 0;

					object = new WorldGenSanctuatiteTree(false);
				}
			}
			else
			{
				object = new WorldGenSanctuatiteTree(false); // Changed //

			}

			Block block = Blocks.air;

			if (flag)
			{
				par1World.setBlock(par2 + i1, par3, par4 + j1, block, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, block, 0, 4);
				par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, block, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, block, 0, 4);
			}
			else
			{
				par1World.setBlock(par2, par3, par4, block, 0, 4);
			}
			if (!((WorldGenerator)object).generate(par1World, par5Random, par2 + i1, par3, par4 + j1))
			{
				if (flag)
				{
					par1World.setBlock(par2 + i1, par3, par4 + j1, this, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this, l, 4);
					par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this, l, 4);
				}
				else
				{
					par1World.setBlock(par2, par3, par4, this, l, 4);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
	{
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		blockIcon = p_149651_1_.registerIcon(Util.MOD_ID + ":" + RioVAPIUtil.getName(this.getUnlocalizedName()));
	}

	protected boolean canPlaceBlockOn(Block block)
	{
		if(this == RioVBlocks.glimmerwoodSapling)
		{
			return block == RioVBlocks.glimmerGrass;
		}
		if(this == RioVBlocks.skywoodSapling)
		{
			return block == RioVBlocks.sanctuatiteGrass;
		}
		if(this == RioVBlocks.bloodSapling)
		{
			return block == RioVBlocks.bloodGrass;
		}
		
		return block == Blocks.grass;
	}
}