package com.example.colorgame

import android.content.ClipData
import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.iterator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colorgame.databinding.ActivityMainBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var colorBoxItems: RecyclerView
    //private lateinit var colorItems: RecyclerView
    private var size = DataManager.colors.size

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        colorBoxItems = binding.content.colorCardsView
        //colorItems = binding.content.colorImageView

        colorBoxItems.layoutManager = GridLayoutManager(this,2)
        colorBoxItems.adapter = colorBoxRecyclerAdpater(this, DataManager.colors)

       //colorItems.layoutManager = GridLayoutManager(this,size)
        //colorItems.adapter = ImageRecyclerAdapter(this,DataManager.colors)
        val colorItems = binding.content.colorItems
        for(item in colorItems){
            item.setOnLongClickListener {
                val clipText = "color ${item.contentDescription.toString()}"
                val item = ClipData.Item(clipText)
                val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)

                val data = ClipData(clipText, mimeTypes, item)
                val dragShadowBuilder = View.DragShadowBuilder(it)
                it.startDragAndDrop(data, dragShadowBuilder, it, 0)

                it.visibility = View.INVISIBLE
                true
            }
        }

        val dragListener = View.OnDragListener{ view, event ->
            when(event.action){
                DragEvent.ACTION_DRAG_STARTED -> {
                    event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                    true
                }
                DragEvent.ACTION_DRAG_ENTERED -> false
                DragEvent.ACTION_DRAG_LOCATION -> false
                DragEvent.ACTION_DRAG_EXITED -> {
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DROP -> false
                DragEvent.ACTION_DRAG_ENDED -> {
                    view.invalidate()
                    true
                }
                else -> false
            }
        }
        colorItems.setOnDragListener(dragListener)

    }
}