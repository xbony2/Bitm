package net.bitm.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class confighandler {

	public static void init(File file){
		Configuration config = new Configuration(file);
		
		config.load();
		
		defaultsettings.bemeraldonoff = config.get("Settings", "Put to 0 if another mod adds emerald tools", defaultsettings.bemeraldon).getInt();
		defaultsettings.bquartzonoff = config.get("Settings", "Put to 0 if another mod adds quartz tools", defaultsettings.bquartzon).getInt();
		defaultsettings.furnacespeed = config.get("Settings", "Adjusts the nytrogenic furnace speed, do NOT make it a decimal or fraction", defaultsettings.defaultfurnacespeed).getInt();
		defaultsettings.ironfurnacespeed = config.get("Settings", "Adjusts the iron furnace speed, do NOT make it a decimal or fraction", defaultsettings.defaultironfurnacespeed).getInt();
		defaultsettings.bonyiumregistered = config.get("Settings", "Put to 0 to disable bonyium ingot from registering in the oredictionary, in case a mod does something silly with it", defaultsettings.bonyiumdefaulton).getInt();		
		defaultsettings.GTsupport = config.get("Settings", "Put to 0 to turn off gregtech support", defaultsettings.GTsupporton).getInt();
		defaultsettings.IC2support = config.get("Settings", "Put to 0 to turn off IC2 support", defaultsettings.IC2supporton).getInt();
		defaultsettings.tritspeed = config.get("Settings", "Adjusts the nytrogenic triturator speed, NO decimals", defaultsettings.tritspeeddefault).getInt();
		
		config.save();
		
		System.out.println();
	}
	
	
}
