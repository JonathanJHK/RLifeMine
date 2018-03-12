/*     */ package me.MMaquinas.Utils;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class jSon
/*     */ {
/*     */   public static enum ClickAction
/*     */   {
/*  14 */     RUN_COMMAND,  SUGGEST_COMMAND,  OPEN_URL;
/*     */   }
/*     */   
/*     */   public static enum HoverAction {
/*  18 */     SHOW_TEXT;
/*     */   }
/*     */   
/*  21 */   private static final String version = org.bukkit.Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
/*  22 */   private static final Pattern pattern = Pattern.compile("([&|§][a-fA-F0-9k-oK-orR]){1}");
/*     */   private ArrayList<String> partes;
/*  24 */   private String json = "";
/*     */   
/*     */   public jSon() {
/*  27 */     this.json += "[\"\",";
/*  28 */     this.partes = new ArrayList();
/*     */   }
/*     */   
/*     */   public jSon parseToJSON(String text) {
/*  32 */     Matcher matcher = pattern.matcher(text);
/*  33 */     if (matcher.find()) {
/*  34 */       String cor = "";
/*  35 */       String palavra = "";
/*  36 */       String geral = "";
/*  37 */       char[] array = text.toCharArray();
/*  38 */       for (int j = 0; j < array.length; j++) {
/*  39 */         if ((j + 1 != array.length) && (pattern.matcher(String.valueOf(array[j]) + String.valueOf(array[(j + 1)])).matches())) {
/*  40 */           cor = cor + String.valueOf(array[j]) + String.valueOf(array[(j + 1)]);
/*  41 */           j++;
/*     */         } else {
/*  43 */           palavra = palavra + array[j];
/*  44 */           if (j + 1 != array.length) {
/*  45 */             if (String.valueOf(array[(j + 1)]).matches("&|§"))
/*     */             {
/*     */ 
/*     */ 
/*  49 */               geral = geral + "{\"text\":\"" + palavra + "\"" + getFormat(cor) + "},";
/*  50 */               this.partes.add(geral);
/*  51 */               cor = "";
/*  52 */               palavra = "";
/*  53 */               geral = "";
/*     */             }
/*     */             
/*     */           }
/*     */           else
/*     */           {
/*  59 */             geral = geral + "{\"text\":\"" + palavra + "\"" + getFormat(cor) + "},";
/*  60 */             this.partes.add(geral);
/*  61 */             geral = "";
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   private String getFormat(String cor) {
/*  70 */     String retornar = "";
/*  71 */     if (cor.matches("(.+)?([&§]0)(.+)?")) retornar = retornar + ",\"color\":\"black\"";
/*  72 */     if (cor.matches("(.+)?([&§]1)(.+)?")) retornar = retornar + ",\"color\":\"dark_blue\"";
/*  73 */     if (cor.matches("(.+)?([&§]2)(.+)?")) retornar = retornar + ",\"color\":\"dark_green\"";
/*  74 */     if (cor.matches("(.+)?([&§]3)(.+)?")) retornar = retornar + ",\"color\":\"dark_aqua\"";
/*  75 */     if (cor.matches("(.+)?([&§]4)(.+)?")) retornar = retornar + ",\"color\":\"dark_red\"";
/*  76 */     if (cor.matches("(.+)?([&§]5)(.+)?")) retornar = retornar + ",\"color\":\"dark_purple\"";
/*  77 */     if (cor.matches("(.+)?([&§]6)(.+)?")) retornar = retornar + ",\"color\":\"gold\"";
/*  78 */     if (cor.matches("(.+)?([&§]7)(.+)?")) retornar = retornar + ",\"color\":\"gray\"";
/*  79 */     if (cor.matches("(.+)?([&§]8)(.+)?")) retornar = retornar + ",\"color\":\"dark_gray\"";
/*  80 */     if (cor.matches("(.+)?([&§]9)(.+)?")) retornar = retornar + ",\"color\":\"blue\"";
/*  81 */     if (cor.matches("(.+)?([&§]a)(.+)?")) retornar = retornar + ",\"color\":\"green\"";
/*  82 */     if (cor.matches("(.+)?([&§]b)(.+)?")) retornar = retornar + ",\"color\":\"aqua\"";
/*  83 */     if (cor.matches("(.+)?([&§]c)(.+)?")) retornar = retornar + ",\"color\":\"red\"";
/*  84 */     if (cor.matches("(.+)?([&§]d)(.+)?")) retornar = retornar + ",\"color\":\"light_purple\"";
/*  85 */     if (cor.matches("(.+)?([&§]e)(.+)?")) retornar = retornar + ",\"color\":\"yellow\"";
/*  86 */     if (cor.matches("(.+)?([&§]f)(.+)?")) retornar = retornar + ",\"color\":\"white\"";
/*  87 */     if (cor.matches("(.+)?([&§]k)(.+)?")) retornar = retornar + ",\"obfuscated\":true";
/*  88 */     if (cor.matches("(.+)?([&§]l)(.+)?")) retornar = retornar + ",\"bold\":true";
/*  89 */     if (cor.matches("(.+)?([&§]m)(.+)?")) retornar = retornar + ",\"strikethrough\":true";
/*  90 */     if (cor.matches("(.+)?([&§]n)(.+)?")) retornar = retornar + ",\"underlined\":true";
/*  91 */     if (cor.matches("(.+)?([&§]o)(.+)?")) retornar = retornar + ",\"italic\":true";
/*  92 */     return retornar;
/*     */   }
/*     */   
/*     */   public jSon addText(String text) {
/*  96 */     if (this.partes.size() > 0) {
/*  97 */       for (String parte : this.partes) {
/*  98 */         this.json += parte;
/*     */       }
/* 100 */       this.partes.clear();
/*     */     }
/* 102 */     Matcher matcher = pattern.matcher(text);
/* 103 */     if (matcher.find()) {
/* 104 */       parseToJSON(text);
/*     */     } else {
/* 106 */       this.json = (this.json + "{\"text\":\"" + text + "\"},");
/*     */     }
/* 108 */     return this;
/*     */   }
/*     */   
/*     */   public jSon withHoverAction(HoverAction hoveraction, String value) {
/* 112 */     for (int i = 0; i < this.partes.size(); i++) {
/* 113 */       String parte = (String)this.partes.get(i);
/* 114 */       if (parte.endsWith("},")) parte = parte.substring(0, parte.length() - 2);
/* 115 */       parte = parte + ",\"hoverEvent\":{\"action\":\"" + hoveraction.name().toLowerCase() + "\",\"value\":\"" + value + "\"}},";
/* 116 */       this.partes.set(i, parte);
/*     */     }
/* 118 */     return this;
/*     */   }
/*     */   
/*     */   public jSon withClickAction(ClickAction clickaction, String value) {
/* 122 */     for (int i = 0; i < this.partes.size(); i++) {
/* 123 */       String parte = (String)this.partes.get(i);
/* 124 */       if (parte.endsWith("},")) parte = parte.substring(0, parte.length() - 2);
/* 125 */       parte = parte + ",\"clickEvent\":{\"action\":\"" + clickaction.name().toLowerCase() + "\",\"value\":\"" + value + "\"}},";
/* 126 */       this.partes.set(i, parte);
/*     */     }
/* 128 */     return this;
/*     */   }
/*     */   
/*     */   public jSon removeLastElement() {
/* 132 */     if (this.partes.size() > 0) {
/* 133 */       for (String parte : this.partes) {
/* 134 */         this.json += parte;
/*     */       }
/* 136 */       this.partes.clear();
/*     */     }
/* 138 */     this.json = this.json.substring(0, this.json.lastIndexOf("{\"text\":\""));
/* 139 */     return this;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 144 */     return this.json;
/*     */   }
/*     */   
/*     */   public void sendJson(Player p) {
/*     */     try {
/* 149 */       if (this.partes.size() > 0) {
/* 150 */         for (String parte : this.partes) {
/* 151 */           this.json += parte;
/*     */         }
/* 153 */         this.partes.clear();
/*     */       }
/* 155 */       if (this.json.endsWith(",")) this.json = this.json.substring(0, this.json.length() - 1);
/* 156 */       if (!this.json.endsWith("]")) { this.json += "]";
/*     */       }
/* 158 */       Class<?> chatSerializer = Class.forName("net.minecraft.server." + version + ".IChatBaseComponent$ChatSerializer");
/* 159 */       Object chatComponent = Class.forName("net.minecraft.server." + version + ".IChatBaseComponent");
/* 160 */       Class<?> packet = Class.forName("net.minecraft.server." + version + ".PacketPlayOutChat");
/* 161 */       Constructor<?> constructor = packet.getConstructor(new Class[] { chatComponent });
/*     */       
/* 163 */       Object text = chatSerializer.getMethod("a", new Class[] { String.class }).invoke(chatSerializer, new Object[] { this.json });
/* 164 */       Object packetFinal = constructor.newInstance(new Object[] { text });
/*     */       
/* 166 */       Object handle = p.getClass().getMethod("getHandle", new Class[0]).invoke(p, new Object[0]);
/* 167 */       Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
/* 168 */       playerConnection.getClass().getMethod("sendPacket", new Class[] { Class.forName("net.minecraft.server." + version + ".Packet") }).invoke(playerConnection, new Object[] { packetFinal });
/*     */     } catch (Exception e) {
/* 170 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Diego\Desktop\MM-Maquinas.jar!\me\MMaquinas\Utils\jSon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */