package sheenrox82.RioV.src.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import sheenrox82.RioV.src.entity.mob.hostile.EntityPaladin;
import sheenrox82.RioV.src.util.Util;


public class RenderPaladin extends RenderBiped
{
	private static final ResourceLocation texture = new ResourceLocation(Util.MOD_ID + ":" + "textures/entity/" + "Paladin.png");

	public RenderPaladin()
	{
		super(new ModelBiped(), 0.5F);

	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityPaladin)par1Entity, par2, par4, par6, par8, par9);
		func_147906_a((EntityLiving)par1Entity, "\u00A79Paladin", par2, par4, par6, 64);
		doRenderLiving((EntityLiving)par1Entity, par2, par4, par6, par8, par9);
	}


	public void func_82418_a(EntityPaladin par1, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRender(par1, par2, par4, par6, par8, par9);
		BossStatus.setBossStatus(par1, true);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityPaladin)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}