package sheenrox82.RioV.src.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.content.RioVItems;
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
import sheenrox82.RioV.src.lib.EntityResourceLocation;
import sheenrox82.RioV.src.model.ModelDemonAngel;
import sheenrox82.RioV.src.model.ModelDragonWings;
import sheenrox82.RioV.src.model.ModelHellhound;
import sheenrox82.RioV.src.model.ModelTerron;
import sheenrox82.RioV.src.render.RenderAngel;
import sheenrox82.RioV.src.render.RenderAunTun;
import sheenrox82.RioV.src.render.RenderBipedCore;
import sheenrox82.RioV.src.render.RenderBossCore;
import sheenrox82.RioV.src.render.RenderDarkEssence;
import sheenrox82.RioV.src.render.RenderDove;
import sheenrox82.RioV.src.render.RenderEssence;
import sheenrox82.RioV.src.render.RenderFairy;
import sheenrox82.RioV.src.render.RenderLivingCore;
import sheenrox82.RioV.src.render.RenderOrc;
import sheenrox82.RioV.src.render.RenderPaladin;
import sheenrox82.RioV.src.render.RenderRabbit;
import sheenrox82.RioV.src.render.RenderSkeletalHorse;
import sheenrox82.RioV.src.render.RenderTef;
import sheenrox82.RioV.src.render.item.ItemRenderBow;
import sheenrox82.RioV.src.render.item.ItemRenderLongbow;
import sheenrox82.RioV.src.render.projectile.RenderDarkMatter;
import sheenrox82.RioV.src.render.projectile.RenderDarknessArrow;
import sheenrox82.RioV.src.render.projectile.RenderPinkEssence;
import sheenrox82.RioV.src.render.projectile.RenderVraviniteArrow;
import sheenrox82.RioV.src.render.tileentity.RenderTileEntityFlag;
import sheenrox82.RioV.src.tileentity.TileEntityFlag;
import sheenrox82.RioV.src.util.Util;

//import com.jadarstudios.developercapes.DevCapes;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy 
{	
	private static final ModelDragonWings dragonWings = new ModelDragonWings(1.0F);

	@Override
	public void init() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityMage.class, new RenderBipedCore(EntityResourceLocation.mage));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalHorse.class, new RenderSkeletalHorse());
		RenderingRegistry.registerEntityRenderingHandler(EntityAunTunBodyguard.class, new RenderBipedCore(EntityResourceLocation.auntun));
		RenderingRegistry.registerEntityRenderingHandler(EntityAdv.class, new RenderBipedCore(EntityResourceLocation.adventurer));
		RenderingRegistry.registerEntityRenderingHandler(EntityTerron.class, new RenderBossCore(new ModelTerron(), 0.5F, 1.8F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDemonAngel.class, new RenderBossCore(new ModelDemonAngel(), 0.5F, 2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkElf.class, new RenderBipedCore(EntityResourceLocation.dark_elf));
		RenderingRegistry.registerEntityRenderingHandler(EntityAunTun.class, new RenderAunTun());
		RenderingRegistry.registerEntityRenderingHandler(EntityAltruEssence.class, new RenderEssence());
		RenderingRegistry.registerEntityRenderingHandler(EntityNizonian.class, new RenderLivingCore(new ModelTerron(), 0.5F, 1.5F, 1.5F, 1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGalokin.class, new RenderBipedCore(EntityResourceLocation.galokin));
		RenderingRegistry.registerEntityRenderingHandler(EntityOrc.class, new RenderOrc());
		RenderingRegistry.registerEntityRenderingHandler(EntityFairy.class, new RenderFairy());
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkEssence.class, new RenderDarkEssence());
		RenderingRegistry.registerEntityRenderingHandler(EntityHellhound.class, new RenderLivingCore(new ModelHellhound(), 0.6F, 1.5F, 1.5F, 1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodElf.class, new RenderBipedCore(EntityResourceLocation.wood_elf));
		RenderingRegistry.registerEntityRenderingHandler(EntityTef.class, new RenderTef());
		RenderingRegistry.registerEntityRenderingHandler(EntityTefGuard.class, new RenderBipedCore(EntityResourceLocation.essence));
		RenderingRegistry.registerEntityRenderingHandler(EntityShadow.class, new RenderBipedCore(EntityResourceLocation.shadow));
		RenderingRegistry.registerEntityRenderingHandler(EntityVravinite.class, new RenderBipedCore(EntityResourceLocation.vravinite));
		RenderingRegistry.registerEntityRenderingHandler(EntityDove.class, new RenderDove());
		RenderingRegistry.registerEntityRenderingHandler(EntityAngel.class, new RenderAngel());
		RenderingRegistry.registerEntityRenderingHandler(EntityRabbit.class, new RenderRabbit());
		RenderingRegistry.registerEntityRenderingHandler(EntitySoverianOfficer.class, new RenderBipedCore(EntityResourceLocation.officer));
		RenderingRegistry.registerEntityRenderingHandler(EntityPaladin.class, new RenderPaladin());
		RenderingRegistry.registerEntityRenderingHandler(EntityPinkEssence.class, new RenderPinkEssence(new ResourceLocation(Util.MOD_ID + ":" + "pinkEssence.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkMatter.class, new RenderDarkMatter(new ResourceLocation(Util.MOD_ID + ":" + "darkMatter.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityAunTunMinion.class, new RenderBipedCore(EntityResourceLocation.auntun));
		RenderingRegistry.registerEntityRenderingHandler(EntityBloodGhoul.class, new RenderBipedCore(EntityResourceLocation.blood_ghoul));
		RenderingRegistry.registerEntityRenderingHandler(EntityDarknessArrow.class, new RenderDarknessArrow(EntityResourceLocation.darkness_arrow));
		RenderingRegistry.registerEntityRenderingHandler(EntityVraviniteArrow.class, new RenderVraviniteArrow(EntityResourceLocation.vravinite_arrow));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlag.class, new RenderTileEntityFlag());
	}

	@Override
	public void registerItemRenderers()
	{
		MinecraftForgeClient.registerItemRenderer(RioVItems.bowOfWurTun, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(RioVItems.enforcedBowOfWurTun, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(RioVItems.vraviniteBow, new ItemRenderLongbow());
	}

	@Override
	public void cape()
	{
		if(RioVAPI.getInstance().getUtil().getConfigBool("runCapes") == true)
		{
			//DevCapes.getInstance().registerConfig("https://dl.dropbox.com/u/126631367/RioVCapes.txt", Util.MOD_ID);
		}
		else
		{

		}
	}

	public static int addArmor(String armorName)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armorName);
	}

	@Override
	public ModelBiped getArmorModel(int id)
	{
		switch (id) {
		case 0:
			return dragonWings;
		default:
			break;
		}
		return dragonWings;
	}
}