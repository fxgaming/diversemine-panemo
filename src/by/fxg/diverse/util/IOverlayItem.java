package by.fxg.diverse.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Post;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;

public interface IOverlayItem {
	@SideOnly(Side.CLIENT)
	void renderOverlay(Pre event, int itemDamage);
	@SideOnly(Side.CLIENT)
	void renderOverlay(Post event, int itemDamage);
}
