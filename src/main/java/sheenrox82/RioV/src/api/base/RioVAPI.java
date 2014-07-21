package sheenrox82.RioV.src.api.base;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import sheenrox82.RioV.src.api.handler.packet.PacketPipeline;
import sheenrox82.RioV.src.api.recipe.manager.AnvilCraftingManager;
import sheenrox82.RioV.src.api.recipe.manager.InfuserManager;
import sheenrox82.RioV.src.api.util.LogHelper;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;

public class RioVAPI
{
	private static RioVAPI api = new RioVAPI();
	private static AnvilCraftingManager crafter = new AnvilCraftingManager();
	private static InfuserManager infuser = new InfuserManager();
	private static LogHelper logger = new LogHelper();
	private static RioVAPIUtil util = new RioVAPIUtil();
	
	public static final String mod_id = getUtil().getUtilString("MOD_ID");
	public static final String mod_name = getUtil().getUtilString("MOD_NAME");
	public static final String version = getUtil().getUtilString("VERSION");

	/**
	 * Used to correctly write and close the debug file.
	 */
	public boolean modLoaded = false;

	public PacketPipeline packetPipeline = new PacketPipeline();

	/**
	 * These booleans are used to detect if certain mods are loaded in the ExpansionChecker class in the main source code for RioV.
	 * Natura - continued by progwml6
	 * Botania - by Vazkii
	 * Optifine - by sp614x
	 * NEI - by CodeChicken
	 */
	public boolean natura;
	public boolean botania;
	public boolean optifine;
	public boolean nei;

	/**
	 * RioV tab.
	 */
	public CreativeTabs tab = new CreativeTabs("RioV") {public Item getTabIconItem() {return Item.getItemFromBlock(getUtil().getRioVBlock("infuser"));}};

	/**
	 * The API instance.
	 */
	public static RioVAPI getInstance()
	{
		return api;
	}

	/**
	 * The crafting manager for the Anvil in RioV
	 */
	public AnvilCraftingManager getCraftingManager()
	{
		return crafter;
	}

	/**
	 * Writes to ./TheMistsOfRioV/debug.log
	 */
	public LogHelper getLogger()
	{
		return logger;
	}

	/**
	 * Gets infuser crafting from RioV
	 */
	public InfuserManager getInfuser()
	{
		return infuser;
	}

	/**
	 * Get RioV PacketPipeline
	 */
	public PacketPipeline getPacketPipeline()
	{
		return packetPipeline;
	}	
	
	/**
	 * Get RioVAPIUtil.java
	 */
	public static RioVAPIUtil getUtil()
	{
		return util;
	}
}
