package by.fxg.diverse.common.item;

import by.fxg.diverse.client.ClientProxy;
import by.fxg.diverse.client.model.item.VModelGelatrium;
import by.fxg.diverse.client.model.item.VModelHusazium;
import by.fxg.diverse.client.model.item.VModelKusistrium;
import by.fxg.diverse.client.model.item.VModelKusistriumPickaxe;
import by.fxg.diverse.client.model.item.VModelVintarium;
import by.fxg.diverse.client.model.item.VModelVintariumGelatriumHusaziumPickaxe;
import by.fxg.diverse.client.model.item.VModelYeselium;
import by.fxg.diverse.client.model.item.VModelYeseliumPickaxe;
import by.fxg.diverse.common.block.BlockRegistry;
import by.fxg.diverse.common.storage.ModelItemCreation;
import by.fxg.diverse.debug.DebugItem;
import by.fxg.diverse.util.Utils;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;

public class ItemRegistry {
	public static VItem itemVintarium;
	public static VItem itemGelatrium;
	public static VItem itemHusazium;
	public static VItem itemKusistrium;
	public static VItem itemYeselium;
	public static VPickaxe pickVintarium;
	public static VPickaxe pickGelatrium;
	public static VPickaxe pickHusazium;
	public static VPickaxe pickKusistrium;
	public static VPickaxe pickYeselium;
	public static VItem itemPressedVintarium;
	public static VItem itemPressedGelatrium;
	public static VItem itemPressedHusazium;
	public static VItem itemPressedKusistrium;
	public static VItem itemPressedYeselium;
	public static VItem itemPlabster;
	public static VItem itempickVintarium;
	public static VItem itempickGelatrium;
	public static VItem itempickHusazium;
	public static VItem itempickKusistrium;
	public static VItem itempickYeselium;
	public static VItem itemswordVintarium;
	public static VItem itemswordGelatrium;
	public static VItem itemswordHusazium;
	public static VItem itemswordKusistrium;
	public static VItem itemswordYeselium;
	public static VItem itemingotVintarium;
	public static VItem itemingotGelatrium;
	public static VItem itemingotHusazium;
	public static VItem itemingotKusistrium;
	public static VItem itemingotYeselium;
	public static VSword swordVintarium;
	public static VSword swordGelatrium;
	public static VSword swordHusazium;
	public static VSword swordKusistrium;
	public static VSword swordYeselium;
	
	public static VMultiItem rpgFood;
	public static VMultiItem rpgItem;
	public static VMultiItem rpgItems;
	
	public static ItemNecklace itemNecklace;
	public static ItemRing itemRing;
	public static ItemMedal itemMedal;
	public static ItemFist itemFist;
	//public static ItemNecklace itemBook;
	
	public static VItemArmor armorVintarium0;
	public static VItemArmor armorVintarium1;
	public static VItemArmor armorVintarium2;
	public static VItemArmor armorVintarium3;
	public static VItemArmor armorGelatrium0;
	public static VItemArmor armorGelatrium1;
	public static VItemArmor armorGelatrium2;
	public static VItemArmor armorGelatrium3;
	public static VItemArmor armorHusazium0;
	public static VItemArmor armorHusazium1;
	public static VItemArmor armorHusazium2;
	public static VItemArmor armorHusazium3;
	public static VItemArmor armorKusistrium0;
	public static VItemArmor armorKusistrium1;
	public static VItemArmor armorKusistrium2;
	public static VItemArmor armorKusistrium3;
	public static VItemArmor armorYeselium0;
	public static VItemArmor armorYeselium1;
	public static VItemArmor armorYeselium2;
	public static VItemArmor armorYeselium3;
	
