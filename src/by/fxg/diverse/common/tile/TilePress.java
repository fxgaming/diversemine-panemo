package by.fxg.diverse.common.tile;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TilePress extends VTileInventory {
	public int tick = 0;
	public boolean isWorking = false;
	public int time = 0;
	public int item1 = 0;
	public int item2 = 0;
	
	public TilePress() {
		this.items = new ItemStack[3];
	}
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.isWorking = par1NBTTagCompound.getBoolean("work");
		this.time = par1NBTTagCompound.getInteger("time");
		this.item1 = par1NBTTagCompound.getInteger("item1");
		this.item2 = par1NBTTagCompound.getInteger("item2");
	}

	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("work", this.isWorking);
		par1NBTTagCompound.setInteger("time", this.time);
		par1NBTTagCompound.setInteger("item1", this.item1);
		par1NBTTagCompound.setInteger("item2", this.item2);
	}
		
	public void updateEntity() {
		super.updateEntity();
		try {
			this.tick++;
			if (this.tick >= 20) {
				this.tick = 0;
				PacketDispatcher.sendPacketToAllAround((double) super.xCoord, (double) super.yCoord, (double) super.zCoord, 50.0D, super.worldObj.provider.dimensionId, this.getDescriptionPacket());
				ItemStack crystals = super.items[0];
				ItemStack plabster = super.items[1];
				if (!this.isWorking) {
					if (crystals != null && plabster != null) {
						if (crystals.stackSize >= 8 && plabster.stackSize >= 1) {
							this.isWorking = true;
							this.time++;
							this.item1 = crystals.itemID;
							this.item2 = plabster.itemID;
							return;
						}
					}
				} else {
					if (crystals != null && plabster != null) {
						if (crystals.stackSize >= 8 && plabster.stackSize >= 1) {
							if (this.item1 == crystals.itemID && this.item2 == plabster.itemID) {
								if (this.items[2] != null) {
									if (this.items[2].stackSize >= 64) {
										this.close();
										return;
									}
									if ((this.items[2].itemID - 6) != this.item1) {
										this.close();
										return;
									}
								}
								this.time++;
								if (this.time >= 22) {
									if (this.items[2] == null) {
										this.items[2] = new ItemStack(this.item1 + 6, 1, 0);
									} else {
										this.items[2].stackSize = this.items[2].stackSize + 1;
									}
									if (this.items[0].stackSize == 8) {
										this.items[0] = null;
									} else {
										this.items[0].stackSize = this.items[0].stackSize - 8;
									}
									if (this.items[1].stackSize == 1) {
										this.items[1] = null;
									} else {
										this.items[1].stackSize = this.items[1].stackSize - 1;
									}
									this.close();
									return;
								} else {
									return;
								}
							}
						}
					}
				}
				this.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		this.isWorking = false;
		this.time = 0;
		this.item1 = 0;
		this.item2 = 0;
	}
	
	public void openChest() {
	}

	public void closeChest() {
	}

	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		return false;
	}

	public String getInventoryName() {
		return "container.PressSw";
	}
}
