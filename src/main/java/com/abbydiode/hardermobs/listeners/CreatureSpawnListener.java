package com.abbydiode.hardermobs.listeners;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftEntity;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.abbydiode.hardermobs.App;
import net.minecraft.server.v1_17_R1.EntityLiving;
import net.minecraft.server.v1_17_R1.NBTTagCompound;

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
			net.minecraft.server.v1_17_R1.Entity nmsEntity = ((CraftEntity) entity).getHandle();
			NBTTagCompound tag = new NBTTagCompound();
			nmsEntity.c(tag);
			tag.setBoolean("CanBreakDoors", true);
			EntityLiving el = (EntityLiving) nmsEntity;
			el.a(tag);
		}
	}
}
