package com.example.aurelian.cleanerapp;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;
import java.text.DecimalFormat;

/**
 * Created by Aurelian on 3/19/2017.
 */

public class StorageManager {

    //PHONE STORAGE
    public static long phone_storage_free(){
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long free_memory = stat.getAvailableBlocksLong() * stat.getBlockSizeLong(); //return value is in bytes

        return free_memory;
    }

    public static long phone_storage_used(){
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long free_memory = (stat.getBlockCountLong()  - stat.getAvailableBlocksLong()) * stat.getBlockSizeLong(); //return value is in bytes

        return free_memory;
    }

    public static long phone_storage_total(){
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long free_memory = stat.getBlockCountLong() * stat.getBlockSizeLong(); //return value is in bytes

        return free_memory;
    }

    // SD CARD
    public static long sd_card_free(){

        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long free_memory = stat.getAvailableBlocksLong() * stat.getBlockSizeLong(); //return value is in bytes

        return free_memory;
    }
    public static long sd_card_used(){

        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long free_memory = (stat.getBlockCountLong() - stat.getAvailableBlocksLong()) * stat.getBlockSizeLong(); //return value is in bytes

        return free_memory;
    }
    public static long sd_card_total(){

        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long free_memory = stat.getBlockCountLong() * stat.getBlockSizeLong(); //return value is in bytes

        return free_memory;
    }
}
