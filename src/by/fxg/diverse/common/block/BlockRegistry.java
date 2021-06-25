package by.fxg.diverse.common.block;

import java.lang.reflect.Field;

import by.fxg.diverse.client.ClientProxy;
import by.fxg.diverse.client.model.block.VModelOre;
import by.fxg.diverse.client.model.block.VModelPress;
import by.fxg.diverse.client.model.block.VModelToolStation;
import by.fxg.diverse.common.item.ItemRegistry;
import by.fxg.diverse.common.storage.ModelTileCreation;
import by.fxg.diverse.common.tile.TileOreGelatrium;
import by.fxg.diverse.common.tile.TileOreHusazium;
import by.fxg.diverse.common.tile.TileOreKusistrium;
import by.fxg.diverse.common.tile.TileOreVintarium;
import by.fxg.diverse.common.tile.TileOreYeselium;
import by.fxg.diverse.common.tile.TileParticleGetter;
import by.fxg.diverse.common.tile.TilePortal;
import by.fxg.diverse.common.tile.TilePress;
import by.fxg.diverse.common.tile.TileToolStation;
import by.fxg.diverse.util.Utils;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;

public class BlockRegistry {
	public int id = 3999;
	public static VOreBase oreVintarium;
	public static VOreBase oreGelatrium;
	public static VOreBase oreHusazium;
	public static VOreBase oreKusistrium;
	public static VOreBase oreYeselium;
	
	public static VBlockGuiBase blockPress;
	public static VBlockGuiBase blockToolStation;
	
	public static VBlockTextured blockVintarium;
	public static VBlockTextured blockGelatrium;
	public static VBlockTextured blockHusazium;
	public static VBlockTextured blockKusistrium;
	public static VBlockTextured blockYeselium;
	
	public static VBlockGuiBase blockParticleGetter;
	public static VBlockBase blockPortal;
	
	public BlockRegistry init() {
		registerOre(TileOreVintarium.class, "TileOreVintarium", "oreVintarium", "Винтариевая руда", 2000, ItemRegistry.itemVintarium.itemID, 25.0F, new VModelOre(), "orevintarium");
		registerOre(TileOreGelatrium.class, "TileOreGelatrium", "oreGelatrium", "Гелатриевая руда", 2001, ItemRegistry.itemGelatrium.itemID, 50.0F, new VModelOre(), "oregelatrium");
		registerOre(TileOreHusazium.class, "TileOreHusazium", "oreHusazium", "Хусазиумаевая руда", 2002, ItemRegistry.itemHusazium.itemID, 75.0F, new VModelOre(), "orehusazium");
		registerOre(TileOreKusistrium.class, "TileOreKusistrium", "oreKusistrium", "Кузистриевая руда", 2003, ItemRegistry.itemKusistrium.itemID, 100.0F, new VModelOre(), "orekusistrium");
		registerOre(TileOreYeselium.class, "TileOreYeselium", "oreYeselium", "Йеселиевая руда", 2004, ItemRegistry.itemYeselium.itemID, 125.0F, new VModelOre(), "oreyeselium");
		
		registerGuiBlock(TilePress.class, "TilePress", "blockPress", "Базовый прессовщик кристаллов", 2200, 1000, 0, new VModelPress(), "blockpress");
		registerGuiBlock(TileToolStation.class, "TileToolStation", "blockToolStation", "Инструментальный стол", 2201, 1001, 1, new VModelToolStation(), "blocktoolstation");
		
		registerTextured(2400, "blockVintarium", "Блок винтария");
		registerTextured(2401, "blockGelatrium", "Блок гелатрия");
		registerTextured(2402, "blockHusazium", "Блок хусазиума");
		registerTextured(2403, "blockKusistrium", "Блок кузистрия");
		registerTextured(2404, "blockYeselium", "Блок йеселия");
		
		GameRegistry.registerTileEntity(TileParticleGetter.class, "TileParticleGetter");
		GameRegistry.registerBlock((Block)(this.blockParticleGetter = new VBlockGuiBase(2202, "TileParticleGetter", 1002).install("blockParticleGetter.block")), "blockParticleGetter.item");
		LanguageRegistry.addName(this.blockParticleGetter, "Улавливатель частиц"); 

		GameRegistry.registerTileEntity(TilePortal.class, "TilePortal");
		GameRegistry.registerBlock((Block)(this.blockPortal = new BlockPortal(2210)), "blockPortal.item");
		LanguageRegistry.addName(this.blockPortal, "Портал"); 
		
		return this;
	}
	
	private void registerTextured(int id, String field, String name) {
		try {
			Field f = this.getClass().getField(field);
			Object fo = f.get(this.getClass());
			GameRegistry.registerBlock((Block)(fo = new VBlockTextured(id, field).install(field + ".block")), field + ".item");
			LanguageRegistry.addName(fo, name); 
			f.set(this.getClass(), fo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void registerOre(Class tile, String tileobj, String field, String name, int id, int itemid, float hardness, ModelBase model, String texture) {
		try {
			GameRegistry.registerTileEntity(tile, tile.getSimpleName());
			Field f = this.getClass().getField(field);
			Object fo = f.get(this.getClass());
			GameRegistry.registerBlock((Block)(fo = new VOreBase(id, tileobj, itemid, hardness).install(tile.getSimpleName() + ".block")), tile.getSimpleName() + ".item");
			LanguageRegistry.addName(fo, name); 
			f.set(this.getClass(), fo);
			if (Utils.isClient()) {
				ClientProxy.blockmodels.add(new ModelTileCreation(id, 0, model, tile, texture));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void registerGuiBlock(Class tile, String tileobj, String field, String name, int id, int guid, int rendid, ModelBase model, String texture) {
		try {
			GameRegistry.registerTileEntity(tile, tile.getSimpleName());
			Field f = this.getClass().getField(field);
			Object fo = f.get(this.getClass());
			GameRegistry.registerBlock((Block)(fo = new VBlockGuiBase(id, tileobj, guid).install(tile.getSimpleName() + ".block")), tile.getSimpleName() + ".item");
			LanguageRegistry.addName(fo, name); 
			f.set(this.getClass(), fo);
			if (Utils.isClient()) {
				ClientProxy.customblockmodels.add(new ModelTileCreation(id, rendid, model, tile, texture));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void registerBlockModel(Class tile, int id, int rendid, ModelBase model, String texture) {
		try {
			if (Utils.isClient()) {
				ClientProxy.customblockmodels.add(new ModelTileCreation(id, rendid, model, tile, texture));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int nextInt() {
		this.id++;
		return this.id;
	}
}
