package com.arati.theavengers

import android.content.Intent
import android.content.SharedPreferences
import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

@Suppress("UNUSED_EXPRESSION")
class LoginActivity : AppCompatActivity() {
     lateinit var edtmob:EditText
     lateinit var edtpwd:EditText
     lateinit var btnlogin:Button
     lateinit var txtforgotpwd:TextView
     lateinit var txtregister:TextView
     val validMobileNumber="8114771737"
    val validPassword= arrayOf("tony","natasha","bruce","carol","avengers")
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), MODE_PRIVATE)

        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)

        setContentView(R.layout.activity_login)

        if(isLoggedIn){
            val intent=Intent(this@LoginActivity,AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }
        setContentView(R.layout.activity_login)
        title = "Log In"

        edtmob = findViewById(R.id.edtmob)
        edtpwd = findViewById(R.id.edtpwd)
        btnlogin = findViewById(R.id.btnlogin)
        txtforgotpwd = findViewById(R.id.txtforgotpwd)
        txtregister = findViewById(R.id.txtregister)





//Lambda Representation

        btnlogin.setOnClickListener{
            val mobileNumber=edtmob.text.toString()

            val password=edtpwd.text.toString()

            var nameOfAvengers="Avengers"

            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)


            if((mobileNumber==validMobileNumber)) {
                if (password == validPassword[0]) {

                    nameOfAvengers = "Tony Stark"
                    savepreferences(nameOfAvengers)

                    startActivity(intent)
                } else if (password == validPassword[1]) {
                    nameOfAvengers = "Natasha Romanoff"
                    savepreferences(nameOfAvengers)
                    startActivity(intent)
                } else if (password === validPassword[2]) {

                    nameOfAvengers = "Bruce Banner"
                    savepreferences(nameOfAvengers)
                    startActivity(intent)
                } else if (password == validPassword[3]) {

                    nameOfAvengers = "Carol Danvers"
                    savepreferences(nameOfAvengers)
                    startActivity(intent)
                } else if (password == validPassword[4]) {

                    nameOfAvengers = "The Avengers"
                    savepreferences(nameOfAvengers)

                    startActivity(intent)
                }
            }else {
                    Toast.makeText(this@LoginActivity, "Incorrect Credential", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savepreferences(title: String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()

    }
}


