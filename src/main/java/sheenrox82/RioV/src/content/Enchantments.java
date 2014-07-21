package sheenrox82.RioV.src.content;

import net.minecraft.enchantment.Enchantment;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.enchantment.EnchantmentVicious;
import sheenrox82.RioV.src.enchantment.EnchantmentVenom;
import sheenrox82.RioV.src.enchantment.EnchantmentConfusion;
import sheenrox82.RioV.src.enchantment.EnchantmentFrost;
import sheenrox82.RioV.src.enchantment.EnchantmentKanuutu;

public class Enchantments 
{
	public static Enchantment kanuutu;
	public static Enchantment frost;
	public static Enchantment venom;
	public static Enchantment confusion;
	public static Enchantment vicious;
	
	public static void add()
	{
		kanuutu = new EnchantmentKanuutu(Config.addEnchantment("Kanuutu"), 3);
		frost = new EnchantmentFrost(Config.addEnchantment("Frost"), 3);
		venom = new EnchantmentVenom(Config.addEnchantment("Venom"), 3);
		confusion = new EnchantmentConfusion(Config.addEnchantment("Confusion"), 3);
		vicious = new EnchantmentVicious(Config.addEnchantment("Vicious"), 3);
	}
}
