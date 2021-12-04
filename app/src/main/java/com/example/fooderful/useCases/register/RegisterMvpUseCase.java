package com.example.fooderful.useCases.register;

import android.content.Context;

public interface RegisterMvpUseCase {

    void registrarUsuario(String username, String password, String correo, String fecha, String perfil, Context context);

}
