package net.bitm.proxies;

import net.bitm.blocks.TileEntityNytWindmill;
import net.bitm.blocks.TileEntityRendererWindmill;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerProxies(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNytWindmill.class, new TileEntityRendererWindmill());
	}
}
