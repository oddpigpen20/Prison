package me.oddpigpen20.prison.Economy;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import me.oddpigpen20.prison.Main;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

public class Economys implements Economy{

	private Main plugin = Main.getInstance();
	
	
	@Override
	public EconomyResponse bankBalance(String arg0) {
		return null;
	}

	@Override
	public EconomyResponse bankDeposit(String arg0, double arg1) {
		return null;
	}

	@Override
	public EconomyResponse bankHas(String arg0, double arg1) {
		return null;
	}

	@Override
	public EconomyResponse bankWithdraw(String arg0, double arg1) {
		return null;
	}

	@Override
	public EconomyResponse createBank(String arg0, String arg1) {
		return null;
	}

	@Override
	public EconomyResponse createBank(String arg0, OfflinePlayer arg1) {
		return null;
	}

	@Override
	public boolean createPlayerAccount(String arg0) {
		return false;
	}

	@Override
	public boolean createPlayerAccount(OfflinePlayer arg0) {
		return false;
	}

	@Override
	public boolean createPlayerAccount(String arg0, String arg1) {
		return false;
	}

	@Override
	public boolean createPlayerAccount(OfflinePlayer arg0, String arg1) {
		return false;
	}

	@Override
	public String currencyNamePlural() {
		return null;
	}

	@Override
	public String currencyNameSingular() {
		return null;
	}

	@Override
	public EconomyResponse deleteBank(String arg0) {
		return null;
	}

	@Override
	public EconomyResponse depositPlayer(String arg0, double arg1) {
		Player player = Bukkit.getPlayer(arg0);
		UUID uuid = player.getUniqueId();
		
		double oldBalance = plugin.playerBank.get(uuid);
		plugin.playerBank.put(uuid, oldBalance + arg1);
		
		return null;
	}

	@Override
	public EconomyResponse depositPlayer(OfflinePlayer arg0, double arg1) {
		UUID uuid = arg0.getUniqueId();
		
		double oldBalance = plugin.playerBank.get(uuid);
		plugin.playerBank.put(uuid, oldBalance + arg1);
		
		return null;

	}

	@Override
	public EconomyResponse depositPlayer(String arg0, String arg1, double arg2) {
		Player player = Bukkit.getPlayer(arg0);
		UUID uuid = player.getUniqueId();
		
		double oldBalance = plugin.playerBank.get(uuid);
		plugin.playerBank.put(uuid, oldBalance );
		
		return null;

	}

	@Override
	public EconomyResponse depositPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		UUID uuid = arg0.getUniqueId();
		
		double oldBalance = plugin.playerBank.get(uuid);
		plugin.playerBank.put(uuid, oldBalance + arg2);
		
		return null;
	}

	@Override
	public String format(double arg0) {
		return null;
	}

	@Override
	public int fractionalDigits() {
		return 0;
	}

	@Override
	public double getBalance(String s) {
		Player player = Bukkit.getPlayer(s);
		UUID uuid = player.getUniqueId();
		
		return plugin.playerBank.get(uuid);
	}

	@Override
	public double getBalance(OfflinePlayer arg0) {
		UUID uuid = arg0.getUniqueId();
		
		return plugin.playerBank.get(uuid);
	}

	@Override
	public double getBalance(String s, String arg1) {
		Player player = Bukkit.getPlayer(s);
		UUID uuid = player.getUniqueId();
		
		return plugin.playerBank.get(uuid);
	}

	@Override
	public double getBalance(OfflinePlayer arg0, String arg1) {
		UUID uuid = arg0.getUniqueId();
		
		return plugin.playerBank.get(uuid);
	}

	@Override
	public List<String> getBanks() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public boolean has(String arg0, double arg1) {
		return false;
	}

	@Override
	public boolean has(OfflinePlayer arg0, double arg1) {
		return false;
	}

	@Override
	public boolean has(String arg0, String arg1, double arg2) {
		return false;
	}

	@Override
	public boolean has(OfflinePlayer arg0, String arg1, double arg2) {
		return false;
	}

	@Override
	public boolean hasAccount(String arg0) {
		return false;
	}

	@Override
	public boolean hasAccount(OfflinePlayer arg0) {
		return false;
	}

	@Override
	public boolean hasAccount(String arg0, String arg1) {
		return false;
	}

	@Override
	public boolean hasAccount(OfflinePlayer arg0, String arg1) {
		return false;
	}

	@Override
	public boolean hasBankSupport() {
		return false;
	}

	@Override
	public EconomyResponse isBankMember(String arg0, String arg1) {
		return null;
	}

	@Override
	public EconomyResponse isBankMember(String arg0, OfflinePlayer arg1) {
		return null;
	}

	@Override
	public EconomyResponse isBankOwner(String arg0, String arg1) {
		return null;
	}

	@Override
	public EconomyResponse isBankOwner(String arg0, OfflinePlayer arg1) {
		return null;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public EconomyResponse withdrawPlayer(String arg0, double arg1) {
		return null;
	}

	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer arg0, double arg1) {
		return null;
	}

	@Override
	public EconomyResponse withdrawPlayer(String arg0, String arg1, double arg2) {
		return null;
	}

	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		return null;
	}

}
