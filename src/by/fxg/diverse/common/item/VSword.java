package by.fxg.diverse.common.item;

import java.util.List;

import by.fxg.diverse.common.storage.ValueObject;
import by.fxg.diverse.util.DamageSourceItem;
import by.fxg.diverse.util.DamageSourcePlayer;
import by.fxg.diverse.util.EnumRarityBase;
import by.fxg.diverse.util.IDamageable;
import by.fxg.diverse.util.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class VSword extends VItem implements IDamageable {
	public int id;
	public boolean isDifferent;
	public int damage;
	public int maxDamage;
	public int tick = 0;
	
	public VSword(int par1, String par2, Boolean par3, int par4, int par5, int par6) {
		super(par1);
		this.setMaxStackSize(1);
		this.iconString = "diverse:" + par2;
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setUnlocalizedName("diverse.item:" + par2);
		this.setMaxDamage(par6);
		this.id = par4;
		this.isDifferent = par3;
		this.damage = par5;
		this.maxDamage = par6;
		this.setFull3D();
	}
	
	public VSword(int par1, String par2, Boolean par3, int par4, CreativeTabs par5, int par6, int par7) {
		this(par1, par2, par3, par4, par6, par7);
		this.setCreativeTab(par5);
	}
	
	public boolean isDamageable() {
		return this.maxDamage != -1;
	}

    public boolean onEntityItemUpdate(EntityItem par1) {
        return false;
    }
    
//    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
//    	if (stack.itemID == 22222) return true;
//        return false;
//    }
    
    public void addInformation(ItemStack i, EntityPlayer p, List l, boolean b) {
    	if (Utils.getNBT(i).hasKey("rare")) {
    		String tag = (String)l.get(0);
    		int end = Utils.raritylist.containsKey(Utils.getNBT(i).getInteger("rare")) ? Utils.raritylist.get(Utils.getNBT(i).getInteger("rare")).endingType : -1;
    		tag = (end == 0 ? "ый" : (end == 1 ? "ой" : (end == 2 ? "ий" : (end == 3 ? "ийся" : "ОШИБКА")))) + " " + tag;
        	String name = Utils.raritylist.containsKey(Utils.getNBT(i).getInteger("rare")) ? Utils.raritylist.get(Utils.getNBT(i).getInteger("rare")).Text : "";
    		l.set(0, name + tag);
    		double damage = 0.0D;
        	if (Utils.raritylist.containsKey(Utils.getNBT(i).getInteger("rare")) && Utils.getNBT(i).getInteger("rare") != 17) {
        		l.add("§7Усиления ЛКМ:");
	        	ValueObject[] vals = Utils.getBuffsSword(Utils.raritylist.get(Utils.getNBT(i).getInteger("rare")));
	        	for (int j = 0; j != vals.length; j++) {
	        		String type = "";
	        		switch(vals[j].value) {
					case CUSTOMFIRE:
						type = "Огонь по вам на X сек.";
						type = type.replace("X", "" + vals[j].time);
						break;
					case CUSTOMFIREENEMY:
						type = "Огонь по врагу на X сек.";
						type = type.replace("X", "" + vals[j].time);
						break;
					case CUSTOMINSTAFIRE:
						type = "";
						break;
					case DAMAGE:
						damage = ((double)this.damage / 100.0D) * (vals[j].percent);
						type = "Урон по вам Xед.";
						type = type.replace("X", "" + (int)damage);
						break;
					case DAMAGEENEMY:
						damage = ((double)this.damage / 100.0D) * (100.0D + vals[j].percent);
						type = "Урон по врагу Xед.";
						type = type.replace("X", "" + (int)damage);
						break;
					case FIRE:
						type = "Огонь по вам на X сек.";
						type = type.replace("X", "" + vals[j].time);
						break;
					case FIREENEMY:
						type = "Огонь по врагу на X сек.";
						type = type.replace("X", "" + vals[j].time);
						break;
					case INSTADAMAGE:
						damage = ((double)this.damage / 100.0D) * (100.0D + vals[j].percent);
						type = "Урон по вам сразу Xед.";
						type = type.replace("X", "" + (int)damage);
						break;
					case INSTAFIRE:
						type = "Огонь по вам сразу X сек.";
						type = type.replace("X", "" + vals[j].time);
						break;
					case INSTAPOTION:
						type = "Эффект X по вам сразу на Y сек.";
						type = type.replace("X", StatCollector.translateToLocal(vals[j].id.getName()));
						type = type.replace("Y", "" + vals[j].time);
						break;
					case POTION:
						type = "Эффект X по вам на Y сек.";
						type = type.replace("X", StatCollector.translateToLocal(vals[j].id.getName()));
						type = type.replace("Y", "" + vals[j].time);
						break;
					case POTIONENEMY:
						type = "Эффект X по врагу на Y сек.";
						type = type.replace("X", StatCollector.translateToLocal(vals[j].id.getName()));
						type = type.replace("Y", "" + vals[j].time);
						break;
					default:
						break;
	        		}
	        		if (!type.equals("")) l.add("§7 " + type);
	        	}
	        	l.add("§7Усиления ПКМ (нужна способность):");
	        	for (int j = 0; j != vals.length; j++) {
	        		String type = "";
	        		switch(vals[j].value) {
					case BIGCUSTOMFIRE:
						type = "Огонь по вам на X сек.";
						type = type.replace("X", "" + vals[j].time);
						break;
					case BIGCUSTOMFIREENEMY:
						type = "Огонь по врагу на X сек.";
						type = type.replace("X", "" + vals[j].time);
						break;
					case BIGDAMAGE:
						damage = ((double)this.damage / 100.0D) * (vals[j].percent);
						type = "Урон по вам Xед.";
						type = type.replace("X", "" + (int)damage);
						break;
					case BIGDAMAGEENEMY:
						damage = ((double)this.damage / 100.0D) * (100.0D + vals[j].percent);
						type = "Урон по врагу Xед.";
						type = type.replace("X", "" + (int)damage);
						break;
					case BIGFIRE:
						type = "Огонь по вам на X сек.";
						type = type.replace("X", "" + vals[j].time);
						break;
					case BIGFIREENEMY:
						type = "Огонь по врагу на X сек.";
						type = type.replace("X", "" + vals[j].time);
						break;
					case BIGPOTION:
						type = "Эффект X по вам на Y сек.";
						type = type.replace("X", StatCollector.translateToLocal(vals[j].id.getName()));
						type = type.replace("Y", "" + vals[j].time);
						break;
					case BIGPOTIONENEMY:
						type = "Эффект X по врагу на Y сек.";
						type = type.replace("X", StatCollector.translateToLocal(vals[j].id.getName()));
						type = type.replace("Y", "" + vals[j].time);
						break;
					default:
						break;
	        		}
	        		if (!type.equals("")) l.add("§7 " + type);
	        	}
	        	if (Utils.getNBT(i).getBoolean("infinity")) {
	        		l.add("§7 Не ломается.");
	        	}
        	} else {
        		l.add("§7Урон по врагу: " + this.damage);
        		if (Utils.getNBT(i).getBoolean("infinity")) {
	        		l.add("§7Не ломается.");
	        	}
        	}
    	}
    }
    
    public void onUpdate(ItemStack i, World w, Entity e, int par4, boolean par5) {
    	if (!w.isRemote) {
    		if (Utils.getNBT(i).getInteger("cooldown") > 0) {
    			Utils.getNBT(i).setInteger("cooldown", Utils.getNBT(i).getInteger("cooldown") - 1);
    		}
    		if (!Utils.getNBT(i).hasKey("rare") && this.isDifferent) {
    			int r = w.rand.nextInt(145) + 1;
    			if (r > 100) {
    				EnumRarityBase rare = Utils.raritylist.get(r - 100);
    				Utils.getNBT(i).setString("raretag", rare.Tag);
    				Utils.getNBT(i).setInteger("rare", r - 100);
    			} else {
    				Utils.getNBT(i).setString("raretag", "default");
    				Utils.getNBT(i).setInteger("rare", 17);
    			}
    		} else if (Utils.getNBT(i).hasKey("rare") && this.isDifferent) {
    			if (!Utils.getNBT(i).hasKey("infinity")) {
    				int r = w.rand.nextInt(100) + 1;
    				if (r >= 13 && r <= 23) {
    					Utils.getNBT(i).setBoolean("infinity", true);
    				} else {
    					Utils.getNBT(i).setBoolean("infinity", false);
    				}
    			}
    		}
    	}
    }
    
    public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer p) {
    	if (p != null && Utils.getAimedEntity(w, p, 3.0D, 0.5F) != null && !w.isRemote && Utils.getAimedEntity(w, p, 3.0D, 0.5F) instanceof EntityPlayer) {
    		if (i.getItemDamage() >= (this.maxDamage + 3)) {
    			return i;
    		}
    		if (Utils.getNBT(i).getInteger("cooldown") <= 0) {
	    		EntityPlayer attacked = (EntityPlayer)Utils.getAimedEntity(w, p, 3.0D, 0.5F);
	    		double currentDamage = this.damage;
	    		double backwardDamage = 0.0D;
	    		boolean hasInfinity = false;
	    		int cooldown = 0;
	    		if (Utils.getNBT(i).hasKey("rare")) {
	    			ValueObject[] vals = Utils.getBuffsSword(Utils.raritylist.get(Utils.getNBT(i).getInteger("rare")));
	    			for (ValueObject val : vals) {
	    				if (val.value == val.value.BIGDAMAGE) {
	    					backwardDamage = ((currentDamage / 100) * val.percent);
	    				}
	    				if (val.value == val.value.BIGDAMAGEENEMY) {
	    					currentDamage = ((currentDamage / 100) * (100 + val.percent));
	    				} 
	    				if (val.value == val.value.BIGPOTION) {
	    					p.addPotionEffect(new PotionEffect(val.id.getId(), val.time * 20, 0, true));
	    				}
	    				if (val.value == val.value.BIGPOTIONENEMY) {
	    					attacked.addPotionEffect(new PotionEffect(val.id.getId(), val.time * 20, 0, true));
	    				}
	    				if (val.value == val.value.BIGFIRE) {
	    					p.setFire(val.time);
	    				}
	    				if (val.value == val.value.BIGFIREENEMY) {
	    					attacked.setFire(val.time);
	    				}
	    				if (val.value == val.value.INFINITY) {
	    					hasInfinity = true;
	    				}
	    				if (val.value == val.value.BIGCOOLDOWN) {
	    					cooldown = val.time;
	    				}
	    			}
	    			attacked.attackEntityFrom(new DamageSourcePlayer(p), (float)currentDamage);
	        		if (backwardDamage > 0.0D) attacked.attackEntityFrom(new DamageSourceItem(p), (float)backwardDamage);
	        		if (!Utils.getNBT(i).getBoolean("infinity")) this.setDamage(i, i.getItemDamage() + 3);
	        		Utils.getNBT(i).setInteger("cooldown", cooldown);
		    		Utils.getNBT(i).setInteger("maxcooldown", cooldown);
	    		}
    		}
    	} else if (p != null && Utils.getAimedEntity(w, p, 3.0D, 0.5F) != null && !w.isRemote && Utils.getAimedEntity(w, p, 3.0D, 0.5F) instanceof EntityLivingBase) {
    		if (Utils.getNBT(i).getInteger("cooldown") <= 0) {
	    		if (i.getItemDamage() >= (this.maxDamage + 3)) {
	    			return i;
	    		}
	    		double currentDamage = this.damage;
	    		double backwardDamage = 0.0D;
	    		boolean hasInfinity = false;
	    		int cooldown = 0;
	    		if (Utils.getNBT(i).hasKey("rare")) {
	    			ValueObject[] vals = Utils.getBuffsSword(Utils.raritylist.get(Utils.getNBT(i).getInteger("rare")));
	    			for (ValueObject val : vals) {
	    				if (val.value == val.value.BIGDAMAGE) {
	    					backwardDamage = ((currentDamage / 100) * val.percent);
	    				}
	    				if (val.value == val.value.BIGDAMAGEENEMY) {
	    					currentDamage = ((currentDamage / 100) * (100 + val.percent));
	    				} 
	    				if (val.value == val.value.BIGPOTION) {
	    					p.addPotionEffect(new PotionEffect(val.id.getId(), val.time * 20, 0, true));
	    				}
	    				if (val.value == val.value.BIGPOTIONENEMY) {
	    					((EntityLivingBase)Utils.getAimedEntity(w, p, 3.0D, 0.5F)).addPotionEffect(new PotionEffect(val.id.getId(), val.time * 20, 0, true));
	    				}
	    				if (val.value == val.value.BIGFIRE) {
	    					p.setFire(val.time);
	    				}
	    				if (val.value == val.value.BIGFIREENEMY) {
	    					Utils.getAimedEntity(w, p, 3.0D, 0.5F).setFire(val.time);
	    				}
	    				if (val.value == val.value.INFINITY) {
	    					hasInfinity = true;
	    				}
	    				if (val.value == val.value.BIGCOOLDOWN) {
	    					cooldown = val.time;
	    				}
	    			}
	    		}
	    		Utils.getAimedEntity(w, p, 3.0D, 0.5F).attackEntityFrom(new DamageSourcePlayer(p), (float)this.damage);
	    		if (backwardDamage > 0.0D) p.attackEntityFrom(new DamageSourceItem(p), (float)backwardDamage);
	    		if (!Utils.getNBT(i).getBoolean("infinity")) this.setDamage(i, i.getItemDamage() + 3);
	    		Utils.getNBT(i).setInteger("cooldown", cooldown);
	    		Utils.getNBT(i).setInteger("maxcooldown", cooldown);
	    	} else {
	    		return i;
	    	}
    	}
    	p.swingItem();
        return i;
    }
    
    public boolean onLeftClickEntity(ItemStack s, EntityPlayer attacker, Entity e) {
    	if (attacker != null && e != null && e instanceof EntityPlayer && this.isDifferent && !e.worldObj.isRemote) {
    		if (s.getItemDamage() >= (this.maxDamage + 1)) {
    			return false;
    		}
    		if (Utils.getNBT(s).getInteger("cooldown") <= 0) {
	    		EntityPlayer attacked = (EntityPlayer)e;
	    		double currentDamage = this.damage;
	    		double backwardDamage = 0.0D;
	    		boolean hasInfinity = false;
	    		int cooldown = 0;
	    		if (Utils.getNBT(s).hasKey("rare")) {
	    			ValueObject[] vals = Utils.getBuffsSword(Utils.raritylist.get(Utils.getNBT(s).getInteger("rare")));
	    			for (ValueObject val : vals) {
	    				if (val.value == val.value.DAMAGE) {
	    					backwardDamage = ((currentDamage / 100) * val.percent);
	    				}
	    				if (val.value == val.value.DAMAGEENEMY) {
	    					currentDamage = ((currentDamage / 100) * (100 + val.percent));
	    				} 
	    				if (val.value == val.value.POTION) {
	    					attacker.addPotionEffect(new PotionEffect(val.id.getId(), val.time * 20, 0, true));
	    				}
	    				if (val.value == val.value.POTIONENEMY) {
	    					attacked.addPotionEffect(new PotionEffect(val.id.getId(), val.time * 20, 0, true));
	    				}
	    				if (val.value == val.value.FIRE) {
	    					attacker.setFire(val.time);
	    				}
	    				if (val.value == val.value.FIREENEMY) {
	    					attacked.setFire(val.time);
	    				}
	    				if (val.value == val.value.INFINITY) {
	    					hasInfinity = true;
	    				}
	    				if (val.value == val.value.COOLDOWN) {
	    					cooldown = val.time;
	    				}
	    			}
	    			attacked.attackEntityFrom(new DamageSourcePlayer(attacker), (float)currentDamage);
	        		if (backwardDamage > 0.0D) attacked.attackEntityFrom(new DamageSourceItem(attacker), (float)backwardDamage);
	        		if (!Utils.getNBT(s).getBoolean("infinity")) this.setDamage(s, s.getItemDamage() + 1);
	        		Utils.getNBT(s).setInteger("cooldown", cooldown);
		    		Utils.getNBT(s).setInteger("maxcooldown", cooldown);
		    		return true;
	    		}
    		} else {
    			return false;
    		}
    	} else if (e instanceof EntityLivingBase) {
    		if (s.getItemDamage() >= (this.maxDamage + 1)) {
    			return false;
    		}
    		if (Utils.getNBT(s).getInteger("cooldown") <= 0) {
	    		double currentDamage = this.damage;
	    		double backwardDamage = 0.0D;
	    		boolean hasInfinity = false;
	    		int cooldown = 0;
	    		if (Utils.getNBT(s).hasKey("rare")) {
	    			ValueObject[] vals = Utils.getBuffsSword(Utils.raritylist.get(Utils.getNBT(s).getInteger("rare")));
	    			for (ValueObject val : vals) {
	    				if (val.value == val.value.DAMAGE) {
	    					backwardDamage = ((currentDamage / 100) * val.percent);
	    				}
	    				if (val.value == val.value.DAMAGEENEMY) {
	    					currentDamage = ((currentDamage / 100) * (100 + val.percent));
	    				} 
	    				if (val.value == val.value.POTION) {
	    					attacker.addPotionEffect(new PotionEffect(val.id.getId(), val.time * 20, 0, true));
	    				}
	    				if (val.value == val.value.POTIONENEMY) {
	    					((EntityLivingBase)e).addPotionEffect(new PotionEffect(val.id.getId(), val.time * 20, 0, true));
	    				}
	    				if (val.value == val.value.FIRE) {
	    					attacker.setFire(val.time);
	    				}
	    				if (val.value == val.value.FIREENEMY) {
	    					e.setFire(val.time);
	    				}
	    				if (val.value == val.value.INFINITY) {
	    					hasInfinity = true;
	    				}
	    				if (val.value == val.value.COOLDOWN) {
	    					cooldown = val.time;
	    				}
	    			}
	    		}
	    		e.attackEntityFrom(new DamageSourcePlayer(attacker), (float)this.damage);
	    		if (backwardDamage > 0.0D) attacker.attackEntityFrom(new DamageSourceItem(attacker), (float)backwardDamage);
	    		if (!Utils.getNBT(s).getBoolean("infinity")) this.setDamage(s, s.getItemDamage() + 1);
	    		Utils.getNBT(s).setInteger("cooldown", cooldown);
	    		Utils.getNBT(s).setInteger("maxcooldown", cooldown);
	    		return true;
    		} else {
    			return false;
    		}
    	}
        return false;
    }
}
