package com.kotlinseries.sharedprefapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var name_textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Initialize our widgets
        val editText:EditText= findViewById(R.id.inputtext)
       name_textView = findViewById(R.id.tvshowname)
        val btn:Button = findViewById(R.id.btnsave)

        btn.setOnClickListener {
            val enteredtext:String = editText.text.toString()
            //create a function savenameInSharedpreference
            saveNameInSharedpref(enteredtext)

        }
    }

    private fun saveNameInSharedpref(enteredtext: String) {
        //Opening  shared Preferences
        val sharedprefernces:SharedPreferences = getSharedPreferences("UserName",
            MODE_PRIVATE)
        //Writing data to shared preferences
        val editor:SharedPreferences.Editor = sharedprefernces.edit()
        editor.putString("name",enteredtext)
        editor.commit()

    }
    //Reading Data from shared preference
    fun DisplaysavedName(){
        val sharedPreferences: SharedPreferences = getSharedPreferences("UserName", MODE_PRIVATE)
        val s1 :String? = sharedPreferences.getString("name","")
        //we need to use  null safety in kotlin while dealing with shared prefernces and getting text
        // from the key provided
        //Then we need to display the text that we captured as textview
        name_textView.setText(s1)
    }


}