/**
 *
 */
package com.example.administrator.myfirst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Toast;
/**
 * @author allin
 *
 */
public class simpleadapter_test2_1 extends Activity {
    private ListView listv;
    private String[] name = { "Lion", "Tiger", "Monkey", "Dog","Cat","Elephant" };

    private int[] imageids = { R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog,R.drawable.cat,R.drawable.elephant };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        listv = (ListView)findViewById(R.id.lt1);
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

        listv.setAdapter(simplead);
        listv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
            // TODO Auto-generated method stub
                HashMap<String, Object> map = (HashMap<String, Object>) parent
                        .getItemAtPosition(position);
                Toast.makeText(simpleadapter_test2_1.this, "选择是："+map.get("name"),Toast.LENGTH_LONG).show();
            }
        });

    }


}
