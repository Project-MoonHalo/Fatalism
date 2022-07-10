package MoonHalo.Fatalism.features.Modules.Render;

import MoonHalo.Fatalism.Fatalism;
import MoonHalo.Fatalism.Render.FontManager;
import MoonHalo.Fatalism.features.Category;
import MoonHalo.Fatalism.features.Feature;

import java.awt.*;

public class Watermark extends Feature {

    public Watermark() {
        super("Watermark", Category.RENDER, "Display watermark.");
    }

    @Override
    public void on2dRender(){
        FontManager.getFontRenderer().drawString(Fatalism.Name,2,5,new Color(0xEA6236).getRGB());
    }
}
