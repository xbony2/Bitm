package sheenrox82.RioV.src.world.provider;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.content.Biomes;
import sheenrox82.RioV.src.world.chunk.ChunkProviderFlamonor;
import sheenrox82.RioV.src.world.chunk.ChunkProviderVaeryn;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderVaeryn extends WorldProvider
{

	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(Biomes.glimmerwood, 1F);
		this.dimensionId = Config.vaerynID;
	}

	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderVaeryn(this.worldObj, this.worldObj.getSeed());
	}
	
    public String getDimensionName()
    {
        return "Vaeryn";
    }

	@SideOnly(Side.CLIENT)
	public String getWelcomeMessage()
	{
		return "Entering Vaeryn";
	}
	
    public String getSaveFolder()
    {
        return "VaerynDim";
    }
}