package com.aibei.lixue.lixuelib.utils;

import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.PointF;
import android.os.Build;

/**
 * 贝塞尔曲线动画插值器
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class BezierEvaluator implements TypeEvaluator<PointF> {

    private PointF mControlPoint;

    public BezierEvaluator(PointF controlPoint) {
        this.mControlPoint = controlPoint;
    }

    @Override
    public PointF evaluate(float t, PointF startValue, PointF endValue) {
        return BezierUtil.CalculateBezierPointForQuadratic(t, startValue, mControlPoint, endValue);
    }
}