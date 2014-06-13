package net.bitm;

import net.bitm.blocks.ChoclateCake;
import net.bitm.blocks.TileEntityIronFurnace;
import net.bitm.blocks.TileEntityNytFurnace;
import net.bitm.blocks.TileEntityNytTrit;
import net.bitm.blocks.chromeglass;
import net.bitm.blocks.clearglass;
import net.bitm.blocks.furnaceiron;
import net.bitm.blocks.furnacenyt;
import net.bitm.blocks.irongravel;
import net.bitm.blocks.machineblock;
import net.bitm.blocks.nytblock;
import net.bitm.blocks.nytore;
import net.bitm.blocks.tritnyt;
import net.bitm.blocks.viceblock;
import net.bitm.blocks.viceore;
import net.bitm.config.confighandler;
import net.bitm.config.defaultsettings;
import net.bitm.events.ironFurnaceEvent;
import net.bitm.events.machineblockEvent;
import net.bitm.events.nytFurnaceEvent;
import net.bitm.events.nytoreEvent;
import net.bitm.events.rodcarverevent;
import net.bitm.events.viceoreEvent;
import net.bitm.gui.OreRecipes;
import net.bitm.gui.guihandler;
import net.bitm.items.ItemBitcoin;
import net.bitm.items.ItemDust;
import net.bitm.items.ItemRod;
import net.bitm.items.bemeraldaxe;
import net.bitm.items.bemeraldhoe;
import net.bitm.items.bemeraldpick;
import net.bitm.items.bemeraldspade;
import net.bitm.items.bemeraldsword;
import net.bitm.items.bonyiumingot;
import net.bitm.items.bquartzaxe;
import net.bitm.items.bquartzhoe;
import net.bitm.items.bquartzpick;
import net.bitm.items.bquartzspade;
import net.bitm.items.bquartzsword;
import net.bitm.items.ironflint;
import net.bitm.items.itembasicbattery;
import net.bitm.items.nytaxe;
import net.bitm.items.nythoe;
import net.bitm.items.nytitem;
import net.bitm.items.nytpick;
import net.bitm.items.nytspade;
import net.bitm.items.nytstick;
import net.bitm.items.nytsword;
import net.bitm.items.stickcarver;
import net.bitm.items.viceaxe;
import net.bitm.items.vicehoe;
import net.bitm.items.viceitem;
import net.bitm.items.vicepick;
import net.bitm.items.vicespade;
import net.bitm.items.vicesword;
import net.bitm.oredict.BitReg;
import net.bitm.oredict.vanillaReg;
import net.bitm.recipes.shapedrecipes;
import net.bitm.recipes.shaplessrecipes;
import net.bitm.recipes.smelting;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "bitm", name = "BIT mod!", version = "1.1.0a") 
//, dependencies = "required-after:IC2" (if needed later)
public class bonytechmod {
	
	@Instance("bitm")
	public static bonytechmod instance;
	
	public static Item nyt;
	public static Item vice;
	public static Item basicbattery;
	public static Item stonestick;
	public static Item stickcarver;
	public static Item ironstick;
	public static Item diamondstick;
	public static Item emeraldstick;
	public static Item goldstick;
	public static Item axenyt;
	public static Item picknyt;
	public static Item swordnyt;
	public static Item spadenyt;
	public static Item hoenyt;
	public static Item axevice;
	public static Item pickvice;
	public static Item swordvice;
	public static Item spadevice;
	public static Item hoevice;
	public static Item axebemerald;
	public static Item pickbemerald;
	public static Item swordbemerald;
	public static Item spadebemerald;
	public static Item hoebemerald;
	public static Item axebquartz;
	public static Item pickbquartz;
	public static Item swordbquartz;
	public static Item spadebquartz;
	public static Item hoebquartz;
	public static Item glowstonestick;
	public static Item ironbitcoin;
	public static Item goldbitcoin;
	public static Item diamondbitcoin;
	public static Item redstonestick;
	public static Item lapisstick;
	public static Item quartzstick;
	public static Item nytstick;
	public static Item vicestick;
	public static Item ironflint;
	public static Item bonyiumingot;
	public static Item emeraldbitcoin;
	public static Item stonedust;
	public static Item irondust;
	public static Item diamonddust;
	public static Item golddust;
	public static Item emeralddust;
	public static Item lapisdust;
	public static Item quartzdust;
	public static Item nytdust;
	public static Item vicedust;
	public static Item coaldust;
	
