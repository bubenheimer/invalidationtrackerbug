package org.bubenheimer.invalidationtrackerbug;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;

@Dao
public abstract class CounterDao {
    @Insert
    abstract void insert(
            Counter entity
    );

    @Update
    abstract void update(
            Counter entity
    );
}
