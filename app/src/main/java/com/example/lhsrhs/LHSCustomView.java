package com.example.lhsrhs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.AttrRes;
import androidx.annotation.Nullable;

public class LHSCustomView extends View implements inter {

    Paint paint;
    Path path;
    static inter rhs;
    public LHSCustomView(Context context) {
        super(context);
        init(null);
    }

    public LHSCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public LHSCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){
        paint = new Paint();
        path = new Path();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(15f);
        RHSCustomView.setLhs(LHSCustomView.this);
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
                rhs.setmover(x,y);
                path.moveTo(x,y);
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                rhs.sendcord(x,y);
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

    public static void setRhs(inter rhs) {
        LHSCustomView.rhs = rhs;
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
