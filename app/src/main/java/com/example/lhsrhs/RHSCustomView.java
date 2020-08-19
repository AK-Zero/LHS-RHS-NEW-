package com.example.lhsrhs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class RHSCustomView extends View implements inter{

    Paint paint;
    Path path;
    static inter lhs;
    public RHSCustomView(Context context) {
        super(context);
        init(null);
    }

    public RHSCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RHSCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){
        paint = new Paint();
        path = new Path();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(15f);
        LHSCustomView.setRhs(RHSCustomView.this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path , paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value =  super.onTouchEvent(event);

        float x = event.getX();
        float y = event.getY();
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN : {
                lhs.setmover(x,y);
                path.moveTo(x,y);
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                lhs.sendcord(x,y);
                path.lineTo(x,y);
                postInvalidate();
                return value;
            }
            case MotionEvent.ACTION_UP : {
                return value;
            }
        }
        return value;
    }

    public static void setLhs(inter lhs) {
        RHSCustomView.lhs = lhs;
    }

    @Override
    public void sendcord(float x, float y) {
        path.lineTo(x,y);
        postInvalidate();
    }

    @Override
    public void setmover(float x, float y) {
        path.moveTo(x,y);
    }
}
