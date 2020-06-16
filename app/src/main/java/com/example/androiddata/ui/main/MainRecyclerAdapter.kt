/*
 *  Copyright (C) 2020 Elbert Tous.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.example.androiddata.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddata.R
import com.example.androiddata.data.Monster




/**
 * Class MainRecyclerAdapter
 *
 * @author Elbert Tous <contact@lotous.com.co>
 * @version 1.0
 * @since 2020-06-16 00:57
 */
class MainRecyclerAdapter (
    private val monsters: List<Monster>
) : RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.monster_grid_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val monster = monsters[position]
        with(holder) {
            nameText.let {
                it.text = monster.monsterName
                it.contentDescription = monster.monsterName
            }
            ratingBar.rating = monster.scariness.toFloat()

           val context: Context = holder.itemView.context
            val resourceId:Int = context.resources.getIdentifier(
                monster.imageFile,
                "drawable",
                context.packageName
            )
            monsterImage.setImageResource(resourceId)

        }
    }

    override fun getItemCount(): Int = monsters.size

    class MainViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val nameText: TextView = itemView.findViewById(R.id.nameText)
        val monsterImage : ImageView = itemView.findViewById(R.id.monsterImage)
        val ratingBar : RatingBar = itemView.findViewById(R.id.ratingBar)
    }


}