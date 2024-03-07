package com.example.enjoyyourmeal.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.enjoyyourmeal.R
import com.example.enjoyyourmeal.data.entity.Yemekler
import com.example.enjoyyourmeal.databinding.CardTasarimBinding
import com.example.enjoyyourmeal.ui.fragment.AnasayfaFragmentDirections
import com.example.enjoyyourmeal.ui.viewmodel.AnasayfaViewModel
import com.example.enjoyyourmeal.util.gecisYap
import com.google.android.material.snackbar.Snackbar

class OrderAdapter(var mContext: Context, var orderListesi: List<Yemekler>) : RecyclerView.Adapter<OrderAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding: CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val order = orderListesi.get(position)
        val t = holder.tasarim




        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${order.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(300,300).into(t.imageViewUrun)

        t.orderNesnesi = order


        t.cardViewOrder.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(order=order)
            Navigation.gecisYap(it,gecis)
        }

        t.buttonSepet.setOnClickListener {
            Snackbar.make(it,"${order.yemek_adi} sepete eklendi!",Snackbar.LENGTH_SHORT)
                .show()
        }

    }

    override fun getItemCount(): Int {
        return orderListesi.size
    }




}


