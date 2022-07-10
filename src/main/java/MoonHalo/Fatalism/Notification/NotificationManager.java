package MoonHalo.Fatalism.Notification;

import MoonHalo.Fatalism.Fatalism;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class NotificationManager {
    public static void PrintMessage(String message){
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString("["+ Fatalism.Name +"]"+message));
    }
}
