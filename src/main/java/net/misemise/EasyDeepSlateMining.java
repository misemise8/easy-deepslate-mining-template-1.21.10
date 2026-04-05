package net.misemise;

import com.mojang.logging.LogUtils;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(EasyDeepSlateMining.MOD_ID)
public class EasyDeepSlateMining {
	public static final String MOD_ID = "easy_deepslate_mining";
	public static final Logger LOGGER = LogUtils.getLogger();

	public EasyDeepSlateMining() {
		LOGGER.info("Easy Deepslate Mining for NeoForge loaded.");
	}
}
