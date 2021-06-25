package by.fxg.diverse.client.model.accessories.fist;

import org.lwjgl.opengl.GL11;

import api.player.model.ModelPlayer;
import by.fxg.diverse.client.model.accessories.ModelAccessories;
import by.fxg.diverse.common.player.ExtendedPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class VFist0 extends ModelAccessories {
	ModelRenderer Shape1;
	ModelRenderer Shape2;
    
    public VFist0() {
        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(0F, 0F, 0F, 4, 1, 1);
        Shape1.setRotationPoint(-8.2F, 11.2F, -1F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 0, 0);
        Shape2.addBox(0F, 0F, 0F, 1, 1, 1);
        Shape2.setRotationPoint(-4.8F, 11.2F, -1F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        addChild(Shape1, Type.R_ARM);
        addChild(Shape2, Type.R_ARM);
    }
}
