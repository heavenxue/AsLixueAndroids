package com.aibei.lixue.lixueandroids.thirdframes.butterknifeDemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.aibei.lixue.lixueandroids.R;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 *绑定注解：
 @BindView—->绑定一个view；id为一个view 变量
 @BindViews —-> 绑定多个view；id为一个view的list变量
 @BindArray—-> 绑定string里面array数组；@BindArray(R.array.city ) String[] citys ;
 @BindBitmap—->绑定图片资源为Bitmap；@BindBitmap( R.mipmap.wifi ) Bitmap bitmap;
 @BindBool —->绑定boolean值
 @BindColor —->绑定color；@BindColor(R.color.colorAccent) int black;
 @BindDimen —->绑定Dimen；@BindDimen(R.dimen.borth_width) int mBorderWidth;
 @BindDrawable —-> 绑定Drawable；@BindDrawable(R.drawable.test_pic) Drawable mTestPic;
 @BindFloat —->绑定float
 @BindInt —->绑定int
 @BindString —->绑定一个String id为一个String变量；@BindString( R.string.app_name ) String meg;


 更多事件注解：
 @OnClick—->点击事件
 @OnCheckedChanged —->选中，取消选中
 @OnEditorAction —->软键盘的功能键
 @OnFocusChange —->焦点改变
 @OnItemClick item—->被点击(注意这里有坑，如果item里面有Button等这些有点击的控件事件的，需要设置这些控件属性focusable为false)
 @OnItemLongClick item—->长按(返回真可以拦截onItemClick)
 @OnItemSelected —->item被选择事件
 @OnLongClick —->长按事件
 @OnPageChange —->页面改变事件
 @OnTextChanged —->EditText里面的文本变化事件
 @OnTouch —->触摸事件
 @Optional —->选择性注入，如果当前对象不存在，就会抛出一个异常，为了压制这个异常，可以在变量或者方法上加入一下注解,让注入变成选择性的,如果目标View存在,则注入, 不存在,则什么事情都不做

 ButterKnife的代码混淆：
 -keep class butterknife.** { *; }
 -dontwarn butterknife.internal.**
 -keep class **$$ViewBinder { *; }

 -keepclasseswithmembernames class * {
 @butterknife.* <fields>;
 }

 -keepclasseswithmembernames class * {
 @butterknife.* <methods>;
 }

 **/

public class ButterknifeDemoActivity extends AppCompatActivity {

    @BindView(R.id.btn_show)
    public Button btn;

    @BindString(R.string.app_name)
    public String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife_demo);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_show)
    public void showToast(){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
