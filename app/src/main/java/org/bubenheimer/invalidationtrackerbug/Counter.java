package org.bubenheimer.invalidationtrackerbug;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public final class Counter {
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
