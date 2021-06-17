package com.example.accodechallenge.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.accodechallenge.R
import com.example.accodechallenge.databinding.FragmentContactsSearchBinding
import com.example.accodechallenge.screens.common.RecyclerDecoration
import com.example.accodechallenge.screens.common.SingleLineTextAdapter
import com.example.accodechallenge.util.tryHideKeyboardIfVisible

class ContactsSearchFragment : Fragment() {

    private lateinit var binding: FragmentContactsSearchBinding
    private lateinit var adapter: SingleLineTextAdapter
    val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contacts_search, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SingleLineTextAdapter()
        viewModel.watchNameEmailList().observe(viewLifecycleOwner, { adapter.setTextItems(it) })
        binding.contactRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ContactsSearchFragment.adapter
            addItemDecoration(
                RecyclerDecoration(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    ContextCompat.getDrawable(requireContext(), R.drawable.indented_list_divider)
                )
            )
        }

        binding.searchButton.setOnClickListener {
            requireActivity().tryHideKeyboardIfVisible()
            val searchString = binding.searchEditText.text.toString()
            val isValid = viewModel.validateSearchString(searchString)
            if (!isValid) {
                binding.searchInputLayout.error = getString(R.string.enter_a_name)
            } else {
                binding.searchInputLayout.error = null
                lifecycleScope.launchWhenCreated { viewModel.searchForContacts(searchString) }
            }
        }
    }
}