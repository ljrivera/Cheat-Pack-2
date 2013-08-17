package com.kodehawa.module.classes;

import net.minecraft.src.EntityPlayer;

import org.lwjgl.input.Keyboard;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.annotations.ModuleLoader;
import com.kodehawa.module.enums.EnumGuiCategory;
import com.kodehawa.util.Tickable;

public class Step extends ModuleBase implements Tickable{

	public static float STEP_HEIGHT = 1.0F;
	
	@ModuleLoader(type = "Module")
	public Step( ) {
		super("Step", "More than a slab!", "1.6.2", Keyboard.KEY_NUMPAD1,
				EnumGuiCategory.WORLD, true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnableModule(){
		CheatingEssentials.getCheatingEssentials().addToTick(this);
	}
	
	@Override
	public void onDisableModule(){
		CheatingEssentials.getCheatingEssentials().removeFromCurrentTick(this);
		setStep(0.5F);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		setStep(STEP_HEIGHT);
	}
	
	public void setStep( float f ){
        EntityPlayer.getInstance().setStepHeight(f);
	}


}
