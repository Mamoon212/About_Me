package com.mo2a.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.mo2a.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Lorem Ipsum")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.button.setOnClickListener {
            showNickname(it)
        }
        binding.myName = myName
    }

    private fun showNickname(view: View) {
        binding.apply {
            myName?.nickname = editText.text.toString()
            // Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()
            textView.visibility = View.VISIBLE
            editText.visibility = View.GONE
            button.visibility = View.GONE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

data class MyName(var name: String = "", var nickname: String = "")