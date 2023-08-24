package com.android.singleinactivitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SingleUpActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_up)

        val completeBtn = findViewById<Button>(R.id.completeBtn)
        val joinInputName = findViewById<EditText>(R.id.join_inputName)
        val joinInputId = findViewById<EditText>(R.id.join_inputId)
        val joinInputPw = findViewById<EditText>(R.id.join_inputPw)



            //아이디,비밀번호,이름 비어있을 때 토스트로 알려주기
        completeBtn.setOnClickListener {
            val joinInputNameText = joinInputName.text.toString()
            val joinInputIdText = joinInputId.text.toString()
            val joinInputPwText = joinInputPw.text.toString()

            if (joinInputNameText.isEmpty()) {
                Toast.makeText(this, "이름을 입력해주세요!", Toast.LENGTH_SHORT).show()
            } else if (joinInputIdText.isEmpty()) {
                Toast.makeText(this, "아이디를 입력해주세요!", Toast.LENGTH_SHORT).show()
            } else if (joinInputPwText.isEmpty()) {
                Toast.makeText(this, "비밀번호를 입력해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "회원가입성공!", Toast.LENGTH_SHORT).show()

                val loginIntent = Intent(this, SingleInActivity::class.java)
                loginIntent.putExtra("joinInputId", joinInputIdText)
                loginIntent.putExtra("joinInputPw", joinInputPwText)
                setResult(RESULT_OK, loginIntent)
                finish()
            }

        }

    }
}





