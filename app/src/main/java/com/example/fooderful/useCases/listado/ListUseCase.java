package com.example.fooderful.useCases.listado;



import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.constraintlayout.helper.widget.MotionEffect;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fooderful.R;
import com.example.fooderful.ui.list.ListMvpPresenter;
import com.example.fooderful.utils.Alimento;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListUseCase implements ListMvpUseCase {


    //private String URL = "http://192.168.0.188/android_mysql/buscar_alimento.php?nombre=cebolla";
    ListMvpPresenter presenter;
    RequestQueue requestQueue;
    View view;
    ArrayList<Alimento> listaAlimentos;

    public ListUseCase(ListMvpPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void buscarTodosAlimentos(Context context) {

        listaAlimentos=new ArrayList<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                "http://192.168.0.188/android_mysql/buscar_todos_alimentos.php",
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                Alimento alimento = null;
                for(int i = 0; i< response.length(); i++){
                    try {
                        alimento = new Alimento();
                        jsonObject = response.getJSONObject(i);
                        alimento.setNombre(jsonObject.optString("nombre"));
                        alimento.setImagenId(R.drawable.ensalada);
                        alimento.setCantidad(jsonObject.optString("cantidad"));
                        alimento.setDias("7");
                        listaAlimentos.add(alimento);
                    }catch (JSONException e){
                        Toast.makeText(context.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }


                }

                presenter.envioListaAlimentos(listaAlimentos);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context.getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest);

    }

    @Override
    public void buscarAlimento(Context context, String query) {
        listaAlimentos=new ArrayList<>();
        //listaAlimentos.add(new Alimento(R.drawable.ensalada,"manzana", "3","2"));
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                "http://192.168.0.188/android_mysql/buscar_alimento.php?nombre="+query+"",
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                Alimento alimento = null;
                for(int i = 0; i< response.length(); i++){
                    try {
                        alimento = new Alimento();
                        jsonObject = response.getJSONObject(i);
                        alimento.setNombre(jsonObject.optString("nombre"));
                        alimento.setImagenId(R.drawable.ensalada);
                        alimento.setCantidad(jsonObject.optString("cantidad"));
                        alimento.setDias("7");

                        listaAlimentos.add(alimento);
                    }catch (JSONException e){
                        Toast.makeText(context.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }


                }

                presenter.envioListaAlimentos(listaAlimentos);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context.getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest);


    }

}




