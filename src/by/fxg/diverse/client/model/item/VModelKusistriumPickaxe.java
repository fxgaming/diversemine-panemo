package by.fxg.diverse.client.model.item;

import by.fxg.diverse.client.model.VModel;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class VModelKusistriumPickaxe extends VModel {
	ModelRenderer Shape1;
	ModelRenderer Shape7;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;
	ModelRenderer Shape12;

	public VModelKusistriumPickaxe() {
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 8, 0);
		Shape1.addBox(0F, -1F, 0F, 2, 18, 2);
		Shape1.setRotationPoint(-1F, 5F, -1F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 0, 0);
		Shape7.addBox(0F, 0F, 0F, 2, 2, 2);
		Shape7.setRotationPoint(-1F, 21.7F, -1F);
		Shape7.setTextureSize(64, 32);
		Shape7.mirror = true;
		setRotation(Shape7, -0.122173F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 4);
		Shape2.addBox(0F, -4F, 0F, 2, 4, 2);
		Shape2.setRotationPoint(-1F, 4F, -1F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, -0.5585054F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 10);
		Shape3.addBox(0F, 0F, 0F, 2, 2, 2);
		Shape3.setRotationPoint(-1F, -0.3F, 0.8F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 20);
		Shape4.addBox(0F, 0F, 0F, 2, 2, 8);
		Shape4.setRotationPoint(-1F, -2F, -4F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 12, 21);
		Shape5.addBox(0F, 0F, -6F, 2, 1, 6);
		Shape5.setRotationPoint(-1F, -1F, -3.8F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		setRotation(Shape5, -0.0479966F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 16, 14);
		Shape6.addBox(0F, -1F, -6F, 2, 1, 6);
		Shape6.setRotationPoint(-1F, -1F, -3.8F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0.0493056F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 16, 18);
		Shape8.addBox(0F, 0F, -1F, 2, 1, 1);
		Shape8.setRotationPoint(-1F, -1F, -9.1F);
		Shape8.setTextureSize(64, 32);
		Shape8.mirror = true;
		setRotation(Shape8, -0.7853982F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 16, 10);
		Shape9.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape9.setRotationPoint(-0.1F, -1.9F, 3.5F);
		Shape9.setTextureSize(64, 32);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 0, 14);
		Shape10.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape10.setRotationPoint(-0.9F, -1.9F, 3.5F);
		Shape10.setTextureSize(64, 32);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 0, 22);
		Shape11.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape11.setRotationPoint(-0.1F, -1.1F, 3.5F);
		Shape11.setTextureSize(64, 32);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F);
		Shape12 = new ModelRenderer(this, 0, 18);
		Shape12.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape12.setRotationPoint(-0.9F, -1.1F, 3.5F);
		Shape12.setTextureSize(64, 32);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 0F);
	}

	@Override
	public void render() {
		float f5 = 0.0625F;
		Shape1.render(f5);
		Shape7.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
	}
}
