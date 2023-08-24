package com.android.singleinactivitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SingleInActivity : AppCompatActivity() {

    private lateinit var loginLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.single_in_activity)

        val loginBtn = findViewById<Button>(R.id.login_btn)
        val joinBtn = findViewById<Button>(R.id.join_btn)
        val loginIdEditText = findViewById<EditText>(R.id.loginIdText)
        val loginPwEditText = findViewById<EditText>(R.id.loginPswText)


        //
        loginLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val reId = result.data?.getStringExtra("joinInputId") ?: ""
                    val rePw = result.data?.getStringExtra("joinInputPw") ?: ""
                    loginIdEditText.setText(reId)
                    loginPwEditText.setText(rePw)
                }
            }


        //로그인버튼 Id를 homepage에서 보기.
        loginBtn.setOnClickListener {
            val loginId = loginIdEditText.text.toString()
            val loginPw = loginPwEditText.text.toString()

            if (loginId.isEmpty()) {
                Toast.makeText(this, "아이디를 확인해 주세요!", Toast.LENGTH_SHORT).show()
            } else if (loginPw.isEmpty()) {
                Toast.makeText(this, "비밀번호를 확인해 주세요!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("id", loginId)
                startActivity(intent)

            }
        }


        joinBtn.setOnClickListener {
            val joinIntent = Intent(this, SingleUpActivity::class.java)
            loginLauncher.launch(joinIntent)
        }

    }
}
