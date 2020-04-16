package org.bubenheimer.invalidationtrackerbug;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.TextView;

import java.util.Random;
import java.util.Set;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;

public final class MainActivity extends Activity {
    int i = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);

        final DB db = Room
                .databaseBuilder(this, DB.class, "exploredb")
                .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
//                .setJournalMode(RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING)
                .enableMultiInstanceInvalidation()
                .build();

        final TextView textView = findViewById(R.id.textview);

        final InvalidationTracker invalidationTracker = db.getInvalidationTracker();
        new Thread(() -> invalidationTracker.addObserver(
                new InvalidationTracker.Observer(Counter2.TABLE_NAME) {
                    @Override
                    public void onInvalidated(@NonNull Set<String> tables) {
                        if (tables.contains(Counter2.TABLE_NAME)) {
                            runOnUiThread(() -> textView.setText(Integer.toString(--i)));
                        }
                    }
                })).start();

        final Random random = new Random();

        new Thread(() -> {
            while (true) {
                db.counterDao().insert(new Counter(random.nextLong()));
                SystemClock.sleep(1L);
                db.counter2Dao().insert(new Counter2(random.nextLong()));
                runOnUiThread(() -> textView.setText(Integer.toString(++i)));

                SystemClock.sleep(1000L);
            }
        }).start();
    }
}
