package net.misemise.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class DeepSlateMiningSpeedMixin {

    @Inject(method = "getBlockBreakingSpeed", at = @At("RETURN"), cancellable = true)
    private void modifyDeepSlateMiningSpeed(BlockState block, CallbackInfoReturnable<Float> cir) {
        // 深層岩系ブロックかどうかを判定
        if (isDeepSlateBlock(block)) {
            // 元の採掘速度を取得
            float originalSpeed = cir.getReturnValue();

            // 深層岩は硬度が3.0f、石は0.6f
            // 採掘速度を石と同じにするには、5倍速くする必要がある（3.0 / 0.6 = 5.0）
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