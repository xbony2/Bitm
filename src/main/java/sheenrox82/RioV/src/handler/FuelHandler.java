package sheenrox82.RioV.src.handler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.content.RioVBlocks;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack fuel) 
	{
		Item var1 = fuel.getItem();
		
		if(var1 == Item.getItemFromBlock(RioVBlocks.steamingBloodDeposit))
		{
			return 6400;
		}
		else
		{
			return 0;
		}
	}
}