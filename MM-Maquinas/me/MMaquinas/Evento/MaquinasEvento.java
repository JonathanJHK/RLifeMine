/*      */ package me.MMaquinas.Evento;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Random;
/*      */ import me.MMaquinas.Main;
/*      */ import me.MMaquinas.Utils.Strings;
/*      */ import net.milkbowl.vault.economy.Economy;
/*      */ import org.bukkit.Bukkit;
/*      */ import org.bukkit.Location;
/*      */ import org.bukkit.Material;
/*      */ import org.bukkit.World;
/*      */ import org.bukkit.block.Block;
/*      */ import org.bukkit.command.ConsoleCommandSender;
/*      */ import org.bukkit.configuration.file.FileConfiguration;
/*      */ import org.bukkit.enchantments.Enchantment;
/*      */ import org.bukkit.entity.ArmorStand;
/*      */ import org.bukkit.entity.LivingEntity;
/*      */ import org.bukkit.entity.Player;
/*      */ import org.bukkit.event.EventHandler;
/*      */ import org.bukkit.event.block.BlockBreakEvent;
/*      */ import org.bukkit.event.block.BlockPlaceEvent;
/*      */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*      */ import org.bukkit.event.inventory.InventoryClickEvent;
/*      */ import org.bukkit.event.inventory.InventoryOpenEvent;
/*      */ import org.bukkit.event.inventory.InventoryType;
/*      */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*      */ import org.bukkit.event.player.PlayerInteractEvent;
/*      */ import org.bukkit.inventory.Inventory;
/*      */ import org.bukkit.inventory.ItemStack;
/*      */ import org.bukkit.inventory.PlayerInventory;
/*      */ import org.bukkit.inventory.meta.ItemMeta;
/*      */ import org.bukkit.plugin.Plugin;
/*      */ import org.bukkit.scheduler.BukkitRunnable;
/*      */ 
/*      */ public class MaquinasEvento implements org.bukkit.event.Listener
/*      */ {
/*   37 */   int quebrados = 0;
/*      */   
/*   39 */   static ItemStack petroleo = new ItemStack(Material.FLINT); static ItemMeta pm = petroleo.getItemMeta();
/*      */   
/*   41 */   static ItemStack eta = new ItemStack(Material.COAL, 1, (short)1); static ItemMeta em = eta.getItemMeta();
/*   42 */   static ItemStack gas = new ItemStack(Material.COAL, 1, (short)1); static ItemMeta gm = gas.getItemMeta();
/*   43 */   static ItemStack die = new ItemStack(Material.COAL, 1, (short)1); static ItemMeta dm = die.getItemMeta();
/*   44 */   static ItemStack gn = new ItemStack(Material.getMaterial(373), 1, (short)0); static ItemMeta gnm = gn.getItemMeta();
/*      */   
/*      */   public void darPetroleo(Player p) {
/*   47 */     pm.setDisplayName("§0Petróleo");
/*   48 */     ArrayList<String> desc = new ArrayList();
/*   49 */     desc.add("§7Tipo: §f?");
/*   50 */     desc.add("§7Duração: §f1 M");
/*   51 */     pm.setLore(desc);
/*   52 */     petroleo.setItemMeta(pm);
/*      */     
/*   54 */     p.sendMessage(Strings.acharpetroleo);
/*   55 */     p.getInventory().addItem(new ItemStack[] { petroleo });
/*      */   }
/*      */   
/*      */   public void darEta(Player p) {
/*   59 */     em.setDisplayName("§4Combustivel I");
/*   60 */     ArrayList<String> desc = new ArrayList();
/*   61 */     desc.add("§7Tipo: §fETANOL");
/*   62 */     desc.add("§7Duração: §f1 M");
/*   63 */     em.setLore(desc);
/*   64 */     eta.setItemMeta(em);
/*      */     
/*   66 */     p.sendMessage(Strings.acharpetroleo);
/*   67 */     p.getInventory().addItem(new ItemStack[] { eta });
/*      */   }
/*      */   
/*      */   public void darGas(Player p) {
/*   71 */     gm.setDisplayName("§4Combustivel II");
/*   72 */     ArrayList<String> desc1 = new ArrayList();
/*   73 */     desc1.add("§7Tipo: §fGASOSA");
/*   74 */     desc1.add("§7Duração: §f5 M");
/*   75 */     gm.setLore(desc1);
/*   76 */     gas.setItemMeta(gm);
/*      */     
/*   78 */     p.sendMessage(Strings.acharpetroleo);
/*   79 */     p.getInventory().addItem(new ItemStack[] { gas });
/*      */   }
/*      */   
/*      */   public void darDie(Player p) {
/*   83 */     dm.setDisplayName("§4Combustivel III");
/*   84 */     ArrayList<String> desc2 = new ArrayList();
/*   85 */     desc2.add("§7Tipo: §fDIESEL");
/*   86 */     desc2.add("§7Duração: §f25 M");
/*   87 */     dm.setLore(desc2);
/*   88 */     die.setItemMeta(dm);
/*      */     
/*   90 */     p.sendMessage(Strings.acharpetroleo);
/*   91 */     p.getInventory().addItem(new ItemStack[] { die });
/*      */   }
/*      */   
/*      */   public void createNewArmorStand(Block e, String name) {
/*   95 */     ArmorStand am = (ArmorStand)e.getWorld().spawnEntity(e.getLocation().add(0.5D, -1.0D, 0.5D), 
/*   96 */       org.bukkit.entity.EntityType.ARMOR_STAND);
/*   97 */     am.setSmall(true);
/*   98 */     am.setVisible(true);
/*   99 */     am.setGravity(false);
/*  100 */     am.setCustomNameVisible(false);
/*  101 */     am.setCustomName(name);
/*      */   }
/*      */   
/*  104 */   public LivingEntity getAmorStand(Block block) { for (org.bukkit.entity.Entity e : block.getWorld().getNearbyEntities(block.getLocation().add(0.5D, -1.0D, 0.5D), 0.2D, 0.1D, 
/*  105 */       0.2D)) {
/*  106 */       if (e.getType() == org.bukkit.entity.EntityType.ARMOR_STAND) {
/*  107 */         return (LivingEntity)e;
/*      */       }
/*      */     }
/*  110 */     return null;
/*      */   }
/*      */   
/*      */   @EventHandler
/*      */   public void QuebrarArmor(EntityDamageByEntityEvent e) {
/*  115 */     org.bukkit.entity.Entity am = e.getEntity();
/*  116 */     if ((am instanceof ArmorStand)) {
/*  117 */       e.setCancelled(true);
/*      */     }
/*      */   }
/*      */   
/*      */   @EventHandler
/*      */   public void aoQuebrar(BlockBreakEvent e) {
/*  123 */     Player p = e.getPlayer();
/*  124 */     this.quebrados += 1;
/*  125 */     if ((!e.getBlock().getType().equals(Material.LAPIS_ORE)) && (!e.getBlock().getType().equals(Material.GOLD_ORE)) && (!e.getBlock().getType().equals(Material.IRON_ORE)) && (!e.getBlock().getType().equals(Material.REDSTONE_ORE)) && (!e.getBlock().getType().equals(Material.COAL_ORE)) && 
/*  126 */       (!e.getBlock().getType().equals(Material.EMERALD_ORE)) && (!e.getBlock().getType().equals(Material.DIAMOND_ORE)) && (!e.getBlock().getType().equals(Material.OBSIDIAN)) && (!e.getBlock().getType().equals(Material.STONE))) {
/*  127 */       return;
/*      */     }
/*      */     
/*  130 */     if (this.quebrados == Strings.BlocosQuebrados) {
/*  131 */       this.quebrados = 0;
/*  132 */       boolean ver1 = Strings.EtaisFalse();
/*  133 */       boolean ver2 = Strings.GasisFalse();
/*  134 */       boolean ver3 = Strings.DieisFalse();
/*  135 */       Random r = new Random();
/*  136 */       int i = r.nextInt(11);
/*  137 */       switch (i) {
/*      */       case 0: 
/*  139 */         if ((e.getBlock().getType().equals(Material.OBSIDIAN)) || (e.getBlock().getType().equals(Material.EMERALD_ORE)) || (e.getBlock().getType().equals(Material.GOLD_ORE))) {
/*  140 */           darPetroleo(p);
/*      */         }
/*  142 */         return;
/*      */       case 1: 
/*  144 */         if ((e.getBlock().getType().equals(Material.OBSIDIAN)) || (e.getBlock().getType().equals(Material.EMERALD_ORE)) || (e.getBlock().getType().equals(Material.GOLD_ORE))) {
/*  145 */           if (!ver1) {
/*  146 */             darEta(p);
/*      */           } else {
/*  148 */             darPetroleo(p);
/*      */           }
/*      */         }
/*  151 */         return;
/*      */       case 2: 
/*      */         
/*      */       case 3: 
/*      */         
/*      */       case 4: 
/*      */         
/*      */       case 5: 
/*      */         
/*      */       case 6: 
/*      */         
/*      */       case 7: 
/*  163 */         if ((e.getBlock().getType().equals(Material.OBSIDIAN)) || (e.getBlock().getType().equals(Material.EMERALD_ORE)) || (e.getBlock().getType().equals(Material.GOLD_ORE))) {
/*  164 */           if (!ver2) {
/*  165 */             darGas(p);
/*      */           } else {
/*  167 */             darPetroleo(p);
/*      */           }
/*      */         }
/*  170 */         return;
/*      */       case 8: 
/*  172 */         if ((e.getBlock().getType().equals(Material.OBSIDIAN)) || (e.getBlock().getType().equals(Material.EMERALD_ORE)) || (e.getBlock().getType().equals(Material.GOLD_ORE)) || (e.getBlock().getType().equals(Material.EMERALD_ORE)) || (e.getBlock().getType().equals(Material.REDSTONE_ORE))) {
/*  173 */           darPetroleo(p);
/*      */         }
/*  175 */         return;
/*      */       case 9: 
/*  177 */         if ((e.getBlock().getType().equals(Material.OBSIDIAN)) || (e.getBlock().getType().equals(Material.EMERALD_ORE)) || (e.getBlock().getType().equals(Material.IRON_ORE)) || (e.getBlock().getType().equals(Material.EMERALD_ORE)) || (e.getBlock().getType().equals(Material.GOLD_ORE))) {
/*  178 */           darPetroleo(p);
/*      */         }
/*  180 */         return;
/*      */       case 10: 
/*  182 */         if (!ver3) {
/*  183 */           darDie(p);
/*      */         } else {
/*  185 */           darPetroleo(p);
/*      */         }
/*  187 */         return;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   @EventHandler
/*      */   public void colocarMaquinas(BlockPlaceEvent e) {
/*  194 */     Player p = e.getPlayer();
/*      */     try {
/*  196 */       if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Strings.RefinariaNome)) {
/*  197 */         if (Main.getPlugin().getConfig().getInt("Limite de Maquinas para Player Normais (0 para False)") != 0) {
/*  198 */           if (!p.hasPermission(Strings.PermLimite)) {
/*  199 */             if (Strings.Limite <= Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName())) {
/*  200 */               e.setCancelled(true);
/*  201 */               p.sendMessage(Strings.ntotal);
/*      */             }
/*      */             
/*      */           }
/*  205 */           else if ((Main.getPlugin().getConfig().getInt("Limite de Maquinas para Player Vips (0 para False)") != 0) && 
/*  206 */             (Strings.LimiteVip <= Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()))) {
/*  207 */             e.setCancelled(true);
/*  208 */             p.sendMessage(Strings.ntotal);
/*  209 */             return;
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*  214 */         createNewArmorStand(e.getBlock(), "REFINARIA");
/*  215 */         p.sendMessage(Strings.ColocarMaquina);
/*  216 */         Main.getPlugin().getConfig().set("Maquinas de " + p.getName(), Integer.valueOf(Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()) + 1));
/*  217 */         Main.getPlugin().saveConfig();
/*      */       }
/*  219 */       if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Strings.Maquina1Nome)) {
/*  220 */         if (Main.getPlugin().getConfig().getInt("Limite de Maquinas para Player Normais (0 para False)") != 0) {
/*  221 */           if (!p.hasPermission(Strings.PermLimite)) {
/*  222 */             if (Strings.Limite <= Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName())) {
/*  223 */               e.setCancelled(true);
/*  224 */               p.sendMessage(Strings.ntotal);
/*      */             }
/*      */             
/*      */           }
/*  228 */           else if ((Main.getPlugin().getConfig().getInt("Limite de Maquinas para Player Vips (0 para False)") != 0) && 
/*  229 */             (Strings.LimiteVip <= Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()))) {
/*  230 */             e.setCancelled(true);
/*  231 */             p.sendMessage(Strings.ntotal);
/*  232 */             return;
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*  237 */         createNewArmorStand(e.getBlock(), "MAQUINA1");
/*  238 */         p.sendMessage(Strings.ColocarMaquina);
/*  239 */         Main.getPlugin().getConfig().set("Maquinas de " + p.getName(), Integer.valueOf(Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()) + 1));
/*  240 */         Main.getPlugin().saveConfig();
/*      */       }
/*  242 */       if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Strings.Maquina2Nome)) {
/*  243 */         if (Main.getPlugin().getConfig().getInt("Limite de Maquinas para Player Normais (0 para False)") != 0) {
/*  244 */           if (!p.hasPermission(Strings.PermLimite)) {
/*  245 */             if (Strings.Limite <= Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName())) {
/*  246 */               e.setCancelled(true);
/*  247 */               p.sendMessage(Strings.ntotal);
/*      */             }
/*      */             
/*      */           }
/*  251 */           else if ((Main.getPlugin().getConfig().getInt("Limite de Maquinas para Player Vips (0 para False)") != 0) && 
/*  252 */             (Strings.LimiteVip <= Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()))) {
/*  253 */             e.setCancelled(true);
/*  254 */             p.sendMessage(Strings.ntotal);
/*  255 */             return;
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*  260 */         createNewArmorStand(e.getBlock(), "MAQUINA2");
/*  261 */         p.sendMessage(Strings.ColocarMaquina);
/*  262 */         Main.getPlugin().getConfig().set("Maquinas de " + p.getName(), Integer.valueOf(Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()) + 1));
/*  263 */         Main.getPlugin().saveConfig();
/*      */       }
/*  265 */       if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Strings.Maquina5Nome)) {
/*  266 */         if (Main.getPlugin().getConfig().getInt("Limite de Maquinas para Player Normais (0 para False)") != 0) {
/*  267 */           if (!p.hasPermission(Strings.PermLimite)) {
/*  268 */             if (Strings.Limite <= Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName())) {
/*  269 */               e.setCancelled(true);
/*  270 */               p.sendMessage(Strings.ntotal);
/*      */             }
/*      */             
/*      */           }
/*  274 */           else if ((Main.getPlugin().getConfig().getInt("Limite de Maquinas para Player Vips (0 para False)") != 0) && 
/*  275 */             (Strings.LimiteVip <= Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()))) {
/*  276 */             e.setCancelled(true);
/*  277 */             p.sendMessage(Strings.ntotal);
/*  278 */             return;
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*  283 */         createNewArmorStand(e.getBlock(), "MAQUINA5");
/*  284 */         p.sendMessage(Strings.ColocarMaquina);
/*  285 */         Main.getPlugin().getConfig().set("Maquinas de " + p.getName(), Integer.valueOf(Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()) + 1));
/*  286 */         Main.getPlugin().saveConfig();
/*      */       }
/*  288 */       if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Strings.Maquina3Nome)) {
/*  289 */         if (Main.getPlugin().getConfig().getInt("Limite de Maquinas para Player Normais (0 para False)") != 0) {
/*  290 */           if (!p.hasPermission(Strings.PermLimite)) {
/*  291 */             if (Strings.Limite <= Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName())) {
/*  292 */               e.setCancelled(true);
/*  293 */               p.sendMessage(Strings.ntotal);
/*      */             }
/*      */             
/*      */           }
/*  297 */           else if ((Main.getPlugin().getConfig().getInt("Limite de Maquinas para Player Vips (0 para False)") != 0) && 
/*  298 */             (Strings.LimiteVip <= Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()))) {
/*  299 */             e.setCancelled(true);
/*  300 */             p.sendMessage(Strings.ntotal);
/*  301 */             return;
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*  306 */         createNewArmorStand(e.getBlock(), "MAQUINA3");
/*  307 */         p.sendMessage(Strings.ColocarMaquina);
/*  308 */         Main.getPlugin().getConfig().set("Maquinas de " + p.getName(), Integer.valueOf(Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()) + 1));
/*  309 */         Main.getPlugin().saveConfig();
/*      */       }
/*  311 */       if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Strings.Maquina4Nome)) {
/*  312 */         if (Main.getPlugin().getConfig().getInt("Limite de Maquinas para Player Normais (0 para False)") != 0) {
/*  313 */           if (!p.hasPermission(Strings.PermLimite)) {
/*  314 */             if (Strings.Limite <= Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName())) {
/*  315 */               e.setCancelled(true);
/*  316 */               p.sendMessage(Strings.ntotal);
/*      */             }
/*      */             
/*      */           }
/*  320 */           else if ((Main.getPlugin().getConfig().getInt("Limite de Maquinas para Player Vips (0 para False)") != 0) && 
/*  321 */             (Strings.LimiteVip <= Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()))) {
/*  322 */             e.setCancelled(true);
/*  323 */             p.sendMessage(Strings.ntotal);
/*  324 */             return;
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*  329 */         createNewArmorStand(e.getBlock(), "MAQUINA4");
/*  330 */         p.sendMessage(Strings.ColocarMaquina);
/*  331 */         Main.getPlugin().getConfig().set("Maquinas de " + p.getName(), Integer.valueOf(Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()) + 1));
/*  332 */         Main.getPlugin().saveConfig();
/*      */       }
/*  334 */       if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Strings.Maquina6Nome)) {
/*  335 */         if (Main.getPlugin().getConfig().getInt("Limite de Maquinas para Player Normais (0 para False)") != 0) {
/*  336 */           if (!p.hasPermission(Strings.PermLimite)) {
/*  337 */             if (Strings.Limite <= Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName())) {
/*  338 */               e.setCancelled(true);
/*  339 */               p.sendMessage(Strings.ntotal);
/*      */             }
/*      */             
/*      */           }
/*  343 */           else if ((Main.getPlugin().getConfig().getInt("Limite de Maquinas para Player Vips (0 para False)") != 0) && 
/*  344 */             (Strings.LimiteVip <= Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()))) {
/*  345 */             e.setCancelled(true);
/*  346 */             p.sendMessage(Strings.ntotal);
/*  347 */             return;
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*  352 */         createNewArmorStand(e.getBlock(), "MAQUINA6");
/*  353 */         p.sendMessage(Strings.ColocarMaquina);
/*  354 */         Main.getPlugin().getConfig().set("Maquinas de " + p.getName(), Integer.valueOf(Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()) + 1));
/*  355 */         Main.getPlugin().saveConfig();
/*      */       }
/*      */     }
/*      */     catch (Exception localException) {}
/*      */   }
/*      */   
/*      */ 
/*  362 */   ArrayList<Location> quebrar = new ArrayList();
/*      */   
/*      */   @EventHandler
/*      */   public void quebrarMachine(BlockBreakEvent e) {
/*  366 */     Player p = e.getPlayer();
/*  367 */     LivingEntity ev = getAmorStand(e.getBlock());
/*  368 */     ItemStack Maquina1 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina1Bloco).intValue()));ItemMeta Maquina1Meta = Maquina1.getItemMeta();
/*  369 */     ItemStack Maquina2 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina2Bloco).intValue()));ItemMeta Maquina2Meta = Maquina2.getItemMeta();
/*  370 */     ItemStack Maquina5 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina5Bloco).intValue()));ItemMeta Maquina5Meta = Maquina5.getItemMeta();
/*  371 */     ItemStack Maquina4 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina4Bloco).intValue()));ItemMeta Maquina4Meta = Maquina4.getItemMeta();
/*  372 */     ItemStack Maquina3 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina3Bloco).intValue()));ItemMeta Maquina3Meta = Maquina3.getItemMeta();
/*  373 */     ItemStack Maquina6 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina6Bloco).intValue()));ItemMeta Maquina6Meta = Maquina6.getItemMeta();
/*  374 */     ItemStack Refinaria = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.RefinariaBloco).intValue()));ItemMeta Refinaria1Meta = Refinaria.getItemMeta();
/*  375 */     if (ev != null) {
/*  376 */       if (ev.getCustomName().equalsIgnoreCase("REFINARIA")) {
/*  377 */         String name = p.getItemInHand().getType().name();
/*  378 */         if (andamentoRefinaria.contains(e.getBlock().getLocation())) {
/*  379 */           p.sendMessage(Strings.semquebrar);
/*  380 */           e.setCancelled(true);
/*  381 */           if (this.quebrar.contains(e.getBlock().getLocation()))
/*      */           {
/*  383 */             return;
/*      */           }
/*  385 */           return;
/*      */         }
/*  387 */         if (name.contains("_PICKAXE")) {
/*  388 */           if (p.getInventory().getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
/*  389 */             this.quebrar.add(e.getBlock().getLocation());
/*  390 */             this.quebrar.remove(p);
/*  391 */             p.closeInventory();
/*  392 */             e.setCancelled(true);
/*  393 */             Refinaria1Meta.setDisplayName(Strings.RefinariaNome);
/*  394 */             ArrayList<String> desc = new ArrayList();
/*  395 */             desc.add("§7Tipo: " + Strings.RefinariaTipo);
/*  396 */             Refinaria1Meta.setLore(desc);
/*  397 */             Refinaria.setItemMeta(Refinaria1Meta);
/*  398 */             ev.remove();
/*  399 */             p.sendMessage(Strings.RemoverMaquina);
/*  400 */             p.getInventory().addItem(new ItemStack[] { Refinaria });
/*  401 */             Main.getPlugin().getConfig().set("Maquinas de " + p.getName(), Integer.valueOf(Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()) - 1));
/*  402 */             Main.getPlugin().saveConfig();
/*  403 */             e.getBlock().setType(Material.AIR);
/*      */           } else {
/*  405 */             e.setCancelled(true);
/*  406 */             p.sendMessage(Strings.Tag + "§cVocê não pode quebrar isso sem uma picareta Encantada com SilkTouch!");
/*  407 */             return;
/*      */           }
/*      */         }
/*  410 */         ev.remove();
/*      */       }
/*  412 */       if (ev.getCustomName().equalsIgnoreCase("MAQUINA1")) {
/*  413 */         String name = p.getItemInHand().getType().name();
/*  414 */         if (andamentoMaquina1.contains(e.getBlock().getLocation())) {
/*  415 */           p.sendMessage(Strings.semquebrar);
/*  416 */           e.setCancelled(true);
/*      */           
/*  418 */           return;
/*      */         }
/*  420 */         if (name.contains("_PICKAXE")) {
/*  421 */           if (p.getInventory().getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
/*  422 */             e.setCancelled(true);
/*  423 */             e.getBlock().setType(Material.AIR);
/*  424 */             p.closeInventory();
/*  425 */             Maquina1Meta.setDisplayName(Strings.Maquina1Nome);
/*  426 */             ArrayList<String> desc = new ArrayList();
/*  427 */             desc.add("§7Tipo: " + Strings.Maquina1Tipo);
/*  428 */             Maquina1Meta.setLore(desc);
/*  429 */             Maquina1.setItemMeta(Maquina1Meta);
/*  430 */             p.getInventory().addItem(new ItemStack[] { Maquina1 });
/*  431 */             ev.remove();
/*  432 */             p.sendMessage(Strings.RemoverMaquina);
/*  433 */             Main.getPlugin().getConfig().set("Maquinas de " + p.getName(), Integer.valueOf(Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()) + 1));
/*  434 */             Main.getPlugin().saveConfig();
/*      */           } else {
/*  436 */             e.setCancelled(true);
/*  437 */             p.sendMessage(Strings.Tag + "§cVocê não pode quebrar isso sem uma picareta Encantada com SilkTouch!");
/*  438 */             return;
/*      */           }
/*      */         }
/*  441 */         ev.remove();
/*      */       }
/*  443 */       if (ev.getCustomName().equalsIgnoreCase("MAQUINA2")) {
/*  444 */         String name = p.getItemInHand().getType().name();
/*  445 */         if (andamentoMaquina2.contains(e.getBlock().getLocation())) {
/*  446 */           p.sendMessage(Strings.semquebrar);
/*  447 */           e.setCancelled(true);
/*      */           
/*  449 */           return;
/*      */         }
/*  451 */         if (name.contains("_PICKAXE")) {
/*  452 */           if (p.getInventory().getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
/*  453 */             e.setCancelled(true);e.getBlock().setType(Material.AIR);
/*  454 */             p.closeInventory();
/*  455 */             Maquina2Meta.setDisplayName(Strings.Maquina2Nome);
/*  456 */             ArrayList<String> desc = new ArrayList();
/*  457 */             desc.add("§7Tipo: " + Strings.Maquina2Tipo);
/*  458 */             Maquina2Meta.setLore(desc);
/*  459 */             Maquina2.setItemMeta(Maquina2Meta);
/*  460 */             p.getInventory().addItem(new ItemStack[] { Maquina2 });
/*  461 */             ev.remove();
/*  462 */             p.sendMessage(Strings.RemoverMaquina);
/*  463 */             Main.getPlugin().getConfig().set("Maquinas de " + p.getName(), Integer.valueOf(Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()) + 1));
/*  464 */             Main.getPlugin().saveConfig();
/*      */           }
/*      */           else {
/*  467 */             e.setCancelled(true);
/*  468 */             p.sendMessage(Strings.Tag + "§cVocê não pode quebrar isso sem uma picareta Encantada com SilkTouch!");
/*  469 */             return;
/*      */           }
/*      */         }
/*  472 */         ev.remove();
/*      */       }
/*  474 */       if (ev.getCustomName().equalsIgnoreCase("MAQUINA5")) {
/*  475 */         String name = p.getItemInHand().getType().name();
/*  476 */         if (andamentoMaquina5.contains(e.getBlock().getLocation())) {
/*  477 */           p.sendMessage(Strings.semquebrar);
/*  478 */           e.setCancelled(true);
/*      */           
/*  480 */           return;
/*      */         }
/*  482 */         if ((name.contains("_PICKAXE")) && 
/*  483 */           (p.getInventory().getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH))) {
/*  484 */           e.setCancelled(true);e.getBlock().setType(Material.AIR);
/*  485 */           p.closeInventory();
/*  486 */           Maquina5Meta.setDisplayName(Strings.Maquina5Nome);
/*  487 */           ArrayList<String> desc = new ArrayList();
/*  488 */           desc.add("§7Tipo: " + Strings.Maquina5Tipo);
/*  489 */           Maquina5Meta.setLore(desc);
/*  490 */           Maquina5.setItemMeta(Maquina5Meta);
/*  491 */           p.getInventory().addItem(new ItemStack[] { Maquina5 });
/*  492 */           ev.remove();
/*  493 */           p.sendMessage(Strings.RemoverMaquina);
/*  494 */           Main.getPlugin().getConfig().set("Maquinas de " + p.getName(), Integer.valueOf(Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()) + 1));
/*  495 */           Main.getPlugin().saveConfig();
/*      */         }
/*      */         
/*  498 */         ev.remove();
/*      */       }
/*  500 */       if (ev.getCustomName().equalsIgnoreCase("MAQUINA3")) {
/*  501 */         String name = p.getItemInHand().getType().name();
/*  502 */         if (andamentoMaquina3.contains(e.getBlock().getLocation())) {
/*  503 */           p.sendMessage(Strings.semquebrar);
/*  504 */           e.setCancelled(true);
/*      */           
/*  506 */           return;
/*      */         }
/*  508 */         if (name.contains("_PICKAXE")) {
/*  509 */           if (p.getInventory().getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
/*  510 */             e.setCancelled(true);e.getBlock().setType(Material.AIR);
/*  511 */             p.closeInventory();
/*  512 */             Maquina3Meta.setDisplayName(Strings.Maquina3Nome);
/*  513 */             ArrayList<String> desc = new ArrayList();
/*  514 */             desc.add("§7Tipo: " + Strings.Maquina3Tipo);
/*  515 */             Maquina3Meta.setLore(desc);
/*  516 */             Maquina3.setItemMeta(Maquina3Meta);
/*  517 */             p.getInventory().addItem(new ItemStack[] { Maquina3 });
/*  518 */             ev.remove();
/*  519 */             p.sendMessage(Strings.RemoverMaquina);
/*  520 */             Main.getPlugin().getConfig().set("Maquinas de " + p.getName(), Integer.valueOf(Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()) + 1));
/*  521 */             Main.getPlugin().saveConfig();
/*      */           } else {
/*  523 */             e.setCancelled(true);
/*  524 */             p.sendMessage(Strings.Tag + "§cVocê não pode quebrar isso sem uma picareta Encantada com SilkTouch!");
/*  525 */             return;
/*      */           }
/*      */         }
/*  528 */         ev.remove();
/*      */       }
/*  530 */       if (ev.getCustomName().equalsIgnoreCase("MAQUINA4")) {
/*  531 */         String name = p.getItemInHand().getType().name();
/*  532 */         if (andamentoMaquina4.contains(e.getBlock().getLocation())) {
/*  533 */           p.sendMessage(Strings.semquebrar);
/*  534 */           e.setCancelled(true);
/*      */           
/*  536 */           return;
/*      */         }
/*  538 */         if (name.contains("_PICKAXE")) {
/*  539 */           if (p.getInventory().getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
/*  540 */             e.setCancelled(true);e.getBlock().setType(Material.AIR);
/*  541 */             p.closeInventory();
/*  542 */             Maquina4Meta.setDisplayName(Strings.Maquina4Nome);
/*  543 */             ArrayList<String> desc = new ArrayList();
/*  544 */             desc.add("§7Tipo: " + Strings.Maquina4Tipo);
/*  545 */             Maquina4Meta.setLore(desc);
/*  546 */             Maquina4.setItemMeta(Maquina4Meta);
/*  547 */             p.getInventory().addItem(new ItemStack[] { Maquina4 });
/*  548 */             ev.remove();
/*  549 */             p.sendMessage(Strings.RemoverMaquina);
/*  550 */             Main.getPlugin().getConfig().set("Maquinas de " + p.getName(), Integer.valueOf(Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()) + 1));
/*  551 */             Main.getPlugin().saveConfig();
/*      */           } else {
/*  553 */             e.setCancelled(true);
/*  554 */             p.sendMessage(Strings.Tag + "§cVocê não pode quebrar isso sem uma picareta Encantada com SilkTouch!");
/*  555 */             return;
/*      */           }
/*      */         }
/*  558 */         ev.remove();
/*      */       }
/*  560 */       if (ev.getCustomName().equalsIgnoreCase("MAQUINA6")) {
/*  561 */         String name = p.getItemInHand().getType().name();
/*  562 */         if (andamentoMaquina6.contains(e.getBlock().getLocation())) {
/*  563 */           p.sendMessage(Strings.semquebrar);
/*  564 */           e.setCancelled(true);
/*      */           
/*  566 */           return;
/*      */         }
/*  568 */         if (name.contains("_PICKAXE")) {
/*  569 */           if (p.getInventory().getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
/*  570 */             e.setCancelled(true);e.getBlock().setType(Material.AIR);
/*  571 */             p.closeInventory();
/*  572 */             Maquina6Meta.setDisplayName(Strings.Maquina6Nome);
/*  573 */             ArrayList<String> desc = new ArrayList();
/*  574 */             desc.add("§7Tipo: " + Strings.Maquina6Tipo);
/*  575 */             Maquina6Meta.setLore(desc);
/*  576 */             Maquina6.setItemMeta(Maquina6Meta);
/*  577 */             p.getInventory().addItem(new ItemStack[] { Maquina6 });
/*  578 */             ev.remove();
/*  579 */             p.sendMessage(Strings.RemoverMaquina);
/*  580 */             Main.getPlugin().getConfig().set("Maquinas de " + p.getName(), Integer.valueOf(Main.getPlugin().getConfig().getInt("Maquinas de " + p.getName()) + 1));
/*  581 */             Main.getPlugin().saveConfig();
/*      */           } else {
/*  583 */             e.setCancelled(true);
/*  584 */             p.sendMessage(Strings.Tag + "§cVocê não pode quebrar isso sem uma picareta Encantada com SilkTouch!");
/*  585 */             return;
/*      */           }
/*      */         }
/*  588 */         ev.remove();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*  593 */   public void invMaquinas(Player p) { Inventory inv = Bukkit.createInventory(null, 27, "§8Loja de Máquinas");
/*      */     
/*  595 */     ItemStack Maquina1 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina1Bloco).intValue()));ItemMeta Maquina1Meta = Maquina1.getItemMeta();
/*  596 */     ItemStack Maquina2 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina2Bloco).intValue()));ItemMeta Maquina2Meta = Maquina2.getItemMeta();
/*  597 */     ItemStack Maquina5 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina5Bloco).intValue()));ItemMeta Maquina5Meta = Maquina5.getItemMeta();
/*  598 */     ItemStack Maquina4 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina4Bloco).intValue()));ItemMeta Maquina4Meta = Maquina4.getItemMeta();
/*  599 */     ItemStack Maquina3 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina3Bloco).intValue()));ItemMeta Maquina3Meta = Maquina3.getItemMeta();
/*  600 */     ItemStack Maquina6 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina6Bloco).intValue()));ItemMeta Maquina6Meta = Maquina6.getItemMeta();
/*  601 */     ItemStack Refinaria = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.RefinariaBloco).intValue()));ItemMeta Refinaria1Meta = Refinaria.getItemMeta();
/*      */     
/*  603 */     Refinaria1Meta.setDisplayName(Strings.RefinariaNome);
/*  604 */     ArrayList<String> desc = new ArrayList();
/*  605 */     desc.add("§7Tipo: " + Strings.RefinariaTipo);
/*  606 */     desc.add("§7Preco: " + Strings.RefinariaPreco);
/*  607 */     Refinaria1Meta.setLore(desc);
/*  608 */     Refinaria.setItemMeta(Refinaria1Meta);
/*      */     
/*  610 */     Maquina1Meta.setDisplayName(Strings.Maquina1Nome);
/*  611 */     ArrayList<String> desc1 = new ArrayList();
/*  612 */     desc1.add("§7Tipo: " + Strings.Maquina1Tipo);
/*  613 */     desc1.add("§7Preco: " + Strings.Maquina1Preco);
/*  614 */     Maquina1Meta.setLore(desc1);
/*  615 */     Maquina1.setItemMeta(Maquina1Meta);
/*      */     
/*  617 */     Maquina2Meta.setDisplayName(Strings.Maquina2Nome);
/*  618 */     ArrayList<String> desc2 = new ArrayList();
/*  619 */     desc2.add("§7Tipo: " + Strings.Maquina2Tipo);
/*  620 */     desc2.add("§7Preco: " + Strings.Maquina2Preco);
/*  621 */     Maquina2Meta.setLore(desc2);
/*  622 */     Maquina2.setItemMeta(Maquina2Meta);
/*      */     
/*  624 */     Maquina5Meta.setDisplayName(Strings.Maquina5Nome);
/*  625 */     ArrayList<String> desc11 = new ArrayList();
/*  626 */     desc11.add("§7Tipo: " + Strings.Maquina5Tipo);
/*  627 */     desc11.add("§7Preco: " + Strings.Maquina5Preco);
/*  628 */     Maquina5Meta.setLore(desc11);
/*  629 */     Maquina5.setItemMeta(Maquina5Meta);
/*      */     
/*  631 */     Maquina6Meta.setDisplayName(Strings.Maquina6Nome);
/*  632 */     ArrayList<String> desc111 = new ArrayList();
/*  633 */     desc111.add("§7Tipo: " + Strings.Maquina6Tipo);
/*  634 */     desc111.add("§7Preco: " + Strings.Maquina6Preco);
/*  635 */     Maquina6Meta.setLore(desc11);
/*  636 */     Maquina6.setItemMeta(Maquina6Meta);
/*      */     
/*  638 */     Maquina3Meta.setDisplayName(Strings.Maquina3Nome);
/*  639 */     ArrayList<String> desc1111 = new ArrayList();
/*  640 */     desc1111.add("§7Tipo: " + Strings.Maquina3Tipo);
/*  641 */     desc1111.add("§7Preco: " + Strings.Maquina3Preco);
/*  642 */     Maquina3Meta.setLore(desc1111);
/*  643 */     Maquina3.setItemMeta(Maquina3Meta);
/*      */     
/*  645 */     Maquina4Meta.setDisplayName(Strings.Maquina4Nome);
/*  646 */     ArrayList<String> desc121 = new ArrayList();
/*  647 */     desc121.add("§7Tipo: " + Strings.Maquina4Tipo);
/*  648 */     desc121.add("§7Preco: " + Strings.Maquina4Preco);
/*  649 */     Maquina4Meta.setLore(desc121);
/*  650 */     Maquina4.setItemMeta(Maquina4Meta);
/*      */     
/*  652 */     boolean ver1 = Strings.Maquina1isFalse();
/*  653 */     boolean ver2 = Strings.Maquina2isFalse();
/*  654 */     boolean ver3 = Strings.Maquina3isFalse();
/*  655 */     boolean ver4 = Strings.Maquina4isFalse();
/*  656 */     boolean ver5 = Strings.Maquina5isFalse();
/*  657 */     boolean ver6 = Strings.Maquina6isFalse();
/*  658 */     boolean ver7 = Strings.RefinariaisFalse();
/*      */     
/*  660 */     if (!ver1) {
/*  661 */       inv.setItem(10, Maquina1);
/*      */     }
/*      */     
/*  664 */     if (!ver2) {
/*  665 */       inv.setItem(11, Maquina2);
/*      */     }
/*      */     
/*  668 */     if (!ver3) {
/*  669 */       inv.setItem(12, Maquina3);
/*      */     }
/*      */     
/*  672 */     if (!ver4) {
/*  673 */       inv.setItem(13, Maquina4);
/*      */     }
/*      */     
/*  676 */     if (!ver5) {
/*  677 */       inv.setItem(14, Maquina5);
/*      */     }
/*      */     
/*  680 */     if (!ver6) {
/*  681 */       inv.setItem(15, Maquina6);
/*      */     }
/*      */     
/*  684 */     if (!ver7) {
/*  685 */       inv.setItem(22, Refinaria);
/*      */     }
/*      */     
/*  688 */     p.openInventory(inv);
/*      */   }
/*      */   
/*      */   @EventHandler
/*      */   public void comandoGui(PlayerCommandPreprocessEvent e) {
/*  693 */     Player p = e.getPlayer();
/*  694 */     String[] args = e.getMessage().split(" ");
/*  695 */     if (args[0].equalsIgnoreCase("/maquinas")) {
/*  696 */       e.setCancelled(true);
/*  697 */       invMaquinas(p);
/*      */     }
/*      */   }
/*      */   
/*      */   @EventHandler
/*      */   public void aoClicarIn(InventoryClickEvent e)
/*      */   {
/*  704 */     if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
/*  705 */       Inventory inv = e.getInventory();
/*  706 */       Player p = (Player)e.getWhoClicked();
/*  707 */       ItemStack Maquina1 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina1Bloco).intValue()));ItemMeta Maquina1Meta = Maquina1.getItemMeta();
/*  708 */       ItemStack Maquina2 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina2Bloco).intValue()));ItemMeta Maquina2Meta = Maquina2.getItemMeta();
/*  709 */       ItemStack Maquina5 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina5Bloco).intValue()));ItemMeta Maquina5Meta = Maquina5.getItemMeta();
/*  710 */       ItemStack Maquina4 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina4Bloco).intValue()));ItemMeta Maquina4Meta = Maquina4.getItemMeta();
/*  711 */       ItemStack Maquina3 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina3Bloco).intValue()));ItemMeta Maquina3Meta = Maquina3.getItemMeta();
/*  712 */       ItemStack Maquina6 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina6Bloco).intValue()));ItemMeta Maquina6Meta = Maquina6.getItemMeta();
/*  713 */       ItemStack Refinaria = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.RefinariaBloco).intValue()));ItemMeta Refinaria1Meta = Refinaria.getItemMeta();
/*  714 */       if (inv.getTitle().equalsIgnoreCase("§8Loja de Máquinas")) {
/*  715 */         if (e.getCurrentItem().getType() == Material.getMaterial(Strings.RefinariaBloco)) {
/*  716 */           e.setCancelled(true);
/*  717 */           if (Main.economy.getBalance(p) < Strings.RefinariaPreco) {
/*  718 */             p.sendMessage(Strings.SemMoney);
/*  719 */             p.closeInventory();
/*      */           } else {
/*  721 */             Main.economy.withdrawPlayer(p, Strings.RefinariaPreco);
/*  722 */             p.sendMessage(Strings.ComprouMaquina);
/*  723 */             p.closeInventory();
/*  724 */             Refinaria1Meta.setDisplayName(Strings.RefinariaNome);
/*  725 */             ArrayList<String> desc = new ArrayList();
/*  726 */             desc.add("§7Tipo: " + Strings.RefinariaTipo);
/*  727 */             Refinaria1Meta.setLore(desc);
/*  728 */             Refinaria.setItemMeta(Refinaria1Meta);
/*  729 */             p.getInventory().addItem(new ItemStack[] { Refinaria });
/*      */           }
/*  731 */         } else if (e.getCurrentItem().getType() == Material.getMaterial(Strings.Maquina1Bloco)) {
/*  732 */           e.setCancelled(true);
/*  733 */           if (Main.economy.getBalance(p) < Strings.Maquina1Preco) {
/*  734 */             p.sendMessage(Strings.SemMoney);
/*  735 */             p.closeInventory();
/*      */           } else {
/*  737 */             Main.economy.withdrawPlayer(p, Strings.Maquina1Preco);
/*  738 */             p.sendMessage(Strings.ComprouMaquina);
/*  739 */             p.closeInventory();
/*  740 */             Maquina1Meta.setDisplayName(Strings.Maquina1Nome);
/*  741 */             ArrayList<String> desc1 = new ArrayList();
/*  742 */             desc1.add("§7Tipo: " + Strings.Maquina1Tipo);
/*  743 */             Maquina1Meta.setLore(desc1);
/*  744 */             Maquina1.setItemMeta(Maquina1Meta);
/*  745 */             p.getInventory().addItem(new ItemStack[] { Maquina1 });
/*      */           }
/*  747 */         } else if (e.getCurrentItem().getType() == Material.getMaterial(Strings.Maquina2Bloco)) {
/*  748 */           e.setCancelled(true);
/*  749 */           if (Main.economy.getBalance(p) < Strings.Maquina2Preco) {
/*  750 */             p.sendMessage(Strings.SemMoney);
/*  751 */             p.closeInventory();
/*      */           } else {
/*  753 */             Main.economy.withdrawPlayer(p, Strings.Maquina2Preco);
/*  754 */             p.sendMessage(Strings.ComprouMaquina);
/*  755 */             p.closeInventory();
/*  756 */             Maquina2Meta.setDisplayName(Strings.Maquina2Nome);
/*  757 */             ArrayList<String> desc1 = new ArrayList();
/*  758 */             desc1.add("§7Tipo: " + Strings.Maquina2Tipo);
/*  759 */             Maquina2Meta.setLore(desc1);
/*  760 */             Maquina2.setItemMeta(Maquina2Meta);
/*  761 */             p.getInventory().addItem(new ItemStack[] { Maquina2 });
/*      */           }
/*  763 */         } else if (e.getCurrentItem().getType() == Material.getMaterial(Strings.Maquina5Bloco)) {
/*  764 */           e.setCancelled(true);
/*  765 */           if (Main.economy.getBalance(p) < Strings.Maquina5Preco) {
/*  766 */             p.sendMessage(Strings.SemMoney);
/*  767 */             p.closeInventory();
/*      */           } else {
/*  769 */             Main.economy.withdrawPlayer(p, Strings.Maquina5Preco);
/*  770 */             p.sendMessage(Strings.ComprouMaquina);
/*  771 */             p.closeInventory();
/*  772 */             Maquina5Meta.setDisplayName(Strings.Maquina5Nome);
/*  773 */             ArrayList<String> desc1 = new ArrayList();
/*  774 */             desc1.add("§7Tipo: " + Strings.Maquina5Tipo);
/*  775 */             Maquina5Meta.setLore(desc1);
/*  776 */             Maquina5.setItemMeta(Maquina5Meta);
/*  777 */             p.getInventory().addItem(new ItemStack[] { Maquina5 });
/*      */           }
/*  779 */         } else if (e.getCurrentItem().getType() == Material.getMaterial(Strings.Maquina4Bloco)) {
/*  780 */           e.setCancelled(true);
/*  781 */           if (Main.economy.getBalance(p) < Strings.Maquina4Preco) {
/*  782 */             p.sendMessage(Strings.SemMoney);
/*  783 */             p.closeInventory();
/*      */           } else {
/*  785 */             Main.economy.withdrawPlayer(p, Strings.Maquina4Preco);
/*  786 */             p.sendMessage(Strings.ComprouMaquina);
/*  787 */             p.closeInventory();
/*  788 */             Maquina4Meta.setDisplayName(Strings.Maquina4Nome);
/*  789 */             ArrayList<String> desc1 = new ArrayList();
/*  790 */             desc1.add("§7Tipo: " + Strings.Maquina4Tipo);
/*  791 */             Maquina4Meta.setLore(desc1);
/*  792 */             Maquina4.setItemMeta(Maquina4Meta);
/*  793 */             p.getInventory().addItem(new ItemStack[] { Maquina4 });
/*      */           }
/*  795 */         } else if (e.getCurrentItem().getType() == Material.getMaterial(Strings.Maquina3Bloco)) {
/*  796 */           e.setCancelled(true);
/*  797 */           if (Main.economy.getBalance(p) < Strings.Maquina3Preco) {
/*  798 */             p.sendMessage(Strings.SemMoney);
/*  799 */             p.closeInventory();
/*      */           } else {
/*  801 */             Main.economy.withdrawPlayer(p, Strings.Maquina3Preco);
/*  802 */             p.sendMessage(Strings.ComprouMaquina);
/*  803 */             p.closeInventory();
/*  804 */             Maquina3Meta.setDisplayName(Strings.Maquina3Nome);
/*  805 */             ArrayList<String> desc1 = new ArrayList();
/*  806 */             desc1.add("§7Tipo: " + Strings.Maquina3Tipo);
/*  807 */             desc1.add("§7Preco: " + Strings.Maquina3Preco);
/*  808 */             Maquina3Meta.setLore(desc1);
/*  809 */             Maquina3.setItemMeta(Maquina3Meta);
/*  810 */             p.getInventory().addItem(new ItemStack[] { Maquina3 });
/*      */           }
/*  812 */         } else if (e.getCurrentItem().getType() == Material.getMaterial(Strings.Maquina6Bloco)) {
/*  813 */           e.setCancelled(true);
/*  814 */           if (Main.economy.getBalance(p) < Strings.Maquina6Preco) {
/*  815 */             p.sendMessage(Strings.SemMoney);
/*  816 */             p.closeInventory();
/*      */           } else {
/*  818 */             Main.economy.withdrawPlayer(p, Strings.Maquina6Preco);
/*  819 */             p.sendMessage(Strings.ComprouMaquina);
/*  820 */             p.closeInventory();
/*  821 */             Maquina6Meta.setDisplayName(Strings.Maquina6Nome);
/*  822 */             ArrayList<String> desc1 = new ArrayList();
/*  823 */             desc1.add("§7Tipo: " + Strings.Maquina6Tipo);
/*  824 */             Maquina6Meta.setLore(desc1);
/*  825 */             Maquina6.setItemMeta(Maquina6Meta);
/*  826 */             p.getInventory().addItem(new ItemStack[] { Maquina6 });
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*  833 */   static ArrayList<Location> andamentoRefinaria = new ArrayList();
/*  834 */   static ArrayList<Location> andamentoMaquina1 = new ArrayList();
/*  835 */   static ArrayList<Location> andamentoMaquina2 = new ArrayList();
/*  836 */   static ArrayList<Location> andamentoMaquina5 = new ArrayList();
/*      */   
/*  838 */   static ArrayList<Location> andamentoMaquina3 = new ArrayList();
/*  839 */   static ArrayList<Location> andamentoMaquina4 = new ArrayList();
/*  840 */   static ArrayList<Location> andamentoMaquina6 = new ArrayList();
/*      */   static org.bukkit.scheduler.BukkitTask cancel;
/*      */   static ItemStack drop1;
/*      */   static ItemStack drop2;
/*      */   static ItemStack drop3;
/*      */   static ItemStack drop4;
/*      */   
/*      */   @EventHandler
/*  848 */   public void ClickFlint(final PlayerInteractEvent e) { final Player p = e.getPlayer();
/*      */     try {
/*  850 */       LivingEntity ev = getAmorStand(e.getClickedBlock());
/*  851 */       if ((p.getItemInHand() == null) && (p.getItemInHand().getType() == Material.AIR) && (!p.getItemInHand().hasItemMeta())) {
/*  852 */         return;
/*      */       }
/*  854 */       if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§0Petróleo")) {
/*  855 */         if ((ev != null) && 
/*  856 */           (ev.getCustomName().equalsIgnoreCase("REFINARIA"))) {
/*  857 */           if (!andamentoRefinaria.contains(e.getClickedBlock().getLocation())) {
/*  858 */             if (p.getItemInHand().getAmount() == 1) {
/*  859 */               p.getInventory().remove(p.getItemInHand());
/*      */             } else {
/*  861 */               p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */             }
/*  863 */             p.sendMessage(Strings.LigouMaquina);
/*      */             
/*  865 */             em.setDisplayName("§4Combustivel I");
/*  866 */             ArrayList<String> desc = new ArrayList();
/*  867 */             desc.add("§7Tipo: §fETANOL");
/*  868 */             desc.add("§7Duração: §f1 M");
/*  869 */             em.setLore(desc);
/*  870 */             eta.setItemMeta(em);
/*      */             
/*  872 */             gm.setDisplayName("§4Combustivel II");
/*  873 */             ArrayList<String> desc1 = new ArrayList();
/*  874 */             desc1.add("§7Tipo: §fGASOSA");
/*  875 */             desc1.add("§7Duração: §f5 M");
/*  876 */             gm.setLore(desc1);
/*  877 */             gas.setItemMeta(gm);
/*      */             
/*  879 */             dm.setDisplayName("§4Combustivel III");
/*  880 */             ArrayList<String> desc2 = new ArrayList();
/*  881 */             desc2.add("§7Tipo: §fDIESEL");
/*  882 */             desc2.add("§7Duração: §f25 M");
/*  883 */             dm.setLore(desc2);
/*  884 */             die.setItemMeta(dm);
/*      */             
/*  886 */             andamentoRefinaria.add(e.getClickedBlock().getLocation());
/*      */             
/*      */ 
/*  889 */             cancel = new BukkitRunnable() {
/*  890 */               int atual = 0;
/*      */               
/*      */               public void run() {
/*  893 */                 if (this.atual < 60) {
/*  894 */                   this.atual += Strings.RefinariaColdown;
/*  895 */                   Random r = new Random();
/*  896 */                   int i = r.nextInt(4);
/*  897 */                   switch (i) {
/*      */                   case 0: 
/*  899 */                     e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.eta);
/*  900 */                     break;
/*      */                   case 1: 
/*  902 */                     e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.gas);
/*  903 */                     break;
/*      */                   case 2: 
/*  905 */                     e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.eta);
/*  906 */                     break;
/*      */                   case 3: 
/*  908 */                     e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.die);
/*      */                   }
/*      */                 }
/*      */                 else {
/*  912 */                   MaquinasEvento.andamentoRefinaria.remove(e.getClickedBlock().getLocation());
/*  913 */                   p.sendMessage(Strings.AcabouCombustivel);
/*  914 */                   cancel();
/*      */                 }
/*      */               }
/*  917 */             }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.RefinariaColdown);
/*      */           }
/*      */           else
/*      */           {
/*  921 */             p.sendMessage(Strings.JaEstaAbastecida);
/*      */           }
/*      */         }
/*      */       }
/*  925 */       else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§4Combustivel I")) {
/*  926 */         if (ev != null)
/*      */         {
/*  928 */           if (ev.getCustomName().equalsIgnoreCase("MAQUINA1")) {
/*  929 */             if (!andamentoMaquina1.contains(e.getClickedBlock().getLocation()))
/*      */             {
/*  931 */               if (p.getItemInHand().getAmount() == 1) {
/*  932 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/*  934 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/*  936 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/*      */ 
/*  939 */               andamentoMaquina1.add(e.getClickedBlock().getLocation());
/*      */               
/*      */ 
/*  942 */               String args = Strings.Maquina1ID;
/*  943 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/*  944 */               if (args.contains(":")) {
/*  945 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina1ID).split(":");
/*  946 */                 int id = Integer.valueOf(args1[0]).intValue();
/*  947 */                 int data = Integer.valueOf(args1[1]).intValue();
/*  948 */                 drop1 = new ItemStack(Material.getMaterial(id), Strings.Maquina1Quantia, (short)data);
/*  949 */                 Bukkit.getConsoleSender().sendMessage("ID VALE: " + id + "\nData vale: " + data);
/*      */               } else {
/*  951 */                 drop1 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina1ID).intValue()));
/*  952 */                 drop1.setAmount(Strings.Maquina1Quantia);
/*      */               }
/*  954 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  967 */                 new BukkitRunnable()
/*      */                 {
/*  955 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/*  958 */                     if (this.atual < 60) {
/*  959 */                       this.atual += Strings.Maquina1Coldown;
/*  960 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop1);
/*      */                     } else {
/*  962 */                       MaquinasEvento.andamentoMaquina1.remove(e.getClickedBlock().getLocation());
/*  963 */                       p.sendMessage(Strings.AcabouCombustivel);
/*  964 */                       cancel();
/*      */                     }
/*      */                   }
/*  967 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina1Coldown);
/*      */             } else {
/*  969 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/*  971 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA2")) {
/*  972 */             if (!andamentoMaquina2.contains(e.getClickedBlock().getLocation())) {
/*  973 */               if (p.getItemInHand().getAmount() == 1) {
/*  974 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/*  976 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/*  978 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/*  980 */               andamentoMaquina2.add(e.getClickedBlock().getLocation());
/*      */               
/*  982 */               String args = Strings.Maquina2ID;
/*  983 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/*  984 */               if (args.contains(":")) {
/*  985 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina2ID).split(":");
/*  986 */                 int id = Integer.valueOf(args1[0]).intValue();
/*  987 */                 int data = Integer.valueOf(args1[1]).intValue();
/*  988 */                 drop2 = new ItemStack(Material.getMaterial(id), Strings.Maquina2Quantia, (short)data);
/*      */               } else {
/*  990 */                 drop2 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina2ID).intValue()));
/*  991 */                 drop2.setAmount(Strings.Maquina2Quantia);
/*      */               }
/*      */               
/*  994 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1007 */                 new BukkitRunnable()
/*      */                 {
/*  995 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/*  998 */                     if (this.atual < 60) {
/*  999 */                       this.atual += Strings.Maquina2Coldown;
/* 1000 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop2);
/*      */                     } else {
/* 1002 */                       MaquinasEvento.andamentoMaquina2.remove(e.getClickedBlock().getLocation());
/* 1003 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1004 */                       cancel();
/*      */                     }
/*      */                   }
/* 1007 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina2Coldown);
/*      */             } else {
/* 1009 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/* 1011 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA5")) {
/* 1012 */             if (!andamentoMaquina5.contains(e.getClickedBlock().getLocation())) {
/* 1013 */               if (p.getItemInHand().getAmount() == 1) {
/* 1014 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1016 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1018 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/* 1020 */               andamentoMaquina5.add(e.getClickedBlock().getLocation());
/*      */               
/*      */ 
/* 1023 */               String args = Strings.Maquina5ID;
/* 1024 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1025 */               if (args.contains(":")) {
/* 1026 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina5ID).split(":");
/* 1027 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1028 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1029 */                 drop5 = new ItemStack(Material.getMaterial(id), Strings.Maquina5Quantia, (short)data);
/*      */               } else {
/* 1031 */                 drop5 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina5ID).intValue()));
/* 1032 */                 drop5.setAmount(Strings.Maquina5Quantia);
/*      */               }
/*      */               
/* 1035 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1048 */                 new BukkitRunnable()
/*      */                 {
/* 1036 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1039 */                     if (this.atual < 60) {
/* 1040 */                       this.atual += Strings.Maquina5Coldown;
/* 1041 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop5);
/*      */                     } else {
/* 1043 */                       MaquinasEvento.andamentoMaquina5.remove(e.getClickedBlock().getLocation());
/* 1044 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1045 */                       cancel();
/*      */                     }
/*      */                   }
/* 1048 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina5Coldown);
/*      */             } else {
/* 1050 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/* 1052 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA4")) {
/* 1053 */             if (!andamentoMaquina4.contains(e.getClickedBlock().getLocation())) {
/* 1054 */               if (p.getItemInHand().getAmount() == 1) {
/* 1055 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1057 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1059 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/* 1061 */               andamentoMaquina4.add(e.getClickedBlock().getLocation());
/*      */               
/* 1063 */               String args = Strings.Maquina4ID;
/* 1064 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1065 */               if (args.contains(":")) {
/* 1066 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina4ID).split(":");
/* 1067 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1068 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1069 */                 drop4 = new ItemStack(Material.getMaterial(id), Strings.Maquina4Quantia, (short)data);
/*      */               } else {
/* 1071 */                 drop4 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina4ID).intValue()));
/* 1072 */                 drop4.setAmount(Strings.Maquina4Quantia);
/*      */               }
/*      */               
/* 1075 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1088 */                 new BukkitRunnable()
/*      */                 {
/* 1076 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1079 */                     if (this.atual < 60) {
/* 1080 */                       this.atual += Strings.Maquina4Coldown;
/* 1081 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop4);
/*      */                     } else {
/* 1083 */                       MaquinasEvento.andamentoMaquina4.remove(e.getClickedBlock().getLocation());
/* 1084 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1085 */                       cancel();
/*      */                     }
/*      */                   }
/* 1088 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina4Coldown);
/*      */             } else {
/* 1090 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/* 1092 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA3")) {
/* 1093 */             if (!andamentoMaquina3.contains(e.getClickedBlock().getLocation())) {
/* 1094 */               if (p.getItemInHand().getAmount() == 1) {
/* 1095 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1097 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1099 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/* 1101 */               andamentoMaquina3.add(e.getClickedBlock().getLocation());
/*      */               
/*      */ 
/* 1104 */               String args = Strings.Maquina3ID;
/* 1105 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1106 */               if (args.contains(":")) {
/* 1107 */                 String[] args1 = Strings.Maquina3ID.split(":");
/* 1108 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1109 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1110 */                 drop3 = new ItemStack(Material.getMaterial(id), Strings.Maquina3Quantia, (short)data);
/*      */               } else {
/* 1112 */                 drop3 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina3ID).intValue()));
/* 1113 */                 drop3.setAmount(Strings.Maquina3Quantia);
/*      */               }
/*      */               
/* 1116 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1129 */                 new BukkitRunnable()
/*      */                 {
/* 1117 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1120 */                     if (this.atual < 60) {
/* 1121 */                       this.atual += Strings.Maquina3Coldown;
/* 1122 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop3);
/*      */                     } else {
/* 1124 */                       MaquinasEvento.andamentoMaquina3.remove(e.getClickedBlock().getLocation());
/* 1125 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1126 */                       cancel();
/*      */                     }
/*      */                   }
/* 1129 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina3Coldown);
/*      */             } else {
/* 1131 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/* 1133 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA6")) {
/* 1134 */             if (!andamentoMaquina6.contains(e.getClickedBlock().getLocation())) {
/* 1135 */               if (p.getItemInHand().getAmount() == 1) {
/* 1136 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1138 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1140 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/* 1142 */               andamentoMaquina6.add(e.getClickedBlock().getLocation());
/*      */               
/*      */ 
/* 1145 */               String args = Strings.Maquina6ID;
/* 1146 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1147 */               if (args.contains(":")) {
/* 1148 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina6ID).split(":");
/* 1149 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1150 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1151 */                 drop6 = new ItemStack(Material.getMaterial(id), Strings.Maquina6Quantia, (short)data);
/*      */               } else {
/* 1153 */                 drop6 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina6ID).intValue()));
/* 1154 */                 drop6.setAmount(Strings.Maquina6Quantia);
/*      */               }
/*      */               
/* 1157 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1170 */                 new BukkitRunnable()
/*      */                 {
/* 1158 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1161 */                     if (this.atual < 60) {
/* 1162 */                       this.atual += Strings.Maquina6Coldown;
/* 1163 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop6);
/*      */                     } else {
/* 1165 */                       MaquinasEvento.andamentoMaquina6.remove(e.getClickedBlock().getLocation());
/* 1166 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1167 */                       cancel();
/*      */                     }
/*      */                   }
/* 1170 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina6Coldown);
/*      */             } else {
/* 1172 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/* 1177 */       else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§4Combustivel II")) {
/* 1178 */         if (ev != null)
/*      */         {
/* 1180 */           if (ev.getCustomName().equalsIgnoreCase("MAQUINA1")) {
/* 1181 */             if (!andamentoMaquina1.contains(e.getClickedBlock().getLocation()))
/*      */             {
/* 1183 */               if (p.getItemInHand().getAmount() == 1) {
/* 1184 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1186 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1188 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/*      */ 
/* 1191 */               andamentoMaquina1.add(e.getClickedBlock().getLocation());
/*      */               
/*      */ 
/* 1194 */               String args = Strings.Maquina1ID;
/* 1195 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1196 */               if (args.contains(":")) {
/* 1197 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina1ID).split(":");
/* 1198 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1199 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1200 */                 drop11 = new ItemStack(Material.getMaterial(id), Strings.Maquina1Quantia, (short)data);
/*      */               } else {
/* 1202 */                 drop11 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina1ID).intValue()));
/* 1203 */                 drop11.setAmount(Strings.Maquina1Quantia);
/*      */               }
/* 1205 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1218 */                 new BukkitRunnable()
/*      */                 {
/* 1206 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1209 */                     if (this.atual < 300) {
/* 1210 */                       this.atual += Strings.Maquina1Coldown;
/* 1211 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop11);
/*      */                     } else {
/* 1213 */                       MaquinasEvento.andamentoMaquina1.remove(e.getClickedBlock().getLocation());
/* 1214 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1215 */                       cancel();
/*      */                     }
/*      */                   }
/* 1218 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina1Coldown);
/*      */             } else {
/* 1220 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/* 1222 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA2")) {
/* 1223 */             if (!andamentoMaquina2.contains(e.getClickedBlock().getLocation())) {
/* 1224 */               if (p.getItemInHand().getAmount() == 1) {
/* 1225 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1227 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1229 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/* 1231 */               andamentoMaquina2.add(e.getClickedBlock().getLocation());
/* 1232 */               String args = Strings.Maquina2ID;
/* 1233 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1234 */               if (args.contains(":")) {
/* 1235 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina2ID).split(":");
/* 1236 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1237 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1238 */                 drop22 = new ItemStack(Material.getMaterial(id), Strings.Maquina2Quantia, (short)data);
/*      */               } else {
/* 1240 */                 drop22 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina2ID).intValue()));
/* 1241 */                 drop22.setAmount(Strings.Maquina2Quantia);
/*      */               }
/*      */               
/* 1244 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1257 */                 new BukkitRunnable()
/*      */                 {
/* 1245 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1248 */                     if (this.atual < 300) {
/* 1249 */                       this.atual += Strings.Maquina2Coldown;
/* 1250 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop22);
/*      */                     } else {
/* 1252 */                       MaquinasEvento.andamentoMaquina2.remove(e.getClickedBlock().getLocation());
/* 1253 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1254 */                       cancel();
/*      */                     }
/*      */                   }
/* 1257 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina2Coldown);
/*      */             } else {
/* 1259 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/* 1261 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA5")) {
/* 1262 */             if (!andamentoMaquina5.contains(e.getClickedBlock().getLocation())) {
/* 1263 */               if (p.getItemInHand().getAmount() == 1) {
/* 1264 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1266 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1268 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/* 1270 */               andamentoMaquina5.add(e.getClickedBlock().getLocation());
/*      */               
/*      */ 
/* 1273 */               String args = Strings.Maquina5ID;
/* 1274 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1275 */               if (args.contains(":")) {
/* 1276 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina5ID).split(":");
/* 1277 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1278 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1279 */                 drop55 = new ItemStack(Material.getMaterial(id), Strings.Maquina5Quantia, (short)data);
/*      */               } else {
/* 1281 */                 drop55 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina5ID).intValue()));
/* 1282 */                 drop55.setAmount(Strings.Maquina5Quantia);
/*      */               }
/*      */               
/* 1285 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1298 */                 new BukkitRunnable()
/*      */                 {
/* 1286 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1289 */                     if (this.atual < 300) {
/* 1290 */                       this.atual += Strings.Maquina5Coldown;
/* 1291 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop55);
/*      */                     } else {
/* 1293 */                       MaquinasEvento.andamentoMaquina5.remove(e.getClickedBlock().getLocation());
/* 1294 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1295 */                       cancel();
/*      */                     }
/*      */                   }
/* 1298 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina5Coldown);
/*      */             } else {
/* 1300 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/* 1302 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA4")) {
/* 1303 */             if (!andamentoMaquina4.contains(e.getClickedBlock().getLocation())) {
/* 1304 */               if (p.getItemInHand().getAmount() == 1) {
/* 1305 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1307 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1309 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/* 1311 */               andamentoMaquina4.add(e.getClickedBlock().getLocation());
/*      */               
/* 1313 */               String args = Strings.Maquina4ID;
/* 1314 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1315 */               if (args.contains(":")) {
/* 1316 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina4ID).split(":");
/* 1317 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1318 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1319 */                 drop44 = new ItemStack(Material.getMaterial(id), Strings.Maquina4Quantia, (short)data);
/*      */               } else {
/* 1321 */                 drop44 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina4ID).intValue()));
/* 1322 */                 drop44.setAmount(Strings.Maquina4Quantia);
/*      */               }
/*      */               
/* 1325 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1338 */                 new BukkitRunnable()
/*      */                 {
/* 1326 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1329 */                     if (this.atual < 300) {
/* 1330 */                       this.atual += Strings.Maquina4Coldown;
/* 1331 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop44);
/*      */                     } else {
/* 1333 */                       MaquinasEvento.andamentoMaquina4.remove(e.getClickedBlock().getLocation());
/* 1334 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1335 */                       cancel();
/*      */                     }
/*      */                   }
/* 1338 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina4Coldown);
/*      */             } else {
/* 1340 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/* 1342 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA3")) {
/* 1343 */             if (!andamentoMaquina3.contains(e.getClickedBlock().getLocation())) {
/* 1344 */               if (p.getItemInHand().getAmount() == 1) {
/* 1345 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1347 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1349 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/* 1351 */               andamentoMaquina3.add(e.getClickedBlock().getLocation());
/*      */               
/*      */ 
/* 1354 */               String args = Strings.Maquina3ID;
/* 1355 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1356 */               if (args.contains(":")) {
/* 1357 */                 String[] args1 = Strings.Maquina3ID.split(":");
/* 1358 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1359 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1360 */                 drop33 = new ItemStack(Material.getMaterial(id), Strings.Maquina3Quantia, (short)data);
/*      */               } else {
/* 1362 */                 drop33 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina3ID).intValue()));
/* 1363 */                 drop33.setAmount(Strings.Maquina3Quantia);
/*      */               }
/*      */               
/* 1366 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1379 */                 new BukkitRunnable()
/*      */                 {
/* 1367 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1370 */                     if (this.atual < 300) {
/* 1371 */                       this.atual += Strings.Maquina3Coldown;
/* 1372 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop33);
/*      */                     } else {
/* 1374 */                       MaquinasEvento.andamentoMaquina3.remove(e.getClickedBlock().getLocation());
/* 1375 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1376 */                       cancel();
/*      */                     }
/*      */                   }
/* 1379 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina3Coldown);
/*      */             } else {
/* 1381 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/* 1383 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA6")) {
/* 1384 */             if (!andamentoMaquina6.contains(e.getClickedBlock().getLocation())) {
/* 1385 */               if (p.getItemInHand().getAmount() == 1) {
/* 1386 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1388 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1390 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/* 1392 */               andamentoMaquina6.add(e.getClickedBlock().getLocation());
/*      */               
/*      */ 
/* 1395 */               String args = Strings.Maquina6ID;
/* 1396 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1397 */               if (args.contains(":")) {
/* 1398 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina6ID).split(":");
/* 1399 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1400 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1401 */                 drop66 = new ItemStack(Material.getMaterial(id), Strings.Maquina6Quantia, (short)data);
/*      */               } else {
/* 1403 */                 drop66 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina6ID).intValue()));
/* 1404 */                 drop66.setAmount(Strings.Maquina6Quantia);
/*      */               }
/*      */               
/* 1407 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1420 */                 new BukkitRunnable()
/*      */                 {
/* 1408 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1411 */                     if (this.atual < 300) {
/* 1412 */                       this.atual += Strings.Maquina6Coldown;
/* 1413 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop66);
/*      */                     } else {
/* 1415 */                       MaquinasEvento.andamentoMaquina6.remove(e.getClickedBlock().getLocation());
/* 1416 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1417 */                       cancel();
/*      */                     }
/*      */                   }
/* 1420 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina6Coldown);
/*      */             } else {
/* 1422 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/* 1427 */       else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§4Combustivel III")) {
/* 1428 */         if (ev != null)
/*      */         {
/* 1430 */           if (ev.getCustomName().equalsIgnoreCase("MAQUINA1")) {
/* 1431 */             if (!andamentoMaquina1.contains(e.getClickedBlock().getLocation()))
/*      */             {
/* 1433 */               if (p.getItemInHand().getAmount() == 1) {
/* 1434 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1436 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1438 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/*      */ 
/* 1441 */               andamentoMaquina1.add(e.getClickedBlock().getLocation());
/*      */               
/*      */ 
/* 1444 */               String args = Strings.Maquina1ID;
/* 1445 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1446 */               if (args.contains(":")) {
/* 1447 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina1ID).split(":");
/* 1448 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1449 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1450 */                 drop111 = new ItemStack(Material.getMaterial(id), Strings.Maquina1Quantia, (short)data);
/*      */               } else {
/* 1452 */                 drop111 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina1ID).intValue()));
/* 1453 */                 drop111.setAmount(Strings.Maquina1Quantia);
/*      */               }
/* 1455 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1468 */                 new BukkitRunnable()
/*      */                 {
/* 1456 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1459 */                     if (this.atual < 1500) {
/* 1460 */                       this.atual += Strings.Maquina1Coldown;
/* 1461 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop111);
/*      */                     } else {
/* 1463 */                       MaquinasEvento.andamentoMaquina1.remove(e.getClickedBlock().getLocation());
/* 1464 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1465 */                       cancel();
/*      */                     }
/*      */                   }
/* 1468 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina1Coldown);
/*      */             } else {
/* 1470 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/* 1472 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA2")) {
/* 1473 */             if (!andamentoMaquina2.contains(e.getClickedBlock().getLocation())) {
/* 1474 */               if (p.getItemInHand().getAmount() == 1) {
/* 1475 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1477 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1479 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/* 1481 */               andamentoMaquina2.add(e.getClickedBlock().getLocation());
/*      */               
/* 1483 */               String args = Strings.Maquina2ID;
/* 1484 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1485 */               if (args.contains(":")) {
/* 1486 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina2ID).split(":");
/* 1487 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1488 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1489 */                 drop222 = new ItemStack(Material.getMaterial(id), Strings.Maquina2Quantia, (short)data);
/*      */               } else {
/* 1491 */                 drop222 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina2ID).intValue()));
/* 1492 */                 drop222.setAmount(Strings.Maquina2Quantia);
/*      */               }
/*      */               
/* 1495 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1508 */                 new BukkitRunnable()
/*      */                 {
/* 1496 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1499 */                     if (this.atual < 1500) {
/* 1500 */                       this.atual += Strings.Maquina2Coldown;
/* 1501 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop222);
/*      */                     } else {
/* 1503 */                       MaquinasEvento.andamentoMaquina2.remove(e.getClickedBlock().getLocation());
/* 1504 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1505 */                       cancel();
/*      */                     }
/*      */                   }
/* 1508 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina2Coldown);
/*      */             } else {
/* 1510 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/* 1512 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA5")) {
/* 1513 */             if (!andamentoMaquina5.contains(e.getClickedBlock().getLocation())) {
/* 1514 */               if (p.getItemInHand().getAmount() == 1) {
/* 1515 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1517 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1519 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/* 1521 */               andamentoMaquina5.add(e.getClickedBlock().getLocation());
/*      */               
/*      */ 
/* 1524 */               String args = Strings.Maquina5ID;
/* 1525 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1526 */               if (args.contains(":")) {
/* 1527 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina5ID).split(":");
/* 1528 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1529 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1530 */                 drop555 = new ItemStack(Material.getMaterial(id), Strings.Maquina5Quantia, (short)data);
/*      */               } else {
/* 1532 */                 drop555 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina5ID).intValue()));
/* 1533 */                 drop555.setAmount(Strings.Maquina5Quantia);
/*      */               }
/*      */               
/* 1536 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1549 */                 new BukkitRunnable()
/*      */                 {
/* 1537 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1540 */                     if (this.atual < 1500) {
/* 1541 */                       this.atual += Strings.Maquina5Coldown;
/* 1542 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop555);
/*      */                     } else {
/* 1544 */                       MaquinasEvento.andamentoMaquina5.remove(e.getClickedBlock().getLocation());
/* 1545 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1546 */                       cancel();
/*      */                     }
/*      */                   }
/* 1549 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina5Coldown);
/*      */             } else {
/* 1551 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/* 1553 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA4")) {
/* 1554 */             if (!andamentoMaquina4.contains(e.getClickedBlock().getLocation())) {
/* 1555 */               if (p.getItemInHand().getAmount() == 1) {
/* 1556 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1558 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1560 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/* 1562 */               andamentoMaquina4.add(e.getClickedBlock().getLocation());
/*      */               
/* 1564 */               String args = Strings.Maquina4ID;
/* 1565 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1566 */               if (args.contains(":")) {
/* 1567 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina4ID).split(":");
/* 1568 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1569 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1570 */                 drop444 = new ItemStack(Material.getMaterial(id), Strings.Maquina4Quantia, (short)data);
/*      */               } else {
/* 1572 */                 drop444 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina4ID).intValue()));
/* 1573 */                 drop444.setAmount(Strings.Maquina4Quantia);
/*      */               }
/*      */               
/* 1576 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1589 */                 new BukkitRunnable()
/*      */                 {
/* 1577 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1580 */                     if (this.atual < 1500) {
/* 1581 */                       this.atual += Strings.Maquina4Coldown;
/* 1582 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop444);
/*      */                     } else {
/* 1584 */                       MaquinasEvento.andamentoMaquina4.remove(e.getClickedBlock().getLocation());
/* 1585 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1586 */                       cancel();
/*      */                     }
/*      */                   }
/* 1589 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina4Coldown);
/*      */             } else {
/* 1591 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/* 1593 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA3")) {
/* 1594 */             if (!andamentoMaquina3.contains(e.getClickedBlock().getLocation())) {
/* 1595 */               if (p.getItemInHand().getAmount() == 1) {
/* 1596 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1598 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1600 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/* 1602 */               andamentoMaquina3.add(e.getClickedBlock().getLocation());
/*      */               
/*      */ 
/* 1605 */               String args = Strings.Maquina3ID;
/* 1606 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1607 */               if (args.contains(":")) {
/* 1608 */                 String[] args1 = Strings.Maquina3ID.split(":");
/* 1609 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1610 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1611 */                 drop333 = new ItemStack(Material.getMaterial(id), Strings.Maquina3Quantia, (short)data);
/*      */               } else {
/* 1613 */                 drop333 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina3ID).intValue()));
/* 1614 */                 drop333.setAmount(Strings.Maquina3Quantia);
/*      */               }
/*      */               
/* 1617 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1630 */                 new BukkitRunnable()
/*      */                 {
/* 1618 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1621 */                     if (this.atual < 1500) {
/* 1622 */                       this.atual += Strings.Maquina3Coldown;
/* 1623 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop333);
/*      */                     } else {
/* 1625 */                       MaquinasEvento.andamentoMaquina3.remove(e.getClickedBlock().getLocation());
/* 1626 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1627 */                       cancel();
/*      */                     }
/*      */                   }
/* 1630 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina3Coldown);
/*      */             } else {
/* 1632 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             }
/* 1634 */           } else if (ev.getCustomName().equalsIgnoreCase("MAQUINA6"))
/* 1635 */             if (!andamentoMaquina6.contains(e.getClickedBlock().getLocation())) {
/* 1636 */               if (p.getItemInHand().getAmount() == 1) {
/* 1637 */                 p.getInventory().remove(p.getItemInHand());
/*      */               } else {
/* 1639 */                 p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
/*      */               }
/* 1641 */               p.sendMessage(Strings.LigouMaquina);
/*      */               
/* 1643 */               andamentoMaquina6.add(e.getClickedBlock().getLocation());
/*      */               
/*      */ 
/* 1646 */               String args = Strings.Maquina6ID;
/* 1647 */               Bukkit.getConsoleSender().sendMessage("ARGS VALE: " + args);
/* 1648 */               if (args.contains(":")) {
/* 1649 */                 String[] args1 = Main.getPlugin().getConfig().getString(Strings.Maquina6ID).split(":");
/* 1650 */                 int id = Integer.valueOf(args1[0]).intValue();
/* 1651 */                 int data = Integer.valueOf(args1[1]).intValue();
/* 1652 */                 drop666 = new ItemStack(Material.getMaterial(id), Strings.Maquina6Quantia, (short)data);
/*      */               } else {
/* 1654 */                 drop666 = new ItemStack(Material.getMaterial(Integer.valueOf(Strings.Maquina6ID).intValue()));
/* 1655 */                 drop666.setAmount(Strings.Maquina6Quantia);
/*      */               }
/*      */               
/* 1658 */               cancel = 
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1671 */                 new BukkitRunnable()
/*      */                 {
/* 1659 */                   int atual = 0;
/*      */                   
/*      */                   public void run() {
/* 1662 */                     if (this.atual < 1500) {
/* 1663 */                       this.atual += Strings.Maquina6Coldown;
/* 1664 */                       e.getClickedBlock().getLocation().getWorld().dropItem(e.getClickedBlock().getLocation(), MaquinasEvento.drop666);
/*      */                     } else {
/* 1666 */                       MaquinasEvento.andamentoMaquina6.remove(e.getClickedBlock().getLocation());
/* 1667 */                       p.sendMessage(Strings.AcabouCombustivel);
/* 1668 */                       cancel();
/*      */                     }
/*      */                   }
/* 1671 */                 }.runTaskTimer(Main.getPlugin(), 20L, 20L * Strings.Maquina6Coldown);
/*      */             } else {
/* 1673 */               p.sendMessage(Strings.JaEstaAbastecida);
/*      */             } }
/*      */       } else {}
/*      */     } catch (Exception localException) {}
/*      */   }
/*      */   
/*      */   static ItemStack drop5;
/*      */   static ItemStack drop6;
/*      */   static ItemStack drop11;
/*      */   static ItemStack drop22;
/*      */   static ItemStack drop33;
/*      */   static ItemStack drop44;
/*      */   static ItemStack drop55;
/*      */   
/*      */   @EventHandler
/*      */   public void aoCLicar(PlayerInteractEvent e) {
/* 1689 */     if ((e.getClickedBlock().getType() == Material.DROPPER) || (e.getClickedBlock().getType() == Material.DISPENSER) || (e.getClickedBlock().getType() == Material.FURNACE)) {
/* 1690 */       LivingEntity ev = getAmorStand(e.getClickedBlock());
/* 1691 */       if (ev == null) {
/* 1692 */         return;
/*      */       }
/* 1694 */       if ((ev.getCustomName().equalsIgnoreCase("REFINARIA")) || (ev.getCustomName().equalsIgnoreCase("MAQUINA1")) || (ev.getCustomName().equalsIgnoreCase("MAQUINA2")) || (ev.getCustomName().equalsIgnoreCase("MAQUINA3")) || 
/* 1695 */         (ev.getCustomName().equalsIgnoreCase("MAQUINA4")) || (ev.getCustomName().equalsIgnoreCase("MAQUINA5")) || (ev.getCustomName().equalsIgnoreCase("MAQUINA6")))
/* 1696 */         bloco = e.getClickedBlock();
/*      */     } }
/*      */   
/*      */   static ItemStack drop66;
/*      */   static ItemStack drop111;
/*      */   
/* 1702 */   public void fecharInv(InventoryOpenEvent e) { if ((e.getInventory().getType() == InventoryType.FURNACE) || (e.getInventory().getType() == InventoryType.DROPPER) || (e.getInventory().getType() == InventoryType.DISPENSER)) {
/* 1703 */       LivingEntity ev = getAmorStand(bloco);
/* 1704 */       if (ev == null) {
/* 1705 */         return;
/*      */       }
/* 1707 */       if ((ev.getCustomName().equalsIgnoreCase("REFINARIA")) || (ev.getCustomName().equalsIgnoreCase("MAQUINA1")) || (ev.getCustomName().equalsIgnoreCase("MAQUINA2")) || (ev.getCustomName().equalsIgnoreCase("MAQUINA3")) || 
/* 1708 */         (ev.getCustomName().equalsIgnoreCase("MAQUINA4")) || (ev.getCustomName().equalsIgnoreCase("MAQUINA5")) || (ev.getCustomName().equalsIgnoreCase("MAQUINA6"))) {
/* 1709 */         e.setCancelled(true);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static ItemStack drop222;
/*      */   static ItemStack drop333;
/*      */   static ItemStack drop444;
/*      */   static ItemStack drop555;
/*      */   static ItemStack drop666;
/*      */   static Block bloco;
/*      */ }


/* Location:              C:\Users\Diego\Desktop\MM-Maquinas.jar!\me\MMaquinas\Evento\MaquinasEvento.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */