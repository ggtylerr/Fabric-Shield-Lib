package me.crimsondawn45.fabricshieldlib.util.event;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public abstract class ShieldEvent
{
	private ShieldEventType type = ShieldEventType.UNSET;

    private boolean usesOnBlockDamage;
    private boolean usesOnDisable;
	private boolean usesWhileHolding;
	
	public ShieldEvent(boolean usesOnBlockDamage, boolean usesOnDisable, boolean usesWhileHolding)
    {
        this.usesOnBlockDamage = usesOnBlockDamage;
        this.usesOnDisable = usesOnDisable;
        this.usesWhileHolding = usesWhileHolding;
	}

    /**
	 * onBlockDamage
	 * 
	 * runs when the shield successfully blocks damage from an attacker.
	 * 
	 * @param defender - Entity that is holding thie shield.
	 * @param source - Source of the damage blocked.
	 * @param amount - Amount of damage blocked.
	 * @param level - Level of enchantment(will be 0 if it is not an enchantment)
	 * @param hand - Hand holding the shield
	 * @param shield - The ItemStack containing the shield
	 */
	public void onBlockDamage(LivingEntity defender, DamageSource source, float amount, int level, Hand hand, ItemStack shield){}

	/**
	 * onDisable
	 * 
	 * runs when the shield is disabled with an axe.
	 * 
	 * @param defender - Entity that is holding thie shield.
	 * @param level - Level of enchantment(will be 0 if it is not an enchantment)
	 * @param hand - Hand holding the shield
	 * @param shield - The ItemStack containing the shield
	 */
	public void onDisable(PlayerEntity defender, int level, Hand hand, ItemStack shield){}
	
	/**
	 * whileHolding
	 * 
	 * runs every tick the shield is held.
	 * 
	 * @param defender - Entity that is holding thie shield.
	 * @param level - Level of enchantment(will be 0 if it is not an enchantment)
	 * @param hand - Hand holding the shield
	 * @param shield - The ItemStack containing the shield
	 */
	public void whileHolding(LivingEntity defender, int level, Hand hand, ItemStack shield){}

    public boolean usesOnBlockDamage()
    {
        return this.usesOnBlockDamage;
	}
	
	public boolean usesOnDisable()
	{
		return this.usesOnDisable;
	}

    public boolean usesWhileHolding()
    {
        return this.usesWhileHolding;
	}
	
	public void setType(ShieldEventType type)
	{
		this.type = type;
	}

	public ShieldEventType getType()
	{
		return this.type;
	}
}