package com.example.colorgame

import android.content.ClipDescription
import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class colorBoxRecyclerAdpater(private val context: Context, private var colorBoxes: List<Colors>):
    RecyclerView.Adapter<colorBoxRecyclerAdpater.viewHolder>(){
    private val layoutInflater = LayoutInflater.from(context)
    private val yayMp = MediaPlayer.create(context,R.raw.yay_sound_fx)
    private val colorB = colorBoxes.shuffled()



    inner class viewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
        val colorName = itemView?.findViewById<TextView>(R.id.color_name)
        val colorBox = itemView?.findViewById<LinearLayout>(R.id.color_view)
        var colorBoxPosition = 0
        init{
            Drag()

        }

        private fun Drag() {
            val dragListener = View.OnDragListener{ view, event ->
                when(event.action){
                    DragEvent.ACTION_DRAG_STARTED -> {
                        event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                        true
                    }
                    DragEvent.ACTION_DRAG_ENTERED -> {
                        view.invalidate()
                        true
                    }
                    DragEvent.ACTION_DRAG_LOCATION -> false

                    DragEvent.ACTION_DRAG_EXITED -> false
                    DragEvent.ACTION_DROP -> {
                        view.invalidate()

                        val v = event.localState as View
                        val owner = v.parent as ViewGroup
                        owner.removeView(v)
                        val destination = view as LinearLayout
                        destination.addView(v)

                        checkWin(v,destination)
                        true
                    }
                    DragEvent.ACTION_DRAG_ENDED -> {
                        val v = event.localState as View
                        v.visibility = View.VISIBLE
                        view.invalidate()
                        true
                    }
                    else -> false
                }
            }
            colorBox?.setOnDragListener(dragListener)
        }

        private fun checkWin(v: View, destination: View) {
            val color = v.contentDescription.toString()
            val destColor = destination.findViewById<TextView>(R.id.color_name).text.toString()
            if(color == destColor){
                yayMp.start()
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView = layoutInflater.inflate(R.layout.color_box_item,parent,false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        Log.i("pos","${position}")
        Log.i("color","${colorB[position]}")
        val colorB = colorB[position]
        holder.colorName?.text = colorB.colorName
        holder.colorBoxPosition = position

    }

    override fun getItemCount() = colorBoxes.size

}
