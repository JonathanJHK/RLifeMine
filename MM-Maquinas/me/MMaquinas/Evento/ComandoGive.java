/*     */ package me.MMaquinas.Evento;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import me.MMaquinas.Utils.Strings;
/*     */ import me.MMaquinas.Utils.jSon;
/*     */ import me.MMaquinas.Utils.jSon.ClickAction;
/*     */ import me.MMaquinas.Utils.jSon.HoverAction;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ public class ComandoGive implements org.bukkit.command.CommandExecutor
/*     */ {
/*     */   public boolean onCommand(org.bukkit.command.CommandSender Sender, Command Cmd, String Label, String[] args)
/*     */   {
/*  19 */     if (Cmd.getName().equalsIgnoreCase("combustivel")) {
/*  20 */       if ((Sender instanceof Player)) {
/*  21 */         Player p2 = (Player)Sender;
/*  22 */         if (!p2.hasPermission("KIBE.GiveMachine")) {
/*  23 */           p2.sendMessage("§6§l[WMachine] §cVocê não pode fazer isso!");
/*  24 */           return true;
/*     */         }
/*  26 */         if (args.length != 4) {
/*  27 */           p2.sendMessage(Strings.Tag + "§cArgumentos Invalidos!");
/*  28 */           p2.sendMessage(Strings.Tag + " §eUse: /combustivel give <nick> <tipo> <quantia>");
/*  29 */           p2.sendMessage(Strings.Tag + " §eLista de Maquinas disponiveis: ");
/*  30 */           jSon json = new jSon();
/*  31 */           json.addText("§6- §ePetroleo ")
/*  32 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/combustivel give " + p2.getName() + " petroleo 1")
/*  33 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar um §aPetroleo");
/*  34 */           json.sendJson(p2);
/*  35 */           jSon json2 = new jSon();
/*  36 */           json2.addText("§6- §eEtanol ")
/*  37 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/combustivel give " + p2.getName() + " etanol 1")
/*  38 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar um §aEtanol");
/*  39 */           json2.sendJson(p2);
/*  40 */           jSon json3 = new jSon();
/*  41 */           json3.addText("§6- §eGasolina ")
/*  42 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/combustivel give " + p2.getName() + " gasolina 1")
/*  43 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar uma §aGasolina");
/*  44 */           json3.sendJson(p2);
/*  45 */           jSon json4 = new jSon();
/*  46 */           json4.addText("§6- §eDiesel ")
/*  47 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/combustivel give " + p2.getName() + " diesel 1")
/*  48 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar um §aDiesel");
/*  49 */           json4.sendJson(p2);
/*  50 */           return true;
/*     */         }
/*  52 */         if (!args[0].equalsIgnoreCase("give")) {
/*  53 */           p2.sendMessage(Strings.Tag + "§cArgumentos Invalidos!");
/*  54 */           p2.sendMessage(Strings.Tag + " §eUse: /combustivel give <nick> <tipo> <quantia>");
/*  55 */           p2.sendMessage(Strings.Tag + " §eLista de Maquinas disponiveis: ");
/*  56 */           jSon json = new jSon();
/*  57 */           json.addText("§6- §ePetroleo ")
/*  58 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/combustivel give " + p2.getName() + " petroleo 1")
/*  59 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar um §aPetroleo");
/*  60 */           json.sendJson(p2);
/*  61 */           jSon json2 = new jSon();
/*  62 */           json2.addText("§6- §eEtanol ")
/*  63 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/combustivel give " + p2.getName() + " etanol 1")
/*  64 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar um §aEtanol");
/*  65 */           json2.sendJson(p2);
/*  66 */           jSon json3 = new jSon();
/*  67 */           json3.addText("§6- §eGasolina ")
/*  68 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/combustivel give " + p2.getName() + " gasolina 1")
/*  69 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar uma §aGasolina");
/*  70 */           json3.sendJson(p2);
/*  71 */           jSon json4 = new jSon();
/*  72 */           json4.addText("§6- §eDiesel ")
/*  73 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/combustivel give " + p2.getName() + " diesel 1")
/*  74 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar um §aDiesel");
/*  75 */           json4.sendJson(p2);
/*  76 */           return true;
/*     */         }
/*     */       }
/*     */       try {
/*  80 */         Player recebe = Bukkit.getPlayer(args[1]);
/*  81 */         if (args[2].equalsIgnoreCase("petroleo")) {
/*  82 */           MaquinasEvento.pm.setDisplayName("§0Petróleo");
/*  83 */           ArrayList<String> desc = new ArrayList();
/*  84 */           desc.add("§7Tipo: §f?");
/*  85 */           desc.add("§7Duração: §f1 M");
/*  86 */           MaquinasEvento.pm.setLore(desc);
/*  87 */           MaquinasEvento.petroleo.setAmount(Integer.valueOf(args[3]).intValue());
/*  88 */           MaquinasEvento.petroleo.setItemMeta(MaquinasEvento.pm);
/*     */           
/*  90 */           recebe.getInventory().addItem(new ItemStack[] { MaquinasEvento.petroleo });
/*  91 */           recebe.sendMessage(Strings.CombustivelGivado);
/*  92 */         } else if (args[2].equalsIgnoreCase("etanol")) {
/*  93 */           MaquinasEvento.em.setDisplayName("§4Combustivel I");
/*  94 */           ArrayList<String> desc = new ArrayList();
/*  95 */           desc.add("§7Tipo: §fEtanol");
/*  96 */           desc.add("§7Duração: §f1 M");
/*  97 */           MaquinasEvento.em.setLore(desc);
/*  98 */           MaquinasEvento.eta.setAmount(Integer.valueOf(args[3]).intValue());
/*  99 */           MaquinasEvento.eta.setItemMeta(MaquinasEvento.em);
/*     */           
/* 101 */           recebe.getInventory().addItem(new ItemStack[] { MaquinasEvento.eta });
/* 102 */           recebe.sendMessage(Strings.CombustivelGivado);
/* 103 */         } else if (args[2].equalsIgnoreCase("gasolina")) {
/* 104 */           MaquinasEvento.gm.setDisplayName("§4Combustivel II");
/* 105 */           ArrayList<String> desc1 = new ArrayList();
/* 106 */           desc1.add("§7Tipo: §fGasolina");
/* 107 */           desc1.add("§7Duração: §f5 M");
/* 108 */           MaquinasEvento.gm.setLore(desc1);
/* 109 */           MaquinasEvento.gas.setAmount(Integer.valueOf(args[3]).intValue());
/* 110 */           MaquinasEvento.gas.setItemMeta(MaquinasEvento.gm);
/*     */           
/* 112 */           recebe.getInventory().addItem(new ItemStack[] { MaquinasEvento.gas });
/* 113 */           recebe.sendMessage(Strings.CombustivelGivado);
/* 114 */         } else if (args[2].equalsIgnoreCase("diesel")) {
/* 115 */           MaquinasEvento.dm.setDisplayName("§4Combustivel III");
/* 116 */           ArrayList<String> desc2 = new ArrayList();
/* 117 */           desc2.add("§7Tipo: §fDiesel");
/* 118 */           desc2.add("§7Duração: §f25 M");
/* 119 */           MaquinasEvento.dm.setLore(desc2);
/* 120 */           MaquinasEvento.die.setAmount(Integer.valueOf(args[3]).intValue());
/* 121 */           MaquinasEvento.die.setItemMeta(MaquinasEvento.dm);
/*     */           
/* 123 */           recebe.getInventory().addItem(new ItemStack[] { MaquinasEvento.die });
/* 124 */           recebe.sendMessage(Strings.CombustivelGivado);
/*     */         } else {
/* 126 */           Bukkit.getConsoleSender().sendMessage(Strings.CombustivelNaoEncontrado);
/* 127 */           return true;
/*     */         }
/*     */       } catch (Exception io) {
/* 130 */         Bukkit.getConsoleSender().sendMessage(Strings.Tag + "§cErro ao executar o Comando!");
/*     */       }
/*     */     }
/* 133 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Diego\Desktop\MM-Maquinas.jar!\me\MMaquinas\Evento\ComandoGive.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */