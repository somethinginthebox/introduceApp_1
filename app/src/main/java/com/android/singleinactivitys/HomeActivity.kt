package com.android.singleinactivitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val IDData = intent.getStringExtra("dataFromSingleInActivity")
        val fromSingleInActivityId = findViewById<EditText>(R.id.fromSingleInActivityId)
        fromSingleInActivityId.setText(IDData)

        val btn_close = findViewById<Button>(R.id.buttonThirdActivity)
        btn_close.setOnClickListener{
            finish()
        }

    }
}