package by.fxg.diverse.common.block;

import by.fxg.diverse.Viod;
import by.fxg.diverse.common.tile.TileParticleGetter;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockParticleGetter extends VBlockBase {
	public BlockParticleGetter(int id) {
		super(id);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setResistance(25.0F);
		this.setHardness(5.0F);
		this.setUnlocalizedName("vgui.particlegetter");
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if (par1World.isRemote) {
			return true;
		} else if (!par5EntityPlayer.isSneaking()) {
			TileParticleGetter var10 = (TileParticleGetter) par1World.getBlockTileEntity(par2, par3, par4);
			if (var10 != null) {
				par5EntityPlayer.openGui(Viod.instance, 1002, par1World, par2, par3, par4);
			}
			return true;
		} else {
			return false;
		}
	}

	public TileEntity createNewTileEntity(World world) {
		return null;
	}

	public TileEntity createTileEntity(World world, int metadata) {
		return new TileParticleGetter();
	}

	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public void registerIcons(IconRegister par1IconRegister) {
		super.blockIcon = par1IconRegister.registerIcon("diverse:machine");
	}
}
