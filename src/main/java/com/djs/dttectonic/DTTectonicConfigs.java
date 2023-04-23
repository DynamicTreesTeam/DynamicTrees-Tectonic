package com.djs.dttectonic;

import net.minecraftforge.common.ForgeConfigSpec;

public class DTTectonicConfigs {

	public static final ForgeConfigSpec GENERAL_SPEC;
	
	static {
	    ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
	    setupConfig(configBuilder);
	    GENERAL_SPEC = configBuilder.build();		
	}
	
	public static ForgeConfigSpec.ConfigValue<Boolean> TECTONIC_TREE_FEATURES_FIX;
	public static ForgeConfigSpec.ConfigValue<Boolean> TERRATONIC_SAND_FIX;

	private static void setupConfig(ForgeConfigSpec.Builder builder) { 

		builder.push("Dynamic Trees + Tectonic Compat Mod Config");

		TECTONIC_TREE_FEATURES_FIX = builder
                .comment("If \"true\", implements fixes for failed tree cancellation in tectonic biomes. \n" +
                		"Replaces tree features in biomes that tree cancellation has failed. \n" +
                		"Defaults to \"true\".")
                .define("tectonic_tree_features_fix_entry", true);
		
		TERRATONIC_SAND_FIX = builder
                .comment("If \"true\", implements fix for sandy tectonic biomes when used with terratonic. \n" +
                		"Implements changes above, but also adds force_sand feature from terratonic. \n" +
                		"Defaults to \"true\".")
                .define("terratonic_sand_fix_entry", true);

		builder.pop();
	}
}