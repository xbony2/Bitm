package sheenrox82.RioV.src.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.EosUtil;
import sheenrox82.RioV.src.api.util.PlayerNBT;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;
import sheenrox82.RioV.src.content.RioVItems;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVDrinkable extends ItemFood
{
	public int foodEffectRand;

	public RioVDrinkable(int par2, float par3, boolean par4)
	{
		super(par2, par3, par4);
		this.setMaxStackSize(1);
		this.setCreativeTab(RioVAPI.getInstance().tab);
	}

	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		if (!entityPlayer.capabilities.isCreativeMode)
		{
			--itemStack.stackSize;
		}

		if(itemStack.getItem().equals(RioVItems.wine))
		{
			foodEffectRand = itemRand.nextInt(3);

			if (foodEffectRand == 0)
			{
				--itemStack.stackSize;
				entityPlayer.getFoodStats().func_151686_a(this, itemStack);
				world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				this.onFoodEaten(itemStack, world, entityPlayer);
				return itemStack.stackSize <= 0 ? new ItemStack(RioVItems.wineGlass) : itemStack;
			}
			if (foodEffectRand == 1)
			{
				--itemStack.stackSize;
				entityPlayer.getFoodStats().func_151686_a(this, itemStack);
				world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				entityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 1000, 6));//again, sets effect an time
				this.onFoodEaten(itemStack, world, entityPlayer);
				return itemStack.stackSize <= 0 ? new ItemStack(RioVItems.wineGlass) : itemStack;
			}
			if (foodEffectRand == 2)
			{
				--itemStack.stackSize;
				entityPlayer.getFoodStats().func_151686_a(this, itemStack);
				world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				this.onFoodEaten(itemStack, world, entityPlayer);
				return itemStack.stackSize <= 0 ? new ItemStack(RioVItems.wineGlass) : itemStack;			}
		}

		if(itemStack.getItem().equals(RioVItems.spicedWine))
		{
			foodEffectRand = itemRand.nextInt(3);

			if (foodEffectRand == 0)
			{
				--itemStack.stackSize;
				entityPlayer.getFoodStats().func_151686_a(this, itemStack);
				world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				this.onFoodEaten(itemStack, world, entityPlayer);
				return itemStack.stackSize <= 0 ? new ItemStack(RioVItems.wineGlass) : itemStack;
			}
			if (foodEffectRand == 1)
			{
				--itemStack.stackSize;
				entityPlayer.getFoodStats().func_151686_a(this, itemStack);
				world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				entityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 10 * 20, 2));//again, sets effect an time
				this.onFoodEaten(itemStack, world, entityPlayer);
				return itemStack.stackSize <= 0 ? new ItemStack(RioVItems.wineGlass) : itemStack;

			}
			if (foodEffectRand == 2)
			{
				--itemStack.stackSize;
				entityPlayer.getFoodStats().func_151686_a(this, itemStack);
				world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				this.onFoodEaten(itemStack, world, entityPlayer);
				return itemStack.stackSize <= 0 ? new ItemStack(RioVItems.wineGlass) : itemStack;
			}
		}

		if(itemStack.getItem().equals(RioVItems.eosPotion))
		{
			PlayerNBT player = PlayerNBT.get(entityPlayer);

			--itemStack.stackSize;
			EosUtil.replenishEos();
			entityPlayer.getFoodStats().func_151686_a(this, itemStack);
			world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			this.onFoodEaten(itemStack, world, entityPlayer);
			return itemStack.stackSize <= 0 ? new ItemStack(Items.glass_bottle) : itemStack;		
		}

		return itemStack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 32;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.drink;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		PlayerNBT player = PlayerNBT.get(par3EntityPlayer);

		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));

		return par1ItemStack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + RioVAPIUtil.getName(this.getUnlocalizedName()));
	}
}
