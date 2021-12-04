package com.example.fooderful.useCases.login;

import android.content.Context;

import com.example.fooderful.ui.login.LoginMvpView;

public interface LoginMvpUseCase {

    void validarUsuario(String username, String password, Context context);
}
