package net.bitm.oredict;

import net.bitm.bonytechmod;
import net.bitm.config.defaultsettings;
import net.minecraft.init.Items;
import net.minecraftforge.oredict.OreDictionary;

public class BitReg {
	public static void bitmRegistery(){
		OreDictionary.registerOre("oreNyt", bonytechmod.nytore);
		OreDictionary.registerOre("oreVice", bonytechmod.viceore);
		OreDictionary.registerOre("gravelIron", bonytechmod.irongravel);
		OreDictionary.registerOre("craftingNytrogenicFurnace", bonytechmod.furnacenytidle);
		OreDictionary.registerOre("glassClear", bonytechmod.clearglass);
        OreDictionary.registerOre("glassChrome", bonytechmod.chromeglass);
		OreDictionary.registerOre("blockMachine", bonytechmod.machineblock);
		OreDictionary.registerOre("machineblock", bonytechmod.machineblock);
        OreDictionary.registerOre("blockNyt", bonytechmod.nytblock);
        OreDictionary.registerOre("blockVice", bonytechmod.viceblock);
        OreDictionary.registerOre("foodCakeChocolate", bonytechmod.choclateCake);
        OreDictionary.registerOre("plankWood", bonytechmod.plankBlack);
        OreDictionary.registerOre("plankWood", bonytechmod.plankBlue);
        OreDictionary.registerOre("plankWood", bonytechmod.plankBrown);
        OreDictionary.registerOre("plankWood", bonytechmod.plankCyan);
        OreDictionary.registerOre("plankWood", bonytechmod.plankGray);
        OreDictionary.registerOre("plankWood", bonytechmod.plankGreen);
        OreDictionary.registerOre("plankWood", bonytechmod.plankLightBlue);
        OreDictionary.registerOre("plankWood", bonytechmod.plankLightGray);
        OreDictionary.registerOre("plankWood", bonytechmod.plankLime);
        OreDictionary.registerOre("plankWood", bonytechmod.plankMagenta);
        OreDictionary.registerOre("plankWood", bonytechmod.plankOrange);
        OreDictionary.registerOre("plankWood", bonytechmod.plankPink);
        OreDictionary.registerOre("plankWood", bonytechmod.plankPurple);
        OreDictionary.registerOre("plankWood", bonytechmod.plankRed);
        OreDictionary.registerOre("plankWood", bonytechmod.plankWhite);
        OreDictionary.registerOre("plankWood", bonytechmod.plankYellow);
        
        OreDictionary.registerOre("gemNyt", bonytechmod.nyt);
		OreDictionary.registerOre("gemVice", bonytechmod.vice);
		OreDictionary.registerOre("coinDiamond", bonytechmod.diamondbitcoin);
		OreDictionary.registerOre("coinGold", bonytechmod.goldbitcoin);
		OreDictionary.registerOre("coinIron", bonytechmod.ironbitcoin);
		OreDictionary.registerOre("coinEmerald", bonytechmod.emeraldbitcoin);
        OreDictionary.registerOre("craftingBattery", bonytechmod.basicbattery); //Better name to come later :P
        OreDictionary.registerOre("craftingBasicBattery", bonytechmod.basicbattery);
        OreDictionary.registerOre("rodCobblestone", bonytechmod.stonestick);
        OreDictionary.registerOre("rodWood", Items.stick);
		OreDictionary.registerOre("rodIron", bonytechmod.ironstick);
		OreDictionary.registerOre("rodGold", bonytechmod.goldstick);
		OreDictionary.registerOre("rodDiamond", bonytechmod.diamondstick);
		OreDictionary.registerOre("rodEmerald", bonytechmod.emeraldstick);
		OreDictionary.registerOre("rodRedstone", bonytechmod.redstonestick);
		OreDictionary.registerOre("rodGlowstone", bonytechmod.glowstonestick);
		OreDictionary.registerOre("rodLapis", bonytechmod.lapisstick);
		OreDictionary.registerOre("rodQuartz", bonytechmod.quartzstick);
		OreDictionary.registerOre("rodNyt", bonytechmod.nytstick);
		OreDictionary.registerOre("rodVice", bonytechmod.vicestick);
		OreDictionary.registerOre("flintIron", bonytechmod.ironflint);
		if(defaultsettings.bonyiumregistered == 1) OreDictionary.registerOre("ingotBonyium", bonytechmod.bonyiumingot);
		OreDictionary.registerOre("dustCobblestone", bonytechmod.stonedust);
		OreDictionary.registerOre("dustIron", bonytechmod.irondust);
		OreDictionary.registerOre("dustDiamond", bonytechmod.diamonddust);
		OreDictionary.registerOre("dustGold", bonytechmod.golddust);
		OreDictionary.registerOre("dustEmerald", bonytechmod.emeralddust);
		OreDictionary.registerOre("dustLapis", bonytechmod.lapisdust);
		OreDictionary.registerOre("dustNetherQuartz", bonytechmod.quartzdust);
		OreDictionary.registerOre("dustNyt", bonytechmod.nytdust);
		OreDictionary.registerOre("dustVice", bonytechmod.vicedust);
		OreDictionary.registerOre("dustCoal", bonytechmod.coaldust);
	}
}
