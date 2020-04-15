package org.bubenheimer.invalidationtrackerbug;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public final class Counter2 {
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