	public static Block nytore;
	public static Block viceore;
	public static Block furnacenytidle;
	public static Block furnacenytactive;
	public static Block nytblock;
	public static Block viceblock;
	public static Block chromeglass;
	public static Block machineblock;
	public static Block irongravel;
	public static Block clearglass;
	public static Block furnaceironidle;
	public static Block furnaceironactive;
	public static Block tritnytidle;
	public static Block tritnytactive;
	public static Block choclateCake;
	
	public static ToolMaterial toolMaterialNyt;
	public static ToolMaterial toolMaterialVice;
	public static ToolMaterial toolMaterialBEmerald;
	public static ToolMaterial toolMaterialBQuartz;
	
	public static Achievement rodcarverAchievement;
	public static Achievement nytoreAchievement;
	public static Achievement machineblockAchievement;
	public static Achievement nytFurnaceAchievement;
	public static Achievement viceoreAchievement;
	public static Achievement ironFurnaceAchievement;
	
	public static final int guiIdNytFurnace = 0;
	public static final int guiIdIronFurnace = 1;
	public static final int guiIdNytTrit = 2;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		FMLLog.info("Bitm is in preInit");
		
		creativeTab.registerCreativeTabs();
     
		confighandler.init(event.getSuggestedConfigurationFile());
		
		toolMaterialNyt = EnumHelper.addToolMaterial("NytToolMaterial", 2, 250, 6.0F, 2.0F, 25);
		toolMaterialVice = EnumHelper.addToolMaterial("ViceToolMaterial", 1, 150, 5.0F, 1.0F, 5);
		toolMaterialBEmerald = EnumHelper.addToolMaterial("BEmeraldToolMaterial", 2, 500, 6.0F, 3.0F, 13);
		toolMaterialBQuartz = EnumHelper.addToolMaterial("BQuartzToolMaterial", 1, 210, 5.0F, 1.0F, 23);
		
