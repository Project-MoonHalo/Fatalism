// Decompiled with: CFR 0.152
// Class Version: 8
package MoonHalo.Fatalism.Config.Settings;

import MoonHalo.Fatalism.Config.Setting;
import java.util.ArrayList;
import java.util.List;

public class ModeSetting extends Setting<String> {
    private int IndexCount = 0;
    public List<String> ModeList = new ArrayList<String>();

    public ModeSetting(String DefaultValue, String Information, List<String> modes) {
        super(DefaultValue, Information);
        modes.forEach(mode -> {
            if (!this.ModeList.contains(mode)) {
                this.ModeList.add((String)mode);
            }
        });
    }

    @Override
    public void setValue(String vl) {
        if (this.ModeList.contains(vl)) {
            this.value = vl;
        }
    }

    public String NextMode() {
        ++this.IndexCount;
        this.value = this.ModeList.get(this.IndexCount);
        return this.ModeList.get(this.IndexCount);
    }
}

