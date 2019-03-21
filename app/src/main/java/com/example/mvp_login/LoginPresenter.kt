package com.example.mvp_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoginPresenter(var loginView: LoginContracter.LoginView?, val loginInteractor: LoginContracter) :
    LoginContracter.onFinishListener, LoginContracter.Presenter {
    override fun onSuccess(successMessage: String, userModel: ModelUser) {
        loginView?.hideProgress()
        loginView?.navigateToHome()
    }

    override fun onFailure(errorMessage: String) {
        loginView?.hideProgress()

    }

    override fun onUsernameError() {
        loginView?.hideProgress()
        loginView?.setUsernameError()
    }

    override fun onPasswordError() {
        loginView?.hideProgress()
        loginView?.setPasswordError()

    }

    override fun validateCredentials(username: String, password: String) {
        loginView?.showProgress()
        loginInteractor.login(username, password, this)
    }
     override fun onDestroy(){
         loginView = null
     }
}
