package com.example.sportsapp_cardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter

class SportAdapter (val sportsList:ArrayList<SportModel>): RecyclerView.Adapter<SportAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        // create and return a new viewHolder Instance for each item in the list
        var v = LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        // Bind data to views based on the item at the specified position
        holder.sportsImg.setImageResource(sportsList[position].sportImg)
        holder.sportsName.setText(sportsList[position].sportName)

    }

    override fun getItemCount(): Int {

        // return the size of the list
        return sportsList.size
    }

    // ViewHolder: Holds references to the views in the layout
    inner class MyViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        var sportsImg: ImageView
        var sportsName: TextView

        init {
            sportsImg = itemView.findViewById(R.id.imageViewCard)
            sportsName = itemView.findViewById(R.id.textView)

            // Handling the click events on cardview
            itemView.setOnClickListener() {
                Toast.makeText(
                    itemView.context,
                    "You Clicked:  ${ sportsList[adapterPosition].sportName }", Toast.LENGTH_SHORT).show()
            }
        }
    }

    }