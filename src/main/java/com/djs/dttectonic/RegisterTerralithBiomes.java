package com.djs.dttectonic;

import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterTerralithBiomes {

	public static final DeferredRegister<Biome> REGISTER = DeferredRegister.create(ForgeRegistries.BIOMES, "terralith");
	
	public static final RegistryObject<Biome> SKYLANDS_AUTUMN = REGISTER.register("skylands_autumn", () -> {
		return Biome.BiomeBuilder.from(OverworldBiomes.desert()).build();
	});
	public static final RegistryObject<Biome> SKYLANDS_WINTER = REGISTER.register("skylands_winter", () -> {
		return Biome.BiomeBuilder.from(OverworldBiomes.desert()).build();
	});
	public static final RegistryObject<Biome> SKYLANDS_SPRING = REGISTER.register("skylands_spring", () -> {
		return Biome.BiomeBuilder.from(OverworldBiomes.desert()).build();
	});
	public static final RegistryObject<Biome> SKYLANDS_SUMMER = REGISTER.register("skylands_summer", () -> {
		return Biome.BiomeBuilder.from(OverworldBiomes.desert()).build();
	});
	
//    @SubscribeEvent	
    public static void register(IEventBus bus) {
        REGISTER.register(bus);
    }

}
