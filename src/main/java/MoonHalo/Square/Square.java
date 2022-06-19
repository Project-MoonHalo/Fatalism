package MoonHalo.Square;

import MoonHalo.FlameApi.Mod;
import MoonHalo.FlameApi.FlameMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(name = "Square", information = "Square",priority = 1000)
public class Square extends FlameMod{
    public static Logger logger = LogManager.getLogger("Square");
    @Override
    public void Modinit(){
        Display.setTitle("Square");
    }
}
