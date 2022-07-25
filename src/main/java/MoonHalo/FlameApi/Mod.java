package MoonHalo.FlameApi;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Mod {
    String name();
    String version();
    String information();
    int priority() default 0;
    String supportVersion() default "1.12.2";
}
