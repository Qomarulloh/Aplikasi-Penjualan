package com.example.penjualankomponenkomputer

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_menu.view.*

class Menu_Adapter (mCtx: Context, val ViewOrder: ArrayList<Menu_Model>): RecyclerView.Adapter<Menu_Adapter.ViewHolder>() {

    val mCtx = mCtx

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Nmenu = itemView.tv_nama
        val Harga = itemView.tv_harga
        val diskon = itemView.tv_diskon
        val img= itemView.imageView
        val desk = itemView.tc_des
        val btn_beli = itemView.btn_save
        val context = itemView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_menu, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Orderan = ViewOrder[position]
        holder.Nmenu.text = Orderan.nama
        holder.Harga.text = Orderan.harga.toString()
        holder.diskon.text = Orderan.diskon.toString()
        holder.img.setImageResource(ViewOrder[position].img_produk)
        holder.desk.text = Orderan.des

        holder.img.setOnClickListener{
            AlertDialog.Builder(mCtx).setTitle("Detail Produk").setMessage(holder.desk.text).show()
        }

        holder.btn_beli.setOnClickListener{
            val intent = Intent(holder.context, Order_Menu::class.java)
            intent.putExtra("nama", holder.Nmenu.text)
            intent.putExtra("harga", holder.Harga.text).toString()
            intent.putExtra("diskon", holder.diskon.text).toString()
            intent.putExtra("image", ViewOrder[position].img_produk.toString())
            holder.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return ViewOrder.size
    }
}

private operator fun Int.get(position: Int): String? {
    return position.toString()
}
