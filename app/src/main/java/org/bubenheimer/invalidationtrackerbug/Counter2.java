package org.bubenheimer.invalidationtrackerbug;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Counter2.TABLE_NAME)
public final class Counter2 {
    static final String TABLE_NAME = "Counter2";

    @PrimaryKey
    private final long value;
    public long getValue(
    ) {
        return value;
    }

    Counter2(
            final long value
    ) {
        this.value = value;
    }
}
