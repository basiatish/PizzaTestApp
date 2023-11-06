package com.basiatish.hammersystemstestapp.ui.menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.basiatish.hammersystemstestapp.App
import com.basiatish.hammersystemstestapp.R
import com.basiatish.hammersystemstestapp.databinding.MenuFragmentBinding
import javax.inject.Inject
import kotlin.math.abs

class MenuFragment : Fragment() {

    private var _binding: MenuFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MenuListAdapter

    @Inject
    lateinit var viewModel: MenuViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.menuComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MenuFragmentBinding.inflate(layoutInflater, container, false)
        viewModel.getMenu()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = MenuListAdapter()
        val layoutManager = LinearLayoutManager(requireContext())
        binding.menuList.adapter = adapter
        binding.menuList.layoutManager = layoutManager

        setupObservers()
        setupListeners()
    }

    private fun setupObservers() {
        viewModel.menu.observe(this.viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                adapter.submitList(it)
            }
        }
        viewModel.error.observe(this.viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupListeners() {
        binding.appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (abs(verticalOffset) - appBarLayout.totalScrollRange == 0)
                binding.categoriesContainer.setBackgroundColor(
                    resources.getColor(R.color.white, requireContext().theme))
            else
                binding.categoriesContainer.setBackgroundColor(
                    resources.getColor(R.color.background, requireContext().theme))
        }
    }
}