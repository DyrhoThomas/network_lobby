package network.Lobby.ServerVillagers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;

import net.minecraft.server.v1_8_R2.NBTTagCompound;
import network.Lobby.Main;

public class SpawnVillagers {
	
	public static void spawnOnStartUp(Location loc, String name, Boolean setRemoveWhenFarAway) {
		Main.broadcast(Main.prefix + "Villager gespawnt met de naam §3" + name + "§b!");
		Villager villager = (Villager) loc.getWorld().spawn(loc, Villager.class);
		villager.setProfession(Profession.LIBRARIAN);
		villager.setRemoveWhenFarAway(setRemoveWhenFarAway);
		villager.setCustomName(name);
		villager.setCustomNameVisible(true);
		villager.setAdult();
		if(villager instanceof Entity) {
			freezeEntity((Entity) villager);
		}
	}
	public static void killAllVillagers(World world) {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kill @e[type=Villager]");
	}
	public static void freezeEntity(Entity en){
	      net.minecraft.server.v1_8_R2.Entity nmsEn = ((CraftEntity) en).getHandle();
	      NBTTagCompound compound = new NBTTagCompound();
	      nmsEn.c(compound);
	      compound.setByte("NoAI", (byte) 1);
	      nmsEn.f(compound);
	}
}
