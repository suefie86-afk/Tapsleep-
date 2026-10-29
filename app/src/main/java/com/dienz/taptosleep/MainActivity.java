package com.dienz.taptosleep;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        new Thread(() -> {
            try {
                Runtime.getRuntime()
                    .exec(new String[]{"su", "-c", "input keyevent 26"})
                    .waitFor();
            } catch (Exception e) { e.printStackTrace(); }
            runOnUiThread(this::finishAndRemoveTask);
        }).start();
    }
}
