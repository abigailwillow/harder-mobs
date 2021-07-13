package com.abbydiode.hardermobs.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.abbydiode.hardermobs.App;

public class EntityShootBowListener implements Listener {
	private App plugin;
	
	public EntityShootBowListener(App plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onEntityShootBow(EntityShootBowEvent e) {
		Entity entity = e.getEntity();
		if (entity.getType() == EntityType.SKELETON && Math.random() < plugin.getConfig().getDouble("poisonArrowChance")) {
			Skeleton skeleton = (Skeleton) entity;
			Entity projectile = e.getProjectile();
			Vector velocity = projectile.getVelocity();
			Arrow arrow = entity.getWorld().spawn(skeleton.getEyeLocation(), Arrow.class);
			arrow.addCustomEffect(new PotionEffect(PotionEffectType.POISON, plugin.getConfig().getInt("poisonArrowDuration"), 0), true);
			e.setProjectile(arrow);
			e.getProjectile().setVelocity(velocity);
		}
	}
}
