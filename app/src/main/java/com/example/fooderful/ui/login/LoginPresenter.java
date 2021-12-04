package com.example.fooderful.ui.login;

import com.example.fooderful.useCases.login.LoginMvpUseCase;
import com.example.fooderful.useCases.login.LoginUseCase;

public class LoginPresenter implements LoginMvpPresenter {

    private LoginMvpView view;
    private LoginMvpUseCase useCase;

    public LoginPresenter(LoginMvpView view) {
        this.view = view;
        useCase = new LoginUseCase(this);
    }

    @Override
    public void validarUsuario(String username, String password, LoginActivity context) {
        useCase.validarUsuario(username, password, context);
    }

    @Override
    public void respuesta(String mensaje) {
        view.respuesta(mensaje);
    }

    @Override
    public void error() {
        view.error();
    }
}
