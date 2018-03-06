package com.lukasanda.smashedpixeldungeon;

import com.lukasanda.smashedpixeldungeon.SmashedPixelDungeon;
import com.lukasanda.smashedpixeldungeon.journal.Catalog;
import com.lukasanda.smashedpixeldungeon.journal.Document;
import com.watabou.utils.Bundle;
import com.watabou.utils.FileUtils;

import java.io.IOException;

/**
 * Created by lukas on 3/5/2018.
 */

public class SoulStoneWallet {
    private static final String WALLET_FILE = "wallet.dat";
    
    private static boolean loaded = false;
    public static boolean saveNeeded = false;
    
    public static int soulStones;
    
    public static void loadGlobal(){
        if (loaded){
            return;
        }
        
        Bundle bundle;
        try {
            bundle = FileUtils.bundleFromFile( WALLET_FILE );
            
        } catch (IOException e){
            bundle = new Bundle();
        }
        soulStones = bundle.getInt("SOUL_STONES");
        
        loaded = true;
    }
    
    public static void saveGlobal(){
        if (!saveNeeded){
            return;
        }
        
        Bundle bundle = new Bundle();
        
        bundle.put("SOUL_STONES", soulStones);
        
        try {
            FileUtils.bundleToFile( WALLET_FILE, bundle );
            saveNeeded = false;
        } catch (IOException e) {
            SmashedPixelDungeon.reportException(e);
        }
        
    }
}
