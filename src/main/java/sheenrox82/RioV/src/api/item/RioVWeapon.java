package sheenrox82.RioV.src.api.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVWeapon extends ItemSword
{
	public float weaponDamage;
	public final ToolMaterial toolMaterial;
	public boolean isInfused;

	public RioVWeapon(ToolMaterial par2EnumToolMaterial, boolean par2)
	{
		super(par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
		this.maxStackSize = 1;
		this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
		this.setCreativeTab(RioVAPI.getInstance().tab);
		this.weaponDamage = 4 + par2EnumToolMaterial.getDamageVsEntity();
		this.isInfused = par2;
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if (isInfused)
		{
			return true;
		}

		return par1ItemStack.isItemEnchanted();
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		if(par1ItemStack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("axeOfAunTun")))
		{
			par2EntityLivingBase.setFire(30);
		}

		if(par1ItemStack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("swordOfFlame")))
		{
			par2EntityLivingBase.setFire(10);
		}

		if(par1ItemStack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("daetoriSword")))
		{
			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 3));
		}

		if(par1ItemStack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("alerisSword")))
		{
			par2EntityLivingBase.motionY = 1;
		}

		if (EnchantmentHelper.getEnchantmentLevel(RioVAPI.getInstance().getUtil().getRioVEnchantment("kanuutu").effectId, par1ItemStack) == 2)
		{
			par2EntityLivingBase.motionY = 0.8;
		}

		if (EnchantmentHelper.getEnchantmentLevel(RioVAPI.getInstance().getUtil().getRioVEnchantment("kanuutu").effectId, par1ItemStack) == 1)
		{
			par2EntityLivingBase.motionY = 0.7;
		}

		if (EnchantmentHelper.getEnchantmentLevel(RioVAPI.getInstance().getUtil().getRioVEnchantment("frost").effectId, par1ItemStack) == 2)
		{
			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 4));
		}

		if (EnchantmentHelper.getEnchantmentLevel(RioVAPI.getInstance().getUtil().getRioVEnchantment("frost").effectId, par1ItemStack) == 1)
		{
			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 2)); 
		}

		if (EnchantmentHelper.getEnchantmentLevel(RioVAPI.getInstance().getUtil().getRioVEnchantment("venom").effectId, par1ItemStack) == 2)
		{
			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 4));
		}

		if (EnchantmentHelper.getEnchantmentLevel(RioVAPI.getInstance().getUtil().getRioVEnchantment("venom").effectId, par1ItemStack) == 1)
		{
			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 2)); 
		}

		if (EnchantmentHelper.getEnchantmentLevel(RioVAPI.getInstance().getUtil().getRioVEnchantment("confusion").effectId, par1ItemStack) == 2)
		{
			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 4));
		}

		if (EnchantmentHelper.getEnchantmentLevel(RioVAPI.getInstance().getUtil().getRioVEnchantment("confusion").effectId, par1ItemStack) == 1)
		{
			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 2)); 
		}
		
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		if(itemstack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("khuulisScythe")))
		{
			float f = 1.0F;
			float f1 = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;
			float f2 = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;
			double d = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * (double)f;
			double d1 = (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * (double)f + 1.6200000000000001D) - (double)entityplayer.yOffset;
			double d2 = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * (double)f;
			Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
			float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
			float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
			float f5 = -MathHelper.cos(-f1 * 0.01745329F);
			float f6 = MathHelper.sin(-f1 * 0.01745329F);
			float f7 = f4 * f5;
			float f8 = f6;
			float f9 = f3 * f5;
			double d3 = 5000D;
			Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3 + 1, (double)f9 * d3);
			MovingObjectPosition movingobjectposition = world.func_147447_a(vec3d, vec3d1, false, true, true);
			if (movingobjectposition == null)
			{
				return itemstack;
			}
			if (movingobjectposition.typeOfHit == MovingObjectType.BLOCK)
			{
				int i = movingobjectposition.blockX;
				int j = movingobjectposition.blockY;
				int k = movingobjectposition.blockZ;
				world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
			}
			itemstack.damageItem(1, entityplayer);
		}
		entityplayer.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
		return itemstack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if(var1.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("axeOfAunTun")))
		{
			var3.add("The most valuable and powerful weapon.");
			var3.add("Fully fused. Fully usable.");
			var3.add("Fusion: 100%");
		}

		if(var1.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("unfusedAxeOfAunTun")))
		{
			var3.add(StatCollector.translateToLocal("Unfused. Not usable."));
			var3.add(StatCollector.translateToLocal("Fusion: 0%"));
		}

		if (var1.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("halfFusedAxeOfAunTun")))
		{
			var3.add(StatCollector.translateToLocal("Half fused. Still not usable."));
			var3.add(StatCollector.translateToLocal("Fusion: 50%"));
		}

		if(RioVAPI.getInstance().getUtil().getConfigBool("showToolInfo") == true)
		{
			var3.add(Color.GOLD + (var1.getMaxDamage() - var1.getItemDamage()) + " Uses");
			var3.add(Color.DARK_PURPLE + "Damage: " + toolMaterial.getDamageVsEntity());
		}
	}

	@Override
	public EnumRarity getRarity(ItemStack par1)
	{
		if(par1.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("axeOfAunTun")) || par1.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("ultraAxeOfAunTun")) || par1.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("daetoriSword")))
		{
			return EnumRarity.epic;
		}

		return EnumRarity.common;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(RioVAPI.mod_id + ":" + RioVAPIUtil.getName(this.getUnlocalizedName()));

		if(RioVAPI.getInstance().natura)
		{
			if(this == RioVAPI.getInstance().getUtil().getRioVItem("infusedBloodwoodSword") || this == RioVAPI.getInstance().getUtil().getRioVItem("infusedGhostwoodSword") || this == RioVAPI.getInstance().getUtil().getRioVItem("infusedDarkwoodSword") || this == RioVAPI.getInstance().getUtil().getRioVItem("infusedFusewoodSword") || this == RioVAPI.getInstance().getUtil().getRioVItem("infusedNetherquartzSword"))
				this.itemIcon = par1IconRegister.registerIcon(RioVAPIUtil.getName(this.getUnlocalizedName()));
		}
	}
}
