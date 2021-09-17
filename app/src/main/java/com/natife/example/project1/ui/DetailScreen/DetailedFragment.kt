package com.natife.example.project1.ui.DetailScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.natife.example.project1.databinding.FragmentDetailedBinding
import com.natife.example.project1.models.Item
import com.natife.example.project1.util.ItemsHolder

class DetailedFragment : Fragment()  {

    private val itemId: Int by lazy {
        arguments?.getInt(KEY_ID) ?: throw IllegalStateException("No id passed")
    }

    private lateinit var detailedPresenter: DetailScreenPresenter
    private lateinit var binding: FragmentDetailedBinding
    var item : Item? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDetailed()
    }

     fun showDetailedInfo() {
        binding.idTextView.text = item?.id.toString()
        binding.nameTextView.text = item?.name
        binding.descriptionTextView.text = item?.description
    }

    fun showDetailed() {
        detailedPresenter.showDetailedView(requireContext())
    }

    override fun onDetach() {
        super.onDetach()
        detailedPresenter.detachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        detailedPresenter.destroy()
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