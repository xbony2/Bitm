package sheenrox82.RioV.src.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.entity.mob.hostile.boss.EntityAunTun;
import sheenrox82.RioV.src.lib.EntityResourceLocation;

public class RenderAunTun extends RenderBiped
{
	public RenderAunTun()
	{
		super(new ModelBiped(), 0.5F);

	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityAunTun)par1Entity, par2, par4, par6, par8, par9);
	}


	public void func_82418_a(EntityAunTun par1EntityGiantZombie, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRender(par1EntityGiantZombie, par2, par4, par6, par8, par9);
		BossStatus.setBossStatus(par1EntityGiantZombie, true);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityAunTun)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	protected void preRenderScale(EntityAunTun par1EntityGiantZombie, float par2)
	{
		GL11.glScalef(14F, 14F, 14F);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.preRenderScale((EntityAunTun)par1EntityLivingBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return EntityResourceLocation.auntun;
	}
}