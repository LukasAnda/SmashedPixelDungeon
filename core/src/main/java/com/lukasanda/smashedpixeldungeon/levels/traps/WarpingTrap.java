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

package com.lukasanda.smashedpixeldungeon.levels.traps;

import com.lukasanda.smashedpixeldungeon.Assets;
import com.lukasanda.smashedpixeldungeon.Dungeon;
import com.lukasanda.smashedpixeldungeon.actors.Actor;
import com.lukasanda.smashedpixeldungeon.actors.Char;
import com.lukasanda.smashedpixeldungeon.actors.hero.Hero;
import com.lukasanda.smashedpixeldungeon.actors.mobs.Mob;
import com.lukasanda.smashedpixeldungeon.effects.CellEmitter;
import com.lukasanda.smashedpixeldungeon.effects.Speck;
import com.lukasanda.smashedpixeldungeon.items.Heap;
import com.lukasanda.smashedpixeldungeon.items.Item;
import com.lukasanda.smashedpixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.lukasanda.smashedpixeldungeon.messages.Messages;
import com.lukasanda.smashedpixeldungeon.scenes.GameScene;
import com.lukasanda.smashedpixeldungeon.utils.BArray;
import com.lukasanda.smashedpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;

public class WarpingTrap extends Trap {

	{
		color = TEAL;
		shape = STARS;
	}

	@Override
	public void activate() {
		CellEmitter.get(pos).start(Speck.factory(Speck.LIGHT), 0.2f, 3);
		Sample.INSTANCE.play( Assets.SND_TELEPORT );
		
		Char ch = Actor.findChar( pos);
		if (ch instanceof Hero){
			ScrollOfTeleportation.teleportHero( (Hero)ch);
			BArray.setFalse(Dungeon.level.visited);
			BArray.setFalse(Dungeon.level.mapped);
			GameScene.updateFog();
			Dungeon.observe();
			
		} else if (ch != null){
			int count = 10;
			int pos;
			do {
				pos = Dungeon.level.randomRespawnCell();
				if (count-- <= 0) {
					break;
				}
			} while (pos == -1);
			
			if (pos == -1 || Dungeon.bossLevel()) {
				
				GLog.w( Messages.get(ScrollOfTeleportation.class, "no_tele") );
				
			} else {
				
				ch.pos = pos;
				if (ch instanceof Mob && ((Mob) ch).state == ((Mob) ch).HUNTING){
					((Mob) ch).state = ((Mob) ch).WANDERING;
				}
				ch.sprite.place(ch.pos);
				ch.sprite.visible = Dungeon.level.heroFOV[pos];
				
			}
		}
		
		Heap heap = Dungeon.level.heaps.get(pos);
		
		if (heap != null){
			int cell = Dungeon.level.randomRespawnCell();
			
			Item item = heap.pickUp();
			
			if (cell != -1) {
				Dungeon.level.drop( item, cell );
			}
		}

	}
}