package com.djs.dttectonic;

import com.ferreusveritas.dynamictrees.api.worldgen.GroundFinder;
import com.ferreusveritas.dynamictrees.util.CoordUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Harley O'Connor, modified by DJS
 */
public final class SkylandsGroundFinder implements GroundFinder {

    @Override
    public List<BlockPos> findGround(LevelAccessor level, BlockPos start) {
        return Collections.singletonList(CoordUtils.findWorldSurface(level, start, Heightmap.Types.OCEAN_FLOOR));
    }

    @SubscribeEvent
    public static void register() {
        ResourceKey<Level> dimension = Level.OVERWORLD;
        GroundFinder groundFinder = new SkylandsGroundFinder();
        GroundFinder.registerGroundFinder(dimension, groundFinder);
    }
    
}