package com.kodehawa.module.classes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.RenderManager;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.enums.EnumGuiCategory;
import com.reeszrbteam.ce.util.CEUtils;
import org.lwjgl.input.Keyboard;

public class BlockESP extends ModuleBase{

	private int size = 0;

	public static List<Integer> espList = new ArrayList<Integer>();
	public static BlockCoord[] espBlocks = new BlockCoord[10000000];
	
	public BlockESP() {
		super("Block ESP", "Draws ESP on Blocks", "1.6.2", Keyboard.KEY_NUMPAD8, EnumGuiCategory.RENDER, true);
	}

	@Override
	public void onEnableModule() {}

	@Override
	public void onDisableModule() {}
	
	private int timer = 0;

	public void refresh() {
		size = 0;
		int radius = 72;
		for(int y = 0; y < 128; y++) {
			for(int x = 0; x < radius; x++) {
				for(int z = 0; z < radius; z++) {

					int cX = (int)CheatingEssentials.getMinecraftInstance().thePlayer.posX - (int)radius/2+x;
					int cY = y;
					int cZ = (int)CheatingEssentials.getMinecraftInstance().thePlayer.posZ - (int)radius/2+z;
					int ids = CheatingEssentials.getMinecraftInstance().theWorld.getBlockId(cX, cY, cZ);

					if (espList.contains(ids)) {
						espBlocks[size++] = new BlockCoord(cX, cY, cZ);
					}
				}
			}
		}
	}

	@Override
	public void onRenderInModule() {
		if(isActive()) {
            timer++;

			if(timer >= 60) {
				refresh();
				timer = 0;
			}

			for(int cur = 0; cur < size; cur++) {
				BlockCoord curBlock = espBlocks[cur];
				CEUtils.drawESP(curBlock.getDeltaX(), curBlock.getDeltaY(), curBlock.getDeltaZ(), 0.0F, 0.0F, 1.0F);
			}
		}
	}

    public class BlockCoord {
		private int x, y, z;

		public BlockCoord(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getZ() {
			return z;
		}

		public double getDeltaX() {
			return getX() - RenderManager.renderPosX;
		}

		public double getDeltaY() {
			return getY() - RenderManager.renderPosY;
		}

		public double getDeltaZ() {
			return getZ() - RenderManager.renderPosZ;
		}
	}

}
