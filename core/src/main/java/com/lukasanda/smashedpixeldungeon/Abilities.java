package com.lukasanda.smashedpixeldungeon;

import com.lukasanda.smashedpixeldungeon.messages.Messages;
import com.lukasanda.smashedpixeldungeon.scenes.PixelScene;
import com.lukasanda.smashedpixeldungeon.utils.GLog;
import com.watabou.utils.Bundle;
import com.watabou.utils.FileUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by lukas on 3/6/2018.
 */

public class Abilities {
    public enum Ability {
        MIDAS_TOUCH(0,8,50),
        TITAN_SKIN(3,11,50),
        POTIONS_MASTER(2,10,50),
        SCROLLS_MASTER(1,9,50);
        
        
        public int image;
        public int fadedImage;
        public int price;
        
        public String desc() {
            return Messages.get(this, name());
        }
        
        Ability(int image, int fadedImage, int price) {
            this.image = image;
            this.fadedImage = fadedImage;
            this.price = price;
        }
    }
    
    private static LinkedHashSet<Ability> allAbilities;
    private static LinkedHashSet<Ability> unlockedAbilities;
    
    private static boolean saveNeeded = false;
    private static boolean unlockedSaveNeeded = false;
    
    private static final String ABILITIES_FILE = "abilities.dat";
    private static final String ABILITIES_UNLOCKED_FILE = "abunlocked.dat";
    private static final String ABILITIES = "abilities";
    
    private static LinkedHashSet<Ability> restore(Bundle bundle) {
        LinkedHashSet<Ability> abilities = new LinkedHashSet<>();
        if (bundle == null) return abilities;
        
        String[] names = bundle.getStringArray(ABILITIES);
        for (int i = 0; i < names.length; i++) {
            try {
                abilities.add(Ability.valueOf(names[i]));
            } catch (Exception e) {
                SmashedPixelDungeon.reportException(e);
            }
        }
        
        return abilities;
    }
    
    private static void store(Bundle bundle, HashSet<Ability> abilities) {
        int count = 0;
        String names[] = new String[abilities.size()];
        
        for (Ability ability : abilities) {
            names[count++] = ability.toString();
        }
        bundle.put(ABILITIES, names);
    }
    
    public static void loadUnlocked(){
        if(unlockedAbilities == null){
            try{
                Bundle bundle = FileUtils.bundleFromFile(ABILITIES_UNLOCKED_FILE);
                unlockedAbilities = restore(bundle);
                
            } catch (IOException e){
                unlockedAbilities = new LinkedHashSet<>();
            }
        }
    }
    
    public static void saveUnlocked(){
        if(unlockedSaveNeeded){
            Bundle bundle = new Bundle();
            store(bundle, allAbilities);
    
            try {
                FileUtils.bundleToFile(ABILITIES_UNLOCKED_FILE, bundle);
                unlockedSaveNeeded = false;
            } catch (IOException e) {
                SmashedPixelDungeon.reportException(e);
            }
        }
    }
    
    public static HashSet<Ability> getAllAbilities(){
        loadAll();
        return allAbilities;
    }
    
    public static HashSet<Ability> getUnlockedAbilities(){
        loadUnlocked();
        return unlockedAbilities;
    }
    
    public static void loadAll() {
        if (allAbilities == null || allAbilities.size() == 0) {
            try {
                Bundle bundle = FileUtils.bundleFromFile(ABILITIES_FILE);
                allAbilities = restore(bundle);
                
            } catch (IOException e) {
                allAbilities = new LinkedHashSet<>();
            }
            prepopulate(allAbilities);
        }
    }
    
    private static void prepopulate(HashSet<Ability> abilities){
        if(!abilities.contains(Ability.MIDAS_TOUCH)){
            abilities.add(Ability.MIDAS_TOUCH);
        }
        if(!abilities.contains(Ability.TITAN_SKIN)){
            abilities.add(Ability.TITAN_SKIN);
        }
        if(!abilities.contains(Ability.SCROLLS_MASTER)){
            abilities.add(Ability.SCROLLS_MASTER);
        }
        if(!abilities.contains(Ability.POTIONS_MASTER)){
            abilities.add(Ability.POTIONS_MASTER);
        }
    }
    
    public static void saveAll() {
        if (saveNeeded) {
            
            Bundle bundle = new Bundle();
            store(bundle, allAbilities);
            
            try {
                FileUtils.bundleToFile(ABILITIES_FILE, bundle);
                saveNeeded = false;
            } catch (IOException e) {
                SmashedPixelDungeon.reportException(e);
            }
        }
    }
    
    public static void getAbility(){
        
    }
    
    public static void purchaseAbility( Ability ability ) {
        
        if (ability == null || SoulStoneWallet.soulStones < ability.price) {
            return;
        }
        SoulStoneWallet.soulStones -= ability.price;
        unlockedAbilities.add( ability );
        unlockedSaveNeeded = true;
            
//            if (ability.meta) {
//                GLog.h( Messages.get(Badges.class, "new_super", ability.desc()) );
//            } else {
//                GLog.h( Messages.get(Badges.class, "new", ability.desc()) );
//            }
//            PixelScene.showBadge( ability );
    }
    
    public static boolean isUnlocked( Ability ability ) {
        return unlockedAbilities.contains( ability );
    }
    
}
