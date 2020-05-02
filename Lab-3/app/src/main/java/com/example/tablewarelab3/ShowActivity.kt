package com.example.tablewarelab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_show.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter

class ShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        val collection = getList()
        println(collection.size)
        if(collection.isNotEmpty())
        {
            list_recycler_view.apply {
                adapter = ListAdapter(collection.reversed())
                layoutManager = LinearLayoutManager(context)
            }
        }
        BackMain()
    }

    fun BackMain() {
        button_back.setOnClickListener{
            val activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)
        }
    }

    fun getList(): List<ModelTableware> {

        val list: ArrayList<ModelTableware> = ArrayList()

        val dbHandler = BaseHelper(this, null)
        val cursor = dbHandler.getAll()

        if(cursor!!.moveToFirst()) {
            val product = cursor.getString(cursor.getColumnIndex(BaseHelper.Product))
            val shop = cursor.getString(cursor.getColumnIndex(BaseHelper.Shop))
            list.add(ModelTableware(
                Product = product,
                Shop = shop))
        }
        else{
            return list
        }
        while (cursor.moveToNext()) {
            val product = cursor.getString(cursor.getColumnIndex(BaseHelper.Product))
            val shop = cursor.getString(cursor.getColumnIndex(BaseHelper.Shop))
            list.add(ModelTableware(
                Product = product,
                Shop = shop))
        }
        cursor.close()
        return list
    }
}
