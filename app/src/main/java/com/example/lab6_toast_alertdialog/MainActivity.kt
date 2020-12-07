package com.example.lab6_toast_alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab6_toast_alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //在Activity中使用View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //使用binding對象訪問視圖
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}