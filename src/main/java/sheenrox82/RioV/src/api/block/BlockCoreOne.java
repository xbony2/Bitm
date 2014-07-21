package sheenrox82.RioV.src.api.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCoreOne extends Block
{	
	public BlockCoreOne()
	{
		super(Material.rock);
		this.setCreativeTab(RioVAPI.getInstance().tab);
	}
	
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		if(this == RioVAPI.getInstance().getUtil().getRioVBlock("onyxOre"))
		{
			return RioVAPI.getInstance().getUtil().getRioVItem("onyx");
		}
		if(this == RioVAPI.getInstance().getUtil().getRioVBlock("garnetOre"))
		{
			return RioVAPI.getInstance().getUtil().getRioVItem("garnet");
		}
		if(this == RioVAPI.getInstance().getUtil().getRioVBlock("nironiteOre"))
		{
			return RioVAPI.getInstance().getUtil().getRioVItem("nironite");
		}
		if(this == RioVAPI.getInstance().getUtil().getRioVBlock("dragonOre"))
		{
			return RioVAPI.getInstance().getUtil().getRioVItem("dragonSoul");
		}
		if(this == RioVAPI.getInstance().getUtil().getRioVBlock("netherCrystal"))
		{
			return RioVAPI.getInstance().getUtil().getRioVItem("burnedQuartz");
		}
		if(this == RioVAPI.getInstance().getUtil().getRioVBlock("slate"))
		{
			return Item.getItemFromBlock(RioVAPI.getInstance().getUtil().getRioVBlock("slateCobble"));
		}
		if(this == RioVAPI.getInstance().getUtil().getRioVBlock("amethystOre"))
		{
			return RioVAPI.getInstance().getUtil().getRioVItem("amethyst");
		}
		if(this == RioVAPI.getInstance().getUtil().getRioVBlock("blindoniteOre"))
		{
			return RioVAPI.getInstance().getUtil().getRioVItem("blindonite");
		}
		if(this == RioVAPI.getInstance().getUtil().getRioVBlock("vraviniteOre"))
		{
			return RioVAPI.getInstance().getUtil().getRioVItem("vravinite");
		}
		if(this == RioVAPI.getInstance().getUtil().getRioVBlock("drakiuzOre"))
		{
			return RioVAPI.getInstance().getUtil().getRioVItem("drakiuz");
		}
		if(this == RioVAPI.getInstance().getUtil().getRioVBlock("alerisOre"))
		{
			return RioVAPI.getInstance().getUtil().getRioVItem("aleris");
		}
		if(this == RioVAPI.getInstance().getUtil().getRioVBlock("jaavikOre"))
		{
			return RioVAPI.getInstance().getUtil().getRioVItem("jaavik");
		}

		return Item.getItemFromBlock(this);
	}

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return this.blockIcon;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		blockIcon = par1IconRegister.registerIcon(RioVAPI.mod_id + ":" + RioVAPIUtil.getName(this.getUnlocalizedName()));
	} 

	@Override
	public int quantityDropped(Random par1Random)
	{
		return 1;
	}
}
