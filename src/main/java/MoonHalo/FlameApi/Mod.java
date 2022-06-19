package MoonHalo.FlameApi;

public @interface Mod {
    String name();
    String information();
    int priority() default 0;
    String supportVersion() default "1.12.2";
}
