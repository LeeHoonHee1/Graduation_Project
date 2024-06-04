package com.example.graduation_project.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.graduation_project.R;

public class Join_Activity extends AppCompatActivity {

    Button btn_close,btn_login;

    EditText et_id,et_pass,et_name,et_email;

    String id,pw,name,email;

    private User_Database db;

    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        // Room 데이터베이스 초기화
        db = Room.databaseBuilder(getApplicationContext(),
                User_Database.class, "userinfo_db").build();

        btn_close = findViewById(R.id.btn_close);
        btn_login = findViewById(R.id.btn_login);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);

        thread = new InsertThread();

        btn_login.setOnClickListener(v -> {

            id = et_id.getText().toString();
            pw = et_pass.getText().toString();
            name = et_name.getText().toString();
            email = et_email.getText().toString();


            if (id.isEmpty() || pw.isEmpty() || name.isEmpty() || email.isEmpty()){
                Toast.makeText(getApplicationContext(),"정보를 전부 입력해주세요!",Toast.LENGTH_SHORT).show();
                return;
            }else {
                try {
                    thread.start();
                    thread.join();
                    Toast.makeText(getApplicationContext(),"회원가입 완료!",Toast.LENGTH_SHORT).show();
                    finish();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    class InsertThread extends Thread{
        @Override
        public void run() {
            db.UserDaoDao().insertUserInfo(new User_Info(id,pw,name,email));
            super.run();
        }
    }
}
