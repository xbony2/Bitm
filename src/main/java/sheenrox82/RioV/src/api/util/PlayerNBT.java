package sheenrox82.RioV.src.api.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerNBT implements IExtendedEntityProperties
{
	public final static String EXT_PROP_NAME = "PlayerNBT";
	public static EntityPlayer player;
	public static boolean receivedScroll;

	public static int raetiinID;
	public static int jaerinID;

	//EOS
	public static final int EOS_WATCHER = 30;
	public static int maxEos = 50;

	//BLOOD
	public static final int BLOOD_WATCHER = 31;
	public static int maxBlood = 100;

	//FACTION
	public static int factionID;
	public static boolean hasSeenFactionGui;

	public PlayerNBT(EntityPlayer player)
	{
		this.player = player;
	}

	public static void register(EntityPlayer player)
	{
		player.registerExtendedProperties(PlayerNBT.EXT_PROP_NAME, new PlayerNBT(player));
	}

	public static PlayerNBT get(EntityPlayer player)
	{
		return (PlayerNBT)player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("CurrentEos", this.player.getDataWatcher().getWatchableObjectInt(EOS_WATCHER));
		properties.setInteger("MaxEos", this.maxEos);

		properties.setInteger("CurrentBlood", this.player.getDataWatcher().getWatchableObjectInt(BLOOD_WATCHER));
		properties.setInteger("MaxBlood", this.maxBlood);

		properties.setInteger("FactionID", this.factionID);
		properties.setBoolean("FactionGui", this.hasSeenFactionGui);

		properties.setBoolean("ScrollItem", this.receivedScroll);

		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.player.getDataWatcher().updateObject(EOS_WATCHER, properties.getInteger("CurrentEos"));
		this.maxEos = properties.getInteger("MaxEos");

		this.player.getDataWatcher().updateObject(BLOOD_WATCHER, properties.getInteger("CurrentBlood"));
		this.maxBlood = properties.getInteger("MaxBlood");

		this.factionID = properties.getInteger("FactionID");
		this.hasSeenFactionGui = properties.getBoolean("FactionGui");

		this.receivedScroll = properties.getBoolean("ScrollItem");
	}

	@Override
	public void init(Entity entity, World world)
	{
		this.player.getDataWatcher().addObject(EOS_WATCHER, this.maxEos);
		this.player.getDataWatcher().addObject(BLOOD_WATCHER, this.maxBlood);
		this.factionID = -1;
		this.hasSeenFactionGui = false;
		this.raetiinID = 0;
		this.jaerinID = 1;
		this.receivedScroll = false;
	}

	private static String getSaveKey(EntityPlayer player) 
	{
		return player.getCommandSenderName() + ":" + EXT_PROP_NAME;
	}

	public static void saveProxyData(EntityPlayer player) 
	{
		PlayerNBT playerData = PlayerNBT.get(player);
		NBTTagCompound savedData = new NBTTagCompound();

		playerData.saveNBTData(savedData);

		PlayerStorage.storeEntityData(getSaveKey(player), savedData);
	}

	public static void loadProxyData(EntityPlayer player) 
	{
		PlayerNBT playerData = PlayerNBT.get(player);
		NBTTagCompound savedData = PlayerStorage.getEntityData(getSaveKey(player));

		if(savedData != null) 
		{
			playerData.loadNBTData(savedData);
		}
	}
}