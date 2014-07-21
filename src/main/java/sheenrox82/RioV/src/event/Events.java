package sheenrox82.RioV.src.event;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import sheenrox82.Core.src.base.ModUpdateChecker;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.BloodUtil;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.api.util.EosUtil;
import sheenrox82.RioV.src.api.util.PlayerNBT;
import sheenrox82.RioV.src.api.util.PlayerStorage;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;
import sheenrox82.RioV.src.block.BlockRioVSapling;
import sheenrox82.RioV.src.content.RioVBlocks;
import sheenrox82.RioV.src.content.RioVItems;
import sheenrox82.RioV.src.handler.WavHandler;
import sheenrox82.RioV.src.handler.packet.PacketHandler;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.client.GuiModList;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Events
{
	public boolean hasSeen;

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void clientLoggedIn(EntityJoinWorldEvent event)
	{			
		if (event.entity instanceof EntityPlayer) 
		{
			EntityPlayer p = (EntityPlayer) event.entity;

			if (p.worldObj.isRemote) 
			{
				if (ModUpdateChecker.isUpdateAvailable()) 
				{
					if(!hasSeen)
					{
						p.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.DARK_RED, "[" + Color.WHITE + Util.MOD_NAME + Color.DARK_RED + "] Hey, " + p.getDisplayName() + "! " + EnumChatFormatting.GOLD + "Version " + ModUpdateChecker.newVersionStr + " is available!" + EnumChatFormatting.DARK_RED + " Check http://tinyurl.com/riovmod. - sheenrox82"));
						hasSeen = true;
					}
				}

				if (!ModUpdateChecker.isUpdateAvailable()) 
				{
					if(!hasSeen)
					{
						p.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.GREEN, "[" + Color.WHITE + Util.MOD_NAME + Color.GREEN + "] Hey, " + p.getDisplayName() + "! Thank you for downloading " + Util.MOD_NAME + "! You are up-to-date! - sheenrox82"));
						hasSeen = true;
					}	
				}
			}
		} 
	}

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer && PlayerNBT.get((EntityPlayer) event.entity) == null)
		{
			PlayerNBT.register((EntityPlayer) event.entity);
		}
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(PlayerNBT.EXT_PROP_NAME) == null)
		{
			event.entity.registerExtendedProperties(PlayerNBT.EXT_PROP_NAME, new PlayerNBT((EntityPlayer) event.entity));
		}
	}

	@SubscribeEvent
	public void playerLoggedInEvent(PlayerLoggedInEvent event)
	{
		EntityPlayer p = event.player;
		RioVAPI.getInstance().getPacketPipeline().sendTo(new PacketHandler(), (EntityPlayerMP)p);
	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entity;

			NBTTagCompound playerData = PlayerStorage.getEntityData(((EntityPlayer) event.entity).getDisplayName() + PlayerNBT.EXT_PROP_NAME);

			if (playerData != null) 
			{
				((PlayerNBT)(event.entity.getExtendedProperties(PlayerNBT.EXT_PROP_NAME))).loadNBTData(playerData);
			}
		}
	}

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event)
	{			
		if (!event.entity.worldObj.isRemote && (event.entity instanceof EntityPlayer || event.entity instanceof EntityPlayerMP))
		{
			NBTTagCompound playerData = new NBTTagCompound();

			if(playerData != null)
			{
				BloodUtil.setCurrentBlood(100);
			}

			((PlayerNBT)(event.entity.getExtendedProperties(PlayerNBT.EXT_PROP_NAME))).saveNBTData(playerData);
			PlayerStorage.storeEntityData(((EntityPlayer) event.entity).getDisplayName() + PlayerNBT.EXT_PROP_NAME, playerData);
			PlayerNBT.saveProxyData((EntityPlayer) event.entity);
		}
	}

	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) 
	{
		if (event.source.getDamageType().equals("player")) 
		{
			if (event.entityLiving instanceof EntityBlaze) 
			{
				event.entityLiving.dropItem(RioVItems.onyx, 2);
			}
			if (event.entityLiving instanceof EntityDragon) 
			{
				event.entityLiving.dropItem(RioVItems.dragonSoul, 40);
			}
			if (event.entityLiving instanceof EntityHorse) 
			{
				event.entityLiving.dropItem(RioVItems.horseMeat, 2);
			}
		}
	}

	@SubscribeEvent
	public void bonemealUsed(BonemealEvent event)
	{
		if(event.world.getBlock(event.x, event.y, event.z) == RioVBlocks.glimmerwoodSapling)
		{
			((BlockRioVSapling)RioVBlocks.glimmerwoodSapling).func_149878_d(event.world, event.x, event.y, event.z, event.world.rand);
		}

		if(event.world.getBlock(event.x, event.y, event.z) == RioVBlocks.cherryBlossomSapling)
		{
			((BlockRioVSapling)RioVBlocks.cherryBlossomSapling).func_149878_d(event.world, event.x, event.y, event.z, event.world.rand);
		}

		if(event.world.getBlock(event.x, event.y, event.z) == RioVBlocks.bloodSapling)
		{
			((BlockRioVSapling)RioVBlocks.bloodSapling).func_149878_d(event.world, event.x, event.y, event.z, event.world.rand);
		}

		if(event.world.getBlock(event.x, event.y, event.z) == RioVBlocks.skywoodSapling)
		{
			((BlockRioVSapling)RioVBlocks.skywoodSapling).func_149878_d(event.world, event.x, event.y, event.z, event.world.rand);
		}
	}

	@SubscribeEvent
	public void playerBloodUpdate(LivingHurtEvent event)
	{
		if(event.entity instanceof EntityPlayer)
		{
			BloodUtil.consumeBlood(3);
		}
	}

	public boolean bloodBlur = false;
	public boolean bloodColor = false;
	public boolean bloodColorII = false;

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void playerUpdateClient(LivingEvent.LivingUpdateEvent event)
	{
		Minecraft mc = Minecraft.getMinecraft();

		if(event.entity instanceof EntityPlayer)
		{
			if(!mc.thePlayer.capabilities.isCreativeMode)
			{
				if(BloodUtil.getCurrentBlood() == 100)
				{
					mc.entityRenderer.theShaderGroup = null;
					bloodBlur = false;
					bloodColor = false;
					bloodColorII = false;
				}

				if(BloodUtil.getCurrentBlood() <= 85 && BloodUtil.getCurrentBlood() > 60)
				{
					mc.entityRenderer.theShaderGroup = null;
					bloodBlur = false;
					bloodColor = false;
					bloodColorII = false;
				}

				if(BloodUtil.getCurrentBlood() <= 60)
				{
					if(bloodBlur == false)
					{
						try
						{
							mc.entityRenderer.theShaderGroup = new ShaderGroup(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), new ResourceLocation("shaders/post/blur.json"));
							mc.entityRenderer.theShaderGroup.createBindFramebuffers(mc.displayWidth, mc.displayHeight);
							bloodBlur = true;
						}
						catch(IOException ioexception)
						{
							ioexception.printStackTrace();
						}
					}
				}

				if(BloodUtil.getCurrentBlood() <= 50 && BloodUtil.getCurrentBlood() > 40)
				{
					if(bloodColor == false)
					{
						try
						{
							mc.entityRenderer.theShaderGroup = new ShaderGroup(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), new ResourceLocation("blood", "shaders/post/desaturateBlur.json"));
							mc.entityRenderer.theShaderGroup.createBindFramebuffers(mc.displayWidth, mc.displayHeight);
							bloodColor = true;
							bloodColorII = false;
						}
						catch(IOException ioexception)
						{
							ioexception.printStackTrace();
						}
					}
				}

				if(BloodUtil.getCurrentBlood() <= 40 && BloodUtil.getCurrentBlood() > 35)
				{
					if(bloodColorII == false)
					{
						try
						{
							mc.entityRenderer.theShaderGroup = new ShaderGroup(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), new ResourceLocation("blood", "shaders/post/desaturateBlurII.json"));
							mc.entityRenderer.theShaderGroup.createBindFramebuffers(mc.displayWidth, mc.displayHeight);
							bloodColorII = true;
							bloodColor = false;
							event.entityLiving.addPotionEffect(new PotionEffect(Potion.harm.getId(), 100, 2));
						}
						catch(IOException ioexception)
						{
							ioexception.printStackTrace();
						}
					}
				}

				if(BloodUtil.getCurrentBlood() <= 35)
				{
					event.entityLiving.addPotionEffect(new PotionEffect(Potion.poison.getId(), 100, 2));
					event.entityLiving.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 100, 2));
					event.entityLiving.addPotionEffect(new PotionEffect(Potion.hunger.getId(), 100, 2));
				}
			}
		}
	}

	public int regenTimer;

	@SubscribeEvent
	public void playerUpdate(LivingEvent.LivingUpdateEvent event)
	{
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer thePlayer = (EntityPlayer)event.entityLiving;

			if(!thePlayer.capabilities.isCreativeMode)
			{
				if(BloodUtil.getCurrentBlood() <= 85)
				{
					event.entityLiving.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 100, 2));
				}

				if(BloodUtil.getCurrentBlood() <= 30 && BloodUtil.getCurrentBlood() > 0)
				{
					event.entityLiving.attackEntityFrom(DamageSource.generic, Float.MAX_VALUE);
				}

				if(thePlayer.getFoodStats().getFoodLevel() >= 12)
				{
					if(BloodUtil.getCurrentBlood() < PlayerNBT.maxBlood)
					{
						++regenTimer;

						if(regenTimer > 70)
						{
							BloodUtil.consumeBlood(-1);
							regenTimer = 0;
						}
					}
				}
			}

			if(EosUtil.getCurrentEos() < PlayerNBT.maxEos)
			{
				++regenTimer;

				if(regenTimer > 70)
				{
					EosUtil.consumeEos(-1);
					regenTimer = 0;
				}
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void guiEvent(GuiOpenEvent event)
	{	    
		String riov = Util.MOD_ID.toLowerCase();

		if(event.gui instanceof GuiMainMenu)
		{
			if(RioVAPI.getInstance().getUtil().getConfigBool("menuMusic") == true)
			{
				WavHandler.setUpSound("BackgroundMusic.wav");
				WavHandler.playSound(0);
			}

			Random rand = new Random();
			int panoRand = rand.nextInt(2);

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			ResourceLocation buttonTextures = new ResourceLocation(riov, "widget.png");

			//NEW FIELDS
			ResourceLocation title = new ResourceLocation(riov, "title.png");
			ResourceLocation[] flamonorPano = new ResourceLocation[] {new ResourceLocation(riov, "pano/flamonor/north.png"), new ResourceLocation(riov, "pano/flamonor/left.png"), new ResourceLocation(riov, "pano/flamonor/back.png"), new ResourceLocation(riov, "pano/flamonor/right.png"), new ResourceLocation(riov, "pano/flamonor/up.png"), new ResourceLocation(riov, "pano/flamonor/down.png")};
			ResourceLocation[] vaerynPano = new ResourceLocation[] {new ResourceLocation(riov, "pano/vaeryn/north.png"), new ResourceLocation(riov, "pano/vaeryn/left.png"), new ResourceLocation(riov, "pano/vaeryn/back.png"), new ResourceLocation(riov, "pano/vaeryn/right.png"), new ResourceLocation(riov, "pano/vaeryn/up.png"), new ResourceLocation(riov, "pano/vaeryn/down.png")};

			RioVAPIUtil.replaceField("minecraftTitleTextures", GuiMainMenu.class, title, event.gui);
			RioVAPIUtil.replaceField("titlePanoramaPaths", GuiMainMenu.class, flamonorPano, event.gui);
			RioVAPIUtil.replaceField("buttonTextures", GuiButton.class, buttonTextures, event.gui);

			if (calendar.get(2) + 1 == 3 && calendar.get(5) == 12)
			{
				RioVAPIUtil.replaceField("splashText", GuiMainMenu.class, Color.AQUA + "The Mists of RioV Anniversary!", event.gui);
			}
			else
			{
				RioVAPIUtil.replaceField("splashText", GuiMainMenu.class, "", event.gui);
			}
		}

		if(event.gui == null || event.gui instanceof GuiOptions || event.gui instanceof GuiLanguage || event.gui instanceof GuiSelectWorld || event.gui instanceof GuiMultiplayer || event.gui instanceof GuiModList || event.gui instanceof GuiDownloadTerrain)
		{
			if(RioVAPI.getInstance().getUtil().getConfigBool("menuMusic") == true)
			{
				WavHandler.stopSound();
			}
		}
	}

	@SubscribeEvent
	public void editMessage(ServerChatEvent event)
	{
		event.setCanceled(true);
		PlayerNBT player = PlayerNBT.get(event.player);

		if(player.factionID == player.raetiinID)
		{
			event.player.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.WHITE, "[Raetiin] " + event.component.getUnformattedTextForChat()));
		}

		if(player.factionID == player.jaerinID)
		{
			event.player.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.WHITE, "[Jaerin] " + event.component.getUnformattedTextForChat()));
		}

		if(player.factionID == -1)
		{
			event.player.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.WHITE, "[No Faction] " + event.component.getUnformattedTextForChat()));
		}
	}
}