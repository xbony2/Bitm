package net.bitm.gui;

import org.lwjgl.opengl.GL11;

import net.bitm.bonytechmod;
import net.bitm.blocks.TileEntityNytFurnace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiNytFurnace extends GuiContainer{

	public static final ResourceLocation texture = new ResourceLocation("bitm","textures/gui/standardgui.png");
	
	public TileEntityNytFurnace nytFurnace;
	
	public GuiNytFurnace(InventoryPlayer inventoryPlayer, TileEntityNytFurnace entity) {
		super(new ContainerNytFurnace(inventoryPlayer, entity));
		
		this.nytFurnace = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = this.nytFurnace.hasCustomInventoryName() ? this.nytFurnace.getInventoryName() : I18n.format(this.nytFurnace.getInventoryName(), new Object[0]);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 5, 4210752);
	}
	
	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(this.nytFurnace.hasPower()){
			int k = this.nytFurnace.getPowerRemainingScaled(45);
			drawTexturedModalRect(guiLeft + 8, guiTop + 53 - k, 176, 62 - k, 16, k);
		}
		int k = this.nytFurnace.getCookTimeProgressScaled(24);
		drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 0, k + 1, 16);
	}

}
