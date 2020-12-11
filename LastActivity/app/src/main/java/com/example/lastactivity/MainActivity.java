package com.example.lastactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
        import android.support.v4.app.*;
        import android.os.Bundle;
        import android.view.MotionEvent;
        import android.view.View;
        import android.view.animation.RotateAnimation;

        import com.example.lastactivity.R;
        import com.example.lastactivity.ViewActivity;
/**
 * 转盘
 * @author hasee
 */
public class MainActivity extends AppCompatActivity {

    ViewActivity ViewActivity;
    boolean isTouchInSide = false;
    float mDownX, mDownY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
Button startNormal=(Button) findViewById(R.id.start_diag_activity);
startNormal.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View v){
Intent intent=new Intent (MainActivity.this,NormalActivity.class);
startNormal(intent);
}
});
        initView();
    }

    private void initView() {
        ViewActivity = findViewById(R.id.custom);
 //findViewById(R.id.custom_inside).setOnClickListener(new View.OnClickListener() {
//@Override
 //public void onClick(View v) {
//float degrees = (float)(720 + Math.random() * 1000);
 //RotateAnimation rotateAnimation = new RotateAnimation(0, -degrees, 450, 450);
 //rotateAnimation.setDuration(5000);
 //rotateAnimation.setFillAfter(true);
 //customCircleView.startAnimation(rotateAnimation);
 //}
 //});

        findViewById(R.id.custom_inside).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN &&
                        event.getX() >500 &&
                        event.getX() < 600 &&
                        event.getY() > 500 &&
                        event.getY() < 600) {
                    isTouchInSide = true;
                    mDownX = event.getX();
                    mDownY = event.getY();
                    return true;
                }else if(event.getAction() == MotionEvent.ACTION_MOVE && (
                        event.getX() < mDownX -10 ||
                                event.getX() > mDownX + 10 ||
                                event.getY() < mDownY -10 ||
                                event.getY() > mDownY + 10) ){
                    isTouchInSide = false;
                } else if (event.getAction() == MotionEvent.ACTION_UP &&
                        event.getX() > mDownX -10 &&
                        event.getX() < mDownX + 10 &&
                        event.getY() > mDownY -10 &&
                        event.getY() < mDownY + 10 &&
                        isTouchInSide) {
                    float degrees = (float) (720 + Math.random() * 1000);
                    //RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY)
                    //fromDegrees为旋转的起始点,(pivotX,pivotY)为旋转点。pivotX为距离左侧的偏移量，pivotY为距离顶部的偏移量。
                    RotateAnimation rotateAnimation = new RotateAnimation(0, -degrees, 550, 550);
                    rotateAnimation.setDuration(5000);
                    rotateAnimation.setFillAfter(true);
                    ViewActivity.startAnimation(rotateAnimation);
                }
                isTouchInSide = false;
                return false;
            }
        });
    }
}
