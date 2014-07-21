package sheenrox82.RioV.src.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBricks extends Block
{
	public static final String[] brickList = new String[] {"amethyst", "onyx", "blindonite", "dragon", "vravinite", "aleris", "jaavik", "nironite", "garnet", "drakiuz"};

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public BlockBricks()
	{
		super(Material.rock);
		this.setStepSound(this.soundTypeStone);
		this.setCreativeTab(RioVAPI.getInstance().tab);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return this.iconArray[par2];
	}

	@Override
	public int damageDropped(int p_149692_1_)
	{
		return p_149692_1_;
	}

	public static int func_150032_b(int p_150032_0_)
	{
		return func_150031_c(p_150032_0_);
	}

	public static int func_150031_c(int p_150031_0_)
	{
		return ~p_150031_0_ & 15;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for(int i = 0; i < brickList.length; ++i)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.iconArray = new IIcon[brickList.length];

		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = par1IconRegister.registerIcon(Util.MOD_ID + ":" + brickList[i] + "Bricks");
		}
	}
}
