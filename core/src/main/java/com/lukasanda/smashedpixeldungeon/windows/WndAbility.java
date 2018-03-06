package com.lukasanda.smashedpixeldungeon.windows;

import com.lukasanda.smashedpixeldungeon.Abilities;
import com.lukasanda.smashedpixeldungeon.Badges;
import com.lukasanda.smashedpixeldungeon.effects.BadgeBanner;
import com.lukasanda.smashedpixeldungeon.messages.Messages;
import com.lukasanda.smashedpixeldungeon.scenes.PixelScene;
import com.lukasanda.smashedpixeldungeon.ui.RedButton;
import com.lukasanda.smashedpixeldungeon.ui.RenderedTextMultiline;
import com.lukasanda.smashedpixeldungeon.ui.Window;
import com.watabou.noosa.Image;

/**
 * Created by lukas on 3/6/2018.
 */

public class WndAbility extends Window {
    private static final int WIDTH = 120;
    private static final int MARGIN = 4;
    
    public WndAbility(final Abilities.Ability ability ) {
        
        super();
        
        Image icon = BadgeBanner.image( ability.image );
        icon.scale.set( 2 );
        add( icon );
        
        //TODO: this used to be centered, should probably figure that out.
        RenderedTextMultiline info = PixelScene.renderMultiline( ability.desc(), 8 );
        info.maxWidth(WIDTH - MARGIN * 2);
        PixelScene.align(info);
        add(info);
        
        float w = Math.max( icon.width(), info.width() ) + MARGIN * 2;
        
        icon.x = (w - icon.width()) / 2f;
        icon.y = MARGIN;
        PixelScene.align(icon);
        
        info.setPos((w - info.width()) / 2, icon.y + icon.height() + MARGIN);
        resize( (int)w, (int)(info.bottom() + MARGIN) );
        
        BadgeBanner.highlight( icon, ability.image );
    
        RedButton buyButton = new RedButton(Messages.get(this,"sell", ability.price)){
            @Override
            protected void onClick() {
                Abilities.purchaseAbility(ability);
                hide();
            }
        };
        buyButton.setPos(w - buyButton.width() / 2, info.bottom() + info.height() + MARGIN);
        
        add(buyButton);
    
        resize( (int)w, (int)(buyButton.bottom() + MARGIN) );
        
    }
}
