package com.lukasanda.smashedpixeldungeon.items.bags;

import com.lukasanda.smashedpixeldungeon.items.Item;
import com.lukasanda.smashedpixeldungeon.items.scrolls.Scroll;
import com.lukasanda.smashedpixeldungeon.sprites.ItemSpriteSheet;

/**
 * Created by lukas on 3/6/2018.
 */

public class DarkSpellbook extends Bag {
    {
        image = ItemSpriteSheet.HOLDER;
        
        size = 12;
    }
    
    @Override
    public boolean grab( Item item ) {
        return item instanceof Scroll;
    }
    
    @Override
    public int price() {
        return -1;
    }
}
