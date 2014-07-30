package net.bitm.tileentity;
// #Yolo
import net.bitm.bonytechmod;
import net.bitm.blocks.furnacenyt;
import net.bitm.config.settings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityNytFurnace extends TileEntity implements ISidedInventory{

	private String localizedName;
	
	private static final int[] slots_top = new int[]{0};
	private static final int[] slots_bottom = new int[]{2, 1};
	private static final int[] slots_side = new int[]{1};
	
	private ItemStack[] slots = new ItemStack[3];
	
	/**
	 * Determens furnace speed, as an int
	 */
	public int furnaceSpeed = settings.furnacespeed;
	
	/**
	 * Energy held in the furnace
	 */
	public int boos;
	
	/**
	 * Determs the mac amount of energy the furnace can hold
	 */
	public final int maxBoos = 10000;
	
	/**
	 * This grows as something is being smelted, once it reachs 
	 * the furnaceSpeed int it resets and puts out the output
	 */
	public int cookTime;
	
	@Override
	public int getSizeInventory(){
		return this.slots.length;
		
	}
	
	@Override
	public String getInventoryName(){
		return this.hasCustomInventoryName() ? this.localizedName : "container.nytfurnace";
	}
	
	@Override
	public boolean hasCustomInventoryName(){
		return this.localizedName != null && this.localizedName.length() > 0;
	}
	
	/**Set's the GUI Display name (supposebly) 
	 * 
	 * @param displayName
	 */
	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.slots[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if(this.slots[i] != null){
			ItemStack itemstack;
				
			if(this.slots[i].stackSize <= j){
				itemstack = this.slots[i];
				
				this.slots[i] = null;
				
				return itemstack;
			}else{
				itemstack = this.slots[i].splitStack(j);
				
				if(this.slots[i].stackSize == 0){
					this.slots[i] = null;
				}
				return itemstack;
			}
			
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if(this.slots[i] != null){
			ItemStack itemstack = this.slots[i];
			this.slots[i] = null;
			return itemstack;
		}
		
		
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack){
		this.slots[i] = itemstack;
		
		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()){
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		
		NBTTagList list = nbt.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];
		
		for(int i = 0; i < list.tagCount(); i++){
		NBTTagCompound compound = list.getCompoundTagAt(i);
		byte b = compound.getByte("Slot");
		
			if(b >= 0 && b < this.slots.length){
				this.slots[b] = ItemStack.loadItemStackFromNBT(compound);
			}
		}
		
		this.boos = nbt.getShort("Power");
		this.cookTime = nbt.getShort("CookTime");
		
		if(nbt.hasKey("CustomName")){
			this.localizedName = nbt.getString("CustomName");
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		
		nbt.setShort("Power", (short)this.boos);
		nbt.setShort("CookTime", (short)this.cookTime);
		
		NBTTagList list = new NBTTagList();
		
		for(int i = 0; i < this.slots.length; i++){
		
			if(this.slots[1] != null){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("Slot", (byte)i);
				this.slots[i].writeToNBT(compound);
				list.appendTag(compound);
			}	
		}
		nbt.setTag("Items", list);
		
		if(this.hasCustomInventoryName()){
			nbt.setString("CustomName", this.localizedName);
		}
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
	}
	/**
	 * Checks if the furnace has power
	 * @return
	 */
	public boolean hasPower(){
		return this.boos > 0;
	}
	/**
	 * Checks if the furnace is smelting
	 * @return
	 */
	public boolean isSmelting(){
		return this.cookTime > 0;
	}
	
	@Override
	public void updateEntity(){
		boolean flag = this.boos > 0;
		boolean flag1 = false;
		
		if(this.hasPower() && this.isSmelting()){
			this.boos--;
		}
		
		if(!this.worldObj.isRemote){
			if(TileEntityNytFurnace.hasItemPower(this.slots[1]) && this.boos <= (this.maxBoos - TileEntityNytFurnace.getItemPower(this.slots[1]))){
				if(!this.slots[1].isItemStackDamageable()){
				
				this.boos += getItemPower(this.slots[1]);
				
				if(this.slots[1] != null){
					flag1 = true;
					
					this.slots[1].stackSize--;
					
					if(this.slots[1].stackSize == 0){
						this.slots[1] = this.slots[1].getItem().getContainerItem(this.slots[1]);
					}
				}
			}else{
				if(this.slots[1].getItemDamage() < this.slots[1].getMaxDamage()){
					this.boos += getItemPower(this.slots[1]);
					this.slots[1] = new ItemStack(this.slots[1].getItem(), this.slots[1].stackSize, this.slots[1].getItemDamage()+1);
				}
				
			}
		
		}
				
					
		if(this.hasPower() && this.canSmelt()){
			this.cookTime++;
				
			if(this.cookTime == this.furnaceSpeed){
					this.cookTime = 0;
					this.smeltItem();
					flag1 = true;
				}
			}else{
				this.cookTime = 0;
			}
			
			if(flag != this.hasPower()){
				flag1 = true;
				furnacenyt.updatefurnacenytstate(this.boos > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}	
		}
		
		if(this.hasPower()){
			flag1 = true;
		
			
			if(this.slots[1] != null){
				this.slots[1].stackSize--;
				
				if(this.slots[1].stackSize == 0){
					this.slots[1] = this.slots[1].getItem().getContainerItem(this.slots[1]);
				}
			}
			if(flag1){
				this.markDirty();
			
			}
		
		}
		
		
	}

	/**
	 * Checks if the furnace can smelt
	 * 
	 * @return
	 */
	private boolean canSmelt(){
		if(this.slots[0] == null){
			return false;
		}else{
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			
			if(itemstack == null) return false;
			if(this.slots[2] == null) return true;
			if(!this.slots[2].isItemEqual(itemstack)) return false;
			
			int result = this.slots[2].stackSize + itemstack.stackSize;
			
			return(result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
	}
	/**
	 * Smelts the item if it can.
	 */
	public void smeltItem(){
		if(this.canSmelt()){
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			
			if(this.slots[2] == null){
				this.slots[2] = itemstack.copy();
			}else if(this.slots[2].isItemEqual(itemstack)){
				this.slots[2].stackSize += itemstack.stackSize;
			}
			this.slots[0].stackSize--;
			
			if(this.slots[0].stackSize <= 0){
				this.slots[0] = null;
			}
		}
	}
	
	/**
	 * Gets the power (in boos) of the item in the power slot
	 * @param itemstack
	 * @return
	 */
	public static int getItemPower(ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();
			
			if(item == bonytechmod.basicbattery) return 1;
			
			if(item == Items.redstone) return 10;
			if(item == Items.glowstone_dust) return 20;
			if(item == Items.nether_star) return 5000;
			if(item == Item.getItemFromBlock(Blocks.redstone_block)) return 90;
			if(item == Item.getItemFromBlock(Blocks.glowstone)) return 80;
			
			
			return 0;
		}
	}
	/**
	 * Checks if the item has any power (in boos)
	 * @param itemstack
	 * @return
	 */
	public static boolean hasItemPower(ItemStack itemstack){
		return getItemPower(itemstack) > 0;
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return i == 2 ? false : (i == 1 ? hasItemPower(itemstack) : true);
	}


	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_side);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
	}

	/**
	 * Gets the power remaining scaled (whatever that means :P)
	 * @param i
	 * @return
	 */
	public int getPowerRemainingScaled(int i){
		return this.boos * i / this.maxBoos;
	}
	/**
	 * Get the cooktime progress scaled
	 * @param i
	 * @return
	 */
	public int getCookTimeProgressScaled(int i){
		return this.cookTime * i / this.furnaceSpeed;
	}

	/**
	 * This is what happen when you open a GUI
	 */
	@Override
	public void openInventory() {
		
	}

	/**
	 * This is what happen when you close a GUI
	 */
	@Override
	public void closeInventory() {
		
	}
}

