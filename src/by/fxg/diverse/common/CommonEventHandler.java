package by.fxg.diverse.common;

import java.util.Random;

import by.fxg.diverse.common.block.BlockRegistry;
import by.fxg.diverse.common.item.ItemRegistry;
import by.fxg.diverse.common.item.VItemArmor;
import by.fxg.diverse.common.player.ExtendedPlayer;
import by.fxg.diverse.util.IArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;

public class CommonEventHandler {
	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer)event.entity) == null) {
			ExtendedPlayer.register((EntityPlayer)event.entity);
		}
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties("epa") == null) {
			event.entity.registerExtendedProperties("epa", new ExtendedPlayer((EntityPlayer)event.entity));
		}
	}
	
	@ForgeSubscribe
	public void onBlockBreak(BlockEvent.BreakEvent e) {
		if (!e.world.isRemote) {
		}
	}
	
	@ForgeSubscribe
	public void onBlockBreak(BlockEvent.HarvestDropsEvent e) {
		if (!e.world.isRemote) {
			if (e.block.blockID >= 2000 && e.block.blockID <= 2004) {
				if (e.harvester != null && e.harvester.getHeldItem() != null) {
					if (e.harvester.getHeldItem().getItem() instanceof ItemPickaxe) {
						ItemStack tool = e.harvester.getHeldItem();
						EnumToolMaterial etm = EnumToolMaterial.valueOf(((ItemPickaxe)tool.getItem()).getToolMaterialName());
						if (etm != null) {
							if (e.block == BlockRegistry.oreVintarium) {
								if (etm.getHarvestLevel() < 3) e.drops.clear();
					    	} else if (e.block == BlockRegistry.oreGelatrium) {
					    		if (etm.getHarvestLevel() < 4) e.drops.clear();
					    	} else if (e.block == BlockRegistry.oreHusazium) {
					    		if (etm.getHarvestLevel() < 5) e.drops.clear();
					    	} else if (e.block == BlockRegistry.oreKusistrium) {
					    		if (etm.getHarvestLevel() < 6) e.drops.clear();
					    	} else if (e.block == BlockRegistry.oreYeselium) {
					    		if (etm.getHarvestLevel() < 7) e.drops.clear();
					    	}
						}
					}
				}
			}
			for (ItemStack i : e.drops) {
				if (i.itemID >= 2000 && i.itemID <= 2004) {
					e.drops.remove(i);
				}
			}
			if (e.block.blockID >= 2000 && e.block.blockID <= 2004) {
				Random rand = e.world.rand;
				if (rand.nextInt(75) == rand.nextInt(75)) {
					e.drops.add(new ItemStack(ItemRegistry.itemPlabster));
				}
			}
		}
	}

	@ForgeSubscribe
	public void onDamage(LivingHurtEvent e) {
		if (e.entity instanceof EntityPlayer && !e.entity.worldObj.isRemote) {
			EntityPlayer p = (EntityPlayer)e.entity;
			ItemStack[] arm = p.inventory.armorInventory;
			int a = 0;
			for (int i = 0; i != arm.length; i++) {
				if (arm[i] != null && arm[i].getItem() instanceof IArmor) {
					a++;
				}
			}
			
			float damage = e.ammount;
			for (int i = 0; i != arm.length; i++) {
				if (arm[i] != null && arm[i].getItem() instanceof IArmor) {
					VItemArmor tut = (VItemArmor)arm[i].getItem();
					if (tut.getCharge(arm[i]) >= damage) {
						tut.discharge(arm[i], (int)damage);
						damage = 0;
					} else {
						tut.discharge(arm[i], (int)damage);
						damage = damage - tut.getCharge(arm[i]);
					}
				}
			}
			if (damage == 0) 
				e.ammount = 0;
			else
				e.ammount = damage;
		}
	}
}
