package com.example.mvp_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity(), LoginContracter.LoginView {

    private val presenter = LoginPresenter(this, LoginContracter())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            validateCredentials()
        }
    }

    private fun validateCredentials() {
        presenter.validateCredentials(edtUserName.text.toString(), edtPassword.text.toString())
    }

    override fun showProgress() {
        progress.visibility = VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = GONE

    }

    override fun setUsernameError() {
        edtUserName.requestFocus()
        edtUserName.error = "Enter Username"
    }

    override fun setPasswordError() {
        edtPassword.requestFocus()
        edtPassword.error = "Enter password"
    }

    override fun navigateToHome() {
        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
