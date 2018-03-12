/*     */ package me.MMaquinas.Utils;
/*     */ 
/*     */ import me.MMaquinas.Main;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ public class Strings
/*     */ {
/*     */   public static String Tag;
/*     */   public static String acharpetroleo;
/*     */   public static String p;
/*     */   public static String RemoverMaquina;
/*     */   public static String SemMoney;
/*     */   public static String ComprouMaquina;
/*     */   public static String LigouMaquina;
/*     */   public static String AcabouCombustivel;
/*     */   public static String JaEstaAbastecida;
/*     */   public static String ColocarMaquina;
/*     */   public static String MaquinaNaoEncontrada;
/*     */   public static String CombustivelNaoEncontrado;
/*     */   public static String MaquinaGivada;
/*     */   public static String CombustivelGivado;
/*     */   public static String semquebrar;
/*     */   public static String perm;
/*     */   public static boolean vendacap;
/*     */   public static boolean vendacouro;
/*     */   public static boolean vendaxp;
/*     */   public static boolean vendanether;
/*     */   public static boolean vendaslime;
/*     */   public static boolean vendaferro;
/*     */   public static boolean GanharEta;
/*     */   
/*     */   public static boolean EtaisFalse()
/*     */   {
/*  19 */     if (!GanharEta) {
/*  20 */       return true;
/*     */     }
/*  22 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean GanharGas;
/*     */   public static boolean GanharDie;
/*     */   public static int Limite;
/*     */   public static int LimiteVip;
/*     */   
/*     */   public static boolean GasisFalse()
/*     */   {
/*  26 */     if (!GanharGas) {
/*  27 */       return true;
/*     */     }
/*  29 */     return false;
/*     */   }
/*     */   
/*     */   public static int BlocosQuebrados;
/*     */   public static String PermLimite;
/*     */   public static String ntotal;
/*     */   public static String Maquina1Nome;
/*     */   
/*     */   public static boolean DieisFalse()
/*     */   {
/*  33 */     if (!GanharDie) {
/*  34 */       return true;
/*     */     }
/*  36 */     return false;
/*     */   }
/*     */   
/*     */   public static String Maquina1ID;
/*     */   public static String Maquina1Tipo;
/*     */   public static int Maquina1Preco;
/*     */   
/*     */   public static boolean Maquina3isFalse()
/*     */   {
/*  41 */     if (!Maquina3Vender) {
/*  42 */       return true;
/*     */     }
/*  44 */     return false;
/*     */   }
/*     */   
/*     */   public static int Maquina1Coldown;
/*     */   public static int Maquina1Quantia;
/*     */   public static int Maquina1Bloco;
/*     */   
/*     */   public static boolean Maquina6isFalse()
/*     */   {
/*  48 */     if (!Maquina6Vender) {
/*  49 */       return true;
/*     */     }
/*  51 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean Maquina1Vender;
/*     */   public static String Maquina2Nome;
/*     */   
/*     */   public static boolean Maquina4isFalse()
/*     */   {
/*  55 */     if (!Maquina4Vender) {
/*  56 */       return true;
/*     */     }
/*  58 */     return false;
/*     */   }
/*     */   
/*     */   public static String Maquina2ID;
/*     */   public static String Maquina2Tipo;
/*     */   public static int Maquina2Preco;
/*     */   public static boolean Maquina1isFalse()
/*     */   {
/*  62 */     if (!Maquina1Vender) {
/*  63 */       return true;
/*     */     }
/*  65 */     return false;
/*     */   }
/*     */   public static int Maquina2Coldown;
/*     */   public static int Maquina2Quantia;
/*     */   public static int Maquina2Bloco;
/*     */   
/*     */   public static boolean Maquina2isFalse()
/*     */   {
/*  69 */     if (!Maquina2Vender) {
/*  70 */       return true;
/*     */     }
/*  72 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean Maquina2Vender;
/*     */   public static String Maquina3Nome;
/*     */   public static String Maquina3ID;
/*     */   
/*     */   public static boolean Maquina5isFalse()
/*     */   {
/*  76 */     if (!Maquina5Vender) {
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public static String Maquina3Tipo;
/*     */   public static int Maquina3Preco;
/*     */   public static int Maquina3Coldown;
/*     */   public static int Maquina3Quantia;
/*     */   public static int Maquina3Bloco;
/*     */   
/*     */   public static boolean RefinariaisFalse()
/*     */   {
/*  83 */     if (!RefinariaVender) {
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean Maquina3Vender;
/*     */   public static String Maquina4Nome;
/*     */   public static String Maquina4ID;
/*     */   public static String Maquina4Tipo;
/*     */   public static int Maquina4Preco;
/*     */   
/*     */   public static void Limites()
/*     */   {
/*  94 */     if (Main.getPlugin().getConfig().get("Outros.Limite de Maquinas para Player Normais (0 para False)") == null) {
/*  95 */       Main.getPlugin().getConfig().set("Outros.Limite de Maquinas para Player Normais (0 para False)", Integer.valueOf(0));
/*  96 */       Main.getPlugin().saveConfig();
/*  97 */       Limite = Main.getPlugin().getConfig().getInt("Outros.Limite de Maquinas para Player Normais (0 para False)");
/*     */     } else {
/*  99 */       Limite = Main.getPlugin().getConfig().getInt("Outros.Limite de Maquinas para Player Normais (0 para False)");
/*     */     }
/* 101 */     if (Main.getPlugin().getConfig().get("Outros.Limite de Maquinas para Player Vips (0 para False)") == null) {
/* 102 */       Main.getPlugin().getConfig().set("Outros.Limite de Maquinas para Player Vips (0 para False)", Integer.valueOf(0));
/* 103 */       Main.getPlugin().saveConfig();
/* 104 */       LimiteVip = Main.getPlugin().getConfig().getInt("Outros.Limite de Maquinas para Player Vips (0 para False)");
/*     */     } else {
/* 106 */       LimiteVip = Main.getPlugin().getConfig().getInt("Outros.Limite de Maquinas para Player Vips (0 para False)");
/*     */     }
/* 108 */     if (Main.getPlugin().getConfig().get("Outros.Quantia de Blocos quebrados Para sortear Petroleo") == null)
/*     */     {
/* 109 */       Main.getPlugin().getConfig().set("Outros.Quantia de Blocos quebrados Para sortear Petroleo", Integer.valueOf(200));
/* 110 */       Main.getPlugin().saveConfig();
/* 111 */       BlocosQuebrados = Main.getPlugin().getConfig().getInt("Outros.Quantia de Blocos quebrados Para sortear Petroleo");
/*     */     }
/*     */     else
/*     */     {
/* 113 */       BlocosQuebrados = Main.getPlugin().getConfig().getInt("Outros.Quantia de Blocos quebrados Para sortear Petroleo");
/*     */     }
/*     */   }
/*     */   
/*     */   public static int Maquina4Coldown;
/*     */   public static int Maquina4Quantia;
/*     */   public static int Maquina4Bloco;
/*     */   public static boolean Maquina4Vender;
/*     */   public static String Maquina5Nome;
/*     */   public static void Mensagens()
/*     */   {
/* 121 */     if (Main.getPlugin().getConfig().get("Mensagens.Tag") == null) {
/* 122 */       Main.getPlugin().getConfig().set("Mensagens.Tag", String.valueOf("&6&l[WMachine] &e"));
/* 123 */       Main.getPlugin().saveConfig();
/* 124 */       Tag = Main.getPlugin().getConfig().getString("Mensagens.Tag").replace("&", "§");
/*     */     } else {
/* 126 */       Tag = Main.getPlugin().getConfig().getString("Mensagens.Tag").replace("&", "§");
/*     */     }
/* 128 */     if (Main.getPlugin().getConfig().get("Mensagens.Numero de Maquinas Atingido") == null) {
/* 129 */       Main.getPlugin().getConfig().set("Mensagens.Numero de Maquinas Atingido", String.valueOf("§cNumero de Maquinas totais Atingido!"));
/* 130 */       Main.getPlugin().saveConfig();
/* 131 */       ntotal = Tag + Main.getPlugin().getConfig().getString("Mensagens.Numero de Maquinas Atingido").replace("&", "§");
/*     */     } else {
/* 133 */       ntotal = Tag + Main.getPlugin().getConfig().getString("Mensagens.Numero de Maquinas Atingido").replace("&", "§");
/*     */     }
/* 135 */     if (Main.getPlugin().getConfig().get("Mensagens.SemPermissao") == null) {
/* 136 */       Main.getPlugin().getConfig().set("Mensagens.SemPermissao", String.valueOf("§cComando Exclusivo Para Staffers!"));
/* 137 */       Main.getPlugin().saveConfig();
/* 138 */       p = Tag + Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§");
/*     */     } else {
/* 140 */       p = Tag + Main.getPlugin().getConfig().getString("Mensagens.SemPermissao").replace("&", "§");
/*     */     }
/* 142 */     if (Main.getPlugin().getConfig().get("Mensagens.Achou Combustivel/Petroleo") == null) {
/* 143 */       Main.getPlugin().getConfig().set("Mensagens.Achou Combustivel/Petroleo", String.valueOf("Você achou algo bem interessante minerando!"));
/* 144 */       Main.getPlugin().saveConfig();
/* 145 */       acharpetroleo = Tag + Main.getPlugin().getConfig().getString("Mensagens.Achou Combustivel/Petroleo").replace("&", "§");
/*     */     } else {
/* 147 */       acharpetroleo = Tag + Main.getPlugin().getConfig().getString("Mensagens.Achou Combustivel/Petroleo").replace("&", "§");
/*     */     }
/* 149 */     if (Main.getPlugin().getConfig().get("Mensagens.MaquinaColocada") == null) {
/* 150 */       Main.getPlugin().getConfig().set("Mensagens.MaquinaColocada", String.valueOf("Máquina instalada, para fazê-la funcionar, coloque seu combustível."));
/* 151 */       Main.getPlugin().saveConfig();
/* 152 */       ColocarMaquina = Tag + Main.getPlugin().getConfig().getString("Mensagens.MaquinaColocada").replace("&", "§");
/*     */     } else {
/* 154 */       ColocarMaquina = Tag + Main.getPlugin().getConfig().getString("Mensagens.MaquinaColocada").replace("&", "§");
/*     */     }
/* 156 */     if (Main.getPlugin().getConfig().get("Mensagens.RemoverMaquina") == null) {
/* 157 */       Main.getPlugin().getConfig().set("Mensagens.RemoverMaquina", String.valueOf("Máquina removida, Ajude o meio ambiente!"));
/* 158 */       Main.getPlugin().saveConfig();
/* 159 */       RemoverMaquina = Tag + Main.getPlugin().getConfig().getString("Mensagens.RemoverMaquina").replace("&", "§");
/*     */     } else {
/* 161 */       RemoverMaquina = Tag + Main.getPlugin().getConfig().getString("Mensagens.RemoverMaquina").replace("&", "§");
/*     */     }
/* 163 */     if (Main.getPlugin().getConfig().get("Mensagens.SemMoney") == null) {
/* 164 */       Main.getPlugin().getConfig().set("Mensagens.SemMoney", String.valueOf("Você não tem dinheiro para comprar essa maquina."));
/* 165 */       Main.getPlugin().saveConfig();
/* 166 */       SemMoney = Tag + Main.getPlugin().getConfig().getString("Mensagens.SemMoney").replace("&", "§");
/*     */     } else {
/* 168 */       SemMoney = Tag + Main.getPlugin().getConfig().getString("Mensagens.SemMoney").replace("&", "§");
/*     */     }
/* 170 */     if (Main.getPlugin().getConfig().get("Mensagens.ComprouMaquina") == null) {
/* 171 */       Main.getPlugin().getConfig().set("Mensagens.ComprouMaquina", String.valueOf("Maquina comprada com sucesso."));
/* 172 */       Main.getPlugin().saveConfig();
/* 173 */       ComprouMaquina = Tag + Main.getPlugin().getConfig().getString("Mensagens.ComprouMaquina").replace("&", "§");
/*     */     } else {
/* 175 */       ComprouMaquina = Tag + Main.getPlugin().getConfig().getString("Mensagens.ComprouMaquina").replace("&", "§");
/*     */     }
/* 177 */     if (Main.getPlugin().getConfig().get("Mensagens.LigouMaquina") == null) {
/* 178 */       Main.getPlugin().getConfig().set("Mensagens.LigouMaquina", String.valueOf("Maquina funcionando a todo vapor!"));
/* 179 */       Main.getPlugin().saveConfig();
/* 180 */       LigouMaquina = Tag + Main.getPlugin().getConfig().getString("Mensagens.LigouMaquina").replace("&", "§");
/*     */     } else {
/* 182 */       LigouMaquina = Tag + Main.getPlugin().getConfig().getString("Mensagens.LigouMaquina").replace("&", "§");
/*     */     }
/* 184 */     if (Main.getPlugin().getConfig().get("Mensagens.AcabouCombustivel") == null) {
/* 185 */       Main.getPlugin().getConfig().set("Mensagens.AcabouCombustivel", String.valueOf("Acabou o combustivel em sua Maquina!"));
/* 186 */       Main.getPlugin().saveConfig();
/* 187 */       AcabouCombustivel = Tag + Main.getPlugin().getConfig().getString("Mensagens.AcabouCombustivel").replace("&", "§");
/*     */     } else {
/* 189 */       AcabouCombustivel = Tag + Main.getPlugin().getConfig().getString("Mensagens.AcabouCombustivel").replace("&", "§");
/*     */     }
/* 191 */     if (Main.getPlugin().getConfig().get("Mensagens.JaEstaAbastecida") == null) {
/* 192 */       Main.getPlugin().getConfig().set("Mensagens.JaEstaAbastecida", String.valueOf("Essa maquina ja foi abastecida com um combustivel, aguarde para colocar outro!"));
/* 193 */       Main.getPlugin().saveConfig();
/* 194 */       JaEstaAbastecida = Tag + Main.getPlugin().getConfig().getString("Mensagens.JaEstaAbastecida").replace("&", "§");
/*     */     } else {
/* 196 */       JaEstaAbastecida = Tag + Main.getPlugin().getConfig().getString("Mensagens.JaEstaAbastecida").replace("&", "§");
/*     */     }
/* 198 */     if (Main.getPlugin().getConfig().get("Mensagens.MaquinaNaoEncontrada") == null) {
/* 199 */       Main.getPlugin().getConfig().set("Mensagens.MaquinaNaoEncontrada", String.valueOf("Máquina nao encontrada!"));
/* 200 */       Main.getPlugin().saveConfig();
/* 201 */       MaquinaNaoEncontrada = Tag + Main.getPlugin().getConfig().getString("Mensagens.MaquinaNaoEncontrada").replace("&", "§");
/*     */     } else {
/* 203 */       MaquinaNaoEncontrada = Tag + Main.getPlugin().getConfig().getString("Mensagens.MaquinaNaoEncontrada").replace("&", "§");
/*     */     }
/* 205 */     if (Main.getPlugin().getConfig().get("Mensagens.CombustivelNaoEncontrado") == null) {
/* 206 */       Main.getPlugin().getConfig().set("Mensagens.CombustivelNaoEncontrado", String.valueOf("Combustivel nao encontrado!"));
/* 207 */       Main.getPlugin().saveConfig();
/* 208 */       CombustivelNaoEncontrado = Tag + Main.getPlugin().getConfig().getString("Mensagens.CombustivelNaoEncontrado").replace("&", "§");
/*     */     } else {
/* 210 */       CombustivelNaoEncontrado = Tag + Main.getPlugin().getConfig().getString("Mensagens.CombustivelNaoEncontrado").replace("&", "§");
/*     */     }
/* 212 */     if (Main.getPlugin().getConfig().get("Mensagens.MaquinaGivada") == null) {
/* 213 */       Main.getPlugin().getConfig().set("Mensagens.MaquinaGivada", String.valueOf("Máquina Recebida!"));
/* 214 */       Main.getPlugin().saveConfig();
/* 215 */       MaquinaGivada = Tag + Main.getPlugin().getConfig().getString("Mensagens.MaquinaGivada").replace("&", "§");
/*     */     } else {
/* 217 */       MaquinaGivada = Tag + Main.getPlugin().getConfig().getString("Mensagens.MaquinaGivada").replace("&", "§");
/*     */     }
/* 219 */     if (Main.getPlugin().getConfig().get("Mensagens.CombustivelGivado") == null) {
/* 220 */       Main.getPlugin().getConfig().set("Mensagens.CombustivelGivado", String.valueOf("Combustivel Recebido!"));
/* 221 */       Main.getPlugin().saveConfig();
/* 222 */       CombustivelGivado = Tag + Main.getPlugin().getConfig().getString("Mensagens.CombustivelGivado").replace("&", "§");
/*     */     } else {
/* 224 */       CombustivelGivado = Tag + Main.getPlugin().getConfig().getString("Mensagens.CombustivelGivado").replace("&", "§");
/*     */     }
/* 226 */     if (Main.getPlugin().getConfig().get("Mensagens.NaoPodeQuebrarMaquinaLigada") == null)
/*     */     {
/* 227 */       Main.getPlugin().getConfig().set("Mensagens.NaoPodeQuebrarMaquinaLigada", String.valueOf("Você nao pode quebrar maquinas ligadas!"));
/* 228 */       Main.getPlugin().saveConfig();
/* 229 */       semquebrar = Tag + Main.getPlugin().getConfig().getString("Mensagens.NaoPodeQuebrarMaquinaLigada").replace("&", "§");
/*     */     }
/*     */     else
/*     */     {
/* 231 */       semquebrar = Tag + Main.getPlugin().getConfig().getString("Mensagens.NaoPodeQuebrarMaquinaLigada").replace("&", "§");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void Permissoes()
/*     */   {
/* 236 */     if (Main.getPlugin().getConfig().get("Permissoes.Permissao Give Maquina/Combustivel") == null) {
/* 237 */       Main.getPlugin().getConfig().set("Permissoes.Permissao Give Maquina/Combustivel", String.valueOf("Kibe.Give"));
/* 238 */       Main.getPlugin().saveConfig();
/* 239 */       perm = Tag + Main.getPlugin().getConfig().getString("Permissoes.Permissao Give Maquina/Combustivel");
/*     */     } else {
/* 241 */       perm = Tag + Main.getPlugin().getConfig().getString("Permissoes.Permissao Give Maquina/Combustivel");
/*     */     }
/* 243 */     if (Main.getPlugin().getConfig().get("Permissoes.Permissao Para Ter limite de maquinas VIP") == null)
/*     */     {
/* 244 */       Main.getPlugin().getConfig().set("Permissoes.Permissao Para Ter limite de maquinas VIP", String.valueOf("Kibe.VIP"));
/* 245 */       Main.getPlugin().saveConfig();
/* 246 */       PermLimite = Tag + Main.getPlugin().getConfig().getString("Permissoes.Permissao Para Ter limite de maquinas VIP");
/*     */     }
/*     */     else
/*     */     {
/* 248 */       PermLimite = Tag + Main.getPlugin().getConfig().getString("Permissoes.Permissao Para Ter limite de maquinas VIP");
/*     */     }
/*     */   }
/*     */   
/*     */   public static String Maquina5ID;
/*     */   public static String Maquina5Tipo;
/*     */   public static int Maquina5Preco;
/*     */   public static int Maquina5Coldown;
/*     */   public static int Maquina5Quantia;
/*     */   public static int Maquina5Bloco;
/*     */   public static boolean Maquina5Vender;
/*     */   public static String Maquina6Nome;
/*     */   public static String Maquina6ID;
/*     */   public static String Maquina6Tipo;
/*     */   
/*     */   public static void Etanol()
/*     */   {
/* 257 */     if (Main.getPlugin().getConfig().get("Etanol.Chance de vir minerando") == null)
/*     */     {
/* 258 */       Main.getPlugin().getConfig().set("Etanol.Chance de vir minerando", Boolean.valueOf(false));
/* 259 */       Main.getPlugin().saveConfig();
/* 260 */       GanharEta = Main.getPlugin().getConfig().getBoolean("Etanol.Chance de vir minerando");
/*     */     }
/*     */     else
/*     */     {
/* 262 */       GanharEta = Main.getPlugin().getConfig().getBoolean("Etanol.Chance de vir minerando");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void Gasolina()
/*     */   {
/* 267 */     if (Main.getPlugin().getConfig().get("Gasolina.Chance de vir minerando") == null)
/*     */     {
/* 268 */       Main.getPlugin().getConfig().set("Gasolina.Chance de vir minerando", Boolean.valueOf(false));
/* 269 */       Main.getPlugin().saveConfig();
/* 270 */       GanharGas = Main.getPlugin().getConfig().getBoolean("Gasolina.Chance de vir minerando");
/*     */     }
/*     */     else
/*     */     {
/* 272 */       GanharGas = Main.getPlugin().getConfig().getBoolean("Gasolina.Chance de vir minerando");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void Diesel()
/*     */   {
/* 277 */     if (Main.getPlugin().getConfig().get("Diesel.Chance de vir minerando") == null)
/*     */     {
/* 278 */       Main.getPlugin().getConfig().set("Diesel.Chance de vir minerando", Boolean.valueOf(false));
/* 279 */       Main.getPlugin().saveConfig();
/* 280 */       GanharDie = Main.getPlugin().getConfig().getBoolean("Diesel.Chance de vir minerando");
/*     */     }
/*     */     else
/*     */     {
/* 282 */       GanharDie = Main.getPlugin().getConfig().getBoolean("Diesel.Chance de vir minerando");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void Maquina1Config()
/*     */   {
/* 287 */     if (Main.getPlugin().getConfig().get("Maquina 1.Nome") == null) {
/* 288 */       Main.getPlugin().getConfig().set("Maquina 1.Nome", String.valueOf("&4Maquina de Estrela do Nether"));
/* 289 */       Main.getPlugin().saveConfig();
/* 290 */       Maquina1Nome = Main.getPlugin().getConfig().getString("Maquina 1.Nome").replace("&", "§");
/*     */     } else {
/* 292 */       Maquina1Nome = Main.getPlugin().getConfig().getString("Maquina 1.Nome").replace("&", "§");
/*     */     }
/* 294 */     if (Main.getPlugin().getConfig().get("Maquina 1.Preco") == null) {
/* 295 */       Main.getPlugin().getConfig().set("Maquina 1.Preco", Integer.valueOf(10000000));
/* 296 */       Main.getPlugin().saveConfig();
/* 297 */       Maquina1Preco = Main.getPlugin().getConfig().getInt("Maquina 1.Preco");
/*     */     } else {
/* 299 */       Maquina1Preco = Main.getPlugin().getConfig().getInt("Maquina 1.Preco");
/*     */     }
/* 301 */     if (Main.getPlugin().getConfig().get("Maquina 1.Vender") == null) {
/* 302 */       Main.getPlugin().getConfig().set("Maquina 1.Vender", Boolean.valueOf(false));
/* 303 */       Main.getPlugin().saveConfig();
/* 304 */       Maquina1Vender = Main.getPlugin().getConfig().getBoolean("Maquina 1.Vender");
/*     */     } else {
/* 306 */       Maquina1Vender = Main.getPlugin().getConfig().getBoolean("Maquina 1.Vender");
/*     */     }
/* 308 */     if (Main.getPlugin().getConfig().get("Maquina 1.Quantidade Itens Dropados") == null) {
/* 309 */       Main.getPlugin().getConfig().set("Maquina 1.Quantidade Itens Dropados", Integer.valueOf(8));
/* 310 */       Main.getPlugin().saveConfig();
/* 311 */       Maquina1Quantia = Main.getPlugin().getConfig().getInt("Maquina 1.Quantidade Itens Dropados");
/*     */     } else {
/* 313 */       Maquina1Quantia = Main.getPlugin().getConfig().getInt("Maquina 1.Quantidade Itens Dropados");
/*     */     }
/* 315 */     if (Main.getPlugin().getConfig().get("Maquina 1.Coldown Drop (Segundos)") == null) {
/* 316 */       Main.getPlugin().getConfig().set("Maquina 1.Coldown Drop (Segundos)", Integer.valueOf(5));
/* 317 */       Main.getPlugin().saveConfig();
/* 318 */       Maquina1Coldown = Main.getPlugin().getConfig().getInt("Maquina 1.Coldown Drop (Segundos)");
/*     */     } else {
/* 320 */       Maquina1Coldown = Main.getPlugin().getConfig().getInt("Maquina 1.Coldown Drop (Segundos)");
/*     */     }
/* 322 */     if (Main.getPlugin().getConfig().get("Maquina 1.ID") == null) {
/* 323 */       Main.getPlugin().getConfig().set("Maquina 1.ID", String.valueOf("399"));
/* 324 */       Main.getPlugin().saveConfig();
/* 325 */       Maquina1ID = Main.getPlugin().getConfig().getString("Maquina 1.ID");
/*     */     } else {
/* 327 */       Maquina1ID = Main.getPlugin().getConfig().getString("Maquina 1.ID");
/*     */     }
/* 329 */     if (Main.getPlugin().getConfig().get("Maquina 1.Tipo") == null) {
/* 330 */       Main.getPlugin().getConfig().set("Maquina 1.Tipo", String.valueOf("&7RARA"));
/* 331 */       Main.getPlugin().saveConfig();
/* 332 */       Maquina1Tipo = Main.getPlugin().getConfig().getString("Maquina 1.Tipo").replace("&", "§");
/*     */     } else {
/* 334 */       Maquina1Tipo = Main.getPlugin().getConfig().getString("Maquina 1.Tipo").replace("&", "§");
/*     */     }
/* 336 */     if (Main.getPlugin().getConfig().get("Maquina 1.Bloco") == null)
/*     */     {
/* 337 */       Main.getPlugin().getConfig().set("Maquina 1.Bloco", Integer.valueOf(133));
/* 338 */       Main.getPlugin().saveConfig();
/* 339 */       Maquina1Bloco = Main.getPlugin().getConfig().getInt("Maquina 1.Bloco");
/*     */     }
/*     */     else
/*     */     {
/* 341 */       Maquina1Bloco = Main.getPlugin().getConfig().getInt("Maquina 1.Bloco");
/*     */     }
/*     */   }
/*     */   
/*     */   public static int Maquina6Preco;
/*     */   public static int Maquina6Coldown;
/*     */   public static int Maquina6Quantia;
/*     */   public static int Maquina6Bloco;
/*     */   public static boolean Maquina6Vender;
/*     */   public static String RefinariaNome;
/*     */   public static String RefinariaTipo;
/*     */   public static int RefinariaPreco;
/*     */   public static int RefinariaColdown;
/*     */   public static int RefinariaBloco;
/*     */   public static boolean RefinariaVender;
/*     */   public static void Maquina2Config()
/*     */   {
/* 350 */     if (Main.getPlugin().getConfig().get("Maquina 2.Nome") == null) {
/* 351 */       Main.getPlugin().getConfig().set("Maquina 2.Nome", String.valueOf("&4Maquina de Slime"));
/* 352 */       Main.getPlugin().saveConfig();
/* 353 */       Maquina2Nome = Main.getPlugin().getConfig().getString("Maquina 2.Nome").replace("&", "§");
/*     */     } else {
/* 355 */       Maquina2Nome = Main.getPlugin().getConfig().getString("Maquina 2.Nome").replace("&", "§");
/*     */     }
/* 357 */     if (Main.getPlugin().getConfig().get("Maquina 2.Preco") == null) {
/* 358 */       Main.getPlugin().getConfig().set("Maquina 2.Preco", Integer.valueOf(1000000));
/* 359 */       Main.getPlugin().saveConfig();
/* 360 */       Maquina2Preco = Main.getPlugin().getConfig().getInt("Maquina 2.Preco");
/*     */     } else {
/* 362 */       Maquina2Preco = Main.getPlugin().getConfig().getInt("Maquina 2.Preco");
/*     */     }
/* 364 */     if (Main.getPlugin().getConfig().get("Maquina 2.Vender") == null) {
/* 365 */       Main.getPlugin().getConfig().set("Maquina 2.Vender", Boolean.valueOf(false));
/* 366 */       Main.getPlugin().saveConfig();
/* 367 */       Maquina2Vender = Main.getPlugin().getConfig().getBoolean("Maquina 2.Vender");
/*     */     } else {
/* 369 */       Maquina2Vender = Main.getPlugin().getConfig().getBoolean("Maquina 2.Vender");
/*     */     }
/* 371 */     if (Main.getPlugin().getConfig().get("Maquina 2.Quantidade Itens Dropados") == null) {
/* 372 */       Main.getPlugin().getConfig().set("Maquina 2.Quantidade Itens Dropados", Integer.valueOf(1304));
/* 373 */       Main.getPlugin().saveConfig();
/* 374 */       Maquina2Quantia = Main.getPlugin().getConfig().getInt("Maquina 2.Quantidade Itens Dropados");
/*     */     } else {
/* 376 */       Maquina2Quantia = Main.getPlugin().getConfig().getInt("Maquina 2.Quantidade Itens Dropados");
/*     */     }
/* 378 */     if (Main.getPlugin().getConfig().get("Maquina 2.Coldown Drop (Segundos)") == null) {
/* 379 */       Main.getPlugin().getConfig().set("Maquina 2.Coldown Drop (Segundos)", Integer.valueOf(5));
/* 380 */       Main.getPlugin().saveConfig();
/* 381 */       Maquina2Coldown = Main.getPlugin().getConfig().getInt("Maquina 2.Coldown Drop (Segundos)");
/*     */     } else {
/* 383 */       Maquina2Coldown = Main.getPlugin().getConfig().getInt("Maquina 2.Coldown Drop (Segundos)");
/*     */     }
/* 385 */     if (Main.getPlugin().getConfig().get("Maquina 2.ID") == null) {
/* 386 */       Main.getPlugin().getConfig().set("Maquina 2.ID", String.valueOf("165"));
/* 387 */       Main.getPlugin().saveConfig();
/* 388 */       Maquina2ID = Main.getPlugin().getConfig().getString("Maquina 2.ID");
/*     */     } else {
/* 390 */       Maquina2ID = Main.getPlugin().getConfig().getString("Maquina 2.ID");
/*     */     }
/* 392 */     if (Main.getPlugin().getConfig().get("Maquina 2.Tipo") == null) {
/* 393 */       Main.getPlugin().getConfig().set("Maquina 2.Tipo", String.valueOf("&7COMUM"));
/* 394 */       Main.getPlugin().saveConfig();
/* 395 */       Maquina2Tipo = Main.getPlugin().getConfig().getString("Maquina 2.Tipo").replace("&", "§");
/*     */     } else {
/* 397 */       Maquina2Tipo = Main.getPlugin().getConfig().getString("Maquina 2.Tipo").replace("&", "§");
/*     */     }
/* 399 */     if (Main.getPlugin().getConfig().get("Maquina 2.Bloco") == null)
/*     */     {
/* 400 */       Main.getPlugin().getConfig().set("Maquina 2.Bloco", Integer.valueOf(1));
/* 401 */       Main.getPlugin().saveConfig();
/* 402 */       Maquina2Bloco = Main.getPlugin().getConfig().getInt("Maquina 2.Bloco");
/*     */     }
/*     */     else
/*     */     {
/* 404 */       Maquina2Bloco = Main.getPlugin().getConfig().getInt("Maquina 2.Bloco");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void Maquina3Config()
/*     */   {
/* 413 */     if (Main.getPlugin().getConfig().get("Maquina 3.Nome") == null) {
/* 414 */       Main.getPlugin().getConfig().set("Maquina 3.Nome", String.valueOf("&4Maquina do Capiroto"));
/* 415 */       Main.getPlugin().saveConfig();
/* 416 */       Maquina3Nome = Main.getPlugin().getConfig().getString("Maquina 3.Nome").replace("&", "§");
/*     */     } else {
/* 418 */       Maquina3Nome = Main.getPlugin().getConfig().getString("Maquina 3.Nome").replace("&", "§");
/*     */     }
/* 420 */     if (Main.getPlugin().getConfig().get("Maquina 3.Preco") == null) {
/* 421 */       Main.getPlugin().getConfig().set("Maquina 3.Preco", Integer.valueOf(50000000));
/* 422 */       Main.getPlugin().saveConfig();
/* 423 */       Maquina3Preco = Main.getPlugin().getConfig().getInt("Maquina 3.Preco");
/*     */     } else {
/* 425 */       Maquina3Preco = Main.getPlugin().getConfig().getInt("Maquina 3.Preco");
/*     */     }
/* 427 */     if (Main.getPlugin().getConfig().get("Maquina 3.Vender") == null) {
/* 428 */       Main.getPlugin().getConfig().set("Maquina 3.Vender", Boolean.valueOf(false));
/* 429 */       Main.getPlugin().saveConfig();
/* 430 */       Maquina3Vender = Main.getPlugin().getConfig().getBoolean("Maquina 3.Vender");
/*     */     } else {
/* 432 */       Maquina3Vender = Main.getPlugin().getConfig().getBoolean("Maquina 3.Vender");
/*     */     }
/* 434 */     if (Main.getPlugin().getConfig().get("Maquina 3.Quantidade Itens Dropados") == null) {
/* 435 */       Main.getPlugin().getConfig().set("Maquina 3.Quantidade Itens Dropados", Integer.valueOf(1));
/* 436 */       Main.getPlugin().saveConfig();
/* 437 */       Maquina3Quantia = Main.getPlugin().getConfig().getInt("Maquina 3.Quantidade Itens Dropados");
/*     */     } else {
/* 439 */       Maquina3Quantia = Main.getPlugin().getConfig().getInt("Maquina 3.Quantidade Itens Dropados");
/*     */     }
/* 441 */     if (Main.getPlugin().getConfig().get("Maquina 3.Coldown Drop (Segundos)") == null) {
/* 442 */       Main.getPlugin().getConfig().set("Maquina 3.Coldown Drop (Segundos)", Integer.valueOf(5));
/* 443 */       Main.getPlugin().saveConfig();
/* 444 */       Maquina3Coldown = Main.getPlugin().getConfig().getInt("Maquina 3.Coldown Drop (Segundos)");
/*     */     } else {
/* 446 */       Maquina3Coldown = Main.getPlugin().getConfig().getInt("Maquina 3.Coldown Drop (Segundos)");
/*     */     }
/* 448 */     if (Main.getPlugin().getConfig().get("Maquina 3.ID") == null) {
/* 449 */       Main.getPlugin().getConfig().set("Maquina 3.ID", String.valueOf("322:1"));
/* 450 */       Main.getPlugin().saveConfig();
/* 451 */       Maquina3ID = Main.getPlugin().getConfig().getString("Maquina 3.ID");
/*     */     } else {
/* 453 */       Maquina3ID = Main.getPlugin().getConfig().getString("Maquina 3.ID");
/*     */     }
/* 455 */     if (Main.getPlugin().getConfig().get("Maquina 3.Tipo") == null) {
/* 456 */       Main.getPlugin().getConfig().set("Maquina 3.Tipo", String.valueOf("&7ULTRA RARA"));
/* 457 */       Main.getPlugin().saveConfig();
/* 458 */       Maquina3Tipo = Main.getPlugin().getConfig().getString("Maquina 3.Tipo").replace("&", "§");
/*     */     } else {
/* 460 */       Maquina3Tipo = Main.getPlugin().getConfig().getString("Maquina 3.Tipo").replace("&", "§");
/*     */     }
/* 462 */     if (Main.getPlugin().getConfig().get("Maquina 3.Bloco") == null)
/*     */     {
/* 463 */       Main.getPlugin().getConfig().set("Maquina 3.Bloco", Integer.valueOf(41));
/* 464 */       Main.getPlugin().saveConfig();
/* 465 */       Maquina3Bloco = Main.getPlugin().getConfig().getInt("Maquina 3.Bloco");
/*     */     }
/*     */     else
/*     */     {
/* 467 */       Maquina3Bloco = Main.getPlugin().getConfig().getInt("Maquina 3.Bloco");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void Maquina4Config()
/*     */   {
/* 476 */     if (Main.getPlugin().getConfig().get("Maquina 4.Nome") == null) {
/* 477 */       Main.getPlugin().getConfig().set("Maquina 4.Nome", String.valueOf("&4Maquina do Couro"));
/* 478 */       Main.getPlugin().saveConfig();
/* 479 */       Maquina4Nome = Main.getPlugin().getConfig().getString("Maquina 4.Nome").replace("&", "§");
/*     */     } else {
/* 481 */       Maquina4Nome = Main.getPlugin().getConfig().getString("Maquina 4.Nome").replace("&", "§");
/*     */     }
/* 483 */     if (Main.getPlugin().getConfig().get("Maquina 4.Preco") == null) {
/* 484 */       Main.getPlugin().getConfig().set("Maquina 4.Preco", Integer.valueOf(5000000));
/* 485 */       Main.getPlugin().saveConfig();
/* 486 */       Maquina4Preco = Main.getPlugin().getConfig().getInt("Maquina 4.Preco");
/*     */     } else {
/* 488 */       Maquina4Preco = Main.getPlugin().getConfig().getInt("Maquina 4.Preco");
/*     */     }
/* 490 */     if (Main.getPlugin().getConfig().get("Maquina 4.Vender") == null) {
/* 491 */       Main.getPlugin().getConfig().set("Maquina 4.Vender", Boolean.valueOf(false));
/* 492 */       Main.getPlugin().saveConfig();
/* 493 */       Maquina4Vender = Main.getPlugin().getConfig().getBoolean("Maquina 4.Vender");
/*     */     } else {
/* 495 */       Maquina4Vender = Main.getPlugin().getConfig().getBoolean("Maquina 4.Vender");
/*     */     }
/* 497 */     if (Main.getPlugin().getConfig().get("Maquina 4.Quantidade Itens Dropados") == null) {
/* 498 */       Main.getPlugin().getConfig().set("Maquina 4.Quantidade Itens Dropados", Integer.valueOf(8));
/* 499 */       Main.getPlugin().saveConfig();
/* 500 */       Maquina4Quantia = Main.getPlugin().getConfig().getInt("Maquina 4.Quantidade Itens Dropados");
/*     */     } else {
/* 502 */       Maquina4Quantia = Main.getPlugin().getConfig().getInt("Maquina 4.Quantidade Itens Dropados");
/*     */     }
/* 504 */     if (Main.getPlugin().getConfig().get("Maquina 4.Coldown Drop (Segundos)") == null) {
/* 505 */       Main.getPlugin().getConfig().set("Maquina 4.Coldown Drop (Segundos)", Integer.valueOf(5));
/* 506 */       Main.getPlugin().saveConfig();
/* 507 */       Maquina4Coldown = Main.getPlugin().getConfig().getInt("Maquina 4.Coldown Drop (Segundos)");
/*     */     } else {
/* 509 */       Maquina4Coldown = Main.getPlugin().getConfig().getInt("Maquina 4.Coldown Drop (Segundos)");
/*     */     }
/* 511 */     if (Main.getPlugin().getConfig().get("Maquina 4.ID") == null) {
/* 512 */       Main.getPlugin().getConfig().set("Maquina 4.ID", String.valueOf("334"));
/* 513 */       Main.getPlugin().saveConfig();
/* 514 */       Maquina4ID = Main.getPlugin().getConfig().getString("Maquina 4.ID");
/*     */     } else {
/* 516 */       Maquina4ID = Main.getPlugin().getConfig().getString("Maquina 4.ID");
/*     */     }
/* 518 */     if (Main.getPlugin().getConfig().get("Maquina 4.Tipo") == null) {
/* 519 */       Main.getPlugin().getConfig().set("Maquina 4.Tipo", String.valueOf("&7COMUM"));
/* 520 */       Main.getPlugin().saveConfig();
/* 521 */       Maquina4Tipo = Main.getPlugin().getConfig().getString("Maquina 4.Tipo").replace("&", "§");
/*     */     } else {
/* 523 */       Maquina4Tipo = Main.getPlugin().getConfig().getString("Maquina 4.Tipo").replace("&", "§");
/*     */     }
/* 525 */     if (Main.getPlugin().getConfig().get("Maquina 4.Bloco") == null)
/*     */     {
/* 526 */       Main.getPlugin().getConfig().set("Maquina 4.Bloco", Integer.valueOf(45));
/* 527 */       Main.getPlugin().saveConfig();
/* 528 */       Maquina4Bloco = Main.getPlugin().getConfig().getInt("Maquina 4.Bloco");
/*     */     }
/*     */     else
/*     */     {
/* 530 */       Maquina4Bloco = Main.getPlugin().getConfig().getInt("Maquina 4.Bloco");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void Maquina5Config()
/*     */   {
/* 539 */     if (Main.getPlugin().getConfig().get("Maquina 5.Nome") == null) {
/* 540 */       Main.getPlugin().getConfig().set("Maquina 5.Nome", String.valueOf("&4Maquina de Ferro"));
/* 541 */       Main.getPlugin().saveConfig();
/* 542 */       Maquina5Nome = Main.getPlugin().getConfig().getString("Maquina 5.Nome").replace("&", "§");
/*     */     } else {
/* 544 */       Maquina5Nome = Main.getPlugin().getConfig().getString("Maquina 5.Nome").replace("&", "§");
/*     */     }
/* 546 */     if (Main.getPlugin().getConfig().get("Maquina 5.Preco") == null) {
/* 547 */       Main.getPlugin().getConfig().set("Maquina 5.Preco", Integer.valueOf(3000000));
/* 548 */       Main.getPlugin().saveConfig();
/* 549 */       Maquina5Preco = Main.getPlugin().getConfig().getInt("Maquina 5.Preco");
/*     */     } else {
/* 551 */       Maquina5Preco = Main.getPlugin().getConfig().getInt("Maquina 5.Preco");
/*     */     }
/* 553 */     if (Main.getPlugin().getConfig().get("Maquina 5.Vender") == null) {
/* 554 */       Main.getPlugin().getConfig().set("Maquina 5.Vender", Boolean.valueOf(false));
/* 555 */       Main.getPlugin().saveConfig();
/* 556 */       Maquina5Vender = Main.getPlugin().getConfig().getBoolean("Maquina 5.Vender");
/*     */     } else {
/* 558 */       Maquina5Vender = Main.getPlugin().getConfig().getBoolean("Maquina 5.Vender");
/*     */     }
/* 560 */     if (Main.getPlugin().getConfig().get("Maquina 5.Quantidade Itens Dropados") == null) {
/* 561 */       Main.getPlugin().getConfig().set("Maquina 5.Quantidade Itens Dropados", Integer.valueOf(16));
/* 562 */       Main.getPlugin().saveConfig();
/* 563 */       Maquina5Quantia = Main.getPlugin().getConfig().getInt("Maquina 5.Quantidade Itens Dropados");
/*     */     } else {
/* 565 */       Maquina5Quantia = Main.getPlugin().getConfig().getInt("Maquina 5.Quantidade Itens Dropados");
/*     */     }
/* 567 */     if (Main.getPlugin().getConfig().get("Maquina 5.Coldown Drop (Segundos)") == null) {
/* 568 */       Main.getPlugin().getConfig().set("Maquina 5.Coldown Drop (Segundos)", Integer.valueOf(5));
/* 569 */       Main.getPlugin().saveConfig();
/* 570 */       Maquina5Coldown = Main.getPlugin().getConfig().getInt("Maquina 5.Coldown Drop (Segundos)");
/*     */     } else {
/* 572 */       Maquina5Coldown = Main.getPlugin().getConfig().getInt("Maquina 5.Coldown Drop (Segundos)");
/*     */     }
/* 574 */     if (Main.getPlugin().getConfig().get("Maquina 5.ID") == null) {
/* 575 */       Main.getPlugin().getConfig().set("Maquina 5.ID", String.valueOf("265"));
/* 576 */       Main.getPlugin().saveConfig();
/* 577 */       Maquina5ID = Main.getPlugin().getConfig().getString("Maquina 5.ID");
/*     */     } else {
/* 579 */       Maquina5ID = Main.getPlugin().getConfig().getString("Maquina 5.ID");
/*     */     }
/* 581 */     if (Main.getPlugin().getConfig().get("Maquina 5.Tipo") == null) {
/* 582 */       Main.getPlugin().getConfig().set("Maquina 5.Tipo", String.valueOf("&7RARA"));
/* 583 */       Main.getPlugin().saveConfig();
/* 584 */       Maquina5Tipo = Main.getPlugin().getConfig().getString("Maquina 5.Tipo").replace("&", "§");
/*     */     } else {
/* 586 */       Maquina5Tipo = Main.getPlugin().getConfig().getString("Maquina 5.Tipo").replace("&", "§");
/*     */     }
/* 588 */     if (Main.getPlugin().getConfig().get("Maquina 5.Bloco") == null)
/*     */     {
/* 589 */       Main.getPlugin().getConfig().set("Maquina 5.Bloco", Integer.valueOf(42));
/* 590 */       Main.getPlugin().saveConfig();
/* 591 */       Maquina5Bloco = Main.getPlugin().getConfig().getInt("Maquina 5.Bloco");
/*     */     }
/*     */     else
/*     */     {
/* 593 */       Maquina5Bloco = Main.getPlugin().getConfig().getInt("Maquina 5.Bloco");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void Maquina6Config()
/*     */   {
/* 602 */     if (Main.getPlugin().getConfig().get("Maquina 6.Nome") == null) {
/* 603 */       Main.getPlugin().getConfig().set("Maquina 6.Nome", String.valueOf("&4Maquina de XP"));
/* 604 */       Main.getPlugin().saveConfig();
/* 605 */       Maquina6Nome = Main.getPlugin().getConfig().getString("Maquina 6.Nome").replace("&", "§");
/*     */     } else {
/* 607 */       Maquina6Nome = Main.getPlugin().getConfig().getString("Maquina 6.Nome").replace("&", "§");
/*     */     }
/* 609 */     if (Main.getPlugin().getConfig().get("Maquina 6.Preco") == null) {
/* 610 */       Main.getPlugin().getConfig().set("Maquina 6.Preco", Integer.valueOf(5000000));
/* 611 */       Main.getPlugin().saveConfig();
/* 612 */       Maquina6Preco = Main.getPlugin().getConfig().getInt("Maquina 6.Preco");
/*     */     } else {
/* 614 */       Maquina6Preco = Main.getPlugin().getConfig().getInt("Maquina 6.Preco");
/*     */     }
/* 616 */     if (Main.getPlugin().getConfig().get("Maquina 6.Vender") == null) {
/* 617 */       Main.getPlugin().getConfig().set("Maquina 6.Vender", Boolean.valueOf(false));
/* 618 */       Main.getPlugin().saveConfig();
/* 619 */       Maquina6Vender = Main.getPlugin().getConfig().getBoolean("Maquina 6.Vender");
/*     */     } else {
/* 621 */       Maquina6Vender = Main.getPlugin().getConfig().getBoolean("Maquina 6.Vender");
/*     */     }
/* 623 */     if (Main.getPlugin().getConfig().get("Maquina 6.Quantidade Itens Dropados") == null) {
/* 624 */       Main.getPlugin().getConfig().set("Maquina 6.Quantidade Itens Dropados", Integer.valueOf(8));
/* 625 */       Main.getPlugin().saveConfig();
/* 626 */       Maquina6Quantia = Main.getPlugin().getConfig().getInt("Maquina 6.Quantidade Itens Dropados");
/*     */     } else {
/* 628 */       Maquina6Quantia = Main.getPlugin().getConfig().getInt("Maquina 6.Quantidade Itens Dropados");
/*     */     }
/* 630 */     if (Main.getPlugin().getConfig().get("Maquina 6.Coldown Drop (Segundos)") == null) {
/* 631 */       Main.getPlugin().getConfig().set("Maquina 6.Coldown Drop (Segundos)", Integer.valueOf(5));
/* 632 */       Main.getPlugin().saveConfig();
/* 633 */       Maquina6Coldown = Main.getPlugin().getConfig().getInt("Maquina 6.Coldown Drop (Segundos)");
/*     */     } else {
/* 635 */       Maquina6Coldown = Main.getPlugin().getConfig().getInt("Maquina 6.Coldown Drop (Segundos)");
/*     */     }
/* 637 */     if (Main.getPlugin().getConfig().get("Maquina 6.ID") == null) {
/* 638 */       Main.getPlugin().getConfig().set("Maquina 6.ID", String.valueOf("384"));
/* 639 */       Main.getPlugin().saveConfig();
/* 640 */       Maquina6ID = Main.getPlugin().getConfig().getString("Maquina 6.ID");
/*     */     } else {
/* 642 */       Maquina6ID = Main.getPlugin().getConfig().getString("Maquina 6.ID");
/*     */     }
/* 644 */     if (Main.getPlugin().getConfig().get("Maquina 6.Tipo") == null) {
/* 645 */       Main.getPlugin().getConfig().set("Maquina 6.Tipo", String.valueOf("&7ULTRA RARA"));
/* 646 */       Main.getPlugin().saveConfig();
/* 647 */       Maquina6Tipo = Main.getPlugin().getConfig().getString("Maquina 6.Tipo").replace("&", "§");
/*     */     } else {
/* 649 */       Maquina6Tipo = Main.getPlugin().getConfig().getString("Maquina 6.Tipo").replace("&", "§");
/*     */     }
/* 651 */     if (Main.getPlugin().getConfig().get("Maquina 6.Bloco") == null)
/*     */     {
/* 652 */       Main.getPlugin().getConfig().set("Maquina 6.Bloco", Integer.valueOf(152));
/* 653 */       Main.getPlugin().saveConfig();
/* 654 */       Maquina6Bloco = Main.getPlugin().getConfig().getInt("Maquina 6.Bloco");
/*     */     }
/*     */     else
/*     */     {
/* 656 */       Maquina6Bloco = Main.getPlugin().getConfig().getInt("Maquina 6.Bloco");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void RefinariaConfig()
/*     */   {
/* 665 */     if (Main.getPlugin().getConfig().get("Refinaria.Nome") == null) {
/* 666 */       Main.getPlugin().getConfig().set("Refinaria.Nome", "&0Refinaria de Petroleo");
/* 667 */       Main.getPlugin().saveConfig();
/* 668 */       RefinariaNome = Main.getPlugin().getConfig().getString("Refinaria.Nome").replace("&", "§");
/*     */     } else {
/* 670 */       RefinariaNome = Main.getPlugin().getConfig().getString("Refinaria.Nome").replace("&", "§");
/*     */     }
/* 672 */     if (Main.getPlugin().getConfig().get("Refinaria.Preco") == null) {
/* 673 */       Main.getPlugin().getConfig().set("Refinaria.Preco", Integer.valueOf(100000000));
/* 674 */       Main.getPlugin().saveConfig();
/* 675 */       RefinariaPreco = Main.getPlugin().getConfig().getInt("Refinaria.Preco");
/*     */     } else {
/* 677 */       RefinariaPreco = Main.getPlugin().getConfig().getInt("Refinaria.Preco");
/*     */     }
/* 679 */     if (Main.getPlugin().getConfig().get("Refinaria.Vender") == null) {
/* 680 */       Main.getPlugin().getConfig().set("Refinaria.Vender", Boolean.valueOf(false));
/* 681 */       Main.getPlugin().saveConfig();
/* 682 */       RefinariaVender = Main.getPlugin().getConfig().getBoolean("Refinaria.Vender");
/*     */     } else {
/* 684 */       RefinariaVender = Main.getPlugin().getConfig().getBoolean("Refinaria.Vender");
/*     */     }
/* 686 */     if (Main.getPlugin().getConfig().get("Refinaria.Coldown Drop (Segundos)") == null) {
/* 687 */       Main.getPlugin().getConfig().set("Refinaria.Coldown Drop (Segundos)", Integer.valueOf(5));
/* 688 */       Main.getPlugin().saveConfig();
/* 689 */       RefinariaColdown = Main.getPlugin().getConfig().getInt("Refinaria.Coldown Drop (Segundos)");
/*     */     } else {
/* 691 */       RefinariaColdown = Main.getPlugin().getConfig().getInt("Refinaria.Coldown Drop (Segundos)");
/*     */     }
/* 693 */     if (Main.getPlugin().getConfig().get("Refinaria.Tipo") == null) {
/* 694 */       Main.getPlugin().getConfig().set("Refinaria.Tipo", String.valueOf("&0Desconhecido"));
/* 695 */       Main.getPlugin().saveConfig();
/* 696 */       RefinariaTipo = Main.getPlugin().getConfig().getString("Refinaria.Tipo").replace("&", "§");
/*     */     } else {
/* 698 */       RefinariaTipo = Main.getPlugin().getConfig().getString("Refinaria.Tipo").replace("&", "§");
/*     */     }
/* 700 */     if (Main.getPlugin().getConfig().get("Refinaria.Bloco") == null)
/*     */     {
/* 701 */       Main.getPlugin().getConfig().set("Refinaria.Bloco", Integer.valueOf(173));
/* 702 */       Main.getPlugin().saveConfig();
/* 703 */       RefinariaBloco = Main.getPlugin().getConfig().getInt("Refinaria.Bloco");
/*     */     }
/*     */     else
/*     */     {
/* 705 */       RefinariaBloco = Main.getPlugin().getConfig().getInt("Refinaria.Bloco");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Diego\Desktop\MM-Maquinas.jar!\me\MMaquinas\Utils\Strings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */