package com.saber.cz.a1006tv;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    private RadioGroup radioGroup;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = (FrameLayout) findViewById(R.id.container_main);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_main);
        manager = getSupportFragmentManager();
        initRadioGroupListener();
        transaction = manager.beginTransaction();
        VideoFragment videoFragment = new VideoFragment();
        transaction.replace(R.id.container_main,videoFragment);
        transaction.commit();
        RadioButton button = (RadioButton) radioGroup.getChildAt(0);
        button.setChecked(true);


    }

    private void initRadioGroupListener() {

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.video:
                        transaction = manager.beginTransaction();
                        VideoFragment videoFragment = new VideoFragment();
                        transaction.replace(R.id.container_main,videoFragment);
                        transaction.commit();
                        break;
                    case R.id.cache:
                        transaction = manager.beginTransaction();
                        CacheFragment cacheFragment= new CacheFragment();
                        transaction.replace(R.id.container_main,cacheFragment);
                        transaction.commit();
                        break;
                    case R.id.zhibo:
                        break;
                    case R.id.tool:
                        transaction = manager.beginTransaction();
                        ToolFragment toolFragment = new ToolFragment();
                        transaction.replace(R.id.container_main,toolFragment);
                        transaction.commit();
                        break;
                    case R.id.setting:
                        transaction = manager.beginTransaction();
                        SettingFragment settingFragment = new SettingFragment();
                        transaction.replace(R.id.container_main,settingFragment);
                        transaction.commit();
                        break;
                }
            }
        });
    }
}
