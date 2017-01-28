package network.Lobby.GriefPrevention;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import network.Lobby.Main;

public class Listeners implements Listener {
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		List<Material> preventedBuilding = new ArrayList<Material>();
		preventedBuilding.add(Material.TNT);
		preventedBuilding.add(Material.EXPLOSIVE_MINECART);
		preventedBuilding.add(Material.LAVA);
		preventedBuilding.add(Material.LAVA_BUCKET);
		preventedBuilding.add(Material.STATIONARY_LAVA);
		preventedBuilding.add(Material.WATER);
		preventedBuilding.add(Material.WATER_BUCKET);
		preventedBuilding.add(Material.STATIONARY_WATER);
		if(!e.getPlayer().hasPermission("dyrho.builder")) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(Main.prefix + "§cYou can't break " + e.getBlock().getType().name() + " here!");
		} else {
			if(!e.getPlayer().hasPermission("dyrho.eigenaar")) {
				if(preventedBuilding.contains(e.getBlock().getType())) {
					e.getPlayer().sendMessage(Main.prefix + "§cYou can't break " + e.getBlock().getType().name() + " here!");
					e.setCancelled(true);
				}
			}
		}
	}
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		List<Material> preventedBuilding = new ArrayList<Material>();
		preventedBuilding.add(Material.TNT);
		preventedBuilding.add(Material.EXPLOSIVE_MINECART);
		preventedBuilding.add(Material.LAVA);
		preventedBuilding.add(Material.LAVA_BUCKET);
		preventedBuilding.add(Material.STATIONARY_LAVA);
		preventedBuilding.add(Material.WATER);
		preventedBuilding.add(Material.WATER_BUCKET);
		preventedBuilding.add(Material.STATIONARY_WATER);
		if(!e.getPlayer().hasPermission("dyrho.builder")) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(Main.prefix + "§cYou can't place " + e.getBlockPlaced().getType().name() + " here!");
		} else {
			//has builder
			if(!e.getPlayer().hasPermission("dyrho.eigenaar")) {
				if(preventedBuilding.contains(e.getBlockPlaced().getType())) {
					e.getPlayer().sendMessage(Main.prefix + "§cYou can't place " + e.getBlockPlaced().getType().name() + " here!");
					e.setCancelled(true);
				}
			}
		}
	}
	
	
	@EventHandler
	public void foodChangeEvent(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		e.setCancelled(true);
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if(e.getWhoClicked().hasPermission("dyrho.builder") && e.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) {
		} else {
			e.setCancelled(true);
		}
	}
}