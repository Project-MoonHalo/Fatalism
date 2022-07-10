package MoonHalo.Fatalism.Gui.MainMenu;

import MoonHalo.Fatalism.Render.FontManager;
import MoonHalo.Fatalism.Utils.Render.Font.CFontRenderer;
import net.minecraft.client.gui.*;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

/**
 * @author fireanmeng
 * @deprecated So many bugs...I can't fix them.
 */
@Deprecated
public class FateMainMenu extends GuiScreen {
    //this gui have some bugs so me don't want to use that gui.
    @Override
    public void initGui() {
        int j = this.height / 4 + 48;
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, j + 72 + 12, 98, 20, I18n.format("menu.options")));
        this.buttonList.add(new GuiButton(4, this.width / 2 + 2, j + 72 + 12, 98, 20, I18n.format("menu.quit")));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, j, I18n.format("menu.singleplayer")));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 100, j + 24, I18n.format("menu.multiplayer")));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackground(0);
        mc.getTextureManager().bindTexture(new ResourceLocation("Fatalism/textures/wallpaper.jpg"));
        Gui.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, width, height, width, height);
        String text =  "Fatalism 0.0.1";
        CFontRenderer font = FontManager.getFontRenderer();
        font.drawString(text, width / 2 - font.getStringWidth(text) / 2, height / 2 - font.fontHeight / 2 - 50, 0xFFFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0) {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }

        if (button.id == 4) {
            this.mc.shutdown();
        }

        if (button.id == 1) {
            this.mc.displayGuiScreen(new GuiWorldSelection(this));
        }

        if (button.id == 2) {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }
    }
}
