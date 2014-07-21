package sheenrox82.RioV.src.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTasaravChestplate extends ModelBiped
{
	ModelRenderer Shape1;

	public ModelTasaravChestplate(float f)
	{
		super(f, 0, 64, 64);
		textureWidth = 64;
		textureHeight = 64;

		Shape1 = new ModelRenderer(this, 0, 37);
		Shape1.addBox(0F, 0F, 0F, 10, 20, 1);
		Shape1.setRotationPoint(-5F, 0F, 2F);
		Shape1.setTextureSize(64, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0.3F, 0F, 0F);

		this.bipedBody.addChild(Shape1);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, null);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
