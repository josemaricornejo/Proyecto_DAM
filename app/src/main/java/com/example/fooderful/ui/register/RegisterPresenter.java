package com.example.fooderful.ui.register;

import android.content.Context;

import com.example.fooderful.useCases.register.RegisterMvpUseCase;
import com.example.fooderful.useCases.register.RegisterUseCase;

public class RegisterPresenter implements RegisterMvpPresenter {

    RegisterMvpView view;
    RegisterMvpUseCase useCase;

    public RegisterPresenter(RegisterMvpView view) {
        this.view = view;
        useCase = new RegisterUseCase(this);
    }

    @Override
    public void registrarUsuario(String username, String password, String correo, String fecha, String perfil, Context context) {
        useCase.registrarUsuario(username, password, correo, fecha, perfil, context);
    }

    @Override
    public void mensajes(String mensaje) {
        view.mensajes(mensaje);
    }

    @Override
    public void error() {
        view.error();
    }
}
