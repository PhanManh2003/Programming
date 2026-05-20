package com.example.eventdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TouchActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
//        ((LinearLayout) findViewById(R.id.ln_touch)).setOnTouchListener(new View.OnTouchListener(){
//            @Override
//            public boolean onTouch(View v, MotionEvent m) {
//                Log.d("TouchActivity", "pointerCount = " + m.getPointerCount());
//                Log.d("TouchActivity", "x = " + m.getX());
//                Log.d("TouchActivity", "y = " + m.getY());
//                return true;
//            }
//        });
        gestureDetector = new GestureDetector(this,this);
    }

    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
    @Override
    public boolean onDown(@NonNull MotionEvent motionEvent) {
        Log.d("TouchTest", "onDown");
        return false;
    }

    @Override
    public boolean onFling(@Nullable MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        Log.d("TouchTest", "onFling");
        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent motionEvent) {
        Log.d("TouchTest", "onLongPress");

    }

    @Override
    public boolean onScroll(@Nullable MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        Log.d("TouchTest", "onScroll");
        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent motionEvent) {
        Log.d("TouchTest", "onShowPress");
    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
        Log.d("TouchTest", "onSingleTapUp");
        return false;
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent motionEvent) {
        Log.d("TouchTest", "onDoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent motionEvent) {
        Log.d("TouchTest", "onDoubleTapEvent");
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent motionEvent) {
        Log.d("TouchTest", "onSingleTapConfirmed");
        return false;
    }
}