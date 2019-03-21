package com.example.mvp_login

import android.os.Handler


class LoginContracter {

    interface LoginView {
        fun showProgress()
        fun hideProgress()
        fun setUsernameError()
        fun setPasswordError()
        fun navigateToHome()
    }

    interface Presenter {
        fun validateCredentials(userName: String,password: String)
        fun onDestroy()
    }

    interface onFinishListener {
        fun onSuccess(successMessage: String, userModel: ModelUser)
        fun onFailure(errorMessage: String)
        fun onUsernameError()
        fun onPasswordError()
    }

    fun login(userName: String, password: String, listener: onFinishListener) {

        //replace with your api call
        Handler().postDelayed({
            when {
                userName.isEmpty() -> listener.onUsernameError()
                password.isEmpty() -> listener.onPasswordError()
                else -> listener.onSuccess("Login success", ModelUser("", "", ""))//bind data from api response
            }
        }, 1000)

    }

}