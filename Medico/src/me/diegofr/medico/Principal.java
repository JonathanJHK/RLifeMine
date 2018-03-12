package me.diegofr.medico;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Principal extends JavaPlugin implements Listener {
	
	World world = getServer().getWorld("world");
	Location loc = world.getBlockAt(558, 63, -389).getLocation();
	
	 @EventHandler
	 public void onKill(PlayerDeathEvent e)
	 {
	 String killed = e.getEntity().getName();
	 String killer = e.getEntity().getKiller().getName();
	 Player p = e.getEntity();
	 e.setDeathMessage(ChatColor.RED + killed + " has been slain by " + killer);
	 p.teleport(loc);
	 }

}
