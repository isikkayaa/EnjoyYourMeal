package com.example.enjoyyourmeal.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgument
import com.bumptech.glide.Glide
import com.example.enjoyyourmeal.R
import com.example.enjoyyourmeal.databinding.FragmentDetayBinding
import com.example.enjoyyourmeal.ui.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel : DetayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detay,container,false)
        binding.detayFragment = this


        val bundle:DetayFragmentArgs by navArgs()
        val order = bundle.order
        binding.orderNesnesi = order

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${order.yemek_resim_adi}"
        Glide.with(this).load(url).override(300,300).into(binding.ivOrder)


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonSepeteEkleTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.action_detayFragment_to_sepetFragment)
    }


}
