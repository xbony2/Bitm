package sheenrox82.RioV.src.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.RioVBlocks;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRioVWorkbench extends BlockWorkbench
{
	@SideOnly(Side.CLIENT)
	public IIcon workbenchIconTop;
	@SideOnly(Side.CLIENT)
	public IIcon workbenchIconFront;
	@SideOnly(Side.CLIENT)
	public IIcon bottom;
	public IIcon blockIcon;
	@SuppressWarnings("rawtypes")
	public static List containerList = new ArrayList();
	public static int idForActivation = 1;
	private static BlockRioVWorkbench workbench = new BlockRioVWorkbench();

	public static BlockRioVWorkbench getInstance()
	{
		return workbench;
	}
	public BlockRioVWorkbench()
	{
		super();
		this.setStepSound(Block.soundTypeWood);
		this.setCreativeTab(RioVAPI.getInstance().tab);
	}

	@SideOnly(Side.CLIENT)

	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public IIcon getIcon(int par1, int par2)
	{
		if(this == RioVBlocks.cherryWorkbench)
		{
			return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? this.bottom : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
		}
		
		if(this == RioVBlocks.bloodWorkbench)
		{
			return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? this.bottom : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
		}
		
		if(this == RioVBlocks.glimmerwoodWorkbench)
		{
			return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? this.bottom : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
		}
		
		if(this == RioVBlocks.skywoodWorkbench)
		{
			return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? this.bottom : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
		}
		
		return this.blockIcon;
	}

	@SideOnly(Side.CLIENT)

	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		if(this == RioVBlocks.bloodWorkbench)
		{
			this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bloodWorkbench_side");
			this.workbenchIconTop = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bloodWorkbench_top");
			this.workbenchIconFront = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bloodWorkbench_front");
			this.bottom = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bloodPlanks");
		}
		
		if(this == RioVBlocks.cherryWorkbench)
		{
			this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "cherryWorkbench_side");
			this.workbenchIconTop = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "cherryWorkbench_top");
			this.workbenchIconFront = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "cherryWorkbench_front");
			this.bottom = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "cherryPlanks");
		}
		
		if(this == RioVBlocks.glimmerwoodWorkbench)
		{
			this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "workbench_side");
			this.workbenchIconTop = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "workbench_top");
			this.workbenchIconFront = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "workbench_front");
			this.bottom = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "glimmerwoodPlanks");
		}
		
		if(this == RioVBlocks.skywoodWorkbench)
		{
			this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodWorkbench_side");
			this.workbenchIconTop = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodWorkbench_top");
			this.workbenchIconFront = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodWorkbench_front");
			this.bottom = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodPlanks");
		}
	}
	
	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9)
	{
		if (var1.isRemote)
		{
			return true;
		}

		int id = this.idForActivation;
		player.openGui(TheMistsOfRioV.getInstance(), id, var1, var2, var3, var4);
		return true;
	}
}
