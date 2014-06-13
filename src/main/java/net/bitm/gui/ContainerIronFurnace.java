package net.bitm.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bitm.blocks.TileEntityIronFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ContainerIronFurnace extends Container{

	private TileEntityIronFurnace nytFurnace;

	public int lastBurnTime;
	
	public int lastItemBurnTime;
	
	public int lastCookTime;
	
	public ContainerIronFurnace(InventoryPlayer inventory, TileEntityIronFurnace tileentity){
		this.nytFurnace = tileentity;
		
		this.addSlotToContainer(new Slot(tileentity, 0, 56, 17));
		this.addSlotToContainer(new Slot(tileentity, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 2, 116, 35));
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(inventory, j + i*9 + 9, 8 + j*18, 84 + i*18));
			}
		}
		
		for(int i = 0; i < 9; i++){
			this.addSlotToContainer(new Slot(inventory, i, 8 + i*18, 142));
		}
	}
	
	
	public void addCraftingToCrafters(ICrafting icrafting){
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.nytFurnace.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.nytFurnace.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.nytFurnace.currentItemBurnTime);
	}
	
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.crafters.size(); i++){
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.nytFurnace.cookTime){
				icrafting.sendProgressBarUpdate(this, 0, this.nytFurnace.cookTime);
			}
			
			if(this.lastBurnTime != this.nytFurnace.burnTime){
				icrafting.sendProgressBarUpdate(this, 1, this.nytFurnace.burnTime);
			}
			
			if(this.lastItemBurnTime != this.nytFurnace.currentItemBurnTime){
				icrafting.sendProgressBarUpdate(this, 2, this.nytFurnace.currentItemBurnTime);
			}
		}
		this.lastCookTime = this.nytFurnace.cookTime;
		this.lastBurnTime = this.nytFurnace.burnTime;
		this.lastItemBurnTime = this.nytFurnace.currentItemBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int newValue){
		if(slot == 0) this.nytFurnace.cookTime = newValue;
		if(slot == 1) this.nytFurnace.burnTime = newValue;
		if(slot == 2) this.nytFurnace.currentItemBurnTime = newValue;
	}	
	
	public ItemStack transferStackInSlot(EntityPlayer player, int clickedSlotNumber){
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(clickedSlotNumber);
		
		if(slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if(clickedSlotNumber == 2){
				if(!this.mergeItemStack(itemstack1, 3, 39, true)){
					return null;
				}
				
				slot.onSlotChange(itemstack1, itemstack);
			}else if(clickedSlotNumber != 1 && clickedSlotNumber != 0){
				if(FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null){
					if(!this.mergeItemStack(itemstack1, 0, 1, false)){
						return null;
					}
				}else if(TileEntityIronFurnace.isItemFuel(itemstack1)){
					if(!this.mergeItemStack(itemstack1, 1, 2, false)){
						return null;
					}
				}else if(clickedSlotNumber >= 3 && clickedSlotNumber < 30){
					if(!this.mergeItemStack(itemstack1, 30, 39, false)){
						return null;
					}
				}else if(clickedSlotNumber >= 30 && clickedSlotNumber < 39){
					if(!this.mergeItemStack(itemstack1, 3, 30, false)){
						return null;
					}
				}
			}else if(!this.mergeItemStack(itemstack1, 3, 39, false)){
				return null;
				
				}
			
			if(itemstack1.stackSize == 0){
				slot.putStack((ItemStack)null);
			}else{
				slot.onSlotChanged();
			}
		
			if(itemstack1.stackSize == itemstack.stackSize){
				return null;
			}
			
			slot.onPickupFromSlot(player, itemstack1);
		
		}
			
		
		return itemstack;
	}
	
	
	
	public boolean canInteractWith(EntityPlayer entityplayer){
		return this.nytFurnace.isUseableByPlayer(entityplayer);
	}

}
