package sheenrox82.RioV.src.api.item;

import java.lang.reflect.Field;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVArmor extends ItemArmor
{
	public String armorNamePrefix;
	public ArmorMaterial material;
	public boolean isInfused;

	public RioVArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4, String armornamePrefix, boolean par5)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.material = par2EnumArmorMaterial;
		this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
		this.setCreativeTab(RioVAPI.getInstance().tab);
		this.armorNamePrefix = armornamePrefix;
		this.isInfused = par5;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.toString().contains("leggings")) 
		{
			return RioVAPI.mod_id + ":" + "textures/armor/" + armorNamePrefix + "_2.png";
		}
		if (stack.toString().contains("Leggings")) 
		{
			return RioVAPI.mod_id + ":" + "textures/armor/" + armorNamePrefix + "_2.png";
		}

		return RioVAPI.mod_id + ":" + "textures/armor/" + armorNamePrefix + "_1.png";
	}

	@Override
	public ArmorMaterial getArmorMaterial()
	{
		return this.material;
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if(isInfused)
		{
			return true;
		}

		return par1ItemStack.isItemEnchanted();
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		ItemStack boots = player.getEquipmentInSlot(1);
		ItemStack leggings = player.getEquipmentInSlot(2);
		ItemStack chestplate = player.getEquipmentInSlot(3);
		ItemStack helmet = player.getEquipmentInSlot(4);

		if(boots != null) 
		{
			if(boots.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("magickaBoots")))
			{
				player.fallDistance = 0.0F;
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 5, 2));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 5, 0));
			}
			if(boots.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("bootsOfFlame")))
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5, 1));
			}
		}

		if(chestplate != null) 
		{
			if(chestplate.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("magickaChestplate")))
			{
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5, 2));
			}
			if(chestplate.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("chestplateOfFlame")))
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5, 1));
			}
		}

		if(leggings != null) 
		{
			if(leggings.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("magickaLeggings")))
			{
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 5, 0));
			}
			if(leggings.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("leggingsOfFlame")))
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5, 1));
			}
		}

		if(helmet != null) 
		{
			if(helmet.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("magickaHelmet")))
			{
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 5, 0));
			}
			if(helmet.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("helmetOfFlame")))
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5, 1));
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{		
		this.itemIcon = par1IconRegister.registerIcon(RioVAPI.mod_id + ":" + RioVAPIUtil.getName(this.getUnlocalizedName()));

		if (RioVAPI.getInstance().botania)
		{
			if (this == RioVAPI.getInstance().getUtil().getRioVItem("infusedManasteelHelm"))this.itemIcon = par1IconRegister.registerIcon("Botania:manasteelHelm");
			if (this == RioVAPI.getInstance().getUtil().getRioVItem("infusedManasteelChest"))this.itemIcon = par1IconRegister.registerIcon("Botania:manasteelChest");
			if (this == RioVAPI.getInstance().getUtil().getRioVItem("infusedManasteelLegs"))this.itemIcon = par1IconRegister.registerIcon("Botania:manasteelLegs");
			if (this == RioVAPI.getInstance().getUtil().getRioVItem("infusedManasteelBoots"))this.itemIcon = par1IconRegister.registerIcon("Botania:manasteelBoots");
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if(RioVAPI.getInstance().getUtil().getConfigBool("showToolInfo") == true)
		{
			var3.add(Color.GOLD + (var1.getMaxDamage() - var1.getItemDamage()) + " Uses");
			var3.add(Color.DARK_PURPLE + "Protection: " + RioVArmor.getMaxDamageFactor(material));
		}
	}

	public static int getMaxDamageFactor(ArmorMaterial material)
	{
		int maxDamageFactor = 0;

		try 
		{
			Field fMaxDamageFactor = material.getClass().getDeclaredField("maxDamageFactor");
			fMaxDamageFactor.setAccessible(true);
			maxDamageFactor = fMaxDamageFactor.getInt(material);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return maxDamageFactor;
	}
}