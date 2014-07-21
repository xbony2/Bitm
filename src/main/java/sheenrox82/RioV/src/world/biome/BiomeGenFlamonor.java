package sheenrox82.RioV.src.world.biome;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import sheenrox82.RioV.src.content.RioVBlocks;
import sheenrox82.RioV.src.world.feature.WorldGenBloodTree;

public class BiomeGenFlamonor extends BiomeGenBase
{

	public BiomeGenFlamonor(int par1)
	{
		super(par1);
		this.rootHeight = 0.5F;
		this.topBlock = RioVBlocks.bloodGrass;
		this.fillerBlock = RioVBlocks.bloodDirt;
		this.setBiomeName("Flamonor");
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.theBiomeDecorator.treesPerChunk = 5;
		this.theBiomeDecorator.grassPerChunk = 20;
	}
}