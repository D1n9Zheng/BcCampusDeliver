package com.example.bc_campus_deliver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.bc_campus_deliver.fragment.HelpbuyFragment;
import com.example.bc_campus_deliver.fragment.HomeFragment;
import com.example.bc_campus_deliver.fragment.MineFragment;
import com.example.bc_campus_deliver.fragment.OrderFragment;

public class UserActivity1 extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout home;
    private LinearLayout mine;
    private LinearLayout order;
    private ImageView im_order;
    private ImageView im_mine;
    private ImageView im_home;
    private HomeFragment homeFragment;
    private OrderFragment orderFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user1);

        inInt();

    }

    private void inInt(){ //初始化函数
        home = findViewById(R.id.id_tab_user1);
        order = findViewById(R.id.id_tab_user2);
        mine = findViewById(R.id.id_tab_user3);


        im_home = findViewById(R.id.tab_iv_user1);
        im_order = findViewById(R.id.tab_iv_user2);
        im_mine = findViewById(R.id.tab_iv_user3);
        home.setOnClickListener(this);
        order.setOnClickListener(this);
        mine.setOnClickListener(this);

        homeFragment = new HomeFragment();
        orderFragment = new OrderFragment();
        mineFragment = new MineFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fvc,homeFragment,null);
        fragmentTransaction.add(R.id.fvc,orderFragment,null);
        fragmentTransaction.add(R.id.fvc,mineFragment,null);
        fragmentTransaction.replace(R.id.fvc,homeFragment).commit();

        im_home.setSelected(true);

    }

    private void setAllImg(){ //将所有的图片都设置为灰色
        im_mine.setSelected(false);
        im_order.setSelected(false);
        im_home.setSelected(false);
    }
    @Override
    public void onClick(View view) {
        int a = view.getId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (a){
            case R.id.id_tab_user1:

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fvc,homeFragment).commit();

                setAllImg();
                im_home.setSelected(true);

                break;

            case R.id.id_tab_user2:

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fvc,orderFragment).commit();

                setAllImg();
                im_order.setSelected(true);

                break;
            case R.id.id_tab_user3:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fvc,mineFragment).commit();

                setAllImg();
                im_mine.setSelected(true);

                break;
        }

    }
}