package sheenrox82.RioV.src.gui.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.BloodUtil;
import sheenrox82.RioV.src.api.util.EosUtil;
import sheenrox82.RioV.src.api.util.PlayerNBT;
import sheenrox82.RioV.src.base.Config;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiBloodBar extends Gui
{
	public Minecraft mc;

	public GuiBloodBar(Minecraft mc)
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

		ResourceLocation icons = new ResourceLocation("riov", "textures/gui/blood_bar.png");
		PlayerNBT props = PlayerNBT.get(mc.thePlayer);
		FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;

		if (props == null || props.maxBlood == 0)
		{
			return;
		}

		if(RioVAPI.getInstance().getUtil().getConfigBool("BLOOD") == true)
		{
			if(!mc.thePlayer.capabilities.isCreativeMode)
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(icons);
				int height = event.resolution.getScaledHeight();
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				float blood = (((float) BloodUtil.getCurrentBlood() / props.maxBlood) * 80);
				this.drawTexturedModalRect(Config.bloodPosX, height - Config.bloodPosY, 0, 49, 102, 14);
				this.drawTexturedModalRect(Config.bloodPosX + 11, (height - Config.bloodPosY) + 4, 11, 64, (int)blood, 6);
				GL11.glPopMatrix();
			}
		}

		if(!RioVAPI.getInstance().getUtil().getConfigBool("BLOOD"))
		{
			if(!mc.thePlayer.capabilities.isCreativeMode)
			{
				int height = event.resolution.getScaledHeight();
				GL11.glPushMatrix();
				fontrenderer.drawStringWithShadow("Blood: " + BloodUtil.getCurrentBlood() + "/" + props.maxBlood, 32, height - 18, 16777215);
				GL11.glPopMatrix();
			}
		}
	}
}
