package sheenrox82.RioV.src.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import sheenrox82.RioV.src.content.RioVBlocks;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRioVDoor extends BlockDoor
{
	private static final String[] glimmerwoodDoor = new String[] {Util.MOD_ID + ":" + "glimmerwoodDoor_lower", Util.MOD_ID + ":" + "glimmerwoodDoor_upper"};
	private static final String[] cherryBlossomDoor = new String[] {Util.MOD_ID + ":" + "cherryBlossomDoor_lower", Util.MOD_ID + ":" + "cherryBlossomDoor_upper"};
	private static final String[] skywoodDoor = new String[] {Util.MOD_ID + ":" + "skywoodDoor_lower", Util.MOD_ID + ":" + "skywoodDoor_upper"};
	private static final String[] bloodDoor = new String[] {Util.MOD_ID + ":" + "bloodDoor_lower", Util.MOD_ID + ":" + "bloodDoor_upper"};

	private final int glimmerwoodDoorIcon;
	private final int cherryBlossomDoorIcon;
	private final int skywoodDoorIcon;
	private final int bloodDoorIcon;

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public BlockRioVDoor()
	{
		super(Material.wood);
		this.setStepSound(Block.soundTypeWood);
		this.glimmerwoodDoorIcon = 0;
		this.cherryBlossomDoorIcon = 0;
		this.skywoodDoorIcon = 0;
		this.bloodDoorIcon = 0;
		float f = 0.5F;
		float f1 = 1.0F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
		if(this == RioVBlocks.glimmerwoodDoor)
		{
			return this.iconArray[this.glimmerwoodDoorIcon];
		}
		if(this == RioVBlocks.cherryBlossomDoor)
		{
			return this.iconArray[this.cherryBlossomDoorIcon];
		}
		if(this == RioVBlocks.skywoodDoor)
		{
			return this.iconArray[this.skywoodDoorIcon];
		}
		if(this == RioVBlocks.bloodDoor)
		{
			return this.iconArray[this.bloodDoorIcon];
		}
		return null;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		if (par5 != 1 && par5 != 0)
		{
			int i1 = this.func_150012_g(par1IBlockAccess, par2, par3, par4);
			int j1 = i1 & 3;
			boolean flag = (i1 & 4) != 0;
			boolean flag1 = false;
			boolean flag2 = (i1 & 8) != 0;

			if (flag)
			{
				if (j1 == 0 && par5 == 2)
				{
					flag1 = !flag1;
				}
				else if (j1 == 1 && par5 == 5)
				{
					flag1 = !flag1;
				}
				else if (j1 == 2 && par5 == 3)
				{
					flag1 = !flag1;
				}
				else if (j1 == 3 && par5 == 4)
				{
					flag1 = !flag1;
				}
			}
			else
			{
				if (j1 == 0 && par5 == 5)
				{
					flag1 = !flag1;
				}
				else if (j1 == 1 && par5 == 3)
				{
					flag1 = !flag1;
				}
				else if (j1 == 2 && par5 == 4)
				{
					flag1 = !flag1;
				}
				else if (j1 == 3 && par5 == 2)
				{
					flag1 = !flag1;
				}

				if ((i1 & 16) != 0)
				{
					flag1 = !flag1;
				}
			}

			if(this == RioVBlocks.glimmerwoodDoor)
			{
				return this.iconArray[this.glimmerwoodDoorIcon + (flag1 ? glimmerwoodDoor.length : 0) + (flag2 ? 1 : 0)];
			}

			if(this == RioVBlocks.cherryBlossomDoor)
			{
				return this.iconArray[this.cherryBlossomDoorIcon + (flag1 ? cherryBlossomDoor.length : 0) + (flag2 ? 1 : 0)];
			}

			if(this == RioVBlocks.skywoodDoor)
			{
				return this.iconArray[this.skywoodDoorIcon + (flag1 ? skywoodDoor.length : 0) + (flag2 ? 1 : 0)];
			}

			if(this == RioVBlocks.bloodDoor)
			{
				return this.iconArray[this.bloodDoorIcon + (flag1 ? bloodDoor.length : 0) + (flag2 ? 1 : 0)];
			}

			return null;
		}
		else
		{
			return this.iconArray[this.glimmerwoodDoorIcon];
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		if(this == RioVBlocks.cherryBlossomDoor)
		{
			this.iconArray = new IIcon[cherryBlossomDoor.length * 2];

			for (int i = 0; i < cherryBlossomDoor.length; ++i)
			{
				this.iconArray[i] = par1IconRegister.registerIcon(cherryBlossomDoor[i]);
				this.iconArray[i + cherryBlossomDoor.length] = new IconFlipped(this.iconArray[i], true, false);
			}
		}

		if(this == RioVBlocks.glimmerwoodDoor)
		{
			this.iconArray = new IIcon[glimmerwoodDoor.length * 2];

			for (int i = 0; i < glimmerwoodDoor.length; ++i)
			{
				this.iconArray[i] = par1IconRegister.registerIcon(glimmerwoodDoor[i]);
				this.iconArray[i + glimmerwoodDoor.length] = new IconFlipped(this.iconArray[i], true, false);
			}
		}

		if(this == RioVBlocks.skywoodDoor)
		{
			this.iconArray = new IIcon[skywoodDoor.length * 2];

			for (int i = 0; i < skywoodDoor.length; ++i)
			{
				this.iconArray[i] = par1IconRegister.registerIcon(skywoodDoor[i]);
				this.iconArray[i + skywoodDoor.length] = new IconFlipped(this.iconArray[i], true, false);
			}
		}

		if(this == RioVBlocks.bloodDoor)
		{
			this.iconArray = new IIcon[bloodDoor.length * 2];

			for (int i = 0; i < bloodDoor.length; ++i)
			{
				this.iconArray[i] = par1IconRegister.registerIcon(bloodDoor[i]);
				this.iconArray[i + bloodDoor.length] = new IconFlipped(this.iconArray[i], true, false);
			}
		}
	}
	
	@Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
}
