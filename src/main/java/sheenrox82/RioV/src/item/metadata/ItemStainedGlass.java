package sheenrox82.RioV.src.item.metadata;

import sheenrox82.RioV.src.base.TheMistsOfRioV;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStainedGlass extends ItemBlock
{
	public ItemStainedGlass(Block par1)
	{
		super(par1);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack)
	{
		String name = "";
		switch(itemstack.getItemDamage())
		{
		case 0:
		{
			name = "pattern1"; break;
		}
		case 1:
		{
			name = "pattern2"; break;
		}
		case 2:
		{
			name = "pattern3"; break;
		}
		case 3:
		{
			name = "pattern4"; break;
		}
		default: name = "broken";
		}
		return getUnlocalizedName() + "." + name;
	}

	public int getMetadata(int par1)
	{
		return par1;
	}
}
