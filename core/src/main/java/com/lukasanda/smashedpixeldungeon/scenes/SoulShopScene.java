/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015  Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2017 Evan Debenham
 * 
 * Smashed Pixel Dungeon
 * Copyright (C) 2018-present Lukas Anda
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

package com.lukasanda.smashedpixeldungeon.scenes;

import com.lukasanda.smashedpixeldungeon.Abilities;
import com.lukasanda.smashedpixeldungeon.Assets;
import com.lukasanda.smashedpixeldungeon.SPDSettings;
import com.lukasanda.smashedpixeldungeon.SmashedPixelDungeon;
import com.lukasanda.smashedpixeldungeon.SoulStoneWallet;
import com.lukasanda.smashedpixeldungeon.effects.AbilityBanner;
import com.lukasanda.smashedpixeldungeon.messages.Messages;
import com.lukasanda.smashedpixeldungeon.ui.Archs;
import com.lukasanda.smashedpixeldungeon.ui.ExitButton;
import com.lukasanda.smashedpixeldungeon.ui.Window;
import com.lukasanda.smashedpixeldungeon.utils.GLog;
import com.lukasanda.smashedpixeldungeon.windows.WndAbility;
import com.watabou.noosa.Camera;
import com.watabou.noosa.Game;
import com.watabou.noosa.Image;
import com.watabou.noosa.RenderedText;
import com.watabou.noosa.audio.Music;
import com.watabou.noosa.audio.Sample;
import com.watabou.noosa.ui.Button;
import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.List;

public class SoulShopScene extends PixelScene implements OnBuyInterface {
    private RenderedText soulStones;
    
    @Override
    public void create() {
        
        super.create();
        
        Music.INSTANCE.play(Assets.THEME, true);
        
        uiCamera.visible = false;
        
        int w = Camera.main.width;
        int h = Camera.main.height;
        
        Archs archs = new Archs();
        archs.setSize(w, h);
        add(archs);
        
        loadViews(w, h);
        fadeIn();
    }
    
    private void loadViews(int w, int h) {
        float left = 5;
        float top = 15;
        RenderedText title = PixelScene.renderText(Messages.get(this, "title"), 9);
        title.hardlight(Window.TITLE_COLOR);
        title.x = (w - title.width()) / 2;
        title.y = (top - title.baseLine()) / 2;
        align(title);
        add(title);
        
        SoulStoneWallet.loadGlobal();
        
        soulStones = PixelScene.renderText(Messages.get(this, "currency",
                SoulStoneWallet.soulStones), 6);
        soulStones.hardlight(Window.SHPX_COLOR);
        soulStones.x = 4;
        soulStones.y = (top - soulStones.baseLine()) / 2;
        align(soulStones);
        add(soulStones);
        
        Abilities.loadUnlocked();
        
        List<Abilities.Ability> abilities = new ArrayList<>(Abilities.getAllAbilities());
        
        int blankBadges = 4;
        blankBadges -= abilities.size();
        blankBadges = Math.max(0, blankBadges);
        
        //guarantees a max of 5 rows in landscape, and 8 in portrait, assuming a max of 40 buttons
        int nCols = SPDSettings.landscape() ? 7 : 4;
        if (abilities.size() + blankBadges > 32 && !SPDSettings.landscape()) nCols++;
        
        int nRows = 1 + (blankBadges + abilities.size()) / nCols;
        
        float abilityWidth = (w - 2 * left) / nCols;
        float abilityHeight = (h - 2 * top) / nRows;
        
        for (int i = 0; i < abilities.size(); i++) {
            int row = i / nCols;
            int col = i % nCols;
            final Abilities.Ability b = i < abilities.size() ? abilities.get(i) : null;
            AbilityButton button = new AbilityButton(b, this);
            button.setPos(
                    left + col * abilityWidth + (abilityWidth - button.width()) / 2,
                    top + row * abilityHeight + (abilityHeight - button.height()) / 2);
            align(button);
            add(button);
        }
        
        ExitButton btnExit = new ExitButton();
        btnExit.setPos(Camera.main.width - btnExit.width(), 0);
        add(btnExit);
        SoulStoneWallet.soulStones = 250;
    }
    
    private void updateViews() {
        soulStones.text(Messages.get(this, "currency",
                SoulStoneWallet.soulStones));
    }
    
    @Override
    public void destroy() {
        
        Abilities.saveAll();
        Abilities.saveUnlocked();
        
        super.destroy();
    }
    
    @Override
    protected void onBackPressed() {
        SmashedPixelDungeon.switchNoFade(TitleScene.class);
    }
    
    @Override
    public void onBuyItem() {
        updateViews();
    }
    
    
    private class AbilityButton extends Button implements OnItemBuyInterface {
        
        private Abilities.Ability ability;
        
        private Image icon;
        
        private OnBuyInterface onBuyInterface;
        
        public AbilityButton(Abilities.Ability ability, OnBuyInterface onBuyInterface) {
            super();
            
            this.ability = ability;
            active = (ability != null);
            
            this.onBuyInterface = onBuyInterface;
            
            icon = Abilities.isUnlocked(this.ability) ? AbilityBanner.image(this.ability.image) :
                    AbilityBanner.image(this.ability.fadedImage);
            add(icon);
            
            setSize(icon.width(), icon.height());
        }
        
        @Override
        protected void layout() {
            super.layout();
            
            icon.x = x + (width - icon.width()) / 2;
            icon.y = y + (height - icon.height()) / 2;
        }
        
        @Override
        public void update() {
            super.update();
            if (Random.Float() < Game.elapsed * 0.1) {
                AbilityBanner.highlight(icon, ability.image);
            }
        }
        
        @Override
        protected void onClick() {
            Sample.INSTANCE.play(Assets.SND_CLICK, 0.7f, 0.7f, 1.2f);
            Game.scene().add(new WndAbility(this.ability, this));
        }
        
        @Override
        public void onBuy() {
            remove(icon);
            this.icon = AbilityBanner.image(this.ability.image);
            add(icon);
            setSize(icon.width(), icon.height());
            onBuyInterface.onBuyItem();
        }
    }
}
