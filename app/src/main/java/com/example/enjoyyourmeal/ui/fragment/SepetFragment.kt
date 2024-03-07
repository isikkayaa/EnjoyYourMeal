package com.example.enjoyyourmeal.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.enjoyyourmeal.R
import com.example.enjoyyourmeal.databinding.FragmentSepetBinding
import com.example.enjoyyourmeal.ui.adapter.DesignAdapter
import com.example.enjoyyourmeal.ui.adapter.OrderAdapter
import com.example.enjoyyourmeal.ui.viewmodel.SepetViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() {
    private lateinit var binding:FragmentSepetBinding
    private lateinit var viewModel:SepetViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet, container, false)
        binding.sepetFragment = this

        val bundle:SepetFragmentArgs by navArgs()
        val ordder = bundle.ordder
        binding.orderNesnesi = ordder


        viewModel.orderListesi.observe(viewLifecycleOwner){
            val designAdapter = DesignAdapter(requireContext(),it,viewModel)
            binding.designAdapter = designAdapter
        }


        return binding.root
    }

    fun buttonOnayTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.action_sepetFragment_to_animationFragment)
    }


}
