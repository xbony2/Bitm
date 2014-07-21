package sheenrox82.RioV.src.gui.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.base.Config;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiChestplateHud extends Gui
{
	public Minecraft mc;

	public GuiChestplateHud(Minecraft mc)
	{
		super();
		this.mc = mc;
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void render(RenderGameOverlayEvent event)
	{
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}
		
		FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;

		ItemStack chestplate = mc.thePlayer.getCurrentArmor(2);

		if (chestplate == null)
		{
			return;
		}
		
		if(chestplate != null)
		{
			if(!mc.thePlayer.capabilities.isCreativeMode)
			{
				int height = event.resolution.getScaledHeight();
				int width = event.resolution.getScaledWidth();
				GL11.glPushMatrix();
				fontrenderer.drawStringWithShadow(EnumChatFormatting.ITALIC + chestplate.getDisplayName() + ": " + (chestplate.getMaxDamage() - chestplate.getItemDamage()), width - Config.hudPosX, height - Config.hudPosY + 27, 16777215);
				GL11.glPopMatrix();
			}
		}
	}
}
