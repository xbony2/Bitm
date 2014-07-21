package sheenrox82.RioV.src.api.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.api.base.RioVAPI;

public class RioVRecipes 
{
	/**
	 * Adds a shaped recipe into the game on the RioV Anvil
	 * 
	 * @param  item  the result of the crafting.
	 * @param  amount  the amount of the item you will receive.
	 * @param  obj   the string for the crafting shape, and the items used for the string characters.
	 */
	public void addRecipe(Item item, int amount, Object ... obj)
	{
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(item, amount), obj);
	}
	
	/**
	 * Adds a shapeless recipe into the RioV Anvil
	 * 
	 * @param  item  the result of the crafting.
	 * @param  amount  the amount of the item you will receive.
	 * @param  obj   the items used in the recipe.
	 */
	public void addShapelessRecipe(Item item, int amount, Object ... obj)
	{
		RioVAPI.getInstance().getCraftingManager().addShapelessRecipe(new ItemStack(item, amount), obj);
	}
}
