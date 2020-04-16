package org.bubenheimer.invalidationtrackerbug;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Counter.TABLE_NAME)
public final class Counter {
    static final String TABLE_NAME = "Counter";

    @PrimaryKey
    private final long value;
    public long getValue(
    ) {
        return value;
    }

    Counter(
            final long value
    ) {
        this.value = value;
    }
}
