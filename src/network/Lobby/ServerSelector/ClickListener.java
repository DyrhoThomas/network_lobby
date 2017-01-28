package network.Lobby.ServerSelector;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import network.Lobby.Main;

public class ClickListener implements Listener {
	

	public static int eStatus = OpenListener.eStatus;//0=no 1=inschrijven 2=tijd bekend  3=eventisbussy
	public static String eName = OpenListener.eName;
	public static String eTime = OpenListener.eTime;
	public static String eLink = OpenListener.eLink;
	
	public static void serverNotOpen(Player p) {
		p.sendMessage(Main.prefix + "§cThis server isn't open yet!");
	}
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		if(e.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase("§3Server§bSelector")) {
			//IS DE SS INV!
			
			if(!(e.getWhoClicked() instanceof Player)) {
				e.getWhoClicked().sendMessage(Main.geenSpelerMessage);
				return;
			} else {
				//is een speler
				
				Player p = (Player) e.getWhoClicked();
				
				if(e.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)) {
					e.setCancelled(true);
					p.closeInventory();
					network.Core.Main.sendToServer("factions", "Factions", p);
					return;
				} else if(e.getCurrentItem().getType().equals(Material.STONE_SWORD)) {
					e.setCancelled(true);
					p.closeInventory();
					network.Core.Main.sendToServer("kitpvp", "KitPVP", p);
					return;
				} else if(e.getCurrentItem().getType().equals(Material.DIAMOND)) {
					e.setCancelled(true);
					p.closeInventory();
					//network.Core.Main.sendToServer("dyrhotopia", "DyrhoTopia", p);
					serverNotOpen(p);
					return;
				} else if(e.getCurrentItem().getType().equals(Material.SKULL_ITEM)) {
					e.setCancelled(true);
					p.closeInventory();
					//network.Core.Main.sendToServer("craftingdead", "The Crafting Dead", p);
					serverNotOpen(p);
					return;
				} else if(e.getCurrentItem().getType().equals(Material.NETHER_STAR)) {
					if(eStatus == 0) {
						//GEEN EVENT
						p.sendMessage(Main.prefix + "§cThere is currently no event busy! Maybe later!");
						e.setCancelled(true);
						p.closeInventory();
						return;
					} else if (eStatus == 1) {
						//INSCHRIJVEN
						p.sendMessage(Main.prefix + "You can register at the following linkje:§3 " + eLink);
						e.setCancelled(true);
						p.closeInventory();
						return;
					} else if (eStatus == 2) {
						//EVENT TIJD BEKEND
						p.sendMessage(Main.prefix + "&cUnfortunately, the entries have closed but the event has not started yet!");
						e.setCancelled(true);
						p.closeInventory();
						return;
					} else if (eStatus == 3) {
						//EVENT IS BEGONNEN
						e.setCancelled(true);
						network.Core.Main.sendToServer("eventserver", "EventServer", p);
						return;
					}
				}
				else {
					e.setCancelled(true);
					return;
				}
			}
		}
	}
}
