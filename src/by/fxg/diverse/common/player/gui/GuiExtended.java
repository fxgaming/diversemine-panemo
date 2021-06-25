package by.fxg.diverse.common.player.gui;

import org.lwjgl.opengl.GL11;

import by.fxg.diverse.client.gui.GuiButtonExtended;
import by.fxg.diverse.common.player.InventoryExtended;
import by.fxg.diverse.common.player.container.ContainerExtended;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiExtended extends InventoryEffectRenderer {
	public InventoryPlayer inv;
	public InventoryExtended holderInventory;
	public static ContainerExtended thiss;
	private float xSize_lo;
	private float ySize_lo;

	public GuiExtended(InventoryPlayer inventoryplayer, InventoryExtended holder) {
		super(new ContainerExtended(inventoryplayer, holder));
		this.inv = inventoryplayer;
		this.holderInventory = holder;
		this.xSize = 176;
		this.ySize = 166;
	}

	public void initGui() {
		super.initGui();
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
	}

	public void drawScreen(int par1, int par2, float par3) {
		super.drawScreen(par1, par2, par3);
		this.xSize_lo = (float) par1;
		this.ySize_lo = (float) par2;
	}

	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		super.mc.renderEngine.bindTexture(new ResourceLocation("diverse:textures/gui/inventoryext.png"));
		int cornerX = super.guiLeft;
		int cornerY = super.guiTop;
		this.drawTexturedModalRect(cornerX, cornerY, 0, 0, super.xSize, super.ySize);
		this.drawPlayerOnGui(super.mc, cornerX + 33, cornerY + 72, 30, (float)(cornerX + 51) - this.xSize_lo, (float)(cornerY + 75 - 50) - this.ySize_lo);
	}

	public static void drawPlayerOnGui(Minecraft par0Minecraft, int par1, int par2, int par3, float par4, float par5) {
		GL11.glEnable(2903);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) par1, (float) par2, 50.0F);
		GL11.glScalef((float) (-par3), (float) par3, (float) par3);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		float f2 = par0Minecraft.thePlayer.renderYawOffset;
		float f3 = par0Minecraft.thePlayer.rotationYaw;
		float f4 = par0Minecraft.thePlayer.rotationPitch;
		par4 -= 19.0F;
		GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-((float) Math.atan((double) (par5 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
		par0Minecraft.thePlayer.renderYawOffset = (float) Math.atan((double) (par4 / 40.0F)) * 20.0F;
		par0Minecraft.thePlayer.rotationYaw = (float) Math.atan((double) (par4 / 40.0F)) * 40.0F;
		par0Minecraft.thePlayer.rotationPitch = -((float) Math.atan((double) (par5 / 40.0F))) * 20.0F;
		par0Minecraft.thePlayer.rotationYawHead = par0Minecraft.thePlayer.rotationYaw;
		GL11.glTranslatef(0.0F, par0Minecraft.thePlayer.yOffset, 0.0F);
		RenderManager.instance.playerViewY = 180.0F;
		RenderManager.instance.renderEntityWithPosYaw(par0Minecraft.thePlayer, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
		par0Minecraft.thePlayer.renderYawOffset = f2;
		par0Minecraft.thePlayer.rotationYaw = f3;
		par0Minecraft.thePlayer.rotationPitch = f4;
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable('耺');
		OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GL11.glDisable(3553);
		OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}
}
