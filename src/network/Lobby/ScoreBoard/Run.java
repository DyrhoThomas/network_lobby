package network.Lobby.ScoreBoard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import network.Lobby.Main;
import network.Lobby.ScoreBoard.Create;

public class Run {
	
	public static void Timer(final Player p) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.main, new Runnable() {
			public void run() {
				if(!p.isOnline()) {
					return;
				}
				Create.createScoreBoard(p);
			}
		}, 0, 5*20);
	}
}