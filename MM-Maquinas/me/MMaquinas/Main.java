/*    */ package me.MMaquinas;
/*    */ 
/*    */ import me.MMaquinas.Utils.Strings;
/*    */ import net.milkbowl.vault.chat.Chat;
/*    */ import net.milkbowl.vault.economy.Economy;
/*    */ import net.milkbowl.vault.permission.Permission;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.ConsoleCommandSender;
/*    */ import org.bukkit.command.PluginCommand;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ import org.bukkit.plugin.RegisteredServiceProvider;
/*    */ import org.bukkit.plugin.ServicesManager;
/*    */ 
/*    */ public class Main extends org.bukkit.plugin.java.JavaPlugin
/*    */ {
/*    */   public static Plugin plugin;
/*    */   
/*    */   public static Plugin getPlugin()
/*    */   {
/* 22 */     return plugin;
/*    */   }
/*    */   
/*    */   public void onEnable()
/*    */   {
/* 27 */     Bukkit.getServer().getConsoleSender().sendMessage("§3----------------------------------------------------------");
/* 28 */     Bukkit.getServer().getConsoleSender().sendMessage("§6MM-Máquinas: §aAtivado Com Sucesso!!");
/* 29 */     Bukkit.getServer().getConsoleSender().sendMessage("§6Criador: §azMarcDev.");
/* 30 */     Bukkit.getServer().getConsoleSender().sendMessage("§cKIBE: §aWorldNetowrk.");
/* 31 */     Bukkit.getServer().getConsoleSender().sendMessage("§3----------------------------------------------------------");
/*    */     
/* 33 */     PluginManager pm = Bukkit.getServer().getPluginManager();
/* 34 */     pm.registerEvents(new me.MMaquinas.Evento.MaquinasEvento(), this);
/* 35 */     getCommand("combustivel").setExecutor(new me.MMaquinas.Evento.ComandoGive());
/* 36 */     getCommand("maquina").setExecutor(new me.MMaquinas.Evento.GiveMachine());
/*    */     
/* 38 */     plugin = this;
/*    */     
/* 40 */     Strings.Maquina1Config();
/* 41 */     Strings.Maquina2Config();
/* 42 */     Strings.Maquina3Config();
/* 43 */     Strings.Maquina4Config();
/* 44 */     Strings.Maquina5Config();
/* 45 */     Strings.Maquina6Config();
/* 46 */     Strings.RefinariaConfig();
/* 47 */     Strings.Etanol();
/* 48 */     Strings.Gasolina();
/* 49 */     Strings.Diesel();
/* 50 */     Strings.Mensagens();
/* 51 */     Strings.Permissoes();
/* 52 */     Strings.Limites();
/* 53 */     setupChat();
/* 54 */     setupPermissions();
/* 55 */     setupEconomy();
/* 56 */     saveDefaultConfig();
/*    */   }
/*    */   
/*    */ 
/*    */   public void onDisable() {}
/*    */   
/*    */ 
/* 63 */   public static Permission permission = null;
/* 64 */   public static Economy economy = null;
/* 65 */   public static Chat chat = null;
/*    */   
/*    */   private boolean setupPermissions() {
/* 68 */     RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(Permission.class);
/* 69 */     if (permissionProvider != null) {
/* 70 */       permission = (Permission)permissionProvider.getProvider();
/*    */     }
/* 72 */     return permission != null;
/*    */   }
/*    */   
/*    */   private boolean setupChat() {
/* 76 */     RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(Chat.class);
/* 77 */     if (chatProvider != null) {
/* 78 */       chat = (Chat)chatProvider.getProvider();
/*    */     }
/* 80 */     return chat != null;
/*    */   }
/*    */   
/*    */   private boolean setupEconomy() {
/* 84 */     RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
/* 85 */     if (economyProvider != null) {
/* 86 */       economy = (Economy)economyProvider.getProvider();
/*    */     }
/* 88 */     return economy != null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Diego\Desktop\MM-Maquinas.jar!\me\MMaquinas\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */