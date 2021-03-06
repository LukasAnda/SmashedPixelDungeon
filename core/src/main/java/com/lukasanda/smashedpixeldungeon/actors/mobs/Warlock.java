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

package com.lukasanda.smashedpixeldungeon.actors.mobs;

import com.lukasanda.smashedpixeldungeon.Dungeon;
import com.lukasanda.smashedpixeldungeon.actors.Char;
import com.lukasanda.smashedpixeldungeon.actors.buffs.Buff;
import com.lukasanda.smashedpixeldungeon.actors.buffs.Weakness;
import com.lukasanda.smashedpixeldungeon.items.Generator;
import com.lukasanda.smashedpixeldungeon.items.Item;
import com.lukasanda.smashedpixeldungeon.items.potions.PotionOfHealing;
import com.lukasanda.smashedpixeldungeon.items.weapon.enchantments.Grim;
import com.lukasanda.smashedpixeldungeon.mechanics.Ballistica;
import com.lukasanda.smashedpixeldungeon.messages.Messages;
import com.lukasanda.smashedpixeldungeon.sprites.CharSprite;
import com.lukasanda.smashedpixeldungeon.sprites.WarlockSprite;
import com.lukasanda.smashedpixeldungeon.utils.GLog;
import com.watabou.utils.Callback;
import com.watabou.utils.Random;

public class Warlock extends Mob implements Callback {
	
	private static final float TIME_TO_ZAP	= 1f;
	
	{
		spriteClass = WarlockSprite.class;
		
		HP = HT = 70;
		defenseSkill = 18;
		
		EXP = 11;
		maxLvl = 21;
		
		loot = Generator.Category.POTION;
		lootChance = 0.83f;

		properties.add(Property.UNDEAD);
	}
	
	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 16, 22 );
	}
	
	@Override
	public int attackSkill( Char target ) {
		return 25;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 8);
	}
	
	@Override
	protected boolean canAttack( Char enemy ) {
		return new Ballistica( pos, enemy.pos, Ballistica.MAGIC_BOLT).collisionPos == enemy.pos;
	}
	
	protected boolean doAttack( Char enemy ) {

		if (Dungeon.level.adjacent( pos, enemy.pos )) {
			
			return super.doAttack( enemy );
			
		} else {
			
			boolean visible = fieldOfView[pos] || fieldOfView[enemy.pos];
			if (visible) {
				sprite.zap( enemy.pos );
			} else {
				zap();
			}
			
			return !visible;
		}
	}
	
	private void zap() {
		spend( TIME_TO_ZAP );
		
		if (hit( this, enemy, true )) {
			if (enemy == Dungeon.hero && Random.Int( 2 ) == 0) {
				Buff.prolong( enemy, Weakness.class, Weakness.DURATION );
			}
			
			int dmg = Random.Int( 12, 18 );
			enemy.damage( dmg, this );
			
			if (!enemy.isAlive() && enemy == Dungeon.hero) {
				Dungeon.fail( getClass() );
				GLog.n( Messages.get(this, "bolt_kill") );
			}
		} else {
			enemy.sprite.showStatus( CharSprite.NEUTRAL,  enemy.defenseVerb() );
		}
	}
	
	public void onZapComplete() {
		zap();
		next();
	}
	
	@Override
	public void call() {
		next();
	}

	@Override
	public Item createLoot(){
		Item loot = super.createLoot();

		if (loot instanceof PotionOfHealing){

			//count/10 chance of not dropping potion
			if ((Random.Int(10) - Dungeon.LimitedDrops.WARLOCK_HP.count) < 0){
				return null;
			} else
				Dungeon.LimitedDrops.WARLOCK_HP.count++;

		}

		return loot;
	}

	{
		resistances.add( Grim.class );
	}
}
