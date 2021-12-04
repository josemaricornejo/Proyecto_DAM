package com.example.fooderful.ui.register;

import android.content.Context;

public interface RegisterMvpPresenter {

    void registrarUsuario(String username, String password, String correo, String fecha, String perfil, Context context);

    void mensajes(String mensaje);

    void error();
}
