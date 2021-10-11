package com.michaelhighsmith.kitchensync2.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.michaelhighsmith.kitchensync2.R
import com.michaelhighsmith.kitchensync2.databinding.FragmentHomeBinding
import com.michaelhighsmith.kitchensync2.ui.NewGroupCreationActivity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater)
        val view = binding.root

        binding.circleView.setOnClickListener {
            val newGroupCreatingActivityIntent = Intent(context, NewGroupCreationActivity::class.java)
            startActivity(newGroupCreatingActivityIntent)
        }

        binding.circleView.borderColor = ContextCompat.getColor(requireContext(), R.color.colorAccent)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
        //    textView.text = it
        })
        return view
    }


}