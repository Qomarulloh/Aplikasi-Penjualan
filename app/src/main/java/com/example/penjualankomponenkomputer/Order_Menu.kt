package com.example.penjualankomponenkomputer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_order__menu.*

class Order_Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order__menu)

        val intent = intent
        val receivedName = intent.getStringExtra("nama")
        val receivedHarga = intent.getStringExtra("harga")
        val receivedDiskon = intent.getStringExtra("diskon")
        val receivedImage = intent.getStringExtra("image")
        if(receivedImage != null){
            img_gambar.setImageResource(receivedImage.toInt())
        }

        tv_namaProduk.text = receivedName
        tv_hargaProduk.text = receivedHarga
        tv_diskonProduk.text = receivedDiskon



        btn_hitung.setOnClickListener{
            if (et_jmlOrder.text.isEmpty())
                Toast.makeText(this, "Masukan Jumlah order", Toast.LENGTH_SHORT).show()
            else {
                val jumlah =
                    tv_hargaProduk.text.toString().toInt() * et_jmlOrder.text.toString().toInt()
                val diskon = jumlah * tv_diskonProduk.text.toString().toInt() / 100
                val hasil = jumlah - diskon
                tv_hasil.text = hasil.toString()
                tv_hasil.visibility = View.VISIBLE
                tv_rp.visibility = View.VISIBLE
                Toast.makeText(this, "Anda Hemat $diskon rupiah", Toast.LENGTH_SHORT).show()

            }
        }

        btn_saveData.setOnClickListener{
            if (et_jmlOrder.text.isEmpty()){
                Toast.makeText(this, "Isi Jumlah Order", Toast.LENGTH_SHORT).show()
            }else{
                val Order_Model = Order_Model()
                Order_Model.str_nmMenu      = tv_namaProduk.text.toString()
                Order_Model.int_jmlOrder    = et_jmlOrder.text.toString().toInt()
                Order_Model.int_hrgMenu     = tv_hargaProduk.text.toString().toInt()
                Order_Model.int_diskon     = tv_diskonProduk.text.toString().toInt()

                MainActivity.dbHandler.addOrder(this, Order_Model)
            }
        }

        btn_orderLagi.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
