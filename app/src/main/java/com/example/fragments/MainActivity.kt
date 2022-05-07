package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.fragments.fragments.*

class MainActivity : AppCompatActivity(), Comm1 {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Buttons
        val button = findViewById<Button>(R.id.button1)
        val buttonTwo = findViewById<Button>(R.id.button2)


        // Fragments
        val fragment1 = Fragment1()
        val fragment2 = Fragment2()


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment1)
            commit()
        }


        button.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, fragment1)
                addToBackStack(null)
                commit()
            }
        }


        buttonTwo.setOnClickListener {
            val edit1 = findViewById<EditText>(R.id.edit1)
            fragment2.arguments = passTheData(edit1.text.toString())
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, fragment2)
                addToBackStack(null)
                commit()
            }
        }


    }


    override fun passTheData(passingText: String): Bundle {
        val bundle = Bundle()
        bundle.putString("text", passingText)

        return bundle
    }


}

