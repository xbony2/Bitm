package net.bitm.blocks;

import java.util.List;

import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
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
    public int damageDropped(int num){
        return num;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register){
        blockIcon = register.registerIcon("bitm" + ":" + this.getUnlocalizedName());
    }
	 
}