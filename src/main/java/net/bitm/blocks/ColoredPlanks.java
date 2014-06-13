package net.bitm.blocks;

import java.util.List;

import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ColoredPlanks extends Block{
    public static final String[] woodType = new String[] {"white", "orange", "magenta", "lightBlue", "yellow", "lime", "pink", "gray", "lightGray", "cyan", "purple", "blue", "brown", "green", "red", "black"};

    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public ColoredPlanks(){
        super(Material.wood);
        this.setCreativeTab(creativeTab.bonetabDeco);
   		this.setBlockName("coloredPlanks");
        
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        return this.iconArray[meta];
    }

    //Not sure what the int is
    public int damageDropped(int p_149692_1_){
        return p_149692_1_;
    }

	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list){
    	 for(int i = 0; i < woodType.length; i++){
    		 list.add(new ItemStack(item, 1, i));
         }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register){
        this.iconArray = new IIcon[woodType.length];

        for (int i = 0; i < this.iconArray.length; ++i){
            this.iconArray[i] = register.registerIcon("bitm" + ":" + woodType[i] + "Planks");
        }
    }
}