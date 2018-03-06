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

package com.lukasanda.smashedpixeldungeon.actors.hero;

import com.lukasanda.smashedpixeldungeon.Abilities;
import com.lukasanda.smashedpixeldungeon.Assets;
import com.lukasanda.smashedpixeldungeon.Badges;
import com.lukasanda.smashedpixeldungeon.Challenges;
import com.lukasanda.smashedpixeldungeon.Dungeon;
import com.lukasanda.smashedpixeldungeon.actors.buffs.Buff;
import com.lukasanda.smashedpixeldungeon.actors.buffs.MidasTouch;
import com.lukasanda.smashedpixeldungeon.actors.buffs.TitanSkin;
import com.lukasanda.smashedpixeldungeon.items.BrokenSeal;
import com.lukasanda.smashedpixeldungeon.items.armor.ClothArmor;
import com.lukasanda.smashedpixeldungeon.items.artifacts.CloakOfShadows;
import com.lukasanda.smashedpixeldungeon.items.bags.ScrollHolder;
import com.lukasanda.smashedpixeldungeon.items.food.Food;
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
import com.lukasanda.smashedpixeldungeon.items.wands.WandOfMagicMissile;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Dagger;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.Knuckles;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.MagesStaff;
import com.lukasanda.smashedpixeldungeon.items.weapon.melee.WornShortsword;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.Boomerang;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.ThrowingKnife;
import com.lukasanda.smashedpixeldungeon.items.weapon.missiles.ThrowingStone;
import com.lukasanda.smashedpixeldungeon.messages.Messages;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

import java.util.HashSet;

public enum HeroClass {

	WARRIOR( "warrior" ),
	MAGE( "mage" ),
	ROGUE( "rogue" ),
	HUNTRESS( "huntress" );

	private String title;

	HeroClass( String title ) {
		this.title = title;
	}

	public void initHero( Hero hero ) {

		hero.heroClass = this;

		initCommon( hero );

		switch (this) {
			case WARRIOR:
				initWarrior( hero );
				break;

			case MAGE:
				initMage( hero );
				break;

			case ROGUE:
				initRogue( hero );
				break;

			case HUNTRESS:
				initHuntress( hero );
				break;
		}
		
	}

	private static void initCommon( Hero hero ) {
		if (!Dungeon.isChallenged(Challenges.NO_ARMOR))
			(hero.belongings.armor = new ClothArmor()).identify();

		if (!Dungeon.isChallenged(Challenges.NO_FOOD))
			new Food().identify().collect();
        HashSet<Abilities.Ability> abilities = Abilities.getUnlockedAbilities();
        if(abilities!=null){
            for(Abilities.Ability ability :abilities){
                switch (ability){
                    case TITAN_SKIN:
                        Buff.affect(hero, TitanSkin.class, 1f);
                        break;
                    case MIDAS_TOUCH:
                        Buff.affect(hero, MidasTouch.class, 1f);
                        break;
                    case POTIONS_MASTER:
                        getRandomPotion();
                        break;
                    case SCROLLS_MASTER:
                    	getRandomScroll();
                        break;
                }
            }
        }
	}
	
	public static void getRandomPotion(){
	    
	    switch (Random.Int(12)){
            case 0:
                new PotionOfExperience().identify().collect();
                break;
            case 1:
                new PotionOfFrost().identify().collect();
                break;
            case 2:
                new PotionOfHealing().identify().collect();
                break;
            case 3:
                new PotionOfInvisibility().identify().collect();
                break;
            case 4:
                new PotionOfLevitation().identify().collect();
                break;
            case 5:
                new PotionOfLiquidFlame().identify().collect();
                break;
            case 6:
                new PotionOfMight().identify().collect();
                break;
            case 7:
                new PotionOfMindVision().identify().collect();
                break;
            case 8:
                new PotionOfParalyticGas().identify().collect();
                break;
            case 9:
                new PotionOfPurity().identify().collect();
                break;
            case 10:
                new PotionOfStrength().identify().collect();
                break;
            case 11:
                new PotionOfToxicGas().identify().collect();
                break;
        }
    }
    
	public static void getRandomScroll(){
	    
	    switch (Random.Int(12)){
            case 0:
                new ScrollOfIdentify().identify().collect();
                break;
            case 1:
                new ScrollOfLullaby().identify().collect();
                break;
            case 2:
                new ScrollOfMagicalInfusion().identify().collect();
                break;
            case 3:
                new ScrollOfMagicMapping().identify().collect();
                break;
            case 4:
                new ScrollOfMirrorImage().identify().collect();
                break;
            case 5:
                new ScrollOfPsionicBlast().identify().collect();
                break;
            case 6:
                new ScrollOfRage().identify().collect();
                break;
            case 7:
                new ScrollOfRecharging().identify().collect();
                break;
            case 8:
                new ScrollOfRemoveCurse().identify().collect();
                break;
            case 9:
                new ScrollOfTeleportation().identify().collect();
                break;
            case 10:
                new ScrollOfTerror().identify().collect();
                break;
            case 11:
                new ScrollOfUpgrade().identify().collect();
                break;
        }
    }

