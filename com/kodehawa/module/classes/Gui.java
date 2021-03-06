package com.kodehawa.module.classes;

import com.kodehawa.gui.api.components.ModuleGui;
import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.enums.EnumGuiCategory;
import com.reeszrbteam.ce.gui.click.YouAlwaysWinClickGui;
import org.lwjgl.input.Keyboard;

public class Gui extends ModuleBase {

    public static int guimode = 0;
    public ModuleGui kodehawagui;
    public YouAlwaysWinClickGui reesgui;

    public Gui( ) {
        super("Gui", "", "1.6.2", Keyboard.KEY_G, EnumGuiCategory.NONE, true);
        kodehawagui = new ModuleGui();
        reesgui = new YouAlwaysWinClickGui();
    }

    public void onEnableModule() {
        switch(guimode){
            case 0: displayGuiScreen(kodehawagui); break;
            case 1: displayGuiScreen(reesgui); break;
        }
    }

    public void onDisableModule() {
        switch (guimode){
            case 0: displayGuiScreen(kodehawagui); break;
            case 1: displayGuiScreen(reesgui); break;
        }
    }

}
