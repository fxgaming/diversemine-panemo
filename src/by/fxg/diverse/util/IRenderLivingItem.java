package by.fxg.diverse.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.RenderLivingEvent.Specials.Post;
import net.minecraftforge.client.event.RenderLivingEvent.Specials.Pre;

public interface IRenderLivingItem {
	@SideOnly(Side.CLIENT)
	void renderLiving(Pre event, int itemDamage);
	@SideOnly(Side.CLIENT)
	void renderLiving(Post event, int itemDamage);
}
