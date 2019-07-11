package me.oddpigpen20.prison.special;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;


public class Enchants extends Enchantment {

	public Enchants(int id) {
		super(id);
	}
	
	public int getID() {
		return 169;
	}

	@Override
	public boolean canEnchantItem(ItemStack arg0) {
		return false;
	}

	@Override
	public boolean conflictsWith(Enchantment arg0) {
		return false;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return null;
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public String getName() {
		return "Smelter";
	}

	@Override
	public int getStartLevel() {
		return 1;
	}
	
}
