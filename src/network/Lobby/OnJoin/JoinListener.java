package network.Lobby.OnJoin;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		//joinmessage
		if(e.getPlayer().getCustomName() == null) {
			e.setJoinMessage("§7[§a+§7] " + e.getPlayer().getName() + "");
		} else {
			e.setJoinMessage("§7[§a+§7] " + e.getPlayer().getCustomName() + "");
		}
		
		Player p = e.getPlayer();
		
		//normale login stats
		p.setGameMode(GameMode.ADVENTURE);//gamemode
		p.setWalkSpeed(0.2f);//loop snelheid
		p.setFlySpeed(0.2f);//vlieg snelheid
		p.setHealth(20);//levens reset
		p.setFoodLevel(20);//eten reset
		
		//teleport
		teleportToLobby(p);
		
		//inventory
		p.getInventory().clear();
		giveItems(p);
		p.getInventory().setHeldItemSlot(4);
		
		//scoreboard
		network.Lobby.ScoreBoard.Run.Timer(p);
	}
	public static void teleportToLobby(Player p) {
		double x = -4.5;
		double y = 74.0;
		double z = 3.5;
		World world = Bukkit.getWorld("world");
		float yaw = 90;
		float pitch = 0;
		
		Location loc = new Location(world, x, y, z, yaw, pitch);
		
		p.teleport(loc);
	}
	
	public static void giveItems(Player p) {
		ItemStack item = new ItemStack(Material.COMPASS);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName("§3Server§bSelector");
		item.setItemMeta(itemMeta);
		p.getInventory().setItem(4, item);
		
		ItemStack item2 = new ItemStack(Material.BONE);
		ItemMeta itemMeta2 = item2.getItemMeta();
		itemMeta2.setDisplayName("§3Pet§bSelector");
		item2.setItemMeta(itemMeta2);
		p.getInventory().setItem(2, item2);
		
		ItemStack item3 = new ItemStack(Material.BLAZE_ROD);
		ItemMeta itemMeta3 = item3.getItemMeta();
		itemMeta3.setDisplayName("§3Particle§bSelector");
		item3.setItemMeta(itemMeta3);
		p.getInventory().setItem(6, item3);
	}
}
