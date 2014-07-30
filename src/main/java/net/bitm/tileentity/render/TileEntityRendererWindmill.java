package net.bitm.tileentity.render;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityRendererWindmill extends TileEntitySpecialRenderer {

	private final ResourceLocation textureWindmill = new ResourceLocation("bitm", "textures/models/windmill.png");
	
	private int textureWidth = 64;
	private int textureHeight = 32;
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f){
		GL11.glPushMatrix();
			GL11.glTranslatef((float)x, (float)y, (float)z);
			
			Tessellator tessellator = Tessellator.instance;
			this.bindTexture(textureWindmill);
			tessellator.startDrawingQuads(); //Start of the tessellation process
			{
				tessellator.addVertexWithUV(0, 0, 1, 1, 1);
				tessellator.addVertexWithUV(1, 1, 1, 1/4, 1/4);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				tessellator.addVertexWithUV(0, 0, 0, 0, 1);
			}
			tessellator.draw(); //End of the tessellation process
		GL11.glPopMatrix();
	}

}
