package com.reeszrbteam.ce.console.commands;

import org.lwjgl.input.Keyboard;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.mods.Mod;
import com.kodehawa.mods.ModManager;

import com.reeszrbteam.ce.console.BaseCommand;

public class CommandBind extends BaseCommand{

	public CommandBind() {
		super("bind", "ReesZRB, Kodehawa", "1.6.2");
	}

	@Override
	public void runCommand(String s, String[] args) {
		try {
			if(args[0].equalsIgnoreCase("add")) {
				for(Mod m: ModManager.getInstance().mods) {
					if(m.name.replace(" ", "").equalsIgnoreCase(args[1])) {
						if(Keyboard.getKeyIndex(args[2].toUpperCase()) == 0) {
							CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Invalid key.");
							return;
						}
						m.setKeybind(Keyboard.getKeyIndex(args[2].toUpperCase()));
						CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage(m.name + " bound to: " + Keyboard.getKeyName(m.getKeybind()));
						break;
					}
				}
			}
			if(args[0].equalsIgnoreCase("del")) {
				for(Mod m: ModManager.getInstance().mods) {
					if(m.getKeybind() == Keyboard.getKeyIndex(args[1].toUpperCase())) {
						m.setKeybind(0);
						CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Unbound: " + args[1].toUpperCase());
						break;
					}
				}
			}
			if(args[0].equalsIgnoreCase("clearall")) {
				for(Mod m: ModManager.getInstance().mods) {
					m.setKeybind(0);
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("All Keys Unbound.");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Usage: " + getSyntax());
		}
	}

	@Override
	public String getDescription() {
		return "Binds a key to a Module";
	}

	@Override
	public String getSyntax() {
		return "bind add <Module> <Key>, bind del <Key> and bind clearall";
	}

}
