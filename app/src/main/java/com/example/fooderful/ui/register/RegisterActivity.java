package com.example.fooderful.ui.register;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.fooderful.R;
import com.example.fooderful.utils.DatePicker;


public class RegisterActivity extends AppCompatActivity implements RegisterMvpView {

    EditText etUsername, etPassword, etCorreo, etFecha;
    Button btRegistrar;
    DatePicker picker;
    RegisterMvpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.etUsernameRegistro);
        etPassword = findViewById(R.id.etPasswordRegistro);
        etCorreo = findViewById(R.id.etCorreoRegistro);
        etFecha = findViewById(R.id.etFechaRegistro);
        btRegistrar = findViewById(R.id.btRegistro);


        picker = new DatePicker(this);
        presenter = new RegisterPresenter(this);

    }

    @Override
    public void openPicker(View view) {
        picker.openDatePicker(view);
    }

    public void setFecha(String date){
        etFecha.setText(date.toString());
    }

    public void registrarUsuario(View view) {
        String perfil = picker.getPerfil();
        presenter.registrarUsuario(etUsername.getText().toString(), etPassword.getText().toString(), etCorreo.getText().toString(), etFecha.getText().toString(), perfil, this);
    }

    @Override
    public void mensajes(String mensaje) {
        if(mensaje.equals("ERROR 1")) {
            Toast.makeText(RegisterActivity.this, "Se deben de llenar todos los campos", Toast.LENGTH_SHORT).show();
        } else if(mensaje.equals("MENSAJE")) {
            Toast.makeText(RegisterActivity.this, "Registro exitoso", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    public void error() {
        Toast.makeText(RegisterActivity.this, "ERROR CON LA CONEXION", Toast.LENGTH_LONG).show();
    }


}