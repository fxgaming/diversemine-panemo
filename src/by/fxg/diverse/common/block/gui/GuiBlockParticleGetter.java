package by.fxg.diverse.common.block.gui;

import org.lwjgl.opengl.GL11;

import by.fxg.diverse.common.block.container.ContainerBlockParticleGetter;
import by.fxg.diverse.common.tile.TileParticleGetter;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiBlockParticleGetter extends GuiContainer {
	private TileParticleGetter tile;

	public GuiBlockParticleGetter(InventoryPlayer inventoryplayer, TileParticleGetter tileentityInputFurnace) {
		super(new ContainerBlockParticleGetter(inventoryplayer, tileentityInputFurnace));
		this.tile = tileentityInputFurnace;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
	}

	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		super.mc.renderEngine.bindTexture(new ResourceLocation("diverse:textures/gui/blockparticlegetter.png"));
		int j = (super.width - super.xSize) / 2;
		int k = (super.height - super.ySize) / 2;
		this.drawTexturedModalRect(j, k, 0, 0, super.xSize, super.ySize);
	}
}
