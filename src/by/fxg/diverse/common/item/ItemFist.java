package by.fxg.diverse.common.item;

import by.fxg.diverse.client.model.accessories.ModelAccessories;
import by.fxg.diverse.client.model.accessories.fist.VFist0;
import by.fxg.diverse.util.IExtItem;
import by.fxg.diverse.util.IExtItemRender;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ItemFist extends VMultiItem implements IExtItem, IExtItemRender {
	private ModelAccessories[] model = new ModelAccessories[8];
	private VFist0 m = new VFist0();
	public ItemFist(int par1, int par2) {
		super(par1, par2, 1, "itemFist", CreativeTabs.tabCombat);
	}

	@Override
	public int getSlot() {
		return 2;
	}

	@Override
	public ModelAccessories getModel(ItemStack par1) {
		return this.m;
	}

//	@Override
//	public void render(ModelPlayer mp, EntityPlayer ep, ExtendedPlayer exp, ItemStack is, int slot, float[] floats) {
//		System.out.println("1");
//	}
}
