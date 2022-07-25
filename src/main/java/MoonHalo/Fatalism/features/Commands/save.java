// Decompiled with: CFR 0.152
// Class Version: 8
package MoonHalo.Fatalism.features.Commands;

import MoonHalo.Fatalism.Config.ConfigManager;
import MoonHalo.Fatalism.features.Category;
import MoonHalo.Fatalism.features.Feature;

public class save extends Feature {
    public save() {
        super("save", Category.COMMAND, "save config");
    }

    @Override
    protected void onCall(String[] arg) {
        ConfigManager.getInstance().Save();
    }
}
