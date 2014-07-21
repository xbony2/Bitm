package sheenrox82.RioV.src.gui;

import java.util.ArrayList;
import java.util.List;

import sheenrox82.RioV.src.base.Config;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import cpw.mods.fml.client.config.DummyConfigElement.DummyCategoryElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.gui.ForgeGuiFactory.ForgeConfigGui.ChunkLoaderEntry;
import net.minecraftforge.client.gui.ForgeGuiFactory.ForgeConfigGui.GeneralEntry;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
 
public class GuiRioVConfig extends GuiConfig 
{
    public GuiRioVConfig(GuiScreen parent) 
    {
        super(parent, new ConfigElement(Config.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), "RioV", false, false, GuiConfig.getAbridgedConfigPath("The Mists of RioV Config"));
    }
}