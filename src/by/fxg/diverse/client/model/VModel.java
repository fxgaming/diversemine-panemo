package by.fxg.diverse.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public abstract class VModel extends ModelBase {
	public float f5 = 0.0625F;
	public abstract void render();
	
	public void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
