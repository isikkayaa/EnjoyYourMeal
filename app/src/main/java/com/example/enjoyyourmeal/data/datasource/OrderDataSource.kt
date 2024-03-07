package com.example.enjoyyourmeal.data.datasource

import com.example.enjoyyourmeal.data.entity.Yemekler
import com.example.enjoyyourmeal.retrofit.YemeklerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OrderDataSource(var ydao:YemeklerDao) {

    suspend fun urunleriYukle() : List<Yemekler> =
        withContext(Dispatchers.IO){

            return@withContext ydao.urunleriYukle().yemekler
        }

    suspend fun sonUrunleriYukle() : List<Yemekler> =
        withContext(Dispatchers.IO){

            return@withContext ydao.sonUrunleriYukle().yemekler
        }

    //suspend fun ara(aramaKelimesi:String)  : List<Yemekler> =
      //  withContext(Dispatchers.IO) {

        //    return@withContext ydao.ara(aramaKelimesi).yemekler
        //}


    suspend fun  ekle(yemek_ad:String,yemek_resim_adi:String,yemek_fiyat:Int){
        ydao.ekle(yemek_ad,yemek_resim_adi,yemek_fiyat)

    }

    suspend fun sepeteEkle(yemek_ad: String,yemek_resim_adi: String,yemek_fiyat: Int){
        ydao.sepeteEkle(yemek_ad,yemek_resim_adi,yemek_fiyat)

    }

    suspend fun sil(yemek_id : Int){
        ydao.sil(yemek_id)


    }






}