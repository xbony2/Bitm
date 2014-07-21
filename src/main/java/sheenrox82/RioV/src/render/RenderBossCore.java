package sheenrox82.RioV.src.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.api.entity.EntityBossCore;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.entity.mob.hostile.boss.EntityDemonAngel;
import sheenrox82.RioV.src.entity.mob.hostile.boss.EntityTerron;
import sheenrox82.RioV.src.lib.EntityResourceLocation;


public class RenderBossCore extends RenderLiving
{
	public static float shadow;
	public float scale;

	public RenderBossCore(ModelBase base, float shadow, float scale)
	{
		super(base, shadow);
		this.scale = scale;
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityBossCore)par1Entity, par2, par4, par6, par8, par9);

		if(par1Entity instanceof EntityDemonAngel)
		{
			this.func_147906_a((EntityLiving)par1Entity, Color.DARK_RED + "Demon Angel", par2, par4, par6, 64);
		}

		if(par1Entity instanceof EntityTerron)
		{
			this.func_147906_a((EntityLiving)par1Entity, "Terron", par2, par4, par6, 64);
		}

		doRenderLiving((EntityLiving)par1Entity, par2, par4, par6, par8, par9);
	}

	public void func_82418_a(EntityBossCore par1, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRender(par1, par2, par4, par6, par8, par9);
		BossStatus.setBossStatus(par1, true);
	}

	protected void preRenderScale(EntityBossCore par1EntityGiantZombie, float par2)
	{
		GL11.glScalef(scale, scale, scale);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.preRenderScale((EntityBossCore)par1EntityLivingBase, par2);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityBossCore)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		if(entity instanceof EntityTerron) return EntityResourceLocation.terron;
		if(entity instanceof EntityDemonAngel) return EntityResourceLocation.demon_angel;
		return null;
	}
}