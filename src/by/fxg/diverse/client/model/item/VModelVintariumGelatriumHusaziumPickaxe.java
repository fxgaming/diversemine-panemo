package by.fxg.diverse.client.model.item;

import by.fxg.diverse.client.model.VModel;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class VModelVintariumGelatriumHusaziumPickaxe extends VModel {
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;

	public VModelVintariumGelatriumHusaziumPickaxe() {
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 12, 0);
		Shape1.addBox(0F, -1F, 0F, 2, 24, 2);
		Shape1.setRotationPoint(-1F, 1F, -1F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 24);
		Shape2.addBox(0F, 0F, -7F, 2, 1, 7);
		Shape2.setRotationPoint(-1F, 0.5F, -2F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0.0698132F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 24);
		Shape3.addBox(0F, 0F, 0F, 3, 2, 6);
		Shape3.setRotationPoint(-1.5F, 0.5F, -3F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 24);
		Shape4.addBox(0F, 0F, 0F, 2, 1, 7);
		Shape4.setRotationPoint(-1F, 0.5F, 2F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, -0.0698132F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 0, 0);
		Shape5.addBox(0F, -1F, 0F, 2, 1, 1);
		Shape5.setRotationPoint(-1F, 2.4F, -8.9F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		setRotation(Shape5, 0.7853982F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 0, 0);
		Shape6.addBox(0F, -1F, 0F, 2, 1, 1);
		Shape6.setRotationPoint(-1F, 2.4F, 8.9F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0.7853982F, 0F, 0F);
	}

	@Override
	public void render() {
		float f5 = 0.0625F;
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
	}
}
