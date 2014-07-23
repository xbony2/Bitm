package net.bitm.events;

import net.bitm.bonytechmod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class rodcarverevent{

	@SubscribeEvent
	public void onPickup(PlayerEvent.ItemCraftedEvent e) {
		if (e.crafting.getItem() == bonytechmod.stickcarver){
			e.player.addStat(bonytechmod.rodcarverAchievement, 1);
		}
	}
}
