package sheenrox82.RioV.src.world.provider;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.content.Biomes;
import sheenrox82.RioV.src.world.chunk.ChunkProviderBlindOasis;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderBlindOasis extends WorldProvider
{

	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(Biomes.blindOasis, 0.5F);
		this.dimensionId = Config.blindOasisID;
		this.hasNoSky = true;
	}

	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderBlindOasis(this.worldObj, this.worldObj.getSeed());
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
		return "Blind Oasis";
	}

	public boolean renderStars()
	{
		return false;
	}

	public float getStarBrightness(World world, float f)
	{
		return 10.0F;
	}

	public boolean renderClouds()
	{
		return false;
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

	public ChunkCoordinates getEntrancePortalLocation()
	{
		return new ChunkCoordinates(50, 5, 0);
	}

	@SideOnly(Side.CLIENT)
	public String getWelcomeMessage()
	{
		return "Entering the Blind Oasis";
	}


    /**
     * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
     */
    @Override
    public float calculateCelestialAngle(long par1, float par3)
    {
        int j = (int)(par1 % 48000L);
        float f1 = ((float)j + par3) / 48000.0F - 0.25F;

        if (f1 < 0.0F)
        {
            ++f1;
        }

        if (f1 > 1.0F)
        {
            --f1;
        }

        float f2 = f1;
        f1 = 1.0F - (float)((Math.cos((double)f1 * Math.PI) + 1.0D) / 2.0D);
        f1 = f2 + (f1 - f2) / 3.0F;
        return f1;
        //return (float) Math.sin(f2);
        //return 1F;
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * Return Vec3D with biome specific fog color
     */
    @Override
    public Vec3 getFogColor(float par1, float par2)
    {
        float f2 = MathHelper.cos(par1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f2 < 0.2F)
        {
            f2 = 0.2F;
        }

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        
        float f3 = 0.7529412F;
        float f4 = 0.84705883F;
        float f5 = 1.0F;
        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;
        f3 = 0.9F * f2;
        f4 = 0.75F * f2;
        f5 = 0.6F * f2;
        return Vec3.createVectorHelper((double)f3, (double)f4, (double)f5);
    }
    
    @Override
    protected void generateLightBrightnessTable()
    {
        float f = 0.0F;

        for (int i = 0; i <= 15; ++i)
        {
        	float scaledBrightness = i / 15.0F;
            float f1 = 1.0F - scaledBrightness;
            if(i < 5)
            	this.lightBrightnessTable[i] = 0.5F * scaledBrightness / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
            else
            	this.lightBrightnessTable[i] = scaledBrightness / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
            	
            
        }
    }
    
    public String getSaveFolder()
    {
        return "BlindOasisDim";
    }
}