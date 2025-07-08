package com.renarosantos.ecommerceapp.ui.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.renarosantos.ecommerceapp.data.model.ProductCardViewState
import com.renarosantos.ecommerceapp.databinding.ProductListFragmentBinding
import com.renarosantos.ecommerceapp.ui.adapter.ProductCardListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private lateinit var binding: ProductListFragmentBinding
    private val viewModel: ProductListViewModel by viewModels()
    private val adapter = ProductCardListAdapter(::onItemClicked)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductListFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewProductList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.viewProductList.adapter = adapter
        viewModel.viewState.observe(viewLifecycleOwner) { viewState ->
            updateUI(viewState)
        }
        viewModel.loadProductList()
    }

    private fun updateUI(viewState: ProductListViewState) {
        when (viewState) {
            is ProductListViewState.Content -> {
                binding.loadingView.isVisible = false
                binding.errorView.isVisible = false
                binding.viewProductList.isVisible = true
                adapter.setData(viewState.productList)
            }

            ProductListViewState.Error -> {
                binding.loadingView.isVisible = false
                binding.errorView.isVisible = true
                binding.viewProductList.isVisible = false
            }

            ProductListViewState.Loading -> {
                binding.viewProductList.isVisible = false
                binding.loadingView.isVisible = true
                binding.errorView.isVisible = false
            }
        }
    }

    private fun onItemClicked(viewState: ProductCardViewState) {
        findNavController().navigate(ProductListFragmentDirections.actionProductListFragmentToProductDetailsFragment())
    }
}