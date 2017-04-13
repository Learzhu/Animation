package com.learzhu.animation;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/4/13 22:00
 * @update Learzhu 2017/4/13 22:00
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class PathEvaluator implements android.animation.TypeEvaluator<PathPoint> {

    @Override
    public PathPoint evaluate(float t, PathPoint startValue, PathPoint endValue) {
        float x = 0, y = 0;
        if (endValue.mOperation == PathPoint.CUBIC) {
            //贝塞尔曲线
            float oneMinusT = 1 - t;
            x = oneMinusT * oneMinusT * oneMinusT * startValue.mX + 3 * oneMinusT * oneMinusT * t * endValue.mControl0X +
                    3 * oneMinusT * t * t * endValue.mControl1X + t * t * t * endValue.mX;
            y = oneMinusT * oneMinusT * startValue.mY
                    + 3 * oneMinusT * oneMinusT * t * endValue.mControl0Y +
                    3 * oneMinusT * t * t * endValue.mControl1Y + t * t * t * endValue.mY;
            return PathPoint.cubicTo();
        } else if (endValue.mOperation == PathPoint.LINE) {
            //直线运动方式
            x = startValue.mX + t * (endValue.mX - startValue.mX);
            y = startValue.mY + t * (endValue.mY - startValue.mY);
        } else {

        }
        return new PathPoint(x, y);
    }
}
