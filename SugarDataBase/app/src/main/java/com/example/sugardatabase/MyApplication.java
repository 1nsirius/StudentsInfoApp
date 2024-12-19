package com.example.sugardatabase;

import android.util.Log;
import android.app.Application;
import com.orm.SugarContext;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this); // Инициализация Sugar ORM
        Log.d("DatabaseCheck", "Database initialized");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate(); // Завершение работы Sugar ORM
    }
}