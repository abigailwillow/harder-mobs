package com.abbydiode.hardermobs.listeners;

import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import de.tr7zw.NBTEntity;

import com.abbydiode.hardermobs.App;

public class CreatureSpawnListener implements Listener {
	private App plugin;
	
	public CreatureSpawnListener(App plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		Entity entity = e.getEntity();
		if (entity.getType() == EntityType.CREEPER && Math.random() < plugin.getConfig().getDouble("chargedCreeperChance")) {
			((Creeper) entity).setPowered(true);
		}
		
		if (entity.getType() == EntityType.ZOMBIE) {
			NBTEntity nbtEntity = new NBTEntity(entity);
			nbtEntity.setBoolean("CanBreakDoors", true);
			plugin.getLogger().info(nbtEntity);
		}
	}
}
