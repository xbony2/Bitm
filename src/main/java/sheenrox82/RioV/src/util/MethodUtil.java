package sheenrox82.RioV.src.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.DimensionManager;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class MethodUtil 
{
	public static int id = 500;
	private static Field fMaxDamageFactor = null;

	public static DamageSource causeArrowDamage(Entity entityRioVArrow, Entity par1Entity)
	{
		return (new EntityDamageSourceIndirect("arrow", entityRioVArrow, par1Entity)).setProjectile();
	}

	public static void registerEntity(Class entityClass, String entityName)
	{
		int entityID = Config.addEntity(entityName);
		EntityRegistry.registerModEntity(entityClass, entityName, entityID, TheMistsOfRioV.getInstance(), 128, 1, true);
	}

	public static void registerEgg(Class entityClass)
	{
		int ID = uniqueEggID();
		EntityList.IDtoClassMapping.put(ID, entityClass);
		EntityList.entityEggs.put(ID, new EntityEggInfo(ID, 0xffffff, 0x000000));
	}

	public static int uniqueEggID()
	{
		return id++;
	}	
}
