package com.example.fooderful.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fooderful.R;
import com.example.fooderful.ui.list.ListActivity;
import com.example.fooderful.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginMvpView {

    EditText etUsername, etPassword;
    Button btInicioSesion;
    TextView tvRegistrate;

    private LoginMvpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsernameRegistro);
        etPassword = findViewById(R.id.etPasswordRegistro);
        btInicioSesion = findViewById(R.id.btIncioSesion);
        tvRegistrate = findViewById(R.id.tvRegistrate);

        presenter = new LoginPresenter(this);
    }

    @Override
    public void respuesta(String mensaje) {

        if(mensaje.equals("ERROR 1")){
            Toast.makeText(LoginActivity.this, "No debe haber campos vacíos", Toast.LENGTH_LONG).show();
        }else if(mensaje.equals("ERROR 2")){
            Toast.makeText(LoginActivity.this, "El usuario no existe", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(LoginActivity.this, "usuario válido", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void error() {
        Toast.makeText(LoginActivity.this, "Error de conexión", Toast.LENGTH_LONG).show();
    }

    public void validarUsuario(View view) {
        presenter.validarUsuario(etUsername.getText().toString(), etPassword.getText().toString(), this);

        Intent intent = new Intent(LoginActivity.this, ListActivity.class);
        startActivity(intent);
    }

    public void navigateRegistro(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}