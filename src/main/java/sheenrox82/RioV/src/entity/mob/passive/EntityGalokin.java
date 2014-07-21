package sheenrox82.RioV.src.entity.mob.passive;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.entity.EntityMobDeadBody;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.content.RioVItems;
import sheenrox82.RioV.src.content.Sounds;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityGalokin extends EntityMobDeadBody
{
	public static final ItemStack defaultHeldItem;

	public EntityGalokin(World par1World) {

		super(par1World);
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this,  0.56D));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(4, new EntityAIAttackOnCollide(this,  0.56D, true));
		this.setCurrentItemOrArmor(4, new ItemStack(RioVItems.galokinHelmet));
		this.setCurrentItemOrArmor(3, new ItemStack(RioVItems.galokinChestplate));
		this.setCurrentItemOrArmor(2, new ItemStack(RioVItems.galokinLeggings));
		this.setCurrentItemOrArmor(1, new ItemStack(RioVItems.galokinBoots));
		isImmuneToFire = false;
	}
	
	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	@Override
	protected boolean isValidLightLevel()
	{
		return true;
	}

	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.62D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(17.0D);
	}
	
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

	static
	{
		defaultHeldItem = new ItemStack(RioVItems.galokinSword);
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		int var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
		int var4;

		for (var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(RioVItems.galokinCrystal, 1);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected String getLivingSound()
	{
		if(RioVAPI.getInstance().getUtil().getConfigBool("allowBreathing") == true)
		{
			return Sounds.exhale.getPrefixedName();
		}
		
		return null;
	}
	
	@Override
	protected String getHurtSound()
	{
		return Sounds.pain.getPrefixedName();
	}
	
	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
    {
		par1EntityPlayer.playSound(Sounds.hello.getPrefixedName(), 1, 1);
		
		if(!this.worldObj.isRemote)
			par1EntityPlayer.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.WHITE, "Hello to you too, " + par1EntityPlayer.getDisplayName() + "!"));
		return true;
    }
}