	public static EnumToolMaterial materialVintarium = EnumHelper.addToolMaterial("materialVintarium", 4, 2500, 16.0F, 6.0F, 0);
	public static EnumToolMaterial materialGelatrium = EnumHelper.addToolMaterial("materialGelatrium", 5, 5000, 32.0F, 6.0F, 0);
	public static EnumToolMaterial materialHusazium = EnumHelper.addToolMaterial("materialHusazium", 6, 7500, 48.0F, 6.0F, 0);
	public static EnumToolMaterial materialKusistrium = EnumHelper.addToolMaterial("materialKusistrium", 7, 10000, 64.0F, 6.0F, 0);
	public static EnumToolMaterial materialYeselium = EnumHelper.addToolMaterial("materialYeselium", 8, 15000, 96.0F, 6.0F, 0);
	public static DebugItem itemDebug = (DebugItem)new DebugItem(9743, 4).setName("Debug[боевой инвентарь]", 0).setName("Debug[поиск руд]", 1).setName("Debug[перс данные ext]", 2).setName("Tool[Портальный настройщик]", 3);
	
	public ItemRegistry init() {
		itemVintarium = new VItem(5500, 64, "itemVintarium").setName("Кристалл винтария");
		registerModel(new VModelVintarium(), "itemvintarium", itemVintarium.itemID);
		itemGelatrium = new VItem(5501, 64, "itemGelatrium").setName("Кристалл гелатрия");
		registerModel(new VModelGelatrium(), "itemgelatrium",  itemGelatrium.itemID);
		itemHusazium = new VItem(5502, 64, "itemHusazium").setName("Кристалл хусазиума");
		registerModel(new VModelHusazium(), "itemhusazium",  itemHusazium.itemID);
		itemKusistrium = new VItem(5503, 64, "itemKusistrium").setName("Кристалл кузистрия");
		registerModel(new VModelKusistrium(), "itemkusistrium",  itemKusistrium.itemID);
		itemYeselium = new VItem(5504, 64, "itemYeselium").setName("Кристалл йеселия").setMagical(new float[]{0.55F, 0.0F, 1.0F});
		registerModel(new VModelYeselium(), "itemyeselium",  itemYeselium.itemID);
		itemPlabster = new VItem(5505, 64, "itemPlabster").setName("Плабстер для прессовки");
		itemPressedVintarium = new VItem(5506, 64, "itemPressedVintarium").setName("Пресованный винтарий");
		itemPressedGelatrium = new VItem(5507, 64, "itemPressedGelatrium").setName("Пресованный гелатрий");
		itemPressedHusazium = new VItem(5508, 64, "itemPressedHusazium").setName("Пресованный хусазиум");
		itemPressedKusistrium = new VItem(5509, 64, "itemPressedKusistrium").setName("Пресованный кузистрий");
		itemPressedYeselium = new VItem(5510, 64, "itemPressedYeselium").setName("Пресованный йеселий");
		itempickVintarium = new VItem(5511, 64, "itempickVintarium").setName("Винтариевая основа кирки");
		itempickGelatrium = new VItem(5512, 64, "itempickGelatrium").setName("Гелатриевая основа кирки");
		itempickHusazium = new VItem(5513, 64, "itempickHusazium").setName("Хусазиумаевая основа кирки");
		itempickKusistrium = new VItem(5514, 64, "itempickKusistrium").setName("Кузистриевая основа кирки");
		itempickYeselium = new VItem(5515, 64, "itempickYeselium").setName("Йеселиевая основа кирки");
		itemswordVintarium = new VItem(5516, 64, "itemswordVintarium").setName("Винтариевая основа меча");
		itemswordGelatrium = new VItem(5517, 64, "itemswordGelatrium").setName("Гелатриевая основа меча");
		itemswordHusazium = new VItem(5518, 64, "itemswordHusazium").setName("Хусазиумаевая основа меча");
		itemswordKusistrium = new VItem(5519, 64, "itemswordKusistrium").setName("Кузистриевая основа меча");
		itemswordYeselium = new VItem(5520, 64, "itemswordYeselium").setName("Йеселиевая основа меча");
		itemingotVintarium = new VItem(5521, 64, "itemingotVintarium").setName("Винтариевый слиток");
		itemingotGelatrium = new VItem(5522, 64, "itemingotGelatrium").setName("Гелатриевый слиток");
		itemingotHusazium = new VItem(5523, 64, "itemingotHusazium").setName("Хусазиумаевый слиток");
		itemingotKusistrium = new VItem(5524, 64, "itemingotKusistrium").setName("Кузистриевый слиток");
		itemingotYeselium = new VItem(5525, 64, "itemingotYeselium").setName("Йеселиевый слиток");
		
		rpgFood = new VMultiItem(5900, 26, 64, "rpgFood").setName("Клубника", 0).setName("Кусок арбуза", 1).setName("Вишня", 2).setName("Светлый виноград", 3).setName("Тёмный виноград", 4).setName("Ежевика", 5).setName("Зеленый перец", 6).setName("Желтый перец", 7).setName("Красный перец", 8).setName("Красная редька", 9).setName("Морковь", 10).setName("Груша", 11).setName("Ананас", 12).setName("Апельсин", 13).setName("Лимон", 14).setName("Банан", 15).setName("Гриб", 16).setName("Рыбье тело", 17).setName("Сырая рыба", 18).setName("Жаренная рыба", 19).setName("Сырое мясо", 20).setName("Жаренное мясо", 21).setName("Желудь", 22).setName("Темный хлеб", 23).setName("Сыр", 24).setName("Киви", 25);
		rpgItem = new VMultiItem(5901, 3, 1, "rpgItem").setName("Карта", 0).setName("Записная книжка", 1).setName("Часы", 2);
		rpgItems = new VMultiItem(5902, 24, 64, "rpgItems").setName("Трехлистный клевер", 0).setName("Кристалл", 1).setName("Ткань", 2).setName("Перо", 3).setName("Лист", 4).setName("Кость", 5).setName("Книга морей", 6).setName("Книга космоса", 7).setName("Книга расписаний", 8).setName("Книга исскуств", 9).setName("Некромоникон", 10).setName("Книга крови", 11).setName("Книга секретов", 12).setName("Книга силуэтов", 13).setName("Книга", 14).setName("Книга путеводов", 15).setName("Книга карт", 16).setName("Книга X", 17).setName("Книга древностей", 18).setName("Книга воспоминаний", 19).setName("Книга боевых исскуств", 20).setName("Песчаник с гравировкой", 21).setName("Книга шифров", 22).setName("Каменная плита с гравировкой", 23);
		
		itemNecklace = (ItemNecklace)new ItemNecklace(6000, 8).setName("Амулет из зубов", 0).setName("Амулет жизни", 1).setName("Амулет боли", 2).setName("Амулет холодного сердца", 3).setName("Амулет войны", 4).setName("Клыкаррский амулет", 5).setName("Амулет святых", 6).setName("Золотой крестик", 7);
		itemRing = (ItemRing)new ItemRing(6001, 1).setName("Серебрянное кольцо", 0);
		itemMedal = (ItemMedal)new ItemMedal(6002, 4).setName("Медаль 'Участник войны'", 0).setName("Медаль 'Военный спасатель'", 1).setName("Медаль 'Абсолютный герой'", 2).setName("Медаль чемпиона", 3);
		itemFist = (ItemFist)new ItemFist(6003, 5).setName("Обычный кастет", 0).setName("Шипастый кастет", 1).setName("Шипованная перчатка", 2).setName("Перчатка с лезвием", 3).setName("Металлическая перчатка", 4);
		
		
		pickVintarium = new VPickaxe(7000, materialVintarium, 1, "pickVintarium").setName("Винтариевая кирка");
		registerModel(new VModelVintariumGelatriumHusaziumPickaxe(), "pickvintarium", pickVintarium.itemID);
		pickGelatrium = new VPickaxe(7001, materialGelatrium, 1, "pickGelatrium").setName("Гелатриевая кирка");
		registerModel(new VModelVintariumGelatriumHusaziumPickaxe(), "pickgelatrium",  pickGelatrium.itemID);
		pickHusazium = new VPickaxe(7002, materialHusazium, 1, "pickHusazium").setName("Хусазиумаевая кирка");
		registerModel(new VModelVintariumGelatriumHusaziumPickaxe(), "pickhusazium",  pickHusazium.itemID);
		pickKusistrium = new VPickaxe(7003, materialKusistrium, 1, "pickKusistrium").setName("Кузистриевая кирка");
		registerModel(new VModelKusistriumPickaxe(), "pickkusistrium",  pickKusistrium.itemID);
		pickYeselium = new VPickaxe(7004, materialYeselium, 1, "pickYeselium").setName("Йеселивая кирка").setMagical(new float[]{0.55F, 0.0F, 1.0F});
		registerModel(new VModelYeseliumPickaxe(), "pickyeselium",  pickYeselium.itemID);
		swordVintarium = (VSword)new VSword(7500, "swordVintarium", true, 1, 13, 7500).setName("винтариевый меч").set2DSpecial();
		swordGelatrium = (VSword)new VSword(7501, "swordGelatrium", true, 2, 16, 7500).setName("гелатриевый меч").set2DSpecial();
		swordHusazium = (VSword)new VSword(7502, "swordHusazium", true, 3, 19, 10000).setName("хусазиумаевый меч").set2DSpecial();
		swordKusistrium = (VSword)new VSword(7503, "swordKusistrium", true, 4, 22, 12500).setName("кузистриевый меч").set2DSpecial();
		swordYeselium = (VSword)new VSword(7504, "swordYeselium", true, 5, 25, 15000).setName("йеселиевый меч").set2DSpecial();
		
		armorVintarium0 = new VItemArmor(8500, 0, 50, "vintarium0", "armorVintarium0").setName("Винтариевый шлем");
		armorVintarium1 = new VItemArmor(8501, 1, 50, "vintarium0", "armorVintarium1").setName("Винтариевый нагрудник");
		armorVintarium2 = new VItemArmor(8502, 2, 50, "vintarium1", "armorVintarium2").setName("Винтариевые поножи");
		armorVintarium3 = new VItemArmor(8503, 3, 50, "vintarium0", "armorVintarium3").setName("Винтариевые ботинки");
		armorGelatrium0 = new VItemArmor(8504, 0, 75, "gelatrium0", "armorGelatrium0").setName("Гелатриевый шлем");
		armorGelatrium1 = new VItemArmor(8505, 1, 75, "gelatrium0", "armorGelatrium1").setName("Гелатриевый нагрудник");
		armorGelatrium2 = new VItemArmor(8506, 2, 75, "gelatrium1", "armorGelatrium2").setName("Гелатриевые поножи");
		armorGelatrium3 = new VItemArmor(8507, 3, 75, "gelatrium0", "armorGelatrium3").setName("Гелатриевые ботинки");
		armorHusazium0 = new VItemArmor(8508, 0, 100, "husazium0", "armorHusazium0").setName("Хусазиумаевый шлем");
		armorHusazium1 = new VItemArmor(8509, 1, 100, "husazium0", "armorHusazium1").setName("Хусазиумаевый нагрудник");
		armorHusazium2 = new VItemArmor(8510, 2, 100, "husazium1", "armorHusazium2").setName("Хусазиумаевые поножи");
		armorHusazium3 = new VItemArmor(8511, 3, 100, "husazium0", "armorHusazium3").setName("Хусазиумаевые ботинки");
		armorKusistrium0 = new VItemArmor(8512, 0, 125, "kusistrium0", "armorKusistrium0").setName("Кузистриевый шлем");
		armorKusistrium1 = new VItemArmor(8513, 1, 125, "kusistrium0", "armorKusistrium1").setName("Кузистриевый нагрудник");
		armorKusistrium2 = new VItemArmor(8514, 2, 125, "kusistrium1", "armorKusistrium2").setName("Кузистриевые поножи");
		armorKusistrium3 = new VItemArmor(8515, 3, 125, "kusistrium0", "armorKusistrium3").setName("Кузистриевые ботинки");
		armorYeselium0 = new VItemArmor(8516, 0, 150, "yeselium0", "armorYeselium0").setName("Йеселиевый шлем");
		armorYeselium1 = new VItemArmor(8517, 1, 150, "yeselium0", "armorYeselium1").setName("Йеселиевый нагрудник");
		armorYeselium2 = new VItemArmor(8518, 2, 150, "yeselium1", "armorYeselium2").setName("Йеселиевые поножи");
		armorYeselium3 = new VItemArmor(8519, 3, 150, "yeselium0", "armorYeselium3").setName("Йеселиевые ботинки");
		return this;
	}
	
