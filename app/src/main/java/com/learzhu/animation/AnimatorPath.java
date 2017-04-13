package com.learzhu.animation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ${className}.java是极搜浏览器的$DES$类。
 *
 * @author Learzhu
 * @version 3.0.0 2017/4/13 21:18
 * @update Learzhu 2017/4/13 21:18
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

public class AnimatorPath {
    //路径集合
    List<PathPoint> mPathPoints = new ArrayList<>();

    public void moveTo(int x, int y) {
        mPathPoints.add(PathPoint.moveTo(x, y));
    }

    public void lineTo(int x, int y) {
        mPathPoints.add(PathPoint.lineTo(x, y));
    }

    public void cubicTo(float c0x, float c0y, float c1x, float c1y, float x, float y) {
        mPathPoints.add(PathPoint.cubicTo(c0x, c0y, c1x, c1y, x, y));
    }

    public Collection<PathPoint> getPoints() {
        return mPathPoints;
    }

}
