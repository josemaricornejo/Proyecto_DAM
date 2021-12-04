package com.example.fooderful.ui.list;

import android.content.Context;

import com.example.fooderful.utils.Alimento;

import org.json.JSONObject;

import java.util.ArrayList;

public interface ListMvpPresenter {

    void buscarTodosAlimentos(Context context);

    void buscarAlimento(Context context, String query);

    void envioListaAlimentos(ArrayList<Alimento> listaAlimentos);

}