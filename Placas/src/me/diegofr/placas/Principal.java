package me.diegofr.placas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Principal extends JavaPlugin implements Listener {
	
	ArrayList<String> cargoTM = new ArrayList();
	BukkitScheduler scheduler = getServer().getScheduler();
	
	File configFile;
	FileConfiguration config;
	
	public void onEnable()
	{
		System.out.print("[RLife Placas] Iniciando RLife Placas!");
		getServer().getPluginManager().registerEvents(this, this);
		this.configFile = new File(getDataFolder(), "config.yml");
		try {
			firstRun();
		} catch (Exception e) {
			e.printStackTrace();
		}
		reloadConfig();
		saveConfig();
	}
	int taskID = 0;
	
	private void firstRun() throws Exception {
		if (!this.configFile.exists()) {
			this.configFile.getParentFile().mkdirs();
			copy(getResource("config.yml"), this.configFile);
		}
	}
	

	private void copy(InputStream in, File file) {
		try {
			OutputStream out = new FileOutputStream(file);
			byte[] buffer = new byte['?'];
			int len = in.read(buffer);
			while (len != -1) {
				out.write(buffer, 0, len);
				len = in.read(buffer);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
				if (e.getLine(1).equalsIgnoreCase("Mineradora")) {
				Sign sign = (Sign)e.getBlock().getState();
					int vagas = getConfig().getInt("Vagasmineradora");
					try
					{
						e.getPlayer().sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Placa Colocada com sucesso");
						e.setLine(0, ChatColor.GREEN + "[RLife]");
						e.setLine(1, ChatColor.WHITE + "Mineradora");
						e.setLine(2, ChatColor.WHITE + "Vagas: 10");
						e.setLine(3, ChatColor.GREEN+"Disponiveis: " +vagas);
						sign.update();
					}
					catch (NumberFormatException erro)
					{
						e.getPlayer().sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao colocou um preco em numeros");
						e.getBlock().breakNaturally();
					}
				} else if (e.getLine(1).equalsIgnoreCase("Tijoleiro")) {
				Sign sign = (Sign)e.getBlock().getState();
					int vagast = getConfig().getInt("Vagastijoleiro");
					try
					{
						e.getPlayer().sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Placa Colocada com sucesso");
						e.setLine(0, ChatColor.GREEN + "[RLife]");
						e.setLine(1, ChatColor.WHITE + "Fabrica de Tijolo");
						e.setLine(2, ChatColor.WHITE + "Vagas: 10");
						e.setLine(3, ChatColor.GREEN+"Disponiveis: " +vagast);
					}
					catch (NumberFormatException erro)
					{
						e.getPlayer().sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao colocou um preco em numeros");
						e.getBlock().breakNaturally();
					}
				} else if (e.getLine(1).equalsIgnoreCase("Cimento")) {
				Sign sign = (Sign)e.getBlock().getState();
					int vagasc = getConfig().getInt("Vagascimento");
					try
					{
						e.getPlayer().sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Placa Colocada com sucesso");
						e.setLine(0, ChatColor.GREEN + "[RLife]");
						e.setLine(1, ChatColor.WHITE + "Fabrica Cimento");
						e.setLine(2, ChatColor.WHITE + "Vagas: 10");
						e.setLine(3, ChatColor.GREEN+"Disponiveis: " +vagasc);
					}
					catch (NumberFormatException erro)
					{
						e.getPlayer().sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao colocou um preco em numeros");
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
					if (s.getLine(1).equalsIgnoreCase(ChatColor.WHITE + "Mineradora"))
					{
						int vagas = getConfig().getInt("Vagasmineradora");
						if (!getConfig().getList("Mineiro").contains(pname))
						{
						if (!getConfig().getList("Tijoleiro").contains(pname))
						{
							if (!getConfig().getList("Cimento").contains(pname))
							{
							if (vagas >= 1)
							{
								if (p.hasPermission("rlife.usar")){
									List mineiro = getConfig().getList("Mineiro");
									mineiro.add(pname);
									getConfig().set("Mineiro", mineiro);
									this.getConfig().set("Vagasmineradora", vagas - 1);
									saveConfig();
									
									s.setLine(3, ChatColor.GREEN + "Disponiveis: " + getConfig().getInt("Vagasmineradora"));
									s.update();
									getServer().dispatchCommand(getServer().getConsoleSender(), "pex user " + p.getName() + " group set minerador");
									p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.YELLOW+"Voce se tornou um Mineiro!");	
									cargoTM.add(p.getName());
									taskID = scheduler.scheduleSyncDelayedTask(this, new Runnable(){
										public void run(){
											p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.YELLOW+"Caso queira, você ja podera sair do seu emprego atual!");
											cargoTM.remove(p.getName());
										}
									},500);
									
								}
								else
								{
									p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Sem permissao!");
								}
							}
							else {
								p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Nao possui mais vaga na empresa solicitada!");
							}
						} else {
							p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Voce ja tem emprego, primeiro saia do trabalho atual!");
						} 
						}  else {
							p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Voce ja tem emprego, primeiro saia do trabalho atual!");
						}
						} else {
								if(cargoTM.contains(p.getName())){
									p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Aguarde para trocar de emprego!");
								}else{
								List mineiro = getConfig().getList("Mineiro");
								mineiro.remove(pname);
								getConfig().set("Mineiro", mineiro);
								this.getConfig().set("Vagasmineradora", vagas + 1);
								saveConfig();
								
								s.setLine(3, ChatColor.GREEN + "Disponiveis: " + getConfig().getInt("Vagasmineradora"));
								s.update();
								getServer().dispatchCommand(getServer().getConsoleSender(), "pex user " + p.getName() + " group set default");
								p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.YELLOW+"Voce saiu do emprego!");
								}
						}
					}
					
					
					
					
					
					
					if (s.getLine(1).equalsIgnoreCase(ChatColor.WHITE + "Fabrica de Tijolo"))
					{
						int vagast = getConfig().getInt("Vagastijoleiro");
						if (!getConfig().getList("Tijoleiro").contains(pname))
						{
						if (!getConfig().getList("Mineiro").contains(pname))
						{
							if (!getConfig().getList("Cimento").contains(pname))
							{
							if (vagast >= 1)
							{
								if (p.hasPermission("rlife.usar")){
									List tijo = getConfig().getList("Tijoleiro");
									tijo.add(pname);
									getConfig().set("Tijoleiro", tijo);
									this.getConfig().set("Vagastijoleiro", vagast - 1);
									saveConfig();
									
									s.setLine(3, ChatColor.GREEN + "Disponiveis: " + getConfig().getInt("Vagastijoleiro"));
									s.update();
									getServer().dispatchCommand(getServer().getConsoleSender(), "pex user " + p.getName() + " group set tijoleiro");
									p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.YELLOW +"Voce se tornou um Fabricante de Tijolos!");	
									cargoTM.add(p.getName());
									taskID = scheduler.scheduleSyncDelayedTask(this, new Runnable(){
										public void run(){
											p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.YELLOW+"Caso queira, você ja podera sair do seu emprego atual!");
											cargoTM.remove(p.getName());
										}
									},500);
									
								}
								else
								{
									p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Sem permissao!");
								}
							}
							else {
								p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Nao possui mais vaga na empresa solicitada!");
							}
						} else {
							p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Voce ja tem emprego, primeiro saia do trabalho atual!");
						}
						} else {
							p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Voce ja tem emprego, primeiro saia do trabalho atual!");
						}
						} else {
								if(cargoTM.contains(p.getName())){
									p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Aguarde para trocar de emprego!");
								}else{
								List tijo = getConfig().getList("Tijoleiro");
								tijo.remove(pname);
								getConfig().set("Tijoleiro", tijo);
								this.getConfig().set("Vagastijoleiro", vagast + 1);
								saveConfig();
								
								s.setLine(3, ChatColor.GREEN + "Disponiveis: " + getConfig().getInt("Vagastijoleiro"));
								s.update();
								getServer().dispatchCommand(getServer().getConsoleSender(), "pex user " + p.getName() + " group set default");
								p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.YELLOW+"Voce saiu do emprego!");
								}
						}
					}
					
					
					
					
					
					
					if (s.getLine(1).equalsIgnoreCase(ChatColor.WHITE + "Fabrica Cimento"))
					{
						int vagasc = getConfig().getInt("Vagascimento");
						if (!getConfig().getList("Cimento").contains(pname))
						{
						if (!getConfig().getList("Mineiro").contains(pname))
						{
						if (!getConfig().getList("Tijoleiro").contains(pname))
						{
							if (vagasc >= 1)
							{
								if (p.hasPermission("rlife.usar")){
									List cimento = getConfig().getList("Cimento");
									cimento.add(pname);
									getConfig().set("Cimento", cimento);
									this.getConfig().set("Vagascimento", vagasc - 1);
									saveConfig();
									
									s.setLine(3, ChatColor.GREEN + "Disponiveis: " + getConfig().getInt("Vagascimento"));
									s.update();
									getServer().dispatchCommand(getServer().getConsoleSender(), "pex user " + p.getName() + " group set cimenteiro");
									p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.YELLOW+"Voce se tornou um Fabricante de Cimento!");	
									cargoTM.add(p.getName());
									taskID = scheduler.scheduleSyncDelayedTask(this, new Runnable(){
										public void run(){
											p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.YELLOW+"Caso queira, você ja podera sair do seu emprego atual!");
											cargoTM.remove(p.getName());
										}
									},500);
									
								}
								else
								{
									p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Sem permissao!");
								}
							}
							else {
								p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Nao possui mais vaga na empresa solicitada!");
							}
						} else {
							p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Voce ja tem emprego, primeiro saia do trabalho atual!");
						}
						} else {
							p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Voce ja tem emprego, primeiro saia do trabalho atual!");
						}
						} else {
								if(cargoTM.contains(p.getName())){
									p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.RED+"Aguarde para trocar de emprego!");
								}else{
								List cimento = getConfig().getList("Cimento");
								cimento.remove(pname);
								getConfig().set("Cimento", cimento);
								this.getConfig().set("Vagascimento", vagasc + 1);
								saveConfig();
								
								s.setLine(3, ChatColor.GREEN + "Disponiveis: " + getConfig().getInt("Vagascimento"));
								s.update();
								getServer().dispatchCommand(getServer().getConsoleSender(), "pex user " + p.getName() + " group set default");
								p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.YELLOW+"Voce saiu do emprego!");
								}
						}
					}
					
					
					
					
				}
			}
		}
	}
	
	

}
