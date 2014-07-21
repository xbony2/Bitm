package sheenrox82.RioV.src.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;
import sheenrox82.RioV.src.entity.projectile.EntityDarkMatter;
import sheenrox82.RioV.src.util.Util;

public class RioVExplosives extends Item
{
	public RioVExplosives()
	{
		super();
		this.maxStackSize = 1;
		this.setCreativeTab(RioVAPI.getInstance().tab);
	}

	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
	{
		if(!var2.isRemote)
		{
			if (!var3.capabilities.isCreativeMode)
			{
				--var1.stackSize;
			}

			var2.spawnEntityInWorld(new EntityDarkMatter(var2, var3));
		}

		return var1;
	}

	public void registerIcons(IIconRegister i)
	{
		this.itemIcon = i.registerIcon(Util.MOD_ID + ":" + RioVAPIUtil.getName(this.getUnlocalizedName()));
	}
}