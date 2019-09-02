package com.aibei.lixue.lixuelib.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class PackageManagerUtils {
    /**
     * 判断应用是否已安装
     *
     * @param context
     * @param packageName
     * @return
     */
    public static boolean isInstalled(Context context, String packageName) {
        boolean hasInstalled = false;
        PackageManager pm = context.getPackageManager();
        // 参数 0表示不接受任何flag信息，当然也能够返回得到一些基本的包信息！
        // 但是如 PERMISSIONS  ，RECEIVERS  等等就返回不了，如果flag值不匹配 而方法中强行获取相对应的值，返回值为Null，已经做过测试
        List<PackageInfo> list = pm.getInstalledPackages(0);
        for (PackageInfo p : list) {
            if (packageName != null && packageName.equals(p.packageName)) {
                hasInstalled = true;
                break;
            }
        }
        return hasInstalled;
    }

    public static String getApplicationNameByPackageName(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        String Name;
        try {
            Name = pm.getApplicationLabel(pm.getApplicationInfo(packageName, PackageManager.GET_META_DATA)).toString();
        } catch (PackageManager.NameNotFoundException e) {
            Name = "";
        }
        return Name;
    }
}
