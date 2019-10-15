package p.fetch.Database;



import androidx.room.Database;
import androidx.room.RoomDatabase;

import p.fetch.FavoriteDao;
import p.fetch.FavoriteList;

@Database(entities={FavoriteList.class},version = 1)
public abstract class FavoriteDatabase extends RoomDatabase {

    public abstract FavoriteDao favoriteDao();


}
