package by.fxg.diverse.common.item;

import by.fxg.diverse.util.IExtItem;
import net.minecraft.creativetab.CreativeTabs;

public class ItemRing extends VMultiItem implements IExtItem {
	public ItemRing(int par1, int par2) {
		super(par1, par2, 1, "itemRing", CreativeTabs.tabCombat);
	}

	@Override
	public int getSlot() {
		return 3;
	}
}
