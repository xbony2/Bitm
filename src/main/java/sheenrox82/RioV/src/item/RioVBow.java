package sheenrox82.RioV.src.item;

import java.util.List;

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
import sheenrox82.RioV.src.api.util.RioVAPIUtil;
import sheenrox82.RioV.src.content.Enchantments;
import sheenrox82.RioV.src.content.RioVItems;
import sheenrox82.RioV.src.content.Sounds;
import sheenrox82.RioV.src.entity.projectile.EntityDarknessArrow;
import sheenrox82.RioV.src.entity.projectile.EntityVraviniteArrow;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVBow extends ItemBow
{
	public EntityVraviniteArrow vraviniteArrow = new EntityVraviniteArrow(null);
	public static final String[] vravinite = new String[] {Util.MOD_ID + ":" + "vBow_pull_0", Util.MOD_ID + ":" + "vBow_pull_1", Util.MOD_ID + ":" + "vBow_pull_2"};
	public EntityDarknessArrow darknessArrow = new EntityDarknessArrow(null);
	public static final String[] wurTunBow = new String[] {Util.MOD_ID + ":" + "wBow_pull_0", Util.MOD_ID + ":" + "wBow_pull_1", Util.MOD_ID + ":" + "wBow_pull_2"};
	
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public RioVBow(int uses)
	{
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(uses);
		this.setCreativeTab(RioVAPI.getInstance().tab);
	}

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
		
		if(this == RioVItems.vraviniteBow)
		{
			if (flag || par3EntityPlayer.inventory.hasItem(RioVItems.vraviniteArrow))
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

				EntityVraviniteArrow entityarrow = new EntityVraviniteArrow(par2World, par3EntityPlayer, f * 2.0F);

				if (f == 1.0F)
				{
					entityarrow.setIsCritical(true);
				}

				int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

				if (k > 0)
				{
					entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
				}

				int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

				if (l > 0)
				{
					entityarrow.setKnockbackStrength(l);
				}

				if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
				{
					entityarrow.setFire(100);
				}

				if (EnchantmentHelper.getEnchantmentLevel(Enchantments.vicious.effectId, par1ItemStack) > 0)
				{
					entityarrow.setDamage(vraviniteArrow.damage * 1.4);	
				}

				par1ItemStack.damageItem(1, par3EntityPlayer);
				par2World.playSoundAtEntity(par3EntityPlayer, Sounds.bow.getPrefixedName(), 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

				if (flag)
				{
					entityarrow.canBePickedUp = 2;
				}
				else
				{
					par3EntityPlayer.inventory.consumeInventoryItem(RioVItems.vraviniteArrow);
				}

				if (!par2World.isRemote)
				{
					par2World.spawnEntityInWorld(entityarrow);
				}
			}
		}
		
		if(this == RioVItems.bowOfWurTun)
		{
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

				if (f == 1.0F)
				{
					entityarrow.setIsCritical(true);
				}

				int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

				if (k > 0)
				{
					entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
				}

				int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

				if (l > 0)
				{
					entityarrow.setKnockbackStrength(l);
				}

				if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
				{
					entityarrow.setFire(100);
				}

				if (EnchantmentHelper.getEnchantmentLevel(Enchantments.vicious.effectId, par1ItemStack) > 0)
				{
					entityarrow.setDamage(darknessArrow.damage * 1.4);	
				}

				par1ItemStack.damageItem(1, par3EntityPlayer);
				par2World.playSoundAtEntity(par3EntityPlayer, Sounds.bow.getPrefixedName(), 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

				if (flag)
				{
					entityarrow.canBePickedUp = 2;
				}
				else
				{
					par3EntityPlayer.inventory.consumeInventoryItem(RioVItems.darknessArrow);
				}

				if (!par2World.isRemote)
				{
					par2World.spawnEntityInWorld(entityarrow);
				}
			}
		}
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		return par1ItemStack;
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 72000;
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.bow;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return event.result;
		}
		
		if(this == RioVItems.vraviniteBow)
		{
			if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(RioVItems.vraviniteArrow))
			{
				par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
			}
		}
		
		if(this == RioVItems.bowOfWurTun)
		{
			if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(RioVItems.darknessArrow))
			{
				par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
			}
		}

		return par1ItemStack;
	}

	public int getItemEnchantability()
	{
		return 1;
	}


	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + RioVAPIUtil.getName(this.getUnlocalizedName()));

		if(this == RioVItems.vraviniteBow)
		{
			this.iconArray = new IIcon[vravinite.length];

			for (int i = 0; i < this.iconArray.length; ++i)
			{
				this.iconArray[i] = par1IconRegister.registerIcon(vravinite[i]);
			}
		}
		
		if(this == RioVItems.bowOfWurTun)
		{
			this.iconArray = new IIcon[wurTunBow.length];

			for (int i = 0; i < this.iconArray.length; ++i)
			{
				this.iconArray[i] = par1IconRegister.registerIcon(wurTunBow[i]);
			}
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

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if(RioVAPI.getInstance().getUtil().getConfigBool("showToolInfo") == true)
		{
			var3.add(var1.getMaxDamage() - var1.getItemDamage() + " Uses");
			
			if(this == RioVItems.vraviniteBow)
			{
				if (EnchantmentHelper.getEnchantmentLevel(Enchantments.vicious.effectId, var1) > 0)
				{
					var3.add("Damage: " + vraviniteArrow.damage * 1.4);
				}
				else
				{
					var3.add("Damage: " + vraviniteArrow.damage);
				}
			}
			
			if(this == RioVItems.bowOfWurTun)
			{
				if (EnchantmentHelper.getEnchantmentLevel(Enchantments.vicious.effectId, var1) > 0)
				{
					var3.add("Damage: " + darknessArrow.damage * 1.4);
				}
				else
				{
					var3.add("Damage: " + darknessArrow.damage);
				}
			}
		}
	}

}
