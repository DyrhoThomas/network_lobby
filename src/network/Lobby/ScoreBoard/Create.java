package network.Lobby.ScoreBoard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import network.Lobby.Chat.PlayerPrefix;

public class Create {

	private static Scoreboard board;
	private static Objective o;
	private static Score line1;
	private static Score line2;
	private static Score line3;
	private static Score line4;
	private static Score line5;
	private static Score line6;
	private static Score line7;
	private static Score line8;
	private static Score line9;
	
	@SuppressWarnings("deprecation")
	public static void createScoreBoard(Player p) {
		
		board = Bukkit.getScoreboardManager().getNewScoreboard();
		o = board.registerNewObjective(p.getName(), "dummy");
		o.setDisplayName("§3§lDyrho§b§lNetwork");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		
	    line1 = o.getScore(Bukkit.getOfflinePlayer("§1                            "));
    	line1.setScore(9);
    	
	    line2 = o.getScore(Bukkit.getOfflinePlayer("§3§l» Server§b:"));
	    line2.setScore(8);

	    line3 = o.getScore(Bukkit.getOfflinePlayer("§r   Lobby"));
	    line3.setScore(7);

	    line4 = o.getScore(Bukkit.getOfflinePlayer("§2"));
    	line4.setScore(6);
    	
    	line5 = o.getScore(Bukkit.getOfflinePlayer("§3§l» Rank§b:"));
    	line5.setScore(5);
    	
    	line6 = o.getScore(Bukkit.getOfflinePlayer("   " + PlayerPrefix.getRankPrefix(p)));
    	line6.setScore(4);

	    line7 = o.getScore(Bukkit.getOfflinePlayer("§3"));
	    line7.setScore(3);

	    line8 = o.getScore(Bukkit.getOfflinePlayer("§3§l» Buy a rank§b:"));
	    line8.setScore(2);

	    line9 = o.getScore(Bukkit.getOfflinePlayer("§r   shop.dyrhonetwork.nl"));
	    line9.setScore(1);
	    	    	
	    p.setScoreboard(board);
	}
}
