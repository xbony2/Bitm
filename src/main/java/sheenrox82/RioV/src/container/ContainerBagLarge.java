package sheenrox82.RioV.src.container;

import sheenrox82.RioV.src.inventory.InventoryBagLarge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ContainerBagLarge extends Container
{
	public final InventoryBagLarge inventory;

	private final ItemStack containerstack;

	public boolean needsUpdate;

	private static final int INV_START = InventoryBagLarge.INV_SIZE, INV_END = INV_START+26,
			HOTBAR_START = INV_END+1, HOTBAR_END = HOTBAR_START+8;
	
	public ContainerBagLarge(EntityPlayer par1Player, InventoryPlayer inventoryPlayer, InventoryBagLarge inventoryItem)
	{
		this.inventory = inventoryItem;
		this.containerstack = par1Player.getHeldItem();

		int i;

		for (i = 0; i < InventoryBagLarge.INV_SIZE; ++i)
		{

			this.addSlotToContainer(new Slot(this.inventory, i, 80 + (18 * (int)(i/4)), 8 + (18*(i%4))));
		}

		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	public void writeToNBT()
	{
		if (!this.containerstack.hasTagCompound())
		{
			this.containerstack.setTagCompound(new NBTTagCompound());
		}
		((InventoryBagLarge) inventory).writeToNBT(this.containerstack.getTagCompound());
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return true;
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 < INV_START)
			{
				if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END+1, true))
				{
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}
			else
			{

				if (par2 >= INV_START && par2 < HOTBAR_START)
				{
					if (!this.mergeItemStack(itemstack1, HOTBAR_START, HOTBAR_END+1, false))
					{
						return null;
					}
				}
				else if (par2 >= HOTBAR_START && par2 < HOTBAR_END+1)
				{
					if (!this.mergeItemStack(itemstack1, INV_START, INV_END+1, false))
					{
						return null;
					}
				}
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}

			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		}

		this.needsUpdate = true;

		return itemstack;
	}

	@Override
	public ItemStack slotClick(int slotID, int buttonPressed, int flag, EntityPlayer player)
	{
		this.needsUpdate = true;
		return super.slotClick(slotID, buttonPressed, flag, player);
	}
}