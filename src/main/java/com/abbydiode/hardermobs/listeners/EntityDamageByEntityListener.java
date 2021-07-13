package com.abbydiode.hardermobs.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.abbydiode.hardermobs.App;

public class EntityDamageByEntityListener implements Listener {
	private App plugin;
	
	public EntityDamageByEntityListener (App plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		if (e.getDamager().getType() == EntityType.SPIDER) {
			if (e.getEntityType().isAlive()) {
				((LivingEntity) e.getEntity()).addPotionEffect(
						new PotionEffect(PotionEffectType.SLOW, plugin.getConfig().getInt("spiderSlownessLength"), 1), true);
			}
		}
	}
}
