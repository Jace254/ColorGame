package com.example.colorgame

import android.widget.ImageView
import android.widget.ProgressBar

data class Colors(val colorName: String, val colorImage: Int = 0){
    override fun toString(): String {
        return colorName
    }
}

data class GameData(val level: Int,val progress: Int)