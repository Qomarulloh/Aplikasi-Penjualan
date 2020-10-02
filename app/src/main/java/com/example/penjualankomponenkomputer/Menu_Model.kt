package com.example.penjualankomponenkomputer

class Menu_Model {
    var nama : String = ""
    var harga: Int = 0
    var diskon: Int = 0
    var img_produk : Int = 0
    var des: String = ""
    constructor(nama: String, harga: Int, diskon: Int, img_produk: Int, des:String){
        this.nama = nama
        this.harga = harga
        this.diskon = diskon
        this.img_produk = img_produk
        this.des = des
    }
}