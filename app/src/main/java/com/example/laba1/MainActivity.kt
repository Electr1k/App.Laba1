package com.example.laba1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import com.example.laba1.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var listLogins: List<String>
    private lateinit var listPasswords: List<String>
//    private val listUsers: List<User> = listOf(
//        User(login = "vasya_pupkin@gmail.com", password = "qwerty"),
//        User(login = "vsem_hello@gmail.com", password = "kyky"),
//        User(login = "artem3232@mail.ru", password = "art3m"),
//        User(login = "vovan_V_tanke@gmail.com", password = "KV1"),
//        User(login = "s1mple@gmail.com", password = "123456")
//    )
    private lateinit var loginFlied: EditText
    private lateinit var passwordFlied: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listLogins = applicationContext.resources.getStringArray(R.array.Emails).toList()
        listPasswords = applicationContext.resources.getStringArray(R.array.Passwords).toList()
        loginFlied = findViewById(R.id.login)
        passwordFlied = findViewById(R.id.password)
        button = findViewById(R.id.btn)
        println(listLogins)
        // При обновлении значения логина цвет текста логина и пароля должен быть черным
        loginFlied.setOnKeyListener { v, keyCode, event ->
            loginFlied.setTextColor(Color.BLACK)
            passwordFlied.setTextColor(Color.BLACK)
            true
        }

        // При обновлении значения пароля цвет текста логина и пароля должен быть черным
        passwordFlied.setOnKeyListener { v, keyCode, event ->
            loginFlied.setTextColor(Color.BLACK)
            passwordFlied.setTextColor(Color.BLACK)
            if(event.action == KeyEvent.ACTION_DOWN &&
                (keyCode == KeyEvent.KEYCODE_ENTER))
            {
                login()
            }
            true
        }

        button.setOnClickListener{
            login()
        }
    }

    private fun login(){
        // Ищем подходящего юзера
        if (listLogins.find{it == loginFlied.text.toString()}!=null){
            if (listPasswords.find{it == passwordFlied.text.toString()}!=null){
                Log.d("Success", "Success login")
                val intent = Intent(this, BottomNavigationActivity::class.java)
                startActivity(intent)
            }
            else{
                passwordFlied.setTextColor(Color.RED) // Неверный пароль
            }
        }
        else{
            loginFlied.setTextColor(Color.RED) // Неверный логин
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("login", loginFlied.text.toString())
        outState.putString("password", passwordFlied.text.toString())
    }


    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        loginFlied.setText(savedInstanceState?.getString("login"))
        passwordFlied.setText(savedInstanceState?.getString("password"))

    }
}