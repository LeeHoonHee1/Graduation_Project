package com.example.graduation_project.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.graduation_project.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class Login_Activity extends Fragment {

    Button btn_register, btn_login;

    EditText et_id, et_pw;
    private User_Database db;
    Thread thread;

    String id, pw;

    User_Info user_info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        //바텀 네비게이션 숨기기
        /*BottomNavigationView bottomNav = getActivity().findViewById(R.id.bottomNavi);
        if (bottomNav != null) {
            bottomNav.setVisibility(View.GONE);
        }*/

        // Room 데이터베이스 초기화
        db = Room.databaseBuilder(getContext(),
                User_Database.class, "userinfo_db").build();

        btn_register = view.findViewById(R.id.btn_register);
        btn_login = view.findViewById(R.id.btn_login);
        et_id = view.findViewById(R.id.et_id);
        et_pw = view.findViewById(R.id.et_pass);

        btn_login.setOnClickListener(v -> {
            id = et_id.getText().toString();
            pw = et_pw.getText().toString();

            if (id.isEmpty() || pw.isEmpty()) {
                Toast.makeText(getContext(), "정보를 다 입력해주세요!", Toast.LENGTH_SHORT).show();
                return;
            }

            // 비동기로 데이터베이스에서 사용자 정보 가져오기
            /*AsyncTask.execute(() -> {
                user_info = db.UserDaoDao().getUserById(id);

                // UI 업데이트를 메인 스레드에서 수행
                getActivity().runOnUiThread(() -> {
                    if (user_info != null) {
                        if (user_info.pw.equals(pw)) {
                            // 로그인 성공시
                            Toast.makeText(getContext(), "로그인 성공!", Toast.LENGTH_SHORT).show();

                            // MainActivity의 메서드를 호출하여 Frag1으로 이동
                            ((MainActivity) getActivity()).onLoginSuccess();

                        } else {
                            Toast.makeText(getContext(), "아이디 또는 패스워드가 틀렸습니다!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "아이디 또는 패스워드가 틀렸습니다!", Toast.LENGTH_SHORT).show();
                    }
                });
            });*/
        });

        btn_register.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Join_Activity.class);
            startActivity(intent);
        });
        return view;
    }
}
