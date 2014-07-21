package sheenrox82.RioV.src.item.metadata;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBricks extends ItemBlock
{
	public ItemBricks(Block block)
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
			name = "amethyst"; break;
		}
		case 1:
		{
			name = "onyx"; break;
		}
		case 2:
		{
			name = "blindonite"; break;
		}
		case 3:
		{
			name = "dragon"; break;
		}
		case 4:
		{
			name = "vravinite"; break;
		}
		case 5:
		{
			name = "aleris"; break;
		}
		case 6:
		{
			name = "jaavik"; break;
		}
		case 7:
		{
			name = "nironite"; break;
		}
		case 8:
		{
			name = "garnet"; break;
		}
		case 9:
		{
			name = "drakiuz"; break;
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
