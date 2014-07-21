package sheenrox82.RioV.src.util;

import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.content.RioVItems;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;

public class ExpansionChecker 
{
	public static void check()
	{
		try
		{
			Class.forName("optifine.OptiFineClassTransformer");
			FMLLog.info("Optifine detected! Disabling RioV capes for safety measures!");
			RioVAPI.getInstance().optifine = true;
		}
		catch (Throwable var11)
		{
			FMLLog.info("Optifine not detected! RioV Capes is activating using DeveloperCapes by Jadar.");
			RioVAPI.getInstance().optifine = false;
		}

		if(Loader.isModLoaded("Natura"))
		{
			FMLLog.info("Natura detected! You get the Natura Expansion for RioV! :)");
			RioVAPI.getInstance().natura = true;
			if(RioVAPI.getInstance().natura)
			{
				RioVItems.addNatura();
			}
		}
		else
		{
			FMLLog.info("Natura wasn't detected... No Natura Expansion for you. :(");
			RioVAPI.getInstance().natura = false;
		}

		if(Loader.isModLoaded("Botania"))
		{
			FMLLog.info("Botania detected! You get the Botania Expansion for RioV! :)");
			RioVAPI.getInstance().botania = true;
			if(RioVAPI.getInstance().botania)
			{
				RioVItems.addBotania();
			}
		}
		else
		{
			FMLLog.info("Botania wasn't detected... No Botania Expansion for you. :(");
			RioVAPI.getInstance().botania = false;
		}
	}
}
