package com.example.jinglion.gamedemo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jinglion.gamedemo.elos.Elos;

import java.util.ArrayList;
import java.util.List;

public class Square extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PackageManager pm = getPackageManager();
        Intent mainIntent = new Intent("SQUARE", null);
        mainIntent.addCategory("android.intent.category.SQUARE");
        //返回给定条件的所有ResolveInfo对象(本质上是Activity)，集合对象
        List<ResolveInfo> ls = pm.queryIntentActivities(mainIntent, 0);

        int i = 0;
        ArrayList<String> al = new ArrayList<String>();
        setTitle(String.valueOf(ls.size()));

        while(i<ls.size()){
            ResolveInfo ri = ls.get(i);
            al.add(ri.loadLabel(pm).toString());
            i++;
        }
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,al);

        ListView lv = (ListView) this.findViewById(R.id.lv);
        lv.setAdapter(a);
        lv.setOnItemClickListener(new ItemClickListener());

    }

    private class ItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String strText = ((TextView)view).getText().toString();

            if (strText == null) return;
            else if (strText.equals("俄罗斯方块")){
                Intent in = new Intent(Square.this, Elos.class);
                startActivity(in);
            }
        }
    }
}
