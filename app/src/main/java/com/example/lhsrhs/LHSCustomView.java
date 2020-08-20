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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LHSCustomView extends View implements inter {

    List<Paint> paints = new ArrayList<>();
    Paint paint1;
    int paintstat = 0;
    List<Path> patherasers = new ArrayList<>();
    List<Path> paths = new ArrayList<>();
    static inter rhs;
    boolean reseter = false;
    List<Integer> index = new ArrayList<>();

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

    private void init(@Nullable AttributeSet set) {
        paints.add(new Paint());
        paint1 = new Paint();
        paths.add(new Path());
        paints.get(0).setAntiAlias(true);
        paints.get(0).setColor(Color.BLUE);
        paints.get(0).setStyle(Paint.Style.STROKE);
        paints.get(0).setStrokeJoin(Paint.Join.ROUND);
        paints.get(0).setStrokeWidth(15f);
        paint1.setAntiAlias(true);
        paint1.setColor(getResources().getColor(R.color.xax));
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeJoin(Paint.Join.ROUND);
        paint1.setStrokeWidth(25f);
        RHSCustomView.setLhs(LHSCustomView.this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < paths.size(); i++) {
            canvas.drawPath(paths.get(i), paints.get(i));
            for (int j = 0; j < index.size(); j++) {
                if (i == index.get(j)) {
                    canvas.drawPath(patherasers.get(j), paint1);
                }
            }
        }
        if(paintstat==1) {
            canvas.drawPath(patherasers.get(patherasers.size()-1), paint1);
        }
        if (reseter) {
            canvas.drawColor(Color.WHITE);
            reseter = false;
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                rhs.setmover(x, y);
                if (paintstat == 0) {
                    paths.get(paths.size() - 1).moveTo(x, y);
                } else {
                    patherasers.get(patherasers.size()-1).moveTo(x, y);
                }
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                rhs.sendcord(x, y);
                if (paintstat == 0) {
                    paths.get(paths.size() - 1).lineTo(x, y);
                } else {
                    patherasers.get(patherasers.size()-1).lineTo(x, y);
                }
                postInvalidate();
                return value;
            }
            case MotionEvent.ACTION_UP: {
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
        if (paintstat == 0) {
            paths.get(paths.size() - 1).lineTo(x, y);
        } else {
            patherasers.get(patherasers.size()-1).lineTo(x, y);
        }
        postInvalidate();
    }

    @Override
    public void setmover(float x, float y) {
        if (paintstat == 0) {
            paths.get(paths.size() - 1).moveTo(x, y);
        } else {
            patherasers.get(patherasers.size()-1).moveTo(x, y);
        }
    }

    public void reset() {
        reseter = true;
        paths.clear();
        patherasers.clear();
        paints.clear();
        patherasers.add(new Path());
        paths.add(new Path());
        paints.add(new Paint());
        paints.get(0).setAntiAlias(true);
        paints.get(0).setColor(Color.BLUE);
        paints.get(0).setStyle(Paint.Style.STROKE);
        paints.get(0).setStrokeJoin(Paint.Join.ROUND);
        paints.get(0).setStrokeWidth(15f);
        postInvalidate();
    }

    public void eraser() {
        if (paintstat == 0) {
            paintstat = 1;
            index.add(paths.size() - 1);
            patherasers.add(new Path());
        } else {
            paths.add(new Path());
            paints.add(paints.get(paints.size()-1));
            paintstat = 0;
        }
    }

    public void changecolor() {
        Calendar C = Calendar.getInstance();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(15f);

        if (C.getTimeInMillis() % 9 == 0) {
            paint.setColor(Color.RED);
        } else if (C.getTimeInMillis() % 9 == 1) {
            paint.setColor(Color.BLACK);
        } else if (C.getTimeInMillis() % 9 == 2) {
            paint.setColor(Color.BLUE);
        } else if (C.getTimeInMillis() % 9 == 3) {
            paint.setColor(Color.MAGENTA);
        } else if (C.getTimeInMillis() % 9 == 4) {
            paint.setColor(Color.YELLOW);
        } else if (C.getTimeInMillis() % 9 == 5) {
            paint.setColor(Color.DKGRAY);
        } else if (C.getTimeInMillis() % 9 == 6) {
            paint.setColor(Color.CYAN);
        } else if (C.getTimeInMillis() % 9 == 7) {
            paint.setColor(Color.GREEN);
        } else if (C.getTimeInMillis() % 9 == 8) {
            paint.setColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        paints.add(paint);
        paths.add(new Path());
    }
}
