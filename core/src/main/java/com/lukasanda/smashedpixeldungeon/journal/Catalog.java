/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015  Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2017 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.lukasanda.smashedpixeldungeon.journal;

import com.lukasanda.smashedpixeldungeon.Badges;
import com.lukasanda.smashedpixeldungeon.items.Item;
import com.lukasanda.smashedpixeldungeon.items.armor.ClothArmor;
import com.lukasanda.smashedpixeldungeon.items.armor.HuntressArmor;
import com.lukasanda.smashedpixeldungeon.items.armor.LeatherArmor;
import com.lukasanda.smashedpixeldungeon.items.armor.MageArmor;
import com.lukasanda.smashedpixeldungeon.items.armor.MailArmor;
import com.lukasanda.smashedpixeldungeon.items.armor.PlateArmor;
import com.lukasanda.smashedpixeldungeon.items.armor.RogueArmor;
import com.lukasanda.smashedpixeldungeon.items.armor.ScaleArmor;
import com.lukasanda.smashedpixeldungeon.items.armor.WarriorArmor;
import com.lukasanda.smashedpixeldungeon.items.artifacts.CapeOfThorns;
import com.lukasanda.smashedpixeldungeon.items.artifacts.ChaliceOfBlood;
import com.lukasanda.smashedpixeldungeon.items.artifacts.CloakOfShadows;
import com.lukasanda.smashedpixeldungeon.items.artifacts.DriedRose;
import com.lukasanda.smashedpixeldungeon.items.artifacts.EtherealChains;
import com.lukasanda.smashedpixeldungeon.items.artifacts.HornOfPlenty;
import com.lukasanda.smashedpixeldungeon.items.artifacts.LloydsBeacon;
import com.lukasanda.smashedpixeldungeon.items.artifacts.MasterThievesArmband;
import com.lukasanda.smashedpixeldungeon.items.artifacts.SandalsOfNature;
import com.lukasanda.smashedpixeldungeon.items.artifacts.TalismanOfForesight;
import com.lukasanda.smashedpixeldungeon.items.artifacts.TimekeepersHourglass;
import com.lukasanda.smashedpixeldungeon.items.artifacts.UnstableSpellbook;
import com.lukasanda.smashedpixeldungeon.items.potions.PotionOfExperience;
import com.lukasanda.smashedpixeldungeon.items.potions.PotionOfFrost;
import com.lukasanda.smashedpixeldungeon.items.potions.PotionOfHealing;
import com.lukasanda.smashedpixeldungeon.items.potions.PotionOfInvisibility;
import com.lukasanda.smashedpixeldungeon.items.potions.PotionOfLevitation;
import com.lukasanda.smashedpixeldungeon.items.potions.PotionOfLiquidFlame;
import com.lukasanda.smashedpixeldungeon.items.potions.PotionOfMight;
import com.lukasanda.smashedpixeldungeon.items.potions.PotionOfMindVision;
import com.lukasanda.smashedpixeldungeon.items.potions.PotionOfParalyticGas;
import com.lukasanda.smashedpixeldungeon.items.potions.PotionOfPurity;
import com.lukasanda.smashedpixeldungeon.items.potions.PotionOfStrength;
import com.lukasanda.smashedpixeldungeon.items.potions.PotionOfToxicGas;
import com.lukasanda.smashedpixeldungeon.items.rings.RingOfAccuracy;
import com.lukasanda.smashedpixeldungeon.items.rings.RingOfElements;
import com.lukasanda.smashedpixeldungeon.items.rings.RingOfEnergy;
import com.lukasanda.smashedpixeldungeon.items.rings.RingOfEvasion;
import com.lukasanda.smashedpixeldungeon.items.rings.RingOfForce;
import com.lukasanda.smashedpixeldungeon.items.rings.RingOfFuror;
import com.lukasanda.smashedpixeldungeon.items.rings.RingOfHaste;
import com.lukasanda.smashedpixeldungeon.items.rings.RingOfMight;
import com.lukasanda.smashedpixeldungeon.items.rings.RingOfSharpshooting;
import com.lukasanda.smashedpixeldungeon.items.rings.RingOfTenacity;
import com.lukasanda.smashedpixeldungeon.items.rings.RingOfWealth;
import com.lukasanda.smashedpixeldungeon.items.scrolls.ScrollOfIdentify;
import com.lukasanda.smashedpixeldungeon.items.scrolls.ScrollOfLullaby;
import com.lukasanda.smashedpixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.lukasanda.smashedpixeldungeon.items.scrolls.ScrollOfMagicalInfusion;
import com.lukasanda.smashedpixeldungeon.items.scrolls.ScrollOfMirrorImage;
import com.lukasanda.smashedpixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.lukasanda.smashedpixeldungeon.items.scrolls.ScrollOfRage;
import com.lukasanda.smashedpixeldungeon.items.scrolls.ScrollOfRecharging;
import com.lukasanda.smashedpixeldungeon.items.scrolls.ScrollOfRemoveCurse;
import com.lukasanda.smashedpixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.lukasanda.smashedpixeldungeon.items.scrolls.ScrollOfTerror;
import com.lukasanda.smashedpixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfBlastWave;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfCorruption;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfDisintegration;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfFireblast;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfFrost;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfLightning;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfMagicMissile;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfPrismaticLight;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfRegrowth;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfTransfusion;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfCorrosion;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.AssassinsBlade;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.BattleAxe;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Dagger;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Dirk;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Flail;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Glaive;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Greataxe;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Greatshield;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Greatsword;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.HandAxe;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Knuckles;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Longsword;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Mace;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.MagesStaff;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Quarterstaff;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.RoundShield;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.RunicBlade;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Sai;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Scimitar;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Shortsword;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Spear;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Sword;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.WarHammer;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Whip;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.WornShortsword;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.Boomerang;
import com.watabou.utils.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

