package sheenrox82.RioV.src.world.chunk;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import sheenrox82.RioV.src.content.RioVBlocks;
import sheenrox82.RioV.src.world.mineable.WorldGenBalance;
import sheenrox82.RioV.src.world.mineable.WorldGenFlamonorMineable;
import cpw.mods.fml.common.eventhandler.Event.Result;

public class ChunkProviderFlamonor implements IChunkProvider{

	private Random rand;
	private NoiseGeneratorOctaves noiseGen1;
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	private NoiseGeneratorOctaves field_909_n;
	private NoiseGeneratorOctaves noiseGen4;
	public NoiseGeneratorOctaves noiseGen5;
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;
	private World worldObj;
	private double[] noiseArray;
	private double[] stoneNoise = new double[256];
	private MapGenBase caveGenerator = new MapGenCaves();
	private BiomeGenBase[] biomesForGeneration;
	double[] noise3;
	double[] noise1;
	double[] noise2;
	double[] noise5;
	double[] noise6;
	int[][] field_914_i = new int[32][32];
	private double[] generatedTemperatures;

	public ChunkProviderFlamonor(World var1, long var2){
		this.worldObj = var1;
		this.rand = new Random(var2);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.field_909_n = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
	}

	@Override
	public boolean chunkExists(int i, int j) {
		return true;
	}

	public void generateTerrain(int var1, int var2, Block[] var3, BiomeGenBase[] var4) {
		byte var6 = 2;
		int var7 = var6 + 1;
		byte var8 = 33;
		int var9 = var6 + 1;
		this.noiseArray = this.initializeNoiseField(this.noiseArray, var1 * var6, 0, var2 * var6, var7, var8, var9);

		for (int var10 = 0; var10 < var6; ++var10) {
			for (int var11 = 0; var11 < var6; ++var11) {
				for (int var12 = 0; var12 < 32; ++var12) {
					double var13 = 0.25D;
					double var15 = this.noiseArray[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 0];
					double var17 = this.noiseArray[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 0];
					double var19 = this.noiseArray[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 0];
					double var21 = this.noiseArray[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 0];
					double var23 = (this.noiseArray[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 1] - var15) * var13;
					double var25 = (this.noiseArray[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 1] - var17) * var13;
					double var27 = (this.noiseArray[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 1] - var19) * var13;
					double var29 = (this.noiseArray[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 1] - var21) * var13;

					for (int var31 = 0; var31 < 4; ++var31) {
						double var32 = 0.125D;
						double var34 = var15;
						double var36 = var17;
						double var38 = (var19 - var15) * var32;
						double var40 = (var21 - var17) * var32;

						for (int var42 = 0; var42 < 8; ++var42) {
							int var43 = var42 + var10 * 8 << 11 | 0 + var11 * 8 << 7 | var12 * 4 + var31;
							short var44 = 128;
							double var45 = 0.125D;
							double var47 = var34;
							double var49 = (var36 - var34) * var45;

							for (int var51 = 0; var51 < 8; ++var51) {
								Block var52 = null;

								if (var47 > 0.0D) {
									var52 = Blocks.stone;
								}

								var3[var43] = var52;
								var43 += var44;
								var47 += var49;
							}

							var34 += var38;
							var36 += var40;
						}

						var15 += var23;
						var17 += var25;
						var19 += var27;
						var21 += var29;
					}
				}
			}
		}
	}

    public Chunk provideChunk(int par1, int par2) {
        this.rand.setSeed((long)par1 * 391279128714L + (long)par2 * 132894987741L);
        Block[] ablock = new Block[32768];
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
        this.generateTerrain(par1, par2, ablock, this.biomesForGeneration);
        this.replaceBlocksForBiome(par1, par2, ablock, this.biomesForGeneration);
        Chunk chunk = new Chunk(this.worldObj, ablock, par1, par2);
        byte[] abyte = chunk.getBiomeArray();

        for (int k = 0; k < abyte.length; ++k) {
            abyte[k] = (byte)this.biomesForGeneration[k].biomeID;
        }

        chunk.generateSkylightMap();
        return chunk;
    }

