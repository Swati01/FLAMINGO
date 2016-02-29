package com.example.advantal.flames;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText doa;
    TextView dhoom;
    String dhoom2="";
    Context context;
    ImageView calender,cam;
    CalendarView cal;
    Button save, nexto, can;
    TextView Area, timedisplay;
    EditText areaEnter;
    int m = 0, n = 0, o = 0, p = 0, res = 0, sonal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = (Button) findViewById(R.id.save);
        can = (Button) findViewById(R.id.cancel_action);
        nexto=(Button)findViewById(R.id.next);
        doa = (EditText) findViewById(R.id.activitydateswati);
        cam=(ImageView)findViewById(R.id.camera);
        calender = (ImageView) findViewById(R.id.calimg);
        dhoom=(TextView)findViewById(R.id.sonal);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       //
        doa.setText(sdf.format(new Date()));

        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.content_landscape);
        }

        Spinner activitysector=(Spinner)findViewById(R.id.selectactivitysector);
        activitysector.setOnItemSelectedListener(this);
        List<String> categories2 = new ArrayList<String>();
        categories2.add("Select Activity Sector");
        categories2.add("Domestic Sector Activities");
        categories2.add("Agriculture Sector Activities");
        categories2.add("Transport Sector Activities");
        categories2.add("Industry Sector Activities");
        categories2.add("Miscellaneous Activities");
        categories2.add("PAT");
        categories2.add("ISO 50001");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitysector.setAdapter(dataAdapter2);
        //

        Spinner fromhr=(Spinner)findViewById(R.id.fromhour);
        fromhr.setOnItemSelectedListener(this);
        List<String> categories3 = new ArrayList<String>();
        categories3.add("00");
        categories3.add("01");
        categories3.add("02");
        categories3.add("03");
        categories3.add("04");
        categories3.add("05");
        categories3.add("06");
        categories3.add("07");
        categories3.add("08");
        categories3.add("09");
        categories3.add("10");
        categories3.add("11");
        categories3.add("12");
        categories3.add("13");
        categories3.add("14");
        categories3.add("15");
        categories3.add("16");
        categories3.add("17");
        categories3.add("18");
        categories3.add("19");
        categories3.add("20");
        categories3.add("21");
        categories3.add("22");
        categories3.add("23");
        ArrayAdapter<String> dataAdapterdatefromhour = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3);
        dataAdapterdatefromhour.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromhr.setAdapter(dataAdapterdatefromhour);

        Spinner frommin=(Spinner)findViewById(R.id.from_minutes);
        frommin.setOnItemSelectedListener(this);
        List<String> categoriesfromminutes = new ArrayList<String>();
        categoriesfromminutes.add("00");
        categoriesfromminutes.add("15");
        categoriesfromminutes.add("30");
        categoriesfromminutes.add("45");
        ArrayAdapter<String> dataAdapterdatefrommin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoriesfromminutes);
        dataAdapterdatefrommin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        frommin.setAdapter(dataAdapterdatefrommin);

        Spinner tohr=(Spinner)findViewById(R.id.tohour);
        tohr.setOnItemSelectedListener(this);
        List<String> categoriestohour = new ArrayList<String>();
        categoriestohour.add("00");
        categoriestohour.add("01");
        categoriestohour.add("02");
        categoriestohour.add("03");
        categoriestohour.add("04");
        categoriestohour.add("05");
        categoriestohour.add("06");
        categoriestohour.add("07");
        categoriestohour.add("08");
        categoriestohour.add("09");
        categoriestohour.add("10");
        categoriestohour.add("11");
        categoriestohour.add("12");
        categoriestohour.add("13");
        categoriestohour.add("14");
        categoriestohour.add("15");
        categoriestohour.add("16");
        categoriestohour.add("17");
        categoriestohour.add("18");
        categoriestohour.add("19");
        categoriestohour.add("20");
        categoriestohour.add("21");
        categoriestohour.add("22");
        categoriestohour.add("23");
        ArrayAdapter<String> dataAdapterdatetohour = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoriestohour);
        dataAdapterdatetohour.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tohr.setAdapter(dataAdapterdatetohour);

        Spinner tomin=(Spinner)findViewById(R.id.tominutes);
        tomin.setOnItemSelectedListener(this);
        List<String> categoriestominutes = new ArrayList<String>();
        categoriestominutes.add("00");
        categoriestominutes.add("15");
        categoriestominutes.add("30");
        categoriestominutes.add("45");
        ArrayAdapter<String> dataAdapterdatetomin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoriestominutes);
        dataAdapterdatetomin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tomin.setAdapter(dataAdapterdatetomin);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)

    public void popupimage(View v) {
        LayoutInflater layoutInflater= (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        final View popupView = layoutInflater.inflate(R.layout.popup, null);
        final PopupWindow popupWindow = new PopupWindow(popupView, 400, 400, true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(popupView, Gravity.RIGHT, 0, 0);
        cal = (CalendarView)popupView.findViewById(R.id.calendarView);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view,int year,int month,int dayOfMonth) {
                        doa.setText(year + "-" + month + "-" + dayOfMonth);
                        Log.v("value:", doa.getText().toString());
                Toast.makeText(MainActivity.this, doa.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
        });}


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String a="",b="",c="",d="";

        switch (parent.getId())
        {

            case R.id.selectactivitysector: String item2 = parent.getItemAtPosition(position).toString();
                Spinner subactivity =(Spinner)findViewById(R.id.selectactivity);
                List<String> subcategories=new ArrayList<String>();
                if(item2.equalsIgnoreCase("select activity sector"))
                {

                    subcategories.add("Select Activity");
                }
                else if(item2.equalsIgnoreCase("Domestic Sector Activities"))
                {
                    subcategories.add("Select Activity");
                    subcategories.add("Workshop Domestic");
                    subcategories.add("Youth Programme");
                    subcategories.add("Misc");
                }

                else if(item2.equalsIgnoreCase("Agriculture Sector Activities"))
                {
                    subcategories.add("Select Activity");
                    subcategories.add("Kisan Shop");
                    subcategories.add("Workshop Agriculture");
                    subcategories.add("Misc");
                }

                else if(item2.equalsIgnoreCase("Transport Sector Activities"))
                {
                    subcategories.add("Select Activity");
                    subcategories.add("Driver Training Programme");
                    subcategories.add("Model Training Programme");
                    subcategories.add("Training for DTI");
                    subcategories.add("Workshop Transport");
                    subcategories.add("Misc");
                }

                else if(item2.equalsIgnoreCase("Industry Sector Activities"))
                {
                    subcategories.add("Select Activity");
                    subcategories.add("Energy Audit(IH)");
                    subcategories.add("Follow up");
                    subcategories.add("Fuel Oil Diagnostic Study");
                    subcategories.add("Institutional Training Programme");
                    subcategories.add("Seminar/Technical/Consumer Meet");
                    subcategories.add("Service to Small Scale Industry");
                    subcategories.add("Workshop-Industrial");
                    subcategories.add("Misc");
                }

                else if(item2.equalsIgnoreCase("Miscellaneous Activities"))
                {
                    subcategories.add("Select Activity");
                    subcategories.add("Exhibition");
                    subcategories.add("Van Publicity");
                    subcategories.add("Misc");
                }

                else if(item2.equalsIgnoreCase("pat"))
                {
                    subcategories.add("Select Activity");
                    subcategories.add("PAT");
                }
                else if(item2.equalsIgnoreCase("ISO 50001"))
                {
                    subcategories.add("Select Activity");
                    subcategories.add("ISO 50001");
                }

                ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subcategories);
                dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                subactivity.setAdapter(dataAdapter3);
                break;
            case R.id.fromhour:a=  parent.getItemAtPosition(position).toString();
                m=Integer.parseInt(a);
                break;

            case R.id.from_minutes:b=  parent.getItemAtPosition(position).toString();
                n=Integer.parseInt(b);

                break;

            case R.id.tohour:c=  parent.getItemAtPosition(position).toString();
                o=Integer.parseInt(c);
                break;

            case R.id.tominutes:d=  parent.getItemAtPosition(position).toString();
                p=Integer.parseInt(d);
                break;

        }

    }
    @Override
    public void onNothingSelected (AdapterView < ? > parent){

    }

    public void onsaveClick(View v) {
        Intent i= new Intent(MainActivity.this,Dactivity.class);
        startActivity(i);

    }
    public void oncamClick(View v) {

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, 0);
    }


    }





















