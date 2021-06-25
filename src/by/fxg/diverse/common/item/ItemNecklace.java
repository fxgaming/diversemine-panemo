package by.fxg.diverse.common.item;

import by.fxg.diverse.util.IExtItem;
import net.minecraft.creativetab.CreativeTabs;

public class ItemNecklace extends VMultiItem implements IExtItem {
	public ItemNecklace(int par1, int par2) {
		super(par1, par2, 1, "itemNecklace", CreativeTabs.tabCombat);
	}

	@Override
	public int getSlot() {
		return 0;
	}
	
}
