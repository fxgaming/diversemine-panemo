package by.fxg.diverse.util;

import net.minecraft.world.EnumGameType;

public final class FakeWorldFactory {
   private static final FakeWorld instance;

   public static FakeWorld getDefault() {
      return instance;
   }

   static {
      instance = new FakeWorld(EnumGameType.SURVIVAL);
   }
}
