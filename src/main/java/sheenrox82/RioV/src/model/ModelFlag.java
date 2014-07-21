package sheenrox82.RioV.src.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFlag extends ModelBase
{
  //fields
    ModelRenderer pole;
    ModelRenderer flaghanger;
    ModelRenderer base1;
    ModelRenderer base2;
    ModelRenderer flag;
  
  public ModelFlag()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      pole = new ModelRenderer(this, 0, 0);
      pole.addBox(0F, 0F, 0F, 1, 27, 1);
      pole.setRotationPoint(0F, -3F, 0F);
      pole.setTextureSize(64, 64);
      pole.mirror = true;
      setRotation(pole, 0F, 0F, 0F);
      flaghanger = new ModelRenderer(this, 5, 3);
      flaghanger.addBox(0F, 0F, 0F, 9, 1, 1);
      flaghanger.setRotationPoint(-4F, -3F, -1F);
      flaghanger.setTextureSize(64, 64);
      flaghanger.mirror = true;
      setRotation(flaghanger, 0F, 0F, 0F);
      base1 = new ModelRenderer(this, 5, 0);
      base1.addBox(0F, 0F, 0F, 11, 1, 1);
      base1.setRotationPoint(-4F, 23F, 4F);
      base1.setTextureSize(64, 64);
      base1.mirror = true;
      setRotation(base1, 0F, 0.7330383F, 0F);
      base2 = new ModelRenderer(this, 5, 0);
      base2.addBox(0F, 0F, 0F, 11, 1, 1);
      base2.setRotationPoint(-3F, 23F, -4F);
      base2.setTextureSize(64, 64);
      base2.mirror = true;
      setRotation(base2, 0F, -0.8203047F, 0F);
      flag = new ModelRenderer(this, 5, 6);
      flag.addBox(0F, 0F, 0F, 11, 19, 0);
      flag.setRotationPoint(-5F, -3F, -1F);
      flag.setTextureSize(64, 64);
      flag.mirror = true;
      setRotation(flag, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void renderAll()
  {
      this.pole.render(0.0625F);
      this.flaghanger.render(0.0625F);
      this.base1.render(0.0625F);
      this.base2.render(0.0625F);
      this.flag.render(0.0625F);
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
