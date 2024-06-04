package com.example.graduation_project.Login;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User_Info.class}, version = 1, exportSchema = false)
public abstract class User_Database extends RoomDatabase {
    public abstract User_Dao UserDaoDao();
}