// Decompiled with: CFR 0.152
// Class Version: 8
package MoonHalo.Fatalism.features.Commands;

import MoonHalo.Fatalism.Config.ConfigManager;
import MoonHalo.Fatalism.features.Category;
import MoonHalo.Fatalism.features.Feature;

public class reload
        extends Feature {
    public reload() {
        super("reload", Category.COMMAND, "Reload config");
    }

    @Override
    protected void onCall(String[] arg) {
        ConfigManager.getInstance().loadModule();
    }
}
