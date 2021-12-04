package com.example.fooderful.ui.list;

import android.content.Context;

import com.example.fooderful.useCases.listado.ListMvpUseCase;
import com.example.fooderful.useCases.listado.ListUseCase;
import com.example.fooderful.utils.Alimento;

import org.json.JSONObject;

import java.util.ArrayList;

public class ListPresenter implements ListMvpPresenter {

    private ListMvpView view;
    private ListMvpUseCase useCase;

    public ListPresenter(ListMvpView view) {
        this.view = view;
        useCase = new ListUseCase(this);
    }


    @Override
    public void buscarTodosAlimentos(Context context) {
        useCase.buscarTodosAlimentos(context);
    }


    @Override
    public void buscarAlimento(Context context, String query) {

        useCase.buscarAlimento(context, query);

    }

    @Override
    public void envioListaAlimentos(ArrayList<Alimento> listaAlimentos) {
        view.llenarListaAlimentos(listaAlimentos);
        System.out.println("tamaño use case: false"+ listaAlimentos.size());
    }


}
