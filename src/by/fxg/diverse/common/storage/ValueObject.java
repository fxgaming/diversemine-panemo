package by.fxg.diverse.common.storage;

import java.io.Serializable;

import by.fxg.diverse.util.EnumValue;
import net.minecraft.potion.Potion;

public class ValueObject implements Serializable {
	public EnumValue value;
	public Double percent;
	public Potion id;
	public Integer time;
	public Integer damage;
	
	public ValueObject(EnumValue v) {
		this.value = v;
		this.percent = 0.0D;
		this.id = null;
		this.time = 0;
		this.damage = 0;
	}
	
	public ValueObject setPercent(Double par1) {
		this.percent = par1;
		return this;
	}
	
	public ValueObject setPotion(Potion par1, Integer par2) {
		this.id = par1;
		this.time = par2;
		return this;
	}
	
	public ValueObject setDamage(Integer par1) {
		this.damage = par1;
		return this;
	}
	
	public ValueObject setFire(Integer par1) {
		this.time = par1;
		return this;
	}
	
	public ValueObject setCustomFire(Integer par1, Integer par2) {
		this.damage = par1;
		this.time = par2;
		return this;
	}
	
	public ValueObject setTime(int par1) {
		this.time = par1;
		return this;
	}
}