public enum Catalog {
	
	WEAPONS,
	ARMOR,
	WANDS,
	RINGS,
	ARTIFACTS,
	POTIONS,
	SCROLLS;
	
	private LinkedHashMap<Class<? extends Item>, Boolean> seen = new LinkedHashMap<>();
	
	public Collection<Class<? extends Item>> items(){
		return seen.keySet();
	}
	
	public boolean allSeen(){
		for (Class<?extends Item> item : items()){
			if (!seen.get(item)){
				return false;
			}
		}
		return true;
	}
	
	static {
		WEAPONS.seen.put( WornShortsword.class,             false);
		WEAPONS.seen.put( Knuckles.class,                   false);
		WEAPONS.seen.put( Dagger.class,                     false);
		WEAPONS.seen.put( MagesStaff.class,                 false);
		WEAPONS.seen.put( Boomerang.class,                  false);
		WEAPONS.seen.put( Shortsword.class,                 false);
		WEAPONS.seen.put( HandAxe.class,                    false);
		WEAPONS.seen.put( Spear.class,                      false);
		WEAPONS.seen.put( Quarterstaff.class,               false);
		WEAPONS.seen.put( Dirk.class,                       false);
		WEAPONS.seen.put( Sword.class,                      false);
		WEAPONS.seen.put( Mace.class,                       false);
		WEAPONS.seen.put( Scimitar.class,                   false);
		WEAPONS.seen.put( RoundShield.class,                false);
		WEAPONS.seen.put( Sai.class,                        false);
		WEAPONS.seen.put( Whip.class,                       false);
		WEAPONS.seen.put( Longsword.class,                  false);
		WEAPONS.seen.put( BattleAxe.class,                  false);
		WEAPONS.seen.put( Flail.class,                      false);
		WEAPONS.seen.put( RunicBlade.class,                 false);
		WEAPONS.seen.put( AssassinsBlade.class,             false);
		WEAPONS.seen.put( Greatsword.class,                 false);
		WEAPONS.seen.put( WarHammer.class,                  false);
		WEAPONS.seen.put( Glaive.class,                     false);
		WEAPONS.seen.put( Greataxe.class,                   false);
		WEAPONS.seen.put( Greatshield.class,                false);
	
		ARMOR.seen.put( ClothArmor.class,                   false);
		ARMOR.seen.put( LeatherArmor.class,                 false);
		ARMOR.seen.put( MailArmor.class,                    false);
		ARMOR.seen.put( ScaleArmor.class,                   false);
		ARMOR.seen.put( PlateArmor.class,                   false);
		ARMOR.seen.put( WarriorArmor.class,                 false);
		ARMOR.seen.put( MageArmor.class,                    false);
		ARMOR.seen.put( RogueArmor.class,                   false);
		ARMOR.seen.put( HuntressArmor.class,                false);
	
		WANDS.seen.put( WandOfMagicMissile.class,           false);
		WANDS.seen.put( WandOfLightning.class,              false);
		WANDS.seen.put( WandOfDisintegration.class,         false);
		WANDS.seen.put( WandOfFireblast.class,              false);
		WANDS.seen.put( WandOfCorrosion.class,              false);
		WANDS.seen.put( WandOfBlastWave.class,              false);
		//WANDS.seen.put( WandOfLivingEarth.class,          false);
		WANDS.seen.put( WandOfFrost.class,                  false);
		WANDS.seen.put( WandOfPrismaticLight.class,         false);
		//WANDS.seen.put( WandOfWarding.class,              false);
		WANDS.seen.put( WandOfTransfusion.class,            false);
		WANDS.seen.put( WandOfCorruption.class,             false);
		WANDS.seen.put( WandOfRegrowth.class,               false);
	
		RINGS.seen.put( RingOfAccuracy.class,               false);
		RINGS.seen.put( RingOfEnergy.class,                 false);
		RINGS.seen.put( RingOfElements.class,               false);
		RINGS.seen.put( RingOfEvasion.class,                false);
		RINGS.seen.put( RingOfForce.class,                  false);
		RINGS.seen.put( RingOfFuror.class,                  false);
		RINGS.seen.put( RingOfHaste.class,                  false);
		RINGS.seen.put( RingOfMight.class,                  false);
		RINGS.seen.put( RingOfSharpshooting.class,          false);
		RINGS.seen.put( RingOfTenacity.class,               false);
		RINGS.seen.put( RingOfWealth.class,                 false);
	
		//ARTIFACTS.seen.put( AlchemistsToolkit.class,      false);
		ARTIFACTS.seen.put( CapeOfThorns.class,             false);
		ARTIFACTS.seen.put( ChaliceOfBlood.class,           false);
		ARTIFACTS.seen.put( CloakOfShadows.class,           false);
		ARTIFACTS.seen.put( DriedRose.class,                false);
		ARTIFACTS.seen.put( EtherealChains.class,           false);
		ARTIFACTS.seen.put( HornOfPlenty.class,             false);
		ARTIFACTS.seen.put( LloydsBeacon.class,             false);
		ARTIFACTS.seen.put( MasterThievesArmband.class,     false);
		ARTIFACTS.seen.put( SandalsOfNature.class,          false);
		ARTIFACTS.seen.put( TalismanOfForesight.class,      false);
		ARTIFACTS.seen.put( TimekeepersHourglass.class,     false);
		ARTIFACTS.seen.put( UnstableSpellbook.class,        false);
	
		POTIONS.seen.put( PotionOfHealing.class,            false);
		POTIONS.seen.put( PotionOfStrength.class,           false);
		POTIONS.seen.put( PotionOfLiquidFlame.class,        false);
		POTIONS.seen.put( PotionOfFrost.class,              false);
		POTIONS.seen.put( PotionOfToxicGas.class,           false);
		POTIONS.seen.put( PotionOfParalyticGas.class,       false);
		POTIONS.seen.put( PotionOfPurity.class,             false);
		POTIONS.seen.put( PotionOfLevitation.class,         false);
		POTIONS.seen.put( PotionOfMindVision.class,         false);
		POTIONS.seen.put( PotionOfInvisibility.class,       false);
		POTIONS.seen.put( PotionOfExperience.class,         false);
		POTIONS.seen.put( PotionOfMight.class,              false);
	
		SCROLLS.seen.put( ScrollOfIdentify.class,           false);
		SCROLLS.seen.put( ScrollOfUpgrade.class,            false);
		SCROLLS.seen.put( ScrollOfRemoveCurse.class,        false);
		SCROLLS.seen.put( ScrollOfMagicMapping.class,       false);
		SCROLLS.seen.put( ScrollOfTeleportation.class,      false);
		SCROLLS.seen.put( ScrollOfRecharging.class,         false);
		SCROLLS.seen.put( ScrollOfMirrorImage.class,        false);
		SCROLLS.seen.put( ScrollOfTerror.class,             false);
		SCROLLS.seen.put( ScrollOfLullaby.class,            false);
		SCROLLS.seen.put( ScrollOfRage.class,               false);
		SCROLLS.seen.put( ScrollOfPsionicBlast.class,       false);
		SCROLLS.seen.put( ScrollOfMagicalInfusion.class,    false);
	}
	
