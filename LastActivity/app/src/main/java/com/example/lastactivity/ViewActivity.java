package com.example.lastactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
        import android.content.Context;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Path;
        import android.graphics.RectF;
        import androidx.annotation.Nullable;
        import android.util.AttributeSet;
        import android.view.View;

/**
 * 这里是画转盘的
 * @author hasee
 */
public class ViewActivity extends View{
    Paint mPaint;
    int mCircleCount = 6;
    float mStartAngle = 0;

    RectF rectF; //转盘位置
    RectF rectF1;//文字位置

    public ViewActivity(Context context) {
        super(context);
        init();
    }
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.r7", appContext.getPackageName());
    }
    public ViewActivity(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10);
        mPaint.setTextSize(60);
        mPaint.setStyle(Paint.Style.FILL);

        rectF = new RectF();
        rectF.top = 100;
        rectF.left = 100;
        rectF.right = 1000;
        rectF.bottom = 1000;

        rectF1 = new RectF();
        rectF1.top = 200;
        rectF1.left = 200;
        rectF1.right = 900;
        rectF1.bottom = 900;
    }
    String[] textColor = {"炒 粉","炒 冰","烤 鱼","椰 子","盖 饭","烤 肉"};
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i = 0; i < mCircleCount; i++){
            //按角标单双号设置扇形颜色，
            if(i % 2 == 0 ){
                mPaint.setColor(Color.CYAN);
            }else{
                mPaint.setColor(Color.LTGRAY);
            }
            canvas.drawArc(rectF, mStartAngle, 60, true, mPaint);
            //设置转盘上的文字
            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(55);
            Path path = new Path();
            path.addArc(rectF1,mStartAngle+25,60);
            canvas.drawTextOnPath(textColor[i],path,-10,40,mPaint);
            mStartAngle += 60;
        }
    }
}