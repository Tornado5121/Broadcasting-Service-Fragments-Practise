package com.natife.example.project1.ui.itemListScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.natife.example.project1.R
import com.natife.example.project1.databinding.FragmentListItemBinding
import com.natife.example.project1.models.Item
import com.natife.example.project1.ui.detailScreen.DetailedFragment
import com.natife.example.project1.ui.adapters.ItemAdapter

class ItemListFragment : Fragment(), ItemListView {

    private lateinit var binding: FragmentListItemBinding
    private val itemPresenter by lazy {
        ItemListPresenter(requireContext())
    }
    private val adapter by lazy {
        ItemAdapter {
            itemPresenter.saveIdToSharedPrefs(it.id)

            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_activity_fragment_container, DetailedFragment.newInstance(it.id))
                .addToBackStack("")
                .commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemPresenter.attachView(this)
        binding.itemList.layoutManager = LinearLayoutManager(activity)
        binding.itemList.adapter = adapter
        itemPresenter.getItems()
    }

    override fun showItems(items: List<Item>) {
        adapter.submitList(items)
    }

    override fun onDestroyView() {
        itemPresenter.detachView()
        super.onDestroyView()
    }
}