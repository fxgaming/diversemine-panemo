package by.fxg.diverse.common;

import by.fxg.diverse.common.block.container.ContainerBlockParticleGetter;
import by.fxg.diverse.common.block.container.ContainerBlockPress;
import by.fxg.diverse.common.block.container.ContainerBlockToolStation;
import by.fxg.diverse.common.block.gui.GuiBlockParticleGetter;
import by.fxg.diverse.common.block.gui.GuiBlockPress;
import by.fxg.diverse.common.block.gui.GuiBlockToolStation;
import by.fxg.diverse.common.player.ExtendedPlayer;
import by.fxg.diverse.common.player.container.ContainerExtended;
import by.fxg.diverse.common.player.gui.GuiExtended;
import by.fxg.diverse.common.tile.TileParticleGetter;
import by.fxg.diverse.common.tile.TilePress;
import by.fxg.diverse.common.tile.TileToolStation;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		if (ID == 249) {
			return new ContainerPlayer(player.inventory, false, player);
		}
		if (ID == 250) {
			return new ContainerExtended(player.inventory, ExtendedPlayer.get(player).extInv);
		}
		
		if (ID == 1000) {
			if (tile instanceof TilePress)
				return new ContainerBlockPress(player.inventory, (TilePress)tile);
		}
		if (ID == 1001) {
			if (tile instanceof TileToolStation)
				return new ContainerBlockToolStation(player.inventory, (TileToolStation)tile);
		}
		if (ID == 1002) {
			if (tile instanceof TileParticleGetter)
				return new ContainerBlockParticleGetter(player.inventory, (TileParticleGetter)tile);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		if (ID == 249) {
			return new GuiInventory(player);
		}
		if (ID == 250) {
			return new GuiExtended(player.inventory, ExtendedPlayer.get(player).extInv);
		}
		
		if (ID == 1000) {
			if (tile instanceof TilePress)
				return new GuiBlockPress(player.inventory, (TilePress)tile);
		}
		if (ID == 1001) {
			if (tile instanceof TileToolStation)
				return new GuiBlockToolStation(player.inventory, (TileToolStation)tile);
		}
		if (ID == 1002) {
			if (tile instanceof TileParticleGetter)
				return new GuiBlockParticleGetter(player.inventory, (TileParticleGetter)tile);
		}
		return null;
	}
}
