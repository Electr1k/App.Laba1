package com.example.laba1.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laba1.model.Recipe
import com.example.laba1.R


class AdapterListRecipes (
    private val listener: (View) -> Unit,
    private val recipeList: List<Recipe>
): RecyclerView.Adapter<AdapterListRecipes.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recipe_card,parent,false)
        return  RecipeViewHolder(view)
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.recipe_name.text = recipeList[position].name
        holder.recipe_substring.text = recipeList[position].substring
        holder.itemView.setOnClickListener(
            listener
        )
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }


    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recipe_name: TextView
        var recipe_substring: TextView

        init {
            recipe_name = itemView.findViewById(R.id.name)
            recipe_substring = itemView.findViewById(R.id.substring)
        }
    }
}