	public ItemRegistry post() {
		GameRegistry.addRecipe(new ItemStack(pickVintarium), new Object[]{"X", "O", "O", 'X', new ItemStack(itempickVintarium), 'O', new ItemStack(Item.stick)});
		GameRegistry.addRecipe(new ItemStack(pickGelatrium), new Object[]{"X", "O", "O", 'X', new ItemStack(itempickGelatrium), 'O', new ItemStack(Item.stick)});
		GameRegistry.addRecipe(new ItemStack(pickHusazium), new Object[]{"XXX", " O ", " O ", 'X', new ItemStack(itempickHusazium), 'O', new ItemStack(Item.stick)});
		GameRegistry.addRecipe(new ItemStack(pickKusistrium), new Object[]{"XXX", " O ", " O ", 'X', new ItemStack(itempickKusistrium), 'O', new ItemStack(Item.stick)});
		GameRegistry.addRecipe(new ItemStack(pickYeselium), new Object[]{"XXX", " O ", " O ", 'X', new ItemStack(itempickYeselium), 'O', new ItemStack(Item.stick)});
		GameRegistry.addRecipe(new ItemStack(BlockRegistry.blockPress.blockID, 1, 0), new Object[]{"XXX", "XOY", "III", 'X', new ItemStack(Block.blockIron), 'O', new ItemStack(Block.furnaceIdle), 'Y', new ItemStack(351, 1, 1), 'I', new ItemStack(Block.anvil)});
		GameRegistry.addRecipe(new ItemStack(BlockRegistry.blockToolStation.blockID, 1, 0), new Object[]{"XOY", "XIX", "III", 'X', new ItemStack(Block.blockIron), 'O', new ItemStack(Block.planks), 'Y', new ItemStack(351, 1, 1), 'I', new ItemStack(Block.anvil)});
		GameRegistry.addRecipe(new ItemStack(itemPlabster, 1, 0), new Object[]{"XOX", "YIY", "XOX", 'X', new ItemStack(Block.obsidian), 'O', new ItemStack(Block.blockIron), 'Y', new ItemStack(Block.coalBlock), 'I', new ItemStack(Block.blockDiamond)});
		GameRegistry.addRecipe(new ItemStack(itemPlabster, 1, 0), new Object[]{"XYX", "OIO", "XYX", 'X', new ItemStack(Block.obsidian), 'O', new ItemStack(Block.blockIron), 'Y', new ItemStack(Block.coalBlock), 'I', new ItemStack(Block.blockDiamond)});
		GameRegistry.addRecipe(new ItemStack(BlockRegistry.blockVintarium), new Object[]{"XX", "XX", 'X', new ItemStack(itemingotVintarium)});
		GameRegistry.addRecipe(new ItemStack(BlockRegistry.blockGelatrium), new Object[]{"XX", "XX", 'X', new ItemStack(itemingotGelatrium)});
		GameRegistry.addRecipe(new ItemStack(BlockRegistry.blockHusazium), new Object[]{"XX", "XX", 'X', new ItemStack(itemingotHusazium)});
		GameRegistry.addRecipe(new ItemStack(BlockRegistry.blockKusistrium), new Object[]{"XX", "XX", 'X', new ItemStack(itemingotKusistrium)});
		GameRegistry.addRecipe(new ItemStack(BlockRegistry.blockYeselium), new Object[]{"XX", "XX", 'X', new ItemStack(itemingotYeselium)});
		GameRegistry.addRecipe(new ItemStack(swordVintarium), new Object[]{"X", "O", 'X', new ItemStack(itemswordVintarium), 'O', new ItemStack(Item.stick)});
		GameRegistry.addRecipe(new ItemStack(swordGelatrium), new Object[]{"X", "O", 'X', new ItemStack(itemswordGelatrium), 'O', new ItemStack(Item.stick)});
		GameRegistry.addRecipe(new ItemStack(swordHusazium), new Object[]{"X", "O", 'X', new ItemStack(itemswordHusazium), 'O', new ItemStack(Item.stick)});
		GameRegistry.addRecipe(new ItemStack(swordKusistrium), new Object[]{"X", "O", 'X', new ItemStack(itemswordKusistrium), 'O', new ItemStack(Item.stick)});
		GameRegistry.addRecipe(new ItemStack(swordYeselium), new Object[]{"X", "O", 'X', new ItemStack(itemswordYeselium), 'O', new ItemStack(Item.stick)});
		for (int i = 0; i != 5; i++) GameRegistry.addRecipe(new ItemStack(8756 + (i * 4), 1, 0), new Object[]{"XOX", "Y Y", 'X', new ItemStack(5762 + i, 1, 0), 'O', new ItemStack(5777 + i, 1, 0), 'Y', new ItemStack(5756 + i, 1, 0)});
		for (int i = 0; i != 5; i++) GameRegistry.addRecipe(new ItemStack(8757 + (i * 4), 1, 0), new Object[]{"X X", "XYX", "XOX", 'X', new ItemStack(5762 + i, 1, 0), 'O', new ItemStack(5777 + i, 1, 0), 'Y', new ItemStack(5756 + i, 1, 0)});
		for (int i = 0; i != 5; i++) GameRegistry.addRecipe(new ItemStack(8758 + (i * 4), 1, 0), new Object[]{"YOY", "X X", "X X", 'X', new ItemStack(5762 + i, 1, 0), 'O', new ItemStack(5777 + i, 1, 0), 'Y', new ItemStack(5756 + i, 1, 0)});
		for (int i = 0; i != 5; i++) GameRegistry.addRecipe(new ItemStack(8759 + (i * 4), 1, 0), new Object[]{"Y Y", "XOX", 'X', new ItemStack(5762 + i, 1, 0), 'O', new ItemStack(5777 + i, 1, 0), 'Y', new ItemStack(5756 + i, 1, 0)});
		return this;
	}
	
