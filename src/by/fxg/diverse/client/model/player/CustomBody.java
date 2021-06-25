package by.fxg.diverse.client.model.player;

import by.fxg.diverse.client.model.accessories.ModelAccessories;
import net.minecraft.client.model.ModelRenderer;

public class CustomBody extends ModelAccessories {
	ModelRenderer body1;

	public CustomBody() {
		textureWidth = 64;
		textureHeight = 32;
		body1 = new ModelRenderer(this, 0, 0);
		body1.addBox(0F, 0F, 0F, 8, 12, 0);
		body1.setRotationPoint(-4F, 0F, -2.005F);
		body1.setTextureSize(64, 32);
		body1.mirror = true;
		setRotation(body1, 0F, 0F, 0F);
		super.bipedBody.cubeList.clear();
		this.addChild(body1, Type.BODY);
	}
}
