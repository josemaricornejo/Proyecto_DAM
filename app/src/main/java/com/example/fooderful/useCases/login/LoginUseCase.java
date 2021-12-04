package com.example.fooderful.useCases.login;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fooderful.ui.login.LoginMvpPresenter;

import java.util.HashMap;
import java.util.Map;

public class LoginUseCase implements LoginMvpUseCase {

    RequestQueue requestQueue;
    LoginMvpPresenter presenter;

    public LoginUseCase(LoginMvpPresenter presenter){
        this.presenter=presenter;
    }

    @Override
    public void validarUsuario(String username, String password, Context context) {

        requestQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest (
                Request.Method.POST,
                "http://192.168.0.188/android_mysql/login.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        presenter.respuesta(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                presenter.error();
            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("username", username);
                parametros.put("password", password);
                return parametros;
            }
        };

        requestQueue.add(stringRequest);

    }
}