		nyt = new nytitem();
		vice = new viceitem();
		basicbattery = new itembasicbattery();
		stickcarver = new stickcarver();
		stonestick = new ItemRod().setUnlocalizedName("stonestick");
		ironstick = new ItemRod().setUnlocalizedName("ironstick");
		diamondstick = new ItemRod().setUnlocalizedName("diamondstick");
		emeraldstick = new ItemRod().setUnlocalizedName("emeraldstick");
		goldstick = new ItemRod().setUnlocalizedName("goldstick");
		axenyt = new nytaxe(toolMaterialNyt);
		picknyt = new nytpick(toolMaterialNyt);
		swordnyt = new nytsword(toolMaterialNyt);
		spadenyt = new nytspade(toolMaterialNyt);
		hoenyt = new nythoe(toolMaterialNyt);
		axevice = new viceaxe(toolMaterialVice);
		pickvice = new vicepick(toolMaterialVice);
		swordvice = new vicesword(toolMaterialVice);
		spadevice = new vicespade(toolMaterialVice);
		hoevice = new vicehoe(toolMaterialVice);
		axebemerald = new bemeraldaxe(toolMaterialBEmerald);
		pickbemerald = new bemeraldpick(toolMaterialBEmerald);
		swordbemerald = new bemeraldsword(toolMaterialBEmerald);
		spadebemerald = new bemeraldspade(toolMaterialBEmerald);
		hoebemerald = new bemeraldhoe(toolMaterialBEmerald);
		axebquartz = new bquartzaxe(toolMaterialBQuartz);
		pickbquartz = new bquartzpick(toolMaterialBQuartz);
		swordbquartz = new bquartzsword(toolMaterialBQuartz);
		spadebquartz = new bquartzspade(toolMaterialBQuartz);
		hoebquartz = new bquartzhoe(toolMaterialBQuartz);
		glowstonestick = new ItemRod().setUnlocalizedName("glowstonestick");
		ironbitcoin = new ItemBitcoin().setUnlocalizedName("ironbitcoin");
		goldbitcoin = new ItemBitcoin().setUnlocalizedName("goldbitcoin");
		diamondbitcoin = new ItemBitcoin().setUnlocalizedName("diamondbitcoin");
		redstonestick = new ItemRod().setUnlocalizedName("redstonestick");
		lapisstick = new ItemRod().setUnlocalizedName("lapisstick");
		quartzstick = new ItemRod().setUnlocalizedName("quartzstick");
		nytstick = new nytstick();
		vicestick = new ItemRod().setUnlocalizedName("vicestick");
		ironflint = new ironflint();
		bonyiumingot = new bonyiumingot();
		emeraldbitcoin = new ItemBitcoin().setUnlocalizedName("emeraldbitcoin");
		stonedust = new ItemDust().setUnlocalizedName("stonedust");
		irondust = new ItemDust().setUnlocalizedName("irondust");
		diamonddust = new ItemDust().setUnlocalizedName("diamanddust");
		golddust = new ItemDust().setUnlocalizedName("golddust");
		emeralddust = new ItemDust().setUnlocalizedName("emeralddust");
		lapisdust = new ItemDust().setUnlocalizedName("lapisdust");
		quartzdust = new ItemDust().setUnlocalizedName("quartzdust");
		nytdust = new ItemDust().setUnlocalizedName("nytdust");
		vicedust = new ItemDust().setUnlocalizedName("vicedust");
		coaldust = new ItemDust().setUnlocalizedName("coaldust");
		
		GameRegistry.registerItem(nyt, "nyt");
		GameRegistry.registerItem(vice, "vice");
		GameRegistry.registerItem(basicbattery, "basicbattery");
		GameRegistry.registerItem(stickcarver, "stickcarver");
		GameRegistry.registerItem(stonestick, "stonestick");
		GameRegistry.registerItem(ironstick, "ironstick");
		GameRegistry.registerItem(diamondstick, "diamondstick");
		GameRegistry.registerItem(goldstick, "goldstick");
		GameRegistry.registerItem(emeraldstick, "emeraldstick");
		GameRegistry.registerItem(axenyt, "axenyt");
		GameRegistry.registerItem(axevice, "axevice");
		GameRegistry.registerItem(axebemerald, "axebemerald");
		GameRegistry.registerItem(axebquartz, "axebquartz");
		GameRegistry.registerItem(picknyt, "picknyt");
		GameRegistry.registerItem(pickvice, "pickvice");
		GameRegistry.registerItem(pickbemerald, "pickbemerald");
		GameRegistry.registerItem(pickbquartz, "pickbquartz");
		GameRegistry.registerItem(swordnyt, "swordnyt");
		GameRegistry.registerItem(swordvice, "swordvice");
		GameRegistry.registerItem(swordbemerald, "swordbemerald");
		GameRegistry.registerItem(swordbquartz, "swordbquartz");
		GameRegistry.registerItem(spadenyt, "spadenyt");
		GameRegistry.registerItem(spadevice, "spadevice");
		GameRegistry.registerItem(spadebemerald, "spadebemerald");
		GameRegistry.registerItem(spadebquartz, "spadebquartz");
		GameRegistry.registerItem(hoenyt, "hoenyt");
		GameRegistry.registerItem(hoevice, "hoevice");
		GameRegistry.registerItem(hoebemerald, "hoebemerald");
		GameRegistry.registerItem(hoebquartz, "hoebquartz");
		GameRegistry.registerItem(glowstonestick, "glowstonestick");
		GameRegistry.registerItem(ironbitcoin, "ironbitcoin");
		GameRegistry.registerItem(goldbitcoin, "goldbitcoin");
		GameRegistry.registerItem(diamondbitcoin, "diamondbitcoin");
		GameRegistry.registerItem(redstonestick, "redstonestick");
		GameRegistry.registerItem(lapisstick, "lapisstick");
		GameRegistry.registerItem(quartzstick, "quartzstick");
		GameRegistry.registerItem(nytstick, "nytstick");
		GameRegistry.registerItem(vicestick, "vicestick");
		GameRegistry.registerItem(ironflint, "ironflint");
		GameRegistry.registerItem(bonyiumingot, "bonyiumingot");
		GameRegistry.registerItem(emeraldbitcoin, "emeraldbitcoin");
		GameRegistry.registerItem(stonedust, "stonedust");
		GameRegistry.registerItem(irondust, "irondust");
		GameRegistry.registerItem(diamonddust, "diamonddust");
		GameRegistry.registerItem(golddust, "golddust");
		GameRegistry.registerItem(emeralddust, "emeralddust");
		GameRegistry.registerItem(lapisdust, "lapisdust");
		GameRegistry.registerItem(quartzdust, "quartzdust");
		GameRegistry.registerItem(nytdust, "nytdust");
		GameRegistry.registerItem(vicedust, "vicedust");
		GameRegistry.registerItem(coaldust, "coaldust");
		
