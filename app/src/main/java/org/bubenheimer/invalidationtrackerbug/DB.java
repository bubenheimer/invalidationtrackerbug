package org.bubenheimer.invalidationtrackerbug;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {
                Counter.class,
                Counter2.class
        },
        version = 1,
        exportSchema = false
)
public abstract class DB extends RoomDatabase {
    public abstract CounterDao counterDao();
    public abstract Counter2Dao counter2Dao();
}
