package com.example.jinglion.gamedemo.elos;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.jinglion.gamedemo.R;

/**
 * Created by jinglion on 2015-10-28.
 */
public class Elos  extends Activity{

    private ElosView evElos = null;
    private ElosStateView esvElos = null;


    private Rect rtElosArea = new Rect();


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.elos);

        LinearLayout ll = (LinearLayout) this.findViewById(R.id.elos);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);
        params.leftMargin = 1;
        params.rightMargin = 1;
        params.weight = 1;
        ll.addView(evElos = new ElosView(this), params);

        params = new LinearLayout.LayoutParams(params);
        params.weight = 4;
        ll.addView(esvElos = new ElosStateView(this), params);


    }


    private class ElosView extends View {

        public ElosView(Context context) {
            super(context);
        }
        int vvvv = 0;

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint pt = new Paint();
            Rect rt = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
            rtElosArea.set(rt);
            pt.setColor(Color.WHITE);
            
        }
    }

    private class ElosStateView extends View{

        public ElosStateView(Context context) {
            super(context);
        }
    }

}