	public void replaceBlocksForBiome(int var1, int var2, Block[] var3, BiomeGenBase[] var4) {
		byte var5 = 63;
		double var6 = 0.03125D;
		this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, var1 * 16, var2 * 16, 0, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

		ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, var1, var2, var3, var4);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Result.DENY) return;

		for (int var8 = 0; var8 < 16; ++var8) {
			for (int var9 = 0; var9 < 16; ++var9) {
				BiomeGenBase var10 = var4[var9 + var8 * 16];
				float var11 = var10.getFloatTemperature(var9, var9, var9);
				int var12 = (int)(this.stoneNoise[var8 + var9 * 16] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
				int var13 = -1;
				Block var14 = var10.topBlock;
				Block var15 = RioVBlocks.bloodGrass;

				for (int var16 = 127; var16 >= 0; --var16) {
					int var17 = (var9 * 16 + var8) * 128 + var16;

					if (var16 <= 0 + this.rand.nextInt(5)) {
						var3[var17] = null;
					} else {
						Block var18 = var3[var17];

						if (var18 == null) {
							var13 = -1;
						}
						else if (var18 == Blocks.stone) {
							if (var13 == -1) {
								if (var12 <= 0) {
									var14 = RioVBlocks.bloodGrass;
									var15 = RioVBlocks.bloodGrass;
								}
								else if (var16 >= var5 - 4 && var16 <= var5 + 1) {
									var14 = RioVBlocks.bloodGrass;
									var15 = RioVBlocks.flamonorRock;
								}

								if (var16 >= var5 - 1) {
									var3[var17] = var14;
								} else {
									var3[var17] = var15;
								}
							}
							else if (var13 > 0) {
								--var13;
								var3[var17] = var15;

								if (var13 == 0 && var15 == RioVBlocks.bloodGrass) {
									var13 = -1;
									var15 = RioVBlocks.bloodGrass;
								}
							}
						}

						if (var13 > 0) {
							--var13;
							var3[var17] = var15;

							if (var13 == 0 && var15 == RioVBlocks.flamonorRock) {
								var13 = -1;
								var15 = RioVBlocks.flamonorRock;
							}
						}
					}
				}
			}
		}
	}

	@Override
	public Chunk loadChunk(int i, int j) {
		return this.provideChunk(i, j);
	}

	private double[] initializeNoiseField(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (var1 == null) {
			var1 = new double[var5 * var6 * var7];
		}

		double var8 = 684.412D;
		double var10 = 684.412D;
		this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
		this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
		var8 *= 2.0D;
		this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, var2, var3, var4, var5, var6, var7, var8 / 80.0D, var8 / 160.0D, var8 / 80.0D);
		this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, var2, var3, var4, var5, var6, var7, var8, var10, var8);
		this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, var2, var3, var4, var5, var6, var7, var8, var10, var8);
		int var12 = 0;
		int var13 = 0;
		int var14 = 16 / var5;

		for (int var15 = 0; var15 < var5; ++var15) {
			int var16 = var15 * var14 + var14 / 2;

			for (int var17 = 0; var17 < var7; ++var17) {
				int var18 = var17 * var14 + var14 / 2;
				double var19 = (this.noise5[var13] + 256.0D) / 512.0D;
				double var21 = this.noise6[var13] / 8000.0D;

				if (var21 < 0.0D) {
					var21 = -var21 * 0.3D;
				}

				var21 = var21 * 3.0D - 2.0D;

				if (var21 > 1.0D) {
					var21 = 1.0D;
				}

				var21 /= 8.0D;
				var21 = 0.0D;

				if (var19 < 0.0D) {
					var19 = 0.0D;
				}

				var19 += 0.5D;
				var21 = var21 * var6 / 16.0D;
				++var13;
				double var23 = var6 / 2.0D;

				for (int var25 = 0; var25 < var6; ++var25) {
					double var26 = 0.0D;
					double var28 = (var25 - var23) * 8.0D / var19;

					if (var28 < 0.0D) {
						var28 *= -1.0D;
					}

					double var30 = this.noise1[var12] / 512.0D;
					double var32 = this.noise2[var12] / 512.0D;
					double var34 = (this.noise3[var12] / 10.0D + 1.0D) / 2.0D;

					if (var34 < 0.0D) {
						var26 = var30;
					}
					else if (var34 > 1.0D) {
						var26 = var32;
					} else {
						var26 = var30 + (var32 - var30) * var34;
					}

					var26 -= 8.0D;
					byte var36 = 32;
					double var37;

					if (var25 > var6 - var36) {
						var37 = (var25 - (var6 - var36)) / (var36 - 1.0F);
						var26 = var26 * (1.0D - var37) + -30.0D * var37;
					}

					var36 = 8;

					if (var25 < var36) {
						var37 = (var36 - var25) / (var36 - 1.0F);
						var26 = var26 * (1.0D - var37) + -30.0D * var37;
					}

					var1[var12] = var26;
					++var12;
				}
			}
		}

		return var1;
	}

	@Override
	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3)
	{
		BlockSand.fallInstantly = true;
		int k = par2 * 16;
		int l = par3 * 16;
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long i1 = this.rand.nextLong() / 2L * 2L + 1L;
		long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long)par2 * i1 + (long)par3 * j1 ^ this.worldObj.getSeed());
		boolean flag = false;
		int var13;
		int var14;
		int var15;
		int var16;
		int d, y;

		for(int x =0; x < 8; x++)
		{
			var14 = k + this.rand.nextInt(16);
			var15 = this.rand.nextInt(128);
			var16 = l + this.rand.nextInt(16);
			(new WorldGenFlamonorMineable(RioVBlocks.drakiuzOre, 4)).generate(this.worldObj, this.rand, var14, var15, var16);
			(new WorldGenFlamonorMineable(RioVBlocks.steamingBloodDeposit, 5)).generate(this.worldObj, this.rand, var14, var15, var16);
		}

		for(int var5 = 0; var5 < 2; ++var5)
		{
			int var6 = k + rand.nextInt(16);
			int var7 = rand.nextInt(128);
			int var8 = l + rand.nextInt(16);
			new WorldGenBalance(RioVBlocks.bloodBerryBush).generate(worldObj, rand, var6, var7, var8);
			new WorldGenBalance(RioVBlocks.bloodFlower).generate(worldObj, rand, var6, var7, var8);
		}

		biomegenbase.decorate(this.worldObj, this.rand, k, l);
		SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);

		BlockSand.fallInstantly = false;
	}
	
	@Override
	public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
		return true;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public String makeString() {
		return "Flamonor";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i, int j, int k) {
		BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(i, k);
		return var5 == null ? null : var5.getSpawnableList(enumcreaturetype);
	}

	@Override
	public ChunkPosition func_147416_a(World world, String s, int i, int j, int k) {
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int i, int j) { }

	@Override
	public void saveExtraData() { }
}