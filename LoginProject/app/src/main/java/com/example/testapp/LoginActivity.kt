package com.example.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val context = this
        val db = DataBaseHandler(context)
        loginBtn.setOnClickListener {

                val data = db.readData()
                var uName = username_field.text.toString()
                var pass = pass_field.text.toString()
            if (username_field.text.toString().isEmpty() &&
                pass_field.text.toString().isEmpty()
            )
            {
                Toast.makeText(context, "Details not entered", Toast.LENGTH_SHORT).show()
            }
            for (i in 0 until data.size)
            {
                 if (uName == data[i].username && pass == data[i].pass)
                 {
                    var dashBoardIntent = Intent(this, Dashboard::class.java)
                     dashBoardIntent.putExtra("key",uName)
                     dashBoardIntent.putExtra("key1", pass)
                    startActivity(dashBoardIntent)
                     break;
                 }

                 else {
                    Toast.makeText(context, "Incorrect credentials", Toast.LENGTH_SHORT).show()
                }
            }

        }
        sign_up_btn.setOnClickListener {
            var signUpIntent = Intent(this, MainActivity::class.java)
            startActivity(signUpIntent)
        }
    }
}