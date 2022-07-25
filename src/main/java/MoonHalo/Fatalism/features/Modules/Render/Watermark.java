// Decompiled with: CFR 0.152
// Class Version: 8
package MoonHalo.Fatalism.features.Modules.Render;

import MoonHalo.Fatalism.Config.Settings.IntSetting;
import MoonHalo.Fatalism.Config.Settings.StringSetting;
import MoonHalo.Fatalism.Fatalism;
import MoonHalo.Fatalism.Render.FontManager;
import MoonHalo.Fatalism.features.Category;
import MoonHalo.Fatalism.features.Feature;
import java.awt.Color;

public class Watermark
        extends Feature {
    public IntSetting posX = new IntSetting(0, 1024, 2, "Change List display position.(X)");
    public IntSetting posY = new IntSetting(0, 1024, 5, "Change List display position.(Y)");
    public StringSetting watermark = new StringSetting(Fatalism.Name, "Change display string.");

    public Watermark() {
        super("Watermark", Category.RENDER, "Display watermark.");
    }

    @Override
    public void on2dRender() {
        FontManager.getFontRenderer().drawString(this.watermark.getValue(), this.posX.getValue(), this.posY.getValue(), new Color(15360566).getRGB());
    }
}
