package by.fxg.diverse.common.player.container;

import by.fxg.diverse.common.player.InventoryExtended;
import by.fxg.diverse.common.slot.SlotExtended;
import by.fxg.diverse.common.slot.SlotInv.Access;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerExtended extends Container {
	public InventoryPlayer invPlayer;

	public ContainerExtended(InventoryPlayer var1, InventoryExtended var2) {
		this.invPlayer = var1;
		this.addSlotToContainer(new SlotExtended(Access.IO, var2, 0, 64, 8));
		this.addSlotToContainer(new SlotExtended(Access.IO, var2, 1, 82, 8));
		this.addSlotToContainer(new SlotExtended(Access.IO, var2, 2, 100, 8));
		this.addSlotToContainer(new SlotExtended(Access.IO, var2, 3, 118, 8));
		this.addSlotToContainer(new SlotExtended(Access.IO, var2, 4, 136, 8));
		this.addSlotToContainer(new SlotExtended(Access.IO, var2, 5, 154, 8));

		int var3;
		for (var3 = 0; var3 < 3; ++var3) {
			for (int var4 = 0; var4 < 9; ++var4) {
				this.addSlotToContainer(new Slot(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3) {
			this.addSlotToContainer(new Slot(var1, var3, 8 + var3 * 18, 142));
		}
	}

	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
		return null;
	}
}
