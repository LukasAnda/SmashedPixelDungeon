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

package com.lukasanda.smashedpixeldungeon.levels.features;

import com.lukasanda.smashedpixeldungeon.Challenges;
import com.lukasanda.smashedpixeldungeon.Dungeon;
import com.lukasanda.smashedpixeldungeon.actors.Char;
import com.lukasanda.smashedpixeldungeon.actors.buffs.Barkskin;
import com.lukasanda.smashedpixeldungeon.actors.buffs.Buff;
import com.lukasanda.smashedpixeldungeon.actors.hero.Hero;
import com.lukasanda.smashedpixeldungeon.actors.hero.HeroSubClass;
import com.lukasanda.smashedpixeldungeon.effects.CellEmitter;
import com.lukasanda.smashedpixeldungeon.effects.particles.LeafParticle;
import com.lukasanda.smashedpixeldungeon.items.Dewdrop;
import com.lukasanda.smashedpixeldungeon.items.Generator;
import com.lukasanda.smashedpixeldungeon.items.Item;
import com.lukasanda.smashedpixeldungeon.items.armor.glyphs.Camouflage;
import com.lukasanda.smashedpixeldungeon.items.artifacts.SandalsOfNature;
import com.lukasanda.smashedpixeldungeon.levels.Level;
import com.lukasanda.smashedpixeldungeon.levels.Terrain;
import com.lukasanda.smashedpixeldungeon.plants.BlandfruitBush;
import com.lukasanda.smashedpixeldungeon.scenes.GameScene;
import com.watabou.utils.Random;

public class HighGrass {

	public static void trample( Level level, int pos, Char ch ) {
		
		Level.set( pos, Terrain.GRASS );
		GameScene.updateMap( pos );

		if (!Dungeon.isChallenged( Challenges.NO_HERBALISM )) {
			int naturalismLevel = 0;

			if (ch != null) {
				SandalsOfNature.Naturalism naturalism = ch.buff( SandalsOfNature.Naturalism.class );
				if (naturalism != null) {
					if (!naturalism.isCursed()) {
						naturalismLevel = naturalism.itemLevel() + 1;
						naturalism.charge();
					} else {
						naturalismLevel = -1;
					}
				}
			}

			if (naturalismLevel >= 0) {
				// Seed, scales from 1/16 to 1/4
				if (Random.Int(16 - ((int) (naturalismLevel * 3))) == 0) {
					Item seed = Generator.random(Generator.Category.SEED);

					if (seed instanceof BlandfruitBush.Seed) {
						if (Random.Int(3) - Dungeon.LimitedDrops.BLANDFRUIT_SEED.count >= 0) {
							level.drop(seed, pos).sprite.drop();
							Dungeon.LimitedDrops.BLANDFRUIT_SEED.count++;
						}
					} else
						level.drop(seed, pos).sprite.drop();
				}

				// Dew, scales from 1/6 to 1/3
				if (Random.Int(24 - naturalismLevel*3) <= 3) {
					level.drop(new Dewdrop(), pos).sprite.drop();
				}
			}
		}

		int leaves = 4;
		

		if (ch instanceof Hero) {
			Hero hero = (Hero)ch;

			// Barkskin
			if (hero.subClass == HeroSubClass.WARDEN) {
				Buff.affect(ch, Barkskin.class).level(ch.HT / 3);
				leaves += 4;
			}

			//Camouflage
			if (hero.belongings.armor != null && hero.belongings.armor.hasGlyph(Camouflage.class)){
				Buff.affect(hero, Camouflage.Camo.class).set(3 + hero.belongings.armor.level());
				leaves += 4;
			}
		}
		
		CellEmitter.get( pos ).burst( LeafParticle.LEVEL_SPECIFIC, leaves );
		if (Dungeon.level.heroFOV[pos]) Dungeon.observe();
	}
}
