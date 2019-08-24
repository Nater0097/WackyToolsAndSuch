package com.spikeyt.thermionic.wackytoolsandsuch.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier {
	soapswordmat(4.5f, 1.0f, 190, 0, 42, WackyToolsAndSuchItems.soap),
	soapaxemat(8.0f, 5.5f, 191, 0, 42, WackyToolsAndSuchItems.soap),
	soappicmat(2.5f, 6.0f, 191, 1, 42, WackyToolsAndSuchItems.soap),
	soaphoemat(1.5f, 1.0f, 191, 0, 42, WackyToolsAndSuchItems.soap),
	soapshovelmat(3.0f, 6.0f, 192, 0, 42, WackyToolsAndSuchItems.soap);
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {
		
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
		
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public float getEfficiency() {
		return this.efficiency;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getMaxUses() {
		return this.durability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(this.repairMaterial);
	}

}
