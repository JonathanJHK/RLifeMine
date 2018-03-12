/*     */ package com.bernardopmbr.bcity;
/*     */ 
/*     */ import com.sk89q.worldedit.Vector;
/*     */ import com.sk89q.worldguard.LocalPlayer;
/*     */ import com.sk89q.worldguard.bukkit.WGBukkit;
/*     */ import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
/*     */ import com.sk89q.worldguard.domains.DefaultDomain;
/*     */ import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
/*     */ import com.sk89q.worldguard.protection.managers.RegionManager;
/*     */ import com.sk89q.worldguard.protection.regions.ProtectedRegion;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import net.milkbowl.vault.economy.Economy;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.block.Sign;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
/*     */ import org.bukkit.event.block.SignChangeEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.PluginManager;
/*     */ import org.bukkit.plugin.RegisteredServiceProvider;
/*     */ import org.bukkit.plugin.ServicesManager;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Principal
/*     */   extends JavaPlugin
/*     */   implements Listener
/*     */ {
/*     */   public Economy economia;
/*     */   File configFile;
/*     */   FileConfiguration config;
/*     */   
/*     */   public void onEnable()
/*     */   {
/*  57 */     getWorldGuard();
/*  58 */     System.out.print("[RLife Terrenos] Iniciando RLife terrenos!");
/*  59 */     getServer().getPluginManager().registerEvents(this, this);
/*  60 */     setupEconomy();
/*  61 */     this.configFile = new File(getDataFolder(), "config.yml");
/*     */     try {
/*  63 */       firstRun();
/*     */     } catch (Exception e) {
/*  65 */       e.printStackTrace();
/*     */     }
/*  67 */     reloadConfig();
/*  68 */     saveConfig();
/*     */   }
/*     */   
/*     */   private void firstRun() throws Exception {
/*  72 */     if (!this.configFile.exists()) {
/*  73 */       this.configFile.getParentFile().mkdirs();
/*  74 */       copy(getResource("config.yml"), this.configFile);
/*     */     }
/*     */   }
/*     */   
/*     */   private void copy(InputStream in, File file) {
/*     */     try {
/*  80 */       OutputStream out = new FileOutputStream(file);
/*  81 */       byte[] buffer = new byte['?'];
/*     */       int len = in.read(buffer);
/*  83 */       while (len != -1) {
/*  84 */         out.write(buffer, 0, len);
/*     */		  len = in.read(buffer);
/*     */       }
/*  86 */       out.close();
/*  87 */       in.close();
/*     */     } catch (Exception e) {
/*  89 */       e.printStackTrace();
/*     */     }
   }
   
/*     */   private WorldGuardPlugin getWorldGuard()
/*     */   {
/*  95 */     Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
/*  96 */     if ((plugin == null) || (!(plugin instanceof WorldGuardPlugin))) {
/*  97 */       Bukkit.getLogger().log(Level.SEVERE, "[RLife]" + ChatColor.RED + " Sem worldguard o plugin nao funciona");
/*     */     }
/*  99 */     return (WorldGuardPlugin)plugin;
/*     */   }
/*     */   
/*     */   private boolean initVault()
/*     */   {
/* 104 */     Plugin vault_plugin = getServer().getPluginManager().getPlugin("Vault");
/* 105 */     boolean hasVault = false;
/* 106 */     if ((vault_plugin != null) && 
/* 107 */       (getServer().getPluginManager().isPluginEnabled(vault_plugin))) {
/* 108 */       hasVault = true;
/*     */     }
/* 110 */     if (hasVault) {
/* 111 */       return true;
/*     */     }
/* 113 */     return false;
/*     */   }
/*     */   
/*     */   private boolean setupEconomy()
/*     */   {
/* 118 */     if (getServer().getPluginManager().getPlugin("Vault") == null) {
/* 119 */       return false;
/*     */     }
/* 121 */     RegisteredServiceProvider rsp = getServer().getServicesManager().getRegistration(Economy.class);
/* 122 */     if (rsp == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     this.economia = ((Economy)rsp.getProvider());
/* 126 */     return this.economia != null;
/*     */   }
/*     */   
/*     */   public void onDisable()
/*     */   {
/* 131 */     System.out.print("[RLife Terrenos] Finalizando plugin");
/* 132 */     saveConfig();
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void CriarPlaca(SignChangeEvent e)
/*     */   {
/* 138 */     if ((e.getLine(0).equalsIgnoreCase("[Comprar]")) || (e.getLine(0).equalsIgnoreCase("&2[Comprar]")) || (e.getLine(0).equalsIgnoreCase("&2[Comprar]"))) {
/* 139 */       if (!e.getPlayer().hasPermission("rlife.admin"))
/*     */       {
/* 141 */         e.getPlayer().sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao tem Permissao");
/* 142 */         e.getBlock().breakNaturally();
/*     */       }
/*     */       else
/*     */       {
/* 146 */         World mundo = e.getPlayer().getWorld();
/* 147 */         RegionManager rm = WGBukkit.getRegionManager(mundo);
/* 148 */         Sign sign = (Sign)e.getBlock().getState();
/* 149 */         if (rm.getRegion(e.getLine(1)) != null)
/*     */         {
/* 151 */           int preco = 0;
/*     */           try
/*     */           {
/* 154 */             preco = Integer.parseInt(e.getLine(2));
/* 155 */             String nomeregion = e.getLine(1);
/* 156 */             String spreco = e.getLine(2);
/* 157 */             e.getPlayer().sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Terreno colocado a venda");
/* 158 */             e.setLine(0, ChatColor.DARK_GREEN + "[Comprar]");
/* 159 */             e.setLine(1, nomeregion);
/* 160 */             e.setLine(2, spreco);
/* 161 */             e.setLine(3, "");
/*     */           }
/*     */           catch (NumberFormatException erro)
/*     */           {
/* 165 */             e.getPlayer().sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao colocou um preco em numeros");
/* 166 */             e.getBlock().breakNaturally();
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 171 */           e.getPlayer().sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao colocou o nome de uma region valida deste mundo");
/* 172 */           e.getBlock().breakNaturally();
/*     */         }
/*     */       }
/*     */     }
/*     */   }


/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/* 180 */     if (cmd.getName().equalsIgnoreCase("rlife"))
/*     */     {
/* 182 */       if (args.length == 0)
/*     */       {
/* 184 */         sender.sendMessage(ChatColor.GREEN+"-- Comandos: --");
/* 185 */         sender.sendMessage("/rlife adicionaramigo -> Adiciona um amigo ao seu terreno");
/* 186 */         sender.sendMessage("/rlife removeramigo -> Remove um amigo do seu terreno");
/* 187 */         sender.sendMessage("/rlife amigos -> Ve os amigos atuais do seu terreno");
/* 188 */         sender.sendMessage(ChatColor.GREEN+"---------------");
/* 189 */         return true;
/*     */       }
/*     */       
/* 192 */       if (args[0].equalsIgnoreCase("adicionaramigo"))
/*     */       {
/* 194 */         if (sender.hasPermission("rlife.usar"))
/*     */         {
/* 196 */           if (args.length != 2)
/*     */           {
/* 198 */             sender.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Utilize /rlife adicionaramigo [nick] -> DENTRO DO TERRENO");
/* 199 */             return true;
/*     */           }
/* 201 */           String amigo = args[1];
/* 202 */           Player p = (Player)sender;
/* 203 */           if (!amigo.equalsIgnoreCase(p.getName()))
/*     */           {
/* 205 */             World mundo = p.getWorld();
/* 206 */             RegionManager rm = WGBukkit.getRegionManager(mundo);
/* 207 */             Location local = p.getLocation();
/* 208 */             LocalPlayer localPlayer = getWorldGuard().wrapPlayer(p);
/* 209 */             Vector pt = localPlayer.getPosition();
/* 210 */             ApplicableRegionSet set = rm.getApplicableRegions(pt);
/* 211 */             if (set.size() == 0)
/*     */             {
/* 213 */               p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao esta encima de nenhuma region");
/* 214 */               return true;
/*     */             }
/* 216 */             String id = ((ProtectedRegion)set.iterator().next()).getId();
/* 217 */             ProtectedRegion region = rm.getRegion(id);
/* 218 */             if (region.isOwner(p.getName()))
/*     */             {
/* 220 */               DefaultDomain membros = region.getMembers();
/* 221 */               membros.addPlayer(amigo);
/* 222 */               region.setMembers(membros);
/*     */               try
/*     */               {
/* 225 */                 rm.save();
/*     */               }
/*     */               catch (Exception e) {
/* 228 */                 e.printStackTrace();
/*     */               }
/*     */               
/*     */ 
/* 232 */               sender.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Foi adicionado o seguinte amigo no seu terreno: " + amigo);
/* 233 */               return true;
/*     */             }
/* 235 */             p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao e dono desta region");
/* 236 */             return true;
/*     */           }
/* 238 */           sender.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Seu amigo nao pode ser voce");
/* 239 */           return true;
/*     */         }
/*     */         
/* 242 */         sender.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Sem permissao");
/* 243 */         return true;
/*     */       }
/* 245 */       if (args[0].equalsIgnoreCase("removeramigo"))
/*     */       {
/* 247 */         if (sender.hasPermission("rlife.usar"))
/*     */         {
/* 249 */           if (args.length != 2)
/*     */           {
/* 251 */             sender.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Utilize /rlife removeramigo [nick] -> DENTRO DO TERRENO");
/* 252 */             return true;
/*     */           }
/* 254 */           String amigo = args[1];
/* 255 */           Player p = (Player)sender;
/* 256 */           if (!amigo.equalsIgnoreCase(p.getName()))
/*     */           {
/* 258 */             World mundo = p.getWorld();
/* 259 */             RegionManager rm = WGBukkit.getRegionManager(mundo);
/* 260 */             Location local = p.getLocation();
/* 261 */             LocalPlayer localPlayer = getWorldGuard().wrapPlayer(p);
/* 262 */             Vector pt = localPlayer.getPosition();
/* 263 */             ApplicableRegionSet set = rm.getApplicableRegions(pt);
/* 264 */             if (set.size() == 0)
/*     */             {
/* 266 */               p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao esta encima de nenhuma region");
/* 267 */               return true;
/*     */             }
/* 269 */             String id = ((ProtectedRegion)set.iterator().next()).getId();
/* 270 */             ProtectedRegion region = rm.getRegion(id);
/* 271 */             if (region.isOwner(p.getName()))
/*     */             {
/* 273 */               DefaultDomain membros = region.getMembers();
/* 274 */               if (membros.contains(amigo)) {
/* 275 */                 membros.removePlayer(amigo);
/* 276 */                 region.setMembers(membros);
/*     */                 try
/*     */                 {
/* 279 */                   rm.save();
/*     */                 }
/*     */                 catch (Exception e) {
/* 282 */                   e.printStackTrace();
/*     */                 }
/*     */                 
/*     */ 
/*     */ 
/* 287 */                 sender.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Foi removido o seguinte amigo no seu terreno: " + amigo);
/* 288 */                 return true;
/*     */               }
/* 290 */               sender.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Esse player nao e amigo em seu terreno");
/* 291 */               return true;
/*     */             }
/*     */             
/* 294 */             p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao e dono desta region");
/* 295 */             return true;
/*     */           }
/* 297 */           sender.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Seu amigo nao pode ser voce");
/* 298 */           return true;
/*     */         }
/*     */         
/* 301 */         sender.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Sem permissao");
/* 302 */         return true;
/*     */       }
/* 304 */       if (args[0].equalsIgnoreCase("amigos"))
/*     */       {
/* 306 */         if (sender.hasPermission("rlife.usar"))
/*     */         {
/* 308 */           Player p = (Player)sender;
/* 309 */           World mundo = p.getWorld();
/* 310 */           RegionManager rm = WGBukkit.getRegionManager(mundo);
/* 311 */           Location local = p.getLocation();
/* 312 */           LocalPlayer localPlayer = getWorldGuard().wrapPlayer(p);
/* 313 */           Vector pt = localPlayer.getPosition();
/* 314 */           ApplicableRegionSet set = rm.getApplicableRegions(pt);
/* 315 */           if (set.size() == 0)
/*     */           {
/* 317 */             p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao esta encima de nenhuma region");
/* 318 */             return true;
/*     */           }
/* 320 */           String id = ((ProtectedRegion)set.iterator().next()).getId();
/* 321 */           ProtectedRegion region = rm.getRegion(id);
/* 322 */           if (region.isOwner(p.getName()))
/*     */           {
/* 324 */             DefaultDomain membros = region.getMembers();
/* 325 */             sender.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Amigos atuais da sua area: " + membros.toPlayersString());
/* 326 */             return true;
/*     */           }
/* 328 */           p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao e dono desta region");
/* 329 */           return true;
/*     */         }
/* 331 */         sender.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Sem permissao");
/* 332 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 336 */     return false;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerInteract(PlayerInteractEvent ev)
/*     */   {
/* 342 */     if (ev.getAction() == Action.RIGHT_CLICK_BLOCK)
/*     */     {
/* 344 */       Block b = ev.getClickedBlock();
/* 345 */       if ((b.getType() == Material.SIGN_POST) || (b.getType() == Material.WALL_SIGN))
/*     */       {
/* 347 */         Sign s = (Sign) b.getState();
/* 348 */         if (s.getLine(0).equalsIgnoreCase(ChatColor.DARK_GREEN + "[Comprar]"))
/*     */         {
/* 350 */           Player p = ev.getPlayer();
/* 351 */           String pname = ev.getPlayer().getName();
/* 352 */           World mundo = ev.getPlayer().getWorld();
/* 353 */           RegionManager rm = WGBukkit.getRegionManager(mundo);
/* 354 */           String regionName = s.getLine(1);
/* 355 */           if (rm.getRegion(regionName) != null)
/*     */           {
/* 357 */             if ((!getConfig().getList("donosdeterrenos").contains(pname)) || (!getConfig().getBoolean("LimiteDeUmTerrenoPorPlayer")))
/*     */             {
/* 359 */               int preco = Integer.parseInt(s.getLine(2));
/* 360 */               if (this.economia.getBalance(pname) >= preco)
/*     */               {
/* 362 */                 if (p.hasPermission("rlife.usar"))
/*     */                 {
/* 364 */                   List donosdeterrenos = getConfig().getList("donosdeterrenos");
/* 365 */                   if (!donosdeterrenos.contains(pname)) {
/* 366 */                     donosdeterrenos.add(pname);
/* 367 */                     getConfig().set("donosdeterrenos", donosdeterrenos);
/* 368 */                     saveConfig();
/*     */                   }
/* 370 */                   DefaultDomain dd = new DefaultDomain();
/* 371 */                   dd.addPlayer(pname);
/* 372 */                   ProtectedRegion region = rm.getRegion(regionName);
/* 373 */                   p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Terreno comprado com sucesso!");
/* 374 */                   this.economia.withdrawPlayer(pname, preco);
/* 375 */                   region.setOwners(dd);
/*     */                   try
/*     */                   {
/* 378 */                     rm.save();
/*     */                   }
/*     */                   catch (Exception e)
/*     */                   {
/* 382 */                     System.out.print("Deu ruim");
/*     */                   }
/* 384 */                   s.setLine(0, ChatColor.RED + "[Vendido]");
/* 385 */                   s.setLine(1, ChatColor.BLACK + "Dono");
/* 386 */                   s.setLine(2, ChatColor.BLACK + ev.getPlayer().getName());
/* 387 */                   s.setLine(3, "");
/* 388 */                   s.update();
/*     */                 }
/*     */                 else
/*     */                 {
/* 392 */                   p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Sem permissao!");
/*     */                 }
/*     */               }
/*     */               else {
/* 396 */                 p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce nao tem dinheiro suficiente!");
/*     */               }
/*     */             }
/*     */             else
/*     */             {
/* 401 */               p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Voce ja possui um terreno!!");
/*     */             }
/*     */           }
/*     */           else {
/* 405 */             p.sendMessage(ChatColor.GREEN+"[RLife] "+ChatColor.WHITE+"Region Invalida!!");
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Diego\Desktop\BCity.jar!\com\bernardopmbr\bcity\Principal.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */