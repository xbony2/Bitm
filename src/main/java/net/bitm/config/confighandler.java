package net.bitm.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class confighandler {

	public static void init(File file){
		Configuration config = new Configuration(file);
		
		config.load();
		
		settings.bemeraldonoff = config.get("Settings", "Put to 0 if another mod adds emerald tools", settings.bemeraldon).getInt();
		settings.bquartzonoff = config.get("Settings", "Put to 0 if another mod adds quartz tools", settings.bquartzon).getInt();
		settings.furnacespeed = config.get("Settings", "Adjusts the nytrogenic furnace speed, do NOT make it a decimal or fraction", settings.defaultfurnacespeed).getInt();
		settings.ironfurnacespeed = config.get("Settings", "Adjusts the iron furnace speed, do NOT make it a decimal or fraction", settings.defaultironfurnacespeed).getInt();
		settings.GTsupport = config.get("Settings", "Turns on and off GT support", true).getBoolean();
		settings.IC2support = config.get("Settings", "Turns on and off IC2 support", true).getBoolean();
		settings.tritspeed = config.get("Settings", "Adjusts the nytrogenic triturator speed, NO decimals", settings.tritspeeddefault).getInt();
		settings.riovSuport = config.get("Settings", "Turns on and off RioV support", true).getBoolean();
		
		config.save();
		
		System.out.println();
	}
	
	
}
