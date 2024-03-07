package com.example.enjoyyourmeal.data.repo

import com.example.enjoyyourmeal.data.datasource.OrderDataSource
import com.example.enjoyyourmeal.data.entity.Yemekler

class OrderRepository(var ods:OrderDataSource) {

    suspend fun ekle(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int) = ods.ekle(yemek_adi,yemek_resim_adi,yemek_fiyat)

    suspend fun sepeteEkle(yemek_adi: String,yemek_resim_adi: String,yemek_fiyat: Int) = ods.sepeteEkle(yemek_adi,yemek_resim_adi,yemek_fiyat)

    suspend fun sil(yemek_id : Int) = ods.sil(yemek_id)

    suspend fun urunleriYukle() : List<Yemekler> = ods.urunleriYukle()

    suspend fun sonUrunleriYukle() : List<Yemekler> = ods.sonUrunleriYukle()

    //suspend fun ara(aramaKelimesi:String) : List<Yemekler> = ods.ara(aramaKelimesi)

}