package net.bitm.events;

import net.bitm.bonytechmod;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class viceoreEvent {
	
	@SubscribeEvent
	public void onPickup(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(bonytechmod.viceore))) {
			e.player.addStat(bonytechmod.viceoreAchievement, 1);
		}
		
	}
}

