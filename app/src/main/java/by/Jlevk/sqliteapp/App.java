package by.Jlevk.sqliteapp;

import android.app.Application;
import androidx.room.Room;
import by.Jlevk.sqliteapp.model.dao.UserDao;
import by.Jlevk.sqliteapp.model.database.UsersDatabase;

public class App extends Application {

    private UserDao userDao;

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        userDao = Room.databaseBuilder(
                this,
                UsersDatabase.class,
                "usersDatabase"
        ).allowMainThreadQueries()
                .build().getUserDao();
    }

    public static App getInstance() {
        return instance;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}