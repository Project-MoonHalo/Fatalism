// Decompiled with: CFR 0.152
// Class Version: 8
package MoonHalo.Fatalism.Config.Settings;

import MoonHalo.Fatalism.Config.Setting;

public class IntSetting
        extends Setting<Integer> {
    public int Max;
    public int Minimal;

    public IntSetting(int minimal, int max, int defaultvalue, String Information) {
        super(defaultvalue, Information);
        this.Max = max;
        this.Minimal = minimal;
    }

    public int getMax() {
        return this.Max;
    }

    public int getMinimal() {
        return this.Minimal;
    }
}

