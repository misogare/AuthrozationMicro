package com.example.loginmicroservice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.commit

class MainActivity2 : AppCompatActivity() {
    lateinit private var navigateButton: Button
    lateinit private var icon1:ImageView
    lateinit private var icon2:ImageView
    lateinit private var icon3:ImageView
    lateinit private var icon4:ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        supportFragmentManager.commit {
            add(R.id.mago, BlankFragment::class.java, null)
            setReorderingAllowed(true)
        }

        icon1 = findViewById<ImageView>(R.id.icon1)
        icon2 = findViewById<ImageView>(R.id.icon2)
        icon3 = findViewById<ImageView>(R.id.icon3)
        icon4 = findViewById<ImageView>(R.id.icon4)
        icon1.setOnClickListener {
            supportFragmentManager.commit {
                add(R.id.mago, BlankFragment::class.java, null)
                setReorderingAllowed(true)
            }
        }


    }
}