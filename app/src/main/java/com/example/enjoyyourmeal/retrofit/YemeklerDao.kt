package com.example.enjoyyourmeal.retrofit

import com.example.enjoyyourmeal.data.entity.CRUDCevap
import com.example.enjoyyourmeal.data.entity.YemeklerCevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerDao{

    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/ -> base url
    //yemekler/tumYemekleriGetir.php  -> webservis url

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun urunleriYukle() : YemeklerCevap

    @GET("yemekler/sepettekiYemekleriGetir.php")
    suspend fun  sonUrunleriYukle(): YemeklerCevap


    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun ekle(@Field("yemek_adi") yemek_adi:String,
                     @Field("yemek_resim_adi") yemek_resim_adi:String,
                     @Field("yemek_fiyat") yemek_fiyat:Int) : CRUDCevap

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun sepeteEkle(@Field("yemek_adi") yemek_adi: String,
                           @Field("yemek_resim_adi") yemek_resim_adi: String,
                           @Field("yemek_fiyat") yemek_fiyat: Int) : CRUDCevap


    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun sil(@Field("yemek_id") yemek_id : Int) : CRUDCevap


    //suspend fun ara(aramaKelimesi:String) : YemeklerCevap








}