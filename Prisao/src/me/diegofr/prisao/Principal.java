package me.diegofr.prisao;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.core.appender.rolling.OnStartupTriggeringPolicy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class Principal extends JavaPlugin implements Listener {
	
	ArrayList<String> cargoTM = new ArrayList();
	ArrayList<String> freezee = new ArrayList();
	ArrayList<String> tempos = new ArrayList();
	BukkitScheduler scheduler = getServer().getScheduler();
	
	File configFile;
	FileConfiguration config;
	
	public Player player;
	 
    Principal plugin;
    World world = getServer().getWorld("world");
	 Location loc = world.getBlockAt(381, 65, -478).getLocation();
	 Location fora = world.getBlockAt(385, 65, -457).getLocation();
    Location sp = world.getSpawnLocation();
    
    
	public void onEnable()
	{
		System.out.print("[RLife Placas] Iniciando RLife Placas!");
		getServer().getPluginManager().registerEvents(this, this);
		this.configFile = new File(getDataFolder(), "config.yml");
		freezee.clear();
		reloadConfig();
		saveConfig();
	}
 
    public void ClassCommands(Principal plugin){
    this.plugin = plugin;
    }
    
    @EventHandler
    public void frezar(PlayerMoveEvent e) {
    	if (freezee.contains(e.getPlayer().getName())) {
    		e.getPlayer().teleport(e.getPlayer());
    	}
    }
 
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label,
            String[] args) {
    	int tempo = Integer.parseInt(args[0]);
    	String player = args[1].toString();
    	Player tplayer = Bukkit.getServer().getPlayer(args[1]);
    	Player p = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("prender")){
        	if(p.hasPermission("rlife.prender")) {
            if(sender instanceof Player){
            if(freezee.contains(tplayer.getName())) {
            	if(!cargoTM.contains(tplayer.getName())) {
            		if(((Player) sender).getItemInHand().getType() == Material.TRIPWIRE_HOOK) {
                   
                    if (tempo >=1 && tempo<=90) {
                    	int tempi = 0;
                    	tempi = tempo*20*60;
                    	 
                    	 List presos = getConfig().getList("Presos");
							presos.add(tplayer);
							getConfig().set("Presos", presos);
							saveConfig();
							
							tplayer.getInventory().clear();
                    	 cargoTM.add(tplayer.getName());
                    	 tplayer.teleport(loc);
                    	 ((Player) sender).getItemInHand().setType(Material.SHEARS);
                    	 freezee.remove(tplayer.getName());
                    	 tplayer.sendMessage(ChatColor.GREEN+"[RLife] : "+ ChatColor.WHITE +"Você foi preso, e terá que aguardar: "+ChatColor.RED+tempo+ChatColor.WHITE+" Min");
             				scheduler.scheduleSyncDelayedTask(this, new Runnable(){
             					public void run(){
             						p.sendMessage(ChatColor.GREEN+"[RLife] : "+ ChatColor.WHITE +"O Jogador "+ ChatColor.RED + player + ChatColor.WHITE +" Ja saiu da prisão");
             						tplayer.sendMessage(ChatColor.GREEN+"[RLife] : "+ ChatColor.WHITE +"Você saiu da prisão");
             						
             						cargoTM.remove(tplayer.getName());             						            						
             						
             						tplayer.teleport(fora);
             						presos.remove(tplayer);
        							getConfig().set("Presos", presos);
        							saveConfig();
        							
             					}
             				},tempi);
                    	
                    } else {
                    	sender.sendMessage(ChatColor.GREEN+"[RLife]"+ChatColor.WHITE+"Tempo Inválido, tempo mínimo = 5 min, tempo máximo: 90 min!");
                    }
            	} else {
            		p.sendMessage(ChatColor.GREEN+"[RLife] : "+ ChatColor.WHITE +"Voce precisa segurar a chave na mão para prender o Jogador!");
            	}
            } else {
            	p.sendMessage(ChatColor.GREEN+"[RLife] : "+ ChatColor.WHITE +"Esse Jogador ja está preso!");
            }
            } else {
            	p.sendMessage(ChatColor.GREEN+"[RLife] : "+ ChatColor.WHITE +"Você precisa algemar o Jogador primeiro!");
            }
            } else {
            	sender.sendMessage(ChatColor.RED + "Somente Players podem executar!");
            }
        } else {
        	p.sendMessage(ChatColor.GREEN+"[RLife] : "+ ChatColor.WHITE +"Somente Policiais podem usar esse comando!");
        }
    } else {
    	sender.sendMessage(ChatColor.RED + "Uso: /prender <Tempo> <Player>");
    }
		return false;
    }
    
    
    
    
    
    
    
    
    
    
    @EventHandler
    public void CriarPlaca(SignChangeEvent e)
   	{
   		if (e.getLine(0).equalsIgnoreCase("[RLife]")) {
   			if (!e.getPlayer().hasPermission("rlife.admin"))
   			{
   				e.getPlayer().sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao tem Permissao para criar placas desse tipo");
   				e.getBlock().breakNaturally();
   			}
   			else
   			{
   				if (e.getLine(1).equalsIgnoreCase("Sair")) {
   				Sign sign = (Sign)e.getBlock().getState();
   					try
   					{
   						e.getPlayer().sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Placa Colocada com sucesso");
   						e.setLine(0, ChatColor.GREEN + "[RLife]");
   						e.setLine(1, ChatColor.RED + "Sair da Prisao");
   						sign.update();
   					}
   					catch (NumberFormatException erro)
   					{
   						e.getPlayer().sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao pode fazer isso");
   						e.getBlock().breakNaturally();
   					}
   				}
   			}
   		}
   	}
    
    
    
    
    
    
    
    
    
    
    
    @EventHandler
	public void onPlayerInteract(PlayerInteractEvent ev)
	{
		if (ev.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			Block b = ev.getClickedBlock();
			if ((b.getType() == Material.SIGN_POST) || (b.getType() == Material.WALL_SIGN))
			{
				Sign s = (Sign) b.getState();
				if (s.getLine(0).equalsIgnoreCase(ChatColor.GREEN + "[RLife]"))
				{
					Player p = ev.getPlayer();
					String pname = ev.getPlayer().getName();
					World mundo = ev.getPlayer().getWorld();
					if (s.getLine(1).equalsIgnoreCase(ChatColor.RED + "Sair da Prisao"))
					{
						if(cargoTM.contains(p.getName())){
                      		 p.sendMessage(ChatColor.GREEN+"[RLife] : "+ ChatColor.WHITE +"Voce ainda nao pode sair da prisão! Aguarde!");
                      	} else {
                      		p.sendMessage(ChatColor.GREEN+"[RLife] : "+ ChatColor.WHITE +"Voce está liberado!");
                      		p.teleport(fora);
                      		
                      	}
					}
				}
			}
		}
	}
    
    
    
    
    
    
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event)
    {
    	if(event.getPlayer().hasPermission("rlife.algema")) {
    	String entity = event.getRightClicked().getName();
        Player player = event.getPlayer();
        	if(!tempos.contains(event.getPlayer().getName())) {
				if (player.getItemInHand().getType() == Material.SHEARS) {
					player.getItemInHand().setType(Material.RABBIT_STEW);
			        player.sendMessage(ChatColor.GREEN+"[RLife] : "+ ChatColor.WHITE +"Voce algemou "+ entity);
			        event.getRightClicked().sendMessage(ChatColor.GREEN+"[RLife] : "+ ChatColor.WHITE +"Voce foi algemado por "+ player.getName());
			        freezee.add(entity);
			        tempos.add(event.getPlayer().getName());
			        scheduler.scheduleSyncDelayedTask(this, new Runnable(){
						@Override
						public void run() {
							player.getItemInHand().setType(Material.TRIPWIRE_HOOK);
						}			        	
			        },1);
			        scheduler.scheduleSyncDelayedTask(this, new Runnable(){
						@Override
						public void run() {
							tempos.remove(event.getPlayer().getName());
						} 
			        },200);
				}
        	}
				if (player.getItemInHand().getType() == Material.TRIPWIRE_HOOK) {
					player.getItemInHand().setType(Material.RABBIT_STEW);
			        player.sendMessage(ChatColor.GREEN+"[RLife] : "+ ChatColor.WHITE +"Voce soltou "+ entity);
			        event.getRightClicked().sendMessage(ChatColor.GREEN+"[RLife] : "+ ChatColor.WHITE +"Voce foi solto!");
			        freezee.removeAll(Collections.singleton(entity));
			        scheduler.scheduleSyncDelayedTask(this, new Runnable(){
						@Override
						public void run() {
							player.getItemInHand().setType(Material.SHEARS);
						}			        	
			        },1);
				}
			}
    }
    
    
    
    @EventHandler
    public void onQuit(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        if(freezee.contains(player.getName())) {
        	List presos = getConfig().getList("Presos");
			presos.add(player);
			getConfig().set("Presos", presos);
			saveConfig();
			
			player.getInventory().clear();
			cargoTM.add(player.getName());
			player.teleport(loc);
			freezee.remove(player.getName());
				scheduler.scheduleSyncDelayedTask(this, new Runnable(){
					public void run(){
						player.sendMessage(ChatColor.GREEN+"[RLife] : "+ ChatColor.WHITE +"Você saiu da prisão");
						
						cargoTM.remove(player.getName());             						            						
						
						player.teleport(fora);
						presos.remove(player);
					getConfig().set("Presos", presos);
					saveConfig();
					
					}
				},72000);
        }

    }
    
}
