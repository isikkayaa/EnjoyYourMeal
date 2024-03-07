package com.example.enjoyyourmeal.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.enjoyyourmeal.data.entity.Yemekler
import com.example.enjoyyourmeal.data.repo.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var orepo:OrderRepository): ViewModel() {
    var orderListesi = MutableLiveData<List<Yemekler>>()

    init {
        urunleriYukle()
    }



    fun urunleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                orderListesi.value = orepo.urunleriYukle()
            }catch (e:Exception){

            }

        }
    }

   //fun ara(aramaKelimesi: String){
     //   CoroutineScope(Dispatchers.Main).launch {
       //     try {
         //       orderListesi.value = orepo.ara(aramaKelimesi)
           // }catch (e:Exception){
//
    //        }
//
  //      }
   // }




}