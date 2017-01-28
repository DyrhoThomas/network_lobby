package network.Lobby.Particles.Selector;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import network.Lobby.Main;

public class OpenGUI implements Listener {
	
	@EventHandler
	public void onBlazeClick(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getPlayer().getItemInHand().getType().equals(Material.BONE)) {
				e.getPlayer().sendMessage(Main.prefix + "§cComing soon!");
				e.setCancelled(true);
			}
		}
	}
}