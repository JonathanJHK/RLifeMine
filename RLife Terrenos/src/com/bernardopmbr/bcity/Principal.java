package com.bernardopmbr.bcity;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.domains.DefaultDomain;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Principal
  extends JavaPlugin
  implements Listener
{
  public Economy economia;
  File configFile;
  FileConfiguration config;
  
  public void onEnable()
  {
    getWorldGuard();
    System.out.print("[BCity] Iniciando - Autor: bernardopmbr!");
    getServer().getPluginManager().registerEvents(this, this);
    setupEconomy();
    this.configFile = new File(getDataFolder(), "config.yml");
    try
    {
      firstRun();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    reloadConfig();
    saveConfig();
  }
  
  private void firstRun()
    throws Exception
  {
    if (!this.configFile.exists())
    {
      this.configFile.getParentFile().mkdirs();
      copy(getResource("config.yml"), this.configFile);
    }
  }
  
  private void copy(InputStream in, File file)
  {
    try
    {
      OutputStream out = new FileOutputStream(file);
      byte[] buf = new byte['?'];
      int len;
      while ((len = in.read(buf)) > 0)
      {
        out.write(buf, 0, len);
      }
      out.close();
      in.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  private WorldGuardPlugin getWorldGuard()
  {
    Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
    if ((plugin == null) || (!(plugin instanceof WorldGuardPlugin))) {
      Bukkit.getLogger().log(Level.SEVERE, "[BCity]" + ChatColor.RED + " Sem worldguard o plugin nao funciona");
    }
    return (WorldGuardPlugin)plugin;
  }
  
  private boolean initVault()
  {
    Plugin vault_plugin = getServer().getPluginManager().getPlugin("Vault");
    boolean hasVault = false;
    if ((vault_plugin != null) && 
      (getServer().getPluginManager().isPluginEnabled(vault_plugin))) {
      hasVault = true;
    }
    if (hasVault) {
      return true;
    }
    return false;
  }
  
  private boolean setupEconomy()
  {
    if (getServer().getPluginManager().getPlugin("Vault") == null) {
      return false;
    }
    RegisteredServiceProvider rsp = getServer().getServicesManager().getRegistration(Economy.class);
    if (rsp == null) {
      return false;
    }
    this.economia = ((Economy)rsp.getProvider());
    return this.economia != null;
  }
  
  public void onDisable()
  {
    System.out.print("[BCity] Finalizando - Autor: bernardopmbr");
    saveConfig();
  }
  
  @EventHandler
  public void CriarPlaca(SignChangeEvent e)
  {
    if ((e.getLine(0).equalsIgnoreCase("[Comprar]")) || (e.getLine(0).equalsIgnoreCase("&2[Comprar]")) || (e.getLine(0).equalsIgnoreCase("&2[Comprar]"))) {
      if (!e.getPlayer().hasPermission("bcity.admin"))
      {
        e.getPlayer().sendMessage("&a[BCity] &4Voce nao tem Permissao");
        e.getBlock().breakNaturally();
      }
      else
      {
        World mundo = e.getPlayer().getWorld();
        RegionManager rm = WGBukkit.getRegionManager(mundo);
        Sign sign = (Sign)e.getBlock().getState();
        if (rm.getRegion(e.getLine(1)) != null)
        {
          int preco = 0;
          try
          {
            preco = Integer.parseInt(e.getLine(2));
            String nomeregion = e.getLine(1);
            String spreco = e.getLine(2);
            e.getPlayer().sendMessage("&a[BCity] &fTerreno colocado a venda");
            e.setLine(0, ChatColor.DARK_GREEN + "[Comprar]");
            e.setLine(1, nomeregion);
            e.setLine(2, spreco);
            e.setLine(3, "");
          }
          catch (NumberFormatException erro)
          {
            e.getPlayer().sendMessage("&a[BCity] &fVoce nao colocou um preco em numeros");
            e.getBlock().breakNaturally();
          }
        }
        else
        {
          e.getPlayer().sendMessage("&a[BCity] &fVoce nao colocou o nome de uma region valida deste mundo");
          e.getBlock().breakNaturally();
        }
      }
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("bcity"))
    {
      if (args.length == 0)
      {
        sender.sendMessage("&a[BCity] &f-- Comandos: --");
        sender.sendMessage("&a> &f/bcity adicionaramigo -> Adiciona um amigo ao seu terreno");
        sender.sendMessage("&a> &f/bcity removeramigo -> Remove um amigo do seu terreno");
        sender.sendMessage("&a> &f/bcity amigos -> Ve os amigos atuais do seu terreno");
        sender.sendMessage("&a[BCity] &f---------------");
        return true;
      }
      if (args[0].equalsIgnoreCase("adicionaramigo"))
      {
        if (sender.hasPermission("bcity.usar"))
        {
          if (args.length != 2)
          {
            sender.sendMessage("&a[BCity] &fUtilize /bcity adicionaramigo [nick] -> DENTRO DO TERRENO");
            return true;
          }
          String amigo = args[1];
          Player p = (Player)sender;
          if (!amigo.equalsIgnoreCase(p.getName()))
          {
            World mundo = p.getWorld();
            RegionManager rm = WGBukkit.getRegionManager(mundo);
            Location local = p.getLocation();
            LocalPlayer localPlayer = getWorldGuard().wrapPlayer(p);
            Vector pt = localPlayer.getPosition();
            ApplicableRegionSet set = rm.getApplicableRegions(pt);
            if (set.size() == 0)
            {
              p.sendMessage("&a[BCity] &fVoce nao esta encima de nenhuma region");
              return true;
            }
            String id = ((ProtectedRegion)set.iterator().next()).getId();
            ProtectedRegion region = rm.getRegion(id);
            if (region.isOwner(p.getName()))
            {
              DefaultDomain membros = region.getMembers();
              membros.addPlayer(amigo);
              region.setMembers(membros);
              try
              {
                rm.save();
              }
              catch (Exception e)
              {
                e.printStackTrace();
              }
              sender.sendMessage("&a[BCity] &fFoi adicionado o seguinte amigo no seu terreno:  &4" + amigo);
              return true;
            }
            p.sendMessage("&a[BCity] &fVoce nao e dono desta region");
            return true;
          }
          sender.sendMessage("&a[BCity] &fSeu amigo nao pode ser voce");
          return true;
        }
        sender.sendMessage("&6[BCity] &fSem permissao");
        return true;
      }
      if (args[0].equalsIgnoreCase("removeramigo"))
      {
        if (sender.hasPermission("bcity.usar"))
        {
          if (args.length != 2)
          {
            sender.sendMessage("&a[BCity] &fUtilize /bcity removeramigo [nick] -> DENTRO DO TERRENO");
            return true;
          }
          String amigo = args[1];
          Player p = (Player)sender;
          if (!amigo.equalsIgnoreCase(p.getName()))
          {
            World mundo = p.getWorld();
            RegionManager rm = WGBukkit.getRegionManager(mundo);
            Location local = p.getLocation();
            LocalPlayer localPlayer = getWorldGuard().wrapPlayer(p);
            Vector pt = localPlayer.getPosition();
            ApplicableRegionSet set = rm.getApplicableRegions(pt);
            if (set.size() == 0)
            {
              p.sendMessage("&a[BCity] &fVoce nao esta encima de nenhuma region");
              return true;
            }
            String id = ((ProtectedRegion)set.iterator().next()).getId();
            ProtectedRegion region = rm.getRegion(id);
            if (region.isOwner(p.getName()))
            {
              DefaultDomain membros = region.getMembers();
              if (membros.contains(amigo))
              {
                membros.removePlayer(amigo);
                region.setMembers(membros);
                try
                {
                  rm.save();
                }
                catch (Exception e)
                {
                  e.printStackTrace();
                }
                sender.sendMessage("&a[BCity] &fFoi removido o seguinte amigo no seu terreno:  &4" + amigo);
                return true;
              }
              sender.sendMessage("&a[BCity] &fEsse player nao e amigo em seu terreno");
              return true;
            }
            p.sendMessage("&a[BCity] &fVoce nao e dono desta region");
            return true;
          }
          sender.sendMessage("&a[BCity] &fSeu amigo nao pode ser voce");
          return true;
        }
        sender.sendMessage("&a[BCity]&f Sem permissao");
        return true;
      }
      if (args[0].equalsIgnoreCase("amigos"))
      {
        if (sender.hasPermission("bcity.usar"))
        {
          Player p = (Player)sender;
          World mundo = p.getWorld();
          RegionManager rm = WGBukkit.getRegionManager(mundo);
          Location local = p.getLocation();
          LocalPlayer localPlayer = getWorldGuard().wrapPlayer(p);
          Vector pt = localPlayer.getPosition();
          ApplicableRegionSet set = rm.getApplicableRegions(pt);
          if (set.size() == 0)
          {
            p.sendMessage("&a[BCity] &fVoce nao esta encima de nenhuma region");
            return true;
          }
          String id = ((ProtectedRegion)set.iterator().next()).getId();
          ProtectedRegion region = rm.getRegion(id);
          if (region.isOwner(p.getName()))
          {
            DefaultDomain membros = region.getMembers();
            sender.sendMessage("&a[BCity] &fAmigos atuais da sua area:  &4" + membros.toPlayersString());
            return true;
          }
          p.sendMessage("&a[BCity] &fVoce nao e dono desta region");
          return true;
        }
        sender.sendMessage("&a[BCity]&f Sem permissao");
        return true;
      }
    }
    return false;
  }
  
  
  
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent ev)
  {
    if (ev.getAction() == Action.RIGHT_CLICK_BLOCK)
    {
      Block b = ev.getClickedBlock();
      if ((b.getType() == Material.SIGN_POST) || (b.getType() == Material.WALL_SIGN) || (b.getType() == Material.SIGN))
      {
        Sign s = (Sign)b.getState();
        if ((s.getLine(0).equalsIgnoreCase("[Comprar]")) || (s.getLine(0).equalsIgnoreCase("&2[Comprar]")) || (s.getLine(0).equalsIgnoreCase("&2[Comprar]")))
        {
          Player p = ev.getPlayer();
          String pname = ev.getPlayer().getName();
          World mundo = ev.getPlayer().getWorld();
          RegionManager rm = WGBukkit.getRegionManager(mundo);
          String regionName = s.getLine(1);
          if (rm.getRegion(regionName) != null)
          {
              int preco = Integer.parseInt(s.getLine(2));
              if (this.economia.getBalance(pname) >= preco)
              {
                if (p.hasPermission("bcity.usar"))
                {
                  List donosdeterrenos = getConfig().getList("donosdeterrenos");
                  if (!donosdeterrenos.contains(pname))
                  {
                    donosdeterrenos.add(pname);
                    getConfig().set("donosdeterrenos", donosdeterrenos);
                    saveConfig();
                  }
                  DefaultDomain dd = new DefaultDomain();
                  dd.addPlayer(pname);
                  ProtectedRegion region = rm.getRegion(regionName);
                  p.sendMessage("&a[BCity] &fTerreno comprado com sucesso!");
                  this.economia.withdrawPlayer(pname, preco);
                  region.setOwners(dd);
                  try
                  {
                    rm.save();
                  }
                  catch (Exception e)
                  {
                    e.printStackTrace();
                  }
                  s.setLine(0, ChatColor.RED + "[Vendido]");
                  s.setLine(1, ChatColor.BLACK + "Dono");
                  s.setLine(2, ChatColor.BLACK + ev.getPlayer().getName());
                  s.setLine(3, "");
                  s.update();
                }
                else
                {
                  p.sendMessage("&a[BCity] &fSem permissao!");
                }
              }
              else {
                p.sendMessage("&a[BCity] &fVoce nao tem dinheiro suficiente!");
              }
          }
          else {
            p.sendMessage("&a[BCity] &fRegion Invalida!!");
          }
        }
      }
    }
  }
}
