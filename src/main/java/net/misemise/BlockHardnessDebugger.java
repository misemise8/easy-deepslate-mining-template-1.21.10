package net.misemise;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockHardnessDebugger implements ModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("BlockHardnessDebugger");

    @Override
    public void onInitialize() {
        // ブロックの硬度を確認
        logBlockHardness("Stone", Blocks.STONE);
        logBlockHardness("Deepslate", Blocks.DEEPSLATE);
        logBlockHardness("Deepslate Coal Ore", Blocks.DEEPSLATE_COAL_ORE);
        logBlockHardness("Deepslate Iron Ore", Blocks.DEEPSLATE_IRON_ORE);
        logBlockHardness("Deepslate Diamond Ore", Blocks.DEEPSLATE_DIAMOND_ORE);
    }

    private void logBlockHardness(String name, Block block) {
        float hardness = block.defaultBlockState().getDestroySpeed(null,null);
        LOGGER.info("{}: Hardness = {}", name, hardness);
    }
}