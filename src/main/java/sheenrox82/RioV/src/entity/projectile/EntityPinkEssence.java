package sheenrox82.RioV.src.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPinkEssence extends EntityThrowable
{
	public EntityPinkEssence(World var1)
	{
		super(var1);
	}

	public EntityPinkEssence(World var1, EntityLivingBase var2)
	{
		super(var1, var2);
	}

	public EntityPinkEssence(World var1, double var2, double var4, double var6)
	{
		super(var1, var2, var4, var6);
	}

	@Override
	protected void onImpact(MovingObjectPosition var1)
	{
		if(var1.entityHit instanceof EntityLivingBase)
		{
			var1.entityHit.addVelocity(0F, 1F, 0F);
		}
	}
}