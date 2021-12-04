package com.example.fooderful.ui.register;

import android.view.View;

public interface RegisterMvpView {

    void openPicker(View view);

    void registrarUsuario(View view);

    void mensajes(String mensaje);

    void error();
}
