package sheenrox82.RioV.src.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialCustom extends Material
{

	public MaterialCustom(MapColor par1MapColor)
	{
		super(par1MapColor);
		this.setBurning();
		this.setNoPushMobility();
	}
	
	@Override
    public boolean isOpaque()
    {
        return false;
    }
}
