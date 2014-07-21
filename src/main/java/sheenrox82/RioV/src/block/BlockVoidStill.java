package sheenrox82.RioV.src.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.util.Util;

public class BlockVoidStill extends BlockStaticLiquid
{
	public IIcon blockIcon;
	
	public BlockVoidStill() 
	{
		super(Material.water);
		this.setCreativeTab(null);
	}

	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return blockIcon;
    }
	
	@Override
	public void registerBlockIcons(IIconRegister i)
	{
		this.blockIcon = i.registerIcon(Util.MOD_ID + ":" + "voidStill");
	}
    
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
    	if (par5Entity instanceof EntityLivingBase)
    	{
    		((EntityLivingBase)par5Entity).addPotionEffect(new PotionEffect(Potion.wither.getId(), 50, 2));
    	}
	}
}
