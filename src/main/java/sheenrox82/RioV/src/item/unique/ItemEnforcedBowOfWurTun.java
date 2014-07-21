package sheenrox82.RioV.src.item.unique;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.content.Enchantments;
import sheenrox82.RioV.src.content.RioVItems;
import sheenrox82.RioV.src.content.Sounds;
import sheenrox82.RioV.src.entity.projectile.EntityDarknessArrow;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnforcedBowOfWurTun extends ItemBow
{
	public EntityDarknessArrow arrow = new EntityDarknessArrow(null);
	public static final String[] bowPullIconNameArray = new String[] {Util.MOD_ID + ":" + "ewBow_pull_0", Util.MOD_ID + ":" + "ewBow_pull_1", Util.MOD_ID + ":" + "ewBow_pull_2"};
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public ItemEnforcedBowOfWurTun()
	{
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(800);
		this.setCreativeTab(RioVAPI.getInstance().tab);
	}

	/**
	 * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	 */
	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
	{
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

		ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return;
		}
		j = event.charge;

		boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

		if (flag || par3EntityPlayer.inventory.hasItem(RioVItems.darknessArrow))
		{
			float f = (float)j / 20.0F;
			f = (f * f + f * 2.0F) / 3.0F;

			if ((double)f < 0.1D)
			{
				return;
			}

			if (f > 1.0F)
			{
				f = 1.0F;
			}

			EntityDarknessArrow entityarrow = new EntityDarknessArrow(par2World, par3EntityPlayer, f * 2.0F);
			EntityDarknessArrow entityarrow1 = new EntityDarknessArrow(par2World, par3EntityPlayer, f * 2.0F);

			entityarrow.motionX += Math.random() * 0.4 - 0.2;
			entityarrow.motionY += Math.random() * 0.4 - 0.2;
			entityarrow.motionZ += Math.random() * 0.4 - 0.2;
			entityarrow1.motionX += Math.random() * 0.4 - 0.2;
			entityarrow1.motionY += Math.random() * 0.4 - 0.2;
			entityarrow1.motionZ += Math.random() * 0.4 - 0.2;

			if (f == 1.0F)
			{
				entityarrow.setIsCritical(true);
				entityarrow1.setIsCritical(true);
			}

			int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

			if (k > 0)
			{
				entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
				entityarrow1.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
			}

			int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

			if (l > 0)
			{
				entityarrow.setKnockbackStrength(l);
				entityarrow1.setKnockbackStrength(l);
			}

			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
			{
				entityarrow.setFire(100);
				entityarrow1.setFire(100);
			}

			if (EnchantmentHelper.getEnchantmentLevel(Enchantments.vicious.effectId, par1ItemStack) > 0)
			{
				entityarrow.setDamage(arrow.damage * 1.4);	
				entityarrow1.setDamage(arrow.damage * 1.4);	
			}
			
			par1ItemStack.damageItem(1, par3EntityPlayer);
			par2World.playSoundAtEntity(par3EntityPlayer, Sounds.bow.getPrefixedName(), 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			if (flag)
			{
				entityarrow.canBePickedUp = 2;
				entityarrow1.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(RioVItems.darknessArrow);
				par3EntityPlayer.inventory.consumeInventoryItem(RioVItems.darknessArrow);
			}

			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityarrow);
				par2World.spawnEntityInWorld(entityarrow1);
			}
		}
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		return par1ItemStack;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 72000;
	}

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.bow;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return event.result;
		}

		if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(RioVItems.darknessArrow))
		{
			par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		}

		return par1ItemStack;
	}

	/**
	 * Return the enchantability factor of the item, most of the time is based on material.
	 */
	public int getItemEnchantability()
	{
		return 1;
	}


	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "enforcedBowOfWurTun");
		this.iconArray = new IIcon[bowPullIconNameArray.length];

		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = par1IconRegister.registerIcon(bowPullIconNameArray[i]);
		}
	}

	@Override
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if(player.getItemInUse() == null) return this.itemIcon;
		int var4 = stack.getMaxItemUseDuration() - useRemaining;
		if (var4 > 18)
		{
			return iconArray[2];
		}
		else if (var4 > 13)
		{
			return iconArray[1];
		}
		else if (var4 > 0)
		{
			return iconArray[0];
		}
		return iconArray[0];
	}

	public IIcon getItemIconForUseDuration(int par1)
	{
		return this.iconArray[par1];
	}
}
