package net.bitm.blocks;

import java.util.Random;

import net.bitm.creativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ChoclateCake extends Block{
	// #BlameSheen
	@SideOnly(Side.CLIENT)
	public IIcon cakeTopIcon;
	
	@SideOnly(Side.CLIENT)
	public IIcon cakeBottomIcon;
	
	@SideOnly(Side.CLIENT)
	public IIcon cakeInner;
	
	@SideOnly(Side.CLIENT)
	public IIcon blockIcon;

	public ChoclateCake(Material material){
		super(Material.cake);
        this.setTickRandomly(true);
		this.setCreativeTab(creativeTab.bonetabDeco);
		this.setBlockName("choclatecake");
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z){
        int l = access.getBlockMetadata(x, y, z);
        float f = 0.0625F;
        float f1 = (1 + l * 2) / 16.0F;
        float f2 = 0.5F;
        this.setBlockBounds(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    @Override
	public void setBlockBoundsForItemRender(){
        float f = 0.0625F;
        float f1 = 0.5F;
        this.setBlockBounds(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
        int l = world.getBlockMetadata(x, y, z);
        float f = 0.0625F;
        float f1 = (1 + l * 2) / 16.0F;
        float f2 = 0.5F;
        return AxisAlignedBB.getBoundingBox(x + f1, y, z + f, x + 1 - f, y + f2 - f, z + 1 - f);
    }

    /**
     * Does shit
     */
    @Override
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z){
        int l = world.getBlockMetadata(x, y, z);
        float f = 0.0625F;
        float f1 = (1 + l * 2) / 16.0F;
        float f2 = 0.5F;
        //return AxisAlignedBB.getAABBPool().getAABB((double)((float)x + f1), (double)y, (double)((float)z + f), (double)((float)(x + 1) - f), (double)((float)y + f2), (double)((float)(z + 1) - f));
        return AxisAlignedBB.getBoundingBox(x + f1, y, z + f, x + 1 - f, y + f2, z + 1 - f);
    }


	@Override
	public IIcon getIcon(int side, int meta){
		return side == 1 ? this.cakeTopIcon : (side == 0 ? this.cakeBottomIcon : (meta > 0 && side == 4 ? this.cakeInner : this.blockIcon));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		this.blockIcon = register.registerIcon("bitm" + ":" + "chocolateCake_side");
		this.cakeInner = register.registerIcon("bitm" + ":" + "chocolateCake_inner");
		this.cakeTopIcon = register.registerIcon("bitm" + ":" + "chocolateCake_top");
		this.cakeBottomIcon = register.registerIcon("bitm" + ":" + "chocolateCake_bottom");
	}

	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}

	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		this.eatYourGreenBeans(world, x, y, z, player);
		return true;
	}

	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){
		this.eatYourGreenBeans(world, x, y, z, player);
	}

	private void eatYourGreenBeans(World world, int x, int y, int z, EntityPlayer player){
		if (player.canEat(false)){
			player.getFoodStats().addStats(2, 0.1F);
			int l = world.getBlockMetadata(x, y, z) + 1;

			if (l >= 6){
				world.setBlockToAir(x, y, z);
			}else{
				world.setBlockMetadataWithNotify(x, y, z, l, 2);
			}
		}
	}

	 @Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z){
		 return !super.canPlaceBlockAt(world, x, y, z) ? false : this.canBlockStay(world, x, y, z);
	 }

	 @Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor){
		 if (!this.canBlockStay(world, x, y, z)){
			 world.setBlockToAir(x, y, z);
		 }
	 }

	 @Override
	public boolean canBlockStay(World world, int x, int y, int z){
		 return world.getBlock(x, y - 1, z).getMaterial().isSolid();
	 }

	 @Override
	public int quantityDropped(Random rand){
		 return 0;
	 }

	 @Override
	public Item getItemDropped(int idkwhatthisintis, Random rand, int idkaboutthiseithe){
		 return null;
	 }

	 @SideOnly(Side.CLIENT)
	 public Item func_149694_d(World world, int x, int y, int z){
		 return Item.getItemFromBlock(this);
	 }
}
