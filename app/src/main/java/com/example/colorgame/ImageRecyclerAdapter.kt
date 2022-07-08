package com.example.colorgame

import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
/*
class ImageRecyclerAdapter(private val context: Context, private val colors: List<Colors>):
    RecyclerView.Adapter<ImageRecyclerAdapter.viewHolder>(){
    private val layoutInflater = LayoutInflater.from(context)


    inner class viewHolder (itemView: View?): RecyclerView.ViewHolder(itemView!!){
        val colorImage = itemView?.findViewById<ImageView>(R.id.color_image)
        var colorPosition = 0
        init{
            onDrag(itemView!!)
        }
        fun onDrag(view: View) {
            view.setOnLongClickListener {
                val clipText = colorPosition.toString()
                val item = ClipData.Item(clipText)
                val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)

                val data = ClipData(clipText, mimeTypes, item)
                val dragShadowBuilder = View.DragShadowBuilder(it)
                it.startDragAndDrop(data, dragShadowBuilder, it, 0)

                it.visibility = View.INVISIBLE
                true
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView = layoutInflater.inflate(R.layout.color_box_image,parent,false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val color = colors[position]
        holder.colorImage?.setImageResource(color.colorImage)
        holder.colorImage?.contentDescription = color.colorName
        holder.colorPosition = position
    }

    override fun getItemCount() = colors.size

}*/

