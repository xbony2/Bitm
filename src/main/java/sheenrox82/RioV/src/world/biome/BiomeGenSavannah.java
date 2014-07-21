package sheenrox82.RioV.src.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenSavannah extends BiomeGenBase
{
    public BiomeGenSavannah(int par1)
    {
        super(par1);
        this.spawnableCreatureList.clear();
        this.topBlock = Blocks.grass;
        this.fillerBlock = Blocks.sand;
        this.theBiomeDecorator.treesPerChunk = 1;
    }
}
