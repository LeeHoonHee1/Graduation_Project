package com.example.graduation_project.Login;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface User_Dao {
    @Query("SELECT * FROM MEMBERS")
    List<User_Info> getAll();
    @Query("SELECT * FROM MEMBERS WHERE id = :userId")
    User_Info getUserById(String userId);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUserInfo(User_Info user_info);

}