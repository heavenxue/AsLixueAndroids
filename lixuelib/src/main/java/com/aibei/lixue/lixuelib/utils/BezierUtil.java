package com.aibei.lixue.lixuelib.utils;

import android.graphics.PointF;

/**
 * 计算贝塞尔曲线上的坐标
 * Created by Administrator on 2016/7/26.
 */
public class BezierUtil {
    /**
     * B(t) = (1 - t)^2 * P0 + 2t * (1 - t) * P1 + t^2 * P2, t ∈ [0,1]
     * 二阶贝塞尔曲线
     * @param t  曲线长度比例
     * @param p0 起始点
     * @param p1 控制点
     * @param p2 终止点
     * @return t对应的点
     */
    public static PointF CalculateBezierPointForQuadratic(float t, PointF p0, PointF p1, PointF p2) {
        PointF point = new PointF();
        float temp = 1 - t;
        point.x = temp * temp * p0.x + 2 * t * temp * p1.x + t * t * p2.x;
        point.y = temp * temp * p0.y + 2 * t * temp * p1.y + t * t * p2.y;
        return point;
    }

    /**
     *  /**
     * B(t) = P0 * (1-t)^3 + 3 * P1 * t * (1-t)^2 + 3 * P2 * t^2 * (1-t) + P3 * t^3, t ∈ [0,1]
     * 三阶贝塞尔曲线
     * @param t  曲线长度比例
     * @param p0 起始点
     * @param p1 控制点1
     * @param p2 控制点2
     * @param p3 终止点
     * @return t对应的点
     */
    public static PointF CalculateBezierPointForCubic(float t,PointF p0,PointF p1,PointF p2,PointF p3){
        PointF pointF = new PointF();
        float tmp = 1 - t;
        pointF.x = p0.x * tmp * tmp *tmp + 3 * p1.x * t * tmp * tmp + 3 * p2.x * t * t * tmp + p3.x * t * t * t;
        pointF.y = p0.y * tmp * tmp *tmp + 3 * p1.y * t * tmp * tmp + 3 * p2.y * t * t * tmp + p3.y * t * t * t;
        return pointF;
    }

}
