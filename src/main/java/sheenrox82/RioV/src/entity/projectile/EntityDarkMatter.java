package sheenrox82.RioV.src.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityDarkMatter extends EntityThrowable
{
	double bounceFactor;
	int fuse;
	boolean exploded;
	boolean collided;
	boolean stopped;

	public EntityDarkMatter(World var1)
	{
		super(var1);
	}

	public EntityDarkMatter(World var1, EntityLivingBase var2)
	{
		super(var1, var2);
	}

	public EntityDarkMatter(World var1, double var2, double var4, double var6)
	{
		super(var1, var2, var4, var6);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
	}

	@Override
	protected void onImpact(MovingObjectPosition var1)
	{
		if (this.fuse-- <= 0)
        {
            this.setDead();

            if (!this.worldObj.isRemote)
            {
                this.explode();
            }
        }
        else
        {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
        }
	}

	protected void explode()
	{
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3.0F, true);
	}

	public void writeEntityToNBT(NBTTagCompound var1)
	{
		super.writeEntityToNBT(var1);
		var1.setByte("Fuse", (byte)this.fuse);
	}

	public void readEntityFromNBT(NBTTagCompound var1)
	{
		super.readEntityFromNBT(var1);
		this.fuse = var1.getByte("Fuse");
	}
}