package sheenrox82.RioV.src.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.content.Materials;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStainedGlass extends Block
{
	public static final String[] glass = new String[] {"pattern1", "pattern2", "pattern3", "pattern4"};

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public BlockStainedGlass()
	{
		super(Materials.customMaterial);
		this.setStepSound(this.soundTypeGlass);
		this.setCreativeTab(RioVAPI.getInstance().tab);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
		return this.iconArray[p_149691_2_ % this.iconArray.length];
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
    public int getRenderBlockPass()
    {
        return 1;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }
    
	@Override
	public int damageDropped(int par1)
	{
		return par1;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for(int i = 0; i < glass.length; ++i)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.iconArray = new IIcon[glass.length];

		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = par1IconRegister.registerIcon(Util.MOD_ID + ":" + glass[i] + "Glass");
		}
	}
}
