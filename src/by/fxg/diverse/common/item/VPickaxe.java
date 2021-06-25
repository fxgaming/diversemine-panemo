package by.fxg.diverse.common.item;

import by.fxg.diverse.common.block.BlockRegistry;
import by.fxg.diverse.util.IDamageable;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntitySpellParticleFX;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class VPickaxe extends ItemPickaxe implements IDamageable {
	public float partColor[];
	public boolean isMagical;
	
	public VPickaxe(int par1, EnumToolMaterial par2, int par3, String par4) {
		super(par1, par2);
		this.setMaxStackSize(par3);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.iconString = "diverse:" + par4;
		this.setUnlocalizedName("diverse.item:" + par4);
	}
	
	public VPickaxe(int par1, EnumToolMaterial par2, int par3, String par4, CreativeTabs par5) {
		super(par1, par2);
		this.setMaxStackSize(par3);
		this.setCreativeTab(par5);
		this.iconString = "diverse:" + par4;
		this.setUnlocalizedName("diverse.item:" + par4);
	}
	
	public VPickaxe setMagical(float[] par1) {
		this.partColor = par1;
		this.isMagical = true;
		return this;
	}
	
	public VPickaxe setName(String par1) {
		LanguageRegistry.addName(this, par1);
		return this;
	}
	
	@SideOnly(Side.CLIENT)
    public boolean onEntityItemUpdate(EntityItem par1) {
    	if (this.isMagical) {
    		if (par1.worldObj.isRemote) {
    			EntityFX entityfx = new EntitySpellParticleFX(par1.worldObj, par1.posX, par1.posY, par1.posZ, 0.0D, 0.1D, 0.0D);
                ((EntityFX)entityfx).setRBGColorF((float)this.partColor[0], (float)this.partColor[1], (float)this.partColor[2]);
                Minecraft.getMinecraft().effectRenderer.addEffect(entityfx);
    		}
    		return false;
    	}
        return false;
    }
    
    public boolean canHarvestBlock(Block b) {
    	if (b == BlockRegistry.oreVintarium) {
    		return true;
    	} else if (b == BlockRegistry.oreGelatrium) {
    		if (this.toolMaterial.getHarvestLevel() >= 4) return true;
    		return false;
    	} else if (b == BlockRegistry.oreHusazium) {
    		if (this.toolMaterial.getHarvestLevel() >= 5) return true;
    		return false;
    	} else if (b == BlockRegistry.oreKusistrium) {
    		if (this.toolMaterial.getHarvestLevel() >= 6) return true;
    		return false;
    	} else if (b == BlockRegistry.oreYeselium) {
    		if (this.toolMaterial.getHarvestLevel() >= 7) return true;
    		return false;
    	}
    	return true;
    }
    
    public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2) {
        return false;
    }
}
