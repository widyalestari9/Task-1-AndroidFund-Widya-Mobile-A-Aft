package com.widya.foodiest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.widya.foodiest.adapter.FoodAdapter
import com.widya.foodiest.databinding.FragmentVegetarianBinding
import com.widya.foodiest.model.DataRecipes
import com.widya.foodiest.model.Recipes

class VegetarianFragment : Fragment() {
    private lateinit var vegetarianBinding: FragmentVegetarianBinding
    private var list : ArrayList<Recipes> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        vegetarianBinding = FragmentVegetarianBinding.inflate(inflater,container,false)

        return vegetarianBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.addAll(DataRecipes.dataVegetarian)
        vegetarianBinding.rvVegetarian.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context,2)
            val foodAdapter = FoodAdapter(list)
            adapter = foodAdapter
        }
    }

}