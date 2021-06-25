package by.fxg.diverse.client.model.item;

import by.fxg.diverse.client.model.VModel;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class VModelGelatrium extends VModel {
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;

	public VModelGelatrium() {
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 2, 4, 2);
		Shape1.setRotationPoint(0F, 0F, 0F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 0);
		Shape2.addBox(0F, 0F, 0F, 2, 3, 2);
		Shape2.setRotationPoint(0F, 1F, 0F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0.2268928F, 0.2268928F, 0.0872665F);
		Shape3 = new ModelRenderer(this, 0, 0);
		Shape3.addBox(0F, 0F, 0F, 1, 5, 2);
		Shape3.setRotationPoint(0F, 0F, 0F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0.0872665F, -0.0523599F, -0.1570796F);
	}

	@Override
	public void render() {
		float f5 = 0.0625F;
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
	}
}
