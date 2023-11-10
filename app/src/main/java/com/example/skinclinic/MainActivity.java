package com.example.skinclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etAge, etSex;
    private Spinner spinnerAppointmentTimes;
    private Button btnSelectDateTime;
    private TextView tvSelectedDateTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etSex = findViewById(R.id.etSex);
        spinnerAppointmentTimes = findViewById(R.id.spinnerAppointmentTimes);
        btnSelectDateTime = findViewById(R.id.btnSelectDateTime);
        tvSelectedDateTime = findViewById(R.id.tvSelectedDateTime);

        btnSelectDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimePicker();
            }
        });

        // Populate the spinner with available appointment times
        populateAppointmentTimesSpinner();
    }

    private void showDateTimePicker() {
        // Implement date and time picker logic here
        // You can use DatePickerDialog and TimePickerDialog
        // to allow users to choose the date and time.

        // For simplicity, let's assume you have a method to show a date picker
        showDatePicker();
    }

    private void showDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Handle the selected date
                        showTimePicker();
                    }
                },
                // Set initial date values if needed
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.show();
    }

    private void showTimePicker() {
        // Implement TimePickerDialog logic here
        // Set the selected date and time to tvSelectedDateTime TextView
        // You can use a library or a custom method to show a time picker
        // For simplicity, let's assume you have a method called showTimePickerDialog
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        // Implement TimePickerDialog logic here
        // Set the selected date and time to tvSelectedDateTime TextView

        // Example code for a simple time picker
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Handle the selected time
                        String selectedDateTime = getSelectedDateTime(hourOfDay, minute);
                        tvSelectedDateTime.setText("Selected Date and Time: " + selectedDateTime);
                    }
                },
                // Set initial time values if needed
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                Calendar.getInstance().get(Calendar.MINUTE),
                false
        );

        timePickerDialog.show();
    }

    private String getSelectedDateTime(int hourOfDay, int minute) {
        // Process the selected date and time
        // You might want to format it as needed

        // Example: Format as "YYYY-MM-DD HH:mm"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        Date date = new Date(); // Replace this with the actual date selected
        date.setHours(hourOfDay);
        date.setMinutes(minute);
        return dateFormat.format(date);
    }

    private void populateAppointmentTimesSpinner() {
        // Implement logic to populate the spinner with available appointment times
        // You can use an array adapter to set the available times
        // For simplicity, let's assume you have an array of times
        String[] times = {"10:00 AM", "02:00 PM", "04:30 PM"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                times
        );

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinnerAppointmentTimes.setAdapter(adapter);
    }

    }
