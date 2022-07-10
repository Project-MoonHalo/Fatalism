package MoonHalo.Fatalism.Mixin.Classes;

import MoonHalo.Fatalism.features.Feature;
import MoonHalo.Fatalism.features.FeatureManager;
import net.minecraft.client.gui.GuiSubtitleOverlay;
import net.minecraft.client.gui.ScaledResolution;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiSubtitleOverlay.class)
public class MixinGuiSubtitleOverlay {

    @Inject(method = "renderSubtitles", at = @At("HEAD"))
    public void onRender2D(ScaledResolution resolution, CallbackInfo ci) {
        for (Feature feature : FeatureManager.getInstance().featureList) {
            if(feature.enabled){
                feature.on2dRender();
            }
        }
    }

}
