package com.example.fooderful.ui.login;

public interface LoginMvpPresenter {

    void validarUsuario(String toString, String toString1, LoginActivity loginActivity);

    void respuesta(String mensaje);

    void error();
}
