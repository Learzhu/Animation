package com.learzhu.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import static android.view.FrameMetrics.ANIMATION_DURATION;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton mFab;

    private LinearLayout mFabContainer;
    private LinearLayout mControlsContainer;
    private static final float SCALE_FACTOR = 13f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onFabPressed(View view) {
        final float startX = mFab.getX();

        AnimatorPath animatorPath = new AnimatorPath();
        animatorPath.moveTo(0, 0);
        animatorPath.lineTo(100, 200);
        animatorPath.cubicTo(-200, 200, -400, 100, -600, 50);
//        animatorPath.lineTo(0,0);

//        ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", 0, 100);
//        ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", 0, 100);
        //属性动画 可以控制对象上的任何属性的值 setTranslationX();setAlpha()
//        ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "haha", 0, 100);
        ObjectAnimator animator = ObjectAnimator.ofObject(this, "haha", null, animatorPath.getPoints().toArray());
        animator.setDuration(ANIMATION_DURATION);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ImageButton mfab = mFab;
                //属性的动画
//                if (Math.abs(startX))
                mfab.animate().scaleXBy(SCALE_FACTOR).scaleY(SCALE_FACTOR);
            }
        });
        animator.start();
    }

    public void setHaha(PathPoint pathPoint) {
        mFab.setTranslationX(pathPoint.mX);
        mFab.setTranslationY(pathPoint.mY);
    }

    /**
     * 控制显示三个图标
     */
    private AnimatorListenerAdapter mAnimatorListenerAdapter = new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            mFab.setVisibility(View.INVISIBLE);
            mFabContainer.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            for (int i = 0; i < mControlsContainer.getChildCount(); i++) {
                View v = mControlsContainer.getChildAt(i);
                v.animate().scaleX(1).scaleY(1).setDuration(ANIMATION_DURATION);
                animation.setStartDelay(i * 70);
                animation.start();
            }
        }
    };
}
