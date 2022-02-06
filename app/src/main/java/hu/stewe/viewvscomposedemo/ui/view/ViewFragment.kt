package hu.stewemetal.viewvscomposedemo.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hu.stewemetal.viewvscomposedemo.R
import hu.stewemetal.viewvscomposedemo.model.Item

class ViewFragment : Fragment() {

    lateinit var adapter: ViewItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View =
        inflater.inflate(R.layout.fragment_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ViewItemAdapter()
        val list = view.findViewById<RecyclerView>(R.id.list)
        list.adapter = adapter

        adapter.submitList(
            mutableListOf<Item>().apply {
                (1..30).forEach {
                    add(Item("View item $it"))
                }
            }
        )
    }
}
