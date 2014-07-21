package sheenrox82.RioV.src.enchantment;

import sheenrox82.RioV.src.content.Enchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class EnchantmentKanuutu extends Enchantment
{
	
	private ItemStack par1ItemStack;

	public EnchantmentKanuutu(int par1, int par2)
	{
		super(par1, par2, EnumEnchantmentType.weapon);
		this.setName("Kanuutu");
	}

	@Override
    public int getMinEnchantability(int par1)
    {
        return 10 + 20 * (par1 - 1);
    }

	@Override
    public int getMaxEnchantability(int par1)
    {
        return super.getMinEnchantability(par1) + 50;
    }

	@Override
    public int getMaxLevel()
    {
        return 2;
    }

	@Override
	public String getTranslatedName(int par1)
	{
		String enchantmentName = "Kanuutu";
		return enchantmentName + " " + StatCollector.translateToLocal("enchantment.level." + par1);
	}
}