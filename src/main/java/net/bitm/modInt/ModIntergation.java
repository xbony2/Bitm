package net.bitm.modInt;

import net.bitm.config.settings;
import net.bitm.modInt.IC2IC2.IC2;
import net.bitm.modInt.SheenRio.RioV;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;

public class ModIntergation {

	static boolean GTint;
	static boolean IC2int;
	static boolean RioVint;
	
	public static void intergateAllTheMods(){
		
		/**Gregtech Compact*/
		if(Loader.isModLoaded("gregtech") && settings.GTsupport == true){
			FMLLog.info("Oh heyo greg");
			FMLLog.warning("Gregtech detected! Gregtech support is not yet added, balance issues may occur!");
			GTint = true;
		}else{ 
			GTint = false;
			}
		
		/** IC2 Compact*/
		if(Loader.isModLoaded("IC2") && settings.IC2support == true){
			FMLLog.info("Oh heyo Sirus and others (including mr10 because he wants a shoutout");
			
			IC2int = true;
			
			IC2.addIC2Items();
			IC2.addRecipes();
			
		}else{ 
			IC2int = false;
		}
		
		/** RioV Compact*/
		if(Loader.isModLoaded("RioV") && settings.riovSuport == true){
			FMLLog.info("RioV detected! Adding silly items!");
			RioVint = true;
			
			RioV.addRioVItems();
			RioV.addRioVRecipes();
		}else{
			RioVint = false;
		}
	}
}
