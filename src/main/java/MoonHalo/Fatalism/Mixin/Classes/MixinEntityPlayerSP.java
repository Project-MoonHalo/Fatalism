package MoonHalo.Fatalism.Mixin.Classes;

import MoonHalo.Fatalism.Notification.NotificationManager;
import MoonHalo.Fatalism.features.FeatureManager;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP {


    @Inject(at = @At(value = "HEAD"), method = "sendChatMessage", cancellable = true)
    public void sendChatMessage(String message, CallbackInfo callbackInfo) {
        if(message.startsWith(".")) {
            String[] strings = message.split(" ");
            try {
                FeatureManager.getInstance().getFeatureByName(strings[0].replaceFirst(".","")).Call(strings);
            } catch (ClassNotFoundException e) {

            }catch (Throwable e){
                e.printStackTrace();
                NotificationManager.PrintMessage("Error!Please send log to Author!");
            }
            callbackInfo.cancel();
        }
    }
}

