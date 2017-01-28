package network.Lobby.BroadCaster;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import network.Lobby.Main;

public class TimedBroadCast {
	
	public static void startBroadcast() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.main, new Runnable() {
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					p.sendMessage(Main.prefix + getMessage());
				}
			}
		}, 2*60*20, 2*60*20);
		
		
		
		
	}
	
	public static String getMessage() {
		int number = ThreadLocalRandom.current().nextInt(1, 4);
		
		String line = "";
		
		String line1 = "Want to buy a rank? You can with /buy or via shop.dyrhonetwork.nl!";
		String line2 = "We are constantly working to improve the server, any suggestions? Contact us at dyhonetwork.nl, "
				+ "info@dyrhonetwork.nl or via twitter: @TeamDyrho!";
		String line3 = "We are still looking for builders! Apply via dyrhonetwork.nl!";
		
		if(number == 1) {
			line = line1;
		} else if(number == 2) {
			line = line2;
		} else if(number == 3) {
			line = line3;
		} else if(number == 4) {
			line = line1;
		}
		return line;
	}
}
