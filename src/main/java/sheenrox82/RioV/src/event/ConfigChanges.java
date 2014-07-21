package sheenrox82.RioV.src.event;

import sheenrox82.RioV.src.util.Registry;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigChanges 
{
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) 
	{
		if(eventArgs.modID.equals("RioV"))
		{
			Registry.syncConfig();
		}
	}
}
