package sheenrox82.RioV.src.base;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.content.RioVBlocks;
import sheenrox82.RioV.src.content.RioVItems;
import cpw.mods.fml.common.registry.GameRegistry;


public class Crafting 
{
	public static String[] helmet = new String[] {"XXX", "X X"};
	public static String[] chestplate = new String[] {"X X", "XXX", "XXX"};
	public static String[] leggings = new String[] {"XXX", "X X", "X X"};
	public static String[] boots = new String[] {"X X", "X X"};
	public static String[] bricks = new String[] {"XX"};
	
	public static String[] pickaxe = new String[] {"XXX", " ! ", " ! ", " ! "};
	public static String[] sword = new String[] {" X ", " X ", "XXX", " ! ",};
	public static String[] shovel = new String[] {"X", "!", "!", "!"};
	public static String[] axe = new String[] {"XX", "X!", " !", " !"};
	public static String[] bowOfWurTun = new String[] {" I*", "IB*", " I*"};
	public static String[] bow = new String[] {" I*", "I *", " I*"};
	public static String[] riovhelmet = new String[] {"XXX", "X X"};
	public static String[] riovchestplate = new String[] {"X X", "XXX", "XXX"};
	public static String[] riovleggings = new String[] {"XXX", "X X", "X X"};
	public static String[] riovboots = new String[] {"X X", "X X"};
	
