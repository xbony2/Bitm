package sheenrox82.RioV.src.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sheenrox82.RioV.src.block.BlockAnvil;
import sheenrox82.RioV.src.block.BlockRioVWorkbench;
import sheenrox82.RioV.src.container.ContainerAnvil;
import sheenrox82.RioV.src.container.ContainerBagLarge;
import sheenrox82.RioV.src.container.ContainerBagMedium;
import sheenrox82.RioV.src.container.ContainerBagSheen;
import sheenrox82.RioV.src.container.ContainerBagSmall;
import sheenrox82.RioV.src.container.ContainerInfuser;
import sheenrox82.RioV.src.container.ContainerRioVWorkbench;
import sheenrox82.RioV.src.gui.GuiAnvil;
import sheenrox82.RioV.src.gui.GuiInfuser;
import sheenrox82.RioV.src.gui.GuiLargeBag;
import sheenrox82.RioV.src.gui.GuiMediumBag;
import sheenrox82.RioV.src.gui.GuiSheenBag;
import sheenrox82.RioV.src.gui.GuiSmallBag;
import sheenrox82.RioV.src.gui.GuiWorkbench;
import sheenrox82.RioV.src.inventory.InventoryBagLarge;
import sheenrox82.RioV.src.inventory.InventoryBagMedium;
import sheenrox82.RioV.src.inventory.InventoryBagSheen;
import sheenrox82.RioV.src.inventory.InventoryBagSmall;
import sheenrox82.RioV.src.item.RioVBag;
import sheenrox82.RioV.src.tileentity.TileEntityInfuser;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){

		TileEntity tile_entity = world.getTileEntity(x, y, z);

		if(tile_entity instanceof TileEntityInfuser){

			return new ContainerInfuser(player.inventory, (TileEntityInfuser) tile_entity);
		}

		if (id == BlockRioVWorkbench.idForActivation)
		{
			return new ContainerRioVWorkbench(player.inventory, world, x, y, z);
		}

		if (id == BlockAnvil.id)
		{
			return new ContainerAnvil(player.inventory, world, x, y, z);
		}

		if(id == RioVBag.smallBagId)
		{
			return new ContainerBagSmall(player, player.inventory, new InventoryBagSmall(player.getHeldItem()));
		}

		if(id == RioVBag.mediumBagId)
		{
			return new ContainerBagMedium(player, player.inventory, new InventoryBagMedium(player.getHeldItem()));
		}

		if(id == RioVBag.largeBagId)
		{
			return new ContainerBagLarge(player, player.inventory, new InventoryBagLarge(player.getHeldItem()));
		}

		if(player.getCommandSenderName().contains("sheenrox82") || player.getCommandSenderName().contains("Mr_Simba"))
		{
			if(id == RioVBag.sheensBagId)
			{
				return new ContainerBagSheen(player, player.inventory, new InventoryBagSheen(player.getHeldItem()));
			}
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){

		TileEntity tile_entity = world.getTileEntity(x, y, z);

		if(tile_entity instanceof TileEntityInfuser){

			return new GuiInfuser(player.inventory, (TileEntityInfuser) tile_entity);
		}
		
		if (id == BlockRioVWorkbench.idForActivation)
		{
			return new GuiWorkbench(player.inventory, world, x, y, z);
		}

		if (id == BlockAnvil.id)
		{
			return new GuiAnvil(player.inventory, world, x, y, z);
		}

		if(id == RioVBag.smallBagId)
		{
			return new GuiSmallBag((ContainerBagSmall) new ContainerBagSmall(player, player.inventory, new InventoryBagSmall(player.getHeldItem())));
		}

		if(id == RioVBag.mediumBagId)
		{
			return new GuiMediumBag((ContainerBagMedium) new ContainerBagMedium(player, player.inventory, new InventoryBagMedium(player.getHeldItem())));
		}

		if(id == RioVBag.largeBagId)
		{
			return new GuiLargeBag((ContainerBagLarge) new ContainerBagLarge(player, player.inventory, new InventoryBagLarge(player.getHeldItem())));
		}

		if(player.getCommandSenderName().contains("sheenrox82") || player.getCommandSenderName().contains("Mr_Simba"))
		{
			if(id == RioVBag.sheensBagId)
			{
				return new GuiSheenBag((ContainerBagSheen) new ContainerBagSheen(player, player.inventory, new InventoryBagSheen(player.getHeldItem())));
			}
		}

		return null;
	}
}