package com.example.livewallpaper_project;

import android.service.wallpaper.WallpaperService;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class MyWallpaperService extends WallpaperService {

    @Override
    public Engine onCreateEngine() {
        return new MyWallpaperEngine();
    }

    class MyWallpaperEngine extends Engine {
        private Paint paint = new Paint();
        private boolean visible = true;
        private Thread drawThread;

        MyWallpaperEngine() {
            paint.setColor(0xFF0099CC);
            paint.setStyle(Paint.Style.FILL);

            drawThread = new Thread(() -> {
                while (true) {
                    if (visible) {
                        SurfaceHolder holder = getSurfaceHolder();
                        Canvas canvas = holder.lockCanvas();
                        if (canvas != null) {
                            canvas.drawColor(0xFF000000);
                            canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, 200, paint);
                            holder.unlockCanvasAndPost(canvas);
                        }
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            drawThread.start();
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            this.visible = visible;
        }
    }
                          }
