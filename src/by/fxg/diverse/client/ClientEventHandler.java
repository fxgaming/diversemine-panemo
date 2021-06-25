package by.fxg.diverse.client;

import java.awt.Color;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import by.fxg.diverse.Switch;
import by.fxg.diverse.Viod;
import by.fxg.diverse.client.cherry.CherryMainPage;
import by.fxg.diverse.client.gui.GuiLoading;
import by.fxg.diverse.common.item.VItemArmor;
import by.fxg.diverse.common.player.ExtendedPlayer;
import by.fxg.diverse.util.IDamageable;
import by.fxg.diverse.util.IExtItemRender;
import by.fxg.diverse.util.IExtItemUpdate;
import by.fxg.diverse.util.IOverlayItem;
import by.fxg.diverse.util.IRenderLivingItem;
import by.fxg.diverse.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class ClientEventHandler {
	public RenderItem rend = new RenderItem();
	public Minecraft mc = Minecraft.getMinecraft();
	public FontRenderer font = Minecraft.getMinecraft().fontRenderer;
	
	private int currentHealth = 0;
	private int currentFood = 0;
	private int currentCharge = 0;
	private int armorPercentage = 0;
	private int maxCharge = 0;
	private int charge = 0;
	private int tick = 0;
	
	@ForgeSubscribe
    public void renderEntity(RenderLivingEvent.Specials.Pre e) {
		if (this.mc.thePlayer != null) {
			if (this.mc.thePlayer.getHeldItem() != null) {
				if (this.mc.thePlayer.getHeldItem().getItem() instanceof IRenderLivingItem) {
					((IRenderLivingItem)this.mc.thePlayer.getHeldItem().getItem()).renderLiving(e, this.mc.thePlayer.getHeldItem().getItemDamage());
				}
			}
		}
    }
    
    @ForgeSubscribe
    public void renderEntity(RenderLivingEvent.Specials.Post e) {
    	if (this.mc.thePlayer != null) {
			if (this.mc.thePlayer.getHeldItem() != null) {
				if (this.mc.thePlayer.getHeldItem().getItem() instanceof IRenderLivingItem) {
					((IRenderLivingItem)this.mc.thePlayer.getHeldItem().getItem()).renderLiving(e, this.mc.thePlayer.getHeldItem().getItemDamage());
				}
			}
		}
    }

	@ForgeSubscribe
	public void drawHud(RenderGameOverlayEvent.Pre e) {
		if (this.mc.thePlayer != null) {
			if (this.mc.thePlayer.getHeldItem() != null) {
				if (this.mc.thePlayer.getHeldItem().getItem() instanceof IOverlayItem) {
					((IOverlayItem)this.mc.thePlayer.getHeldItem().getItem()).renderOverlay(e, this.mc.thePlayer.getHeldItem().getItemDamage());
				}
			}
		}
		ResourceLocation frame = new ResourceLocation("diverse:textures/overlay/overlay.png");
		ScaledResolution sr = e.resolution;
		if (e.type == e.type.HEALTH) {
			e.setCanceled(true);
		}
		if (e.type == e.type.FOOD) {
			e.setCanceled(true);
		}
		if (e.type == e.type.CROSSHAIRS) {
			if (!(this.mc.currentScreen instanceof CherryMainPage)) {
				this.tick++;
				if (this.tick % 5 == 0) {
					this.charge = 0;
					this.maxCharge = 0;
					this.tick = 0;
					ItemStack[] inv = this.mc.thePlayer.inventory.armorInventory;
					for (ItemStack i : inv) {
						if (i != null && i.getItem() instanceof VItemArmor) {
							this.charge += ((VItemArmor)i.getItem()).getCharge(i);
							this.maxCharge += ((VItemArmor)i.getItem()).maxCharge;
						}
					}
					this.armorPercentage = Utils.getPercentOf(80, this.charge, this.maxCharge);
				}
				if (this.mc.thePlayer != null) {
					if (Utils.getPercentOf(80, this.mc.thePlayer.getHealth(), this.mc.thePlayer.getMaxHealth()) > this.currentHealth) {
						this.currentHealth++;
					} else if (Utils.getPercentOf(80, this.mc.thePlayer.getHealth(), this.mc.thePlayer.getMaxHealth()) < this.currentHealth) {
						this.currentHealth--;
					}
					if (Utils.getPercentOf(80, this.mc.thePlayer.getFoodStats().getFoodLevel(), 20) > this.currentFood) {
						this.currentFood++;
					} else if (Utils.getPercentOf(80, this.mc.thePlayer.getFoodStats().getFoodLevel(), 20) < this.currentFood) {
						this.currentFood--;
					}
					if (this.armorPercentage > this.currentCharge) {
						this.currentCharge++;
					} else if (this.armorPercentage < this.currentCharge) {
						this.currentCharge--;
					}
					if (this.currentHealth > 80) this.currentHealth = 80;
					if (this.currentFood > 80) this.currentFood = 80;
					if (this.currentCharge > 80) this.currentCharge = 80;
				}
				
				this.mc.renderEngine.bindTexture(frame);
				GL11.glPushMatrix();
				GL11.glScalef(0.75F, 0.75F, 0.75F);
				for (int i = 0; i != 3; i++) {
					drawTexturedModalRect(84, 5 + (i * 20), 80, 134, 80, 16);
				}
				drawTexturedModalRect(84, 6, 0, 150, this.currentHealth, 14);
				drawTexturedModalRect(84, 26, 0, 136, this.currentFood, 14);
				drawTexturedModalRect(84, 46, 80, 150, this.currentCharge, 14);
				this.font.drawString((int)this.mc.thePlayer.getHealth() + "/" + (int)this.mc.thePlayer.getMaxHealth(), 86, 7, Color.BLACK.getRGB());
				this.font.drawString(this.mc.thePlayer.getFoodStats().getFoodLevel() + "/20", 86, 27, Color.BLACK.getRGB());
				if (this.maxCharge > 0) this.font.drawString(this.charge + "/" + this.maxCharge, 86, 47, Color.BLACK.getRGB());
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				this.mc.renderEngine.bindTexture(frame);
				drawTexturedModalRect(1, 1, 128, 0, 84, 89);
				drawTexturedModalRect(164, 3, 85, 166, 32, 60);
				GL11.glPushMatrix();
				GL11.glScalef(32.0F, 32.0F, 32.0F);
				GL11.glTranslatef(1.03F, 0.75F, 2.0F);
				GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(150.0F, 0.0F, 1.0F, 0.0F);
				GL11.glEnable(GL11.GL_COLOR_MATERIAL);
				RenderHelper.enableStandardItemLighting();
				RenderManager.instance.renderEntityWithPosYaw(Viod.fakePlayerFactory.getFakePlayer(), 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
				Viod.fakePlayerFactory.getFakePlayer().inventory = this.mc.thePlayer.inventory;
				RenderHelper.disableStandardItemLighting();
				GL11.glDisable(GL12.GL_RESCALE_NORMAL);
				OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		        GL11.glDisable(GL11.GL_TEXTURE_2D);
		        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
				GL11.glPopMatrix();
				if (this.mc.thePlayer.getHeldItem() != null && this.mc.thePlayer.getHeldItem().getItem() instanceof IDamageable) {
					int damage = (int)((double)(this.mc.thePlayer.getHeldItem().getMaxDamage() - this.mc.thePlayer.getHeldItem().getItemDamage()) / ((double)this.mc.thePlayer.getHeldItem().getMaxDamage() / 54.0D));
					int type = Utils.getNBT(this.mc.thePlayer.getHeldItem()).getBoolean("infinity") ? 1 : 0;
					GL11.glPushMatrix();
					RenderHelper.enableStandardItemLighting();
					GL11.glScalef(0.5F, 0.5F, 0.5F);
					this.rend.renderItemIntoGUI(this.font, this.mc.getTextureManager(), this.mc.thePlayer.getHeldItem(), 18, sr.getScaledHeight() * 2);
					RenderHelper.disableStandardItemLighting();
					GL11.glPopMatrix();
					this.mc.renderEngine.bindTexture(frame);
					drawTexturedModalRect(1, sr.getScaledHeight() - 8, 232, 54, 24, 90);
					if (type == 0) drawTexturedModalRect(6, (sr.getScaledHeight() + 73) - damage, 228, 0, 14, damage);
					else drawTexturedModalRect(6, sr.getScaledHeight() + 19, 242, 0, 14, 54);
				}
				GL11.glPopMatrix();
			}
		}
	}
	
	@ForgeSubscribe
	public void drawHud(RenderGameOverlayEvent.Post e) {
		if (this.mc.thePlayer != null) {
			if (this.mc.thePlayer.getHeldItem() != null) {
				if (this.mc.thePlayer.getHeldItem().getItem() instanceof IOverlayItem) {
					((IOverlayItem)this.mc.thePlayer.getHeldItem().getItem()).renderOverlay(e, this.mc.thePlayer.getHeldItem().getItemDamage());
				}
			}
		}
	}
	
	@ForgeSubscribe
	public void onGui(GuiOpenEvent e) {
		if (e.gui instanceof GuiMainMenu && !Viod.clientManager.gameStarted) {
			e.setCanceled(true);
			this.mc.displayGuiScreen(new GuiLoading());
		} else if (e.gui instanceof GuiMainMenu && Viod.clientManager.gameStarted && Switch.isClient) {
			this.mc.shutdownMinecraftApplet();
		}
	}
	
    public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6) {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + par6), 0, (double)((float)(par3 + 0) * f), (double)((float)(par4 + par6) * f1));
        tessellator.addVertexWithUV((double)(par1 + par5), (double)(par2 + par6), 0, (double)((float)(par3 + par5) * f), (double)((float)(par4 + par6) * f1));
        tessellator.addVertexWithUV((double)(par1 + par5), (double)(par2 + 0), 0, (double)((float)(par3 + par5) * f), (double)((float)(par4 + 0) * f1));
        tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + 0), 0, (double)((float)(par3 + 0) * f), (double)((float)(par4 + 0) * f1));
        tessellator.draw();
    }
}
