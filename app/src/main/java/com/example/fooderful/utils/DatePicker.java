package com.example.fooderful.utils;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.view.View;

import com.example.fooderful.ui.register.RegisterActivity;

import java.util.Calendar;

public class DatePicker {

    private DatePickerDialog datePickerDialog;

    RegisterActivity view;
    String perfil = "1";

    public DatePicker(RegisterActivity view){
        this.view = view;
        initDatePicker();
    }

    public String initDatePicker() {

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker view, int year, int month, int day) {

                month = month +1;
                String date = makeDateString(day, month, year);
                setDate(date);
                //calcularEdad(year);
                //etFecha.setText(date.toString());


            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(view, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());


        return null;
    }

    public String makeDateString(int day, int month, int year) {

        return year+"-"+month+"-"+day;

    }

    public void setDate(String date){
        this.view.setFecha(date);
    }

    public void openDatePicker(View view){
        datePickerDialog.show();
    }

    private void calcularEdad(int birthYear) {
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        int year = currentYear - birthYear;
        if(year<14){
            perfil="2";
        }

    }

    public String getPerfil(){
        return perfil;
    }





}
