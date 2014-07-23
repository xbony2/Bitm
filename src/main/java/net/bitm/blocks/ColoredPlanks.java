package net.bitm.blocks;

import net.bitm.creativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ColoredPlanks extends Block{

    public ColoredPlanks(){
        super(Material.wood);
        this.setCreativeTab(creativeTab.bonetabDeco);
   		this.setHardness(2.0F);
   		this.setResistance(5.0F);
        this.setStepSound(soundTypeWood);
    }

    //Not sure what this int is
    @Override
	public int damageDropped(int num){
        return num;
    }

    @Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register){
        blockIcon = register.registerIcon("bitm" + ":" + this.getUnlocalizedName());
    }
	 
}