package com.example.enjoyyourmeal.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.enjoyyourmeal.R
import com.example.enjoyyourmeal.data.entity.Yemekler
import com.example.enjoyyourmeal.databinding.CardDesignBinding
import com.example.enjoyyourmeal.ui.viewmodel.SepetViewModel
import com.google.android.material.snackbar.Snackbar

class DesignAdapter(var mContext: Context, var orderListesi: List<Yemekler>, var viewModel:SepetViewModel) : RecyclerView.Adapter<DesignAdapter.CardDesignTutucu>() {
    inner class CardDesignTutucu(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignTutucu{
        val binding: CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_design,parent,false)
        return CardDesignTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardDesignTutucu, position: Int) {
        val ordder = orderListesi.get(position)
        val y = holder.design




        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${ordder.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(300,300).into(y.imageView2)

        y.orderNesnesi = ordder


        y.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${ordder.yemek_adi} silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.sil(ordder.yemek_id)
                }
                .show()
        }


    }

    override fun getItemCount(): Int {
        return orderListesi.size
    }




}