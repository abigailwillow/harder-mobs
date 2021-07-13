package com.abbydiode.hardermobs;

import org.bukkit.plugin.java.JavaPlugin;

import com.abbydiode.hardermobs.listeners.CreatureSpawnListener;
import com.abbydiode.hardermobs.listeners.EntityDamageByEntityListener;
import com.abbydiode.hardermobs.listeners.EntityShootBowListener;

public class App extends JavaPlugin {
	@Override
	public void onEnable() {
		saveDefaultConfig();
		new CreatureSpawnListener(this);
		new EntityShootBowListener(this);
		new EntityDamageByEntityListener(this);
	}
}
