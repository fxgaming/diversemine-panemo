package by.fxg.diverse.client.model.player;

import by.fxg.diverse.client.model.accessories.ModelAccessories;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CustomPart extends ModelAccessories {
	ModelRenderer Shape1;

	public CustomPart() {
		textureWidth = 16;
		textureHeight = 8;
		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 8, 8, 0);
		Shape1.setRotationPoint(-4F, -8F, -4.5F);
		Shape1.setTextureSize(16, 8);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		this.bipedHead.cubeList.clear();
		this.bipedBody.cubeList.clear();
		this.bipedLeftArm.cubeList.clear();
		this.bipedRightArm.cubeList.clear();
		this.bipedLeftLeg.cubeList.clear();
		this.bipedRightLeg.cubeList.clear();
		this.addChild(Shape1, Type.HEAD);
	}

}
