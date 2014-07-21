package sheenrox82.RioV.src.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.tileentity.TileEntityFlag;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFlag extends BlockContainer 
{
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon;
	
	public BlockFlag() 
	{
		super(Material.wood);
//		/this.setCreativeTab(RioVAPI.getInstance().tab);
		this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.6F, 3.0F, 0.6F);
	}

	@Override
	public TileEntity createNewTileEntity(World par1World, int var1)
	{
		return new TileEntityFlag();
	}

	@Override
	public int getRenderType()
	{
		return 50;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return true;
	}

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return this.blockIcon;
	}
	
	public void registerBlockIcons(IIconRegister icon) 
	{
		this.blockIcon = icon.registerIcon(Util.MOD_ID + ":" + "flagIcon");
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		++l;
		l %= 4;

		if (l == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2); //2
		}
		if (l == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2); //3
		}
		if (l == 2)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2); //0
		}
		if (l == 3)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2); //1
		}
	}
}
