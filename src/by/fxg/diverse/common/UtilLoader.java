package by.fxg.diverse.common;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;

import by.fxg.diverse.util.EnumRarityBase;
import by.fxg.diverse.util.Utils;

public class UtilLoader {
	public UtilLoader init() {
		return this.loadEnums();
	}
	
	public UtilLoader loadEnums() {
		Object[] rarity = EnumSet.allOf(EnumRarityBase.class).toArray();
		for (Object emum : rarity) {
			if (emum instanceof EnumRarityBase) {
				Utils.raritylist.put(((EnumRarityBase)emum).ID, (EnumRarityBase)emum);
			}
		}
		return this;
	}
}
