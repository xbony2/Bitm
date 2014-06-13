package net.bitm.blocks;

import java.util.Random;

import net.bitm.bonytechmod;
import net.bitm.creativeTab;
import net.bitm.config.defaultsettings;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class irongravel extends BlockFalling{

	public irongravel(Material material){
		super();
		
		this.setHardness(0.6F);
		this.setStepSound(soundTypeGravel);
		this.setResistance(2);
		this.setBlockName("irongravel");
		
		if(defaultsettings.alternetcreativemenuonoff == 0){
			this.setCreativeTab(CreativeTabs.tabBlock);
		}else{
		this.setCreativeTab(creativeTab.bonetabMaterials);
		}
	
	}
	
	public Item getItemDropped(int idkwhatthisintis, Random rand, int idkaboutthiseither)
    {
        if (idkaboutthiseither > 3)
        {
        	idkaboutthiseither = 3;
        }

        return rand.nextInt(10 - idkaboutthiseither * 3) == 0 ? bonytechmod.ironflint : Item.getItemFromBlock(this);
    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		blockIcon = register.registerIcon("bitm" + ":" + "irongravel");
	}

}

