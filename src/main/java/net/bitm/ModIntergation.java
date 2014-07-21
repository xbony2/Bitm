package net.bitm;

import net.bitm.config.settings;
import net.bitm.modInt.IC2;
import net.bitm.modInt.RioV;
import net.minecraft.item.Item;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;

public class ModIntergation {

	public static void intergateAllTheMods(){
		
		/**Gregtech Compact*/
		if(Loader.isModLoaded("gregtech") && settings.GTsupport == true){
			FMLLog.info("Oh heyo greg");
			
			FMLLog.warning("Gregtech detected! Gregtech support is not yet added, balance issues may occur!");
			
			boolean GTint = true;
		}else{ 
			boolean GTint = false;
			}
		
		/** IC2 Compact*/
		if(Loader.isModLoaded("IC2") && settings.IC2support == true){
			FMLLog.info("Oh heyo Sirus and others (including mr10 because he wants a shoutout");
			
			boolean IC2int = true;
			
			IC2.addIC2Items();
			IC2.addRecipes();
			
		}else{ 
			boolean IC2int = false;
		}
		
		/** RioV Compact*/
		if(Loader.isModLoaded("RioV") && settings.riovSuport == true){
			FMLLog.info("RioV detected! Adding silly items!");
			boolean RioVint = true;
			
			RioV.addRioVItems();
			RioV.addRioVRecipes();
		}else{
			boolean RioVint = false;
		}
	}
}
