package sheenrox82.RioV.src.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.container.ContainerRioVWorkbench;
import sheenrox82.RioV.src.lib.GuiResourceLocation;

public class GuiWorkbench extends GuiContainer
{
	public GuiWorkbench(InventoryPlayer player_inventory, World par2World, int par3, int par4, int par5)
	{
		super(new ContainerRioVWorkbench(player_inventory, par2World, par3, par4, par5));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.crafting"), 28, 6, 0x4A4A4A);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 94, 0x4A4A4A);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(GuiResourceLocation.workbench);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize + 120);
	}
}