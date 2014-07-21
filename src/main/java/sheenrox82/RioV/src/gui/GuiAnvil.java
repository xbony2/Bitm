package sheenrox82.RioV.src.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.container.ContainerAnvil;
import sheenrox82.RioV.src.lib.GuiResourceLocation;

public class GuiAnvil extends GuiContainer
{	
	public GuiAnvil(InventoryPlayer inventoryplayer, World world, int i, int j, int k)
    {
        super(new ContainerAnvil(inventoryplayer, world, i, j, k));
		
    }

	@Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
		fontRendererObj.drawString("Anvil", 8, 6, 4210752);
		fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 80, 4210752);
    }

	@Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getMinecraft().renderEngine.bindTexture(GuiResourceLocation.anvil);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize + 120);
    }
}
