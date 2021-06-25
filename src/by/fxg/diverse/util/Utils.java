package by.fxg.diverse.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import by.fxg.diverse.common.storage.ValueObject;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Utils {
	public static HashMap<Integer, EnumRarityBase> raritylist = new HashMap<Integer, EnumRarityBase>();
	
	public static boolean isClient() {
		return FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT;
	}
	
	public static NBTTagCompound getNBT(ItemStack i) {
		if (i.getTagCompound() == null) {
			i.setTagCompound(new NBTTagCompound("tag"));
			return i.getTagCompound();
		} else {
			return i.getTagCompound();
		}
	}
	
	public static ValueObject[] getBuffsSword(EnumRarityBase e) {
		ValueObject[] obj = new ValueObject[16];
		if (e != null) {
			switch(e) {
			case BROKEN:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(-75.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(-65.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(30);
				break;
			case GLOOMY:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(-70.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(-60.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(30);
				break;
			case SCORCHED:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(-65.0D);
				obj[1] = new ValueObject(EnumValue.FIRE).setFire(1);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(-55.0D);
				obj[4] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(30);
				break;
			case CURVED:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(-50.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(17);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(-40.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(30);
				break;
			case OLD:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(-40.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(15);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(-20.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(30);
				break;
			case BLOOMING:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(-35.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(10);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(-15.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(20);
				break;
			case POISON:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(-30.0D);
				obj[1] = new ValueObject(EnumValue.POTION).setPotion(Potion.poison, 1);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(-29.0D);
				obj[4] = new ValueObject(EnumValue.BIGPOTION).setPotion(Potion.poison, 2);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(26);
				break;
			case ANCIENT:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(-25.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(-15.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(30);
				break;
			case CURSED:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(-20.0D);
				obj[1] = new ValueObject(EnumValue.INSTAPOTION).setPotion(Potion.poison, 5);
				obj[2] = new ValueObject(EnumValue.INSTAPOTION).setPotion(Potion.blindness, 5);
				obj[3] = new ValueObject(EnumValue.INSTAFIRE).setFire(1);
				obj[4] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[5] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(-10.0D);
				obj[6] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(30);
				break;
			case EMERGENCY:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(-15.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(14);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(5.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(36);
				break;
			case DARK:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(-10.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(0.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(30);
				break;
			case SMALL:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(-5.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(10);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(5.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(20);
				break;
			case FLOWERING:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(5.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(16);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(15.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(30);
				break;
			case WEIGHTY:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(2.5D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(5.5D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(30);
				break;
			case FORGED:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(10.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(17);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(15.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(30);
				break;
			case GLACIAL:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(5.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(24);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(10.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(34);
				break;
			case DEFAULT:
				obj[0] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[1] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(20);
				break;
			case BUTCHER:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(25.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(30.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(30);
				break;
			case QUARRY:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(10.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(18.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(40);
				break;
			case BUZZ:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(5.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(14);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(12.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(26);
				break;
			case NEW:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(5.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(19);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(12.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(38);
				break;
			case LIGHT:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(15.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(14);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(25.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(36);
				break;
			case BIG:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(10.0D);
				obj[1] = new ValueObject(EnumValue.INSTAPOTION).setPotion(Potion.moveSlowdown, 5);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(24);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(20.0D);
				obj[4] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(48);
				break;
			case BATTLE:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(20.0D);
				obj[1] = new ValueObject(EnumValue.POTION).setPotion(Potion.damageBoost, 2);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(18);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(40.0D);
				obj[4] = new ValueObject(EnumValue.BIGPOTION).setPotion(Potion.damageBoost, 5);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(46);
				break;
			case CHIMERICAL:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(10.0D);
				obj[1] = new ValueObject(EnumValue.POTIONENEMY).setPotion(Potion.poison, 3);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(18);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(17.0D);
				obj[4] = new ValueObject(EnumValue.BIGPOTIONENEMY).setPotion(Potion.poison, 10);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(40);
				break;
			case VORACIOUS:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(10.0D);
				obj[1] = new ValueObject(EnumValue.POTION).setPotion(Potion.hunger, 5);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(18);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(12.0D);
				obj[4] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(28);
				break;
			case MOLTEN:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(20.0D);
				obj[1] = new ValueObject(EnumValue.FIREENEMY).setFire(5);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(26);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(22.0D);
				obj[4] = new ValueObject(EnumValue.BIGFIREENEMY).setFire(10);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(40);
				break;
			case STRONG:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(27.5D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(28);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(50.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(50);
				break;
			case FURIOUS:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(15.0D);
				obj[1] = new ValueObject(EnumValue.POTION).setPotion(Potion.fireResistance, 3);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(10);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(18.0D);
				obj[4] = new ValueObject(EnumValue.BIGPOTION).setPotion(Potion.fireResistance, 4);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(20);
				break;
			case THUNDEROUS:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(15.0D);
				obj[1] = new ValueObject(EnumValue.POTION).setPotion(Potion.resistance, 3);
				obj[2] = new ValueObject(EnumValue.POTION).setPotion(Potion.regeneration, 1);
				obj[3] = new ValueObject(EnumValue.COOLDOWN).setTime(12);
				obj[4] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(18.0D);
				obj[5] = new ValueObject(EnumValue.BIGPOTION).setPotion(Potion.resistance, 4);
				obj[6] = new ValueObject(EnumValue.BIGPOTION).setPotion(Potion.regeneration, 2);
				obj[7] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(24);
				break;
			case BLOODY:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(10.0D);
				obj[1] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(14);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(13.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(18);
				break;
			case DISASTROUS:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(-20.0D);
				obj[1] = new ValueObject(EnumValue.POTION).setPotion(Potion.resistance, 5);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(-13.0D);
				obj[4] = new ValueObject(EnumValue.BIGPOTION).setPotion(Potion.resistance, 3);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(26);
				break;
			case FLAMING:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(12.0D);
				obj[1] = new ValueObject(EnumValue.POTION).setPotion(Potion.fireResistance, 3);
				obj[2] = new ValueObject(EnumValue.FIREENEMY).setFire(5);
				obj[3] = new ValueObject(EnumValue.COOLDOWN).setTime(22);
				obj[4] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(20.0D);
				obj[5] = new ValueObject(EnumValue.BIGPOTION).setPotion(Potion.fireResistance, 7);
				obj[6] = new ValueObject(EnumValue.BIGFIREENEMY).setFire(10);
				obj[7] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(40);
				break;
			case BALANCED:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(5.0D);
				obj[1] = new ValueObject(EnumValue.POTIONENEMY).setPotion(Potion.resistance, 2);
				obj[2] = new ValueObject(EnumValue.FIREENEMY).setFire(2);
				obj[3] = new ValueObject(EnumValue.COOLDOWN).setTime(18);
				obj[4] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(15.0D);
				obj[5] = new ValueObject(EnumValue.BIGPOTIONENEMY).setPotion(Potion.resistance, 1);
				obj[6] = new ValueObject(EnumValue.BIGFIREENEMY).setFire(4);
				obj[7] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(30);
				break;
			case HEAVY:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(20.0D);
				obj[1] = new ValueObject(EnumValue.POTIONENEMY).setPotion(Potion.confusion, 5);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(26);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(25.0D);
				obj[4] = new ValueObject(EnumValue.BIGPOTIONENEMY).setPotion(Potion.confusion, 7);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(40);
				break;
			case MAGICAL:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(5.0D);
				obj[1] = new ValueObject(EnumValue.POTION).setPotion(Potion.resistance, 1);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(9.0D);
				obj[4] = new ValueObject(EnumValue.BIGPOTION).setPotion(Potion.resistance, 2);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(40);
				break;
			case BLESSED:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(5.0D);
				obj[1] = new ValueObject(EnumValue.POTIONENEMY).setPotion(Potion.blindness, 3);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(14.0D);
				obj[4] = new ValueObject(EnumValue.BIGPOTIONENEMY).setPotion(Potion.blindness, 10);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(60);
				break;
			case RUNIC:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(35.0D);
				obj[1] = new ValueObject(EnumValue.POTION).setPotion(Potion.blindness, 5);
				obj[2] = new ValueObject(EnumValue.POTION).setPotion(Potion.confusion, 10);
				obj[3] = new ValueObject(EnumValue.COOLDOWN).setTime(18);
				obj[4] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(90.0D);
				obj[5] = new ValueObject(EnumValue.BIGPOTION).setPotion(Potion.blindness, 20);
				obj[6] = new ValueObject(EnumValue.BIGPOTION).setPotion(Potion.confusion, 40);
				obj[7] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(80);
				break;
			case RISING:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(30.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(24);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(70.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(56);
				break;
			case POWERFUL:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(25.0D);
				obj[1] = new ValueObject(EnumValue.POTION).setPotion(Potion.damageBoost, 3);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(18);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(50.0D);
				obj[4] = new ValueObject(EnumValue.BIGPOTION).setPotion(Potion.damageBoost, 6);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(36);
				break;
			case DEVOURING:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(30.0D);
				obj[1] = new ValueObject(EnumValue.POTION).setPotion(Potion.blindness, 5);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(24);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(55.0D);
				obj[4] = new ValueObject(EnumValue.BIGPOTION).setPotion(Potion.blindness, 6);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(42);
				break;
			case TUSKARR:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(35.0D);
				obj[1] = new ValueObject(EnumValue.FIRE).setFire(1);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(20);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(55.0D);
				obj[4] = new ValueObject(EnumValue.BIGFIRE).setFire(3);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(34);
				break;
			case HEAVENLY:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(30.0D);
				obj[1] = new ValueObject(EnumValue.POTIONENEMY).setPotion(Potion.confusion, 5);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(28);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(75.0D);
				obj[4] = new ValueObject(EnumValue.BIGPOTIONENEMY).setPotion(Potion.confusion, 12);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(60);
				break;
			case SPARKING:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(35.0D);
				obj[1] = new ValueObject(EnumValue.FIREENEMY).setFire(3);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(22);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(60.0D);
				obj[4] = new ValueObject(EnumValue.BIGFIREENEMY).setFire(7);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(40);
				break;
			case CELESTIAL:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(40.0D);
				obj[1] = new ValueObject(EnumValue.POTIONENEMY).setPotion(Potion.moveSlowdown, 3);
				obj[2] = new ValueObject(EnumValue.COOLDOWN).setTime(18);
				obj[3] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(60.0D);
				obj[4] = new ValueObject(EnumValue.BIGPOTIONENEMY).setPotion(Potion.moveSlowdown, 6);
				obj[5] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(34);
				break;	
			case TROPHY:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(45.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(4);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(70.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(28);
				break;
			case COSTY:
				obj[0] = new ValueObject(EnumValue.DAMAGEENEMY).setPercent(50.0D);
				obj[1] = new ValueObject(EnumValue.COOLDOWN).setTime(6);
				obj[2] = new ValueObject(EnumValue.BIGDAMAGEENEMY).setPercent(80.0D);
				obj[3] = new ValueObject(EnumValue.BIGCOOLDOWN).setTime(30);
				break;
			default:
				break;
			}
			Integer len = 0;
			for (int i = 0; i != 16; i++) {
				if (obj[i] != null) {
					len++;
				}
			}
			Integer templen = 0;
			ValueObject[] vals = new ValueObject[len];
			for (int i = 0; i != 16; i++) {
				if (obj[i] != null) {
					vals[templen] = obj[i];
					templen++;
				}
			}
			return vals;
		}
		return null;
	}
	
	public static Entity getAimedEntity(World par1World, Entity par2Entity, double par3Range, float par4Padding) {
		return getAimedEntity(par1World, par2Entity, par3Range, par4Padding, false);
	}

	public static Entity getAimedEntity(World par1World, Entity par2Entity, double par3Range, float par4Padding, boolean par5NonCollide) {
		return getAimedEntity(par1World, par2Entity, par3Range, par4Padding, par5NonCollide, (IEntitySelector)null);
	}

	public static Entity getAimedEntity(World par1World, Entity par2Entity, double par3Range, float par4Padding, boolean par5NonCollide, IEntitySelector par6Selector) {
		Entity var1 = null;
		Vec3 var2 = Vec3.fakePool.getVecFromPool(par2Entity.posX, par2Entity.posY + (double) par2Entity.getEyeHeight(), par2Entity.posZ);
		Vec3 var3 = par2Entity.getLookVec();
		List var4 = par1World.getEntitiesWithinAABBExcludingEntity(par2Entity, par2Entity.boundingBox.addCoord(var3.xCoord * par3Range, var3.yCoord * par3Range, var3.zCoord * par3Range).expand((double) par4Padding, (double) par4Padding, (double) par4Padding), par6Selector);
		double var5 = 0.0D;
		Vec3 var6 = null;
		List var7 = new ArrayList();
		if (var4.size() > 0) {
			var6 = var2.addVector(var3.xCoord * par3Range, var3.yCoord * par3Range, var3.zCoord * par3Range);
		}
		float var8;
		for (int i$ = 0; i$ < var4.size(); ++i$) {
			Entity var9 = (Entity) var4.get(i$);
			if ((var9.canBeCollidedWith() || par5NonCollide) && par1World.rayTraceBlocks_do_do(par1World.getWorldVec3Pool().getVecFromPool(par2Entity.posX, par2Entity.posY + (double) par2Entity.getEyeHeight(), par2Entity.posZ), par1World.getWorldVec3Pool().getVecFromPool(var9.posX, var9.posY + (double) var9.getEyeHeight(), var9.posZ), false, true) == null) {
				var8 = par4Padding > 0.0F ? par4Padding - 0.3F : 0.8F;
				var8 = Math.max(var8, var9.getCollisionBorderSize());
				AxisAlignedBB var10 = var9.boundingBox.expand((double) var8, (double) var8, (double) var8);
				MovingObjectPosition var11 = null;
				if (var10.isVecInside(var2)) {
					if (0.0D < var5 || var5 == 0.0D) {
						var1 = var9;
						var5 = 0.0D;
					}
				} else if ((var11 = var10.calculateIntercept(var2, var6)) != null) {
					double var12 = var2.distanceTo(var11.hitVec);
					if (var12 < var5 || var5 == 0.0D) {
						var1 = var9;
						var5 = var12;
					}
				}
			}
		}
		if (var1 != null) {
			Vec3 var9 = Vec3.fakePool.getVecFromPool(var1.posX, var1.posY + (double) var1.getEyeHeight(), var1.posZ);
			for (int i$ = 0; i$ < var7.size(); ++i$) {
				Entity var10 = (Entity) var7.get(i$);
				var8 = par4Padding > 0.0F ? par4Padding - 0.3F : 0.8F;
				float var11 = Math.max(var8, var10.getCollisionBorderSize());
				AxisAlignedBB var12 = var10.boundingBox.expand((double) var11, (double) var11, (double) var11);
				if (var12.isVecInside(var9)) {
					var1 = var10;
					break;
				}
			}
		}
		return var1;
	}
	
	public static int getPercentOf(int par1Percent, int par2Low, int par3High) {
		return (int)((double)par2Low / ((double)par3High / par1Percent));
	}
	
	public static double getPercentOf(double par1Percent, double par2Low, double par3High) {
		return ((double)par2Low / ((double)par3High / par1Percent));
	}
	
    public static void drawTexturedRect(int par1, int par2, int par3, int par4, int par5, int par6, double zLevel) {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + par6), zLevel, (double)((float)(par3 + 0) * f), (double)((float)(par4 + par6) * f1));
        tessellator.addVertexWithUV((double)(par1 + par5), (double)(par2 + par6), zLevel, (double)((float)(par3 + par5) * f), (double)((float)(par4 + par6) * f1));
        tessellator.addVertexWithUV((double)(par1 + par5), (double)(par2 + 0), zLevel, (double)((float)(par3 + par5) * f), (double)((float)(par4 + 0) * f1));
        tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + 0), zLevel, (double)((float)(par3 + 0) * f), (double)((float)(par4 + 0) * f1));
        tessellator.draw();
    }

    public static void drawTexturedRectFromIcon(int par1, int par2, Icon par3Icon, int par4, int par5, double zLevel) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + par5), zLevel, (double)par3Icon.getMinU(), (double)par3Icon.getMaxV());
        tessellator.addVertexWithUV((double)(par1 + par4), (double)(par2 + par5), zLevel, (double)par3Icon.getMaxU(), (double)par3Icon.getMaxV());
        tessellator.addVertexWithUV((double)(par1 + par4), (double)(par2 + 0), zLevel, (double)par3Icon.getMaxU(), (double)par3Icon.getMinV());
        tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + 0), zLevel, (double)par3Icon.getMinU(), (double)par3Icon.getMinV());
        tessellator.draw();
    }
}
