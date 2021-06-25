package by.fxg.diverse.common.tile;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileParticleGetter extends VTileInventory {
	public int tick = 0;
	public int time = 0;
	
	public TileParticleGetter() {
		this.items = new ItemStack[9];
	}
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.time = par1NBTTagCompound.getInteger("time");
	}

	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("time", this.time);
	}
		
	public void updateEntity() {
		super.updateEntity();
		try {
			this.tick++;
			if (this.tick >= 20) {
				this.tick = 0;
				PacketDispatcher.sendPacketToAllAround((double) super.xCoord, (double) super.yCoord, (double) super.zCoord, 50.0D, super.worldObj.provider.dimensionId, this.getDescriptionPacket());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		this.time = 0;
	}
	
	public void openChest() {
	}

	public void closeChest() {
	}

	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		return false;
	}

	public String getInventoryName() {
		return "container.particlegetter";
	}
}
