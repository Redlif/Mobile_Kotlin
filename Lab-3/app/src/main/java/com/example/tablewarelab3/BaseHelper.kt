package com.example.tablewarelab3

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseHelper(context: Context?, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = ("CREATE TABLE " +
                TABLE_NAME + "("
                + Id + " INTEGER PRIMARY KEY,"
                + Product + " TEXT,"
                + Shop + " TEXT" + ")")
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun getAll(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    fun dropData() {
        val db = this.writableDatabase;
        db.delete(TABLE_NAME, null, null);
    }

    fun addInformation(tableware: ModelTableware) {
        val values = ContentValues()
        values.put(Product, tableware.Product)
        values.put(Shop, tableware.Shop)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "Tableware2.db"
        val TABLE_NAME = "Lab3"
        val Id = "_id"
        val Product = "TypeProduct"
        val Shop = "NameShop"
    }
}