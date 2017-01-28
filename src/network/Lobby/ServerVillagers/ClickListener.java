package network.Lobby.ServerVillagers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import network.Lobby.Main;

public class ClickListener implements Listener {
	
	@EventHandler
	public void onPlayerClick(PlayerInteractEntityEvent e) {
		Entity en = e.getRightClicked();
		
		if(en instanceof Villager) {
			Villager villager = (Villager) en;
			Player p = e.getPlayer();
			if(villager.getCustomName().equalsIgnoreCase("§b§lDyrhoTopia")) {
				e.setCancelled(true);
				//network.Core.Main.sendToServer("dyrhotopia", "DyrhoTopia", p);
				p.sendMessage(Main.prefix + "§cThis server isn't open yet!");
			} else if(villager.getCustomName().equalsIgnoreCase("§b§lKitPVP")) {
				e.setCancelled(true);
				network.Core.Main.sendToServer("kitpvp", "KitPVP", p);
			} else if(villager.getCustomName().equalsIgnoreCase("§b§lFactions")) {
				e.setCancelled(true);
				network.Core.Main.sendToServer("factions", "Factions", p);
			} else if(villager.getCustomName().equalsIgnoreCase("§b§lThe Crafting Dead")) {
				e.setCancelled(true);
				//network.Core.Main.sendToServer("craftingdead", "The Crafting Dead", p);
				p.sendMessage(Main.prefix + "§cThis server isn't open yet!");
			}
		}
	}
}
