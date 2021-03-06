package MoonHalo.FlameApi;

public class FlameMod {
    public FlameMod ModInstance;
    public void Modinit(){}
    public FlameMod(){
        this.ModInstance = this;
    }
    public String getModInfo() {
        if (this.getClass().isAnnotationPresent(Mod.class)) {
            return this.getClass().getAnnotation(Mod.class).information();
        }
        throw new IllegalStateException("No Information on class " + this.getClass().getCanonicalName() + "!");
    }
    public String getModName() {
        if (this.getClass().isAnnotationPresent(Mod.class)) {
            return this.getClass().getAnnotation(Mod.class).name();
        }
        throw new IllegalStateException("No name on class " + this.getClass().getCanonicalName() + "!");
    }
}
