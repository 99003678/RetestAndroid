package com.example.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        var res =  intent.extras!!.getString("key")
        var res2 = intent.extras !!.getString("key1")
        textView3.setText(res)
        textView4.setText(res2)
        logoutBtn.setOnClickListener {
            var logoutIntent = Intent(this, LoginActivity::class.java)
            startActivity(logoutIntent)
        }
    }
}