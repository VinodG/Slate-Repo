package com.example.slate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int ROW = 3;
    private static final int COLUMN = 3;
    private static int WIDTH = 3;
    private static   int HEIGHT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        HEIGHT = displayMetrics.heightPixels;
        WIDTH = displayMetrics.widthPixels;
        WIDTH = (int)(WIDTH/3);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_example);
        int count =0;
        for (int i = 0 ;i<ROW;i++)
        {
            LinearLayout layout =new LinearLayout(this);
            layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,WIDTH));
            layout.setOrientation(LinearLayout.HORIZONTAL);
            for (int j=0;j<COLUMN;j++ )
            {
                ImageView iv = new ImageView(this);
                iv.setLayoutParams(new LinearLayout.LayoutParams(WIDTH, WIDTH));
                iv.setImageResource(R.mipmap.ic_launcher_round);
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
                iv.setBackgroundColor(0xff66ff66); // hex color 0xAARRGGBB
                iv.setId(++count);
                iv.setOnClickListener(this);
                layout.addView(iv);
            }
            linearLayout.addView(layout);
        }

        // Add textview 2
//        TextView textView2 = new TextView(this);
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//        layoutParams.gravity = Gravity.RIGHT;
//        layoutParams.setMargins(10, 10, 10, 10); // (left, top, right, bottom)
//        textView2.setLayoutParams(layoutParams);
//        textView2.setText("programmatically created TextView2");
//        textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
//        textView2.setBackgroundColor(0xffffdbdb); // hex color 0xAARRGGBB
//        linearLayout.addView(textView2);
    }

    @Override
    public void onClick(View v)
    {
        String str=   v.getId()+"";
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();


    }
}
