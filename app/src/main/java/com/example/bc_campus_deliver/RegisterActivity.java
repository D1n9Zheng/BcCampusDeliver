package com.example.bc_campus_deliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private DBOpenHelper mDBOpenHelper;
    private EditText username;
    private EditText password1;
    private EditText password2;
    private Button btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mDBOpenHelper = new DBOpenHelper(this);

        username = findViewById(R.id.username);
        password1 = findViewById(R.id.password_once);
        password2 = findViewById(R.id.password_second);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String UserName = username.getText().toString().trim();
        String Password1 = password1.getText().toString().trim();
        String Password2 = password2.getText().toString().trim();

        if (!TextUtils.isEmpty(UserName) && !TextUtils.isEmpty(Password1) && !TextUtils.isEmpty(Password2) ) {
            if (Password1.equals(Password2)){
                mDBOpenHelper.add(UserName,Password1);
                Intent intent2 = new Intent(this,MainActivity.class);
                startActivity(intent2);
                Toast.makeText(this,  "验证通过，注册成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,"两次输入的密码不一致，请重新输入！",Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this,"信息不完善，请补充信息！",Toast.LENGTH_SHORT).show();
        }
    }
}