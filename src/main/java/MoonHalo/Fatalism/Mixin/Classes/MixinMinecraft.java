package MoonHalo.Fatalism.Mixin.Classes;

import MoonHalo.Fatalism.Config.ConfigManager;
import MoonHalo.FlameApi.Event.Classes.initEvent;
import MoonHalo.FlameApi.FlameCore;
import MoonHalo.Fatalism.Fatalism;
import net.minecraft.client.Minecraft;
import org.lwjgl.LWJGLException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


import java.io.IOException;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "init",at = @At(value = "INVOKE",target = "Lnet/minecraft/client/Minecraft;checkGLError(Ljava/lang/String;)V",ordinal = 0))
    private void init(CallbackInfo ci) throws LWJGLException, IOException {
        ConfigManager.getInstance().loadModule();
        Fatalism.logger.info("--------Fatalism MIXIN LOADED-----------");
        FlameCore.load();
        FlameCore.init();
        FlameCore.eventBus.submit(new initEvent());
    }
    @Inject(method={"shutdown"}, at={@At(value="HEAD")})
    private void Shutdown(CallbackInfo ci) {
        Fatalism.logger.info("GAME SHUTDOWN.CONFIG WILL BE SAVED.");
        ConfigManager.getInstance().Save();
    }
}
