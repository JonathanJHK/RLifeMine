package me.diegofr.medico;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Principal extends JavaPlugin implements Listener {
	
	World world = getServer().getWorld("world");
	Location loc = world.getBlockAt(558, 63, -389).getLocation();
	
	public void onEnable()
	{
		System.out.print("[RLife Médico] Iniciando RLife Médico!");
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	 @EventHandler
	 public void conectar(PlayerJoinEvent event){
		 event.setJoinMessage(null);
	 }
	 
	 public void desconectar(PlayerQuitEvent event){
		 event.setQuitMessage(null);
	 }
	 
	 public void respawn(PlayerRespawnEvent event){
		 Player p = event.getPlayer();
		 p.teleport(loc);
		 p.setHealth(p.getHealth() - 16);
		 p.sendMessage(ChatColor.GREEN + "[RLife]: " + ChatColor.WHITE + "Pague um tratamento para recuperar sua saúde ou se alimente");
	 }
	 
	 public void criarPlaca(SignChangeEvent event){
		 if (event.getLine(0).equalsIgnoreCase("[RLife]")) {
			 if(event.getPlayer().hasPermission("rlife.admin")){
				 if (event.getLine(1).equalsIgnoreCase("Tratamento")){
					 Sign sign = (Sign)event.getBlock().getState();
					 try
						{
							event.getPlayer().sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Placa Colocada com sucesso");
							event.setLine(0, ChatColor.GREEN + "[RLife]");
							event.setLine(1, ChatColor.WHITE + "Tratamento");
							event.setLine(2, ChatColor.RED + "Custo: 100");
							sign.update();
						}
						catch (NumberFormatException erro)
						{
							event.getBlock().breakNaturally();
						}
				 }
			 } else {
				 event.getBlock().breakNaturally();
				 event.getPlayer().sendMessage(ChatColor.GREEN + "[RLife]: " + ChatColor.WHITE + "Este tipo de placa nao pode ser criada por voce!");
			 }
			 
		 }
	 }
}
