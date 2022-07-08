package com.example.colorgame

object DataManager {
    var colors = ArrayList<Colors>()

    init{
        initializeColors()
    }

    private fun initializeColors() {
        var color = Colors("red", R.drawable.ic_red)
        colors.add(color)
        color = Colors("blue", R.drawable.ic_blue)
        colors.add(color)
        color = Colors("yellow", R.drawable.ic_yellow)
        colors.add(color)
        color = Colors("green", R.drawable.ic_green)
        colors.add(color)
        //color = Colors("purple", R.drawable.ic_purple)
        //colors.add(color)
        //color = Colors("orange", R.drawable.ic_orange)
        //colors.add(color)
    }


}
