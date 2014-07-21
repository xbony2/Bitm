package sheenrox82.RioV.src.api.util;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;

public class PlayerStorage
{
	private static final Map<String, NBTTagCompound> entityPlayerData = new HashMap<String, NBTTagCompound>();

	public static void storeEntityData(String name, NBTTagCompound compound)
	{
		entityPlayerData.put(name, compound);
	}

	public static NBTTagCompound getEntityData(String name)
	{
		return entityPlayerData.remove(name);
	}
}
