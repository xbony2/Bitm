package sheenrox82.RioV.src.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.api.recipe.manager.InfuserManager;
import sheenrox82.RioV.src.slot.SlotInfuser;
import sheenrox82.RioV.src.tileentity.TileEntityInfuser;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerInfuser extends Container
{
	private TileEntityInfuser infuser;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;

    public ContainerInfuser(InventoryPlayer par1InventoryPlayer, TileEntityInfuser par2TileEntityInfusionAltar)
    {
        this.infuser = par2TileEntityInfusionAltar;
        
        this.addSlotToContainer(new Slot(par2TileEntityInfusionAltar, 0, 56, 35));
        this.addSlotToContainer(new Slot(par2TileEntityInfusionAltar, 1, 16, 35));
        //this.addSlotToContainer(new Slot(par2TileEntityInfusionAltar, 2, 116, 35));
        this.addSlotToContainer(new SlotInfuser(par1InventoryPlayer.player, par2TileEntityInfusionAltar, 2, 116, 35));

        int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
        }
    }

    @Override
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.infuser.altarCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.infuser.altarBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.infuser.currentItemBurnTime);
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int var1 = 0; var1 < this.crafters.size(); ++var1)
        {
            ICrafting var2 = (ICrafting)this.crafters.get(var1);

            if (this.lastCookTime != this.infuser.altarCookTime)
            {
                var2.sendProgressBarUpdate(this, 0, this.infuser.altarCookTime);
            }

            if (this.lastBurnTime != this.infuser.altarBurnTime)
            {
                var2.sendProgressBarUpdate(this, 1, this.infuser.altarBurnTime);
            }

            if (this.lastItemBurnTime != this.infuser.currentItemBurnTime)
            {
                var2.sendProgressBarUpdate(this, 2, this.infuser.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.infuser.altarCookTime;
        this.lastBurnTime = this.infuser.altarBurnTime;
        this.lastItemBurnTime = this.infuser.currentItemBurnTime;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.infuser.altarCookTime = par2;
        }

        if (par1 == 1)
        {
            this.infuser.altarBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.infuser.currentItemBurnTime = par2;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.infuser.isUseableByPlayer(par1EntityPlayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0)
            {
                if (InfuserManager.getInfuser().getResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityInfuser.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 3 && par2 < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
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

        return itemstack;
    }
}
