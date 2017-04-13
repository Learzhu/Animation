package com.learzhu.animation;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/4/13 21:30
 * @update Learzhu 2017/4/13 21:30
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class PathPoint {
    public static final int MOVE = 0;
    public static final int LINE = 1;
    public static final int CUBIC = 2;

    //保存操作的类型
    int mOperation;

    float mX, mY;
    float mControl0X, mControl0Y;
    float mControl1X, mControl1Y;


    public PathPoint(int operation, float x, float y) {
        mOperation = operation;
        mX = x;
        mY = y;
    }

    public PathPoint(int operation, float c0x, float c0y, float c1x, float c1y, float x, float y) {
        mOperation = operation;
        mX = x;
        mY = y;
        mControl0X = c0x;
        mControl0Y = c0y;
        mControl1X = c1x;
        mControl1Y = c1y;
    }

    public static PathPoint moveTo(int x, int y) {
        return new PathPoint(MOVE, x, y);
    }

    public static PathPoint lineTo(int x, int y) {
        return new PathPoint(LINE, x, y);
    }

    public static PathPoint cubicTo(float c0x, float c0y, float c1x, float c1y, float x, float y) {
        return new PathPoint(CUBIC, c0x, c0y, c1x, c1y, x, y);
    }

}
