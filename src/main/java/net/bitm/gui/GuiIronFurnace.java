package net.bitm.gui;

import org.lwjgl.opengl.GL11;

import net.bitm.tileentity.TileEntityIronFurnace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiIronFurnace extends GuiContainer{

	public static final ResourceLocation texture = new ResourceLocation("bitm","textures/gui/ironfurnace.png");
	
	public TileEntityIronFurnace ironFurnace;
	
	public GuiIronFurnace(InventoryPlayer inventoryPlayer, TileEntityIronFurnace entity) {
		super(new ContainerIronFurnace(inventoryPlayer, entity));
		
		this.ironFurnace = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = this.ironFurnace.hasCustomInventoryName() ? this.ironFurnace.getInventoryName() : I18n.format(this.ironFurnace.getInventoryName(), new Object[0]);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(this.ironFurnace.isBurning()){
			int k = this.ironFurnace.getBurnTimeRemainingScaled(12);
			drawTexturedModalRect(guiLeft + 56, guiTop + 36 + 12 - k, 176, 12 - k, 14, k + 2);
		}
		int k = this.ironFurnace.getCookTimeProgressScaled(24);
		drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 14, k + 1, 16);
	}

}
