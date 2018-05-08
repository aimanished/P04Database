package com.example.a16031940.p04database;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    Button btnGetTasks;
    TextView tv;
    ListView lv;
    ArrayList<Task> taskArray;
    ArrayAdapter<Task> AA;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGettasks);

        taskArray = new ArrayList<Task>();
        tv = findViewById(R.id.tv);
        lv = findViewById(R.id.lv);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                db.insertData("submit RJ", "8 May 2018");
                db.close();
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<String> data = db.getTaskContent();
                db.close();

                String txt = "";
                String date = "";
                String description = "";
                for (int i = 0; i < data.size(); i++) {
                    //Log.d("Database Content", i + ". " + data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tv.setText(txt);


                DBHelper db2 = new DBHelper(MainActivity.this);

                taskArray = db2.getTasks();
                AA = new TaskArrayAdapter(MainActivity.this, R.layout.row, taskArray);
                lv.setAdapter(AA);
                Toast.makeText(MainActivity.this, "" + taskArray.size(), Toast.LENGTH_LONG).show();

                db2.close();
            }
        });


    }


}
