package com.example.laba1.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laba1.model.Recipe
import com.example.laba1.R
import com.example.laba1.Adapter.AdapterListRecipes

class ListRecipes: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_list_recipes, container, false)
        val arrayNames = requireContext().resources.getStringArray(R.array.recipes_name)
        val list = mutableListOf <Recipe>()
        arrayNames.forEach{
            val id = arrayNames.indexOf(it)
            list.add(Recipe(id, it, "Очень вкусный $it", it))
        }
        val adapter = AdapterListRecipes({
            Navigation.findNavController(view).navigate(R.id.selected);
         }, list as List<Recipe>)
        view.findViewById<RecyclerView>(R.id.list_recieps_rv).layoutManager = GridLayoutManager(requireContext(), 2)
        view!!.findViewById<RecyclerView>(R.id.list_recieps_rv).adapter = adapter
        return view
    }

}