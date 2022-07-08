package com.example.colorgame

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.colorgame.databinding.ActivityLevelBinding

class LevelsActivity :AppCompatActivity () {
    private lateinit var binding : ActivityLevelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLevelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = binding.levels.playButton

        button.setOnClickListener{
            startActivity(Intent(this,GameActivity::class.java))
        }
    }
}