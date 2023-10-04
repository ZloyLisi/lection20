package com.example.lectiob20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var extras: Bundle? = intent.extras
        if (extras != null){
            var textViewAge: TextView = findViewById(R.id.textView2)
            var age: String? = extras.getString(MainActivity.AGE_KEY)
            if (age!=null){
                textViewAge.text ="Age: $age"
            }
        }
    }
    fun sendMessage(message:String){
        var data: Intent = Intent()
        data.putExtra(MainActivity.ACCESS_MESSAGE, message)
        setResult(RESULT_OK, data)
        finish()
    }
    fun onButtonGrantClick(view: View) {
        sendMessage("Access allowed")
    }
    fun onButtonDenyClick(view: View) {
        sendMessage("Access denied")
    }
    fun onButtonNotValidClick(view: View) {
        sendMessage("Invalid age")
    }
    fun onButtonCancelClick(view: View) {
        setResult(RESULT_CANCELED)
        finish()
    }
}