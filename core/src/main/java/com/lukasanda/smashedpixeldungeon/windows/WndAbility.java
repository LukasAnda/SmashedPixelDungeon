package com.lukasanda.smashedpixeldungeon.windows;

import com.lukasanda.smashedpixeldungeon.Abilities;
import com.lukasanda.smashedpixeldungeon.Badges;
import com.lukasanda.smashedpixeldungeon.SoulStoneWallet;
import com.lukasanda.smashedpixeldungeon.effects.AbilityBanner;
import com.lukasanda.smashedpixeldungeon.effects.BadgeBanner;
import com.lukasanda.smashedpixeldungeon.messages.Messages;
import com.lukasanda.smashedpixeldungeon.scenes.OnBuyInterface;
import com.lukasanda.smashedpixeldungeon.scenes.OnItemBuyInterface;
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
    
    public WndAbility(final Abilities.Ability ability, final OnItemBuyInterface onChangeInterface) {
        
        super();
        
        Image icon = AbilityBanner.image( ability.image );
        icon.scale.set( 2 );
        add( icon );
        
        //TODO: this used to be centered, should probably figure that out.
        RenderedTextMultiline info = PixelScene.renderMultiline( ability.mName(), 8 );
        info.maxWidth(WIDTH - MARGIN * 2);
        PixelScene.align(info);
        add(info);
    
        RenderedTextMultiline info2 = PixelScene.renderMultiline( ability.desc(), 8 );
        info2.maxWidth(WIDTH - MARGIN * 2);
        PixelScene.align(info2);
        add(info2);
        
        float w = Math.max( icon.width(), info2.width() ) + MARGIN * 2;
        
        icon.x = (w - icon.width()) / 2f;
        icon.y = MARGIN;
        PixelScene.align(icon);
        
        info.setPos((w - info.width()) / 2, icon.y + icon.height() + MARGIN);
        info2.setPos((w - info2.width()) / 2, icon.y + icon.height() + MARGIN*2 + info.height());
        
        AbilityBanner.highlight( icon, ability.image );
        resize((int)w, (int)(info2.bottom() + MARGIN));
        if(Abilities.isUnlocked(ability)) return;
        RedButton buyButton = new RedButton(Messages.get(this,"buy", ability.price)){
            @Override
            protected void onClick() {
                Abilities.purchaseAbility(ability);
                onChangeInterface.onBuy();
                hide();
            }
        };
        buyButton.enable(SoulStoneWallet.soulStones >= ability.price);
        buyButton.setSize(icon.width()*1.5f, 15);
        buyButton.setPos(w/2 - buyButton.width() / 2, info2.bottom()  + buyButton.height() + MARGIN);
        add(buyButton);
    
        resize( (int)w, (int)(buyButton.bottom() + MARGIN) );
        
    }
}
