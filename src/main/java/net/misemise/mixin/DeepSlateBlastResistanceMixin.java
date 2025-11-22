package net.misemise.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class DeepSlateBlastResistanceMixin {

    @Inject(method = "getBlastResistance", at = @At("HEAD"), cancellable = true)
    private void restoreDeepSlateBlastResistance(CallbackInfoReturnable<Float> cir) {
        Block block = (Block) (Object) this;

        // 深層岩系ブロックの爆破耐久値を元に戻す
        if (isDeepSlateBlock(block)) {
            // 各ブロックの爆破耐久値を設定
            float resistance = getBlastResistanceValue(block);
            cir.setReturnValue(resistance);
        }
    }

    @Unique
    private static float getBlastResistanceValue(Block block) {
        // 各深層岩ブロックの爆破耐久値を定義
        if (block == Blocks.DEEPSLATE) return 6.0f;
        if (block == Blocks.DEEPSLATE_BRICKS) return 6.0f;
        if (block == Blocks.DEEPSLATE_TILES) return 6.0f;
        if (block == Blocks.CHISELED_DEEPSLATE) return 6.0f;
        if (block == Blocks.POLISHED_DEEPSLATE) return 6.0f;
        if (block == Blocks.DEEPSLATE_COAL_ORE) return 6.0f;
        if (block == Blocks.DEEPSLATE_COPPER_ORE) return 6.0f;
        if (block == Blocks.DEEPSLATE_DIAMOND_ORE) return 6.0f;
        if (block == Blocks.DEEPSLATE_EMERALD_ORE) return 6.0f;
        if (block == Blocks.DEEPSLATE_GOLD_ORE) return 6.0f;
        if (block == Blocks.DEEPSLATE_IRON_ORE) return 6.0f;
        if (block == Blocks.DEEPSLATE_LAPIS_ORE) return 6.0f;
        if (block == Blocks.DEEPSLATE_REDSTONE_ORE) return 6.0f;
        return 0.0f;
    }

    @Unique
    private static boolean isDeepSlateBlock(Block block) {
        return block == Blocks.DEEPSLATE ||
                block == Blocks.DEEPSLATE_BRICKS ||
                block == Blocks.DEEPSLATE_TILES ||
                block == Blocks.CHISELED_DEEPSLATE ||
                block == Blocks.POLISHED_DEEPSLATE ||
                block == Blocks.DEEPSLATE_COAL_ORE ||
                block == Blocks.DEEPSLATE_COPPER_ORE ||
                block == Blocks.DEEPSLATE_DIAMOND_ORE ||
                block == Blocks.DEEPSLATE_EMERALD_ORE ||
                block == Blocks.DEEPSLATE_GOLD_ORE ||
                block == Blocks.DEEPSLATE_IRON_ORE ||
                block == Blocks.DEEPSLATE_LAPIS_ORE ||
                block == Blocks.DEEPSLATE_REDSTONE_ORE;
    }
}