	public void registerModel(ModelBase par1, String par2, int par3) {
		if (Utils.isClient()) {
			ClientProxy.itemmodels.add(new ModelItemCreation(par3, par1, par2));
		}
	}
	
	public void add(String obj, ItemStack i, char[] j, ItemStack[] k) {
		if (k.length == 1)
			GameRegistry.addRecipe(i, new Object[]{obj.substring(0, 3), obj.substring(3, 6), obj.substring(6, 9), j[0], k[0]});
		else if (k.length == 2)
			GameRegistry.addRecipe(i, new Object[]{obj.substring(0, 3), obj.substring(3, 6), obj.substring(6, 9), j[0], k[0], j[1], k[1]});
		else if (k.length == 3)
			GameRegistry.addRecipe(i, new Object[]{obj.substring(0, 3), obj.substring(3, 6), obj.substring(6, 9), j[0], k[0], j[1], k[1], j[2], k[2]});
		else if (k.length == 4)
			GameRegistry.addRecipe(i, new Object[]{obj.substring(0, 3), obj.substring(3, 6), obj.substring(6, 9), j[0], k[0], j[1], k[1], j[2], k[2], j[3], k[3]});
		else if (k.length == 5)
			GameRegistry.addRecipe(i, new Object[]{obj.substring(0, 3), obj.substring(3, 6), obj.substring(6, 9), j[0], k[0], j[1], k[1], j[2], k[2], j[3], k[3], j[4], k[4]});
		else if (k.length == 6)
			GameRegistry.addRecipe(i, new Object[]{obj.substring(0, 3), obj.substring(3, 6), obj.substring(6, 9), j[0], k[0], j[1], k[1], j[2], k[2], j[3], k[3], j[4], k[4], j[5], k[5]});
		else if (k.length == 7)
			GameRegistry.addRecipe(i, new Object[]{obj.substring(0, 3), obj.substring(3, 6), obj.substring(6, 9), j[0], k[0], j[1], k[1], j[2], k[2], j[3], k[3], j[4], k[4], j[5], k[5], j[6], k[6]});
		else if (k.length == 8) 
			GameRegistry.addRecipe(i, new Object[]{obj.substring(0, 3), obj.substring(3, 6), obj.substring(6, 9), j[0], k[0], j[1], k[1], j[2], k[2], j[3], k[3], j[4], k[4], j[5], k[5], j[6], k[6], j[7], k[7]});
		else if (k.length == 9)
			GameRegistry.addRecipe(i, new Object[]{obj.substring(0, 3), obj.substring(3, 6), obj.substring(6, 9), j[0], k[0], j[1], k[1], j[2], k[2], j[3], k[3], j[4], k[4], j[5], k[5], j[6], k[6], j[7], k[7], j[8], k[8]});
	}
}
