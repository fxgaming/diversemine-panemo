package by.fxg.diverse.common.block.container;

import by.fxg.diverse.common.slot.SlotID;
import by.fxg.diverse.common.tile.TileParticleGetter;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;

public class ContainerBlockParticleGetter extends ContainerBase {
   private TileParticleGetter tileentity;
   private int time = 0;

   public ContainerBlockParticleGetter(InventoryPlayer inventoryplayer, TileParticleGetter tileentity) {
      super(inventoryplayer);
      this.tileentity = tileentity;
      SlotID slot = new SlotID(tileentity, 0, 53, 23, 1);
      this.addSlotToContainer(slot);
      slot = new SlotID(tileentity, 1, 53, 44, 2);
      this.addSlotToContainer(slot);
      slot = new SlotID(tileentity, 2, 129, 34, 0);
      this.addSlotToContainer(slot);
      this.callPlayerInventory(84);
   }

   public void addCraftingToCrafters(ICrafting par1ICrafting) {
      super.addCraftingToCrafters(par1ICrafting);
      par1ICrafting.sendProgressBarUpdate(this, 0, this.tileentity.time);
   }

   public void detectAndSendChanges() {
      super.detectAndSendChanges();
      for(int i = 0; i < super.crafters.size(); ++i) {
         ICrafting icrafting = (ICrafting)super.crafters.get(i);
         if(this.time != this.tileentity.time) {
        	 icrafting.sendProgressBarUpdate(this, 0, this.tileentity.time);
         }
      }
      
      this.time = this.tileentity.time;
   }

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		if (par1 == 0) {
			this.tileentity.time = par2;
		}
	}

   public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
      return this.tileentity.isUseableByPlayer(par1EntityPlayer);
   }

   public int getMergeMaxSlotIndex(int SlotIndex) {
      return SlotIndex + 1;
   }
}
