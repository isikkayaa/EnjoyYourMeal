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
class SepetViewModel @Inject constructor(var orepo:OrderRepository): ViewModel() {
    var orderListesi = MutableLiveData<List<Yemekler>>()

    fun sonUrunleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            orderListesi.value = orepo.sonUrunleriYukle()
        }
    }

    fun sil(yemek_id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            orepo.sil(yemek_id)
            sonUrunleriYukle()
        }
    }


}