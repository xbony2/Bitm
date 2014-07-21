package sheenrox82.RioV.src.world.biome;

import net.minecraft.world.biome.BiomeGenBase;
import sheenrox82.RioV.src.content.RioVBlocks;

public class BiomeGenBlindOasis extends BiomeGenBase
{

	public BiomeGenBlindOasis(int par1)
	{
		super(par1);
		this.rootHeight = 0.1F;
		this.topBlock = RioVBlocks.blackRock;
		this.fillerBlock = RioVBlocks.blackRock;
		this.setBiomeName("Blind Oasis");
		this.waterColorMultiplier = 0x000000;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
	}

}