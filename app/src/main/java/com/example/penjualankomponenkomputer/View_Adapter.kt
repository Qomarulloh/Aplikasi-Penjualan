package com.example.penjualankomponenkomputer

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_view_order.view.*

class View_Adapter (mCtx: Context, val ViewOrder: ArrayList<Order_Model>): RecyclerView.Adapter<View_Adapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): View_Adapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_view_order, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: View_Adapter.ViewHolder, position: Int) {
        val Orderan = ViewOrder[position]
        holder.Nmenu.text = Orderan.str_nmMenu
        holder.Harga.text = Orderan.int_hrgMenu.toString()
        holder.jmlOrder.text = Orderan.int_jmlOrder.toString()
        holder.diskon.text = Orderan.int_diskon.toString()
        holder.total.text = Orderan.int_totalHarga.toString()
        holder.et_edit.setText(Orderan.int_jmlOrder.toString())

        holder.hapus.setImageResource(R.drawable.ic_baseline_delete_24)

        holder.hapus.setOnClickListener{
            val menuName = Orderan.str_nmMenu
            AlertDialog.Builder(mCtx).setTitle("Delete")
                .setMessage("Yakin ingin hapus data : $menuName ?")
                .setPositiveButton("Yes", DialogInterface.OnClickListener{
                        dialog, which -> if (MainActivity.dbHandler.deleteOrder(Orderan.str_id)){
                    ViewOrder.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, ViewOrder.size)
                    Toast.makeText(mCtx, "Barang $menuName dihapus", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(mCtx, "Terjadi kesalahan penghapusan", Toast.LENGTH_SHORT).show()
                }
                })
                .setNegativeButton("No", DialogInterface.OnClickListener{
                        dialog, which ->
                }).setIcon(R.drawable.ic_baseline_warning_24).show()
        }
        holder.edit.setOnClickListener{
            AlertDialog.Builder(mCtx).setTitle("Edit Jumlah Order")
                .setMessage(holder.et_edit.text)
                .setPositiveButton("Yes", DialogInterface.OnClickListener{
                        dialog, which -> if (MainActivity.dbHandler.deleteOrder(Orderan.str_id)){
                    ViewOrder.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, ViewOrder.size)
                    Toast.makeText(mCtx, "Berhasil edit data", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(mCtx, "Terjadi kesalahan penghapusan", Toast.LENGTH_SHORT).show()
                }
                })
                .setNegativeButton("No", DialogInterface.OnClickListener{
                        dialog, which ->
                }).setIcon(R.drawable.ic_baseline_warning_24).show()
        }
    }

    override fun getItemCount(): Int {
        return ViewOrder.size
    }

    val mCtx = mCtx
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val Nmenu = itemView.tv_namaView
        val Harga = itemView.tv_hargaView
        val jmlOrder = itemView.tv_jmlOrderView
        val diskon = itemView.tv_diskonView
        val total = itemView.tv_total
        val hapus = itemView.btn_delete
        val edit = itemView.btn_edit
        val et_edit = itemView.et_edit
    }
}