/**
 *
 */
package com.example.administrator.android_test2;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author allin
 *
 */
public class simpleadapter_test2_1 extends Activity{

    private String[] name = { "Lion", "Tiger", "Monkey", "Dog","Cat","Elephant" };

    private int[] imageids = { R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog,R.drawable.cat,R.drawable.elephant };
    private ListView lt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        List<Map<String, Object>> listems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> listem = new HashMap<String, Object>();
            listem.put("head", imageids[i]);
            listem.put("name", name[i]);
            listems.add(listem);
        }
        SimpleAdapter simplead = new SimpleAdapter(this, listems,
                R.layout.androidtest2_1_simpleadapter, new String[]{"name", "head"},
                new int[]{R.id.name, R.id.img});
        lt1 = (ListView)findViewById(R.id.lt1);
        lt1.setAdapter(simplead);
        lt1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object> map = (HashMap<String,Object> )lt1.getItemAtPosition(position);
                String Name = (String) map.get("name");
                Toast.makeText(getApplicationContext(),Name,Toast.LENGTH_SHORT).show();
            }
        });

    }


}
