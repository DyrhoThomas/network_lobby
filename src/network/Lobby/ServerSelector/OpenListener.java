package network.Lobby.ServerSelector;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OpenListener implements Listener{
	
	@EventHandler
	public void playerOpenSS(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) ||
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getItem().getType().equals(Material.COMPASS)) {
				inventoryOpener(e.getPlayer());
			}
		}
	}
	
	public static int eStatus = 0;//0=no 1=inschrijven 2=tijd bekend  3=eventisbussy
	public static String eName = "UHC";
	public static String eTime = "01-01-2017 19:00";
	public static String eLink = "http://www.linkjevan.nl/inschrijving.html";
	
	public static void inventoryOpener(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, "§3Server§bSelector");		
		ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
		glass.setDurability((short) 3);
		
		ItemStack zomb = new ItemStack(Material.SKULL_ITEM);
		ItemMeta zombMeta = zomb.getItemMeta();
		zomb.setDurability((short) SkullType.ZOMBIE.ordinal());;
		List<String> zombLore = new ArrayList<String>();
		zombLore.add("§bFight against the zombies!");
		zombLore.add("§bJoin a group!");
		zombLore.add("§bWho knows you the most powerful!");
		zombMeta.setLore(zombLore);
		zombMeta.setDisplayName("§3§lThe Crafting Dead - Join now quickly!");
		zomb.setItemMeta(zombMeta);
		
		ItemStack fac = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta facmeta = fac.getItemMeta();
		List<String> facLore = new ArrayList<String>();
		facLore.add("§bYou like playing factions?");
		facLore.add("§bCompete with your friends in a group?");
		facLore.add("§bOr would you stay on your own?");
		facmeta.setLore(facLore);
		facmeta.setDisplayName("§3§lFactions - Join now quickly!");
		fac.setItemMeta(facmeta);

		ItemStack sb = new ItemStack(Material.DIAMOND);
		ItemMeta sbmeta = sb.getItemMeta();
		sbmeta.setDisplayName("§3§lDyrhoTopia - Join now quickly!");
		List<String> sbLore = new ArrayList<String>();
		sbLore.add("§bDo you like real-life?");
		sbLore.add("§bExperience it now in MineCraft?");
		sbLore.add("§bAnd play DyrhoTopia");
		sbmeta.setLore(sbLore);
		sb.setItemMeta(sbmeta);

		ItemStack kingdom = new ItemStack(Material.STONE_SWORD);
		ItemMeta kingdommeta = kingdom.getItemMeta();
		kingdommeta.setDisplayName("§3§lKitPVP - Join now quickly!");
		List<String> kdLore = new ArrayList<String>();
		kdLore.add("§bDefeat everyone!");
		kdLore.add("§bCollect powerfull kits!");
		kdLore.add("§bFighting like crazy!");
		kingdommeta.setLore(kdLore);
		kingdom.setItemMeta(kingdommeta);

		ItemStack event = new ItemStack(Material.NETHER_STAR);
		ItemMeta eventMeta = event.getItemMeta();
		eventMeta.setDisplayName("§3§lEvent - Join now quickly!");
		List<String> eventLore = new ArrayList<String>();
		eventLore.add("§bJoin an event!");
		eventLore.add("§bWin epic prices!");
		eventLore.add("§bCurrent event:");
		
		if(eStatus == 0) {
			eventLore.add("§c  - No event!");
		} else if(eStatus == 1) {
			eventLore.add("§e  - Register for " + eName + "!");
		} else if(eStatus == 2) {
			eventLore.add("§a  - " + eName + " start: " + eTime + "!");
		} else if(eStatus == 3) {
			eventLore.add("§2  - " + eName + " event!");
		}
		eventMeta.setLore(eventLore);
		event.setItemMeta(eventMeta);
		
		inv.setItem(0, glass);
		inv.setItem(1, glass);
		inv.setItem(2, glass);
		inv.setItem(3, glass);
		inv.setItem(4, glass);
		inv.setItem(5, glass);
		inv.setItem(6, glass);
		inv.setItem(7, glass);
		inv.setItem(8, glass);
		inv.setItem(9, glass);
		inv.setItem(17, glass);
		inv.setItem(18, glass);
		inv.setItem(20, kingdom);
		inv.setItem(22, event);
		inv.setItem(30, zomb);
		inv.setItem(24, sb);
		inv.setItem(26, glass);
		inv.setItem(27, glass);
		inv.setItem(32, fac);
		inv.setItem(35, glass);
		inv.setItem(36, glass);
		inv.setItem(44, glass);
		inv.setItem(45, glass);
		inv.setItem(46, glass);
		inv.setItem(47, glass);
		inv.setItem(48, glass);
		inv.setItem(49, glass);
		inv.setItem(50, glass);
		inv.setItem(51, glass);
		inv.setItem(52, glass);
		inv.setItem(53, glass);

		p.closeInventory();
		p.openInventory(inv);

	}
}
