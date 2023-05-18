package com.example.libihb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val myList: List<TravelMemories>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    /**
     * This provides a reference to my type of view
     * (custom ViewHolder)
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.title_img)
        val placeName: TextView = itemView.findViewById(R.id.place_name)
        val placeLocation: TextView = itemView.findViewById(R.id.place_location)
        val dateOfTravel: TextView = itemView.findViewById(R.id.date_of_travel)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        /**
         * i have to create a layout_for_list_item  view object from the  xml "blueprint"
         * this turns the layout file into a view object :
         * inflate( first argument - the row layout i want to inflate , second one - what i plan to put this view into so that
         * the perfect size is assigned, third  - boolean for adding the view to the recycle view right now
         */
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_for_list_item, parent, false)
        return ViewHolder(itemView)
    }
// this method is called a lot :))
    /**
     * this method takes as an argument a view holder and assigns it with the data of my corresponding item
     */

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = myList[position]
        holder.imageView.setImageResource(currentItem.titleImg)
        holder.placeName.text = currentItem.placeName
        holder.placeLocation.text = currentItem.placeLocation
        holder.dateOfTravel.text = currentItem.dateOfTravel

    }

    override fun getItemCount() = myList.size


}




