package by.fxg.diverse.client.model.player;

import by.fxg.diverse.client.model.VModelArmor;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CustomMouth extends VModelArmor {
	ModelRenderer head2;

	public CustomMouth() {
		textureWidth = 16;
		textureHeight = 8;
		head2 = new ModelRenderer(this, 0, 0);
		head2.addBox(0F, 0F, 0F, 8, 8, 0);
		head2.setRotationPoint(-4F, -8F, -4.01F);
		head2.setTextureSize(16, 8);
		head2.mirror = true;
		setRotation(head2, 0F, 0F, 0F);
		this.bipedHead.cubeList.clear();
		this.bipedBody.cubeList.clear();
		this.bipedLeftArm.cubeList.clear();
		this.bipedRightArm.cubeList.clear();
		this.bipedLeftLeg.cubeList.clear();
		this.bipedRightLeg.cubeList.clear();
		this.addChild(head2, Type.HEAD);
	}
}
