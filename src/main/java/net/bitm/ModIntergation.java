package net.bitm;

import net.bitm.config.defaultsettings;
import net.bitm.modInt.IC2;
import net.minecraft.item.Item;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;

public class ModIntergation {

	public static void intergateAllTheMods(){
		
		/**Gregtech Compact*/
		if(Loader.isModLoaded("gregtech") && defaultsettings.GTsupport == 1){
			FMLLog.info("Oh heyo greg");
			
			FMLLog.warning("Gregtech detected! Gregtech support is not yet added, balance issues may occur!");
			
			boolean GTint = true;
		}else{ 
			boolean GTint = false;
			}
		
		/** IC2 Compact*/
		if(Loader.isModLoaded("IC2") && defaultsettings.IC2support == 1){
			FMLLog.info("Oh heyo Sirus and others (including mr10 because he wants a shoutout");
			
			boolean IC2int = true;
			
			IC2.addIC2Items();
			IC2.addRecipes();
			
		}else{ 
			boolean IC2int = false;
		}
	}
}
