package com.aibei.lixue.lixueandroids.MVC;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aibei.lixue.lixueandroids.R;

public class MVCActivity extends AppCompatActivity implements View.OnClickListener,OnSportsListener{
    private SportsModel sportsModel;

    private Button btn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        sportsModel = new SportsModelImpl();
        initView();
    }

    private void initView(){
        btn_go = findViewById(R.id.btn_go);
        btn_go.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_go:
                sportsModel.getSportsInfo("SDKFJ", this);
                break;
        }
    }

    @Override
    public void onSuccess() {
        displayResult();
    }

    @Override
    public void onFailure() {
        Toast.makeText(this, "获取消息失败", Toast.LENGTH_SHORT).show();
    }

    //显示结果
    private void displayResult(){

    }
}
