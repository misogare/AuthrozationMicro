package com.example.loginmicroservice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://4682-103-44-33-226.ngrok-free.app/") // Replace with your API's base URL
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val service = retrofit.create(LoginApi::class.java)


        CoroutineScope(Dispatchers.Main).launch {
            try {
                val apiCategories = service.getCategories()
                // Now you have the data, you can pass it to your RecyclerView adapter
                val recyclerView = view?.findViewById<RecyclerView>(R.id.gridView2)
                val adapter = CategoryAdapter2(this@BlankFragment, apiCategories)
                recyclerView?.adapter = adapter
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }


}