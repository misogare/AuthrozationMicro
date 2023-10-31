package com.example.loginmicroservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : AppCompatActivity() {
    private var userName = ""
    private var password = ""
    lateinit private var resetbutton : TextView
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
        setContentView(R.layout.activity_main)

        loginResponseLiveData.observe(this) {
            it?.let { response ->
                Toast.makeText(this, "${response.message}", Toast.LENGTH_LONG).show()
                Log.d("matthew", "onCreate: ${response.message}")

                if (response.message == "Login successful") {
                    val intentToNavigateTothirds = Intent(this, MainActivity2::class.java)
                    startActivity(intentToNavigateTothirds)
                } else if (response.message == "Login Failed") {
                    Toast.makeText(this, "Your password is wrong", Toast.LENGTH_LONG).show()
                } else if (response.message == "your credentials are not in our database") {
                    Toast.makeText(this, "User doesn't exist", Toast.LENGTH_LONG).show()
                }
            }
        }

        findViewById<EditText>(R.id.editText1).addTextChangedListener {
            userName = it.toString()
        }

        findViewById<EditText>(R.id.editTextText).addTextChangedListener {
            password = it.toString()
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                try {
                    loginResponseLiveData.value = loginApi.login(username = userName, password = password)

                } catch (e: Exception) {
                    loginResponseLiveData.value = LoginResponse(message = "Network call failed $e")
                }

            }

        }
        val intentToNavigateTothirdss = Intent(this, MainActivity3::class.java)
        resetbutton = findViewById<TextView>(R.id.textView6)
        resetbutton.setOnClickListener {
                    startActivity(intentToNavigateTothirdss)
           }
}   }