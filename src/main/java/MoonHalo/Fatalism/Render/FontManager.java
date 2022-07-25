package MoonHalo.Fatalism.Render;

import MoonHalo.Fatalism.Utils.Render.Font.CFont;
import MoonHalo.Fatalism.Utils.Render.Font.CFontRenderer;

import java.awt.*;

public class FontManager {
    public static CFontRenderer fontRenderer = new CFontRenderer(new CFont.CustomFont("/assets/minecraft/fonts/Comfortaa-Bold.ttf", 18f, Font.PLAIN), true, false);
    public static CFontRenderer getFontRenderer(){
        return fontRenderer;
    }
}
