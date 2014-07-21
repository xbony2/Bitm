package sheenrox82.RioV.src.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSeaHorse extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
  
  public ModelSeaHorse()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(0F, 0F, 0F, 2, 3, 6);
      head.setRotationPoint(-1F, 7F, -3F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0.3665191F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 16, 0);
      Shape1.addBox(0F, 0F, 0F, 2, 3, 4);
      Shape1.setRotationPoint(-1F, 5F, 3F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, -1.064651F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 9);
      Shape2.addBox(0F, 0F, 0F, 2, 3, 3);
      Shape2.setRotationPoint(-1F, 8F, 2F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, -0.2617994F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 15);
      Shape3.addBox(0F, 0F, 0F, 2, 4, 3);
      Shape3.setRotationPoint(-1F, 11F, 1F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0.1745329F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 27);
      Shape4.addBox(0F, 0F, 0F, 2, 2, 3);
      Shape4.setRotationPoint(-1F, 15F, 2F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0.3141593F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 22);
      Shape5.addBox(0F, 0F, 0F, 2, 3, 2);
      Shape5.setRotationPoint(-1F, 16F, 3F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, -0.2094395F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 27);
      Shape6.addBox(0F, 0F, 0F, 2, 2, 3);
      Shape6.setRotationPoint(-1F, 20F, 1F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0.5759587F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 27);
      Shape7.addBox(0F, 0F, 0F, 2, 2, 3);
      Shape7.setRotationPoint(-1F, 19F, 0F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, -0.4363323F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
