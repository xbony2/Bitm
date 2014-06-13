package net.bitm.gui;

import net.bitm.bonytechmod;
import net.bitm.blocks.TileEntityIronFurnace;
import net.bitm.blocks.TileEntityNytFurnace;
import net.bitm.blocks.TileEntityNytTrit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class guihandler implements IGuiHandler{
	
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
			case bonytechmod.guiIdNytFurnace:
				if(entity instanceof TileEntityNytFurnace){
					return new ContainerNytFurnace(player.inventory, (TileEntityNytFurnace) entity);
				}
			
			case bonytechmod.guiIdIronFurnace:
				if(entity instanceof TileEntityIronFurnace){
					return new ContainerIronFurnace(player.inventory, (TileEntityIronFurnace) entity);
				}
				
			case bonytechmod.guiIdNytTrit:
				if(entity instanceof TileEntityNytTrit){
					return new ContainerNytTrit(player.inventory, (TileEntityNytTrit) entity);
				}
			}
		}
		
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
			case bonytechmod.guiIdNytFurnace:
				if(entity instanceof TileEntityNytFurnace){
					return new GuiNytFurnace(player.inventory, (TileEntityNytFurnace) entity);
				}
			case bonytechmod.guiIdIronFurnace:
				if(entity instanceof TileEntityIronFurnace){
					return new GuiIronFurnace(player.inventory, (TileEntityIronFurnace) entity);
				}
			case bonytechmod.guiIdNytTrit:
				if(entity instanceof TileEntityNytTrit){
					return new GuiNytTrit(player.inventory, (TileEntityNytTrit) entity);
				}
			}
			
		}
		
		return null;
	}

}
