package com.mhammad.photoapp.favouritedatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Favourite.class}, version = 3, exportSchema = false)
public abstract class DataBase extends RoomDatabase {
    public abstract FavouriteDAO favouriteDAO();
    private static volatile DataBase INSTANCE;

    public static DataBase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (DataBase.class){
                if(INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DataBase.class, "AttendanceDatabase")
                            .addCallback(callback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static final RoomDatabase.Callback callback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDatabase(INSTANCE).execute();
        }
    };
    private static class PopulateDatabase extends AsyncTask<Void, Void, Void>
    {
        private final FavouriteDAO committeeDAO;

        public PopulateDatabase(DataBase db) {
            this.committeeDAO = db.favouriteDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}

