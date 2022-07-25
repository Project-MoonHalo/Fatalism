package MoonHalo.Fatalism.Config;

public class Setting<T> {
    public T value;
    public T defaultValue;
    public String information;

    public Setting(T DefaultValue, String Information) {
        this.value = DefaultValue;
        this.defaultValue = DefaultValue;
        this.information = Information;
    }

    public T getValue() {
        return this.value;
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public void Reset() {
        this.value = this.defaultValue;
    }

    public String getInformation() {
        return this.information;
    }

    public void setValue(T vl) {
        this.value = vl;
    }
}
