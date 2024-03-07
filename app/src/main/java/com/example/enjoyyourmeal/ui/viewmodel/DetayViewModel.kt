package com.example.enjoyyourmeal.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.enjoyyourmeal.data.repo.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetayViewModel @Inject constructor(var orepo:OrderRepository) : ViewModel() {

    fun sepeteEkle(yemek_adi: String,yemek_resim_adi: String,yemek_fiyat: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            orepo.sepeteEkle(yemek_adi,yemek_resim_adi,yemek_fiyat)
        }
    }
}