package com.aibei.lixue.lixueandroids.thirdframes.blockcanaryDemo;

import com.github.moduth.blockcanary.BlockCanaryContext;

/**
 * 作者：lixue on 2019/7/24 14:49
 */

public class AppBlockContext extends BlockCanaryContext {
    //实现各种上下文，包括应用提示符，用户uid,网络类型，卡慢判断阈值，Log保存位置等
    public String provideQualifier(){
        return "unknown";
    }

    public String provideUid(){
        return "uid";
    }

    public String provideNetworkType(){
        return "unknown";
    }

    public int provideMonitorDuration(){
        return -1;
    }

    public int provideBlockThreshold(){
        return 1000;
    }
}
