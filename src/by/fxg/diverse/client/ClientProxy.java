package by.fxg.diverse.client;

import java.util.ArrayList;

import by.fxg.diverse.Viod;
import by.fxg.diverse.client.model.block.VModelParticleGetter;
import by.fxg.diverse.client.model.block.VModelPortal;
import by.fxg.diverse.client.render.VRender2DSpecial;
import by.fxg.diverse.client.render.VRenderBase;
import by.fxg.diverse.client.render.VRenderCustom;
import by.fxg.diverse.client.render.VRenderItems;
import by.fxg.diverse.common.ServerProxy;
import by.fxg.diverse.common.block.BlockRegistry;
import by.fxg.diverse.common.storage.ModelItemCreation;
import by.fxg.diverse.common.storage.ModelTileCreation;
import by.fxg.diverse.common.tile.TileParticleGetter;
import by.fxg.diverse.common.tile.TilePortal;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends ServerProxy {
	public static ArrayList<ModelTileCreation> blockmodels = new ArrayList<ModelTileCreation>();
	public static ArrayList<ModelTileCreation> customblockmodels = new ArrayList<ModelTileCreation>();
	public static ArrayList<ModelItemCreation> itemmodels = new ArrayList<ModelItemCreation>();
	public static ArrayList<Integer> itemSpecial2D = new ArrayList<Integer>();
	
	private int id = -1;
	public void init() {
		for (ModelTileCreation mc : this.blockmodels) {
			ClientRegistry.bindTileEntitySpecialRenderer(mc.tile, new VRenderBase(mc.model, mc.texture));
			MinecraftForgeClient.registerItemRenderer(mc.itemID, new VRenderBase(mc.model, mc.texture));
		}
		for (ModelTileCreation mc : this.customblockmodels) {
			ClientRegistry.bindTileEntitySpecialRenderer(mc.tile, new VRenderCustom(mc.model, mc.texture, mc.id));
			MinecraftForgeClient.registerItemRenderer(mc.itemID, new VRenderBase(mc.model, mc.texture));
		}
		for (ModelItemCreation mc : this.itemmodels) {
			MinecraftForgeClient.registerItemRenderer(mc.itemID, new VRenderItems(mc.model, mc.texture, getNext()));
		}
		for (Integer id : this.itemSpecial2D) {
			MinecraftForgeClient.registerItemRenderer(id, new VRender2DSpecial());
		}
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileParticleGetter.class, new VRenderCustom(new VModelParticleGetter(), "particlegetter", 2));
		MinecraftForgeClient.registerItemRenderer(BlockRegistry.blockParticleGetter.blockID, new VRenderBase(new VModelParticleGetter(), "particlegetter", 0.5F));
		ClientRegistry.bindTileEntitySpecialRenderer(TilePortal.class, new VRenderCustom(new VModelPortal(), "portal", 3));
		MinecraftForgeClient.registerItemRenderer(BlockRegistry.blockPortal.blockID, new VRenderBase(new VModelPortal(), "portal", 1.0F));
		
		//RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new VRenderPlayer());
	}
	
	private int getNext() {
		this.id++;
		return this.id;
	}
	
	public void openCustomGui(int var1, EntityPlayer var2) {
		var2.openGui(Viod.instance, var1, var2.worldObj, (int) var2.posX, (int) var2.posY, (int) var2.posZ);
	}
	
	public void openExtGui(int var1, EntityPlayer var2) {
		
	}
}
