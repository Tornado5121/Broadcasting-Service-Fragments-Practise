package com.natife.example.project1.ui.detailScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.natife.example.project1.databinding.FragmentDetailedBinding
import com.natife.example.project1.models.Item

class DetailedFragment : Fragment(), DetailedView {

    private val detailedPresenter by lazy {
        DetailScreenPresenter(requireContext())
    }
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
        detailedPresenter.attachView(this)
        detailedPresenter.getDetailedItem()
    }

    override fun showDetailedItem(item: Item) {
        binding.idTextView.text = item.id.toString()
        binding.nameTextView.text = item.name
        binding.descriptionTextView.text = item.description
    }

    override fun onDestroyView() {
        detailedPresenter.detachView()
        super.onDestroyView()
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