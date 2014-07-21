package sheenrox82.RioV.src.render.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.model.ModelFlag;
import sheenrox82.RioV.src.util.Util;

public class RenderTileEntityFlag extends TileEntitySpecialRenderer 
{
	private final ModelFlag model;

	public RenderTileEntityFlag() 
	{
		this.model = new ModelFlag();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double par2, double par4, double par6, float par8) 
	{
		int metadata = tileentity.getBlockMetadata();
		int rotationAngle = 0;
		if(metadata%4 == 0)
		{
			rotationAngle = 270;
		}
		if(metadata%4 == 1)
		{
			rotationAngle = 0;
		}
		if(metadata%4 == 2)
		{
			rotationAngle = 90;
		}
		if(metadata%4 == 3)
		{
			rotationAngle = 180;
		}
		GL11.glPushMatrix();
		GL11.glTranslated((float)par2 + 0.5F, (float)par4 + 1.5F, (float)par6 + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		GL11.glRotatef(rotationAngle , 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.0F, -1.5F, 0.0F);
		GL11.glScalef(2.0F, 2.0F, 2.0F);
		ResourceLocation textures = (new ResourceLocation(Util.MOD_ID + ":" + "textures/blocks/RioVFlag.png")); 
		this.bindTexture(textures);
		this.model.renderAll();
		GL11.glPopMatrix();	
	}
}