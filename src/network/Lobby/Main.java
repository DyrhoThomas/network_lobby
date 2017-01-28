package network.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import network.Lobby.BroadCaster.TimedBroadCast;
import network.Lobby.ScoreBoard.Run;
import network.Lobby.ServerVillagers.SpawnVillagers;

public class Main extends JavaPlugin {
	
	public static String prefix;
	public static String geenPermMessage;
	public static String geenSpelerMessage;
	
	public static Main main;
	
	public void onEnable() {
		String tijd_prefix = "§3§l[§b§lDyrho§3§l] §b";
		broadcast(tijd_prefix + "Starting up lobby plugin...");
		
		broadcast(tijd_prefix + "Checking Core plugin...");
		Plugin corePlugin = Bukkit.getPluginManager().getPlugin("network_core");
		
		if(!corePlugin.isEnabled()) {
			broadcast(tijd_prefix + "§cCore plugin not found, disabling plugin...");
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		} else {
			broadcast(tijd_prefix + "Core plugin found, now continuing startup...");
		}
		
		main = this;
		
		//plugin opstarten
		
		prefix = network.Core.Main.prefix;
		geenPermMessage = network.Core.Main.geenPermMessage;
		geenSpelerMessage = network.Core.Main.geenSpelerMessage;
		
		//listeners
		broadcast(prefix + "Register events...");
		Bukkit.getPluginManager().registerEvents(new network.Lobby.OnJoin.JoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new network.Lobby.OnJoin.QuitListener(), this);
		Bukkit.getPluginManager().registerEvents(new network.Lobby.ServerVillagers.ClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new network.Lobby.ServerSelector.OpenListener(), this);
		Bukkit.getPluginManager().registerEvents(new network.Lobby.ServerSelector.ClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new network.Lobby.Chat.ChatFormat(), this);
		Bukkit.getPluginManager().registerEvents(new network.Lobby.GriefPrevention.Listeners(), this);
		Bukkit.getPluginManager().registerEvents(new network.Lobby.Pets.Selector.OpenGUI(), this);
		Bukkit.getPluginManager().registerEvents(new network.Lobby.Particles.Selector.OpenGUI(), this);
		
		//server villagers spawnen!
		broadcast(prefix + "Villagers spawnen...");
	    SpawnVillagers.spawnOnStartUp(new Location(getServer().getWorld("world"), 19.5, 73, 3.5, 90, 0), "§b§lKitPVP", true);
	    SpawnVillagers.spawnOnStartUp(new Location(getServer().getWorld("world"), -4.5, 73, -20.5, 0, 0), "§b§lDyrhoTopia", true);
	    SpawnVillagers.spawnOnStartUp(new Location(getServer().getWorld("world"), -28.5, 73, 3.5, -90, 0), "§b§lFactions", true);
	    SpawnVillagers.spawnOnStartUp(new Location(getServer().getWorld("world"), -4.5, 73, 27.5, -180, 0), "§b§lThe Crafting Dead", true);
		
	    //broadcaster opstarten
	    broadcast(prefix + "Starting upp lobby broadcaster...");
	    TimedBroadCast.startBroadcast();
	    
	    //scoreboard runnen voor onlineplayers
	    broadcast(prefix + "Starting up scoreboard...");
	    for(Player p:Bukkit.getOnlinePlayers()) {
	    	Run.Timer(p);
	    }
	    
		broadcast(prefix + "Lobby plugin has been started up!");
		
	}
	
	public void onDisable() {
		broadcast(prefix + "Shutting down lobby plugin...");
		
		//villagers verwijderen
		broadcast(prefix + "Removing villagers...");
		SpawnVillagers.killAllVillagers(Bukkit.getWorld("world"));
		
		broadcast(prefix + "Lobby plugin has been shutted down!");
		
	}
	
	public static void broadcast(String message) {
		Bukkit.broadcastMessage(message);
	}
}
