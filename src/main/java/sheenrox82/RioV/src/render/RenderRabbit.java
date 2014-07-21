package sheenrox82.RioV.src.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import sheenrox82.RioV.src.entity.mob.passive.EntityRabbit;
import sheenrox82.RioV.src.model.ModelRabbit;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRabbit extends RenderLiving
{
	private static final ResourceLocation field_110917_a = new ResourceLocation(Util.MOD_ID + ":" + "textures/entity/" + "Rabbit.png");
	private static final ResourceLocation field_110915_f = new ResourceLocation(Util.MOD_ID + ":" + "textures/entity/" + "RabbitTamed.png");

	public RenderRabbit()
	{
		super(new ModelRabbit(), 0.5F);
	}

	public void renderAdv(EntityRabbit var1, double var2, double var4, double var6, float var8, float var9)
	{
		super.doRender(var1, var2, var4, var6, var8, var9);
	}

	public void doRender(EntityLiving var1, double var2, double var4, double var6, float var8, float var9)
	{
		renderAdv((EntityRabbit)var1, var2, var4, var6, var8, var9);
	}

	public void doRenderLiving(Entity var1, double var2, double var4, double var6, float var8, float var9)
	{
		renderAdv((EntityRabbit)var1, var2, var4, var6, var8, var9);
	}

	
	protected ResourceLocation getEntityTexture(EntityRabbit par1EntityWolf)
	{
		return par1EntityWolf.isTamed() ? field_110915_f : field_110917_a;
	}

	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntityRabbit)par1Entity);
	}
}
