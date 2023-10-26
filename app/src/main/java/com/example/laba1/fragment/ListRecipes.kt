package com.example.laba1.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laba1.model.Recipe
import com.example.laba1.R
import com.example.laba1.Adapter.AdapterListRecipes
import com.example.laba1.api.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListRecipes: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_list_recipes, container, false)
        lateinit var list: List<Recipe>
        println("Tut")
        Common.retrofitService.getRecipes().enqueue(object :
            Callback<List<Recipe>> {
            override fun onFailure(call: Call<List<Recipe>>, t: Throwable) {
                println("egr")
            }

            override fun onResponse(call: Call<List<Recipe>>, response: Response<List<Recipe>>) {
                println("Успех ${response.body()}")
                list = response.body()!!
                list.forEach{
                    Log.e("", "Название ${it.Name}\n" +
                            "Каллорийность ${it.Calorie}\n" +
                            "Время приготовления: ${it.Time} \n" +
                            "Сложность ${it.Difficulty}\n" +
                            "Ингредиенты: ${it.Ingredients}")
                }
                val adapter = AdapterListRecipes(list)
                view.findViewById<RecyclerView>(R.id.list_recieps_rv).layoutManager = GridLayoutManager(requireContext(), 2)
                view!!.findViewById<RecyclerView>(R.id.list_recieps_rv).adapter = adapter
            }
        })
        return view
    }
}