	public Badges.Badge masteryBadge() {
		switch (this) {
			case WARRIOR:
				return Badges.Badge.MASTERY_WARRIOR;
			case MAGE:
				return Badges.Badge.MASTERY_MAGE;
			case ROGUE:
				return Badges.Badge.MASTERY_ROGUE;
			case HUNTRESS:
				return Badges.Badge.MASTERY_HUNTRESS;
		}
		return null;
	}

	private static void initWarrior( Hero hero ) {
		(hero.belongings.weapon = new WornShortsword()).identify();
		ThrowingStone stones = new ThrowingStone();
		stones.identify().quantity(3).collect();

		if ( Badges.isUnlocked(Badges.Badge.TUTORIAL_WARRIOR) ){
			if (!Dungeon.isChallenged(Challenges.NO_ARMOR))
				hero.belongings.armor.affixSeal(new BrokenSeal());
			Dungeon.quickslot.setSlot(0, stones);
		} else {
			if (!Dungeon.isChallenged(Challenges.NO_ARMOR)) {
				BrokenSeal seal = new BrokenSeal();
				seal.collect();
				Dungeon.quickslot.setSlot(0, seal);
			}
			Dungeon.quickslot.setSlot(1, stones);
		}

		new PotionOfHealing().identify();
	}

	private static void initMage( Hero hero ) {
		MagesStaff staff;

		if ( Badges.isUnlocked(Badges.Badge.TUTORIAL_MAGE) ){
			staff = new MagesStaff(new WandOfMagicMissile());
		} else {
			staff = new MagesStaff();
			new WandOfMagicMissile().identify().collect();
		}

		(hero.belongings.weapon = staff).identify();
		hero.belongings.weapon.activate(hero);

		Dungeon.quickslot.setSlot(0, staff);

		new ScrollOfUpgrade().identify();
	}

	private static void initRogue( Hero hero ) {
		(hero.belongings.weapon = new Dagger()).identify();

		CloakOfShadows cloak = new CloakOfShadows();
		(hero.belongings.misc1 = cloak).identify();
		hero.belongings.misc1.activate( hero );

		ThrowingKnife knives = new ThrowingKnife();
		knives.quantity(3).collect();

		Dungeon.quickslot.setSlot(0, cloak);
		Dungeon.quickslot.setSlot(1, knives);

		new ScrollOfMagicMapping().identify();
	}

	private static void initHuntress( Hero hero ) {

		(hero.belongings.weapon = new Knuckles()).identify();
		Boomerang boomerang = new Boomerang();
		boomerang.identify().collect();

		Dungeon.quickslot.setSlot(0, boomerang);

		new PotionOfMindVision().identify();
	}
	
	public String title() {
		return Messages.get(HeroClass.class, title);
	}
	
	public String spritesheet() {
		
		switch (this) {
		case WARRIOR:
			return Assets.WARRIOR;
		case MAGE:
			return Assets.MAGE;
		case ROGUE:
			return Assets.ROGUE;
		case HUNTRESS:
			return Assets.HUNTRESS;
		}
		
		return null;
	}
	
	public String[] perks() {
		
		switch (this) {
		case WARRIOR:
			return new String[]{
					Messages.get(HeroClass.class, "warrior_perk1"),
					Messages.get(HeroClass.class, "warrior_perk2"),
					Messages.get(HeroClass.class, "warrior_perk3"),
					Messages.get(HeroClass.class, "warrior_perk4"),
					Messages.get(HeroClass.class, "warrior_perk5"),
			};
		case MAGE:
			return new String[]{
					Messages.get(HeroClass.class, "mage_perk1"),
					Messages.get(HeroClass.class, "mage_perk2"),
					Messages.get(HeroClass.class, "mage_perk3"),
					Messages.get(HeroClass.class, "mage_perk4"),
					Messages.get(HeroClass.class, "mage_perk5"),
			};
		case ROGUE:
			return new String[]{
					Messages.get(HeroClass.class, "rogue_perk1"),
					Messages.get(HeroClass.class, "rogue_perk2"),
					Messages.get(HeroClass.class, "rogue_perk3"),
					Messages.get(HeroClass.class, "rogue_perk4"),
					Messages.get(HeroClass.class, "rogue_perk5"),
			};
		case HUNTRESS:
			return new String[]{
					Messages.get(HeroClass.class, "huntress_perk1"),
					Messages.get(HeroClass.class, "huntress_perk2"),
					Messages.get(HeroClass.class, "huntress_perk3"),
					Messages.get(HeroClass.class, "huntress_perk4"),
					Messages.get(HeroClass.class, "huntress_perk5"),
			};
		}
		
		return null;
	}

	private static final String CLASS	= "class";
	
	public void storeInBundle( Bundle bundle ) {
		bundle.put( CLASS, toString() );
	}
	
	public static HeroClass restoreInBundle( Bundle bundle ) {
		String value = bundle.getString( CLASS );
		return value.length() > 0 ? valueOf( value ) : ROGUE;
	}
}
