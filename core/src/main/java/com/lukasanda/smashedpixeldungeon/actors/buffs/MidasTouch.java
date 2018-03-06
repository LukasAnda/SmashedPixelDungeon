package com.lukasanda.smashedpixeldungeon.actors.buffs;

import com.lukasanda.smashedpixeldungeon.actors.hero.Hero;
import com.lukasanda.smashedpixeldungeon.messages.Messages;
import com.lukasanda.smashedpixeldungeon.ui.BuffIndicator;
import com.watabou.noosa.Image;

/**
 * Created by lukas on 3/6/2018.
 */

public class MidasTouch extends FlavourBuff {
    public static final float DURATION	= 1f;
    
    {
        type = buffType.POSITIVE;
    }
    
    @Override
    public boolean act() {
        if(target instanceof Hero){
            ((Hero) target).goldMultiplier = 2;
        }
        detach();
        return super.act();
    }
    
    @Override
    public int icon() {
        return BuffIndicator.IMMUNITY;
    }
    
    @Override
    public void tintIcon(Image icon) {
        greyIcon(icon, 5f, cooldown());
    }
    
    @Override
    public String toString() {
        return Messages.get(this, "name");
    }
    
    @Override
    public String desc() {
        return Messages.get(this, "desc", dispTurns());
    }
}
