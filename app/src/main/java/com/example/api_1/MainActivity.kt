package com.example.api_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    var URL = "https://jsonplaceholder.typicode.com/posts"
    var requestQueue: RequestQueue? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.check_btn)
        requestQueue = Volley.newRequestQueue(this)
        button.setOnClickListener {
            ApiCalling()
        }

    }


    fun ApiCalling() {
        var jsonArrayRequest =
            JsonArrayRequest(Request.Method.GET, URL, null, Response.Listener { response ->
                Log.e("TAG", "ApiCalling:${response} ")
            }, Response.ErrorListener { error ->
                Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()

            })

        requestQueue?.add(jsonArrayRequest)
    }

}