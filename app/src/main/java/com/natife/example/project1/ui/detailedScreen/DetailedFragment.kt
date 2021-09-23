package com.natife.example.project1.ui.detailedScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.natife.example.project1.databinding.FragmentDetailedBinding

class DetailedFragment : Fragment() {

    private lateinit var binding: FragmentDetailedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val detailedFragmentViewModel = DetailedFragmentViewModel(requireContext())
        arguments?.let { detailedFragmentViewModel.getDetailedItem(it.getInt(KEY_ID)) }
        detailedFragmentViewModel.detailedItemToAttach.observe(viewLifecycleOwner, {
            binding.idTextView.text = it.id.toString()
            binding.nameTextView.text = it.name
            binding.descriptionTextView.text = it.description
        })
    }

    companion object {
        const val KEY_ID = "id"
        fun newInstance(id: Int): DetailedFragment {
            return DetailedFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_ID, id)
                }
            }
        }
    }
}