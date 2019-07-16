package com.aibei.lixue.lixuelib.utils;

import android.text.TextUtils;
import android.util.Log;

public class LogUtil {

    public static final String MSG_SIGN = "----dataCollect---";

    /**
     * 日志输出格式: 时间 +日志内容   时间格式: "yyyy-MM-dd HH:mm:ss"
     * 文件日志内容输出格式 ： 文件名---函数名---输出内容
     */
    public static void e(String fileName, String funName, String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Log.e(fileName, getFunctionName());
            Log.e(fileName, MSG_SIGN + fileName + "--" + msg);
        }
    }

    public static void i(String fileName, String funName, String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Log.i(fileName, getFunctionName());
            Log.i(fileName, MSG_SIGN + fileName + "--" + msg);
        }
    }

    /**
     * 日志输出格式: 时间 +日志内容   时间格式: "yyyy-MM-dd HH:mm:ss"
     * 文件日志内容输出格式 ： 文件名---函数名---输出内容
     */
    public static void e2cp(String fileName, String funName, String msg) {
        Log.e(fileName, getFunctionName());
        Log.e(fileName, MSG_SIGN + fileName + "--" + msg);
    }

    public static void d(String tag, String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Log.d(tag, getFunctionName());
            Log.d(tag, MSG_SIGN + tag + "--"  + msg);
        }
    }

    /**
     * 输出到控制台
     *
     * @param msg
     */
    public static void e(String tag, String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Log.e(tag, getFunctionName());
            Log.e(tag, MSG_SIGN + tag + "--" + msg);
        }
    }

    public static void i(String tag, String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Log.i(tag, getFunctionName());
            Log.i(tag, MSG_SIGN + tag + "--" + msg);
        }
    }

    private static String getFunctionName() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts != null) {
            for (StackTraceElement st : sts) {
                if (st.isNativeMethod()) {
                    continue;
                }
                if (st.getClassName().equals(Thread.class.getName())) {
                    continue;
                }
                if (st.getClassName().equals(LogUtil.class.getName())) {
                    continue;
                }
//                return "[ Thread:" + Thread.currentThread().getName() + ", at " + st.getClassName() + "." + st.getMethodName()
//                        + "(" + st.getFileName() + ":" + st.getLineNumber() + ")" + " ]";
                return "[" + st.getMethodName() + "(" + st.getFileName() + ":" + st.getLineNumber() + ")" + "]";
            }
        }
        return null;
    }

}
