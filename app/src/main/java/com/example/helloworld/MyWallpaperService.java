package com.example.helloworld;

import android.service.wallpaper.WallpaperService;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class MyWallpaperService extends WallpaperService {

    @Override
    public Engine onCreateEngine() {
        return new MyEngine();
    }

    class MyEngine extends Engine {
        private Paint paint = new Paint();

        MyEngine() {
            paint.setColor(0xFF00FF00); // أخضر
        }

        @Override
        public void onSurfaceCreated(SurfaceHolder holder) {
            super.onSurfaceCreated(holder);
            draw();
        }

        private void draw() {
            SurfaceHolder holder = getSurfaceHolder();
            Canvas canvas = null;
            try {
                canvas = holder.lockCanvas();
                if (canvas != null) {
                    canvas.drawColor(0xFF000000); // أسود للخلفية
                    canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, 200, paint); // دائرة خضراء
                }
            } finally {
                if (canvas != null) {
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
