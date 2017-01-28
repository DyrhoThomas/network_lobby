package network.Lobby.Chat;

import org.bukkit.entity.Player;

public class PlayerPrefix {
	
	public static String spelerPrefix = "§0[§8Member§0]§8 ";
	public static String elitePrefix = "§e§l[§eElite§e§l]§e ";
	public static String masterPrefix = "§6§l[§6Master§6§l]§6 ";
	public static String legendaryPrefix = "§6§l[Legendary] §6";
	public static String youtuberPrefix = "§4§l[§r§lYouTuber§4§l]§r ";
	public static String builderPrefix = "§3[§bBuilder§3] §b";
	public static String modPrefix = "§3§l[§bModerator§3§l]§b ";
	public static String adminPrefix = "§3§l[§b§lAdmin§3§l] §b";
	public static String developerPrefix = "§3§l[§b§lDeveloper§3§l] §b";
	public static String eigenaarPrefix = "§9§l[§3§lOwner§9§l]§b§l ";
	
	public static String getRankPrefix(Player p) {
		if(p.hasPermission("dyrho.elite")) {
			if(p.hasPermission("dyrho.master")) {
				if(p.hasPermission("dyrho.legendary")) {
					if(p.hasPermission("dyrho.youtuber")) {
						if(p.hasPermission("dyrho.builder")) {
							if(p.hasPermission("dyrho.moderator")) {
								if(p.hasPermission("dyrho.admin")) {
									if(p.hasPermission("dyrho.developer")) {
										if(p.hasPermission("dyrho.eigenaar")) {
											return eigenaarPrefix;
										}
										return developerPrefix;
									}
									return adminPrefix;
								}
								return modPrefix;
							}
							return builderPrefix;
						}
						return youtuberPrefix;
					}
					return legendaryPrefix;
				}
				return masterPrefix;
			}
			return elitePrefix;
		}
		return spelerPrefix;
		
	}
}
