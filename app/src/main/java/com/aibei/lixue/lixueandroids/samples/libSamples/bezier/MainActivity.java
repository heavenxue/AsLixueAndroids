package com.aibei.lixue.lixueandroids.samples.libSamples.bezier;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aibei.lixue.lixueandroids.R;
import com.aibei.lixue.lixuelib.utils.PackageManagerUtils;


public class MainActivity extends Activity implements View.OnClickListener {
//    EditText edit_query ;
    Button btn_jump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView(){
//        edit_query = (EditText) findViewById(R.id.edit_query);
        btn_jump = (Button) findViewById(R.id.btn_plugin);
    }

    private void initData(){
        btn_jump.setOnClickListener(this);
//        Drawable orginalDrawable = edit_query.getBackground();
//        edit_query.setBackgroundDrawable(tintDrawable(orginalDrawable, ColorStateList.valueOf(Color.GREEN)));
//        invokeEditTextCallCursorDrawable(edit_query);
    }

    @Override
    public void onClick(View view) {
        if (PackageManagerUtils.isInstalled(getBaseContext(),"com.lixue.pictureplayer")){
            ComponentName componentName = new ComponentName("com.lixue.pictureplayer","com.lixue.pictureplayer.MainActivity");
            Intent intent = new Intent();
            intent.putExtra("ok","ok");
            intent.setComponent(componentName);
            startActivity(intent);
        }else{
            Toast.makeText(getBaseContext(),"您没有安装另一个apk",Toast.LENGTH_SHORT).show();
        }
    }

//    private Drawable tintDrawable(Drawable drawable,ColorStateList colors){
//        Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
//        DrawableCompat.setTintList(wrappedDrawable,colors);
//        return wrappedDrawable;
//    }

    //参数就是要反射修改光标的edittext对象
//    private void invokeEditTextCallCursorDrawable(EditText et) {
//        try {
//            Field fCursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
//            // 看源码知道 这个变量不是public的 所以要设置下这个可访问属性
//            fCursorDrawableRes.setAccessible(true);
//            //取得 editext对象里的mCursorDrawableRes 属性的值 看源码知道这是一个int值
//            int mCursorDrawableRes = fCursorDrawableRes.getInt(et);
//            //下面的代码 是通过获取mEditor对象 然后再通过拿到的mEditor对象来获取最终我们的mCursorDrawable这个光标的drawable
//            Field fEditor = TextView.class.getDeclaredField("mEditor");
//            fEditor.setAccessible(true);
//            Object editor = fEditor.get(et);
//            Class<?> clazz = editor.getClass();
//            Field fCursorDrawable = clazz.getDeclaredField("mCursorDrawable");
//            fCursorDrawable.setAccessible(true);
//            if (mCursorDrawableRes <= 0) {
//                return;
//            }
//            //到这里 我们终于拿到了默认主题下 edittext的光标的那个小图标的drawable
//            Drawable cursorDrawable = et.getContext().getResources().getDrawable(mCursorDrawableRes);
//            if (cursorDrawable == null) {
//                return;
//            }
//            //既然都拿到了这个drawble 那就修改他。
//            Drawable tintDrawable = tintDrawable(cursorDrawable, ColorStateList.valueOf(Color.GREEN));
//            //前面贴出的mCursorDrawable源码 可以知道 这是一个二维数组。所以我们要构造出一个全新的二维数组
//            Drawable[] drawables = new Drawable[]{tintDrawable, tintDrawable};
//            //然后再通过反射 把这个二维数组的值 放到editor里面 即可！
//            fCursorDrawable.set(editor, drawables);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//    }
}
