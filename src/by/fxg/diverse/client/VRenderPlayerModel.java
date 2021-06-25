package by.fxg.diverse.client;

import org.lwjgl.opengl.GL11;

import api.player.model.ModelPlayerAPI;
import api.player.model.ModelPlayerBase;
import by.fxg.diverse.client.model.VModelArmor;
import by.fxg.diverse.client.model.accessories.fist.VFist0;
import by.fxg.diverse.client.model.player.CustomBody;
import by.fxg.diverse.client.model.player.CustomMouth;
import by.fxg.diverse.client.model.player.CustomPart;
import by.fxg.diverse.common.player.ExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class VRenderPlayerModel extends ModelPlayerBase {
	Test t = new Test();
	VFist0 a = new VFist0();
	CustomPart pp = new CustomPart();
	CustomMouth pm = new CustomMouth();
	CustomBody pb = new CustomBody();
	
	public VRenderPlayerModel(ModelPlayerAPI var1) {
		super(var1);
	}

	public void render(Entity e, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(e, par2, par3, par4, par5, par6, par7);
		if (e != null) {
			try {
				EntityPlayer p = (EntityPlayer)e;
				ExtendedPlayer ep = ExtendedPlayer.get(p);
				Integer load = 0;
				if (ep != null) {
					GL11.glPushMatrix();
					VModelArmor mod = t;
//					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("diverse:test.png"));
//					mod.isSneak = super.modelPlayer.isSneak;
//					mod.isRiding = super.modelPlayer.isRiding;
//					mod.isChild = super.modelPlayer.isChild;
//					mod.aimedBow = super.modelPlayer.aimedBow;
//					mod.heldItemRight = super.modelPlayer.heldItemRight;
//					mod.onGround = super.modelPlayer.onGround;
//					mod.render(e, par2, par3, par4, par5, par6, par7);
//					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("diverse:mouth.png"));
//					CustomMouth cm = pm;
//					cm.isSneak = super.modelPlayer.isSneak;
//					cm.isRiding = super.modelPlayer.isRiding;
//					cm.isChild = super.modelPlayer.isChild;
//					cm.aimedBow = super.modelPlayer.aimedBow;
//					cm.heldItemRight = super.modelPlayer.heldItemRight;
//					cm.onGround = super.modelPlayer.onGround;
//					cm.render(e, par2, par3, par4, par5, par6, par7);
//					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("diverse:map.png"));
					CustomBody pbb = pb;
					pbb.isSneak = super.modelPlayer.isSneak;
					pbb.isRiding = super.modelPlayer.isRiding;
					pbb.isChild = super.modelPlayer.isChild;
					pbb.aimedBow = super.modelPlayer.aimedBow;
					pbb.heldItemRight = super.modelPlayer.heldItemRight;
					pbb.onGround = super.modelPlayer.onGround;
					mod.render(e, par2, par3, par4, par5, par6, par7);
//					while(true) {
//						 if (load >= ep.extInv.getSizeInventory()) {
//							 break;
//						 }
//						 
//						 if (ep.extInv.getStackInSlot(load) != null) {
//							 ItemStack stack = ep.extInv.getStackInSlot(load);
//							 if (stack.getItem() instanceof IExtItemRender) {
//								 ((IExtItemRender)stack.getItem()).getModel(stack).render(super.modelPlayer, p, ep, stack, load, par2, par3, par4, par5, par6, par7);
//								 //((IExtItemRender)stack.getItem()).getModel(stack).render(e, 0F, 0F, 0F, 0F, 0F, 0.0625F);
//							 }
//							 if (stack.getItem() instanceof IExtItemUpdate) {
//								 ((IExtItemUpdate)stack.getItem()).onUpdateExt(stack, p);
//							 }
//						 }
//						 
//						 load++;
//					}
					GL11.glPopMatrix();
				}
			} catch (Exception var1) {
				var1.printStackTrace();
			}
		}
	}
}
