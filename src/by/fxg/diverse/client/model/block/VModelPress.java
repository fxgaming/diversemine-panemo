package by.fxg.diverse.client.model.block;

import by.fxg.diverse.client.model.VModel;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class VModelPress extends VModel {
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape12;
	ModelRenderer Shape13;
	ModelRenderer Shape14;
	ModelRenderer Shape5;

	public VModelPress() {
		textureWidth = 64;
		textureHeight = 64;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 16, 1, 16);
		Shape1.setRotationPoint(-8F, 23F, -8F);
		Shape1.setTextureSize(64, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 17);
		Shape2.addBox(0F, 0F, 0F, 9, 8, 4);
		Shape2.setRotationPoint(-7F, 15F, -7F);
		Shape2.setTextureSize(64, 64);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 26, 17);
		Shape3.addBox(0F, 0F, 0F, 4, 12, 4);
		Shape3.setRotationPoint(3F, 11F, -7F);
		Shape3.setTextureSize(64, 64);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 0);
		Shape4.addBox(0F, 0F, 0F, 16, 1, 16);
		Shape4.setRotationPoint(-8F, 8F, -8F);
		Shape4.setTextureSize(64, 64);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 0, 0);
		Shape6.addBox(0F, 0F, 0F, 1, 14, 1);
		Shape6.setRotationPoint(7F, 9F, -8F);
		Shape6.setTextureSize(64, 64);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 0, 0);
		Shape7.addBox(0F, 0F, 0F, 1, 14, 1);
		Shape7.setRotationPoint(-8F, 9F, -8F);
		Shape7.setTextureSize(64, 64);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 0, 0);
		Shape8.addBox(0F, 0F, 0F, 1, 14, 1);
		Shape8.setRotationPoint(7F, 9F, 7F);
		Shape8.setTextureSize(64, 64);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 0, 0);
		Shape9.addBox(0F, 0F, 0F, 1, 14, 1);
		Shape9.setRotationPoint(-8F, 9F, 7F);
		Shape9.setTextureSize(64, 64);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape12 = new ModelRenderer(this, 0, 40);
		Shape12.addBox(0F, 0F, 0F, 4, 1, 4);
		Shape12.setRotationPoint(-2F, 22F, 1.5F);
		Shape12.setTextureSize(64, 64);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 0F);
		Shape13 = new ModelRenderer(this, 0, 33);
		Shape13.addBox(0F, 0F, 0F, 13, 1, 6);
		Shape13.setRotationPoint(-6.5F, 21F, 0.5F);
		Shape13.setTextureSize(64, 64);
		Shape13.mirror = true;
		setRotation(Shape13, 0F, 0F, 0F);
		Shape14 = new ModelRenderer(this, 0, 33);
		Shape14.addBox(0F, 0F, 0F, 13, 1, 6);
		Shape14.setRotationPoint(-6.5F, 11F, 0.5F);
		Shape14.setTextureSize(64, 64);
		Shape14.mirror = true;
		setRotation(Shape14, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 16, 40);
		Shape5.addBox(0F, 0F, 0F, 4, 2, 4);
		Shape5.setRotationPoint(-2F, 9F, 1.5F);
		Shape5.setTextureSize(64, 64);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
	}

	@Override
	public void render() {
		float f5 = 0.0625F;
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape12.render(f5);
		Shape13.render(f5);
		Shape14.render(f5);
		Shape5.render(f5);
	}
}
