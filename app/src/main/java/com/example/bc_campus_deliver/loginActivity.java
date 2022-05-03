package com.example.bc_campus_deliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class loginActivity extends AppCompatActivity implements View.OnClickListener {

    private DBOpenHelper mDBOpenHelper;
    private EditText userName;
    private EditText passWord;
    private Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDBOpenHelper = new DBOpenHelper(this); //数据库实例化

        userName = findViewById(R.id.username_login);
        passWord = findViewById(R.id.password_login);
        btnlogin = findViewById(R.id.btn_login);

        btnlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = userName.getText().toString().trim();
        String password = passWord.getText().toString().trim();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
            ArrayList<User> data = mDBOpenHelper.getAllData();
            boolean match = false;
            for (int i = 0; i < data.size(); i++) {
                User user = data.get(i);
                if (name.equals(user.getName()) && password.equals(user.getPassword())) {
                    match = true;
                    break;
                } else {
                    match = false;
                }
            }
            if (match) {
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,UserActivity1.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
        }
    }
}