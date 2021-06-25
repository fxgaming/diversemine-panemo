package by.fxg.diverse.common.player;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class ExtendedData {
	public Integer playerLevel;
	public Integer playerExperience;
	public Integer levelPoints;
	public Integer personalPlayerPoints;
	public Boolean hasNewLevel;
	
	public ExtendedData() {
		this.playerLevel = 1;
		this.playerExperience = 0;
		this.levelPoints = 0;
		this.personalPlayerPoints = 2;
		this.hasNewLevel = false;
	}
	
	public void saveToNBT(NBTTagCompound tags) {
		NBTTagCompound nbt = tags.getCompoundTag("extendedData");
		nbt.setInteger("playerLevel", this.playerLevel);
		nbt.setInteger("playerExperience", this.playerExperience);
		nbt.setInteger("levelPoints", this.levelPoints);
		nbt.setInteger("personalPlayerPoints", this.personalPlayerPoints);
		nbt.setBoolean("hasNewLevel", this.hasNewLevel);
		tags.setCompoundTag("extendedData", nbt);
	}

	public void readFromNBT(NBTTagCompound tags) {
		NBTTagCompound nbt = tags.getCompoundTag("extendedData");
		this.playerLevel = nbt.getInteger("playerLevel");
		this.playerExperience = nbt.getInteger("playerExperience");
		this.levelPoints = nbt.getInteger("levelPoints");
		this.personalPlayerPoints = nbt.getInteger("personalPlayerPoints");
		this.hasNewLevel = nbt.getBoolean("hasNewLevel");
	}
	
	public void expandLevel(int experience) {
		int currentLevel = this.playerLevel;
		int newLevel = this.getLevel(experience);
		int exp = this.playerExperience;
		int points = 0; 
		if (newLevel > currentLevel) {
			points = currentLevel - newLevel;
			currentLevel = newLevel;
			exp = experience;
			this.hasNewLevel = true;
		}
		this.playerLevel = currentLevel;
		this.playerExperience = exp;
		this.levelPoints += points;
	}
	
	public int getExpPercentOf80() {
		if (this.playerExperience == 0) {
			return 0;
		}
		return (int)((this.getExperienceToNext(this.playerLevel) / 100) / this.playerExperience);
	}
	
	public int getLevel(int exp) {
		if (exp < 10) {
			return 0;
		} else if (exp < 100) {
			return 1;
		} else if (exp < 500) {
			return 2;
		} else if (exp < 1000) {
			return 3;
		} else if (exp < 2000) {
			return 4;
		} else if (exp < 4000) {
			return 5;
		} else if (exp < 8000) {
			return 6;
		} else if (exp < 16000) {
			return 7;
		} else if (exp < 32000) {
			return 8;
		} else if (exp < 64000) {
			return 9;
		} else if (exp < 80000) {
			return 10;
		} else if (exp < 100000) {
			return 11;
		} else if (exp < 150000) {
			return 12;
		} else if (exp < 200000) {
			return 13;
		} else if (exp < 250000) {
			return 14;
		} else if (exp < 300000) {
			return 15;
		} else if (exp < 350000) {
			return 16;
		} else if (exp < 400000) {
			return 17;
		} else if (exp < 450000) {
			return 18;
		} else if (exp < 500000) {
			return 19;
		} else if (exp < 600000) {
			return 20;
		} else if (exp < 700000) {
			return 21;
		} else if (exp < 800000) {
			return 22;
		} else if (exp < 900000) {
			return 23;
		} else if (exp < 1000000) {
			return 24;
		} else if (exp < 1100000) {
			return 25;
		} else if (exp < 1200000) {
			return 26;
		} else if (exp < 1300000) {
			return 27;
		} else if (exp < 1400000) {
			return 28;
		} else if (exp < 1500000) {
			return 29;
		} else if (exp < 1750000) {
			return 30;
		} else if (exp < 2000000) {
			return 31;
		} else if (exp < 2250000) {
			return 32;
		} else if (exp < 2500000) {
			return 33;
		} else if (exp < 2750000) {
			return 34;
		} else if (exp < 3000000) {
			return 35;
		} else if (exp < 3250000) {
			return 36;
		} else if (exp < 3500000) {
			return 37;
		} else if (exp < 3750000) {
			return 38;
		} else if (exp < 4000000) {
			return 39;
		} else if (exp < 4500000) {
			return 40;
		} else if (exp < 5000000) {
			return 41;
		} else if (exp < 5500000) {
			return 42;
		} else if (exp < 6000000) {
			return 43;
		} else if (exp < 6500000) {
			return 44;
		} else if (exp < 7000000) {
			return 45;
		} else if (exp < 7500000) {
			return 46;
		} else if (exp < 8000000) {
			return 47;
		} else if (exp < 8500000) {
			return 48;
		} else if (exp < 9000000) {
			return 49;
		} else if (exp < 9500000) {
			return 50;
		} else if (exp < 10000000) {
			return 51;
		} else if (exp < 999999999) {
			return 0;
		}  else {
			return 0;
		}
	}
	
	public int getExperienceToNext(int level) {
		switch (level) {
			case 0:
				return 10;
			case 1:
				return 100;
			case 2:
				return 500;
			case 3:
				return 1000;
			case 4:
				return 2000;
			case 5:
				return 4000;
			case 6:
				return 8000;
			case 7:
				return 16000;
			case 8:
				return 32000;
			case 9:
				return 64000;
			case 10:
				return 80000;
			case 11:
				return 100000;
			case 12:
				return 150000;
			case 13:
				return 200000;
			case 14:
				return 250000;
			case 15:
				return 300000;
			case 16:
				return 350000;
			case 17:
				return 400000;
			case 18:
				return 450000;
			case 19:
				return 500000;
			case 20:
				return 600000;
			case 21:
				return 700000;
			case 22:
				return 800000;
			case 23:
				return 900000;
			case 24:
				return 1000000;
			case 25:
				return 1100000;
			case 26:
				return 1200000;
			case 27:
				return 1300000;
			case 28:
				return 1400000;
			case 29:
				return 1500000;
			case 30:
				return 1750000;
			case 31:
				return 2000000;
			case 32:
				return 2250000;
			case 33:
				return 2500000;
			case 34:
				return 2750000;
			case 35:
				return 3000000;
			case 36:
				return 3250000;
			case 37:
				return 3500000;
			case 38:
				return 3750000;
			case 39:
				return 4000000;
			case 40:
				return 4500000;
			case 41:
				return 5000000;
			case 42:
				return 5500000;
			case 43:
				return 6000000;
			case 44:
				return 6500000;
			case 45:
				return 7000000;
			case 46:
				return 7500000;
			case 47:
				return 8000000;
			case 48:
				return 8500000;
			case 49:
				return 9000000;
			case 50:
				return 10000000;
			default:
				return 999999999;
		}
	}
}
