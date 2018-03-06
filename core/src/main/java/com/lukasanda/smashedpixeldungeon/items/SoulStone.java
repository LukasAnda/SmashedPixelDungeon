package com.lukasanda.smashedpixeldungeon.items;

import com.lukasanda.smashedpixeldungeon.Assets;
import com.lukasanda.smashedpixeldungeon.actors.hero.Hero;
import com.lukasanda.smashedpixeldungeon.sprites.CharSprite;
import com.lukasanda.smashedpixeldungeon.sprites.ItemSpriteSheet;
import com.lukasanda.smashedpixeldungeon.SoulStoneWallet;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

import java.util.ArrayList;

/**
 * Created by lukas on 3/5/2018.
 */

public class SoulStone extends Item {
    
    private static final String TXT_VALUE	= "%+d";
    
    {
        image = ItemSpriteSheet.GOLD;
        stackable = true;
    }
    
    public SoulStone() {
        this.quantity = 1;
    }
    
    @Override
    public ArrayList<String> actions(Hero hero ) {
        return new ArrayList<String>();
    }
    
    @Override
    public boolean doPickUp( Hero hero ) {
        SoulStoneWallet.soulStones ++;
        SoulStoneWallet.saveNeeded = true;
        //TODO add to statistics and Badges
//        Badges.validateGoldCollected();
        
        hero.sprite.showStatus( CharSprite.SOUL_STONE, TXT_VALUE, quantity );
        hero.spendAndNext( TIME_TO_PICK_UP );
        
        Sample.INSTANCE.play( Assets.SND_GOLD, 1, 1, Random.Float( 0.9f, 1.1f ) );
        
        return true;
    }
    
    @Override
    public boolean isUpgradable() {
        return false;
    }
    
    @Override
    public boolean isIdentified() {
        return true;
    }
    
    @Override
    public Item random() {
        quantity = 1;
        return this;
    }
}
