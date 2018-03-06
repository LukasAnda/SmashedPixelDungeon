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

package com.lukasanda.smashedpixeldungeon.items;

import com.lukasanda.smashedpixeldungeon.Dungeon;
import com.lukasanda.smashedpixeldungeon.SmashedPixelDungeon;
import com.lukasanda.smashedpixeldungeon.items.armor.Armor;
import com.lukasanda.smashedpixeldungeon.items.armor.ClothArmor;
import com.lukasanda.smashedpixeldungeon.items.armor.LeatherArmor;
import com.lukasanda.smashedpixeldungeon.items.armor.MailArmor;
import com.lukasanda.smashedpixeldungeon.items.armor.PlateArmor;
import com.lukasanda.smashedpixeldungeon.items.armor.ScaleArmor;
import com.lukasanda.smashedpixeldungeon.items.artifacts.AlchemistsToolkit;
import com.lukasanda.smashedpixeldungeon.items.artifacts.Artifact;
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
import com.lukasanda.smashedpixeldungeon.items.bags.Bag;
import com.lukasanda.smashedpixeldungeon.items.food.Food;
import com.lukasanda.smashedpixeldungeon.items.food.MysteryMeat;
import com.lukasanda.smashedpixeldungeon.items.food.Pasty;
import com.lukasanda.smashedpixeldungeon.items.potions.Potion;
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
import com.lukasanda.smashedpixeldungeon.items.rings.Ring;
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
import com.lukasanda.smashedpixeldungeon.items.scrolls.Scroll;
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
import com.lukasanda.smashedpixeldungeon.items.wands.Wand;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfBlastWave;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfCorrosion;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfCorruption;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfDisintegration;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfFireblast;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfFrost;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfLightning;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfMagicMissile;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfPrismaticLight;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfRegrowth;
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfTransfusion;
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
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.MeleeWeapon;
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
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.Bolas;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.FishingSpear;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.Javelin;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.MissileWeapon;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.Shuriken;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.ThrowingHammer;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.ThrowingKnife;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.Tomahawk;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.Trident;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.darts.Dart;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.darts.IncendiaryDart;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.darts.ParalyticDart;
import com.lukasanda.smashedpixeldungeon.plants.BlandfruitBush;
import com.lukasanda.smashedpixeldungeon.plants.Blindweed;
import com.lukasanda.smashedpixeldungeon.plants.Dreamfoil;
import com.lukasanda.smashedpixeldungeon.plants.Earthroot;
import com.lukasanda.smashedpixeldungeon.plants.Fadeleaf;
import com.lukasanda.smashedpixeldungeon.plants.Firebloom;
import com.lukasanda.smashedpixeldungeon.plants.Icecap;
import com.lukasanda.smashedpixeldungeon.plants.Plant;
import com.lukasanda.smashedpixeldungeon.plants.Rotberry;
import com.lukasanda.smashedpixeldungeon.plants.Sorrowmoss;
import com.lukasanda.smashedpixeldungeon.plants.Starflower;
import com.lukasanda.smashedpixeldungeon.plants.Stormvine;
import com.lukasanda.smashedpixeldungeon.plants.Sungrass;
import com.watabou.utils.Bundle;
import com.watabou.utils.GameMath;
import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Generator {

	public enum Category {
		WEAPON	( 6,    MeleeWeapon.class),
		WEP_T1	( 0,    MeleeWeapon.class),
		WEP_T2	( 0,    MeleeWeapon.class),
		WEP_T3	( 0,    MeleeWeapon.class),
		WEP_T4	( 0,    MeleeWeapon.class),
		WEP_T5	( 0,    MeleeWeapon.class),
		
		ARMOR	( 4,    Armor.class ),
		
		MISSILE ( 3,    MissileWeapon.class ),
		MIS_T1  ( 0,    MissileWeapon.class ),
		MIS_T2  ( 0,    MissileWeapon.class ),
		MIS_T3  ( 0,    MissileWeapon.class ),
		MIS_T4  ( 0,    MissileWeapon.class ),
		MIS_T5  ( 0,    MissileWeapon.class ),
		
		POTION	( 20,   Potion.class ),
		SCROLL	( 20,   Scroll.class ),
		
		WAND	( 3,    Wand.class ),
		RING	( 1,    Ring.class ),
		ARTIFACT( 1,    Artifact.class),
		
		SEED	( 0,    Plant.Seed.class ),
		
		FOOD	( 0,    Food.class ),
		
		GOLD	( 20,   Gold.class );
		
		public Class<?>[] classes;
		public float[] probs;
		
		public float prob;
		public Class<? extends Item> superClass;
		
		private Category( float prob, Class<? extends Item> superClass ) {
			this.prob = prob;
			this.superClass = superClass;
		}
		
		public static int order( Item item ) {
			for (int i=0; i < values().length; i++) {
				if (values()[i].superClass.isInstance( item )) {
					return i;
				}
			}
			
			return item instanceof Bag ? Integer.MAX_VALUE : Integer.MAX_VALUE - 1;
		}
		
		private static final float[] INITIAL_ARTIFACT_PROBS = new float[]{ 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1};
		
		static {
			GOLD.classes = new Class<?>[]{
					Gold.class };
			GOLD.probs = new float[]{ 1 };
			
			SCROLL.classes = new Class<?>[]{
					ScrollOfIdentify.class,
					ScrollOfTeleportation.class,
					ScrollOfRemoveCurse.class,
					ScrollOfUpgrade.class,
					ScrollOfRecharging.class,
					ScrollOfMagicMapping.class,
					ScrollOfRage.class,
					ScrollOfTerror.class,
					ScrollOfLullaby.class,
					ScrollOfMagicalInfusion.class,
					ScrollOfPsionicBlast.class,
					ScrollOfMirrorImage.class };
			SCROLL.probs = new float[]{ 30, 10, 20, 0, 15, 15, 12, 8, 8, 0, 4, 10 };
			
			POTION.classes = new Class<?>[]{
					PotionOfHealing.class,
					PotionOfExperience.class,
					PotionOfToxicGas.class,
					PotionOfParalyticGas.class,
					PotionOfLiquidFlame.class,
					PotionOfLevitation.class,
					PotionOfStrength.class,
					PotionOfMindVision.class,
					PotionOfPurity.class,
					PotionOfInvisibility.class,
					PotionOfMight.class,
					PotionOfFrost.class };
			POTION.probs = new float[]{ 45, 4, 15, 10, 15, 10, 0, 20, 12, 10, 0, 10 };
			
			//TODO: add last ones when implemented
			WAND.classes = new Class<?>[]{
					WandOfMagicMissile.class,
					WandOfLightning.class,
					WandOfDisintegration.class,
					WandOfFireblast.class,
					WandOfCorrosion.class,
					WandOfBlastWave.class,
					//WandOfLivingEarth.class,
					WandOfFrost.class,
					WandOfPrismaticLight.class,
					//WandOfWarding.class,
					WandOfTransfusion.class,
					WandOfCorruption.class,
					WandOfRegrowth.class };
			WAND.probs = new float[]{ 5, 4, 4, 4, 4, 3, /*3,*/ 3, 3, /*3,*/ 3, 3, 3 };
			
			//see generator.randomWeapon
			WEAPON.classes = new Class<?>[]{};
			WEAPON.probs = new float[]{};
			
			WEP_T1.classes = new Class<?>[]{
					WornShortsword.class,
					Knuckles.class,
					Dagger.class,
					MagesStaff.class
			};
			WEP_T1.probs = new float[]{ 1, 1, 1, 0 };
			
			WEP_T2.classes = new Class<?>[]{
					Shortsword.class,
					HandAxe.class,
					Spear.class,
					Quarterstaff.class,
					Dirk.class
			};
			WEP_T2.probs = new float[]{ 6, 5, 5, 4, 4 };
			
			WEP_T3.classes = new Class<?>[]{
					Sword.class,
					Mace.class,
					Scimitar.class,
					RoundShield.class,
					Sai.class,
					Whip.class
			};
			WEP_T3.probs = new float[]{ 6, 5, 5, 4, 4, 4 };
			
			WEP_T4.classes = new Class<?>[]{
					Longsword.class,
					BattleAxe.class,
					Flail.class,
					RunicBlade.class,
					AssassinsBlade.class
			};
			WEP_T4.probs = new float[]{ 6, 5, 5, 4, 4 };
			
			WEP_T5.classes = new Class<?>[]{
					Greatsword.class,
					WarHammer.class,
					Glaive.class,
					Greataxe.class,
					Greatshield.class
			};
			WEP_T5.probs = new float[]{ 6, 5, 5, 4, 4 };
			
			//see Generator.randomArmor
			ARMOR.classes = new Class<?>[]{
					ClothArmor.class,
					LeatherArmor.class,
					MailArmor.class,
					ScaleArmor.class,
					PlateArmor.class };
			ARMOR.probs = new float[]{ 0, 0, 0, 0, 0 };
			
			//see Generator.randomMissile
			MISSILE.classes = new Class<?>[]{};
			MISSILE.probs = new float[]{};
			
			MIS_T1.classes = new Class<?>[]{
					Dart.class,
					ThrowingKnife.class
			};
			MIS_T1.probs = new float[]{ 1, 1 };
			
			MIS_T2.classes = new Class<?>[]{
					Shuriken.class,
					IncendiaryDart.class,
					ParalyticDart.class,
			};
			MIS_T2.probs = new float[]{ 8, 3, 3 };
			
			MIS_T3.classes = new Class<?>[]{
					FishingSpear.class,
					Bolas.class
			};
			MIS_T3.probs = new float[]{ 4, 3 };
			
			MIS_T4.classes = new Class<?>[]{
					Javelin.class,
					Tomahawk.class
			};
			MIS_T4.probs = new float[]{ 4, 3 };
			
			MIS_T5.classes = new Class<?>[]{
					Trident.class,
					ThrowingHammer.class
			};
			MIS_T5.probs = new float[]{ 4, 3 };
			
			FOOD.classes = new Class<?>[]{
					Food.class,
					Pasty.class,
					MysteryMeat.class };
			FOOD.probs = new float[]{ 4, 1, 0 };
			
			RING.classes = new Class<?>[]{
					RingOfAccuracy.class,
					RingOfEvasion.class,
					RingOfElements.class,
					RingOfForce.class,
					RingOfFuror.class,
					RingOfHaste.class,
					RingOfEnergy.class,
					RingOfMight.class,
					RingOfSharpshooting.class,
					RingOfTenacity.class,
					RingOfWealth.class};
			RING.probs = new float[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			
			ARTIFACT.classes = new Class<?>[]{
					CapeOfThorns.class,
					ChaliceOfBlood.class,
					CloakOfShadows.class,
					HornOfPlenty.class,
					MasterThievesArmband.class,
					SandalsOfNature.class,
					TalismanOfForesight.class,
					TimekeepersHourglass.class,
					UnstableSpellbook.class,
					AlchemistsToolkit.class, //currently removed from drop tables, pending rework.
					DriedRose.class,
					LloydsBeacon.class,
					EtherealChains.class
			};
			ARTIFACT.probs = INITIAL_ARTIFACT_PROBS.clone();
			
			SEED.classes = new Class<?>[]{
					Firebloom.Seed.class,
					Icecap.Seed.class,
					Sorrowmoss.Seed.class,
					Blindweed.Seed.class,
					Sungrass.Seed.class,
					Earthroot.Seed.class,
					Fadeleaf.Seed.class,
					Rotberry.Seed.class,
					BlandfruitBush.Seed.class,
					Dreamfoil.Seed.class,
					Stormvine.Seed.class,
					Starflower.Seed.class};
			SEED.probs = new float[]{ 10, 10, 10, 10, 10, 10, 10, 0, 2, 10, 10, 1 };
		}
	}

	private static final float[][] floorSetTierProbs = new float[][] {
			{0, 70, 20,  8,  2},
			{0, 25, 50, 20,  5},
			{0, 10, 40, 40, 10},
			{0,  5, 20, 50, 25},
			{0,  2,  8, 20, 70}
	};
	
	private static HashMap<Category,Float> categoryProbs = new LinkedHashMap<>();
	
	public static void reset() {
		for (Category cat : Category.values()) {
			categoryProbs.put( cat, cat.prob );
		}
	}
	
	public static Item random() {
		Category cat = Random.chances( categoryProbs );
		if (cat == null){
			reset();
			cat = Random.chances( categoryProbs );
		}
		categoryProbs.put( cat, categoryProbs.get( cat ) - 1);
		return random( cat );
	}
	
	public static Item random( Category cat ) {
		try {
			
			switch (cat) {
			case ARMOR:
				return randomArmor();
			case WEAPON:
				return randomWeapon();
			case MISSILE:
				return randomMissile();
			case ARTIFACT:
				Item item = randomArtifact();
				//if we're out of artifacts, return a ring instead.
				return item != null ? item : random(Category.RING);
			default:
				return ((Item)cat.classes[Random.chances( cat.probs )].newInstance()).random();
			}
			
		} catch (Exception e) {

			SmashedPixelDungeon.reportException(e);
			return null;
			
		}
	}
	
	public static Item random( Class<? extends Item> cl ) {
		try {
			
			return ((Item)cl.newInstance()).random();
			
		} catch (Exception e) {

			SmashedPixelDungeon.reportException(e);
			return null;
			
		}
	}

	public static Armor randomArmor(){
		return randomArmor(Dungeon.depth / 5);
	}
	
	public static Armor randomArmor(int floorSet) {

		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);

		try {
			Armor a = (Armor)Category.ARMOR.classes[Random.chances(floorSetTierProbs[floorSet])].newInstance();
			a.random();
			return a;
		} catch (Exception e) {
			SmashedPixelDungeon.reportException(e);
			return null;
		}
	}

	public static final Category[] wepTiers = new Category[]{
			Category.WEP_T1,
			Category.WEP_T2,
			Category.WEP_T3,
			Category.WEP_T4,
			Category.WEP_T5
	};

	public static MeleeWeapon randomWeapon(){
		return randomWeapon(Dungeon.depth / 5);
	}
	
	public static MeleeWeapon randomWeapon(int floorSet) {

		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);

		try {
			Category c = wepTiers[Random.chances(floorSetTierProbs[floorSet])];
			MeleeWeapon w = (MeleeWeapon)c.classes[Random.chances(c.probs)].newInstance();
			w.random();
			return w;
		} catch (Exception e) {
			SmashedPixelDungeon.reportException(e);
			return null;
		}
	}
	
	public static final Category[] misTiers = new Category[]{
			Category.MIS_T1,
			Category.MIS_T2,
			Category.MIS_T3,
			Category.MIS_T4,
			Category.MIS_T5
	};
	
	public static MissileWeapon randomMissile(){
		return randomMissile(Dungeon.depth / 5);
	}
	
	public static MissileWeapon randomMissile(int floorSet) {
		
		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);
		
		try {
			Category c = misTiers[Random.chances(floorSetTierProbs[floorSet])];
			MissileWeapon w = (MissileWeapon)c.classes[Random.chances(c.probs)].newInstance();
			w.random();
			return w;
		} catch (Exception e) {
			SmashedPixelDungeon.reportException(e);
			return null;
		}
	}

	//enforces uniqueness of artifacts throughout a run.
	public static Artifact randomArtifact() {

		try {
			Category cat = Category.ARTIFACT;
			int i = Random.chances( cat.probs );

			//if no artifacts are left, return null
			if (i == -1){
				return null;
			}
			
			Class<?extends Artifact> art = (Class<? extends Artifact>) cat.classes[i];

			if (removeArtifact(art)) {
				Artifact artifact = art.newInstance();
				
				artifact.random();
				
				return artifact;
			} else {
				return null;
			}

		} catch (Exception e) {
			SmashedPixelDungeon.reportException(e);
			return null;
		}
	}

	public static boolean removeArtifact(Class<?extends Artifact> artifact) {
		if (spawnedArtifacts.contains(artifact))
			return false;

		Category cat = Category.ARTIFACT;
		for (int i = 0; i < cat.classes.length; i++)
			if (cat.classes[i].equals(artifact)) {
				if (cat.probs[i] == 1){
					cat.probs[i] = 0;
					spawnedArtifacts.add(artifact);
					return true;
				} else
					return false;
			}

		return false;
	}

	//resets artifact probabilities, for new dungeons
	public static void initArtifacts() {
		Category.ARTIFACT.probs = Category.INITIAL_ARTIFACT_PROBS.clone();
		spawnedArtifacts = new ArrayList<>();
	}

	private static ArrayList<Class<?extends Artifact>> spawnedArtifacts = new ArrayList<>();
	
	private static final String GENERAL_PROBS = "general_probs";
	private static final String SPAWNED_ARTIFACTS = "spawned_artifacts";
	
	public static void storeInBundle(Bundle bundle) {
		Float[] genProbs = categoryProbs.values().toArray(new Float[0]);
		float[] storeProbs = new float[genProbs.length];
		for (int i = 0; i < storeProbs.length; i++){
			storeProbs[i] = genProbs[i];
		}
		bundle.put( GENERAL_PROBS, storeProbs);
		
		bundle.put( SPAWNED_ARTIFACTS, spawnedArtifacts.toArray(new Class[0]));
	}

	public static void restoreFromBundle(Bundle bundle) {
		if (bundle.contains(GENERAL_PROBS)){
			float[] probs = bundle.getFloatArray(GENERAL_PROBS);
			for (int i = 0; i < probs.length; i++){
				categoryProbs.put(Category.values()[i], probs[i]);
			}
		} else {
			reset();
		}
		
		initArtifacts();
		if (bundle.contains(SPAWNED_ARTIFACTS)){
			for ( Class<?extends Artifact> artifact : bundle.getClassArray(SPAWNED_ARTIFACTS) ){
				removeArtifact(artifact);
			}
		//pre-0.6.1 saves
		} else if (bundle.contains("artifacts")) {
			String[] names = bundle.getStringArray("artifacts");
			Category cat = Category.ARTIFACT;

			for (String artifact : names)
				for (int i = 0; i < cat.classes.length; i++)
					if (cat.classes[i].getSimpleName().equals(artifact))
						cat.probs[i] = 0;
		}
	}
}
