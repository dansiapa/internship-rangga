package com.dansiapa.ranggainternship.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dansiapa.ranggainternship.R
import com.dansiapa.ranggainternship.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by lazy {
    ViewModelProviders.of(this).get(LoginViewModel::class.java)
}

    //private EditText et_email;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // findViewById(R.id.et_email);

        //et_email.getText().toString();
        et_email.text.toString()

        btn_login.setOnClickListener{
            loginViewModel.login(et_email.text.toString(), et_password.text.toString())
        }

        setObserver()
    }

    private fun setObserver() {
        loginViewModel.getLoginResponseModel().observe(this, Observer {
            if(it != null){
                Toast.makeText(this, "User Id "+it.userModel.userId, Toast.LENGTH_SHORT).show()
            }
        })

        loginViewModel.getErrorListener().observe(this, Observer {
            if(it){
                Toast.makeText(this, "Something is wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }

    // private boolean login(String email, String password)
    private fun login(email: String, password: String = "default"): String{
        return password
    }
}