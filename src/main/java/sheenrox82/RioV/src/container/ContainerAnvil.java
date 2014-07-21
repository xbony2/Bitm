package sheenrox82.RioV.src.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.recipe.manager.AnvilCraftingManager;
import sheenrox82.RioV.src.content.RioVBlocks;

public class ContainerAnvil extends Container
{

	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 5, 5);
	public IInventory craftResult = new InventoryCraftResult();
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;

	public ContainerAnvil(InventoryPlayer inventoryplayer, World world, int x, int y, int z)
	{
		worldObj = world;
		posX = x;
		posY = y;
		posZ = z;
		this.addSlotToContainer(new SlotCrafting(inventoryplayer.player, craftMatrix, craftResult, 0, 129, 44));
		int x1;
		int y1;

		for(y1 = 0; y1 < 4; y1++)
		{
			for(x1 = 0; x1 < 3; x1++)
			{
				this.addSlotToContainer(new Slot(craftMatrix, x1 + y1 * 5, 44 + x1 * 18, 8 + y1 * 18));
			}

		}

		for(x1 = 0; x1 < 3; x1++)
		{
			for(y1 = 0; y1 < 9; y1++)
			{
				this.addSlotToContainer(new Slot(inventoryplayer, y1 + x1 * 9 + 9, 8 + y1 * 18, 97 + x1 * 18));
			}
		}

		for(x1 = 0; x1 < 9; x1++)
		{
			this.addSlotToContainer(new Slot(inventoryplayer, x1, 8 + x1 * 18, 155));
		}

		onCraftMatrixChanged(craftMatrix);
	}

	public void onCraftMatrixChanged(IInventory iinventory)
	{
		craftResult.setInventorySlotContents(0, AnvilCraftingManager.instance.findMatchingRecipe(craftMatrix, worldObj));
	}

	public void onContainerClosed(EntityPlayer entityplayer)
	{
		super.onContainerClosed(entityplayer);
		if(worldObj.isRemote)
		{
			return;
		}
		for (int i = 0; i < 25; ++i)
		{
			ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

			if (itemstack != null)
			{
				entityplayer.dropPlayerItemWithRandomChoice(itemstack, true);
			}
		}
	}

	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	{
		return true;
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)inventorySlots.get(par2);
		if(slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if(par2 == 0)
			{
				if(!mergeItemStack(itemstack1, 10, 46, true))
				{
					return null;
				}
			} else
				if(par2 >= 10 && par2 < 37)
				{
					if(!mergeItemStack(itemstack1, 37, 46, false))
					{
						return null;
					}
				} else
					if(par2 >= 37 && par2 < 46)
					{
						if(!mergeItemStack(itemstack1, 10, 37, false))
						{
							return null;
						}
					} else
						if(!mergeItemStack(itemstack1, 10, 46, false))
						{
							return null;
						}
			if(itemstack1.stackSize == 0)
			{
				slot.putStack(null);
			} else
			{
				slot.onSlotChanged();
			}
			if(itemstack1.stackSize != itemstack.stackSize)
			{
				slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
			} else
			{
				return null;
			}
		}
		return itemstack;
	}
}