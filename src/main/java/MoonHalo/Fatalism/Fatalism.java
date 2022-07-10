package MoonHalo.Fatalism;

import MoonHalo.FlameApi.Mod;
import MoonHalo.FlameApi.FlameMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(name = "Fatalism", information = "Fatalism",priority = 1000,version = "0.0.1")
public class Fatalism extends FlameMod{
    public static Logger logger = LogManager.getLogger("Fatalism");
    public static String Name = "Fatalism";
    @Override
    public void Modinit(){
        Display.setTitle("Fatalism");
    }
}
