package net.bitm.proxies;

import net.bitm.tileentity.TileEntityNytWindmill;
import net.bitm.tileentity.render.TileEntityRendererWindmill;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerProxies(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNytWindmill.class, new TileEntityRendererWindmill());
	}
}
