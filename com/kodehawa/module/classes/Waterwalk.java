package com.kodehawa.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.enums.EnumGuiCategory;
import com.kodehawa.util.Tickable;

public class Waterwalk extends ModuleBase implements Tickable {

	public Waterwalk( ) {
		super("Water Walk", "", "1.6.2", Keyboard.KEY_J, EnumGuiCategory.WORLD, true);
	}

	@Override
	public void tick() {
		if (getPlayer().isInWater())
        {
            getPlayer().setSprinting(false);
            getPlayer().jump();
            getPlayer().motionY /= 2;
        }
	}

	@Override
	public void onEnableModule() {
		CheatingEssentials.getCheatingEssentials().addToTick(this);
	}

	@Override
	public void onDisableModule() {
		CheatingEssentials.getCheatingEssentials().removeFromCurrentTick(this);
	}

}
