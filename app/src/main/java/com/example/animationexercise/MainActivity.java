package com.example.animationexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    View myview;
    ConstraintLayout mylayout;
    int height = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myview = findViewById(R.id.viewtoanimate);

        // measuring height of the view
        mylayout = findViewById(R.id.mylayout);
        ViewTreeObserver vto = mylayout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    mylayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    mylayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width  = mylayout.getMeasuredWidth();
                height = mylayout.getMeasuredHeight();

                int viewHeight = myview.getMeasuredHeight();

                Float heightnew = Float.valueOf(height-viewHeight);

                ObjectAnimator animation = ObjectAnimator.ofFloat(myview, "translationY", heightnew);
                animation.setDuration(2000);
                animation.start();


            }
        });


    }

    private int getHeight()
    {

        Toast.makeText(this, String.valueOf( height), Toast.LENGTH_SHORT).show();


        return height;
    }


}
