package by.fxg.diverse.common.world;

import java.util.Random;

import by.fxg.diverse.common.block.BlockRegistry;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OreGenerator implements IWorldGenerator {
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			this.generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1:
			this.generateEnd(world, random, chunkX * 16, chunkZ * 16);
		default:
		}
	}

	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		this.genOre(world, random, chunkX, chunkZ, BlockRegistry.oreYeselium.blockID, 3, 3, 30, 3);
		this.genOre(world, random, chunkX, chunkZ, BlockRegistry.oreKusistrium.blockID, 3, 3, 40, 4);
		this.genOre(world, random, chunkX, chunkZ, BlockRegistry.oreHusazium.blockID, 3, 3, 50, 5);
		this.genOre(world, random, chunkX, chunkZ, BlockRegistry.oreGelatrium.blockID, 4, 3, 60, 6);
		this.genOre(world, random, chunkX, chunkZ, BlockRegistry.oreVintarium.blockID, 4, 3, 70, 7);
	}

	private void genOre(World w, Random r, int x, int z, int id, int blocks, int yMin, int yMax, int count) {
		int rY = yMin + (int)(Math.random() * (double)(yMax - yMin + 1));
		for (int i = 0; i < r.nextInt(count); ++i) {
			int randPosX = x + r.nextInt(16);
			int randPosZ = z + r.nextInt(16);
			(new WorldGenMinable(id, blocks)).generate(w, r, randPosX, rY, randPosZ);
		}
	}

	private void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}
}
