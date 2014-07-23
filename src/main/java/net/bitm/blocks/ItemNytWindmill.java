package net.bitm.blocks;

import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemNytWindmill extends Item {

	public ItemNytWindmill(){
		super();
		this.setCreativeTab(creativeTab.bonetabMachines);
		this.setUnlocalizedName("itemNytWindmill");
		this.setTextureName("windmill");
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2){
		if(!world.isRemote){
			if(side == 1){
				world.setBlock(x, y + 1, z, bonytechmod.nytWindmill);	
			}
			
			/*if(side == 3){
				world.setBlock(x, y, z + 1, bonytechmod.nytWindmill);
			}
			if(side == 4){
				world.setBlock(x - 1, y, z, bonytechmod.nytWindmill);
			}*/
			return true;
		}
		
		return false;
		
	}
	
}
