package org.bubenheimer.invalidationtrackerbug;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public abstract class Counter2Dao {
    @Insert
    abstract void insert(
            Counter2 entity
    );
}
