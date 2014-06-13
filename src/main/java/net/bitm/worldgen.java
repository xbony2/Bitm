package net.bitm;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class worldgen implements IWorldGenerator
{
	private WorldGenerator nytGen;
	private WorldGenerator viceGen;
	
	public worldgen(){
		GameRegistry.registerWorldGenerator(this, 0);
		nytGen = new WorldGenMinable(bonytechmod.nytore, 7, Blocks.netherrack);
		viceGen = new WorldGenMinable(bonytechmod.viceore, 3, Blocks.netherrack);
	}
	private void generateStandardOre(Random rand, int chunkX, int chunkZ, World world, int iterations, WorldGenerator gen, int lowestY, int highestY){
		for (int i=0; i < iterations; i++){
			int x = chunkX + rand.nextInt(16);
			int y = rand.nextInt(highestY - lowestY) + lowestY;
			int z = chunkZ + rand.nextInt(16);
			
			gen.generate(world, rand, x, y, z);
		}
	}
	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		generateStandardOre(random, chunkX, chunkZ, world, 20, nytGen, 0, 128);
		generateStandardOre(random, chunkX, chunkZ, world, 20, viceGen, 0, 128);
       }
}