	public static LinkedHashMap<Catalog, Badges.Badge> catalogBadges = new LinkedHashMap<>();
	static {
		catalogBadges.put(WEAPONS, Badges.Badge.ALL_WEAPONS_IDENTIFIED);
		catalogBadges.put(ARMOR, Badges.Badge.ALL_ARMOR_IDENTIFIED);
		catalogBadges.put(WANDS, Badges.Badge.ALL_WANDS_IDENTIFIED);
		catalogBadges.put(RINGS, Badges.Badge.ALL_RINGS_IDENTIFIED);
		catalogBadges.put(ARTIFACTS, Badges.Badge.ALL_ARTIFACTS_IDENTIFIED);
		catalogBadges.put(POTIONS, Badges.Badge.ALL_POTIONS_IDENTIFIED);
		catalogBadges.put(SCROLLS, Badges.Badge.ALL_SCROLLS_IDENTIFIED);
	}
	
	public static boolean isSeen(Class<? extends Item> itemClass){
		for (Catalog cat : values()) {
			if (cat.seen.containsKey(itemClass)) {
				return cat.seen.get(itemClass);
			}
		}
		return false;
	}
	
	public static void setSeen(Class<? extends Item> itemClass){
		for (Catalog cat : values()) {
			if (cat.seen.containsKey(itemClass) && !cat.seen.get(itemClass)) {
				cat.seen.put(itemClass, true);
				Journal.saveNeeded = true;
			}
		}
		Badges.validateItemsIdentified();
	}
	
