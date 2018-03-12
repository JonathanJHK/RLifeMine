package me.diegofr.drogas;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Principal extends JavaPlugin implements Listener {
	
	File configFile;
	FileConfiguration config;
	String Player;
	int pl = 0;
	
	@EventHandler// (priority = EventPriority.LOWEST)
	public void playerRenameItem(InventoryClickEvent event){
	if (event.getView().getType() == InventoryType.ANVIL) {
	if (event.getRawSlot() == 2) {
	if (event.getView().getItem(0).getType() != Material.AIR && event.getView().getItem(2).getType() != Material.AIR) {
	if (event.getView().getItem(0).getItemMeta().getDisplayName() != event.getView().getItem(2).getItemMeta().getDisplayName()) {
	event.setCancelled(true);
	}
	}
	}
	}
	}

	
		public void onEnable()
		{
			System.out.print("[RLife Drogas e Auto Mensagens] Iniciando RLife D&AM!");
			getServer().getPluginManager().registerEvents(this, this);
			this.configFile = new File(getDataFolder(), "config.yml");
			reloadConfig();
			saveConfig();			
			
			BukkitScheduler scheduler = getServer().getScheduler();
			 scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
				public void run() {
					pl = Bukkit.getServer().getOnlinePlayers().size();
				}
			}, 0L, 100L);
			 
			 scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
				@Override
				public void run() {
					if (pl >= 2) {
						getServer().broadcastMessage(ChatColor.GREEN + "Servidor em Deselvolvimento");
					}
					
				}
			}, 0L, 5000L);
		}
		
}
		
