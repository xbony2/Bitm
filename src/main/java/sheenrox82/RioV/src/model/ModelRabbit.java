package sheenrox82.RioV.src.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRabbit extends ModelBase
{
	//fields
	ModelRenderer body;
	ModelRenderer paw1;
	ModelRenderer paw3;
	ModelRenderer paw2;
	ModelRenderer paw4;
	ModelRenderer tail;
	ModelRenderer head;

	public ModelRabbit()
	{
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this, 0, 7);
		body.addBox(0F, 0F, 0F, 6, 4, 8);
		body.setRotationPoint(-3F, 19F, -3F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		paw1 = new ModelRenderer(this, 0, 0);
		paw1.addBox(0F, 0F, 0F, 3, 3, 3);
		paw1.setRotationPoint(1F, 21F, -4F);
		paw1.setTextureSize(64, 32);
		paw1.mirror = true;
		setRotation(paw1, 0F, 0F, 0F);
		paw3 = new ModelRenderer(this, 0, 0);
		paw3.addBox(0F, 0F, 0F, 3, 3, 3);
		paw3.setRotationPoint(-4F, 21F, 2F);
		paw3.setTextureSize(64, 32);
		paw3.mirror = true;
		setRotation(paw3, 0F, 0F, 0F);
		paw2 = new ModelRenderer(this, 0, 0);
		paw2.addBox(0F, 0F, 0F, 3, 3, 3);
		paw2.setRotationPoint(-4F, 21F, -4F);
		paw2.setTextureSize(64, 32);
		paw2.mirror = true;
		setRotation(paw2, 0F, 0F, 0F);
		paw4 = new ModelRenderer(this, 0, 0);
		paw4.addBox(0F, 0F, 0F, 3, 3, 3);
		paw4.setRotationPoint(1F, 21F, 2F);
		paw4.setTextureSize(64, 32);
		paw4.mirror = true;
		setRotation(paw4, 0F, 0F, 0F);
		tail = new ModelRenderer(this, 0, 28);
		tail.addBox(0F, 0F, 0F, 2, 2, 1);
		tail.setRotationPoint(-1F, 20F, 5F);
		tail.setTextureSize(64, 32);
		tail.mirror = true;
		setRotation(tail, 0F, 0F, 0F);
		head = new ModelRenderer(this, 0, 20);
		head.addBox(0F, 0F, 0F, 4, 3, 4);
		head.setRotationPoint(-2F, 18F, -5F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		body.render(f5);
		paw1.render(f5);
		paw3.render(f5);
		paw2.render(f5);
		paw4.render(f5);
		tail.render(f5);
		head.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
	{
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
		paw1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.0F * par2;
		paw2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.0F * par2;
		paw3.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.0F * par2;
		paw4.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.0F * par2;
	}

}
