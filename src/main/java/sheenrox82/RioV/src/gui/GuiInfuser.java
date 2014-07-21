package sheenrox82.RioV.src.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.container.ContainerInfuser;
import sheenrox82.RioV.src.lib.GuiResourceLocation;
import sheenrox82.RioV.src.tileentity.TileEntityInfuser;

public class GuiInfuser extends GuiContainer
{
	public GuiInfuser(InventoryPlayer player_inventory, TileEntityInfuser tile_entity)
	{
		super(new ContainerInfuser(player_inventory, tile_entity));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j){

		this.fontRendererObj.drawString("Infuser", 6, 6, 0x4A4A4A);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 0x4A4A4A);
	}

	@Override
	//drawGuiContainerBackgroundLayer
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(GuiResourceLocation.infuser);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize + 120);
	}
}