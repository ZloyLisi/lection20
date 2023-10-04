package com.example.lectiob20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    companion object{
        const val AGE_KEY: String = "AGE"
        const val ACCESS_MESSAGE: String = "ACCESS_MASSAGE"
    }
    var mStartForResult: ActivityResultLauncher<Intent?>?= registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        val textView = findViewById<TextView>(R.id.textView)
        if(result.resultCode== RESULT_OK)
        {
            val intent: Intent? = result.data
            val accessMessage : String? = intent!!.getStringExtra(ACCESS_MESSAGE)
            textView.text = accessMessage
        }
        else{
            textView.text="Ошибка доступа"
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClick(view: View) {
        var ageBox: EditText = findViewById(R.id.editTextAge)
        var age: String = ageBox.text.toString()
        var intent: Intent = Intent (this@MainActivity,SecondActivity::class.java)
        intent.putExtra(AGE_KEY,age)
        mStartForResult?.launch(intent)
    }
}