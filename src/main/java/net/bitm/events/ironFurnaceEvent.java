package net.bitm.events;

import net.bitm.bonytechmod;
import net.minecraft.item.Item;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class ironFurnaceEvent {
	@SubscribeEvent
	public void onPickup(PlayerEvent.ItemCraftedEvent e) {
		if (e.crafting.getItem() == Item.getItemFromBlock(bonytechmod.furnaceironidle)){
			e.player.addStat(bonytechmod.ironFurnaceAchievement, 1);
		}
	}
}
