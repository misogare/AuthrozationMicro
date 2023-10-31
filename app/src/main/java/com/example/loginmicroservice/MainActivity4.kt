package com.example.loginmicroservice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity4 : AppCompatActivity() {
    private var userName = ""
    private var password = ""
    private var confirmPassword = ""

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://7c5b-103-44-33-217.ngrok-free.app/") // Add the correct base url
            .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .build()

    }
    private val loginApi: LoginApi by lazy {
        retrofit.create(LoginApi::class.java)
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        userName = intent.getStringExtra("username") ?: ""

        findViewById<Button>(R.id.perd).setOnClickListener {
            password = findViewById<TextInputEditText>(R.id.passwordc).text.toString()
            confirmPassword = findViewById<TextInputEditText>(R.id.passwordcc).text.toString()

            if (password != confirmPassword) {
                Toast.makeText(this@MainActivity4, "Passwords do not match", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            CoroutineScope(Dispatchers.Main).launch {
                try {
                    val response = loginApi.resetPassword(username = userName, password = password ,confirmPassword = confirmPassword)
                    Toast.makeText(this@MainActivity4, response.message, Toast.LENGTH_LONG).show()
                    if (response.message.equals("Password reset successful")) {
                        finish()
                    }
                } catch (e: Exception) {
                    Log.d("matthew", "onCreate: $e")
                }

            }
    }
    }
}