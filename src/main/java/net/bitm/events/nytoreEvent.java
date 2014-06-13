package net.bitm.events;

import net.bitm.bonytechmod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class nytoreEvent {
	
	@SubscribeEvent
	public void onPickup(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(bonytechmod.nytore))) {
			e.player.addStat(bonytechmod.nytoreAchievement, 1);
		}
		
	}
}
