package network.Lobby.Chat;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormat implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		String message = e.getMessage();
		e.setCancelled(true);
		if(e.getPlayer().hasPermission("lobby.legendary")) {
			message = message.replaceAll("&", "§");
		}
		
		String prefix = PlayerPrefix.getRankPrefix(e.getPlayer());
		if(e.getPlayer().hasPermission("dyrho.elite")) {
			if(e.getPlayer().hasPermission("dyrho.master")) {
				if(e.getPlayer().hasPermission("dyrho.legendary")) {
					if(e.getPlayer().hasPermission("dyrho.youtuber")) {
						if(e.getPlayer().hasPermission("dyrho.builder")) {
							if(e.getPlayer().hasPermission("dyrho.moderator")) {
								if(e.getPlayer().hasPermission("dyrho.admin")) {
									if(e.getPlayer().hasPermission("dyrho.developer")) {
										if(e.getPlayer().hasPermission("dyrho.eigenaar")) {
											Bukkit.broadcastMessage(prefix + e.getPlayer().getCustomName() + "§l: §3" + message);
											return;
										}
										Bukkit.broadcastMessage(prefix + e.getPlayer().getCustomName() + ": §b" + message);
										return;
									}
									Bukkit.broadcastMessage(prefix + e.getPlayer().getCustomName() + ": §b" + message);
									return;
								}
								Bukkit.broadcastMessage(prefix + e.getPlayer().getCustomName() + ": §b" + message);
								return;
							}
							Bukkit.broadcastMessage(prefix + e.getPlayer().getCustomName() + ": §r" + message);
							return;
						}
						Bukkit.broadcastMessage(prefix + e.getPlayer().getCustomName() + ": §c" + message);
						return;
					}
					Bukkit.broadcastMessage(prefix + e.getPlayer().getCustomName() + ": §r" + message);
					return;
				}
				Bukkit.broadcastMessage(prefix + e.getPlayer().getCustomName() + ": §r" + message);
				return;
			}
			Bukkit.broadcastMessage(prefix + e.getPlayer().getCustomName() + ": §r" + message);
			return;
		}
		Bukkit.broadcastMessage(prefix + e.getPlayer().getCustomName() + ": §7" + message);
		return;
		
	}
}
