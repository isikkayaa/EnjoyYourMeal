package com.example.enjoyyourmeal.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.enjoyyourmeal.R
import com.example.enjoyyourmeal.databinding.FragmentAnasayfaBinding
import com.example.enjoyyourmeal.ui.adapter.OrderAdapter
import com.example.enjoyyourmeal.ui.viewmodel.AnasayfaViewModel
import com.example.enjoyyourmeal.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)
        binding.anasayfaFragment = this



        viewModel.orderListesi.observe(viewLifecycleOwner){
            val orderAdapter = OrderAdapter(requireContext(),it)
            binding.orderAdapter = orderAdapter
        }

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_anasayfaFragment_to_sepetFragment)
        }

        //binding.searchView.setOnQueryTextListener(object  : android.widget.SearchView.OnQueryTextListener {
          //  override fun onQueryTextChange(newText: String): Boolean {
            //    ara(newText)
              //  return true
            //}

            //override fun onQueryTextSubmit(query: String): Boolean {
              //  ara(query)
                //return true

  //          }


     //   })


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnasayfaViewModel by viewModels()
        viewModel = tempViewModel

    }

    fun fabTikla(it:View){
        Navigation.gecisYap(it,R.id.action_anasayfaFragment_to_sepetFragment)

    }

    override fun onResume() {
        super.onResume()
        viewModel.urunleriYukle()
    }

   // fun ara(aramaKelimesi:String){

    //}


}
