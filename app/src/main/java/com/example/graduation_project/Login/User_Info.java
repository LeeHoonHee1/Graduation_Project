package com.example.graduation_project.Login;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "MEMBERS")
public class User_Info {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public String id;
    @ColumnInfo(name = "pw")
    public String pw;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "email")
    public String email;

    public User_Info( String id, String pw, String name, String email) {

        this.id = id;
        this.pw = pw;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }
    // 클래스 배열로 만들어서 추가된 친구 만큼 정보를 서버에서 받아 출력

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }
}
