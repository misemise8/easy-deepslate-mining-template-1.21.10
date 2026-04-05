package net.misemise.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class DeepSlateMiningSpeedMixin {

    @Inject(method = "getDestroySpeed", at = @At("RETURN"), cancellable = true)
    private void modifyDeepSlateMiningSpeed(BlockState block, CallbackInfoReturnable<Float> cir) {
        if (isDeepSlateBlock(block)) {
            float originalSpeed = cir.getReturnValue();
            float adjustedSpeed = originalSpeed * 2.0f;
            cir.setReturnValue(adjustedSpeed);
        }
    }

    @Unique
    private static boolean isDeepSlateBlock(BlockState state) {
        return state.getBlock() == Blocks.DEEPSLATE ||
                state.getBlock() == Blocks.DEEPSLATE_BRICKS ||
                state.getBlock() == Blocks.DEEPSLATE_TILES ||
                state.getBlock() == Blocks.CHISELED_DEEPSLATE ||
                state.getBlock() == Blocks.POLISHED_DEEPSLATE ||
                state.getBlock() == Blocks.DEEPSLATE_COAL_ORE ||
                state.getBlock() == Blocks.DEEPSLATE_COPPER_ORE ||
                state.getBlock() == Blocks.DEEPSLATE_DIAMOND_ORE ||
                state.getBlock() == Blocks.DEEPSLATE_EMERALD_ORE ||
                state.getBlock() == Blocks.DEEPSLATE_GOLD_ORE ||
                state.getBlock() == Blocks.DEEPSLATE_IRON_ORE ||
                state.getBlock() == Blocks.DEEPSLATE_LAPIS_ORE ||
                state.getBlock() == Blocks.DEEPSLATE_REDSTONE_ORE;
    }
}
