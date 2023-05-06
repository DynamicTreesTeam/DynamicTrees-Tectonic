package com.djs.dttectonic;

import java.io.IOException;

import com.ferreusveritas.dynamictrees.api.GatherDataHelper;
import com.ferreusveritas.dynamictrees.api.registry.RegistryHandler;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.resource.PathResourcePack;

@Mod(DynamicTreesTectonic.MOD_ID)
public class DynamicTreesTectonic
{
    public static final String MOD_ID = "dttectonic";
    
    public DynamicTreesTectonic()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(Type.COMMON, DTTectonicConfigs.GENERAL_SPEC, "dttectonicconfig.toml");		

		modEventBus.addListener(this::gatherData);
		modEventBus.addListener(this::setupBuiltInDatapack);
        MinecraftForge.EVENT_BUS.register(this);
                
        RegistryHandler.setup(MOD_ID);

        RegisterTectonicBiomes.REGISTER.register(modEventBus);
    }
    
    private void gatherData(final GatherDataEvent event) {
        GatherDataHelper.gatherTagData(MOD_ID, event);
        GatherDataHelper.gatherLootData(MOD_ID, event);
    }


	private void setupBuiltInDatapack(AddPackFindersEvent event) {	

		String MODID = "dttectonic";
		
		if (event.getPackType() == PackType.SERVER_DATA) {
			if ((Boolean)DTTectonicConfigs.TECTONIC_TREE_FEATURES_FIX.get()) {
				var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("resourcepacks/tectonic_tree_features_fix");

	            try (var pack = new PathResourcePack(ModList.get().getModFileById(MODID).getFile().getFileName() + ":" + resourcePath, resourcePath)) {
					var metadataSection = pack.getMetadataSection(PackMetadataSection.SERIALIZER);
					if (metadataSection != null)
					{
					    event.addRepositorySource((packConsumer, packConstructor) ->
					            packConsumer.accept(packConstructor.create(
					            		"builtin/tectonic_tree_features_fix", new TextComponent("dttectonic fixes: tectonic_tree_features_fix"), true,
					                    () -> pack, metadataSection, Pack.Position.TOP, PackSource.BUILT_IN, false)));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if ((Boolean)DTTectonicConfigs.TERRATONIC_SAND_FIX.get()) {
				var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("resourcepacks/terratonic_sand_fix");

	            try (var pack = new PathResourcePack(ModList.get().getModFileById(MODID).getFile().getFileName() + ":" + resourcePath, resourcePath)) {
					var metadataSection = pack.getMetadataSection(PackMetadataSection.SERIALIZER);
					if (metadataSection != null)
					{
					    event.addRepositorySource((packConsumer, packConstructor) ->
					            packConsumer.accept(packConstructor.create(
					            		"builtin/terratonic_sand_fix", new TextComponent("dttectonic fixes: terratonic_sand_fix"), true,
					                    () -> pack, metadataSection, Pack.Position.TOP, PackSource.BUILT_IN, false)));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}		
		}    
	}	
}
