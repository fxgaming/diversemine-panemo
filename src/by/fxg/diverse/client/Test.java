package by.fxg.diverse.client;

import by.fxg.diverse.client.model.accessories.ModelAccessories;
import net.minecraft.client.model.ModelRenderer;

public class Test extends ModelAccessories {
	ModelRenderer Shape1;
	ModelRenderer Shape2;

	public Test() {
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 8, 8, 0);
		Shape1.setRotationPoint(-4F, -8F, -4.005F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 8);
		Shape2.addBox(0F, 0F, 0F, 8, 8, 0);
		Shape2.setRotationPoint(-4F, -8F, -4.01F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		super.bipedHead.cubeList.clear();
		this.addChild(Shape1, Type.HEAD);
		this.addChild(Shape2, Type.HEAD);
	}
	
	public void render(int par1) {
		if (par1 == 0) {
			Shape1.render(0.0625F);
		} else if (par1 == 1) {
			Shape2.render(0.0625F);
		}
	}
}
