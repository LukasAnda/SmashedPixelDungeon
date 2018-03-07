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

package com.lukasanda.smashedpixeldungeon.items.weapon.enchantments;

import com.lukasanda.smashedpixeldungeon.actors.Char;
import com.lukasanda.smashedpixeldungeon.actors.buffs.Buff;
import com.lukasanda.smashedpixeldungeon.actors.buffs.Burning;
import com.lukasanda.smashedpixeldungeon.effects.particles.FlameParticle;
import com.lukasanda.smashedpixeldungeon.items.weapon.Weapon;
import com.lukasanda.smashedpixeldungeon.sprites.ItemSprite;
import com.lukasanda.smashedpixeldungeon.sprites.ItemSprite.Glowing;
import com.watabou.utils.Random;

public class Blazing extends Weapon.Enchantment {

	private static ItemSprite.Glowing ORANGE = new ItemSprite.Glowing( 0xFF4400 );
	
	@Override
	public int proc( Weapon weapon, Char attacker, Char defender, int damage ) {
		// lvl 0 - 33%
		// lvl 1 - 50%
		// lvl 2 - 60%
		int level = Math.max( 0, weapon.level() );
		
		if (Random.Int( level + 3 ) >= 2) {
			
			if (Random.Int( 2 ) == 0) {
				Buff.affect( defender, Burning.class ).reignite( defender );
			}
			defender.damage( Random.Int( 1, level + 2 ), this );
			
			defender.sprite.emitter().burst( FlameParticle.FACTORY, level + 1 );
			
		}

		return damage;

	}
	
	@Override
	public Glowing glowing() {
		return ORANGE;
	}
}