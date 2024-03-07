package com.example.enjoyyourmeal.data.entity

import java.io.Serializable

class Yemekler(var yemek_id:Int,
               var yemek_adi:String,
               var yemek_resim_adi :String,
               var yemek_fiyat: Int) :Serializable {
}