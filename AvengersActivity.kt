package com.arati.theavengers

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class AvengersActivity : AppCompatActivity() {

    var titleName:String?="Avengers"
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btnlogout:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name),
            MODE_PRIVATE)
        setContentView(R.layout.activity_avengers)

   btnlogout=findViewById(R.id.btnlogout)

        btnlogout.setOnClickListener{
            Toast.makeText(this@AvengersActivity, "Click me to Log Out", Toast.LENGTH_SHORT).show()
            intent=Intent(this@AvengersActivity,LoginActivity::class.java)
            clspreferances()
            startActivity(intent)
             onPause()
        }

        titleName=sharedPreferences.getString("Title","The Avengers" )
        title=titleName

    }
    override fun onPause() {
        super.onPause()
        finish()
    }

fun clspreferances(){
    sharedPreferences.edit().clear().apply()
}
}