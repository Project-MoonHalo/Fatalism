// Decompiled with: CFR 0.152
// Class Version: 8
package MoonHalo.Fatalism.features.Modules.Render;

import MoonHalo.Fatalism.Config.Settings.IntSetting;
import MoonHalo.Fatalism.Render.FontManager;
import MoonHalo.Fatalism.features.Category;
import MoonHalo.Fatalism.features.Feature;
import MoonHalo.Fatalism.features.FeatureManager;
import java.awt.Color;

public class EnableList
        extends Feature {
    public IntSetting posX = new IntSetting(0, 1024, 2, "Change List display position.(X)");
    public IntSetting posY = new IntSetting(0, 1024, 12, "Change List display position.(Y)");

    public EnableList() {
        super("EnableList", Category.RENDER, "Display enable features.");
    }

    @Override
    public void on2dRender() {
        int i = (Integer)this.posY.getValue();
        for (Feature feature : FeatureManager.getEnableFeatures()) {
            FontManager.getFontRenderer().drawString(feature.name,this.posX.getValue(), i, new Color(3599034).getRGB());
            i += 7;
        }
    }
}
