package sheenrox82.RioV.src.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTasaravHelmet extends ModelBiped
{
	ModelRenderer Shape1;
	ModelRenderer Shape2;

	public ModelTasaravHelmet(float f)
	{
		super(f, 0, 64, 64);
		textureWidth = 64;
		textureHeight = 64;

		Shape1 = new ModelRenderer(this, 0, 43);
		Shape1.addBox(0F, 0F, 0F, 2, 1, 1);
		Shape1.setRotationPoint(-1F, -9F, 1F);
		Shape1.setTextureSize(64, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 48);
		Shape2.addBox(0F, 0F, 0F, 2, 5, 10);
		Shape2.setRotationPoint(-1F, -14F, 0F);
		Shape2.setTextureSize(64, 64);
		Shape2.mirror = true;
		setRotation(Shape2, -0.1919862F, 0F, 0F);
		
		this.bipedHead.addChild(Shape1);
		this.bipedHead.addChild(Shape2);
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
