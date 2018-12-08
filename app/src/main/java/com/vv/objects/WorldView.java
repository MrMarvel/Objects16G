package com.vv.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;



public class WorldView extends View {
    public static final List<Animal> animals = new ArrayList<Animal>();
    private final Calculator calculator = new Calculator();

    public WorldView(Context context) {
        super(context);
        this.setBackgroundColor(Color.BLACK);
        for (int i = 0; i <  10; i++){
            animals.add(new Penguin());
        }
        //Не играет роли
    }

    public WorldView(Context context, AttributeSet attrs) {
        super(context, attrs);


        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;



        this.setBackgroundColor(Color.BLACK);
        for (int i = 0; i < 1; i++) {
            animals.add(new Bear());
        }
        //animals.add(new Animal(800,700,0,0, 1, 120));
        //animals.add(new Animal(400,300,2.5f,2.0f, 1, 120));
        //animals.add(new Animal(400,300,0,0, 10000, 120));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i <  animals.size(); i++){
            int c  = 0;
            Calculator.calca(i);
            c = Calculator.checks(i);
            if (c == 2) i--;
            if (c != -1) {
                animals.get(i).step();
                animals.get(i).draw(canvas);
            }
        }
        invalidate();
    }








    public void createPenguin () {
        animals.add(new Penguin());
    }
}
