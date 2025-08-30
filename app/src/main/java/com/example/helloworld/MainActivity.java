package com.example.helloworld;

import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // يفتح إعدادات اختيار الخلفية المتحركة مباشرة
        Intent intent = new Intent(WallpaperManager.ACTION_LIVE_WALLPAPER_CHOOSER);
        startActivity(intent);

        // يقفل التطبيق بعد ما يفتح شاشة اختيار الخلفية
        finish();
    }
}
