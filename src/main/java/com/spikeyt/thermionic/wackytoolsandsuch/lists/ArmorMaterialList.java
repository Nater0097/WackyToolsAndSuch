package com.spikeyt.thermionic.wackytoolsandsuch.lists;

import com.spikeyt.thermionic.wackytoolsandsuch.WackyToolsAndSuch;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterialList implements IArmorMaterial {
	SoapMat("soap", 400, new int[] {2, 5, 4, 1}, 42, WackyToolsAndSuchItems.soap, "item.armor.equip_iron", 0.0f);
	
	private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
	private String name, equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness) {
		
		this.name = name;
		this.equipSound = equipSound;
		this.durability = durability;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
		
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) {
		// TODO Auto-generated method stub
		return this.damageReductionAmounts[slot.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slot) {
		// TODO Auto-generated method stub
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability() {
		// TODO Auto-generated method stub
		return this.enchantability;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return WackyToolsAndSuch.MODID + ":" + this.name;
	}

	@Override
	public Ingredient getRepairMaterial() {
		// TODO Auto-generated method stub
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public SoundEvent getSoundEvent() {
		// TODO Auto-generated method stub
		return new SoundEvent(new ResourceLocation(equipSound));
	}

	@Override
	public float getToughness() {
		// TODO Auto-generated method stub
		return this.toughness;
	}

}
