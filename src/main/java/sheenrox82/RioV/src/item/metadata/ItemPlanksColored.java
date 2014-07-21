package sheenrox82.RioV.src.item.metadata;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemPlanksColored extends ItemBlock
{
	public ItemPlanksColored(Block block)
	{
		super(block);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack)
	{
		String name = "";
		switch(itemstack.getItemDamage())
		{
		case 0:
		{
			name = "white"; break;
		}
		case 1:
		{
			name = "orange"; break;
		}
		case 2:
		{
			name = "magenta"; break;
		}
		case 3:
		{
			name = "lightBlue"; break;
		}
		case 4:
		{
			name = "yellow"; break;
		}
		case 5:
		{
			name = "lime"; break;
		}
		case 6:
		{
			name = "pink"; break;
		}
		case 7:
		{
			name = "gray"; break;
		}
		case 8:
		{
			name = "lightGray"; break;
		}
		case 9:
		{
			name = "cyan"; break;
		}
		case 10:
		{
			name = "purple"; break;
		}
		case 11:
		{
			name = "blue"; break;
		}
		case 12:
		{
			name = "brown"; break;
		}
		case 13:
		{
			name = "green"; break;
		}
		case 14:
		{
			name = "red"; break;
		}
		case 15:
		{
			name = "black"; break;
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
