package net.bitm.events;

import net.bitm.bonytechmod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class rodcarverevent{

	@SubscribeEvent
	public void onPickup(PlayerEvent.ItemCraftedEvent e) {
		if (e.crafting.getItem() == bonytechmod.stickcarver){
			e.player.addStat(bonytechmod.rodcarverAchievement, 1);
		}
	}
}
