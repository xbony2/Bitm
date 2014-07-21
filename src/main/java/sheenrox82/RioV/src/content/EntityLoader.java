package sheenrox82.RioV.src.content;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTunBodyguard;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTunMinion;
import sheenrox82.RioV.src.entity.mob.hostile.EntityBloodGhoul;
import sheenrox82.RioV.src.entity.mob.hostile.EntityDarkElf;
import sheenrox82.RioV.src.entity.mob.hostile.EntityHellhound;
import sheenrox82.RioV.src.entity.mob.hostile.EntityMage;
import sheenrox82.RioV.src.entity.mob.hostile.EntityPaladin;
import sheenrox82.RioV.src.entity.mob.hostile.EntityShadow;
import sheenrox82.RioV.src.entity.mob.hostile.EntityTefGuard;
import sheenrox82.RioV.src.entity.mob.hostile.EntityVravinite;
import sheenrox82.RioV.src.entity.mob.hostile.boss.EntityAunTun;
import sheenrox82.RioV.src.entity.mob.hostile.boss.EntityDarkEssence;
import sheenrox82.RioV.src.entity.mob.hostile.boss.EntityDemonAngel;
import sheenrox82.RioV.src.entity.mob.hostile.boss.EntityTef;
import sheenrox82.RioV.src.entity.mob.hostile.boss.EntityTerron;
import sheenrox82.RioV.src.entity.mob.passive.EntityAdv;
import sheenrox82.RioV.src.entity.mob.passive.EntityAltruEssence;
import sheenrox82.RioV.src.entity.mob.passive.EntityAngel;
import sheenrox82.RioV.src.entity.mob.passive.EntityDove;
import sheenrox82.RioV.src.entity.mob.passive.EntityFairy;
import sheenrox82.RioV.src.entity.mob.passive.EntityGalokin;
import sheenrox82.RioV.src.entity.mob.passive.EntityNizonian;
import sheenrox82.RioV.src.entity.mob.passive.EntityOrc;
import sheenrox82.RioV.src.entity.mob.passive.EntityRabbit;
import sheenrox82.RioV.src.entity.mob.passive.EntitySkeletalHorse;
import sheenrox82.RioV.src.entity.mob.passive.EntitySoverianOfficer;
import sheenrox82.RioV.src.entity.mob.passive.EntityWoodElf;
import sheenrox82.RioV.src.entity.projectile.EntityDarkMatter;
import sheenrox82.RioV.src.entity.projectile.EntityDarknessArrow;
import sheenrox82.RioV.src.entity.projectile.EntityPinkEssence;
import sheenrox82.RioV.src.entity.projectile.EntityVraviniteArrow;
import sheenrox82.RioV.src.util.MethodUtil;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityLoader 
{
	public static void add()
	{
		MethodUtil.registerEntity(EntityAdv.class, "Adventurer");
		MethodUtil.registerEntity(EntityAltruEssence.class, "Altru Essence");
		MethodUtil.registerEntity(EntityAunTun.class, "Aun'Tun");
		MethodUtil.registerEntity(EntityAunTunBodyguard.class, "Aun'Tun Bodyguard");
		MethodUtil.registerEntity(EntityAunTunMinion.class, "Aun'Tun Minion");
		MethodUtil.registerEntity(EntityDarkElf.class, "Dark Elf");
		MethodUtil.registerEntity(EntityDemonAngel.class, "Demon Angel");
		MethodUtil.registerEntity(EntityMage.class, "Mage");
		MethodUtil.registerEntity(EntityNizonian.class, "Nizonian");
		MethodUtil.registerEntity(EntitySkeletalHorse.class, "Skeletal Horse");
		MethodUtil.registerEntity(EntityTerron.class, "Terron");
		MethodUtil.registerEntity(EntityGalokin.class, "Galokin");
		MethodUtil.registerEntity(EntityOrc.class, "Orc");
		MethodUtil.registerEntity(EntityFairy.class, "Fairy");
		MethodUtil.registerEntity(EntityDarkEssence.class, "The Darkness");
		MethodUtil.registerEntity(EntityHellhound.class, "Hellhound");
		MethodUtil.registerEntity(EntityTef.class, "Tef");
		MethodUtil.registerEntity(EntityTefGuard.class, "Tef Guard");
		MethodUtil.registerEntity(EntityShadow.class, "The Shadow");
		MethodUtil.registerEntity(EntityVravinite.class, "Vravinite");
		MethodUtil.registerEntity(EntityBloodGhoul.class, "Blood Ghoul");
		MethodUtil.registerEntity(EntityDove.class, "Dove");
		MethodUtil.registerEntity(EntityAngel.class, "Angel");
		MethodUtil.registerEntity(EntityRabbit.class, "Rabbit");
		MethodUtil.registerEntity(EntitySoverianOfficer.class, "Soverian Officer");
		MethodUtil.registerEntity(EntityWoodElf.class, "Dark Wood Elf Assassin");
		MethodUtil.registerEntity(EntityDarkMatter.class, "Dark Matter");
		MethodUtil.registerEntity(EntityPaladin.class, "Paladin");
		MethodUtil.registerEntity(EntityPinkEssence.class, "Pink Essence");
		MethodUtil.registerEntity(EntityDarknessArrow.class, "Darkness Arrow");
		MethodUtil.registerEntity(EntityVraviniteArrow.class, "Vravinite Arrow");

		MethodUtil.registerEgg(EntityAdv.class);
		MethodUtil.registerEgg(EntityMage.class);
		MethodUtil.registerEgg(EntityAltruEssence.class);
		MethodUtil.registerEgg(EntityAunTunBodyguard.class);
		MethodUtil.registerEgg(EntityAunTunMinion.class);
		MethodUtil.registerEgg(EntityDarkElf.class);
		MethodUtil.registerEgg(EntitySkeletalHorse.class);
		MethodUtil.registerEgg(EntityNizonian.class);
		MethodUtil.registerEgg(EntityGalokin.class);
		MethodUtil.registerEgg(EntityOrc.class);
		MethodUtil.registerEgg(EntityFairy.class);
		MethodUtil.registerEgg(EntityHellhound.class);
		MethodUtil.registerEgg(EntityTef.class);
		MethodUtil.registerEgg(EntityTefGuard.class);
		MethodUtil.registerEgg(EntityShadow.class);
		MethodUtil.registerEgg(EntityVravinite.class);
		MethodUtil.registerEgg(EntityBloodGhoul.class);
		MethodUtil.registerEgg(EntityDove.class);
		MethodUtil.registerEgg(EntityAngel.class);
		MethodUtil.registerEgg(EntityRabbit.class);
		MethodUtil.registerEgg(EntitySoverianOfficer.class);
		MethodUtil.registerEgg(EntityWoodElf.class);
		MethodUtil.registerEgg(EntityTerron.class);
		MethodUtil.registerEgg(EntityDemonAngel.class);
		MethodUtil.registerEgg(EntityDarkEssence.class);
		MethodUtil.registerEgg(EntityAunTun.class);
		MethodUtil.registerEgg(EntityPaladin.class);
	}

	public static void addOverworldSpawning()
	{
		BiomeGenBase[] plains = BiomeDictionary.getBiomesForType(Type.PLAINS);
		BiomeGenBase[] desert = BiomeDictionary.getBiomesForType(Type.SANDY);
		BiomeGenBase[] mountain = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);
		BiomeGenBase[] frozen = BiomeDictionary.getBiomesForType(Type.SNOWY);
		BiomeGenBase[] jungle = BiomeDictionary.getBiomesForType(Type.JUNGLE);
		BiomeGenBase[] forest = BiomeDictionary.getBiomesForType(Type.FOREST);
		BiomeGenBase[] swamp = BiomeDictionary.getBiomesForType(Type.SWAMP);
		BiomeGenBase[] beach = BiomeDictionary.getBiomesForType(Type.BEACH);
		BiomeGenBase[] wasteland = BiomeDictionary.getBiomesForType(Type.WASTELAND);

		SpawnListEntry advSpawn = new SpawnListEntry(EntityAdv.class, 30, 4, 9);
		SpawnListEntry nizonianSpawn = new SpawnListEntry(EntityNizonian.class, 30, 3, 5);
		SpawnListEntry mageSpawn = new SpawnListEntry(EntityMage.class, 30, 5, 12);
		SpawnListEntry darkElfSpawn = new SpawnListEntry(EntityDarkElf.class, 30, 4, 8);
		SpawnListEntry galokinSpawn = new SpawnListEntry(EntityGalokin.class, 30, 5, 7);
		SpawnListEntry orcSpawn = new SpawnListEntry(EntityOrc.class, 30, 3, 7);
		SpawnListEntry sovSpawn = new SpawnListEntry(EntitySoverianOfficer.class, 30, 2, 5);
		SpawnListEntry paladinSpawn = new SpawnListEntry(EntityPaladin.class, 30, 2, 4);

		for(int i = 0; i < plains.length; i++)
		{
			plains[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			plains[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			plains[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			plains[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			plains[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			plains[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
			plains[i].getSpawnableList(EnumCreatureType.monster).add(advSpawn);
			plains[i].getSpawnableList(EnumCreatureType.monster).add(mageSpawn);
			plains[i].getSpawnableList(EnumCreatureType.monster).add(darkElfSpawn);
			plains[i].getSpawnableList(EnumCreatureType.monster).add(galokinSpawn);
			plains[i].getSpawnableList(EnumCreatureType.monster).add(orcSpawn);
			plains[i].getSpawnableList(EnumCreatureType.monster).add(sovSpawn);
		}

		for(int i = 0; i < mountain.length; i++)
		{
			mountain[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.creature).add(paladinSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.monster).add(advSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.monster).add(mageSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.monster).add(darkElfSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.monster).add(galokinSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.monster).add(orcSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.monster).add(sovSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.monster).add(paladinSpawn);
		}

		for(int i = 0; i < frozen.length; i++)
		{
			frozen[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.monster).add(advSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.monster).add(mageSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.monster).add(darkElfSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.monster).add(galokinSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.monster).add(orcSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.monster).add(sovSpawn);
		}

		for(int i = 0; i < jungle.length; i++)
		{
			jungle[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.monster).add(advSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.monster).add(mageSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.monster).add(darkElfSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.monster).add(galokinSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.monster).add(orcSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.monster).add(sovSpawn);
		}

		for(int i = 0; i < forest.length; i++)
		{
			forest[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			forest[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			forest[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			forest[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			forest[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			forest[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
			forest[i].getSpawnableList(EnumCreatureType.monster).add(advSpawn);
			forest[i].getSpawnableList(EnumCreatureType.monster).add(mageSpawn);
			forest[i].getSpawnableList(EnumCreatureType.monster).add(darkElfSpawn);
			forest[i].getSpawnableList(EnumCreatureType.monster).add(galokinSpawn);
			forest[i].getSpawnableList(EnumCreatureType.monster).add(orcSpawn);
			forest[i].getSpawnableList(EnumCreatureType.monster).add(sovSpawn);
		}

		for(int i = 0; i < desert.length; i++)
		{
			desert[i].getSpawnableList(EnumCreatureType.creature).add(nizonianSpawn);
			desert[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			desert[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			desert[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			desert[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			desert[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			desert[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
			desert[i].getSpawnableList(EnumCreatureType.creature).add(nizonianSpawn);
			desert[i].getSpawnableList(EnumCreatureType.monster).add(advSpawn);
			desert[i].getSpawnableList(EnumCreatureType.monster).add(mageSpawn);
			desert[i].getSpawnableList(EnumCreatureType.monster).add(darkElfSpawn);
			desert[i].getSpawnableList(EnumCreatureType.monster).add(galokinSpawn);
			desert[i].getSpawnableList(EnumCreatureType.monster).add(orcSpawn);
			desert[i].getSpawnableList(EnumCreatureType.monster).add(sovSpawn);
		}
		
		for(int i = 0; i < swamp.length; i++)
		{
			swamp[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			swamp[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			swamp[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			swamp[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			swamp[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			swamp[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
			swamp[i].getSpawnableList(EnumCreatureType.monster).add(advSpawn);
			swamp[i].getSpawnableList(EnumCreatureType.monster).add(mageSpawn);
			swamp[i].getSpawnableList(EnumCreatureType.monster).add(darkElfSpawn);
			swamp[i].getSpawnableList(EnumCreatureType.monster).add(galokinSpawn);
			swamp[i].getSpawnableList(EnumCreatureType.monster).add(orcSpawn);
			swamp[i].getSpawnableList(EnumCreatureType.monster).add(sovSpawn);
		}

		for(int i = 0; i < beach.length; i++)
		{
			beach[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			beach[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			beach[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			beach[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			beach[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			beach[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
			beach[i].getSpawnableList(EnumCreatureType.creature).add(paladinSpawn);
			beach[i].getSpawnableList(EnumCreatureType.monster).add(advSpawn);
			beach[i].getSpawnableList(EnumCreatureType.monster).add(mageSpawn);
			beach[i].getSpawnableList(EnumCreatureType.monster).add(darkElfSpawn);
			beach[i].getSpawnableList(EnumCreatureType.monster).add(galokinSpawn);
			beach[i].getSpawnableList(EnumCreatureType.monster).add(orcSpawn);
			beach[i].getSpawnableList(EnumCreatureType.monster).add(sovSpawn);
			beach[i].getSpawnableList(EnumCreatureType.monster).add(paladinSpawn);
		}

		for(int i = 0; i < wasteland.length; i++)
		{
			wasteland[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			wasteland[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			wasteland[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			wasteland[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			wasteland[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			wasteland[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
			wasteland[i].getSpawnableList(EnumCreatureType.monster).add(advSpawn);
			wasteland[i].getSpawnableList(EnumCreatureType.monster).add(mageSpawn);
			wasteland[i].getSpawnableList(EnumCreatureType.monster).add(darkElfSpawn);
			wasteland[i].getSpawnableList(EnumCreatureType.monster).add(galokinSpawn);
			wasteland[i].getSpawnableList(EnumCreatureType.monster).add(orcSpawn);
			wasteland[i].getSpawnableList(EnumCreatureType.monster).add(sovSpawn);
		}
	}

	public static void addNetherSpawning()
	{
		BiomeGenBase[] nether = BiomeDictionary.getBiomesForType(Type.NETHER);

		SpawnListEntry skeleHorseSpawn = new SpawnListEntry(EntitySkeletalHorse.class, 34, 5, 7);
		SpawnListEntry minionSpawn = new SpawnListEntry(EntityAunTunMinion.class, 29, 4, 6);
		SpawnListEntry bodyguardSpawn = new SpawnListEntry(EntityAunTunBodyguard.class, 25, 4, 6);
		SpawnListEntry hellhoundSpawn = new SpawnListEntry(EntityHellhound.class, 35, 4, 6);

		for(int i = 0; i < nether.length; i++)
		{
			nether[i].getSpawnableList(EnumCreatureType.creature).add(skeleHorseSpawn);
			nether[i].getSpawnableList(EnumCreatureType.creature).add(minionSpawn);
			nether[i].getSpawnableList(EnumCreatureType.creature).add(bodyguardSpawn);
			nether[i].getSpawnableList(EnumCreatureType.creature).add(hellhoundSpawn);
			nether[i].getSpawnableList(EnumCreatureType.monster).add(skeleHorseSpawn);
			nether[i].getSpawnableList(EnumCreatureType.monster).add(minionSpawn);
			nether[i].getSpawnableList(EnumCreatureType.monster).add(bodyguardSpawn);
			nether[i].getSpawnableList(EnumCreatureType.monster).add(hellhoundSpawn);
		}
	}

	public static void addEndSpawning()
	{
		BiomeGenBase[] end = BiomeDictionary.getBiomesForType(Type.END);

		SpawnListEntry fairySpawn = new SpawnListEntry(EntityFairy.class, 30, 3, 5);
		SpawnListEntry essenceSpawn = new SpawnListEntry(EntityAltruEssence.class, 30, 3, 5);

		for(int i = 0; i < end.length; i++)
		{
			end[i].getSpawnableList(EnumCreatureType.creature).add(fairySpawn);
			end[i].getSpawnableList(EnumCreatureType.creature).add(essenceSpawn);
			end[i].getSpawnableList(EnumCreatureType.monster).add(fairySpawn);
			end[i].getSpawnableList(EnumCreatureType.monster).add(essenceSpawn);
		}
	}

	public static void addDimensionSpawning()
	{
		EntityRegistry.addSpawn(EntityShadow.class, 1, 3, 6, EnumCreatureType.creature, Biomes.blindOasis);
		EntityRegistry.addSpawn(EntityShadow.class, 1, 3, 6, EnumCreatureType.monster, Biomes.blindOasis);
		EntityRegistry.addSpawn(EntityWoodElf.class, 1, 3, 4, EnumCreatureType.creature, Biomes.blindOasis);
		EntityRegistry.addSpawn(EntityWoodElf.class, 1, 3, 4, EnumCreatureType.monster, Biomes.blindOasis);
		EntityRegistry.addSpawn(EntityVravinite.class, 1, 3, 6, EnumCreatureType.creature, Biomes.glimmerwood);
		EntityRegistry.addSpawn(EntityVravinite.class, 1, 3, 6, EnumCreatureType.monster, Biomes.glimmerwood);
		EntityRegistry.addSpawn(EntityBloodGhoul.class, 1, 3, 6, EnumCreatureType.creature, Biomes.flamonor);
		EntityRegistry.addSpawn(EntityBloodGhoul.class, 1, 3, 6, EnumCreatureType.monster, Biomes.flamonor);
		EntityRegistry.addSpawn(EntityDove.class, 1, 2, 3, EnumCreatureType.creature, Biomes.sanctuatite);
		EntityRegistry.addSpawn(EntityAngel.class, 1, 2, 3, EnumCreatureType.creature, Biomes.sanctuatite);
		EntityRegistry.addSpawn(EntityRabbit.class, 1, 2, 3, EnumCreatureType.creature, Biomes.sanctuatite);
	}
}
