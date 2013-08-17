package com.kodehawa.module.classes;

import net.minecraft.src.RenderManager;

import org.lwjgl.input.Keyboard;

import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.enums.EnumGuiCategory;

public class UtilMobHitbox extends ModuleBase {

	public UtilMobHitbox( ) {
		super("Mob Hitbox", "", "1.6.2", Keyboard.KEY_NONE, EnumGuiCategory.UTILS, true);
	}

	@Override
	public void onEnableModule() {
		RenderManager.field_85095_o = !RenderManager.field_85095_o;
	}

	@Override
	public void onDisableModule() {
		RenderManager.field_85095_o = !RenderManager.field_85095_o;
	}
}
