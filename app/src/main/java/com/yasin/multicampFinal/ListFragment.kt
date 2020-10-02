package com.yasin.multicampFinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.yasin.multicampFinal.ListFragmentDirections
import com.yasin.multicampFinal.adapter.CommunitiesAdapter
import com.yasin.multicampFinal.data.model.RetrofitProvider
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {

            val response = RetrofitProvider.newsApi.getCommunities()
            val adapter= CommunitiesAdapter(response.orEmpty().toMutableList()){
                val direction:NavDirections= ListFragmentDirections.actionListFragmentToDetailsFragment(it)
                findNavController().navigate(direction)
            }
            communitiesRecyclerView.adapter=adapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_list,
            container,
            false
        )
    }

}
