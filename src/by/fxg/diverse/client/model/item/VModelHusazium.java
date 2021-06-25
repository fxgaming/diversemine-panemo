package by.fxg.diverse.client.model.item;

import by.fxg.diverse.client.model.VModel;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class VModelHusazium extends VModel {
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape1;

	public VModelHusazium() {
		textureWidth = 64;
		textureHeight = 32;

		Shape3 = new ModelRenderer(this, 0, 0);
		Shape3.addBox(0F, 0F, 0F, 1, 3, 3);
		Shape3.setRotationPoint(0F, 1.6F, -1.6F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0.7853982F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 0);
		Shape4.addBox(0F, 0F, 0F, 3, 3, 1);
		Shape4.setRotationPoint(0.5F, -0.5F, 0F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0.7853982F);
		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 3, 1, 3);
		Shape1.setRotationPoint(-1.6F, 1.1F, 0.5F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0.7853982F, 0F);
	}

	@Override
	public void render() {
		float f5 = 0.0625F;
		Shape3.render(f5);
		Shape4.render(f5);
		Shape1.render(f5);
	}
}