	public static void add()
	{
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.infuser, 1), "XXX", "XAX", "XXX", Character.valueOf('X'), Blocks.obsidian, Character.valueOf('A'), RioVItems.orb);
		GameRegistry.addRecipe(new ItemStack(RioVItems.terronCrystal, 1), "XZX", "ZAZ", "XZX", Character.valueOf('X'), RioVItems.onyx, Character.valueOf('A'), RioVItems.baseCrystal, Character.valueOf('Z'), RioVItems.blindonite);
		GameRegistry.addRecipe(new ItemStack(RioVItems.demonAngelCrystal, 1), "XZX", "ZAZ", "XZX", Character.valueOf('X'), RioVItems.onyx, Character.valueOf('A'), RioVItems.baseCrystal, Character.valueOf('Z'), RioVItems.nironite);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.onyxBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), RioVItems.onyx);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.amethystBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), RioVItems.amethyst);
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 0), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 15)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 1), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 14)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 2), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 13)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 3), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 12)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 4), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 11)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 5), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 10)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 6), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 9)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 7), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 8)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 8), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 7)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 9), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 6)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 10), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 5)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 11), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 4)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 12), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 3)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 13), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 2)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 14), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.plankColored, 1, 15), new Object[] {Blocks.planks,  new ItemStack(Items.dye, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.blackQuartz, 1, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), RioVItems.burnedQuartz);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.garnetBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), RioVItems.garnet);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.nironiteBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), RioVItems.nironite);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.dragonBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), RioVItems.dragonSoul);
		GameRegistry.addSmelting(RioVItems.horseMeat, new ItemStack(RioVItems.cookedHorseMeat, 1), 1F);
		GameRegistry.addRecipe(new ItemStack(RioVItems.wineGlass, 1), "X X", " X ", "XXX", Character.valueOf('X'), Blocks.glass);
		GameRegistry.addRecipe(new ItemStack(RioVItems.potionGlass, 1), " X ", "X X", "XXX", Character.valueOf('X'), Blocks.glass);
		GameRegistry.addShapelessRecipe(new ItemStack(RioVItems.wine, 1), new Object[] {RioVItems.grapes, RioVItems.wineGlass});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVItems.pepperSpices, 1), new Object[] {RioVItems.pepper});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVItems.spicedWine, 1), new Object[] {RioVItems.pepperSpices, RioVItems.wine});
		GameRegistry.addRecipe(new ItemStack(RioVItems.onyx, 9), "X", Character.valueOf('X'), RioVBlocks.onyxBlock);
		GameRegistry.addRecipe(new ItemStack(RioVItems.amethyst, 9), "X", Character.valueOf('X'), RioVBlocks.amethystBlock);
		GameRegistry.addRecipe(new ItemStack(RioVItems.burnedQuartz, 9), "X", Character.valueOf('X'), new ItemStack(RioVBlocks.blackQuartz, 1, 1));
		GameRegistry.addRecipe(new ItemStack(RioVItems.garnet, 9), "X", Character.valueOf('X'), RioVBlocks.garnetBlock);
		GameRegistry.addRecipe(new ItemStack(RioVItems.nironite, 9), "X", Character.valueOf('X'), RioVBlocks.nironiteBlock);
		GameRegistry.addRecipe(new ItemStack(RioVItems.dragonSoul, 9), "X", Character.valueOf('X'), RioVBlocks.dragonBlock);
		GameRegistry.addRecipe(new ItemStack(RioVItems.theDarknessCrystal, 1), "XZX", "ZAZ", "XZX", Character.valueOf('X'), RioVItems.onyx, Character.valueOf('A'), RioVItems.baseCrystal, Character.valueOf('Z'), RioVItems.vulron);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.lamp, 1), "XZX", "ZAZ", "XZX", Character.valueOf('X'), Blocks.planks, Character.valueOf('A'), Blocks.torch, Character.valueOf('Z'), Blocks.glass);
		GameRegistry.addShapelessRecipe(new ItemStack(RioVItems.purpleFeather, 1), new Object[] {Items.feather, new ItemStack(Items.dye, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(RioVItems.darknessArrow, 5), "  *", " D ", "X  ", Character.valueOf('*'), RioVItems.ingotOfFlame, Character.valueOf('D'), RioVItems.blackBone, Character.valueOf('X'), RioVItems.purpleFeather);
		GameRegistry.addRecipe(new ItemStack(RioVItems.blindOasisActivator, 1), "  *", " X ", "*  ", Character.valueOf('*'), RioVItems.onyx, Character.valueOf('X'), new ItemStack(RioVBlocks.blackQuartz, 1, 1));
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.blindoniteBlock, 1), "XX", "XX", Character.valueOf('X'), RioVItems.blindonite);
		GameRegistry.addRecipe(new ItemStack(RioVItems.vaerynActivator, 1), "  *", " X ", "*  ", Character.valueOf('*'), RioVItems.blindonite, Character.valueOf('X'), RioVBlocks.blindoniteBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.glimmerwoodPlanks, 4), new Object[] {RioVBlocks.glimmerwoodLog});
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.glimmerwoodWorkbench, 1), "XX", "XX", Character.valueOf('X'), RioVBlocks.glimmerwoodPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVItems.glimmerwoodSticks, 4), "X", "X", Character.valueOf('X'), RioVBlocks.glimmerwoodPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.glimmerwoodFence, 2), "XXX", "XXX", Character.valueOf('X'), RioVItems.glimmerwoodSticks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.glimmerwoodFenceGate, 1), "XOX", "XOX", Character.valueOf('X'), RioVItems.glimmerwoodSticks, Character.valueOf('O'), RioVBlocks.glimmerwoodPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVItems.glimmerwoodDoorItem, 1), "XX", "XX", "XX", Character.valueOf('X'), RioVBlocks.glimmerwoodPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.glimmerwoodTrapdoor, 2), "XXX", "XXX", Character.valueOf('X'), RioVBlocks.glimmerwoodPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.glimmerwoodLadder, 3), "X X", "XXX", "X X", Character.valueOf('X'), RioVItems.glimmerwoodSticks);
		GameRegistry.addRecipe(new ItemStack(RioVItems.flamonorActivator, 1), "  *", " X ", "*  ", Character.valueOf('*'), RioVItems.onyx, Character.valueOf('X'), RioVBlocks.bloodRock);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.slateBricks, 4), "XX", "XX", Character.valueOf('X'), RioVBlocks.slate);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.slate, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), RioVItems.slateFragment);
		GameRegistry.addSmelting(RioVBlocks.slateCobble, new ItemStack(RioVBlocks.slate, 1), 1F);
		GameRegistry.addSmelting(RioVBlocks.slateBricks, new ItemStack(RioVItems.slateFragment, 1), 0.1F);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.cherryPlanks, 4), "X", Character.valueOf('X'), RioVBlocks.cherryLog);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.cherryWorkbench, 1), "XX", "XX", Character.valueOf('X'), RioVBlocks.cherryPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVItems.cherryBlossomDoorItem, 1), "XX", "XX", "XX", Character.valueOf('X'), RioVBlocks.cherryPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.cherryBlossomTrapdoor, 2), "XXX", "XXX", Character.valueOf('X'), RioVBlocks.cherryPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.cherryBlossomLadder, 3), "X X", "XXX", "X X", Character.valueOf('X'), RioVItems.cherryBlossomSticks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.cherryBlossomFenceGate, 1), "XOX", "XOX", Character.valueOf('O'), RioVBlocks.cherryPlanks,  Character.valueOf('X'), RioVItems.cherryBlossomSticks);
		GameRegistry.addRecipe(new ItemStack(RioVItems.cherryBlossomSticks, 4), "X", "X", Character.valueOf('X'), RioVBlocks.cherryPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.cherryBlossomFence, 2), "XXX", "XXX", Character.valueOf('X'), RioVItems.cherryBlossomSticks);
		GameRegistry.addRecipe(new ItemStack(RioVItems.sanctuatiteActivator, 1), "  *", " X ", "*  ", Character.valueOf('*'), RioVItems.drakiuz, Character.valueOf('X'), RioVBlocks.blindoniteBlock);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.skywoodPlanks, 4), "X", Character.valueOf('X'), RioVBlocks.skywoodLog);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.skywoodWorkbench, 1), "XX", "XX", Character.valueOf('X'), RioVBlocks.skywoodPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVItems.skywoodDoorItem, 1), "XX", "XX", "XX", Character.valueOf('X'), RioVBlocks.skywoodPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.skywoodTrapdoor, 2), "XXX", "XXX", Character.valueOf('X'), RioVBlocks.skywoodPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.skywoodLadder, 3), "X X", "XXX", "X X", Character.valueOf('X'), RioVItems.skywoodSticks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.skywoodFenceGate, 1), "XOX", "XOX", Character.valueOf('O'), RioVBlocks.skywoodPlanks,  Character.valueOf('X'), RioVItems.skywoodSticks);
		GameRegistry.addRecipe(new ItemStack(RioVItems.skywoodSticks, 4), "X", "X", Character.valueOf('X'), RioVBlocks.skywoodPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.skywoodFence, 2), "XXX", "XXX", Character.valueOf('X'), RioVItems.skywoodSticks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bloodPlanks, 4), "X", Character.valueOf('X'), RioVBlocks.bloodLog);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bloodWorkbench, 1), "XX", "XX", Character.valueOf('X'), RioVBlocks.bloodPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVItems.bloodDoorItem, 1), "XX", "XX", "XX", Character.valueOf('X'), RioVBlocks.bloodPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bloodTrapdoor, 2), "XXX", "XXX", Character.valueOf('X'), RioVBlocks.bloodPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bloodLadder, 3), "X X", "XXX", "X X", Character.valueOf('X'), RioVItems.bloodSticks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bloodFenceGate, 1), "XOX", "XOX", Character.valueOf('O'), RioVBlocks.bloodPlanks,  Character.valueOf('X'), RioVItems.bloodSticks);
		GameRegistry.addRecipe(new ItemStack(RioVItems.bloodSticks, 4), "X", "X", Character.valueOf('X'), RioVBlocks.bloodPlanks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bloodFence, 2), "XXX", "XXX", Character.valueOf('X'), RioVItems.bloodSticks);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.anvil, 1), "XOX", "XXX", Character.valueOf('X'), RioVBlocks.slateBricks, Character.valueOf('O'), new ItemStack(Blocks.wool, 1, 14));
		GameRegistry.addRecipe(new ItemStack(RioVItems.voidHolder, 1), "X X", " X ", Character.valueOf('X'), RioVItems.onyx);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.jaavikBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), RioVItems.jaavik);
		GameRegistry.addRecipe(new ItemStack(RioVItems.jaavik, 9), "X", Character.valueOf('X'), RioVBlocks.jaavikBlock);
		GameRegistry.addRecipe(new ItemStack(RioVItems.blindonite, 4), "X", Character.valueOf('X'), RioVBlocks.blindoniteBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(RioVItems.chain, 3), new Object[] {Items.iron_ingot, Items.iron_ingot, Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_helmet, 1), new Object[] { helmet, Character.valueOf('X'), RioVItems.chain});
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_chestplate, 1), new Object[] { chestplate, Character.valueOf('X'), RioVItems.chain});
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_leggings, 1), new Object[] { leggings, Character.valueOf('X'), RioVItems.chain});
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_boots, 1), new Object[] { boots, Character.valueOf('X'), RioVItems.chain});
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.alerisBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), RioVItems.aleris);
		GameRegistry.addRecipe(new ItemStack(RioVItems.aleris, 9), "X", Character.valueOf('X'), RioVBlocks.alerisBlock);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bricks, 2, 2), bricks, Character.valueOf('X'), RioVBlocks.amethystBlock);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bricks, 2, 3), bricks, Character.valueOf('X'), RioVBlocks.onyxBlock);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bricks, 2, 4), bricks, Character.valueOf('X'), RioVBlocks.blindoniteBlock);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bricks, 2, 5), bricks, Character.valueOf('X'), RioVBlocks.dragonBlock);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bricks, 2, 6), bricks, Character.valueOf('X'), RioVBlocks.vraviniteBlock);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bricks, 2, 7), bricks, Character.valueOf('X'), RioVBlocks.alerisBlock);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bricks, 2, 8), bricks, Character.valueOf('X'), RioVBlocks.jaavikBlock);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bricks, 2, 9), bricks, Character.valueOf('X'), RioVBlocks.nironiteBlock);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bricks, 2, 10), bricks, Character.valueOf('X'), RioVBlocks.garnetBlock);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.bricks, 2, 11), bricks, Character.valueOf('X'), RioVBlocks.drakiuzBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.stainedGlass, 1, 0), new Object[] {new ItemStack(Items.dye, 1, 6), new ItemStack(Items.dye, 1, 10), new ItemStack(Items.dye, 1, 11), Blocks.glass});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.stainedGlass, 1, 1), new Object[] {new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 5), new ItemStack(Items.dye, 1, 12),  new ItemStack(Items.dye, 1, 10), Blocks.glass});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.stainedGlass, 1, 2), new Object[] {new ItemStack(Items.dye, 1, 13), new ItemStack(Items.dye, 1, 14), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 12),  new ItemStack(Items.dye, 1, 1), Blocks.glass});
		GameRegistry.addShapelessRecipe(new ItemStack(RioVBlocks.stainedGlass, 1, 3), new Object[] {new ItemStack(Items.dye, 1, 0),  new ItemStack(Items.dye, 1, 1), Blocks.glass});
		GameRegistry.addRecipe(new ItemStack(RioVItems.smallBag, 1), "XXX", "X X", "XXX", Character.valueOf('X'), Items.leather);
		GameRegistry.addRecipe(new ItemStack(RioVItems.mediumBag, 1), "XXX", "XOX", "XXX", Character.valueOf('X'), Items.leather, Character.valueOf('O'), RioVItems.smallBag);
		GameRegistry.addRecipe(new ItemStack(RioVItems.largeBag, 1), "XXX", "XOX", "XXX", Character.valueOf('X'), Items.leather, Character.valueOf('O'), RioVItems.mediumBag);
		GameRegistry.addRecipe(new ItemStack(RioVItems.sheenBag, 1), "XXX", "XOX", "XXX", Character.valueOf('X'), Items.leather, Character.valueOf('O'), RioVItems.largeBag);
		GameRegistry.addRecipe(new ItemStack(RioVItems.auntunSummoner, 1), "XTX", "TOT", "XTX", Character.valueOf('O'), RioVItems.onyx, Character.valueOf('X'), RioVItems.darkMatter, Character.valueOf('T'), RioVBlocks.skycloud);
		GameRegistry.addRecipe(new ItemStack(RioVBlocks.chocolateCake, 1), "XXX", "XOX", "XXX", Character.valueOf('O'), Items.cake, Character.valueOf('X'), new ItemStack(Items.dye, 1, 4));
		GameRegistry.addRecipe(new ItemStack(Items.stone_pickaxe, 5), "***", " I ", " I ", Character.valueOf('*'), Blocks.stone, Character.valueOf('I'), Items.stick);
		GameRegistry.addRecipe(new ItemStack(Items.stone_axe, 5), "** ", "*I ", " I ", Character.valueOf('*'), Blocks.stone, Character.valueOf('I'), Items.stick);
		GameRegistry.addRecipe(new ItemStack(Items.stone_shovel, 5), " * ", " I ", " I ", Character.valueOf('*'), Blocks.stone, Character.valueOf('I'), Items.stick);
		GameRegistry.addRecipe(new ItemStack(Items.stone_sword, 5), " * ", " * ", " I ", Character.valueOf('*'), Blocks.stone, Character.valueOf('I'), Items.stick);
		GameRegistry.addRecipe(new ItemStack(Items.stone_hoe, 5), "** ", " I ", " I ", Character.valueOf('*'), Blocks.stone, Character.valueOf('I'), Items.stick);
		GameRegistry.addRecipe(new ItemStack(Items.stone_pickaxe, 5), "***", " I ", " I ", Character.valueOf('*'), Blocks.mossy_cobblestone, Character.valueOf('I'), Items.stick);
		GameRegistry.addRecipe(new ItemStack(Items.stone_axe, 5), "** ", "*I ", " I ", Character.valueOf('*'), Blocks.mossy_cobblestone, Character.valueOf('I'), Items.stick);
		GameRegistry.addRecipe(new ItemStack(Items.stone_shovel, 5), " * ", " I ", " I ", Character.valueOf('*'), Blocks.mossy_cobblestone, Character.valueOf('I'), Items.stick);
		GameRegistry.addRecipe(new ItemStack(Items.stone_sword, 5), " * ", " * ", " I ", Character.valueOf('*'), Blocks.mossy_cobblestone, Character.valueOf('I'), Items.stick);
		GameRegistry.addRecipe(new ItemStack(Items.stone_hoe, 5), "** ", " I ", " I ", Character.valueOf('*'), Blocks.mossy_cobblestone, Character.valueOf('I'), Items.stick);
	
		//ANVIL CRAFTING
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.amethystPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), RioVItems.amethyst, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.amethystSword, 1), new Object[] { sword, Character.valueOf('X'), RioVItems.amethyst, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.amethystShovel, 1), new Object[] { shovel, Character.valueOf('X'), RioVItems.amethyst, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.amethystAxe, 1), new Object[] { axe, Character.valueOf('X'), RioVItems.amethyst, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.onyxPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), RioVItems.onyx, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.onyxSword, 1), new Object[] { sword, Character.valueOf('X'), RioVItems.onyx, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.onyxShovel, 1), new Object[] { shovel, Character.valueOf('X'), RioVItems.onyx, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.onyxAxe, 1), new Object[] { axe, Character.valueOf('X'), RioVItems.onyx, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.dragonPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), RioVItems.dragonSoul, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.dragonSword, 1), new Object[] { sword, Character.valueOf('X'), RioVItems.dragonSoul, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.dragonShovel, 1), new Object[] { shovel, Character.valueOf('X'), RioVItems.dragonSoul, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.dragonAxe, 1), new Object[] { axe, Character.valueOf('X'), RioVItems.dragonSoul, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.agonitePickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), RioVItems.agonite, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.galokinSword, 1), new Object[] { sword, Character.valueOf('X'), RioVItems.galokinCrystal, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.blindonitePickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), RioVItems.blindonite, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.blindoniteSword, 1), new Object[] { sword, Character.valueOf('X'), RioVItems.blindonite, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.blindoniteShovel, 1), new Object[] { shovel, Character.valueOf('X'), RioVItems.blindonite, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.blindoniteAxe, 1), new Object[] { axe, Character.valueOf('X'), RioVItems.blindonite, Character.valueOf('!'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.vravinitePickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), RioVItems.vravinite, Character.valueOf('!'), RioVItems.glimmerwoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.vraviniteSword, 1), new Object[] { sword, Character.valueOf('X'), RioVItems.vravinite, Character.valueOf('!'), RioVItems.glimmerwoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.vraviniteShovel, 1), new Object[] { shovel, Character.valueOf('X'), RioVItems.vravinite, Character.valueOf('!'), RioVItems.glimmerwoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.vraviniteAxe, 1), new Object[] { axe, Character.valueOf('X'), RioVItems.vravinite, Character.valueOf('!'), RioVItems.glimmerwoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.cherryBlossomPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), RioVBlocks.cherryPlanks, Character.valueOf('!'), RioVItems.cherryBlossomSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.cherryBlossomSword, 1), new Object[] { sword, Character.valueOf('X'), RioVBlocks.cherryPlanks, Character.valueOf('!'), RioVItems.cherryBlossomSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.cherryBlossomShovel, 1), new Object[] { shovel, Character.valueOf('X'), RioVBlocks.cherryPlanks, Character.valueOf('!'), RioVItems.cherryBlossomSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.cherryBlossomAxe, 1), new Object[] { axe, Character.valueOf('X'), RioVBlocks.cherryPlanks, Character.valueOf('!'), RioVItems.cherryBlossomSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.glimmerwoodPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), RioVBlocks.glimmerwoodPlanks, Character.valueOf('!'), RioVItems.glimmerwoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.glimmerwoodSword, 1), new Object[] { sword, Character.valueOf('X'), RioVBlocks.glimmerwoodPlanks, Character.valueOf('!'), RioVItems.glimmerwoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.glimmerwoodShovel, 1), new Object[] { shovel, Character.valueOf('X'), RioVBlocks.glimmerwoodPlanks, Character.valueOf('!'), RioVItems.glimmerwoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.glimmerwoodAxe, 1), new Object[] { axe, Character.valueOf('X'), RioVBlocks.glimmerwoodPlanks, Character.valueOf('!'), RioVItems.glimmerwoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.khuulisScythe, 1), "X  ", " Z ", "  X", Character.valueOf('X'), Items.iron_ingot, Character.valueOf('Z'), RioVItems.blackBone);
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.bowOfWurTun, 1), bowOfWurTun, Character.valueOf('I'), Items.gold_ingot, Character.valueOf('*'), Items.string, Character.valueOf('D'), RioVItems.blackBone);
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.enforcedBowOfWurTun, 1), " XC", "DOC", " XC", Character.valueOf('X'), Items.gold_ingot, Character.valueOf('C'), Items.string, Character.valueOf('D'), RioVItems.blackBone, Character.valueOf('O'), RioVItems.bowOfWurTun);
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.skywoodPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), RioVBlocks.skywoodPlanks, Character.valueOf('!'), RioVItems.skywoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.skywoodSword, 1), new Object[] { sword, Character.valueOf('X'), RioVBlocks.skywoodPlanks, Character.valueOf('!'), RioVItems.skywoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.skywoodShovel, 1), new Object[] { shovel, Character.valueOf('X'), RioVBlocks.skywoodPlanks, Character.valueOf('!'), RioVItems.skywoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.skywoodAxe, 1), new Object[] { axe, Character.valueOf('X'), RioVBlocks.skywoodPlanks, Character.valueOf('!'), RioVItems.skywoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.bloodPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), RioVBlocks.bloodPlanks, Character.valueOf('!'), RioVItems.bloodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.bloodSword, 1), new Object[] { sword, Character.valueOf('X'), RioVBlocks.bloodPlanks, Character.valueOf('!'), RioVItems.bloodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.bloodShovel, 1), new Object[] { shovel, Character.valueOf('X'), RioVBlocks.bloodPlanks, Character.valueOf('!'), RioVItems.bloodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.bloodAxe, 1), new Object[] { axe, Character.valueOf('X'), RioVBlocks.bloodPlanks, Character.valueOf('!'), RioVItems.bloodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.alerisPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), RioVItems.aleris, Character.valueOf('!'), RioVItems.skywoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.alerisSword, 1), new Object[] { sword, Character.valueOf('X'), RioVItems.aleris, Character.valueOf('!'), RioVItems.skywoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.alerisShovel, 1), new Object[] { shovel, Character.valueOf('X'), RioVItems.aleris, Character.valueOf('!'), RioVItems.skywoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.alerisAxe, 1), new Object[] { axe, Character.valueOf('X'), RioVItems.aleris, Character.valueOf('!'), RioVItems.skywoodSticks});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.daetoriSword, 1), new Object[] { " X ", " X ", "!!!", " X ", Character.valueOf('X'), RioVItems.blackBone, Character.valueOf('!'), Items.iron_ingot});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.sorrowSword, 1), new Object[] { " X ", " X ", "XXX", " X ", Character.valueOf('X'), RioVItems.blackBone});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.unfusedAxeOfAunTun, 1), new Object[] { "XOX", "X!X", " ! ", "*!*", Character.valueOf('X'), RioVItems.vulron, Character.valueOf('!'), RioVItems.blackBone, Character.valueOf('O'), RioVItems.darkMatter, Character.valueOf('*'), RioVItems.clothOfMagic});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.swordOfFlame, 1), "*", "*", "*", Character.valueOf('*'), RioVItems.ingotOfFlame);
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.onyxHelmet, 1), new Object[] { riovhelmet, Character.valueOf('X'), RioVItems.onyx});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.onyxChestplate, 1), new Object[] { riovchestplate, Character.valueOf('X'), RioVItems.onyx});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.onyxLeggings, 1), new Object[] { riovleggings, Character.valueOf('X'), RioVItems.onyx});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.onyxBoots, 1), new Object[] { riovboots, Character.valueOf('X'), RioVItems.onyx});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.amethystHelmet, 1), new Object[] { riovhelmet, Character.valueOf('X'), RioVItems.amethyst});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.amethystChestplate, 1), new Object[] { riovchestplate, Character.valueOf('X'), RioVItems.amethyst});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.amethystLeggings, 1), new Object[] { riovleggings, Character.valueOf('X'), RioVItems.amethyst});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.amethystBoots, 1), new Object[] { riovboots, Character.valueOf('X'), RioVItems.amethyst});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.garnetHelmet, 1), new Object[] { riovhelmet, Character.valueOf('X'), RioVItems.garnet});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.garnetChestplate, 1), new Object[] { riovchestplate, Character.valueOf('X'), RioVItems.garnet});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.garnetLeggings, 1), new Object[] { riovleggings, Character.valueOf('X'), RioVItems.garnet});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.garnetBoots, 1), new Object[] { riovboots, Character.valueOf('X'), RioVItems.garnet});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.mythrilHelmet, 1), "XAX", "X*X", Character.valueOf('X'), RioVItems.mythrilIngot, Character.valueOf('A'), Items.iron_ingot, Character.valueOf('*'), RioVItems.darkMatter);
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.mythrilChestplate, 1), "X X", "XAX", "X*X", Character.valueOf('X'), RioVItems.mythrilIngot, Character.valueOf('A'), Items.iron_ingot, Character.valueOf('*'), RioVItems.darkMatter);
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.mythrilLeggings, 1), "X*X", "A A", "X X", Character.valueOf('X'), RioVItems.mythrilIngot, Character.valueOf('A'), Items.iron_ingot, Character.valueOf('*'), RioVItems.darkMatter);
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.mythrilBoots, 1), "A A", "X*X", Character.valueOf('X'), RioVItems.mythrilIngot, Character.valueOf('A'), Items.iron_ingot, Character.valueOf('*'), RioVItems.darkMatter);
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.dragonHelmet, 1), new Object[] { riovhelmet, Character.valueOf('X'), RioVItems.dragonSoul});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.dragonChestplate, 1), new Object[] { riovchestplate, Character.valueOf('X'), RioVItems.dragonSoul});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.dragonLeggings, 1), new Object[] { riovleggings, Character.valueOf('X'), RioVItems.dragonSoul});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.dragonBoots, 1), new Object[] { riovboots, Character.valueOf('X'), RioVItems.dragonSoul});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.galokinHelmet, 1), new Object[] { riovhelmet, Character.valueOf('X'), RioVItems.galokinCrystal});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.galokinChestplate, 1), new Object[] { riovchestplate, Character.valueOf('X'), RioVItems.galokinCrystal});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.galokinLeggings, 1), new Object[] { riovleggings, Character.valueOf('X'), RioVItems.galokinCrystal});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.galokinBoots, 1), new Object[] { riovboots, Character.valueOf('X'), RioVItems.galokinCrystal});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.blindoniteHelmet, 1), new Object[] { riovhelmet, Character.valueOf('X'), RioVItems.blindonite});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.blindoniteChestplate, 1), new Object[] { riovchestplate, Character.valueOf('X'), RioVItems.blindonite});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.blindoniteLeggings, 1), new Object[] { riovleggings, Character.valueOf('X'), RioVItems.blindonite});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.blindoniteBoots, 1), new Object[] { riovboots, Character.valueOf('X'), RioVItems.blindonite});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.helmetOfFlame, 1), new Object[] { riovhelmet, Character.valueOf('X'), RioVItems.ingotOfFlame});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.chestplateOfFlame, 1), new Object[] { riovchestplate, Character.valueOf('X'), RioVItems.ingotOfFlame});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.leggingsOfFlame, 1), new Object[] { riovleggings, Character.valueOf('X'), RioVItems.ingotOfFlame});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.bootsOfFlame, 1), new Object[] { riovboots, Character.valueOf('X'), RioVItems.ingotOfFlame});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.vraviniteHelmet, 1), new Object[] { riovhelmet, Character.valueOf('X'), RioVItems.vravinite});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.vraviniteChestplate, 1), new Object[] { riovchestplate, Character.valueOf('X'), RioVItems.vravinite});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.vraviniteLeggings, 1), new Object[] { riovleggings, Character.valueOf('X'), RioVItems.vravinite});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.vraviniteBoots, 1), new Object[] { riovboots, Character.valueOf('X'), RioVItems.vravinite});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.magickaHelmet, 1), new Object[] { riovhelmet, Character.valueOf('X'), RioVItems.clothOfMagic});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.magickaChestplate, 1), new Object[] { riovchestplate, Character.valueOf('X'), RioVItems.clothOfMagic});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.magickaLeggings, 1), new Object[] { riovleggings, Character.valueOf('X'), RioVItems.clothOfMagic});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.magickaBoots, 1), new Object[] { riovboots, Character.valueOf('X'), RioVItems.clothOfMagic});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.alerisHelmet, 1), new Object[] { riovhelmet, Character.valueOf('X'), RioVItems.aleris});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.alerisChestplate, 1), new Object[] { riovchestplate, Character.valueOf('X'), RioVItems.aleris});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.alerisLeggings, 1), new Object[] { riovleggings, Character.valueOf('X'), RioVItems.aleris});
		RioVAPI.getInstance().getCraftingManager().addRecipe(new ItemStack(RioVItems.alerisBoots, 1), new Object[] { riovboots, Character.valueOf('X'), RioVItems.aleris});

		//INFUSER CRAFTING
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.amethystSword, new ItemStack(RioVItems.infusedAmethystSword, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.onyxSword, new ItemStack(RioVItems.infusedOnyxSword, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.amethystShovel, new ItemStack(RioVItems.infusedAmethystShovel, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.amethystPickaxe, new ItemStack(RioVItems.infusedAmethystPickaxe, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.amethystAxe, new ItemStack(RioVItems.infusedAmethystAxe, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.onyxShovel, new ItemStack(RioVItems.infusedOnyxShovel, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.onyxPickaxe, new ItemStack(RioVItems.infusedOnyxPickaxe, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.onyxAxe, new ItemStack(RioVItems.infusedOnyxAxe, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.amethystHelmet, new ItemStack(RioVItems.infusedAmethystHelmet, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.amethystChestplate, new ItemStack(RioVItems.infusedAmethystChestplate, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.amethystLeggings, new ItemStack(RioVItems.infusedAmethystLeggings, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.amethystBoots, new ItemStack(RioVItems.infusedAmethystBoots, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.onyxHelmet, new ItemStack(RioVItems.infusedOnyxHelmet, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.onyxChestplate, new ItemStack(RioVItems.infusedOnyxChestplate, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.onyxLeggings, new ItemStack(RioVItems.infusedOnyxLeggings, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.onyxBoots, new ItemStack(RioVItems.infusedOnyxBoots, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.unfusedAxeOfAunTun, new ItemStack(RioVItems.halfFusedAxeOfAunTun, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.halfFusedAxeOfAunTun, new ItemStack(RioVItems.axeOfAunTun, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.dragonHelmet, new ItemStack(RioVItems.infusedDragonHelmet, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.dragonChestplate, new ItemStack(RioVItems.infusedDragonChestplate, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.dragonLeggings, new ItemStack(RioVItems.infusedDragonLeggings, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.dragonBoots, new ItemStack(RioVItems.infusedDragonBoots, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.dragonPickaxe, new ItemStack(RioVItems.infusedDragonPickaxe, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.dragonAxe, new ItemStack(RioVItems.infusedDragonAxe, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.dragonShovel, new ItemStack(RioVItems.infusedDragonShovel, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.dragonSword, new ItemStack(RioVItems.infusedDragonSword, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.blindoniteHelmet, new ItemStack(RioVItems.infusedBlindoniteHelmet, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.blindoniteChestplate, new ItemStack(RioVItems.infusedBlindoniteChestplate, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.blindoniteLeggings, new ItemStack(RioVItems.infusedBlindoniteLeggings, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.blindoniteBoots, new ItemStack(RioVItems.infusedBlindoniteBoots, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.blindonitePickaxe, new ItemStack(RioVItems.infusedBlindonitePickaxe, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.blindoniteAxe, new ItemStack(RioVItems.infusedBlindoniteAxe, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.blindoniteShovel, new ItemStack(RioVItems.infusedBlindoniteShovel, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.blindoniteSword, new ItemStack(RioVItems.infusedBlindoniteSword, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(Items.apple, new ItemStack(RioVItems.blueMagicApple, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.vraviniteHelmet, new ItemStack(RioVItems.infusedVraviniteHelmet, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.vraviniteChestplate, new ItemStack(RioVItems.infusedVraviniteChestplate, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.vraviniteLeggings, new ItemStack(RioVItems.infusedVraviniteLeggings, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.vraviniteBoots, new ItemStack(RioVItems.infusedVraviniteBoots, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.vravinitePickaxe, new ItemStack(RioVItems.infusedVravinitePickaxe, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.vraviniteAxe, new ItemStack(RioVItems.infusedVraviniteAxe, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.vraviniteShovel, new ItemStack(RioVItems.infusedVraviniteShovel, 1));
		RioVAPI.getInstance().getInfuser().addInfusion(RioVItems.vraviniteSword, new ItemStack(RioVItems.infusedVraviniteSword, 1));

		if(RioVAPI.getInstance().botania)
		{
			try 
			{
				Class botaniaItems = Class.forName("vazkii.botania.common.item.ModItems");

				RioVAPI.getInstance().getInfuser().addInfusion(((Item)botaniaItems.getDeclaredField("manasteelHelm").get(null)), new ItemStack(RioVItems.infusedManasteelHelm, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)botaniaItems.getDeclaredField("manasteelChest").get(null)), new ItemStack(RioVItems.infusedManasteelChest, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)botaniaItems.getDeclaredField("manasteelLegs").get(null)), new ItemStack(RioVItems.infusedManasteelLegs, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)botaniaItems.getDeclaredField("manasteelBoots").get(null)), new ItemStack(RioVItems.infusedManasteelBoots, 1));
			} 
			catch(Exception e)
			{

			}
		}

		if(RioVAPI.getInstance().natura)
		{
			try 
			{
				Class natura = Class.forName("mods.natura.common.NContent");

				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("bloodwoodPickaxe").get(null)), new ItemStack(RioVItems.infusedBloodwoodPickaxe, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("bloodwoodAxe").get(null)), new ItemStack(RioVItems.infusedBloodwoodAxe, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("bloodwoodShovel").get(null)), new ItemStack(RioVItems.infusedBloodwoodShovel, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("bloodwoodSword").get(null)), new ItemStack(RioVItems.infusedBloodwoodSword, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("ghostwoodPickaxe").get(null)), new ItemStack(RioVItems.infusedGhostwoodPickaxe, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("ghostwoodAxe").get(null)), new ItemStack(RioVItems.infusedGhostwoodAxe, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("ghostwoodShovel").get(null)), new ItemStack(RioVItems.infusedGhostwoodShovel, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("ghostwoodSword").get(null)), new ItemStack(RioVItems.infusedGhostwoodSword, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("darkwoodPickaxe").get(null)), new ItemStack(RioVItems.infusedDarkwoodPickaxe, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("darkwoodAxe").get(null)), new ItemStack(RioVItems.infusedDarkwoodAxe, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("darkwoodShovel").get(null)), new ItemStack(RioVItems.infusedDarkwoodShovel, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("darkwoodSword").get(null)), new ItemStack(RioVItems.infusedDarkwoodSword, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("netherquartzPickaxe").get(null)), new ItemStack(RioVItems.infusedNetherquartzPickaxe, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("netherquartzAxe").get(null)), new ItemStack(RioVItems.infusedNetherquartzAxe, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("netherquartzShovel").get(null)), new ItemStack(RioVItems.infusedNetherquartzShovel, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("netherquartzSword").get(null)), new ItemStack(RioVItems.infusedNetherquartzSword, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("fusewoodPickaxe").get(null)), new ItemStack(RioVItems.infusedFusewoodPickaxe, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("fusewoodAxe").get(null)), new ItemStack(RioVItems.infusedFusewoodAxe, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("fusewoodShovel").get(null)), new ItemStack(RioVItems.infusedFusewoodShovel, 1));
				RioVAPI.getInstance().getInfuser().addInfusion(((Item)natura.getDeclaredField("fusewoodSword").get(null)), new ItemStack(RioVItems.infusedFusewoodSword, 1));
			} 
			catch(Exception e)
			{

			}
		}
	}
}
