package com.example.loginmicroservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity3 : AppCompatActivity() {
    private var userName = ""
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://4682-103-44-33-226.ngrok-free.app/") // Add the correct base url
            .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .build()

    }

    private val loginApi: LoginApi by lazy {
        retrofit.create(LoginApi::class.java)
    }
    private val loginResponseLiveData = MutableLiveData<LoginResponse?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        findViewById<Button>(R.id.mango).setOnClickListener {
            userName = findViewById<TextInputEditText>(R.id.rango).text.toString()
            CoroutineScope(Dispatchers.Main).launch {
                try {
                    loginResponseLiveData.value = loginApi.forgotpassword(username = userName)

                    if (loginResponseLiveData.value?.message == "Change the password") {
                        val intentToNavigateToResetPassword = Intent(this@MainActivity3, MainActivity4::class.java)
                        intentToNavigateToResetPassword.putExtra("username", userName)
                        startActivity(intentToNavigateToResetPassword)
                    } else {
                        Toast.makeText(this@MainActivity3, "User doesn't exist", Toast.LENGTH_LONG).show()
                        val image = findViewById<ImageView>(R.id.textView7)
                        val text = findViewById<TextView>(R.id.mig)
                        image.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE)
                    }
                } catch (e: Exception) {
                    loginResponseLiveData.value = LoginResponse(message = "Network call failed $e")
                }

            }


        }
    }
}