		nytore = new nytore(Material.rock);
		viceore = new viceore(Material.rock);
		nytblock = new nytblock(Material.rock);
		viceblock = new viceblock(Material.rock);
		chromeglass = new chromeglass(Material.glass);
		machineblock = new machineblock(Material.rock);
		irongravel = new irongravel(Material.sand);
		clearglass = new clearglass(Material.glass);
		choclateCake = new ChoclateCake(Material.cake);
		
		furnacenytidle = new furnacenyt(false).setCreativeTab(defaultsettings.alternetcreativemenuonoff == 1 ? creativeTab.bonetabMachines : CreativeTabs.tabDecorations).setHardness(3.5F).setResistance(5F).setBlockName("furnacenytidle");
		furnacenytactive = new furnacenyt(true).setLightLevel(1).setHardness(3.5F).setResistance(5F).setBlockName("furnacenytactive");
		furnaceironidle = new furnaceiron(false).setCreativeTab(defaultsettings.alternetcreativemenuonoff == 1 ? creativeTab.bonetabMachines : CreativeTabs.tabDecorations).setHardness(3.5F).setResistance(5F).setBlockName("furnaceironidle");
		furnaceironactive = new furnaceiron(true).setLightLevel(1).setHardness(3.5F).setResistance(5F).setBlockName("furnaceironactive");
		tritnytidle = new tritnyt(false).setCreativeTab(defaultsettings.alternetcreativemenuonoff == 1 ? creativeTab.bonetabMachines : CreativeTabs.tabDecorations).setHardness(3.5F).setResistance(5F).setBlockName("tritnytidle");
		tritnytactive = new tritnyt(true).setLightLevel(1).setHardness(3.5F).setResistance(5F).setBlockName("tritnytactive");
		
		GameRegistry.registerBlock(nytore, "nytore");
		GameRegistry.registerBlock(viceore, "viceore");
		GameRegistry.registerBlock(furnacenytidle, "furnacenytidle");
		GameRegistry.registerBlock(furnacenytactive, "furnacenytactive");
		GameRegistry.registerBlock(nytblock, "nytblock");
		GameRegistry.registerBlock(viceblock, "viceblock");
		GameRegistry.registerBlock(chromeglass, "chromeglass");
		GameRegistry.registerBlock(machineblock, "machineblock");
		GameRegistry.registerBlock(irongravel, "irongravel");
		GameRegistry.registerBlock(clearglass, "clearglass");
		GameRegistry.registerBlock(furnaceironidle, "furnaceironidle");
		GameRegistry.registerBlock(furnaceironactive, "furnaceironactive");
		GameRegistry.registerBlock(tritnytidle, "tritnytidle");
		GameRegistry.registerBlock(tritnytactive, "tritnytactive");
		GameRegistry.registerBlock(choclateCake, "cakeChocalte");
		
