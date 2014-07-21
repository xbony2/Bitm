package sheenrox82.RioV.src.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAnvil extends Block
{
	public static int id = 2;
	@SideOnly(Side.CLIENT)
	private IIcon field_94461_a;
	@SideOnly(Side.CLIENT)
	private IIcon field_94460_b;
	@SideOnly(Side.CLIENT)
	private IIcon anvilSide;
	
	public BlockAnvil()
	{
		super(Material.anvil);
		this.setStepSound(this.soundTypeAnvil);
		this.setCreativeTab(RioVAPI.getInstance().tab);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.80F, 1.0F);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return par1 == 0 ? this.field_94460_b : (par1 == 1 ? this.field_94461_a : this.anvilSide);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.anvilSide = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "anvil_side");
		this.field_94461_a = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "anvil_top");
		this.field_94460_b = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "anvil_bottom");
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if(!par5EntityPlayer.isSneaking())
		{
			par5EntityPlayer.openGui(TheMistsOfRioV.getInstance(), id, par1World, par2, par3, par4);
			return true;
		}
		else
		{
			return false;
		}
	}
}
