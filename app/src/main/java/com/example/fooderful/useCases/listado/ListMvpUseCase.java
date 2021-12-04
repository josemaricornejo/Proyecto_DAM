package com.example.fooderful.useCases.listado;

import android.content.Context;
import android.view.View;

import com.example.fooderful.ui.list.ListMvpView;

public interface ListMvpUseCase{

    public void buscarTodosAlimentos(Context context);

    public void buscarAlimento(Context context, String query);


}
