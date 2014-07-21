package sheenrox82.RioV.src.api.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class RioVAPIUtil 
{
	public static void registerItem(Item item, String string)
	{
		GameRegistry.registerItem(item, string);	
	}

	public static void registerBlock(Block block, String string)
	{
		GameRegistry.registerBlock(block, string);
	}

	public static String getName(String unlocalizedName) 
	{
		return unlocalizedName.substring(unlocalizedName.lastIndexOf(".") + 1);
	}

	public static ChatComponentTranslation addChatMessage(EnumChatFormatting color, String str, Object... args)
	{
		ChatComponentTranslation ret = new ChatComponentTranslation(str, args);
		ret.getChatStyle().setColor(color);
		return ret;
	}

	public static ChatComponentTranslation addChatMessage(String str, Object... args)
	{
		ChatComponentTranslation ret = new ChatComponentTranslation(str, args);
		return ret;
	}

	public static void sendMessageToAll(String message)
	{
		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(addChatMessage(EnumChatFormatting.GOLD, message));
	}

	public static void sendMessageToAll(String message, EntityPlayer player)
	{
		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(addChatMessage(EnumChatFormatting.GOLD, message + player.getDisplayName()));
	}

	public static void registerDimension(int id, Class worldProvider)
	{
		DimensionManager.registerProviderType(id, worldProvider, true);
		DimensionManager.registerDimension(id, id);
	}

	/**
	 * Get a RioV Item using a string.
	 * 
	 * @param itemName - Object name in RioVItems.java (check Github).
	 */
	public Item getRioVItem(String itemName)
	{
		try
		{
			Class riovItems = Class.forName("sheenrox82.RioV.src.content.RioVItems");
			Item itemToGet = (Item)riovItems.getDeclaredField(itemName).get(null);
			return itemToGet;
		}
		catch(Exception e)
		{
			//If it can't find the item it will revert 
			//to this until the item is found. This is so 
			//you don't crash with this API in Eclipse because you don't have the RioV source code.
			return Items.iron_shovel;
		}
	}

	/**
	 * Get a RioV Block using a string.
	 * 
	 * @param blockName - Object name in RioVBlocks.java (check Github).
	 */
	public Block getRioVBlock(String blockName)
	{
		try
		{
			Class riovBlocks = Class.forName("sheenrox82.RioV.src.content.RioVBlocks");
			Block blockToGet = (Block)riovBlocks.getDeclaredField(blockName).get(null);
			return blockToGet;
		}
		catch(Exception e)
		{
			//If it can't find the block it will revert 
			//to this until the block is found. This is so 
			//you don't crash with this API in Eclipse because you don't have the RioV source code.
			return Blocks.stone;
		}
	}

	/**
	 * Get a RioV Enchantment using a string.
	 * 
	 * @param enchantmentName - Object name in Enchantments.java (check Github).
	 */
	public Enchantment getRioVEnchantment(String enchantmentName)
	{
		try
		{
			Class riovEnchants = Class.forName("sheenrox82.RioV.src.content.Enchantments");
			Enchantment enchantToGet = (Enchantment)riovEnchants.getDeclaredField(enchantmentName).get(null);
			return enchantToGet;
		}
		catch(Exception e)
		{
			//If it can't find the enchantment it will revert 
			//to this until the enchantment is found. This is so 
			//you don't crash with this API in Eclipse because you don't have the RioV source code.
			return Enchantment.protection;
		}
	}

	/**
	 * Get a RioV Biome using a string.
	 * 
	 * @param biomeName - Object name in Biomes.java (check Github).
	 */
	public BiomeGenBase getRioVBiome(String biomeName)
	{
		try
		{
			Class riovBiomes = Class.forName("sheenrox82.RioV.src.content.Biomes");
			BiomeGenBase biomeToGet = (BiomeGenBase)riovBiomes.getDeclaredField(biomeName).get(null);
			return biomeToGet;
		}
		catch(Exception e)
		{
			//If it can't find the biome it will revert 
			//to this until the biome is found. This is so 
			//you don't crash with this API in Eclipse because you don't have the RioV source code.
			return BiomeGenBase.plains;
		}
	}

	/**
	 * Get a RioV Sound using a string.
	 * 
	 * @param soundName - Object name in Sounds.java (check Github).
	 */
	public String getRioVSound(String soundName)
	{
		try
		{
			Class riovSounds = Class.forName("sheenrox82.RioV.src.content.Sounds");
			Sound soundToGet = (Sound)riovSounds.getDeclaredField(soundName).get(null);
			return soundToGet.getPrefixedName();
		}
		catch(Exception e)
		{
			//If it can't find the sound it will revert 
			//to this until the sound is found. This is so 
			//you don't crash with this API in Eclipse because you don't have the RioV source code.
			return "";
		}
	}

	/**
	 * Get a RioV Config boolean field using a string.
	 * 
	 * @param field - Field name in Config.java (check Github).
	 */
	public boolean getConfigBool(String field)
	{
		try
		{
			Class configFile = Class.forName("sheenrox82.RioV.src.base.Config");
			boolean boolToGet = (Boolean)configFile.getDeclaredField(field).get(null);
			return boolToGet;
		}
		catch(Exception e)
		{
			//If field is not found, the boolean will return false.
			return false;
		}
	}

	/**
	 * Get a RioV Config integer field using a string.
	 * 
	 * @param field - Field name in Config.java (check Github).
	 */
	public int getConfigInt(String field)
	{
		try
		{
			Class configFile = Class.forName("sheenrox82.RioV.src.base.Config");
			int intToGet = (Integer)configFile.getDeclaredField(field).get(null);
			return intToGet;
		}
		catch(Exception e)
		{
			//If field is not found, the int will return 0.
			return 0;
		}
	}

	/**
	 * Replace a field in a class.
	 */
	public static void replaceField(String fieldName, Class clazz, Object value, Object instance)
	{
		try
		{
			Field field = clazz.getDeclaredField(fieldName);

			if(field != null)
			{
				field.setAccessible(true);

				Field modField = Field.class.getDeclaredField("modifiers");

				modField.setAccessible(true);
				modField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

				field.set(instance, value);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public String getUtilString(String utilString)
	{
		try
		{
			Class util = Class.forName("sheenrox82.RioV.src.util.Util");
			String strToGet = (String)util.getDeclaredField(utilString).get(null);
			return strToGet;
		}
		catch(Exception e)
		{

			return "";
		}
	}
}
