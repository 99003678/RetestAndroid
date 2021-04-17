package com.example.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        val context = this
        val db = DataBaseHandler(context)

        btnInsert.setOnClickListener {
            if (editTextName.text.toString().isNotEmpty() &&
                    editTextAge.text.toString().isNotEmpty()
            ) {
                val user = User(editTextName.text.toString(), editTextAge.text.toString())
                db.insertData(user)
                clearField()
            }
            else {
                Toast.makeText(context, "Please Fill All Data's", Toast.LENGTH_SHORT).show()
            }
        }
        btnSignIn.setOnClickListener {
            var loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }

    }
    private fun clearField() {
        editTextName.text.clear()
        editTextAge.text.clear()
        email.text.clear()
        phone.text.clear()
    }
}