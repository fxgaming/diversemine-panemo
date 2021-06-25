package by.fxg.diverse.client.storage;

import java.util.ArrayList;

import by.fxg.diverse.client.cherry.ItemWiki;
import by.fxg.diverse.common.item.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ClientWikiDatabase {
	public static ArrayList<ItemWiki> itemWiki = new ArrayList<ItemWiki>();
	public static ArrayList<ItemWiki> blockWiki = new ArrayList<ItemWiki>();
	
	public ClientWikiDatabase init() {
		aiw(i(5756, 0), null, -1, "Маленький, непрозрачный салатовый кристалл.", "Можно добыть в шахте, пересобрать из частиц, либо синтезировать.", "Один из важнейших материалов для крафта.", "Легко");
		aiw(i(5757, 0), null, -1, "Маленький, слегка прозрачный оранжевый кристалл.", "Можно добыть в шахте, пересобрать из частиц, либо синтезировать.", "Один из важнейших материалов для крафта.", "Легко");
		aiw(i(5758, 0), null, -1, "Маленький, слегка прозрачный красный кристалл.", "Можно добыть в шахте, пересобрать из частиц, либо синтезировать.", "Один из важнейших материалов для крафта.", "Легко");
		aiw(i(5759, 0), null, -1, "Маленький, прозрачный зеленый кристалл.", "Можно добыть в шахте, пересобрать из частиц, либо синтезировать.", "Один из важнейших материалов для крафта.", "Не легко");
		aiw(i(5760, 0), null, -1, "Обычный, прозрачный фиолетовый кристалл.", "Можно добыть в шахте, пересобрать из частиц, либо синтезировать.", "Один из важнейших материалов для крафта.", "Не легко");
		aiw(i(5761, 0), null, -1, "Субстанция, похожая на очень густую, однородную глину.", "Можно добыть в шахте.", "Материал для прессовки кристаллов.", "Не легко");
		aiw(i(5762, 0), ii(new ItemStack(ItemRegistry.itemVintarium, 8, 0), new ItemStack(ItemRegistry.itemPlabster), new ItemStack(ItemRegistry.itemPressedVintarium)), 5, "Прессованный материал...", "Можно получить после прессовки кристаллов.", "Один из важнейших материалов для крафта.", "Не легко");
		aiw(i(5763, 0), ii(new ItemStack(ItemRegistry.itemGelatrium, 8, 0), new ItemStack(ItemRegistry.itemPlabster), new ItemStack(ItemRegistry.itemPressedGelatrium)), 5, "Прессованный материал...", "Можно получить после прессовки кристаллов.", "Один из важнейших материалов для крафта.", "Средне");
		aiw(i(5764, 0), ii(new ItemStack(ItemRegistry.itemHusazium, 8, 0), new ItemStack(ItemRegistry.itemPlabster), new ItemStack(ItemRegistry.itemPressedHusazium)), 5, "Прессованный материал...", "Можно получить после прессовки кристаллов.", "Один из важнейших материалов для крафта.", "Средне");
		aiw(i(5765, 0), ii(new ItemStack(ItemRegistry.itemKusistrium, 8, 0), new ItemStack(ItemRegistry.itemPlabster), new ItemStack(ItemRegistry.itemPressedKusistrium)), 5, "Прессованный материал...", "Можно получить после прессовки кристаллов.", "Один из важнейших материалов для крафта.", "Средне");
		aiw(i(5766, 0), ii(new ItemStack(ItemRegistry.itemYeselium, 8, 0), new ItemStack(ItemRegistry.itemPlabster), new ItemStack(ItemRegistry.itemPressedYeselium)), 5, "Прессованный материал...", "Можно получить после прессовки кристаллов.", "Один из важнейших материалов для крафта.", "Средне");
		aiw(i(5767, 0), ii(null, new ItemStack(ItemRegistry.itemPressedVintarium, 16, 0), null, new ItemStack(Block.coalBlock, 16, 0), new ItemStack(ItemRegistry.itempickVintarium)), 6, "Заготовка для кирки повышенной прочности.", "Можно получить в инструментальном столе.", "Главный предмет в крафте кирок повышенных прочностей.", "Средне");
		aiw(i(5768, 0), ii(null, new ItemStack(ItemRegistry.itemPressedGelatrium, 24, 0), null, new ItemStack(Block.coalBlock, 24, 0), new ItemStack(ItemRegistry.itempickGelatrium)), 6, "Заготовка для кирки повышенной прочности.", "Можно получить в инструментальном столе.", "Главный предмет в крафте кирок повышенных прочностей.", "Средне");
		aiw(i(5769, 0), ii(null, new ItemStack(ItemRegistry.itemPressedHusazium, 32, 0), null, new ItemStack(Block.coalBlock, 32, 0), new ItemStack(ItemRegistry.itempickHusazium)), 6, "Заготовка для кирки повышенной прочности.", "Можно получить в инструментальном столе.", "Главный предмет в крафте кирок повышенных прочностей.", "Средне-сложно");
		aiw(i(5770, 0), ii(null, new ItemStack(ItemRegistry.itemPressedKusistrium, 48, 0), null, new ItemStack(Block.coalBlock, 48, 0), new ItemStack(ItemRegistry.itempickKusistrium)), 6, "Заготовка для кирки повышенной прочности.", "Можно получить в инструментальном столе.", "Главный предмет в крафте кирок повышенных прочностей.", "Средне-сложно");
		aiw(i(5771, 0), ii(null, new ItemStack(ItemRegistry.itemPressedYeselium, 64, 0), null, new ItemStack(Block.coalBlock, 64, 0), new ItemStack(ItemRegistry.itempickYeselium)), 6, "Заготовка для кирки повышенной прочности.", "Можно получить в инструментальном столе.", "Главный предмет в крафте кирок повышенных прочностей.", "Средне-сложно");
		aiw(i(5772, 0), ii(null, null, new ItemStack(ItemRegistry.itemPressedVintarium, 48, 0), new ItemStack(Block.coalBlock, 64, 0), new ItemStack(ItemRegistry.itemswordVintarium)), 6, "Заготовка для меча повышенной прочности <SPLIT>и случайного эффекта.", "Можно получить в инструментальном столе.", "Главный предмет в крафте мечей повышенной прочности со случайными <SPLIT>эффектами.", "Средне");
		aiw(i(5773, 0), ii(null, null, new ItemStack(ItemRegistry.itemPressedGelatrium, 48, 0), new ItemStack(Block.coalBlock, 64, 0), new ItemStack(ItemRegistry.itemswordGelatrium)), 6, "Заготовка для меча повышенной прочности <SPLIT>и случайного эффекта.", "Можно получить в инструментальном столе.", "Главный предмет в крафте мечей повышенной прочности со случайными <SPLIT>эффектами.", "Средне");
		aiw(i(5774, 0), ii(null, null, new ItemStack(ItemRegistry.itemPressedHusazium, 64, 0), new ItemStack(Block.coalBlock, 64, 0), new ItemStack(ItemRegistry.itemswordHusazium)), 6, "Заготовка для для меча повышенной прочности <SPLIT>и случайного эффекта.", "Можно получить в инструментальном столе.", "Главный предмет в крафте мечей повышенной прочности со случайными <SPLIT>эффектами.", "Средне-сложно");
		aiw(i(5775, 0), ii(null, null, new ItemStack(ItemRegistry.itemPressedKusistrium, 64, 0), new ItemStack(Block.coalBlock, 64, 0), new ItemStack(ItemRegistry.itemswordKusistrium)), 6, "Заготовка для меча повышенной прочности <SPLIT>и случайного эффекта.", "Можно получить в инструментальном столе.", "Главный предмет в крафте мечей повышенной прочности со случайными <SPLIT>эффектами.", "Средне-сложно");
		aiw(i(5776, 0), ii(null, null, new ItemStack(ItemRegistry.itemPressedYeselium, 64, 0), new ItemStack(Block.coalBlock, 64, 0), new ItemStack(ItemRegistry.itemswordYeselium)), 6, "Заготовка для меча повышенной прочности <SPLIT>и случайного эффекта.", "Можно получить в инструментальном столе.", "Главный предмет в крафте мечей повышенной прочности со случайными <SPLIT>эффектами.", "Средне-сложно");
		aiw(i(5777, 0), ii(new ItemStack(ItemRegistry.itemPressedVintarium, 48, 0), null, null, new ItemStack(Block.coalBlock, 16, 0), new ItemStack(ItemRegistry.itemingotVintarium)), 6, "Красивый кристальный слиток. Теперь можно и <SPLIT>о будущем можно задуматся...", "Можно получить в инструментальном столе.", "Используется в крафтах.", "Средне-сложно");
		aiw(i(5778, 0), ii(new ItemStack(ItemRegistry.itemPressedGelatrium, 48, 0), null, null, new ItemStack(Block.coalBlock, 24, 0), new ItemStack(ItemRegistry.itemingotGelatrium)), 6, "Красивый кристальный слиток. Теперь можно и <SPLIT>о будущем можно задуматся...", "Можно получить в инструментальном столе.", "Используется в крафтах.", "Средне-сложно");
		aiw(i(5779, 0), ii(new ItemStack(ItemRegistry.itemPressedHusazium, 64, 0), null, null, new ItemStack(Block.coalBlock, 32, 0), new ItemStack(ItemRegistry.itemingotHusazium)), 6, "Красивый кристальный слиток. Теперь можно и <SPLIT>о будущем можно задуматся...", "Можно получить в инструментальном столе.", "Используется в крафтах.", "Средне-сложно");
		aiw(i(5780, 0), ii(new ItemStack(ItemRegistry.itemPressedKusistrium, 64, 0), null, null, new ItemStack(Block.coalBlock, 48, 0), new ItemStack(ItemRegistry.itemingotKusistrium)), 6, "Красивый кристальный слиток. Теперь можно и <SPLIT>о будущем можно задуматся...", "Можно получить в инструментальном столе.", "Используется в крафтах.", "Средне-сложно");
		aiw(i(5781, 0), ii(new ItemStack(ItemRegistry.itemPressedYeselium, 64, 0), null, null, new ItemStack(Block.coalBlock, 64, 0), new ItemStack(ItemRegistry.itemingotYeselium)), 6, "Красивый кристальный слиток. Теперь можно и <SPLIT>о будущем можно задуматся...", "Можно получить в инструментальном столе.", "Используется в крафтах.", "Средне-сложно");
		
		for (int i = 0; i != 5; i++) aiw(i(7256 + i, 0), null, -1, "Просто кирка повышенной прочности.<SPLIT>Отлично подходит для разрушения кристальных руд.", "Можно скрафтить.", "Добыча ресурсов.", "Средне-легко");
		for (int i = 0; i != 5; i++) aiw(i(7756 + i, 0), null, -1, "Необычный меч который имеет свои особенные свойства.<SPLIT>Меч при его создании или перековке получает свои эффекты.<SPLIT>Всего эффектов на данный момент 45.", "Можно скрафтить.", "Борьба, оборона.", "Средне-сложно");
		for (int i = 0; i != 4; i++) aiw(i(8756 + i, 0), null, -1, "Необычная самовосстанавливающаяся броня которая поглащает урон!<SPLIT>Сет такой брони может неплохо защитить от монстра или другого игрока.<SPLIT>У каждой ед. брони есть свой заряд, их называют 'элами'<SPLIT>у данного вида брони на единицу предусмотрено 50 'элов'.", "Можно скрафтить.", "Борьба, оборона.", "Средне-сложно");
		for (int i = 0; i != 4; i++) aiw(i(8760 + i, 0), null, -1, "Необычная самовосстанавливающаяся броня которая поглащает урон!<SPLIT>Сет такой брони может неплохо защитить от монстра или другого игрока.<SPLIT>У каждой ед. брони есть свой заряд, их называют 'элами'<SPLIT>у данного вида брони на единицу предусмотрено 75 'элов'.", "Можно скрафтить.", "Борьба, оборона.", "Средне-сложно");
		for (int i = 0; i != 4; i++) aiw(i(8764 + i, 0), null, -1, "Необычная самовосстанавливающаяся броня которая поглащает урон!<SPLIT>Сет такой брони может неплохо защитить от монстра или другого игрока.<SPLIT>У каждой ед. брони есть свой заряд, их называют 'элами'<SPLIT>у данного вида брони на единицу предусмотрено 100 'элов'.", "Можно скрафтить.", "Борьба, оборона.", "Средне-сложно");
		for (int i = 0; i != 4; i++) aiw(i(8768 + i, 0), null, -1, "Необычная самовосстанавливающаяся броня которая поглащает урон!<SPLIT>Сет такой брони может неплохо защитить от монстра или другого игрока.<SPLIT>У каждой ед. брони есть свой заряд, их называют 'элами'<SPLIT>у данного вида брони на единицу предусмотрено 125 'элов'.", "Можно скрафтить.", "Борьба, оборона.", "Средне-сложно");
		for (int i = 0; i != 4; i++) aiw(i(8772 + i, 0), null, -1, "Необычная самовосстанавливающаяся броня которая поглащает урон!<SPLIT>Сет такой брони может неплохо защитить от монстра или другого игрока.<SPLIT>У каждой ед. брони есть свой заряд, их называют 'элами'<SPLIT>у данного вида брони на единицу предусмотрено 150 'элов'.", "Можно скрафтить.", "Борьба, оборона.", "Средне-сложно");
		
		abw(i(2000, 0), null, -1, "Руда. Из нее падают кристаллы. Количество кристаллов <SPLIT>зависит от вашего 'рейта'.<SPLIT>Рейт - Параметр, который увеличивает добычу кристаллов в X раз.", "Можно найти в мире добычи(шахтмир).", "Источник кристаллов.", "Легко");
		abw(i(2001, 0), null, -1, "Руда. Из нее падают кристаллы. Количество кристаллов <SPLIT>зависит от вашего 'рейта'.<SPLIT>Рейт - Параметр, который увеличивает добычу кристаллов в X раз.", "Можно найти в мире добычи(шахтмир).", "Источник кристаллов.", "Легко");
		abw(i(2002, 0), null, -1, "Руда. Из нее падают кристаллы. Количество кристаллов <SPLIT>зависит от вашего 'рейта'.<SPLIT>Рейт - Параметр, который увеличивает добычу кристаллов в X раз.", "Можно найти в мире добычи(шахтмир).", "Источник кристаллов.", "Легко");
		abw(i(2003, 0), null, -1, "Руда. Из нее падают кристаллы. Количество кристаллов <SPLIT>зависит от вашего 'рейта'.<SPLIT>Рейт - Параметр, который увеличивает добычу кристаллов в X раз.", "Можно найти в мире добычи(шахтмир).", "Источник кристаллов.", "Легко");
		abw(i(2004, 0), null, -1, "Руда. Из нее падают кристаллы. Количество кристаллов <SPLIT>зависит от вашего 'рейта'.<SPLIT>Рейт - Параметр, который увеличивает добычу кристаллов в X раз.", "Можно найти в мире добычи(шахтмир).", "Источник кристаллов.", "Легко");
		abw(i(2400, 0), ii(new ItemStack(ItemRegistry.itemingotVintarium, 1, 0), new ItemStack(ItemRegistry.itemingotVintarium, 1, 0), null, new ItemStack(ItemRegistry.itemingotVintarium, 1, 0), new ItemStack(ItemRegistry.itemingotVintarium, 1, 0), null, null, null, null, new ItemStack(2400, 1, 0)), -1, "Кристальный блок. Ценная вещица нынче.", "Можно скрафтить из кристальных слитков.", "Используется в крафтах.", "Средне-сложно");
		abw(i(2401, 0), ii(new ItemStack(ItemRegistry.itemingotGelatrium, 1, 0), new ItemStack(ItemRegistry.itemingotGelatrium, 1, 0), null, new ItemStack(ItemRegistry.itemingotGelatrium, 1, 0), new ItemStack(ItemRegistry.itemingotGelatrium, 1, 0), null, null, null, null, new ItemStack(2401, 1, 0)), -1, "Кристальный блок. Ценная вещица нынче.", "Можно скрафтить из кристальных слитков.", "Используется в крафтах.", "Средне-сложно");
		abw(i(2402, 0), ii(new ItemStack(ItemRegistry.itemingotHusazium, 1, 0), new ItemStack(ItemRegistry.itemingotHusazium, 1, 0), null, new ItemStack(ItemRegistry.itemingotHusazium, 1, 0), new ItemStack(ItemRegistry.itemingotHusazium, 1, 0), null, null, null, null, new ItemStack(2402, 1, 0)), -1, "Кристальный блок. Ценная вещица нынче.", "Можно скрафтить из кристальных слитков.", "Используется в крафтах.", "Средне-сложно");
		abw(i(2403, 0), ii(new ItemStack(ItemRegistry.itemingotKusistrium, 1, 0), new ItemStack(ItemRegistry.itemingotKusistrium, 1, 0), null, new ItemStack(ItemRegistry.itemingotKusistrium, 1, 0), new ItemStack(ItemRegistry.itemingotKusistrium, 1, 0), null, null, null, null, new ItemStack(2403, 1, 0)), -1, "Кристальный блок. Ценная вещица нынче.", "Можно скрафтить из кристальных слитков.", "Используется в крафтах.", "Средне-сложно");
		abw(i(2404, 0), ii(new ItemStack(ItemRegistry.itemingotYeselium, 1, 0), new ItemStack(ItemRegistry.itemingotYeselium, 1, 0), null, new ItemStack(ItemRegistry.itemingotYeselium, 1, 0), new ItemStack(ItemRegistry.itemingotYeselium, 1, 0), null, null, null, null, new ItemStack(2404, 1, 0)), -1, "Кристальный блок. Ценная вещица нынче.", "Можно скрафтить из кристальных слитков.", "Используется в крафтах.", "Средне-сложно");
		abw(i(2200, 0), ii(new ItemStack(Block.blockIron), new ItemStack(Block.blockIron), new ItemStack(Block.blockIron), new ItemStack(Block.blockIron), new ItemStack(Block.furnaceIdle), new ItemStack(351, 1, 1), new ItemStack(Block.anvil), new ItemStack(Block.anvil), new ItemStack(Block.anvil), new ItemStack(2200, 1, 0)), -1, "Блок который прессует предметы с помощью плабстера.", "Можно скрафтить.", "Используется для прессовки.", "Очень легко");
		abw(i(2201, 0), ii(new ItemStack(Block.blockIron), new ItemStack(Block.planks), new ItemStack(351, 1, 1), new ItemStack(Block.blockIron), new ItemStack(Block.anvil), new ItemStack(Block.blockIron), new ItemStack(Block.anvil), new ItemStack(Block.anvil), new ItemStack(Block.anvil), new ItemStack(2201, 1, 0)), -1, "Блок предназначенный для изготовления слитков, основ кирок и мечей<SPLIT>повышенной прочности.", "Можно скрафтить.", "Используется для изготовления предметов.", "Очень легко");
		abw(i(2202, 0), ii(new ItemStack(2202, 1, 0)), -1, "Очень дорогой блок, который улавливает молекулы частиц.<SPLIT>Частицы можно взять и синтезировать предметов из них<SPLIT>в синтезаторе предметов.", "Можно скрафтить.", "Используется для пассивной добычи ресурсов.", "Сложно");
		
		return this;
	}
	
	private void aiw(ItemStack a, ItemStack[] b, int bc, String c, String d, String e, String f) {
		itemWiki.add(new ItemWiki(a, b, bc, c, d, e, f));
	}
	
	private void abw(ItemStack a, ItemStack[] b, int bc, String c, String d, String e, String f) {
		blockWiki.add(new ItemWiki(a, b, bc, c, d, e, f));
	}
	
	private ItemStack i(int id, int meta) {
		return new ItemStack(id, 1, meta);
	}

	private ItemStack[] ii(ItemStack... par1) {
		return par1;
	}
}
