package sheenrox82.RioV.src.api.recipe.manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfuserManager
{
	private static InfuserManager infuserBase = new InfuserManager();
	private Map infuserList;
    private Map infuserExp;

	public static InfuserManager getInfuser()
	{
		return infuserBase;
	}

	public InfuserManager()
	{
		infuserList = new HashMap();
		infuserExp = new HashMap();
	}
	
    public void addInfusion(Item p_151396_1_, ItemStack p_151396_2_)
    {
        this.func_151394_a(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_);
    }

    public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_)
    {
        this.infuserList.put(p_151394_1_, p_151394_2_);
    }

    public ItemStack getResult(ItemStack p_151395_1_)
    {
        Iterator iterator = this.infuserList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }

    public Map getSmeltingList()
    {
        return this.infuserList;
    }
}
