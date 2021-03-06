package test.study.appshelltest;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

/**
 * Created by marks on 2016/8/4.
 */
public class APP extends Application {
    private static Context sContext;
    private static APP sInstance;
    public static int SCREEN_WIDTH;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }


    private void init() {
        sContext = getApplicationContext();
        sInstance = this;
        ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point screen = new Point();
        SCREEN_WIDTH = Math.min(screen.x, screen.y);
    }

    public static Context getContext() {
        if (sContext == null) {
            throw new NullPointerException("APP Context is Null");
        }
        return sContext;
    }

    public static APP getInstance() {
        if (sInstance == null) {
            throw new NullPointerException("APP sInstance is Null");
        }
        return sInstance;
    }


}
