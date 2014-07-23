package net.bitm.blocks;

import java.util.Random;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bitm.bonytechmod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class furnaceiron extends BlockContainer{

	
	private Random rand = new Random();
	
	private final boolean isactive;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconfront;
	
	private static boolean keepInventory;
	
	public furnaceiron(boolean isactive) {
		super(Material.rock);
		
		//this.setHardness(2F);
	    //this.setStepSound(soundStoneFootstep);
		//this.setResistance(5);
		
		this.isactive = isactive;
	}
	
		@Override
		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister register){
			this.blockIcon = register.registerIcon("minecraft" + ":" + "iron_block");
			this.iconfront = register.registerIcon("bitm" + ":" + (this.isactive ? "ironfurnacefrontlit" : "ironfurnacefrontunlit"));
		}
		
		//@SideOnly(Side.CLIENT)
		@Override
		public IIcon getIcon(int Side, int metadata){
			return metadata == 0 && Side == 3 ? this.iconfront : (Side == metadata ? this.iconfront : this.blockIcon);
		}
		
		@Override
		public Item getItemDropped(int par1, Random random, int par2){
			return Item.getItemFromBlock(bonytechmod.furnaceironidle);
		}
		
		@Override
		public void onBlockAdded(World world, int x, int y, int z){
			super.onBlockAdded(world, x, y, z);
			this.setDefaultDirection(world, x, y, z);
		}

		private void setDefaultDirection(World world, int x, int y, int z){
			if(!world.isRemote){
				Block block1 = world.getBlock(x, y, z - 1);
				Block block2 = world.getBlock(x, y, z + 1);
				Block block3 = world.getBlock(x - 1, y, z);
				Block block4 = world.getBlock(x + 1, y, z);
				byte b0 = 3;
				
				if(block1.func_149730_j() && ! block2.func_149730_j()){
					b0 = 3;
				}
				
				if(block2.func_149730_j() && ! block1.func_149730_j()){
					b0 = 2;
				}
				
				if(block3.func_149730_j() && ! block4.func_149730_j()){
					b0 = 5;
				}
				
				if(block4.func_149730_j() && ! block3.func_149730_j()){
					b0 = 4;
				}
				
				world.setBlockMetadataWithNotify(x, y, z, b0, 2);

			}
			
		}
		
		
		@Override
		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
			if(!world.isRemote){
				FMLNetworkHandler.openGui(player, bonytechmod.instance, bonytechmod.guiIdIronFurnace, world, x, y, z);
			}
			
			return true;
		}
		
		@Override
		public TileEntity createNewTileEntity(World world, int i){
			return new TileEntityIronFurnace();
		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public void randomDisplayTick(World world, int x, int y, int z, Random random){
			if(this.isactive){
				int direction = world.getBlockMetadata(x, y, z);
				
				float x1 = x + 0.5F;
				float y1 = y + random.nextFloat();
				float z1 = z + 0.5F;
				
				float f = 0.52F;
				float f1 = random.nextFloat() * 0.6F - 0.3F;
				
				if(direction == 4){
					world.spawnParticle("smoke", x1 - f, y1, z1 + f1, 0D, 0D, 0D);
					world.spawnParticle("flame", x1 - f, y1, z1 + f1, 0D, 0D, 0D);
				}else if(direction == 5){
					world.spawnParticle("smoke", x1 + f, y1, z1 + f1, 0D, 0D, 0D);
					world.spawnParticle("flame", x1 + f, y1, z1 + f1, 0D, 0D, 0D);
				
				}else if(direction == 2){
					world.spawnParticle("smoke", x1 + f1, y1, z1 - f, 0D, 0D, 0D);
					world.spawnParticle("flame", x1 + f1, y1, z1 - f, 0D, 0D, 0D);
				
				}else if(direction == 3){
					world.spawnParticle("smoke", x1 + f1, y1, z1 + f, 0D, 0D, 0D);
					world.spawnParticle("flame", x1 + f1, y1, z1 + f, 0D, 0D, 0D);
				
				}
 			}
		}
		
		@Override
		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack){
			int l = MathHelper.floor_double(entityLivingBase.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
			
			if(l == 0){
				world.setBlockMetadataWithNotify(x, y, z, 2, 2);
			}
			
			if(l == 1){
				world.setBlockMetadataWithNotify(x, y, z, 5, 2);
			}
			
			if(l == 2){
				world.setBlockMetadataWithNotify(x, y, z, 3, 2);
			}
			
			if(l == 3){
				world.setBlockMetadataWithNotify(x, y, z, 4, 2);
			}
			
			if(itemstack.hasDisplayName()){
				((TileEntityIronFurnace)world.getTileEntity(x, y, z)).setGuiDisplayName(itemstack.getDisplayName());
			}
		
		}
		
		public static void updatefurnaceironstate(boolean active, World worldObj, int xCoord, int yCoord, int zCoord){
			int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
			TileEntity tileentity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
			keepInventory = true;
			
			if(active){
				worldObj.setBlock(xCoord, yCoord, zCoord, bonytechmod.furnaceironactive);
			}else{
				worldObj.setBlock(xCoord, yCoord, zCoord, bonytechmod.furnaceironidle);
			}
			
			keepInventory = false;
			
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
			
			if(tileentity != null){
				tileentity.validate();
				worldObj.setTileEntity(xCoord, yCoord, zCoord, tileentity);
			}
			
		}
		
		@Override
		public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetaData){
			if(!keepInventory){
				TileEntityIronFurnace tileentity = (TileEntityIronFurnace) world.getTileEntity(x, y, z);
				
				if(tileentity != null){
					for(int i = 0; i < tileentity.getSizeInventory(); i++){
						ItemStack itemstack = tileentity.getStackInSlot(i);
						
						if(itemstack != null){
							float f = this.rand.nextFloat() * 0.8F + 0.1F;
							float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
							float f2 = this.rand.nextFloat() * 0.8F + 0.1F;
							
							
							while(itemstack.stackSize > 0){
								int j = this.rand.nextInt(21) + 10;
								
								if(j > itemstack.stackSize){ 
									j = itemstack.stackSize;
								}
								
								itemstack.stackSize -= j;
								
								EntityItem item = new EntityItem(world, x + f, y + f1, z + f2, new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
								
								if(itemstack.hasTagCompound()){
									item.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
								}
							
								float f3 = 0.05F;
								item.motionX = (float)this.rand.nextGaussian() * f3;
								item.motionY = (float)this.rand.nextGaussian() * f3 + 0.2F;
								item.motionZ = (float)this.rand.nextGaussian()* f3;
								
								world.spawnEntityInWorld(item);
							}
					
						}
					}
					
					world.func_147453_f(x, y, z, oldblock);
				}
			}
			
			super.breakBlock(world, x, y, z, oldblock, oldMetaData);
			
		}
		
		@Override
		public boolean hasComparatorInputOverride(){
			return true;
			
		}
		
		@Override
		public int getComparatorInputOverride(World world, int x, int y, int z, int i){
			return Container.calcRedstoneFromInventory((IInventory)world.getTileEntity(x, y, z));
		}
		
		@Override
		public Item getItem(World world, int x, int y, int z){
			return Item.getItemFromBlock(bonytechmod.furnaceironidle);
		}
		
		
}

		
