package sheenrox82.RioV.src.world.provider;

import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.content.Biomes;
import sheenrox82.RioV.src.world.chunk.ChunkProviderFlamonor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderFlamonor extends WorldProvider
{

	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(Biomes.flamonor, 0.5F);
		this.dimensionId = Config.flamonorID;
	}

	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderFlamonor(this.worldObj, this.worldObj.getSeed());
	}

	public int getAverageGroundLevel()
	{
		return 0;
	}

	
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int par1, int par2)
	{
		return false;
	}

	public String getDimensionName()
	{
		return "Flamonor";
	}

	public boolean renderStars()
	{
		return true;
	}

	public float getStarBrightness(World world, float f)
	{
		return 10.0F;
	}

	public boolean renderClouds()
	{
		return true;
	}

	public boolean renderVoidFog()
	{
		return false;
	}

	public boolean renderEndSky()
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	public boolean isSkyColored()
	{
		return false;
	}

	public boolean canRespawnHere()
	{
		return false;
	}

	public boolean isSurfaceWorld()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public float getCloudHeight()
	{
		return 128.0F;
	}

	public boolean canCoordinateBeSpawn(int par1, int par2)
	{
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public String getWelcomeMessage()
	{
		return "Entering Flamonor";
	}
	
    public String getSaveFolder()
    {
        return "FlamonorDim";
    }
}