	private static final String CATALOGS = "catalogs";
	
	public static void store( Bundle bundle ){
		
		Badges.loadGlobal();
		
		ArrayList<String> seen = new ArrayList<>();
		
		//if we have identified all items of a set, we use the badge to keep track instead.
		if (!Badges.isUnlocked(Badges.Badge.ALL_ITEMS_IDENTIFIED)) {
			for (Catalog cat : values()) {
				if (!Badges.isUnlocked(catalogBadges.get(cat))) {
					for (Class<? extends Item> item : cat.items()) {
						if (cat.seen.get(item)) seen.add(item.getSimpleName());
					}
				}
			}
		}
		
		bundle.put( CATALOGS, seen.toArray(new String[0]) );
		
	}
	
	public static void restore( Bundle bundle ){
		
		Badges.loadGlobal();
		
		//logic for if we have all badges
		if (Badges.isUnlocked(Badges.Badge.ALL_ITEMS_IDENTIFIED)){
			for ( Catalog cat : values()){
				for (Class<? extends Item> item : cat.items()){
					cat.seen.put(item, true);
				}
			}
			return;
		}
		
		//catalog-specific badge logic
		for (Catalog cat : values()){
			if (Badges.isUnlocked(catalogBadges.get(cat))){
				for (Class<? extends Item> item : cat.items()){
					cat.seen.put(item, true);
				}
			}
		}
		
		//general save/load
		if (bundle.contains(CATALOGS)) {
			List<String> seen = Arrays.asList(bundle.getStringArray(CATALOGS));
			
			//pre-0.6.3 saves
			//TODO should adjust this to tie into the bundling system's class array
			if (seen.contains("WandOfVenom")){
				WANDS.seen.put(WandOfCorrosion.class, true);
			}
			
			for (Catalog cat : values()) {
				for (Class<? extends Item> item : cat.items()) {
					if (seen.contains(item.getSimpleName())) {
						cat.seen.put(item, true);
					}
				}
			}
		}
	}
	
}
