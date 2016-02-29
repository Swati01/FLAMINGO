package com.example.advantal.flames;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by advantal on 23-Feb-16.
 */
public class Dactivity  extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView Area;
    EditText areaEnter;
    Button can,back,submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity1);

        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity1);
        } else {
            setContentView(R.layout.activity1_landscape);
        }

        can=(Button)findViewById(R.id.cancel);
        back=(Button)findViewById(R.id.back);
        submit=(Button)findViewById(R.id.submit);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Select State");
        categories.add("Karnataka");
        categories.add("Lakshadweep");
        categories.add("Kerala");
        categories.add("Tamil Nadu");
        categories.add("Puducherry");
        categories.add("Telagana");
        Area = (TextView) findViewById(R.id.textViewArea);
        areaEnter = (EditText) findViewById(R.id.Area);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        // back.setOnClickListener(new View.OnClickListener() {
          //   @Override

         //});

        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code for cancel
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String a = "", b = "", c = "", d = "";

        switch (parent.getId()) {
            case R.id.spinner:
                String item = parent.getItemAtPosition(position).toString();
                areaEnter.setText("");
                if (item.equalsIgnoreCase("select state")) {
                    Area.setVisibility(View.INVISIBLE);
                    areaEnter.setVisibility(View.INVISIBLE);
                } else {
                    Area.setVisibility(View.VISIBLE);
                    areaEnter.setVisibility(View.VISIBLE);

                }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onbackClick(View v) {
     //  moveTaskToBack(true);
        onBackPressed();
       // Intent i = new Intent(getApplicationContext(), MainActivity.class);
        //startActivity(i);

    }
    public void onSubmitClick(View v) {
        Toast.makeText(getApplicationContext(),"Your form is submitted",Toast.LENGTH_SHORT).show();

    }

}

