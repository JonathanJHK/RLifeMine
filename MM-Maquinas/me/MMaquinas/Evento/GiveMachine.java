/*     */ package me.MMaquinas.Evento;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import me.MMaquinas.Utils.Strings;
/*     */ import me.MMaquinas.Utils.jSon;
/*     */ import me.MMaquinas.Utils.jSon.ClickAction;
/*     */ import me.MMaquinas.Utils.jSon.HoverAction;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.command.ConsoleCommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ public class GiveMachine implements CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] args)
/*     */   {
/*  23 */     if (Cmd.getName().equalsIgnoreCase("maquina")) {
/*  24 */       if ((Sender instanceof Player)) {
/*  25 */         Player p = (Player)Sender;
/*  26 */         if (!p.hasPermission(Strings.perm)) {
/*  27 */           p.sendMessage(Strings.p);
/*  28 */           return true;
/*     */         }
/*  30 */         if (args.length != 4) {
/*  31 */           p.sendMessage(Strings.Tag + "§cArgumentos Invalidos!");
/*  32 */           p.sendMessage(Strings.Tag + " §eUse: /maquina give <nick> <tipo> <quantia>");
/*  33 */           p.sendMessage(Strings.Tag + " §eLista de Maquinas disponiveis: ");
/*  34 */           jSon json = new jSon();
/*  35 */           json.addText("§6- §eMaquina1 ")
/*  36 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/maquina give " + p.getName() + " maquina1")
/*  37 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar a §aMaquina1");
/*  38 */           json.sendJson(p);
/*  39 */           jSon json1 = new jSon();
/*  40 */           json1.addText("§6- §eMaquina2 ")
/*  41 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/maquina give " + p.getName() + " maquina2")
/*  42 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar a §aMaquina2");
/*  43 */           json1.sendJson(p);
/*  44 */           jSon json2 = new jSon();
/*  45 */           json2.addText("§6- §eMaquina3 ")
/*  46 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/maquina give " + p.getName() + " maquina3")
/*  47 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar a §aMaquina3");
/*  48 */           json2.sendJson(p);
/*  49 */           jSon json3 = new jSon();
/*  50 */           json3.addText("§6- §eMaquina4 ")
/*  51 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/maquina give " + p.getName() + " maquina4")
/*  52 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar a §aMaquina4");
/*  53 */           json3.sendJson(p);
/*  54 */           jSon json4 = new jSon();
/*  55 */           json4.addText("§6- §eMaquina5 ")
/*  56 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/maquina give " + p.getName() + " maquina5")
/*  57 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar a §aMaquina5");
/*  58 */           json4.sendJson(p);
/*  59 */           jSon json5 = new jSon();
/*  60 */           json5.addText("§6- §eMaquina6 ")
/*  61 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/maquina give " + p.getName() + " maquina6")
/*  62 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar a §aMaquina6");
/*  63 */           json5.sendJson(p);
/*  64 */           jSon json6 = new jSon();
/*  65 */           json6.addText("§6- §eRefinaria ")
/*  66 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/maquina give " + p.getName() + " refinaria")
/*  67 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar a §aRefinaria");
/*  68 */           json6.sendJson(p);
/*  69 */           return true;
/*     */         }
/*  71 */         if (!args[0].equalsIgnoreCase("give")) {
/*  72 */           p.sendMessage(Strings.Tag + "§cArgumentos Invalidos!");
/*  73 */           p.sendMessage(Strings.Tag + " §eUse: /maquina give <nick> <tipo> <quantia>");
/*  74 */           p.sendMessage(Strings.Tag + " §eLista de Maquinas disponiveis: ");
/*  75 */           jSon json = new jSon();
/*  76 */           json.addText("§6- §eMaquina1 ")
/*  77 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/maquina give " + p.getName() + " maquina1")
/*  78 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar a §aMaquina1");
/*  79 */           json.sendJson(p);
/*  80 */           jSon json1 = new jSon();
/*  81 */           json1.addText("§6- §eMaquina2 ")
/*  82 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/maquina give " + p.getName() + " maquina2")
/*  83 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar a §aMaquina2");
/*  84 */           json1.sendJson(p);
/*  85 */           jSon json2 = new jSon();
/*  86 */           json2.addText("§6- §eMaquina3 ")
/*  87 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/maquina give " + p.getName() + " maquina3")
/*  88 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar a §aMaquina3");
/*  89 */           json2.sendJson(p);
/*  90 */           jSon json3 = new jSon();
/*  91 */           json3.addText("§6- §eMaquina4 ")
/*  92 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/maquina give " + p.getName() + " maquina4")
/*  93 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar a §aMaquina4");
/*  94 */           json3.sendJson(p);
/*  95 */           jSon json4 = new jSon();
/*  96 */           json4.addText("§6- §eMaquina5 ")
/*  97 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/maquina give " + p.getName() + " maquina5")
/*  98 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar a §aMaquina5");
/*  99 */           json4.sendJson(p);
/* 100 */           jSon json5 = new jSon();
/* 101 */           json5.addText("§6- §eMaquina6 ")
/* 102 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/maquina give " + p.getName() + " maquina6")
/* 103 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar a §aMaquina6");
/* 104 */           json5.sendJson(p);
/* 105 */           jSon json6 = new jSon();
/* 106 */           json6.addText("§6- §eRefinaria ")
/* 107 */             .withClickAction(jSon.ClickAction.RUN_COMMAND, "/maquina give " + p.getName() + " refinaria")
/* 108 */             .withHoverAction(jSon.HoverAction.SHOW_TEXT, "§7Clique para pegar a §aRefinaria");
/* 109 */           json6.sendJson(p);
/* 110 */           return true;
/*     */         }
/*     */       }
/* 113 */       Player recebe = Bukkit.getPlayer(args[1]);
/* 114 */       if (recebe == null) {
/* 115 */         Bukkit.getConsoleSender().sendMessage("§cEste player nao esta online ou nao existe!");
/* 116 */         return true;
/*     */       }
/* 118 */       if (args[2].equalsIgnoreCase("Maquina1")) {
/* 119 */         ItemStack Maquina1 = new ItemStack(Material.getMaterial(Strings.Maquina1Bloco));
/* 120 */         ItemMeta Maquina1Meta = Maquina1.getItemMeta();
/* 121 */         Maquina1Meta.setDisplayName(Strings.Maquina1Nome);
/* 122 */         ArrayList<String> desc = new ArrayList();
/* 123 */         desc.add("§7Tipo: " + Strings.Maquina1Tipo);
/* 124 */         Maquina1Meta.setLore(desc);
/* 125 */         Maquina1.setAmount(Integer.valueOf(args[3]).intValue());
/* 126 */         Maquina1.setItemMeta(Maquina1Meta);
/*     */         
/* 128 */         recebe.getInventory().addItem(new ItemStack[] { Maquina1 });
/* 129 */         recebe.sendMessage(Strings.MaquinaGivada);
/* 130 */         Bukkit.getConsoleSender().sendMessage("§aOperação realizada com sucesso!");
/* 131 */       } else if (args[2].equalsIgnoreCase("Maquina2")) {
/* 132 */         ItemStack Maquina2 = new ItemStack(Material.getMaterial(Strings.Maquina2Bloco));
/* 133 */         ItemMeta Maquina2Meta = Maquina2.getItemMeta();
/* 134 */         Maquina2Meta.setDisplayName(Strings.Maquina2Nome);
/* 135 */         ArrayList<String> desc = new ArrayList();
/* 136 */         desc.add("§7Tipo: " + Strings.Maquina2Tipo);
/* 137 */         Maquina2Meta.setLore(desc);
/* 138 */         Maquina2.setAmount(Integer.valueOf(args[3]).intValue());
/* 139 */         Maquina2.setItemMeta(Maquina2Meta);
/*     */         
/* 141 */         recebe.getInventory().addItem(new ItemStack[] { Maquina2 });
/* 142 */         recebe.sendMessage(Strings.MaquinaGivada);
/* 143 */         Bukkit.getConsoleSender().sendMessage("§aOperação realizada com sucesso!");
/* 144 */       } else if (args[2].equalsIgnoreCase("Maquina3")) {
/* 145 */         ItemStack Maquina3 = new ItemStack(Material.getMaterial(Strings.Maquina3Bloco));
/* 146 */         ItemMeta Maquina3Meta = Maquina3.getItemMeta();
/* 147 */         Maquina3Meta.setDisplayName(Strings.Maquina3Nome);
/* 148 */         ArrayList<String> desc = new ArrayList();
/* 149 */         desc.add("§7Tipo: " + Strings.Maquina3Tipo);
/* 150 */         Maquina3Meta.setLore(desc);
/* 151 */         Maquina3.setAmount(Integer.valueOf(args[3]).intValue());
/* 152 */         Maquina3.setItemMeta(Maquina3Meta);
/*     */         
/* 154 */         recebe.getInventory().addItem(new ItemStack[] { Maquina3 });
/* 155 */         recebe.sendMessage(Strings.MaquinaGivada);
/* 156 */         Bukkit.getConsoleSender().sendMessage("§aOperação realizada com sucesso!");
/* 157 */       } else if (args[2].equalsIgnoreCase("Maquina4")) {
/* 158 */         ItemStack Maquina4 = new ItemStack(Material.getMaterial(Strings.Maquina4Bloco));
/* 159 */         ItemMeta Maquina4Meta = Maquina4.getItemMeta();
/* 160 */         Maquina4Meta.setDisplayName(Strings.Maquina4Nome);
/* 161 */         ArrayList<String> desc = new ArrayList();
/* 162 */         desc.add("§7Tipo:" + Strings.Maquina4Tipo);
/* 163 */         Maquina4Meta.setLore(desc);
/* 164 */         Maquina4.setAmount(Integer.valueOf(args[3]).intValue());
/* 165 */         Maquina4.setItemMeta(Maquina4Meta);
/*     */         
/* 167 */         recebe.getInventory().addItem(new ItemStack[] { Maquina4 });
/* 168 */         recebe.sendMessage(Strings.MaquinaGivada);
/* 169 */         Bukkit.getConsoleSender().sendMessage("§aOperação realizada com sucesso!");
/* 170 */       } else if (args[2].equalsIgnoreCase("Maquina5")) {
/* 171 */         ItemStack Maquina5 = new ItemStack(Material.getMaterial(Strings.Maquina5Bloco));
/* 172 */         ItemMeta Maquina5Meta = Maquina5.getItemMeta();
/* 173 */         Maquina5Meta.setDisplayName(Strings.Maquina5Nome);
/* 174 */         ArrayList<String> desc = new ArrayList();
/* 175 */         desc.add("§7Tipo: " + Strings.Maquina5Tipo);
/* 176 */         Maquina5Meta.setLore(desc);
/* 177 */         Maquina5.setAmount(Integer.valueOf(args[3]).intValue());
/* 178 */         Maquina5.setItemMeta(Maquina5Meta);
/*     */         
/* 180 */         recebe.getInventory().addItem(new ItemStack[] { Maquina5 });
/* 181 */         recebe.sendMessage(Strings.MaquinaGivada);
/* 182 */         Bukkit.getConsoleSender().sendMessage("§aOperação realizada com sucesso!");
/* 183 */       } else if (args[2].equalsIgnoreCase("Maquina6")) {
/* 184 */         ItemStack Maquina6 = new ItemStack(Material.getMaterial(Strings.Maquina6Bloco));
/* 185 */         ItemMeta Maquina6Meta = Maquina6.getItemMeta();
/* 186 */         Maquina6Meta.setDisplayName(Strings.Maquina6Nome);
/* 187 */         ArrayList<String> desc = new ArrayList();
/* 188 */         desc.add("§7Tipo:  " + Strings.Maquina6Tipo);
/* 189 */         Maquina6Meta.setLore(desc);
/* 190 */         Maquina6.setAmount(Integer.valueOf(args[3]).intValue());
/* 191 */         Maquina6.setItemMeta(Maquina6Meta);
/*     */         
/* 193 */         recebe.getInventory().addItem(new ItemStack[] { Maquina6 });
/* 194 */         recebe.sendMessage(Strings.MaquinaGivada);
/* 195 */         Bukkit.getConsoleSender().sendMessage("§aOperação realizada com sucesso!");
/* 196 */       } else if (args[2].equalsIgnoreCase("refinaria")) {
/* 197 */         ItemStack Refinaria1 = new ItemStack(Material.getMaterial(Strings.RefinariaBloco));
/* 198 */         ItemMeta Refinaria1Meta = Refinaria1.getItemMeta();
/* 199 */         Refinaria1Meta.setDisplayName(Strings.RefinariaNome);
/* 200 */         ArrayList<String> desc = new ArrayList();
/* 201 */         desc.add("§7Tipo: " + Strings.RefinariaTipo);
/* 202 */         Refinaria1Meta.setLore(desc);
/* 203 */         Refinaria1.setAmount(Integer.valueOf(args[3]).intValue());
/* 204 */         Refinaria1.setItemMeta(Refinaria1Meta);
/*     */         
/* 206 */         recebe.getInventory().addItem(new ItemStack[] { Refinaria1 });
/* 207 */         recebe.sendMessage(Strings.MaquinaGivada);
/* 208 */         Bukkit.getConsoleSender().sendMessage("§aOperação realizada com sucesso!");
/*     */       } else {
/* 210 */         Bukkit.getConsoleSender().sendMessage(Strings.MaquinaNaoEncontrada);
/* 211 */         return true;
/*     */       }
/*     */     }
/* 214 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Diego\Desktop\MM-Maquinas.jar!\me\MMaquinas\Evento\GiveMachine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */