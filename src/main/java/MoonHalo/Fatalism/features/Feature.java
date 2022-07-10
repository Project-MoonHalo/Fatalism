package MoonHalo.Fatalism.features;

import MoonHalo.Fatalism.Fatalism;

import static MoonHalo.FlameApi.FlameCore.*;

public class Feature {
    public String name;
    public Category category;
    public String description;
    public boolean enabled = false;

    public Feature(String Name, Category category1, String description1) {
        name = Name;
        category = category1;
        description = description1;
    }

    protected void OnEnable() {

    }

    protected void OnDisable() {

    }

    protected void onCall(String[] arg) {

    }

    public void on2dRender() {

    }

    public final void Call(String[] arg) {
        if (category == Category.COMMAND) {
            onCall(arg);
        } else {
            Fatalism.logger.warn("Feature " + name + " is not a command!");
        }
    }

    public final void Toggle() {
        if (category != Category.COMMAND) {
            if (enabled) {
                enabled = false;
                eventBus.Unregister(this);
                OnDisable();
            } else {
                enabled = true;
                eventBus.Register(this);
                OnEnable();
            }
        }else{
            Fatalism.logger.warn("Feature " + name + " is not a module!");
        }
    }
}
