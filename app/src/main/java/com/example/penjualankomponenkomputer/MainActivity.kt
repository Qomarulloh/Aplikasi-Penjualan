package com.example.penjualankomponenkomputer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        lateinit var dbHandler: Order_Menu_DBHandler
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = Order_Menu_DBHandler(this, null, null, 1)


        val menu = ArrayList<Menu_Model>()
        menu.add(
            Menu_Model(
                "Processor",1000000,5,R.drawable.processor,"Processor bisa dibilang adalah otak dari sebuah komputer. Mengapa demikian? Karena setiap proses yang masuk maupun keluar selalui diproses oleh processor ini. Oleh karenanya tidak heran processor merupakan salah satu hardware yang sangat mudah panas. Dan karena mudah terlalu panas ini pula, processor selalu dilindungi oleh Heatsink Fan (kipas pendingin)"
            )
        )
        menu.add(
            Menu_Model(
                "Ram",800000,3,R.drawable.ram, "RAM merupakan alat penyimpanan data sementara. Loh  maksudnya? Perintah, data dan proses lainya disimpan sementara di memory ini. Jika komputer direstart, maka semua yang tersimpan di RAM akan hilang"
            )
        )
        menu.add(
            Menu_Model(
                "Motherboard",1500000,7,R.drawable.motherboard, "Motherboard atau biasa disebut papan induk adalah sebuah hardware yang berfungsi sebagai penghubung semua perangkat komputer lainnya. Jadi, semua perangkat seperti Processor, RAM, Harddisk dan lain sebagainya terhubung menjadi satu di papan induk ini"
            )
        )
        menu.add(
            Menu_Model(
                "Hardisk",700000,2,R.drawable.hardisk, "Harddisk adalah perangkat keras yang berfngsi untuk menyimpan data kita pada komputer. Dengan ini kita dapat menyimpan semua file, dokumen, atau pun berkas-berkas penting lainnya.  Macam-macam harddisk misalnya, ATA, SATA, dan SCSI. Harddisk ada dua jenis yaitu Hdd Internal dan Eksternal."
            )
        )
        menu.add(
            Menu_Model(
                "Power Supply",400000,1,R.drawable.powersupply, "Power supply merupakan perangkat yang terhubung langsung dengan aliran listrik. Perangkat ini berfungsi sebagai pemberi daya listrik yang dapat merubah tegangan AC menjadi DC."
            )
        )
        menu.add(
            Menu_Model(
                "Monitor",1200000,3,R.drawable.monitor, "Merupakan salah satu alat output berupa tampilan visual yang terhubung menggunakan video card."
            )
        )
        menu.add(
            Menu_Model(
                "Vga Card",1500000,3,R.drawable.vga, "Perangkat keras ini merupakan perangkat yang berfungsi untuk mengatur tingkat resolusi gambar atau kualitas gambar. Semakin besar kualitas atau spesifikasi VGA anda, maka akan semakin bagus kualitas gambar yang dihasilkan."
            )
        )
        menu.add(
            Menu_Model(
                "Keyboard",85000,1,R.drawable.keyboard, "Merupakan papan ketik yang berfungsi untuk menampilkan output di layar monitor berupa angka, huruf, simbol-simbol, maupun perintah yang dapat dijalankan menggunakan keyboard."
            )
        )
//        menu.add(
//            Menu_Model(
//                "Mouse",100000,2,R.drawable.mouse, "Sesuai dengan namanya,  bentuk dari perangkat ini menyerupai tikus. Alat yang diberi nama mouse ini berfungsi untuk menggerakan kursor pada layar monitor."
//            )
//        )
        val adapter = Menu_Adapter(this, menu)
        rv.layoutManager= GridLayoutManager(this, 2)
        rv.adapter=adapter

        fabtogle.setOnClickListener{
            startActivity(Intent(this, View_Order::class.java))
        }
    }
}