		//Adds stuff to the vanilla Ore Dict
		vanillaReg.registerVanillaOres();
		
		//Bitm Ore Dict Registry
		BitReg.bitmRegistery();
		
		//Registers shaped recipes
		shapedrecipes.registerrecipes();
		
		//Registers shapeless recipes
		shaplessrecipes.registerrecipes();
		
		//Registers smelting recipes
		smelting.registersmeltingstuff();

		GameRegistry.registerTileEntity(TileEntityNytFurnace.class, "tileEntityNytFurnace");
		GameRegistry.registerTileEntity(TileEntityIronFurnace.class, "tileEntityIronFurnace");
		GameRegistry.registerTileEntity(TileEntityNytTrit.class, "tileEntityNytTriturator");
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new guihandler());
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		FMLLog.info("Bitm is in Init");
		
		//Mod integration
		ModIntergation.intergateAllTheMods();
		
		//the y cords are reversed!
		rodcarverAchievement = new Achievement("achievement.rodcarver", "rodcarver", -5, 3, stickcarver, ironFurnaceAchievement).registerStat();
		nytoreAchievement = new Achievement("achievement.nytore", "nytore", -4, 4, nytore, ironFurnaceAchievement).registerStat();
		viceoreAchievement = new Achievement("achievement.viceore", "viceore", -3, 4, viceore, ironFurnaceAchievement).registerStat();
		machineblockAchievement = new Achievement("achievement.machineblock", "machineblock", -2, 1, machineblock, rodcarverAchievement).registerStat();
		nytFurnaceAchievement = new Achievement("achievement.nytfurnace", "nytfurnace", 0, 0, furnacenytidle, machineblockAchievement).registerStat();
		ironFurnaceAchievement = new Achievement("achievement.ironfurnace", "ironfurnace", -6, 5, furnaceironidle, null).registerStat();
		
		AchievementPage.registerAchievementPage(new AchievementPage("Bitm", new Achievement[]{
				rodcarverAchievement, nytoreAchievement, viceoreAchievement, machineblockAchievement, nytFurnaceAchievement, ironFurnaceAchievement
				}));
		
		FMLCommonHandler.instance().bus().register(new rodcarverevent());
		FMLCommonHandler.instance().bus().register(new nytoreEvent());
		FMLCommonHandler.instance().bus().register(new viceoreEvent());
		FMLCommonHandler.instance().bus().register(new machineblockEvent());
		FMLCommonHandler.instance().bus().register(new nytFurnaceEvent());
		FMLCommonHandler.instance().bus().register(new ironFurnaceEvent());
		
		new worldgen();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		FMLLog.info("Bitm is in postInit");

		OreRecipes.overrideStuff(Blocks.cobblestone, new ItemStack(stonedust), 1F);
		OreRecipes.overrideStuff(Blocks.iron_ore, new ItemStack(irondust), 1F);
		OreRecipes.overrideStuff(Blocks.diamond_ore, new ItemStack(diamonddust), 1F);
		OreRecipes.overrideStuff(Blocks.gold_ore, new ItemStack(golddust), 1F);
		OreRecipes.overrideStuff(Blocks.emerald_ore, new ItemStack(emeralddust), 1F);
		OreRecipes.overrideStuff(Blocks.lapis_ore, new ItemStack(lapisdust), 1F);
		OreRecipes.overrideStuff(Blocks.quartz_ore, new ItemStack(quartzdust), 1F);
		OreRecipes.overrideStuff(nytore, new ItemStack(nytdust), 1F);
		OreRecipes.overrideStuff(viceore, new ItemStack(vicedust), 1F);
		OreRecipes.overrideStuff(Blocks.coal_ore, new ItemStack(coaldust), 1F);	 
		
	}
	
}