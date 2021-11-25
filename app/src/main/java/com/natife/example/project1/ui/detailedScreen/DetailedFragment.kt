package com.natife.example.project1.ui.detailedScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natife.example.project1.databinding.FragmentDetailedBinding

class DetailedFragment : Fragment() {
    private lateinit var binding: FragmentDetailedBinding
    private val itemId by lazy {
        arguments?.getInt(KEY_ID) ?: throw IllegalStateException("No id passed")
    }

    val reducer: DetailedScreenReducer by lazy { DetailedScreenReducer(itemId) }
    val useCase by lazy { DisplayDeatiledScreenUseCase() }
    private val detailedScreenViewModel: DetailedScreenViewModel by lazy {
        ViewModelProvider(viewModelStore, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return DetailedScreenViewModel(reducer, useCase) as T
            }
        }).get(DetailedScreenViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailedScreenViewModel.state.observe(viewLifecycleOwner, ::renderDetailedState)
        detailedScreenViewModel.getData()
    }

    private fun renderDetailedState(newState: DetailedScreenStates) {
        newState.item?.also { item ->
            binding.idTextView.text = item.id.toString()
            binding.nameTextView.text = item.name
            binding.descriptionTextView.text = item.description
        }
    }

    companion object {
        private const val KEY_ID = "id"
        fun newInstance(id: Int): DetailedFragment {
            return DetailedFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_ID, id)
                }
            }
        }
    }
}