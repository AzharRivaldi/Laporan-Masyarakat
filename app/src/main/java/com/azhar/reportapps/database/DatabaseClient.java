package com.azhar.reportapps.database;

import android.content.Context;

import androidx.room.Room;

/**
 * Created by Azhar Rivaldi on 19-11-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

public class DatabaseClient {

    private static DatabaseClient dcInstance;
    AppDatabase appDatabase;

    private DatabaseClient(Context context) {
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "laporan_db")
                .fallbackToDestructiveMigration()
                .build();
    }

    public static synchronized DatabaseClient getInstance(Context context) {
        if (dcInstance == null) {
            dcInstance = new DatabaseClient(context);
        }
        return dcInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

}
