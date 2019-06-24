package com.example.todo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewTaskFirst extends AppCompatActivity {
    private Button btnDatePicker, btnTimePicker, btnSaveTask, btnSaveIdea;
    private EditText editTextDate, editTextTime, editTextDescription;

    // database
    private DataHelper db = App.getInstance().getDatabase();
    private IdeasDao ideaDao = db.ideasDao();

    // var for date and time
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnTimePicker = (Button) findViewById(R.id.btn_time);
        editTextDate = (EditText) findViewById(R.id.picked_date);
        editTextTime = (EditText) findViewById(R.id.picked_time);

        btnSaveTask = (Button) findViewById(R.id.button4);
        btnSaveIdea = (Button) findViewById(R.id.button5);
        editTextDescription = (EditText) findViewById(R.id.editTextDescription);

        //Buttons realizations
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_date:
                        callDatePicker();
                        break;
                }
            }
        });

        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_time:
                        callTimePicker();
                        break;
                }
            }
        });

        btnSaveIdea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button5:
                        saveIdea(editTextDescription.getText().toString());
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Вы создали новую идею!", Toast.LENGTH_SHORT);
                        toast.show();
                        switchScreenBack(v);
                        break;
                }
            }
        });

        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button4:
                        saveTask(editTextDescription.getText().toString(),
                                editTextDate.getText().toString(), editTextTime.getText().toString());
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Вы создали новую задачу!", Toast.LENGTH_SHORT);
                        toast.show();
                        switchScreenBack(v);
                        break;
                }
            }
        });
    }

    private void callTimePicker() {
        // получаем текущее время
        final Calendar cal = Calendar.getInstance();
        mHour = cal.get(Calendar.HOUR_OF_DAY);
        mMinute = cal.get(Calendar.MINUTE);

        // инициализируем диалог выбора времени текущими значениями
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String editTextTimeParam = hourOfDay + " : " + minute;
                        editTextTime.setText(editTextTimeParam);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    private void callDatePicker() {
        // получаем текущую дату
        final Calendar cal = Calendar.getInstance();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        // инициализируем диалог выбора даты текущими значениями
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String editTextDateParam = dayOfMonth + "." + (monthOfYear + 1) + "." + year;
                        editTextDate.setText(editTextDateParam);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }


    //Saving Ideas/Tasks
    private void saveIdea(String str) {
        if (!ideaDao.getByHead(str).isEmpty()) {
            return; //вот сюда!!!!!!
        }

        Ideas idea = new Ideas();
        idea.setHead(str);
        ideaDao.insert(idea);
    }

    private void saveTask(String head, String date, String time) {
        if (!ideaDao.getByHead(head).isEmpty()) {
            return; // error
        }

        Ideas idea = new Ideas();
        idea.setHead(head);
        idea.setData(date);
        idea.setTime(time);

        ideaDao.insert(idea);
    }

    public void switchScreenBack(View view){
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }
}
