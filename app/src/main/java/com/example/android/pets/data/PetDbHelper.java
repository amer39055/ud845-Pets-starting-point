package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;

public class PetDbHelper extends SQLiteOpenHelper {

   public final static String DATABASE_NAME="shelter.db";
   public final static int DATABASE_VERSION=1;

   //make a constructor @param context of the app
    public PetDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        //Create a string that contain SQL statement to Create the pets table
        //this statement will be passed to database to create table

        String SQL_CREATE_PETS_TABLE="CREATE TABLE "+ PetEntry.TABLE_NAME +" ("
                +PetEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +PetEntry.COLUMN_PET_NAME+" TEXT NOT NULL, "
                +PetEntry.COLUMN_PET_BREED+" TEXT,"
                +PetEntry.COLUMN_PET_GENDER+" INTEGER NOT NULL, "
                +PetEntry.COLUMN_PET_WEIGHT+" INTRGRT NOT NULL DEFAULT 0);";

        // execute SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);

    }
   @Override
    public void onUpgrade(SQLiteDatabase db,int oldVirsion, int newVirsion){
        //nothing TO DO now
    }
}
