package com.basiatish.hammersystemstestapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.basiatish.hammersystemstestapp.databinding.MenuFragmentBinding
import com.basiatish.hammersystemstestapp.databinding.Test2Binding
import com.basiatish.hammersystemstestapp.databinding.TestBinding
import kotlin.math.abs

class MenuFragment : Fragment() {

    private var _binding: MenuFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MenuFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val items = listOf<String>("Pizza", "Pizza", "Pizza", "Pizza", "Pizza", "Pizza", "Pizza", "Pizza", "Pizza", "Pizza", "Pizza", "Pizza", "Pizza", "Pizza", "Pizza", "Pizza", "Pizza")
        val adapter = object : RecyclerView.Adapter<ItemHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
                return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.menu_list_item, parent, false))
            }
            override fun getItemCount(): Int {
                return items.size
            }
            override fun onBindViewHolder(holder: ItemHolder, position: Int) {
            }
        }
        val layoutManager = LinearLayoutManager(requireContext())
        binding.menuList.adapter = adapter
        binding.menuList.layoutManager = layoutManager

        binding.appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (abs(verticalOffset) - appBarLayout.totalScrollRange == 0)
            {
                binding.categoriesContainer.setBackgroundColor(resources.getColor(R.color.white, requireContext().theme))
            }
            else
            {
                binding.categoriesContainer.setBackgroundColor(resources.getColor(R.color.background, requireContext().theme))
            }
        }
//        val items2 = listOf<String>("Pizza", "Pizza", "Pizza", "Pizza", "Pizza", "Pizza")
//        val adapter2 = object : RecyclerView.Adapter<ItemHolder2>() {
//            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder2 {
//                return ItemHolder2(LayoutInflater.from(parent.context).inflate(R.layout.menu_list_item, parent, false))
//            }
//            override fun getItemCount(): Int {
//                return items2.size
//            }
//            override fun onBindViewHolder(holder: ItemHolder2, position: Int) {
//            }
//        }
//        val layoutManager2 = LinearLayoutManager(requireContext())
//        binding.menuList2.adapter = adapter2
//        binding.menuList2.layoutManager = layoutManager2
    }

    inner class ItemHolder(view: View): RecyclerView.ViewHolder(view) {
        var textField: TextView = view.findViewById(R.id.text) as TextView
    }

    inner class ItemHolder2(view: View): RecyclerView.ViewHolder(view) {
        var textField: TextView = view.findViewById(R.id.text) as TextView
    }

}