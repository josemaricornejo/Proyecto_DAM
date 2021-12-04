package com.example.fooderful.useCases.register;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fooderful.ui.register.RegisterActivity;
import com.example.fooderful.ui.register.RegisterMvpPresenter;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;

public class RegisterUseCase implements RegisterMvpUseCase{


    RegisterMvpPresenter presenter;

    RequestQueue requestQueue;

    public RegisterUseCase(RegisterMvpPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void registrarUsuario(String username, String password, String correo, String fecha, String perfil, Context context) {

        requestQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest;
        stringRequest = new StringRequest(Request.Method.POST,
                "http://192.168.0.188/android_mysql/registro.php",
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        // En este apartado se programa lo que deseamos hacer en caso de no haber errores

                        presenter.mensajes(response);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // En caso de tener algun error en la obtencion de los datos
                presenter.error();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                // En este metodo se hace el envio de valores de la aplicacion al servidor
                Map<String, String> parametros = new Hashtable<String, String>();
                parametros.put("username", username.toString().trim());
                parametros.put("password", password.toString().trim());

                parametros.put("idperfil", perfil.toString().trim());
                parametros.put("correo", correo.toString().trim());
                parametros.put("fecha", fecha.toString().trim());


                return parametros;
            }
        };

        requestQueue.add(stringRequest);
    }


}
