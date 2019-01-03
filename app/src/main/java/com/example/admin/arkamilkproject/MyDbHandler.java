package com.example.admin.arkamilkproject;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.arkamilkproject.model.Products;

public class MyDbHandler  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static int trww=6;
    String query;
    private static final String DATABASE_NAME = "productD" +
            ".db";
    public static final String TABLE_PRODUCTS = "productse";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTCATAGIRYID = "productcatagiryid";
    public static final String COLUMN_PRODUCTNAMENAME = "productname";
    public static final String COLUMN_PRODUCTNAMEIMAGE = "Productimage";
    public static final String COLUMN_PRODUCTNAMESTATUS = "category_status";

    public MyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =    "CREATE TABLE " + TABLE_PRODUCTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_PRODUCTCATAGIRYID + " TEXT," + COLUMN_PRODUCTNAMENAME + " TEXT," + COLUMN_PRODUCTNAMEIMAGE + " TEXT,"
                + COLUMN_PRODUCTNAMESTATUS + " TEXT" + ")";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DELETE FROM  " + TABLE_PRODUCTS);

    }

    public void addProduct(Products product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTCATAGIRYID, product.getProductcatagiryid());
        values.put(COLUMN_PRODUCTNAMENAME, product.getProductname());
        values.put(COLUMN_PRODUCTNAMEIMAGE, product.getProductimage());
        values.put(COLUMN_PRODUCTNAMESTATUS, product.getCategory_status());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    public String databaseToStringTwo(int a){
        String dbString="";
        SQLiteDatabase db = getWritableDatabase();
        query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE _id="+ a;

        Cursor recordSet = db.rawQuery(query, null);

        //Move to the first row in your results
        recordSet.moveToFirst();

        /*  while (!recordSet.isAfterLast()) {*/

        if (recordSet.getString(recordSet.getColumnIndex("productname")) != null) {

            dbString += recordSet.getString(recordSet.getColumnIndex("productcatagiryid"));
        }
        recordSet.moveToNext();
        recordSet.getCount();
        /*}*/

        //db.close();
        return dbString;
    }

}
